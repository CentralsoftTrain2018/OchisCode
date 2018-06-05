<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>２Dモデルの画面</title>
</head>
<body>
コーディネイト画面

<form  method="POST" action="ListOutRecomClothServlet">

 <input type="submit" value="ホーム画面へ">
</form>
<form  method="POST" action="ListOutUserClotheServlet">
 <input type="submit" value="所有服一覧へ">
</form>

</body>
</html>