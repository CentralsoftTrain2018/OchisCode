<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.SelectBean" scope="request" />
<%@ page import="java.lang.String" %>
<%@ page import="domain.ColorEnum" %>
<%@ page import="domain.PatternEnum" %>
<%@ page import="domain.CategoryEnum" %>
<%@ page import="domain.SizeEnum" %>
<%@ page import="java.lang.String" %>
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
<img src="./images/水.png" width="75" height="85"/>
<img src="./images/無地.png" class="absolute" width="75" height="85"/>
<img src="./images/Tシャツ.png"class="absolute"width="75" height="85"/>
</div>

<!-- 下 -->
<div class="relative">
<img src="./images/黒.png" width="75" height="85"/>
<img src="./images/水玉.png" class="absolute" width="75" height="85"/>
<img src="./images/半ズボン.png" class="absolute" width="75" height="85"/>
</div>

<form  method="POST" action=SelectClothServlet>
<!-- 色プルダウン -->
<select name ="color">
<%for(ColorEnum ce :ColorEnum.values()){ %>
<% out.print("<option value=");
out.print(ce.name());
out.print(">");
out.print(ce);
out.println("</option>");%>
<%} %>
</select>

<!-- 柄プルダウン -->
<select name ="pattern">
<%for(PatternEnum pe:PatternEnum.values()){ %>
<% out.print("<option value=");
out.print(pe.name());
out.print(">");
out.print(pe);
out.println("</option>");%>
<%} %>
</select>

<!-- カテゴリープルダウン -->
<select name ="category">
<%for(CategoryEnum cae:CategoryEnum.values()){ %>
<% out.print("<option value=");
String caename =cae.name();
out.print(caename);
out.print(">");
out.print(cae);
out.println("</option>");%>
<%} %>
</select>
<!-- サイズプルダウン -->
<select name ="size">
<%for(SizeEnum se:SizeEnum.values()){ %>
<% out.print("<option value=");
String sename = se.name();
out.print(sename);
out.print(">");
out.print(se);
out.println("</option>");%>
<%} %>
</select>
<input type="submit" value="変更">
</form>

</body>
</html>