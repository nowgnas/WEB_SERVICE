package example;

//기본 XML파싱 코드
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//http://data.seoul.go.kr/dataList/OA-15570/S/1/datasetView.do;jsessionid=68B960D4637D1C546FAA6C39EB9C32A7.new_portal-svr-11

public class HelloWorld {
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

                        System.out.println("######################");
                        //System.out.println(eElement.getTextContent());
                        if (tadarnm.equals("창경궁로35길")) {
                            System.out.println("기준년코드  : " + year);
                            System.out.println("분기 코드  : " + bungi);
                            System.out.println("상권 구분 코드 : " + trdarcode);
                            System.out.println("상권 구분 코드 명  : " + tadarnm);
                            System.out.println("상권 구분 코드  : " + code);
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
    }    // main end
}    // class end

