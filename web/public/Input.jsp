<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<%@ page import="java.io.FileNotFoundException" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: leo50
  Date: 2020-05-19
  Time: 오후 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String gu = request.getParameter("gu");
    String dong = request.getParameter("dong");
    String gender = request.getParameter("gender");

    try {
        JSONParser jsonParse = new JSONParser();

        //JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다.
        JSONObject jsonObj = (JSONObject) jsonParse.parse(new FileReader("D:\\WEBAPP\\webapps\\WEB_SERVICE1\\src\\example\\jigjangingu.json"));

        //JSONObject에서 PersonsArray를 get하여 JSONArray에 저장한다.
        JSONArray personArray = (JSONArray) jsonObj.get("DATA");
        for (int i = 0; i < 5; i++) {
            System.out.println("======== person : " + i + " ========");
            JSONObject personObject = (JSONObject) personArray.get(i);
            System.out.println(personObject.get("trdar_cd_nm"));
            System.out.println(personObject.get("stdr_yy_cd"));
            System.out.println("상권 코드명: " + personObject.get("TRDAR_CD"));
        }

    } catch (ParseException | FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
%>
<html>
<head>
</head>

<body>

<h1>User information</h1>
<div>first name: <%=gu%>
</div>
<br>
<div>last name: <%=dong%>
</div>
<br>
<div>gender: <%=gender%>
</div>
<br>
</body>
</html>
