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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.IOException;
import java.io.PrintWriter;

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

        PrintWriter out = response.getWriter();

        int page = 1;    // 페이지 초기값
        try {
            while (true) {
                // parsing할 url 지정(API 키 포함해서)
                String url = "http://openapi.seoul.go.kr:8088/756b6652796c656f38345a6a667866/xml/Vwsm_TrdhlWrcPopltnQq/1/5/2020";

                DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
                Document doc = dBuilder.parse(url);

                // root tag
                doc.getDocumentElement().normalize();
                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                // 파싱할 tag
                NodeList nList = doc.getElementsByTagName("row");
                System.out.println("파싱할 리스트 수 : " + nList.getLength());

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
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
                out.println("page number : " + page + ", " + gil);
                if (page > 1) {
                    break;
                }
            }    // while end

        } catch (Exception e) {
            e.printStackTrace();
        }    // try~catch end

        out.println("</body></html>");
    }    // main end


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}

