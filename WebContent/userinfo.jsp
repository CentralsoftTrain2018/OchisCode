<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="bean" class="bean.UserInfoBean" scope="request" />
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
      <td><%=bean.getUserid()%></td>
    </tr>
    <tr>
      <td>身長：</td>
      <td>
        <%=bean.getUserheight(  )%>
      </td>
    </tr>
    <tr>

      <td>服のサイズ：</td>
      <td>
        <%=bean.getSize().name()%>
      </td>
    </tr>
    <tr>
      <td>予算：</td>
      <td>
        <%=bean.getBudget(  )%>
      </td>
    </tr>
    <tr>
      <td>性別：</td>
      <td>
        <%=bean.getSex(  ).name(  )%>
      </td>
    </tr>
  </table>
  <!-- 登録情報変更ボタン -->
  <form method="POST" action="UserInfoServlet">
    <input type="submit" value="ユーザー情報を変更する">
  </form>
  <!-- おすすめ表示に戻る -->
  <form method="POST" action="ListOutSaleClothServlet">
    <input type="submit" value="戻る">
  </form>
</body>
</html>