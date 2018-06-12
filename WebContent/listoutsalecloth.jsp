<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.ClothBean" scope="request" />
<%@ page import="java.lang.String"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>おすすめ画面</title>
</head>

<!-- cssファイル読み込み -->
<link rel="stylesheet" type="text/css" href="css/PileImage.css">
<link rel="stylesheet" type="text/css" href="css/Header.css">
<link rel="stylesheet" type="text/css" href="css/TwoColumn.css">
<body>
  <div class="container">
    <div class="header">
      ホーム画面
      <form method="POST" action="CoordinateClothServlet">
        <input type="submit" value="コーデ画面へ">
      </form>
      <form method="POST" action="ListOutUserClotheServlet">
        <input type="submit" value="所有服一覧へ">
      </form>
    </div>
    <div class="verticalContainer">
      <!-- 左側モデル表示部分 -->
      <div class="model"></div>

      <!-- 右側プルダウン、画像表示部分 -->
      <div class="contents">
        <!-- プルダウン、ボタン -->
        <form method="POST" action="SelectedRecomClothServlet">
          <select name="usercloth">
            <%
              for (bean.UserClothLineBean str : bean.getUsercloth().getList())
              {
            %>
            <option value="<%=str.getClothid()%>"><%=str%></option>
            <%
              }
            %>
          </select> <select name="narrow">
            <option value="テスト">絞込み</option>
          </select> <input type="submit" value="オススメ服表示">
        </form>
        <br>
        <%
          for (bean.LineRecomClothBean record : bean.getRecomcloth().getList())
          {
        %>
        <div class="item">
          <div class="relative">
            <img src="./images/<%=record.getColor().name()%>.png" width=175
              height=147 /> <img
              src="./images/<%=record.getPattern().name()%>.png" width=175
              height=147 class=absolute /> <img
              src="./images/<%=record.getCategory().name()%>.png" width=175
              height=147 class=absolute />
          </div>
        </div>
        <%
          }
        %>

      </div>
    </div>
  </div>
</body>

</html>