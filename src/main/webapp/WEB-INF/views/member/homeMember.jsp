<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>Insert title here</title>
<!-- 自定義js -->
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/homeMember.js"></script>
</head>
<body>

	序號:
	<input name="sid" id="sid" type="text"> &nbsp 名字:
	<input name="name" id="name" type="text"> &nbsp 電話:
	<input name="phone" id="phone" type="text"> &nbsp 到職日:
	<input name="workingDay" id="workingDay" type="date">

	<br>
	<br>

	<button id="selectBtn">查詢</button>
	&nbsp
	<button id="resetBtn">重置</button>
	&nbsp
	<button id="saveBtn">保存</button>
	&nbsp

</body>
</html>