package example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Jsonparsing {
    public static void main(String[] args) {

        try {
            JSONParser jsonParse = new JSONParser();

            //JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다.
            JSONObject jsonObj = (JSONObject) jsonParse.parse(new FileReader("D:\\WEBAPP\\webapps\\WEB_SERVICE1\\src\\example\\jigjangingu.json"));

            //JSONObject에서 PersonsArray를 get하여 JSONArray에 저장한다.
            JSONArray personArray = (JSONArray) jsonObj.get("DATA");
            for (int i = 0; i < 5; i++) {
                System.out.println("======== DATA : " + i + " ========");
                JSONObject personObject = (JSONObject) personArray.get(i);
                System.out.println(personObject.get("trdar_cd_nm"));
                System.out.println(personObject.get("stdr_yy_cd"));
                System.out.println("상권 코드명: " + personObject.get("trdar_cd"));

            }

        } catch (ParseException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
