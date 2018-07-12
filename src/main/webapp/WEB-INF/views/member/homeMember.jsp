<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>會員首頁</title>
<!-- bootstrap -->
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<%-- <link href="${pageContext.request.contextPath}/bootstrap/img/glyphicons-halflings.png"> --%>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!-- 自定義js -->
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/homeMember.js"></script>

</head>
<body>
<%-----------------------------------查询表格區-------------------------------------------------------%>
	序號:
	<input name="sid" id="sid" type="text"> &nbsp; 
	名字:
	<input name="name" id="name" type="text"> &nbsp; 
	電話:
	<input name="phone" id="phone" type="text"> &nbsp; 
	到職日:
	<input name="workingDay" id="workingDay" type="date">

	<br>
	<br>
<%-----------------------------------按鈕區---------------------------------------------------------%>

	<button id="selectBtn">查詢</button> &nbsp;
	<button id="resetBtn">重置</button> &nbsp;
	<button id="siginBtn" class="btn btn-default btn-lg">新增
		<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
	</button> &nbsp;
	
<%-----------------------------------顯示結果區-------------------------------------------------------%>
	<div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th><input type="checkbox" id="allDeleteCheckbox"></th>
					<th>序號</th>
					<th>名字</th>
					<th>電話</th>
					<th>生日</th>
					<th>到職日</th>
					<th>查看</th>
					<th>編輯</th>
				</tr>
			<thead>
			<tbody id="tableBody"></tbody>
		</table>
	</div>
	
	
<!-- 刪除按鈕 -->
	<button type="button" style="display: none;" class="delData btn-icon" id="deleteButton">
						<span></span>删除
					</button>
	
	
	
</body>
</html>