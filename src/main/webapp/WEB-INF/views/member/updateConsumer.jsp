<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消費者會員修改</title>
</head>
<body><!-- 記得加 mail -->
	<form action="edit" method="get">
		<h1>編輯消費者會員</h1>
			<input name="email" value="${memberFormBean.email}" hidden>
			<label> 電子信箱:${memberFormBean.email}</label><br> 
			姓氏:<input name="firstName" type="text" size="5" value=${memberFormBean.firstName}><br>
			名字:<input name="lastName" type="text" size="15" value=${memberFormBean.lastName}><br>
			手機:<input name="mobile" type="text" value=${memberFormBean.mobile}><br>
			電話:<input name="tel" type="text" value=${memberFormBean.tel}><br> 
			分機:<input name="telExt" type="text" value=${memberFormBean.telExt}><br>
		
		
<!-- 		<br>電子信箱:<input name="email" type="text" size="5" -->
<%-- 			value="${email}"> --%>
<!-- 		<br>姓氏:<input name="lastName" type="text" size="5" -->
<%-- 			value="${lastName}${param.lastName}"> --%>
<%-- 		<div style="color: red; font-size: 60%">${errorMsg.userLastName}</div> --%>
<!-- 		<br>名字:<input name="firstName" type="text" size="15" -->
<%-- 			value="${firstName}${param.firstName}"> --%>
<%-- 		<div style="color: red; font-size: 60%">${errorMsg.userFirstName}</div> --%>
		
<!-- 		<br>手機:<input name="mobile" type="text" -->
<%-- 			value="${mobile}${param.mobile}"><br> --%>
<%-- 		<div style="color: red; font-size: 60%">${errorMsg.userMobile}</div> --%>
<%-- 		<br>電話:<input name="tel" type="text" value="${tel}${param.tel}"><br> --%>
<%-- 		<div style="color: red; font-size: 60%">${errorMsg.userTel}</div> --%>
<!-- 		<br>分機:<input name="telExt" type="text" -->
<%-- 			value="${telExt}${param.telExt}"><br>  --%>
		<br><input type="submit"
			value="確認修改"> <input type="reset" value="重新輸入">
	</form>

</body>
</html>