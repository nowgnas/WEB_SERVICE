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
import java.util.ArrayList;

@WebServlet("/GUXML")
public class GuXML extends HttpServlet {
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
        String gubname = request.getParameter("Guselect");

        PrintWriter out = response.getWriter();

        int page = 1;    // 페이지 초기값
        try {
            while (true) {
                // parsing할 url2 지정(API 키 포함해서)
                String url2 = "http://openapi.seoul.go.kr:8088/725646724b6c656f313035735a4c5445/xml/TbgisTrdarRelm/1/1000/";
                DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
                Document doc2 = dBuilder.parse(url2);

                // root tag
                doc2.getDocumentElement().normalize();
                System.out.println("Root element :" + doc2.getDocumentElement().getNodeName());

                // 파싱할 tag
                NodeList nList2 = doc2.getElementsByTagName("row");
                System.out.println("파싱할 리스트 수 : " + nList2.getLength());

                for (int temp = 0; temp < nList2.getLength(); temp++) {
                    Node nNode2 = nList2.item(temp);
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode2;

                        String cdname = getTagValue("TRDAR_CD_NM", eElement);
                        String sigungu = getTagValue("SIGNGU_CD", eElement);


                        //out.println(eElement.getTextContent());
                        if (sigungu.equals(gubname)) {
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


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
