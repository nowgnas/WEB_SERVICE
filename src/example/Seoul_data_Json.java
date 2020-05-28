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
import java.util.Arrays;


//서울시 우리마을가게 상권분석서비스(상권배후지-직장인구)
//http://data.seoul.go.kr/dataList/OA-15570/S/1/datasetView.do;jsessionid=68B960D4637D1C546FAA6C39EB9C32A7.new_portal-svr-11

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
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String gil = request.getParameter("gil");
        String guname = request.getParameter("Guselect");

        HttpSession session = request.getSession();


        PrintWriter out = response.getWriter();

        int page = 1;    // 페이지 초기값
        try {
            while (true) {
                // parsing할 url 지정(API 키 포함해서)
                //직장인구
                String url = "http://openapi.seoul.go.kr:8088/756b6652796c656f38345a6a667866/xml/Vwsm_TrdhlWrcPopltnQq/1/1000/2020";
                //상권 영역
                String url2 = "http://openapi.seoul.go.kr:8088/725646724b6c656f313035735a4c5445/xml/TbgisTrdarRelm/1/1000/";

                DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
                Document doc = dBuilder.parse(url);
                Document doc2 = dBuilder.parse(url2);


                // root tag
                doc.getDocumentElement().normalize();
                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                // root tag
                doc2.getDocumentElement().normalize();
                System.out.println("Root element :" + doc2.getDocumentElement().getNodeName());

                // 파싱할 tag
                NodeList nList = doc.getElementsByTagName("row");
                System.out.println("파싱할 리스트 수 : " + nList.getLength());

                // 파싱할 tag
                NodeList nList2 = doc2.getElementsByTagName("row");
                System.out.println("파싱할 리스트 수 : " + nList2.getLength());

                /*구 정보 배열 리스트*/
                ArrayList<Guinfo> guinfos = new ArrayList<>();


                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    Node nNode2 = nList2.item(temp);
                    /*상권 영역*/
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode2;

                        String cdname = getTagValue("TRDAR_CD_NM", eElement);
                        String sigungu = getTagValue("SIGNGU_CD", eElement);

                        /*Guinfo class 생성*/
                        Guinfo name = new Guinfo(cdname);
                        guinfos.add(name);

                        Guinfo findcode = null;
                        for (Guinfo g : guinfos) {
                            if (g.equals(guname)) {
                                findcode = g;
                                break;
                            }
                        }
                        System.out.println(Arrays.toString(guinfos.toArray()));
                        System.out.println(findcode);
                        /*Guinfo*/

                        /*if문에서 2개만 나옴*/
                        if (sigungu.equals(guname)) {
                            request.setAttribute("cdname", cdname);

                            ServletContext app = this.getServletContext();
                            RequestDispatcher dispatcher = app.getRequestDispatcher("/index.jsp");

                            try {
                                dispatcher.forward(request, response);
                            } catch (ServletException e) {
                                out.println(e);
                            }
                        }
                    }    // for end


                    /*직장인구*/
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        String year = getTagValue("STDR_YY_CD", eElement);
                        String bungi = getTagValue("STDR_QU_CD", eElement);
                        String trdarcode = getTagValue("TRDAR_SE_CD", eElement);
                        String tadarnm = getTagValue("TRDAR_CD_NM", eElement);
                        String code = getTagValue("TRDAR_CD", eElement);


                        //out.println(eElement.getTextContent());
                        if (tadarnm.equals(gil)) {
                            request.setAttribute("year", year);
                            request.setAttribute("bungi", bungi);
                            request.setAttribute("trdarcode", trdarcode);
                            request.setAttribute("gil", tadarnm);
                            request.setAttribute("code", code);

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

