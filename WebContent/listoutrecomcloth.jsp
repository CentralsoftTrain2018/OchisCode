<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ホーム画面</title>
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

ホーム画面
<form  method="POST" action="SelectClothServlet">
 <input type="submit" value="コーデ画面へ">
</form>
<form  method="POST" action="ListOutUserClotheServlet">
 <input type="submit" value="所有服一覧へ">
</form>
<br>
<br>

<!--  -->

<div class="relative">
<img src="./images/Black.png" width="175" height="147"/>
<img src="./images/TShirt.png" width="175" height="147" class="absolute"  />
</div>

</body>

</html>