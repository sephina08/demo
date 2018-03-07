<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消費者會員修改</title>
</head>
<body>
	<form action="edit" method="post">
		<h1>編輯消費者會員</h1>
		<br>電子信箱:<input name="email" type="text" size="5"
			value="${email}">
		<br>姓氏:<input name="lastName" type="text" size="5"
			value="${lastName}${param.userLastName}">
		<div style="color: red; font-size: 60%">${errorMsg.userLastName}</div>
		<br>名字:<input name="firstName" type="text" size="15"
			value="${firstName}${param.userFirstName}">
		<div style="color: red; font-size: 60%">${errorMsg.userFirstName}</div>
		
		<br>手機:<input name="mobile" type="text"
			value="${mobile}${param.userMobile}"><br>
		<div style="color: red; font-size: 60%">${errorMsg.userMobile}</div>
		<br>電話:<input name="tel" type="text" value="${tel}${param.userTel}"><br>
		<div style="color: red; font-size: 60%">${errorMsg.userTel}</div>
		<br>分機:<input name="telExt" type="text"
			value="${telExt}${param.userTelExt}"><br> 
		<br><input type="submit"
			value="確認修改"> <input type="reset" value="重新輸入">
	</form>

</body>
</html>