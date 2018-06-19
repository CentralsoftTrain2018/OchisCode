<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.CoordinateDisplayBean"
  scope="request" />
<%@ page import="java.lang.String"%>
<%@ page import="domain.ColorEnum"%>
<%@ page import="domain.PatternEnum"%>
<%@ page import="domain.CategoryEnum"%>
<%@ page import="domain.SizeEnum"%>
<%@ page import="domain.SexEnum"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
    function changeOchiFaceMan()
    {
        document.getElementById("ochiface").src = "./images/ochi's.png";
    }

    function changeOchiFaceWoman()
    {
      document.getElementById("ochiface").src = "./images/ochi_smile.PNG";
    }

    function changeOchiFaceSmile()
    {
      document.getElementById("ochiface").src = "./images/ochi_smile.PNG";
    }
    function changeOchiFaceNonSmile()
    {
      document.getElementById("ochiface").src = "./images/ochi's.png";
    }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>コーデ画面</title>

<!-- 上下服のプルダウンの値を変更 編集:功刀 -->

</head>
<!-- cssファイル読み込み -->
<link rel="stylesheet" type="text/css" href="css/PileImage.css">
<link rel="stylesheet" type="text/css" href="css/Header.css">
<link rel="stylesheet" type="text/css" href="css/TwoColumn.css">
<link rel="stylesheet" type="text/css" href="css/Scroll.css">
<link rel="stylesheet" type="text/css" href="css/BackGround.css">
<link rel="stylesheet" type="text/css" href="css/inline-block.css">

<body>
  <div class="container">
    <div class="header">
      <div class="headlogo">
        <img src="./images/Logo4.png" width="150" height="70" />
      </div>
      <div class="title">コーディネイト画面</div>
      <!-- 画面遷移ボタン -->
      <div class="buttons">
        <div class="button">
          <form method="POST" action="ListOutSaleClothServlet">
            <input type="submit" value="おすすめ画面へ">
          </form>
        </div>
        <div class="button">
          <form method="POST" action="ListOutUserClotheServlet">
            <input type="submit" value="所有服一覧へ">
          </form>
        </div>
      </div>
    </div>

    <div class="verticalContainer">
      <!-- 画像表示部分 -->

      <div class="model">
        <div class="flame">
          <input type="radio" name="sexradio" onclick="changeOchiFaceMan()" checked="checked" />男
          <input type="radio" name="sexradio" onclick="changeOchiFaceWoman()" />女
          <!-- 越智くんの顔 -->
          <div class="relative">
            <%if(bean.getSex() == SexEnum.男) {%>
            <img src="./images/白.png" width="160" height="120" /> <img
              id="ochiface" src="./images/ochi's.png" class="absolute"
              width="160" height="120" onclick="changeOchiFaceSmile()" />
            <%} %>
            <%if(bean.getSex() == SexEnum.女) {%>
            <img src="./images/白.png" width="160" height="120" /> <img
              id="ochiface" src="./images/ochi_smile.PNG" class="absolute"
              width="160" height="120" onclick="changeOchiFaceNonSmile()" />

            <%} %>
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
          <div class="relative">
            <form method="POST" action="RegistCoordinateServlet">
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
                type="submit" value="コーデ登録">
            </form>
          </div>
        </div>
      </div>

      <div class="contents">
        <div class="horizontalcontainer">
          <div class="form1">
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
          </div>

          <div class="form2">
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
              </select> <input type="hidden" name="topcolor"
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
          <div class="form3">
            <ul class="scrollsize">
              <%
                  for (bean.CoordinateBean code : bean.getList())
                  {
                %>
               <li><form method="POST" action="ChangeSelectCodeServlet">
               <div class ="button_floata">
               <input type="submit" name="cloth"
               value="<%=code.toString()%>">
               </div> </form></li>
               <li><form method="POST" action="DeleteCoordinateServlet">
               <div class ="button_floatb">
               <input type="hidden" name="code" value="<%=code.getCode_num()%>">
               <input type="submit" value="コーデ削除">
               </div>
               </form> </li>
                <%
                  }
                %>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>