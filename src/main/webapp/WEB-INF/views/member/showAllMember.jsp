<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顯示所有會員資料</title>
</head>
<body>
	<form action="selectAllMember" method="get"></form>
	<h1>會員資料:</h1>

	<table border="1">
		<tr>
			<th>信箱</th>
			<th>姓氏</th>
			<th>名字</th>
			<th>手機</th>
			<th>電話</th>
			<th>分機</th>
		</tr>
		<c:forEach var='memberFormBean' items="${memberFormBeanList}">
			<tr>
				<td><a href='showMember?email=${memberFormBean.email}'>${memberFormBean.email}</a></td>
				<td>${memberFormBean.firstName}</td>
				<td>${memberFormBean.lastName}</td>
				<td>${memberFormBean.mobile}</td>
				<td>${memberFormBean.tel}</td>
				<td>${memberFormBean.telExt}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>