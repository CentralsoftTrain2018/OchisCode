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

<link rel="stylesheet" type="text/css" href="css/BackGround.css">

<body>
持ち服登録

プルダウンで持っている服の色、柄、カテゴリ、サイズを選んでください。
<form  method="POST" action="RegistUserClothServlet">
<!-- 色プルダウン -->
<select name ="color">
<%for(ColorEnum ce :ColorEnum.values()){ %>
<option value="<%=ce.name() %>">
<%= ce.name()%>
</option>
<%} %>
</select>

<!-- 柄プルダウン -->
<select name ="pattern">
<%for(PatternEnum pe:PatternEnum.values()){ %>
<option value="<%=pe.name() %>">
<%=pe %>
</option>
<%} %>
</select>

<!-- カテゴリープルダウン -->
<select name ="category">
<%for(CategoryEnum cae:CategoryEnum.values()){ %>
<option value="<%=cae.name() %>">
<%=cae %>
</option>
<%} %>
</select>

<!-- サイズプルダウン -->
<select name ="size">
<%for(SizeEnum se:SizeEnum.values()){ %>
<option value="<%=se.name() %>"><%=se %></option>
<%} %>
</select>
 <input type="submit" value="登録">
</form>
</body>
</html>