<%@page import="domain.ColorEnum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.SaleClothDisplayBean" scope="request" />
<%@ page import="java.lang.String"%>
<%@ page import="domain.SexEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ochi's Code</title>
</head>

<!-- cssインポート -->
<link rel="stylesheet" type="text/css" href="css/Login.css">
<link rel="stylesheet" type="text/css" href="css/BackGround.css">
<link rel="stylesheet" type="text/css" href="css/SaleClothDisplay.css">
<link rel="stylesheet" type="text/css" href="css/PileImage.css">

<script type="text/javascript">
    function changeImg(jouge, color, pattern, category)
    {
      if (jouge == "上") {
        document.getElementById("topcolor").src = "./images/" + color
            + ".png";
        document.getElementById("toppattern").src = "./images/"
            + pattern + ".png";
        document.getElementById("topcategory").src = "./images/"
            + category + "hand.png";
      } else {
        document.getElementById("bottomcolor").src = "./images/"
            + color + ".png";
        document.getElementById("bottompattern").src = "./images/"
            + pattern + ".png";
        document.getElementById("bottomcategory").src = "./images/"
            + category + "leg.png";

      }
    }

    function onLoad()
    {
      var elms = document.getElementById("usercloth");
        if (elms)
        {
            for(i = 0; i < elms.options.length; i++)
            {
                if (elms.options[i].value == "<%=bean.getClothid()%>")
                {
                    elms[i].selected = true;
                }
            }
        }
    }

    function changeOchiFaceSmile() {
        document.getElementById("ochiface").src = "./images/ochi_smile.png";
      }



      function changeOchiFaceWomanSmile(){
        document.getElementById("ochiface").src = "./images/ochi_woman_smile.png";
      }
</script>

<body onload="onLoad()">
<!-- コンテナ開始 -->
<div id="container">

<!-- ページ開始 -->
<div id="page">


<!-- ヘッダ開始 -->
<div id="header">

<h1 class="siteTitle">
  <a href="javascript:moveSaleCloth.submit();">
    <img src="./images/Logo4.png" width="150" height="70" />
  </a>
  <form method="POST" name = moveSaleCloth action="ListOutSaleClothServlet">
  </form>
</h1>

<ul class="guide">
<li class="first"><a href="#">FAQ</a></li>
<li><a href="#">アクセス</a></li>
</ul>

<ul class="nl clearFix">
<li class="first"><a href="javascript:movecoordinate.submit();">コーデ画面へ</a>
                <form method="POST" name= "movecoordinate"
                  action="CoordinateServlet">
                </form></li>
<li><a href="javascript:moveusercloth.submit();">所持服一覧へ</a>
                <form method="POST" name= "moveusercloth"
                  action="ListOutUserClotheServlet">
                  <input type="hidden" name="page" value=1>
                </form></li>
<li><a href="javascript:moveuserinfo.submit();">ユーザー情報へ</a>
                <form method="POST" name = "moveuserinfo"
                  action="UserInfoServlet">
                </form></li>
</ul>

<hr class="none">

</div>
<!-- ヘッダ終了 -->


<!-- コンテンツ開始 -->
<div id="content">


<!-- メインカラム開始 -->
<div id="main">

<div class="section emphasis">
<h2>オススメ服</h2>
<div class = "cloth">
<%for (bean.SaleClothBean record : bean.getSaleCloth().getList()){%>
              <div class="item">
                <div class="relative">
                  <form method="POST" action="SaleClothDisplayServlet">
                    <img src="./images/<%=record.getColor().name()%>.png"
                      width=175 height=147 /> <img
                      src="./images/<%=record.getPattern().name()%>.png" width=175
                      height=147 class=absolute /> <img
                      onclick="changeImg('<%=record.getJouge().name()%>',
                                       '<%=record.getColor().name()%>',
                                       '<%=record.getPattern().name()%>',
                                       '<%=record.getCategory().name()%>')"
                      src="./images/<%=record.getCategory().name()%>.png" width=175
                      height=147 class=absolute />
                  </form>
                </div>
                <!-- リンクの調整 -->
                <br> <a href="<%=record.getURL()%>" onclick="ga(‘send’, ‘event’, ‘link’, ‘chick’, ‘test’, true);"><%=record.toString()%></a>
              </div>
              <%
                }
              %>
</div>
</div>
</div>
<!-- メインカラム終了 -->


<!-- サイドバー開始 -->
<div id="nav">

<div class = "model">
<div class = "relative">
<% if (bean.getSex() == SexEnum.男){%>
  <img src="./images/白.png" width="160" height="120" /> <img
   id="ochiface" src="./images/ochi's.png" class="absolute"
   width="160" height="120" onclick="changeOchiFaceSmile()" />
<%}%>
<%if (bean.getSex() == SexEnum.女){%>
  <img src="./images/白.png" width="160" height="120" /> <img
   id="ochiface" src="./images/ochi_woman.png" class="absolute"
   width="160" height="120" onclick="changeOchiFaceWomanSmile()" />
<%}%>
</div>

<!-- 上 -->
<div class="relative">
              <img id="topcolor"
              src="./images/<%=bean.getTopColor().name()%>.png"
              width="<%=bean.getTopSize().getWidth()%>"
              height="<%=bean.getTopSize().getHeight()%>" />
              <img id="toppattern"
              src="./images/<%=bean.getTopPattern().name()%>.png"
              class="absolute" width="<%=bean.getTopSize().getWidth()%>"
              height="<%=bean.getTopSize().getHeight()%>" />
              <img id="topcategory"
              src="./images/<%=bean.getTopCategory().name() + "hand"%>.png"
              class="absolute" width="<%=bean.getTopSize().getWidth()%>"
              height="<%=bean.getTopSize().getHeight()%>" />
</div>
<!-- 下 -->
<div class="relative">
              <img id="bottomcolor"
              src="./images/<%=bean.getBottomColor().name()%>.png"
              width="<%=bean.getBottomSize().getWidth()%>"
              height="<%=bean.getBottomSize().getHeight()%>" /> <img
              id="bottompattern"
              src="./images/<%=bean.getBottomPattern().name()%>.png"
              class="absolute" width="<%=bean.getBottomSize().getWidth()%>"
              height="<%=bean.getBottomSize().getHeight()%>" /> <img
              id="bottomcategory"
              src="./images/<%=bean.getBottomCategory().name() + "leg"%>.png"
              class="absolute" width="<%=bean.getBottomSize().getWidth()%>"
              height="<%=bean.getBottomSize().getHeight()%>" />
</div>
</div>

<form  method="POST" action="SaleClothDisplayServlet">
<div class="section emphasis">

<h2>絞込み</h2>
<input type = "radio" name = "narrow" value = " price > 0 " checked = "checked">0以上
<input type = "radio" name = "narrow" value = " price > 0 and price < 5001"
 <%if(bean.getNarrow().equals(" price > 0 and price < 5001")){ %> checked="checked" <%} %>>0-5000
<input type = "radio" name = "narrow" value = " price > 5000 and price < 10001"
 <%if(bean.getNarrow().equals(" price > 5000 and price < 10001")){ %> checked="checked" <%} %>>5001-10000
<input type = "radio" name = "narrow" value = " price > 10000 and price < 15001"
 <%if(bean.getNarrow().equals(" price > 10000 and price < 15001")){ %> checked="checked" <%} %>>10001-15000
<input type = "radio" name = "narrow" value = " price > 15000"
 <%if(bean.getNarrow().equals(" price > 15000")){ %> checked="checked" <%} %>>15001-
</div>

<div class="section strong">

<h2>並び替え</h2>
<input type = "radio" name = "sort" value = "clothid DESC" checked = "checked">新着順
<input type = "radio" name = "sort" value = "clothid ASC"
 <%if(bean.getSort().equals("clothid ASC")){ %> checked="checked" <%} %>>古い順
<input type = "radio" name = "sort" value = "price DESC"
 <%if(bean.getSort().equals("price DESC")){ %> checked="checked" <%} %>>値段が高い順
<input type = "radio" name = "sort" value = "price ASC"
 <%if(bean.getSort().equals("price ASC")){ %> checked="checked" <%} %>>10001-15000
</div>

<div class="section normal">

<h2>持ち服選択</h2>
 <div class="styled-select yellow rounded">
 <select id="usercloth" name="usercloth">
<%for (bean.UserClothBean str : bean.getUserCloth().getList()){%>
  <option value="<%=str.getClothid()%>"><%=str%></option>
<%}%>
</select>
 </div>
</div>

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
                  type="submit" value="オススメ服表示">

</form>

<!-- サイドバー終了 -->

</div>
<hr class="clear">

</div>
<!-- コンテンツ終了 -->

</div>
<!-- ページ終了 -->

</div>
<!-- コンテナ終了 -->
</body>
</html>
