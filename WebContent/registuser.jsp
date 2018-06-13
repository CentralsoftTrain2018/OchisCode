<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="domain.SizeEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
</head>
<body>
  <form method="POST" action="RegistUserServlet">
    登録情報を入力してください。<br> <br>
    <table>
      <tr>
        <td>ユーザーID</td>
        <td><input name="id" type="text"></td>
      </tr>
      <tr>
        <td>パスワード(半角英数字)</td>
        <td><input name="password" type="password"></td>
      </tr>
      <tr>
        <td>身長(半角数字)</td>
        <td><input name="userheight" type="text"></td>
      </tr>
      <tr>
        <td>服のサイズ</td>
        <td><select name="size">
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
        <td><input name="budget" type="text"></td>
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