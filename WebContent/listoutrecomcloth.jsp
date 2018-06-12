<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.ClothBean" scope="request" />
<%@ page import="java.lang.String" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>おすすめ画面</title>
</head>

<style>
.relative {
    position: relative;
}
.absolute {
    position: absolute;
    left: 0px;
    top: 0px;
}
</style>

<body>

ホーム画面
<form  method="POST" action="CoordinateClothServlet">
 <input type="submit" value="コーデ画面へ">
</form>
<form  method="POST" action="ListOutUserClotheServlet">
 <input type="submit" value="所有服一覧へ">
</form>

<br>

<form  method="POST" action="SelectedRecomClothServlet">
<select name ="usercloth">

<!-- Beanが複数使用されていたためコメントアウト -->
<%for( bean.UserClothLineBean str : bean.getUsercloth().getList()){ %>
<% out.print("<option value=");
out.print(str.getClothid());
out.print(">");
out.print(str);
out.println("</option>");%>
<%} %>
<!-- コメントアウトここまで -->

</select>

<select name ="narrow">
<% out.print("<option value=");
out.print("テスト");
out.print(">");
out.print("絞込み");
out.println("</option>");%>
</select>
<input type="submit" value="オススメ服表示">
</form>

<br>
<br>

<!--  -->
<table>
<tr>
<%int i=0;%>
<%for( bean.LineRecomClothBean record:bean.getRecomcloth().getList() ){
  out.println("<td>");
  out.println("<div class="+"relative"+">");%>
  <%String color = record.getColor().name();%>
  <%String cate = record.getCategory().name();%>
  <%String pat = record.getPattern().name();%>
<% out.println("<img src=./images/"+ color +".png width=175 height=147/>");%>
<% out.println("<img src=./images/"+ pat +".png width=175 height=147/ class=absolute>");%>
<% out.println("<img src=./images/"+ cate +".png width=175 height=147/ class=absolute>");%>
<%out.println("</div>");%>
<%out.println("</td>"); %>
<%i++; %>
  <%if(i%3==2)
  {
  out.println("</tr> <tr>");
  }%>
<%} %>
</tr>
</table>


</body>

</html>