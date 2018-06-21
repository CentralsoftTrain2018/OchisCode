<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="domain.SizeEnum"%>
<jsp:useBean id="bean" class="bean.UserInfoBean" scope="request" />
<head>
<meta charset="UTF-8">
<title>登録情報変更</title>
<!-- cssインポート -->

<link rel="stylesheet" type="text/css" href="css/Login.css">
<link rel="stylesheet" type="text/css" href="css/BackGround.css">
<link rel="stylesheet" type="text/css" href="css/UserInfo.css">
<link rel="stylesheet" type="text/css" href="css/PileImage.css">

</head>

<!-- プルダウンのデフォルト値変更 -->
<script type="text/javascript">
function onLoad()
{
  var elms = document.getElementById("size");
    if (elms)
    {
        for(i = 0; i < elms.options.length; i++)
        {
            if (elms.options[i].value == "<%=bean.getSize().name()%>" )
            {
              elms[i].selected = true;
            }
        }
    }
}
</script>
<body onload="onLoad();">
<!-- コンテナ開始 -->
<div id="container">

<!-- ページ開始 -->
<div id="page">


<!-- ヘッダ開始 -->

<div id="header">

<h1 class="siteTitle">
  <a href="javascript:moveSaleClothImage.submit();">
    <img src="./images/Logo4.png" width="150" height="70" />
  </a>
 <form method="POST" name="moveSaleClothImage"
            action="ListOutSaleClothServlet"></form>
</h1>

 <ul class="guide">
          <li class="first"><a href="javascript:logout.submit();"
            onclick="return confirm('ログアウトしますか？')">ログアウト</a>
            <form method="POST" name="logout" action="LogOutServlet"></form></li>

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
<li><a href="javascript:moveSaleClothButtonsubmit();">おすすめ画面へ</a>
                <form method="POST" name = "moveSaleClothButton"
                  action="ListOutSaleClothServlet">
                </form></li>
</ul>
<hr class="none">
</div>
<!-- ヘッダ終了 -->
<div id="content">


<!-- メインカラム開始 -->
<div id="main">


  <!-- ユーザー情報表示 -->
  <div  class ="normal">

   <div  class ="normal">
 <div class="emphasis">

 <h2>登録情報変更</h2>

  変更する値を入力してください。
  <form method="POST" action="UserInfoUpdateServlet">

    <table>
      <tr>
        <td>項目</td>
        <td>変更前</td>
        <td>変更後</td>
      </tr>
      <tr>
        <td>ユーザーID：</td>
        <td><%=bean.getUserid()%></td>
      </tr>
      <tr>
        <td>身長：</td>
        <td><%=bean.getUserheight()%></td>
        <td><input name="userheight" type="number"></td>
      </tr>
      <tr>
        <td>服のサイズ：</td>
        <td><%=bean.getSize().name()%></td>
        <td><select id = "size" name="size">
            <%
              for (SizeEnum se : SizeEnum.values())
              {
            %>
            <option value="<%=se.name()%>"><%=se%></option>
            <%
              }
            %>
        </select></td>
      </tr>
      <tr>
        <td>予算：</td>
        <td><%=bean.getBudget()%></td>
        <td><input name="budget" type="number"></td>
      </tr>
      <tr>
        <td>性別：</td>
        <td><%=bean.getSex().name()%></td>
        <td><input name="sex" type="radio" value="男" <%if(bean.getSex(  ).name().equals( "男" )){ %> checked="checked" <%} %>>男
        <input name="sex" type="radio" value="女" <%if(bean.getSex(  ).name().equals( "女" )){ %> checked="checked" <%} %>>女</td>
      </tr>
    </table>
    <input type="submit" value="登録情報変更">
  </form  >

  </div>
  </div>
 </div>
<!-- メインカラム終了 -->
<form action="UserInfoServlet">
 <input type="submit" value="戻る">
</form>

<hr class="clear">
</div>
<!-- コンテンツ終了 -->

</div>
<!-- ページ終了 -->

</div>
<!-- コンテナ終了 -->




</body>




</html>