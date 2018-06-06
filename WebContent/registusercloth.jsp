<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.ColorEnum" %>
<%@ page import="domain.PatternEnum" %>
<%@ page import="domain.CategoryEnum" %>
<%@ page import="domain.SizeEnum" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>持ち服登録</title>
</head>
<body>
<!-- 色プルダウン -->
<select name ="color">
<%for(ColorEnum ce :ColorEnum.values()){ %>
<% out.print("<option value=");
out.print(ce);
out.print(">");
out.print(ce);
out.println("</option>");%>
<%} %>
</select>

<!-- 柄プルダウン -->
<select name ="pattern">
<%for(PatternEnum pe:PatternEnum.values()){ %>
<% out.print("<option value=");
out.print(pe);
out.print(">");
out.print(pe);
out.println("</option>");%>
<%} %>
</select>

<!-- カテゴリープルダウン -->
<select name ="category">
<%for(CategoryEnum cae:CategoryEnum.values()){ %>
<% out.print("<option value=");
out.print(cae);
out.print(">");
out.print(cae);
out.println("</option>");%>
<%} %>
</select>
<!-- サイズプルダウン -->
<select name ="size">
<%for(SizeEnum se:SizeEnum.values()){ %>
<% out.print("<option value=");
out.print(se);
out.print(">");
out.print(se);
out.println("</option>");%>
<%} %>
</select>
<form  method="POST" action="RegistUserClothServlet">
 <input type="submit" value="登録">
</form>
</body>
</html>