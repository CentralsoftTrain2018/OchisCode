<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="bean.ListOutLinkCountBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者画面</title>
</head>
<body>
テスト
<table>
<tr>
<td>色</td>
<td>柄</td>
<td>カテゴリ</td>
<td>クリック数</td>
</tr>
<%for(bean.SaleClothBean record:bean.getList(  )){ %>
<tr>
<td><%=record.getColor(  ).name() %></td>
<td><%=record.getPattern(  ).name() %></td>
<td><%=record.getCategory(  ).name() %></td>
<td><%=record.getClickcount(  ) %></td>
</tr>
<% }%>

</table>
</body>
</html>