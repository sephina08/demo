<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申請帳號</title>
</head>
<body>
	
	<form action="apply" method="POST">
		申請帳號 <br>
		電子信箱: <input name="email" type="text" size="20"
			value="${param.email}">
		<div style="color: red; font-size: 60%">${errorMsg.email}</div>
		<br> 密碼: <input name="password" type="password" size="20"
			value="${param.password}">
		<div style="color: red; font-size: 60%">${errorMsg.password}</div>
		<br> 確認密碼: <input name="checkPassword" type="password" size="20"
			value="${param.checkPassword}">
		<div style="color: red; font-size: 60%">${errorMsg.checkPassword}</div>
		<br>姓氏:<input name="lastName" type="text" size="5" 
		 value="${param.userLastName}">
		<div style="color: red; font-size: 60%">${errorMsg.userLastName}</div>
		<br>名字:<input name="firstName" type="text" size="15" 
		value="${param.userFirstName}">
		<div style="color: red; font-size: 60%">${errorMsg.userFirstName}</div>
<!-- 		<br>聯絡地址:<br>  -->
		
<!-- 			<select> -->
		
<%-- 			<c:forEach var="list" items="${zipList}"> --%>
<%-- 				<option value="${list.zipCountyName}">${list.zipCountyName}</option> --%>
<%-- 			</c:forEach> --%>

<!-- 		</select> -->
		
<!-- 		<select name=zipCode size="1"> -->
<%-- 			<c:forEach var="list" items="${zipList}"> --%>
<%-- 				<option value="${list.zipCode}">${list.zipCode}${list.zipTownName}</option> --%>
<%-- 			</c:forEach> --%>
<!-- 		</select>  -->
<%-- 		<input name="userAddress" type="text" value="${LoginOK.userAddress}${param.userAddress}"><br> --%>
<%-- 		<div style="color:red;font-size: 60%">${errorMsg.userAddress}</div> --%>
		<br>手機:<input name="mobile" type="text" 
		value="${param.userMobile}"><br>
		<div style="color:red;font-size: 60%">${errorMsg.userMobile}</div>
		<br>電話:<input name="tel" type="text" 
		value="${param.userTel}"><br>
		<div style="color:red;font-size: 60%">${errorMsg.userTel}</div>
		<br>分機:<input name="telExt" type="text" value="${param.userTelExt}"><br>
		
		<br> <input type="submit" value="確認申請">
	</form>
</body>
</html>