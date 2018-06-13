<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.SaleClothDisplayBean" scope="request" />
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
      <form method="POST" action="CoordinateServlet">
        <input type="submit" value="コーデ画面へ">
      </form>
      <form method="POST" action="ListOutUserClotheServlet">
        <input type="submit" value="所有服一覧へ">
      </form>
    </div>

    <div class="verticalContainer">
      <!-- 左側モデル表示部分 -->

      <div class="model">
        <!-- 画像表示部分 -->
        <!-- 越智くんの顔 -->
        <div class="relative">
          <img src="./images/白.png" width="178" height="218" /> <img
            src="./images/ochi's.png" class="absolute" width="178"
            height="218" />
        </div>

        <div class="relative">
          <!-- 上服 -->
          <img src="./images/白.png" width="178" height="218" />
          <img src="./images/無地.png" class="absolute" width="178" height="218" /> <img
            src="./images/Tシャツ.png" class="absolute" width="178" height="218" />
        </div>

        <div class="relative">
          <!-- 下服 -->
          <img src="./images/白.png" width="178" height="218" />
          <img src="./images/水玉.png" class="absolute" width="178" height="218" /> <img
            src="./images/半ズボン.png" class="absolute" width="178" height="218" />
        </div>
      </div>

      <!-- 右側プルダウン、画像表示部分 -->
      <div class="contents">
        <div class="container">
          <div class="header">

            <!-- プルダウン、ボタン -->
            <form method="POST" action="SaleClothDisplayServlet">
              <select name="usercloth">
                <%
                  for (bean.UserClothBean str : bean.getUserCloth().getList())
                                  {

                %>
                <option value="<%=str.getClothid()%>"><%=str%></option>
                <%
                  }
                %>
              </select> <select name="narrow">
                <option value="0-5000">0-5000</option>
                <option value="5001-10000">5001-10000</option>
                <option value="10001-15000">10001-15000</option>
              </select>
              <select name="sort">
               <option value="clothid DESC">新着順</option>
               <option value="clothid ASC">古い順</option>
               <option value="price DESC">値段が高い順</option>
               <option value="price ASC">値段が安い順</option>
              </select><input type="submit" value="オススメ服表示">

            </form>
          </div>
          <div class="contents">

            <%
              for (bean.SaleClothBean record : bean.getSaleCloth().getList()){
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
              <br> <a href="<%=record.getURL()%>"><%=record.toString()%></a>
            </div>
            <%
              }
            %>

          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>