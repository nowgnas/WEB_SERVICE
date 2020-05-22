<%@ page import="javax.lang.model.element.Element" %><%--
  Created by IntelliJ IDEA.
  User: leo50
  Date: 2020-05-21
  Time: 오후 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    request.setCharacterEncoding("utf-8");
    String gil = request.getParameter("gil");

%>
<jsp:forward page="../index.jsp">
    <jsp:param name="code" value="<%=gil%>"/>
</jsp:forward>