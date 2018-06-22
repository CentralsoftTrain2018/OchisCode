<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.ListOutLinkCountBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
    <%
      for (bean.SaleClothBean record : bean.getList())
      {
    %>
    <tr>
      <td><%=record.getColor().name()%></td>
      <td><%=record.getPattern().name()%></td>
      <td><%=record.getCategory().name()%></td>
      <td><%=record.getClickcount()%></td>
    </tr>
    <%
      }
    %>
  </table>

  <form method="POST" action="ListOutLinkCountServlet">
    <input type="email"  name="address" placeholder="送信先メールアドレスを入力"
      required="required"
>
    <input type="submit" value="集計データを送信">
  </form>
</body>
</html>