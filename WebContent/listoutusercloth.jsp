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

<link rel="stylesheet" type="text/css" href="css/Login.css">
<link rel="stylesheet" type="text/css" href="css/BackGround.css">
<link rel="stylesheet" type="text/css" href="css/SaleClothDisplay.css">
<link rel="stylesheet" type="text/css" href="css/Header.css">
<link rel="stylesheet" type="text/css" href="css/BackGround.css">
<link rel="stylesheet" type="text/css" href="css/PileImage.css">
<link rel="stylesheet" type="text/css" href="css/margin.css">

<body onload="onLoad()">
  <!-- コンテナ開始 -->
  <div id="container">

    <!-- ページ開始 -->
    <div id="page">


      <!-- ヘッダ開始 -->
      <div id="header">

        <h1 class="siteTitle">
          <a href="javascript:moveSaleCloth.submit();"> <img
            src="./images/LoginLogo.png" width="400" height="150" />
          </a>
           <form method="POST" name="moveSaleCloth" action="ListOutSaleClothServlet">
          </form>
        </h1>

        <ul class="guide">
          <li class="first"><a href="javascript:logout.submit();"
            onclick="return confirm('ログアウトしますか？')">ログアウト</a>
            <form method="POST" name="logout" action="LogOutServlet"></form></li>
        </ul>

        <ul class="nl clearFix">
          <li class="first"><a
            href="javascript:movecoordinate.submit();">コーデ画面へ</a>
            <form method="POST" name="movecoordinate"
              action="CoordinateServlet"></form></li>
          <li><a href="javascript:movesalecloth.submit();">おすすめ画面へ</a>
            <form method="POST" name="movesalecloth"
              action="ListOutSaleClothServlet">
              <input type="hidden" name="page" value=1>
            </form></li>
          <li><a href="javascript:moveuserinfo.submit();">ユーザー情報へ</a>
            <form method="POST" name="moveuserinfo" action="UserInfoServlet">
            </form></li>
        </ul>
         </div>

<br><br>
<form method = "POST" action = "NarrowingUsrClothServlet">
<div class="margin">
  <select name = "narrow">
    <option value = "">一覧表示</option>
    <%for (domain.CategoryEnum category : domain.CategoryEnum.values()) {%>
    <option value = "and category = '<%=category.name() %>'"><%=category.name() %>
    </option>
    <%} %>
  </select>
  <input type = "hidden" name = "page" value = 1>
  <input type = "submit" value = "絞込み">
  </div>
</form>
<div class ="margin-center">
現在のページ：<%=bean.getPage() %>
</div>
<div style="display:inline-flex">
<%if(bean.getPage() != 1) {%>
<form method="POST" action="ListOutUserClotheServlet">
<input type = "hidden" name = "page" value = <%=bean.getPage() - 1 %>>
<div class="margin-l">
<input type = "submit" value = "前のページへ">
</div>
</form>
<%} %>

<%if(bean.getPage() * 5 < bean.getList().size()) {%>
<%if(bean.getPage() == 1) {%>
<form method="POST" action="ListOutUserClotheServlet">
<input type = "hidden" name = "page" value = <%=bean.getPage() + 1 %>>
<div class="margin-r1">
<input type = "submit" value = "次のページへ">
</div>
</form>
<%} else {%>
<form method="POST" action="ListOutUserClotheServlet">
<input type = "hidden" name = "page" value = <%=bean.getPage() + 1 %>>
<div class="margin-r">
<input type = "submit" value = "次のページへ">
</div>
</form>
<%} %>
<%} %>
</div>


<!--持ち服の表示(テーブル)-->
<div class="margin-t">
<table width="500" border="5" cellspacing="10">
    <tbody>
      <%
                if(!bean.getList().isEmpty()){
                  int last;
                  if(bean.getPage() * 5 < bean.getList().size()) {
                    last = bean.getPage() * 5;
                  }
                  else {
                    last = bean.getList().size();
                  }
                for (int n = (bean.getPage() - 1) * 5 ; n < last ; n++)
                {
                  java.util.List<bean.UserClothBean> record = bean.getList();
              %>
      <tr>
      <td bgcolor=#FFDBC9><%=record.get(n).toString() %></td>
        <td>
          <div class = "relative">
            <img src="./images/<%=record.get(n).getColor().name()%>.png" width=50 height=50/>
            <img src="./images/<%=record.get(n).getPattern().name()%>.png" class = "absolute" width=50 height=50/>
            <img src="./images/<%=record.get(n).getCategory().name()%>.png" class = "absolute" width=50 height=50/>
          </div>
        </td>
        <td bgcolor=#FFAD90>
           <form method = "POST" action = "DeleteUserClothServlet">
             <input type = "hidden" name = "clothid" value = <%=record.get(n).getClothid()%>>
             <input type = "hidden" name = "page" value = <%=bean.getPage()%>>
             <input type="submit" value="削除">
           </form>
        </td>
      </tr>
      <%}} %>
    </tbody>
</table>
</div>


<form method="POST" action="registusercloth.jsp">
<div class="margin">
 <input type="submit" value="持ち服登録画面へ">
 </div>
</form>


<br>
</div>
      <!-- コンテンツ終了 -->

    </div>
    <!-- ページ終了 -->

  </div>
  <!-- コンテナ終了 -->
</body>

</html>