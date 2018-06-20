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
<title>おすすめ画面</title>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script src="https://www.googletagmanager.com/gtag/js?id=UA-121088811-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-121088811-1');
</script>

</head>

<!-- cssファイル読み込み -->
<link rel="stylesheet" type="text/css" href="css/PileImage.css">
<link rel="stylesheet" type="text/css" href="css/Header.css">
<link rel="stylesheet" type="text/css" href="css/TwoColumn.css">
<link rel="stylesheet" type="text/css" href="css/Pulldown.css">
<link rel="stylesheet" type="text/css" href="css/BackGround.css">


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
        var elms = document.getElementById("narrow");
        if (elms)
        {
            for(i = 0; i < elms.options.length; i++)
            {
                if (elms.options[i].value == "<%=bean.getNarrow()%>")
                {
                    elms[i].selected = true;
                }
            }
        }
        var elms = document.getElementById("sort");
        if (elms)
        {
            for(i = 0; i < elms.options.length; i++)
            {
                if (elms.options[i].value == "<%=bean.getSort()%>") {
          elms[i].selected = true;
        }
      }
    }
  }

  function changeOchiFaceSmile() {
    document.getElementById("ochiface").src = "./images/ochi_smile.PNG";
  }

  function changeOchiFaceNonSmile() {
    document.getElementById("ochiface").src = "./images/ochi's.png";
  }
</script>

<body onload="onLoad()">
  <div class="container">
    <div class="header">
      <div class="headlogo">
        <img src="./images/Logo4.png" width="150" height="70" />
      </div>
      <div class="title">オススメ画面</div>
      <div class="buttons">
        <div class="button">
          <form method="POST" action="CoordinateServlet">
            <input type="submit" value="コーデ画面へ">
          </form>
        </div>
        <div class="button">
          <form method="POST" action="ListOutUserClotheServlet">
            <input type="hidden" name="page" value=1> <input
              type="submit" value="所有服一覧へ">
          </form>
        </div>
      </div>

    </div>
    <div class="content">
      <div class="verticalContainer">
        <!-- 左側モデル表示部分 -->

        <div class="model">
          <div class="flame">
            <!-- 画像表示部分 -->
            <!-- 越智くんの顔 -->
            <div class="relative">

              <%
                if (bean.getSex() == SexEnum.男)
                {
              %>


              <img src="./images/白.png" width="160" height="120" /> <img
                id="ochiface" src="./images/ochi's.png" class="absolute"
                width="160" height="120" onclick="changeOchiFaceSmile()" />
              <%
                }
              %>
              <%
                if (bean.getSex() == SexEnum.女)
                {
              %>

              <img src="./images/白.png" width="160" height="120" /> <img
                id="ochiface" src="./images/ochi_smile.PNG" class="absolute"
                width="160" height="120" onclick="changeOchiFaceNonSmile()" />

              <%
                }
              %>
            </div>

            <div class="relative">
              <!-- 上服 -->
              <img id="topcolor"
                src="./images/<%=bean.getTopColor().name()%>.png"
                width="<%=bean.getTopSize().getWidth()%>"
                height="<%=bean.getTopSize().getHeight()%>" /> <img
                id="toppattern"
                src="./images/<%=bean.getTopPattern().name()%>.png"
                class="absolute" width="<%=bean.getTopSize().getWidth()%>"
                height="<%=bean.getTopSize().getHeight()%>" /> <img
                id="topcategory"
                src="./images/<%=bean.getTopCategory().name()+"hand"%>.png"
                class="absolute" width="<%=bean.getTopSize().getWidth()%>"
                height="<%=bean.getTopSize().getHeight()%>" />
            </div>

            <div class="relative">
              <!-- 下服 -->
              <img id="bottomcolor"
                src="./images/<%=bean.getBottomColor().name()%>.png"
                width="<%=bean.getBottomSize().getWidth()%>"
                height="<%=bean.getBottomSize().getHeight()%>" /> <img
                id="bottompattern"
                src="./images/<%=bean.getBottomPattern().name()%>.png"
                class="absolute" width="<%=bean.getBottomSize().getWidth()%>"
                height="<%=bean.getBottomSize().getHeight()%>" /> <img
                id="bottomcategory"
                src="./images/<%=bean.getBottomCategory().name()+"leg"%>.png"
                class="absolute" width="<%=bean.getBottomSize().getWidth()%>"
                height="<%=bean.getBottomSize().getHeight()%>" />
            </div>
          </div>
          <form method="POST" action="UserInfoServlet">
            <input type="submit" value="ユーザー情報">
          </form>
        </div>

        <!-- 右側プルダウン、画像表示部分 -->
        <div class="contents">
          <div class="container">
            <div class="pulldown">

              <!-- プルダウン、ボタン -->
              <form method="POST" action="SaleClothDisplayServlet">
                <div class="styled-select yellow rounded">
                  <select id="usercloth" name="usercloth">
                    <%
                      for (bean.UserClothBean str : bean.getUserCloth().getList())
                      {
                    %>
                    <option value="<%=str.getClothid()%>"><%=str%></option>
                    <%
                      }
                    %>
                  </select>
                </div>
                <!-- 絞込み -->
                <div class="styled-select yellow rounded">
                  <select id="narrow" name="narrow">
                    <option value=" price > 0 ">0以上</option>
                    <option value=" price > 0 and price < 5001">0-5000</option>
                    <option value=" price > 5000 and price < 10001">5001-10000</option>
                    <option value=" price > 10000 and price < 15001">10001-15000</option>
                    <option value=" price > 15000">15001-</option>
                  </select>
                </div>
                <!-- 並び替え -->
                <div class="styled-select yellow rounded">
                  <select id="sort" name="sort">
                    <option value="clothid DESC">新着順</option>
                    <option value="clothid ASC">古い順</option>
                    <option value="price DESC">値段が高い順</option>
                    <option value="price ASC">値段が安い順</option>
                  </select>
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
            </div>
            <!-- 販売服表示 -->
            <div class="contents">
              <%
                int i = 0;
              %>
              <%
                for (bean.SaleClothBean record : bean.getSaleCloth().getList())
                {
              %>
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
                <br> <a href="javascript:<%="form" + i %>.submit();"><%=record.toString()%></a>
                <form method="POST" name="<%="form" + i%>"
                  action="CountLinkClickServlet">
                  <input type="hidden" name="URL" value="<%=record.getURL()%>">
                  <input type="hidden" name="clothid" value="<%=record.getClothid()%>">
                </form>
                <%
                  i++;
                %>
              </div>
              <%
                }
              %>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>