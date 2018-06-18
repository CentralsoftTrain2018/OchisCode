<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="domain.SizeEnum"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
  <form method="POST" action="RegistUserServlet">
    登録情報を入力してください <br>
    <table>
      <tr>
        <td>ユーザーID(半角英数字4文字以上)</td>
        <td><input name="userid" type="text" required="required" pattern="^([a-zA-Z0-9]{4,})$"></td>
      </tr>
      <tr>
        <td>パスワード(半角英数字8文字以上)</td>
        <td><input name="password" type="password" required="required" pattern="{8,}"></td>
      </tr>
      <tr>
        <td>身長(半角数字)</td>
        <td><input name="userheight" type="number" required="required"></td>
      </tr>
      <tr>
        <td>服のサイズ</td>
        <td><select name="size" required="required">
            <%
              for (SizeEnum se : SizeEnum.values())
              {
            %>
            <option value="<%=se.name()%>"><%=se%></option>
            <%
              }
            %>
        </select></td>
      </tr>
      <tr>
        <td>予算(半角数字)</td>
        <td><input name="budget" type="number" required="required"></td>
      </tr>
      <tr>
        <td>性別</td>
        <td><input name="sex" type="radio" checked="checked" value="男">男<input
          name="sex" type="radio" value="女">女</td>
      </tr>
    </table>
    <input type="submit" value="登録">
  </form>
</body>
</html>