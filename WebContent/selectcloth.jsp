<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.SelectBean" scope="request" />
<%@ page import="java.lang.String" %>
<%@ page import="domain.ColorEnum" %>
<%@ page import="domain.PatternEnum" %>
<%@ page import="domain.CategoryEnum" %>
<%@ page import="domain.SizeEnum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>２Dモデルの画面</title>

</head>

<style>
.relative {
    position: relative;
}
.absolute {
    position: absolute;
    left: 0px;
    top: 0px;
    }
</style>
<body>
コーディネイト画面

<!-- 画面遷移ボタン -->
<form  method="POST" action="ListOutRecomClothServlet">

 <input type="submit" value="ホーム画面へ">
</form>
<form  method="POST" action="ListOutUserClotheServlet">
 <input type="submit" value="所有服一覧へ">
</form>

<!-- 画像表示部分 -->
<!-- 越智くんの顔 -->
<div class="relative">
<img src="./images/白.png" width="60" height="70"/>
<img src="./images/ochi's.png" class="absolute"width="60" height="70"/>
</div>

<!-- 上 -->
<div class="relative">
<img src="./images/<%=bean.getTopColor(  ).name() %>.png" width="<%=bean.getTopSize(  ).getWidth(  ) %>" height="<%=bean.getTopSize(  ).getHeight(  ) %>"/>
<img src="./images/<%=bean.getTopPattern(  ).name() %>.png" class="absolute" width="<%=bean.getTopSize(  ).getWidth(  ) %>" height="<%=bean.getTopSize(  ).getHeight(  ) %>"/>
<img src="./images/<%=bean.getTopCategory(  ).name() %>.png"class="absolute"width="<%=bean.getTopSize(  ).getWidth(  ) %>" height="<%=bean.getTopSize(  ).getHeight(  ) %>"/>
</div>

<!-- 下 -->
<div class="relative">
<img src="./images/<%=bean.getBottomColor().name() %>.png" width="<%=bean.getBottomSize().getWidth() %>" height="<%=bean.getBottomSize().getHeight(  ) %>"/>
<img src="./images/<%=bean.getBottomPattern(  ).name() %>.png" class="absolute" width="<%=bean.getBottomSize(  ).getWidth(  ) %>" height="<%=bean.getBottomSize(  ).getHeight(  ) %>"/>
<img src="./images/<%=bean.getBottomCategory(  ).name() %>.png"class="absolute"width="<%=bean.getBottomSize(  ).getWidth(  ) %>" height="<%=bean.getBottomSize(  ).getHeight(  ) %>"/>
</div>

<!-- 変更する服の情報を入力 -->
<form  method="POST" action=ChangeSelectClothServlet>
<!-- 色プルダウン -->
<select name ="color">
<%for(ColorEnum ce :ColorEnum.values()){ %>
<option value="<%=ce.name() %>">
<%= ce.name()%>
</option>
<%} %>
</select>

<!-- 柄プルダウン -->
<select name ="pattern">
<%for(PatternEnum pe:PatternEnum.values()){ %>
<option value="<%=pe.name() %>">
<%=pe %>
</option>
<%} %>
</select>

<!-- カテゴリープルダウン -->
<select name ="category">
<%for(CategoryEnum cae:CategoryEnum.values()){ %>
<option value="<%=cae.name() %>">
<%=cae %>
</option>
<%} %>
</select>

<!-- サイズプルダウン -->
<select name ="size">
<%for(SizeEnum se:SizeEnum.values()){ %>
<option value="<%=se.name() %>"><%=se %></option>
<%} %>
</select>

<!-- 表示している服の情報をサーブレットに受け渡し -->
<input type="hidden" name="topcolor" value="<%=bean.getTopColor().name() %>">
<input type="hidden" name="toppattern" value="<%=bean.getTopPattern().name() %>">
<input type="hidden" name="topcategory" value="<%= bean.getTopCategory().name()%>">
<input type="hidden" name="topsize" value="<%= bean.getTopSize().name()%>">

<input type="hidden" name="bottomcolor" value="<%=bean.getBottomColor().name() %>">
<input type="hidden" name="bottompattern" value="<%=bean.getBottomPattern().name() %>">
<input type="hidden" name="bottomcategory" value="<%= bean.getBottomCategory().name()%>">
<input type="hidden" name="bottomsize" value="<%= bean.getBottomSize().name()%>">

<input type="submit" value="変更">

<!-- 持ち服と販売服を合わせたプルダウン(上下は分ける) -->
<select name ="topslist">
<%//for(:){ %>
<option value="<%="a" %>"><%="---top一覧---" %></option>
<%//} %>
</select>
<select name ="bottomlist">
<%//for(:){ %>
<option value="<%="a" %>"><%="---bottom一覧---" %></option>
<%//} %>
</select>
</form>

</body>
</html>