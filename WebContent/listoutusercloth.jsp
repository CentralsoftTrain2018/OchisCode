<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.UserClothBean" %>
<jsp:useBean id="bean" class="bean.ListOutUserClothBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有服　一覧</title>
</head>

<link rel="stylesheet" type="text/css" href="css/BackGround.css">
<link rel="stylesheet" type="text/css" href="css/PileImage.css">

<body>

所有服一覧
<form method="POST" action="CoordinateServlet">
 <input type="submit" value="コーデ画面へ">
</form>
<form method="POST" action="ListOutSaleClothServlet">
 <input type="submit" value="おすすめ画面へ">
</form>

<br><br>

<form method = "POST" action = "NarrowingUsrClothServlet">
  <select>
    <option value = "0">絞込み</option>
  </select>
  <input type = "submit" value = "絞込み">
</form>

<br><br>
<table border="1">
    <tbody>
      <%for(UserClothBean record : bean.getList()) {%>
      <tr>
        <td ><%=record.toString() %></td>
        <td>
          <div class = "relative">
            <img src="./images/<%=record.getColor().name()%>.png" width=50 height=50/>
            <img src="./images/<%=record.getPattern().name()%>.png" class = "absolute" width=50 height=50/>
            <img src="./images/<%=record.getCategory().name()%>.png" class = "absolute" width=50 height=50/>
          </div>
        </td>
        <td>
           <form method = "POST" action = "DeleteUserClothServlet">
             <input type = "hidden" name = "clothid" value = <%=record.getClothid()%>>
             <input type="submit" value="削除">
           </form>
        </td>
      </tr>
      <%} %>
    </tbody>
</table>

<form method="POST" action="registusercloth.jsp">
 <input type="submit" value="持ち服登録画面へ">
</form>

<br>
</body>

</html>