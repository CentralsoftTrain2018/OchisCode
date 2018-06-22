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
            <form method="POST" name="moveLogin" action="login.html"></form>
          </h1>
          <ul class="guide">
            <li class="first"><a href="javascript:logout.submit();"
              onclick="return confirm('ログアウトしますか？')">ログアウト</a>
              <form method="POST" name="logout" action="LogOutServlet"></form></li>
          </ul>
          <!-- メインカラム開始 -->
          <div id="main">
            <!-- ユーザー情報表示 -->
            <div class="normal">
              <div class="emphasis">
                <h2>販売服閲覧数集計結果</h2>
                <table width="600" border="5" cellspacing="10" bgcolor = #CCFFFF>
                  <tbody>
                    <tr>
                      <th>色</th>
                      <th>柄</th>
                      <th>カテゴリ</th>
                      <th>クリック数</th>
                    </tr>
                    <%
                      for (bean.SaleClothBean record : bean.getList())
                      {
                    %>
                    <tr align="center" valign="center">
                      <td ><%=record.getColor().name()%></td>
                      <td><%=record.getPattern().name()%></td>
                      <td><%=record.getCategory().name()%></td>
                      <td><%=record.getClickcount()%></td>
                    </tr>
                    <%
                      }
                    %>
                  </tbody>
                </table>

                <form method="POST" action="ListOutLinkCountServlet">
                  <input type="email" name="address" placeholder="送信先メールアドレスを入力"
                    required="required"> <input type="submit"
                    value="集計データを送信">
                </form>
              </div>
              <br>
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