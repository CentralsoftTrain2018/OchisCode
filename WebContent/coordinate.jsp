<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.CoordinateBean" scope="request" />
<%@ page import="java.lang.String"%>
<%@ page import="domain.ColorEnum"%>
<%@ page import="domain.PatternEnum"%>
<%@ page import="domain.CategoryEnum"%>
<%@ page import="domain.SizeEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>コーデ画面</title>

<!-- 上下服のプルダウンの値を変更 編集:功刀 -->

</head>
<!-- cssファイル読み込み -->
<link rel="stylesheet" type="text/css" href="css/PileImage.css">
<link rel="stylesheet" type="text/css" href="css/Header.css">
<link rel="stylesheet" type="text/css" href="css/TwoColumn.css">

<body>
  <div class="container">
    コーディネイト画面
    <div class="header">
      <!-- 画面遷移ボタン -->
      <form method="POST" action="ListOutSaleClothServlet">
        <input type="submit" value="おすすめ画面へ">
      </form>
      <form method="POST" action="ListOutUserClotheServlet">
        <input type="submit" value="所有服一覧へ">
      </form>
    </div>

    <div class="verticalContainer">
      <div class="model">
        <!-- 画像表示部分 -->
        <!-- 越智くんの顔 -->
        <div class="relative">
          <img src="./images/白.png" width="178" height="218" /> <img
            src="./images/ochi's.png" class="absolute" width="178"
            height="218" />
        </div>


        <!-- 上 -->
        <div class="relative">
          <img src="./images/<%=bean.getTopColor().name()%>.png"
            width="<%=bean.getTopSize().getWidth()%>"
            height="<%=bean.getTopSize().getHeight()%>" /> <img
            src="./images/<%=bean.getTopPattern().name()%>.png"
            class="absolute" width="<%=bean.getTopSize().getWidth()%>"
            height="<%=bean.getTopSize().getHeight()%>" /> <img
            src="./images/<%=bean.getTopCategory().name()%>.png"
            class="absolute" width="<%=bean.getTopSize().getWidth()%>"
            height="<%=bean.getTopSize().getHeight()%>" />
        </div>


        <!-- 下 -->
        <div class="relative">
          <img src="./images/<%=bean.getBottomColor().name()%>.png"
            width="<%=bean.getBottomSize().getWidth()%>"
            height="<%=bean.getBottomSize().getHeight()%>" /> <img
            src="./images/<%=bean.getBottomPattern().name()%>.png"
            class="absolute" width="<%=bean.getBottomSize().getWidth()%>"
            height="<%=bean.getBottomSize().getHeight()%>" /> <img
            src="./images/<%=bean.getBottomCategory().name()%>.png"
            class="absolute" width="<%=bean.getBottomSize().getWidth()%>"
            height="<%=bean.getBottomSize().getHeight()%>" />
        </div>
      </div>
      <div class="contents">
        <!-- 変更する服の情報を入力 -->
        <form method="POST" action=ChangeCoordinateClothServlet>
          <!-- 色プルダウン -->
          <select name="color">
            <%
              for (ColorEnum ce : ColorEnum.values())
              {
            %>
            <option value="<%=ce.name()%>">
              <%= ce.name()%>
            </option>
            <%
              }
            %>
          </select>

          <!-- 柄プルダウン -->
          <select name="pattern">
            <%
              for (PatternEnum pe : PatternEnum.values())
              {
            %>
            <option value="<%=pe.name()%>">
              <%=pe%>
            </option>
            <%
              }
            %>
          </select>

          <!-- カテゴリープルダウン -->
          <select name="category">
            <%
              for (CategoryEnum cae : CategoryEnum.values())
              {
            %>
            <option value="<%=cae.name()%>">
              <%=cae%>
            </option>
            <%
              }
            %>
          </select>

          <!-- サイズプルダウン -->
          <select name="size">
            <%
              for (SizeEnum se : SizeEnum.values())
              {
            %>
            <option value="<%=se.name()%>"><%=se%></option>
            <%
              }
            %>
          </select>

          <!-- 表示している服の情報をサーブレットに受け渡し -->
          <input type="hidden" name="topcolor"
            value="<%=bean.getTopColor().name()%>"> <input
            type="hidden" name="toppattern"
            value="<%=bean.getTopPattern().name()%>"> <input
            type="hidden" name="topcategory"
            value="<%= bean.getTopCategory().name()%>"> <input
            type="hidden" name="topsize"
            value="<%= bean.getTopSize().name()%>"> <input
            type="hidden" name="bottomcolor"
            value="<%=bean.getBottomColor().name()%>"> <input
            type="hidden" name="bottompattern"
            value="<%=bean.getBottomPattern().name()%>"> <input
            type="hidden" name="bottomcategory"
            value="<%= bean.getBottomCategory().name()%>"> <input
            type="hidden" name="bottomsize"
            value="<%= bean.getBottomSize().name()%>"> <input
            type="submit" value="変更">
        </form>
        <br>

        <form method="POST" action="ChangeUserSaleClothServlet">
          <!-- 持ち服を上下に分けたプルダウン -->
          <select name="topcloth">
            <%
              for (bean.UserClothBean topcloth : bean.getUscbean().getTopclothlist())
              {
            %>
            <option
              value="<%=topcloth.getColor().name()%>-<%=topcloth.getPattern().name()%>-<%=topcloth.getCategory().name()%>-<%=topcloth.getSize().name()%>"><%=topcloth%></option>
            <%
              }
            %>
          </select> <select name="bottomcloth">


            <%
              for (bean.UserClothBean bottomcloth : bean.getUscbean().getBottomclothlist())
              {
            %><option
            value="<%=bottomcloth.getColor().name()%>-<%=bottomcloth.getPattern().name()%>-<%=bottomcloth.getCategory().name()%>-<%=bottomcloth.getSize().name()%>"><%=bottomcloth%></option>

            <%
              }
            %>
          </select> <br> <input type="hidden" name="topcolor"
            value="<%=bean.getTopColor().name()%>"> <input
            type="hidden" name="toppattern"
            value="<%=bean.getTopPattern().name()%>"> <input
            type="hidden" name="topcategory"
            value="<%= bean.getTopCategory().name()%>"> <input
            type="hidden" name="topsize"
            value="<%= bean.getTopSize().name()%>"> <input
            type="hidden" name="bottomcolor"
            value="<%=bean.getBottomColor().name()%>"> <input
            type="hidden" name="bottompattern"
            value="<%=bean.getBottomPattern().name()%>"> <input
            type="hidden" name="bottomcategory"
            value="<%= bean.getBottomCategory().name()%>"> <input
            type="hidden" name="bottomsize"
            value="<%= bean.getBottomSize().name()%>"> <input
            type="submit" value="変更">
        </form>
      </div>
    </div>
  </div>
</body>
</html>