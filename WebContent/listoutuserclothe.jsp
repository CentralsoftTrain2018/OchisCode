<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有服　一覧</title>
</head>
<body>
所有服一覧
<select name ="test">

</select>
<form method="POST" action="SelectClothServlet">
 <input type="submit" value="コーデ画面へ">
</form>
<form method="POST" action="ListOutRecomClothServlet">
 <input type="submit" value="ホーム画面へ">
<br>
</form>

</body>
</html>