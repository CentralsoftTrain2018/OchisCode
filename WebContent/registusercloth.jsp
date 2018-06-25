<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="domain.ColorEnum"%>
<%@ page import="domain.PatternEnum"%>
<%@ page import="domain.CategoryEnum"%>
<%@ page import="domain.SizeEnum"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- cssインポート --%>
<link rel="stylesheet" type="text/css" href="css/Login.css">
<link rel="stylesheet" type="text/css" href="css/BackGround.css">
<link rel="stylesheet" type="text/css" href="css/UserInfo.css">
<link rel="stylesheet" type="text/css" href="css/PileImage.css">

<title>持ち服登録</title>
</head>
<script>
var set = 0;
function doub() {
  if (set == 0) {
    set = 1;
  } else {
    alert("只今処理中です。\nそのままお待ちください。");
    return false;
  }
}
</script>


<body>
  <%-- コンテナ開始 --%>
  <div id="container">

    <%-- ページ開始 --%>
    <div id="page">



      <%-- コンテンツ開始 --%>
      <div id="content">

        <div id="header">

          <h1 class="siteTitle">
            <a href="javascript:moveSaleCloth.submit();"> <img
              src="./images/LoginLogo.png" width="400" height="150" />
            </a>
            <form method="POST" name="moveSaleCloth"
              action="ListOutSaleClothServlet"></form>
          </h1>
        </div>
        <%-- メインカラム開始 --%>
        <div id="main">
          <%-- ユーザー情報表示 --%>
          <div class="normal">
            <div class="emphasis">
              <h2>持ち服登録</h2>


              プルダウンで持っている服の色、柄、カテゴリ、サイズを選んでください。<br><br>
              <form method="POST" action="RegistUserClothServlet" onSubmit="return doub()">
                <%-- 色プルダウン --%>
                <select name="color">
                  <%
                    for (ColorEnum ce : ColorEnum.values())
                    {
                  %>
                  <option value="<%=ce.name()%>">
                    <%=ce.name()%>
                  </option>
                  <%
                    }
                  %>
                </select>

                <%-- 柄プルダウン --%>
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

                <%-- カテゴリープルダウン --%>
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

                <%-- サイズプルダウン --%>
                <select name="size">
                  <%
                    for (SizeEnum se : SizeEnum.values())
                    {
                  %>
                  <option value="<%=se.name()%>"><%=se%></option>
                  <%
                    }
                  %>
                </select><br><br>
                 <input type="hidden" name="page" value=1> <input
                  type="submit" value="登録">
              </form>
            </div>
      <br>
            <form method="POST" action="ListOutUserClotheServlet">
              <input type="hidden" name="page" value=1> <input
                type="submit" value="戻る">
            </form>
          </div>
        </div>
      </div>
      <%-- コンテンツ終了 --%>

    </div>
    <%-- ページ終了 --%>

  </div>
  <%-- コンテナ終了 --%>
</body>
</html>