package example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


//서울시 우리마을가게 상권분석서비스(상권배후지-직장인구)
//인증키: 756b6652796c656f38345a6a667866
//http://data.seoul.go.kr/dataList/OA-15570/S/1/datasetView.do;jsessionid=68B960D4637D1C546FAA6C39EB9C32A7.new_portal-svr-11

//상권 영역
// 인증키: 725646724b6c656f313035735a4c5445
//http://data.seoul.go.kr/dataList/OA-15560/S/1/datasetView.do

//상주인구
//http://data.seoul.go.kr/dataList/OA-15583/S/1/datasetView.do
//인증키: 647a4445666c656f3930776573416f

@WebServlet("/RQ")
public class Seoul_data_Json extends HttpServlet {
    private static String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Gu.jsp에서 전송한 값들을 받아온다.*/
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        /*도로명 선택 값 받아오기*/
        String gil = request.getParameter("gil");
        /*구 선택한 값 받아오기*/
        String guname = request.getParameter("Guselect");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        int page = 1;    // 페이지 초기값
        try {
            while (true) {
                // parsing할 url 지정(API 키 포함해서)
                //직장인구
                String url = "http://openapi.seoul.go.kr:8088/756b6652796c656f38345a6a667866/xml/Vwsm_TrdhlWrcPopltnQq/1/1000/2020";
                //상권 영역
                String url2 = "http://openapi.seoul.go.kr:8088/725646724b6c656f313035735a4c5445/xml/TbgisTrdarRelm/1/1000/";
                /*유동인구*/
                String url3 = "http://openapi.seoul.go.kr:8088/647a4445666c656f3930776573416f/xml/VwsmTrdhlRepopQq/1/1000/";

                DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();

                Document doc = dBuilder.parse(url);
                Document doc2 = dBuilder.parse(url2);
                Document doc3 = dBuilder.parse(url3);


                // root tag
                doc.getDocumentElement().normalize();
                // root tag
                doc2.getDocumentElement().normalize();
                // root tag
                doc3.getDocumentElement().normalize();

                // 파싱할 tag
                NodeList nList = doc.getElementsByTagName("row");
                // 파싱할 tag
                NodeList nList2 = doc2.getElementsByTagName("row");
                // 파싱할 tag
                NodeList nList3 = doc3.getElementsByTagName("row");

                ArrayList<String> arr = new ArrayList<String>();
                int num = 0;
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    Node nNode2 = nList2.item(temp);
                    Node nNode3 = nList3.item(temp);

                    /*상권 영역*/
                    /**/
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode2;

                        String cdname = getTagValue("TRDAR_CD_NM", eElement);
                        String sigungu = getTagValue("SIGNGU_CD", eElement);

                        /*넘어온 구 코드와 시군구 코드가 같으면*/
                        if (sigungu.equals(guname)) {
                            /*"길"을 포함하는 도로명 출력*/
                            if (cdname.contains("길")) {
                                num++;
                                arr.add(cdname);
                            }
                        }
                    }    // for end

                    /*직장인구*/
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;
                        Element eElement3 = (Element) nNode3;

                        /*도로명*/
                        String tadarnm = getTagValue("TRDAR_CD_NM", eElement);
                        /*남여 직장인구*/
                        String man = getTagValue("ML_WRC_POPLTN_CO", eElement);
                        String women = getTagValue("FML_WRC_POPLTN_CO", eElement);
                        /*남여 상주인구*/
                        String manlive = getTagValue("ML_REPOP_CO", eElement3);
                        String womenlive = getTagValue("FML_REPOP_CO", eElement3);


                        /*받아온 도로명과 일치하는 정보*/
                        if (tadarnm.equals(gil)) {
                            request.setAttribute("gil", tadarnm);
                            request.setAttribute("man", man);
                            request.setAttribute("women", women);

                            session.setAttribute("manlive", manlive);
                            session.setAttribute("womenlive", womenlive);

                            ServletContext app = this.getServletContext();
                            RequestDispatcher dispatcher = app.getRequestDispatcher("/index.jsp");

                            try {
                                dispatcher.forward(request, response);
                            } catch (ServletException e) {
                                out.println(e);
                            }
                        }
                    }    // for end
                }    // if end

                /*받아온 구 정보와 일치하는 도로명 리스트*/
                session.setAttribute("cdname", arr);

                ServletContext app = this.getServletContext();
                RequestDispatcher dispatcher = app.getRequestDispatcher("/index.jsp");

                try {
                    dispatcher.forward(request, response);
                } catch (ServletException e) {
                    out.println(e);
                }

                page += 1;
                if (page > 1) {
                    break;
                }
            }    // while end

        } catch (Exception e) {
            e.printStackTrace();
        }    // try~catch end
    }    // main end


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}

