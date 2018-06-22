<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="domain.SizeEnum"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- cssインポート -->
<link rel="stylesheet" type="text/css" href="css/Login.css">
<link rel="stylesheet" type="text/css" href="css/BackGround.css">
<link rel="stylesheet" type="text/css" href="css/UserInfo.css">
<link rel="stylesheet" type="text/css" href="css/PileImage.css">

<title>ユーザー登録</title>
</head>
<body>
<!-- コンテナ開始 -->
<div id="container">

<!-- ページ開始 -->
<div id="page">



<!-- コンテンツ開始 -->
<div id="content">

<div id="header">

<h1 class="siteTitle">
 <a href="javascript:moveSaleCloth.submit();">
            <img src="./images/LoginLogo.png" width="400" height="150" />
          </a>
          <form method="POST" name=moveSaleCloth action="login.html">
          </form>
</h1>
</div>
<!-- メインカラム開始 -->
<div id="main">


  <!-- ユーザー情報表示 -->
  <div  class ="normal">
 <div class="emphasis">
<h2>新規登録</h2>
  <form method="POST" action="RegistUserServlet">
    登録情報を入力してください <br>
    <table>
      <tr>
        <td>ユーザーID(半角英数字4文字以上)</td>
        <td><input name="userid" type="text" required="required" pattern="^([a-zA-Z0-9]{4,})$"></td>
      </tr>
      <tr>
        <td>パスワード(半角英数字8文字以上)</td>
        <td><input name="password" type="password" required="required" pattern="{8,}"></td>
      </tr>
      <tr>
        <td>身長(半角数字)</td>
        <td><input name="userheight" type="number" required="required"></td>
      </tr>
      <tr>
        <td>服のサイズ</td>
        <td><select name="size" required="required">
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
        <td>予算(半角数字)</td>
        <td><input name="budget" type="number" required="required"></td>
      </tr>
      <tr>
        <td>性別</td>
        <td><input name="sex" type="radio" checked="checked" value="男">男<input
          name="sex" type="radio" value="女">女</td>
      </tr>
    </table>
    <input type="submit" value="登録">
  </form>
  </div>
   <form method="POST" action="login.html">
    <input type="submit" value="戻る">
  </form>
  </div>
  </div>
  </div>
<!-- コンテンツ終了 -->

</div>
<!-- ページ終了 -->

</div>
<!-- コンテナ終了 -->
</body>
</html>