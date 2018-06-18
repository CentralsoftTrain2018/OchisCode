<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー情報</title>
</head>
<body>
  <!-- ユーザー情報表示 -->
  <table>
    <tr>
      <td>ユーザーID：</td>
      <td>
        <%
          //beanの情報=
        %>
      </td>
    </tr>
    <tr>
      <td>身長：</td>
      <td>
        <%
          //beanの情報=
        %>
      </td>
    </tr>
    <tr>

      <td>服のサイズ：</td>
      <td>
        <%
          //beanの情報=
        %>
      </td>
    </tr>
    <tr>
      <td>予算：</td>
      <td>
        <%
          //beanの情報=
        %>
      </td>
    </tr>
    <tr>
      <td>性別：</td>
      <td>
        <%
          //beanの情報=
        %>
      </td>
    </tr>
  </table>
  <!-- 登録情報変更ボタン -->
    <form method="POST" action="registuser.jsp">
      <input type="submit" value="ユーザー情報変更">
    </form>
</body>
</html>