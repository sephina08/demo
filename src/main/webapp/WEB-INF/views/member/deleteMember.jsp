<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>刪除會員</title>
</head>
<body>
<form action="deleteMember" method="get">
	<input name="email" value="${memberFormBean.name}" hidden>
	電子信箱:${memberFormBean.name}<br> 姓名:${memberFormBean.firstName}<br>
	名字:${memberFormBean.lastName}<br> 手機:${memberFormBean.mobile}<br>
	電話:${memberFormBean.tel}<br> 分機:${memberFormBean.telExt}<br>
	
	<button type="submit">刪除會員</button>

</form>

<!--  
<form action="deleteMember" method="get">

		<a href='${pageContext.request.contextPath}/controller/member/MemberController?${memberFormBean.lastName}'>
		電子信箱:${memberFormBean.name}<br> 姓名:${memberFormBean.firstName}<br>
		名字:${memberFormBean.lastName}<br> 手機:${memberFormBean.mobile}<br>
		電話:${memberFormBean.tel}<br> 分機:${memberFormBean.telExt}<br>

		1. <button type="submit">刪除會員</button>
		2. <input name="mail" type="submit">刪除會員

</form>
-->


</body>
</html>