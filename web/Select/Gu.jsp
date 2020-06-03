<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%
    request.setCharacterEncoding("utf-8");
    ArrayList<String> name = (ArrayList<String>) session.getAttribute("cdname");

    int size = 1000;
    String[] st = new String[size];

    if (name != null) {
        for (int i = 0; i < size; i++) {
            st[i] = name.get(i);
            if (name.size() == i + 1) {
                size = i + 1;
                break;
            }
        }
    } else {
        System.out.println("null?");
    }
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="public/build/tailwind.css">
</head>
<body>
<%--지도 --%>
<%--구 도로명 선택 --%>

<form class="flex bg-purple-100 w-3/6" action="RQ" method="post" name="Guselect">
    <div class="flex-1 w-1/5">
        <p>구 선택</p>
        <select class="rounded-lg border-solid border-2" name="Guselect" onchange="this.form.submit()">
            <option>구 선택</option>
            <option value="11110">종로구</option>
            <option value="11140">중구</option>
            <option value="11170">용산구</option>
            <option value="11200">성동구</option>
            <option value="11230">동대문구</option>
            <option value="11620">관악구</option>
            <option value="11680">강남구</option>
            <option value="11500">강서구</option>
            <option value="11545">금천구</option>
            <option value="11380">은평구</option>
            <option value="11710">송파구</option>
            <option value="11590">동작구</option>
            <option value="11560">영등포구</option>
            <option value="11530">구로구</option>
            <option value="11470">양천구</option>
            <option value="11650">서초구</option>
            <option value="11305">강북구</option>
            <option value="11320">도봉구</option>
            <option value="11290">성북구</option>
            <option value="11215">광진구</option>
            <option value="11260">중랑구</option>
            <option value="11440">마포구</option>
            <option value="11740">강동구</option>
            <option value="11410">서대문구</option>
            <option value="11350">노원구</option>
        </select>
    </div>
    <div class="flex-1 w-4/5">
        <p>도로명 선택</p>
        <input class="border-solid border-2 rounded-lg" list="gil" name="gil">
        <datalist id="gil">
            <%
                for (int i = 0; i < size; i++) {
            %>
            <option><%=st[i]%>
            </option>

            <%
                }
            %>
        </datalist>
    </div>
    <input type="submit" value="전송" name="submitbtn">
</form>
</body>
</html>