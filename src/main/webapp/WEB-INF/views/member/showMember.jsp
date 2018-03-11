<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢會員資料</title>
</head>
<body>
	<form action="showMember" method="get">
		<br> 電子信箱: <input name="email" type="text"
			size="5" value="${param.email}"> <br>
		<div style="color: red; font-size: 60%">${errorMessage}</div>
		<input type="submit" value="確認輸入"> <input type="reset"
			value="重新輸入"><br>
	</form>
</body>
</html>