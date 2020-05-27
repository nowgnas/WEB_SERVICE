package example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

// 인증키: 725646724b6c656f313035735a4c5445
//http://data.seoul.go.kr/dataList/OA-15560/S/1/datasetView.do

public class Gucode {
    // tag값의 정보를 가져오는 메소드
    private static String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }

    public static void main(String[] args) {

        int page = 1;    // 페이지 초기값
        try {
            while (true) {
                // parsing할 url 지정(API 키 포함해서)
                String url = "http://openapi.seoul.go.kr:8088/725646724b6c656f313035735a4c5445/xml/TbgisTrdarRelm/1/1000/";
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

                        String cdname = getTagValue("TRDAR_CD_NM", eElement);
                        String sigungu = getTagValue("SIGNGU_CD", eElement);
                        String dongcode = getTagValue("ADSTRD_CD", eElement);


                        //out.println(eElement.getTextContent());
                        if (sigungu.equals("11620")) {
                            System.out.println("도로명: " + cdname);
                            System.out.println("시군구 코드: " + sigungu);
                            System.out.println("동 코드: " + dongcode);
                            System.out.println("---------------------");
                        }
                    }    // for end
                }    // if end


                page += 1;
                System.out.println("page number : " + page);
                if (page > 1) {
                    break;
                }
            }    // while end

        } catch (Exception e) {
            e.printStackTrace();
        }    // try~catch end
    }
}
