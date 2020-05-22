package example;

//http://data.seoul.go.kr/dataList/OA-15570/S/1/datasetView.do;jsessionid=68B960D4637D1C546FAA6C39EB9C32A7.new_portal-svr-11
//동작함

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Jsonparsing2 {
    static String key = "756b6652796c656f38345a6a667866";

    public Jsonparsing2() throws Exception {

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(readUrl());
        JSONObject json = (JSONObject) jsonObject.get("Vwsm_TrdhlWrcPopltnQq");
        JSONArray array = (JSONArray) json.get("row");


        String po = null;
        for (int i = 0; i < array.size(); i++) {
            JSONObject row = (JSONObject) array.get(i);
            String yearcode = (String) row.get("STDR_YY_CD");
            String trdanm = (String) row.get("TRDAR_CD_NM");
            String totpop = row.get("TOT_WRC_POPLTN_CO").toString();
            String TRDARCD = row.get("TRDAR_CD").toString();


            if (trdanm.equals("창경궁로35길")) {
                System.out.println(trdanm + "," + TRDARCD);
                po = trdanm;
                System.out.println(po);
            }
        }
    }

    private static String readUrl() throws Exception {
        BufferedInputStream reader = null;
        try {
            URL url = new URL("http://openapi.seoul.go.kr:8088/"
                    + key + "/json/Vwsm_TrdhlWrcPopltnQq/1/200/2020");

            reader = new BufferedInputStream(url.openStream());
            StringBuffer buffer = new StringBuffer();
            int i = 0;
            byte[] b = new byte[4096];
            while ((i = reader.read(b)) != -1) {
                buffer.append(new String(b, 0, i));
            }
            return buffer.toString();
        } finally {
            if (reader != null) reader.close();
        }
    }
}
