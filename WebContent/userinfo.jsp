<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="bean" class="bean.UserInfoBean" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- cssインポート -->
<link rel="stylesheet" type="text/css" href="css/Login.css">
<link rel="stylesheet" type="text/css" href="css/BackGround.css">
<link rel="stylesheet" type="text/css" href="css/UserInfo.css">
<link rel="stylesheet" type="text/css" href="css/PileImage.css">

<title>ユーザー情報</title>

</head>

<!-- 退会ボタンに対してアラート表示 -->
<script>
  function confirmFunction1() {
    var message = "登録した持ち服、コーデ情報、ユーザー情報はすべて削除されます。\n本当に退会しますか？";
    //「OK」ボタンをクリックした時
    if (confirm(message)) {
      alert("さようなら");
      return true;
    }
    return false;
  }
</script>
<body>
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
 <form method="POST" name="moveSaleCloth"
            action="ListOutSaleClothServlet"></form>
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
<li><a href="javascript:moveuserinfo.submit();">おすすめ画面へ</a>
                <form method="POST" name = "movesalecloth"
                  action="ListOutSaleClothServlet">
                </form></li>
</ul>
<hr class="none">
</div>
<!-- ヘッダ終了 -->


<!-- コンテンツ開始 -->
<div id="content">


<!-- メインカラム開始 -->
<div id="main">


  <!-- ユーザー情報表示 -->
  <div  class ="normal">
 <div class="emphasis">

 <h2>ユーザ登録情報</h2>

 <table>
    <tr>
      <td>ユーザーID：</td>
      <td><%=bean.getUserid()%></td>
    </tr>
    <tr>
      <td>身長：</td>
      <td><%=bean.getUserheight()%></td>
    </tr>
    <tr>

      <td>服のサイズ：</td>
      <td><%=bean.getSize().name()%></td>
    </tr>
    <tr>
      <td>予算：</td>
      <td><%=bean.getBudget()%></td>
    </tr>
    <tr>
      <td>性別：</td>
      <td><%=bean.getSex().name()%></td>
    </tr>
  </table>

</div>
  </div>
   <!-- 登録情報変更ボタン -->
  <form method="POST" action="UserConfigServlet">
    <input type="submit" value="ユーザー情報を変更する">
  </form>

  <!-- 退会ボタン -->
  <form onclick="return confirmFunction1();" method="POST" action="DeleteUserServlet">
    <input type="submit" value="退会する">
  </form>
  </div>
<!-- メインカラム終了 -->

<hr class="clear">
</div>
<!-- コンテンツ終了 -->

</div>
<!-- ページ終了 -->

</div>
<!-- コンテナ終了 -->




</body>




</html>