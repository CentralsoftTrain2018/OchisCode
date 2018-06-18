<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="domain.SizeEnum"%>
<jsp:useBean id="bean" class="bean.UserInfoBean" scope="request" />
<head>
<meta charset="UTF-8">
<title>登録情報変更</title>
</head>
<body>
  変更する値を入力してください。
  <form method="POST" action="">
    <table>
      <tr>
        <td>項目</td>
        <td>変更前</td>
        <td>変更後</td>
      </tr>
      <tr>
        <td>ユーザーID：</td>
        <td><%=bean.getUserid()%></td>
      </tr>
      <tr>
        <td>身長：</td>
        <td><%=bean.getUserheight()%></td>
        <td><input name="userheight" type="number" required="required"></td>
      </tr>
      <tr>
        <td>服のサイズ：</td>
        <td><%=bean.getSize().name()%></td>
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
        <td>予算：</td>
        <td><%=bean.getBudget()%></td>
        <td><input name="budget" type="number" required="required"></td>
      </tr>
      <tr>
        <td>性別：</td>
        <td><%=bean.getSex().name()%></td>
        <td><input name="sex" type="radio" checked="checked" value="男">男<input
          name="sex" type="radio" value="女">女</td>
      </tr>
    </table>
    <input type="submit" value="登録情報変更">
  </form>

</body>
</html>