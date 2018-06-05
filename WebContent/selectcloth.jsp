<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.SelectBean" scope="request" />
<%@ page import="domain.ColorEnum" %>
<%@ page import="domain.PatternEnum" %>
<%@ page import="domain.CategoryEnum" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>２Dモデルの画面</title>

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

<div class="relative">
<img src="./images/白.png" width="60" height="70"/>
<img src="./images/ochi's.png" class="absolute"width="60" height="70"/>
</div>

<div class="relative">
<img src="./images/黒.png" width="75" height="85"/>
<img src="./images/Tシャツ.png"class="absolute"width="75" height="85"/>
</div>

<div class="relative">
<img src="./images/水玉.png" width="75" height="85"/>
<img src="./images/半ズボン.png"class="absolute"width="75" height="85"/>
</div>
<select name ="test">
<%for(ColorEnum ce :bean.getColorlist()){ %>
<% out.print("<option value=");
out.print(ce);
out.print(">");
out.print(ce);
out.println("</option>");%>
<%} %>
</select>
<select name ="test">
<%for(PatternEnum pe:bean.getPatternlist()){ %>
<% out.print("<option value=");
out.print(pe);
out.print(">");
out.print(pe);
out.println("</option>");%>
<%} %>
</select>
<select name ="test">
<%for(CategoryEnum cae:bean.getCategorylist()){ %>
<% out.print("<option value=");
out.print(cae);
out.print(">");
out.print(cae);
out.println("</option>");%>
<%} %>
</select>
コーディネイト画面

<form  method="POST" action="ListOutRecomClothServlet">

 <input type="submit" value="ホーム画面へ">
</form>
<form  method="POST" action="ListOutUserClotheServlet">
 <input type="submit" value="所有服一覧へ">
</form>

</body>
</html>