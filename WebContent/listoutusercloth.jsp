<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.UserClothLineBean" %>
<jsp:useBean id="bean" class="bean.ListOutUserClothBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有服　一覧</title>
</head>
<style>
.relative {
    position: relative;
}
<%-- absolute内のleftとtopは画像の位置を設定した --%>
.absolute {
    position: absolute;
    left: 220px;
    top: -80px;
}
</style>
<body>

所有服一覧
<form method="POST" action="CoordinateClothServlet">
 <input type="submit" value="コーデ画面へ">
</form>
<form method="POST" action="ListOutRecomClothServlet">
 <input type="submit" value="おすすめ画面へ">
</form>

<br><br>
<%for(UserClothLineBean record : bean.getList()) {%>
<% out.println("<td>");%>
<%=record.toString() %>
<br><br>
<br><br>
<% out.println("</td>");%>
<% out.println("<td>");%>
<% out.println("<div class="+"relative"+">");%>
<%String color = record.getColor().name();%>
<%String cate = record.getCategory().name();%>
<%String pat = record.getPattern().name();%>
<% out.println("<img src=./images/"+ color +".png width=50 height=50/ class=absolute>");%>
<% out.println("<img src=./images/"+ pat +".png width=50 height=50/ class=absolute>");%>
<% out.println("<img src=./images/"+ cate +".png width=50 height=50/ class=absolute>");%>
<%out.println("</div>");%>
<%out.println("</td>"); %>
<%} %>

<form method="POST" action="registusercloth.jsp">
 <input type="submit" value="持ち服登録画面へ">
</form>

<br>
</body>

</html>