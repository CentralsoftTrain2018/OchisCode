<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.ListOutLinkCountBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- cssインポート -->
<link rel="stylesheet" type="text/css" href="css/Login.css">
<link rel="stylesheet" type="text/css" href="css/BackGround.css">
<link rel="stylesheet" type="text/css" href="css/UserInfo.css">
<link rel="stylesheet" type="text/css" href="css/PileImage.css">

<title>管理者画面</title>
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
            <a href="javascript:moveLogin.submit();"> <img
              src="./images/LoginLogo.png" width="400" height="150" />
            </a>
            <form method="POST" name="moveLogin"
              action="login.html"></form>
          </h1>

          <!-- メインカラム開始 -->
          <div id="main">
            <!-- ユーザー情報表示 -->
            <div class="normal">
              <div class="emphasis">
                <h2>テスト</h2>
                <table>
                  <tr>
                    <td>色</td>
                    <td>柄</td>
                    <td>カテゴリ</td>
                    <td>クリック数</td>
                  </tr>
                  <%
                    for (bean.SaleClothBean record : bean.getList())
                    {
                  %>
                  <tr>
                    <td><%=record.getColor().name()%></td>
                    <td><%=record.getPattern().name()%></td>
                    <td><%=record.getCategory().name()%></td>
                    <td><%=record.getClickcount()%></td>
                  </tr>
                  <%
                    }
                  %>

                </table>

                <form method="POST" action="ListOutLinkCountServlet">
                  <input type="email" name="address" placeholder="送信先メールアドレスを入力"
                    required="required"> <input type="submit"
                    value="集計データを送信">
                </form>
              </div>
              <br>
              <form method="POST" action="login.html">
                 <input  type="submit" value="戻る">
              </form>
            </div>
          </div>

        </div>
        <!-- コンテンツ終了 -->

      </div>
      <!-- ページ終了 -->

    </div>
    <!-- コンテナ終了 -->
    </div>
</body>
</html>