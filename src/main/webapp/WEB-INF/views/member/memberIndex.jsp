<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>會員首頁</title>
</head>
<body>
	<form action="memberIndex" method="get">
		<a href=/member/goToSignin>申請會員</a> 
		<a href=/member/selectMember>查詢會員資料</a>
		<a href=/member/selectAllMember>後端管理</a>
	</form>
</body>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript">

// var test;
// console.info(test == null);->true
// test = '';
// console.info(test == null);->false 
// console.info(test,length === 0);->true  



	$(document).ready(function(){
	  var message = '${message}';
	  if(message != null && message.length > 0){
		alert(message);
	  }
	});
</script>
</html>