<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>新增會員</title>
<!-- bootstrap -->
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!-- 自定義js -->
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<link rel="stylesheet/less" href="${pageContext.request.contextPath}/css/createMember.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/createMember.js"></script>
</head>
<body>
  名字:<input id="name" name="name" type="text"> &nbsp;
  生日:<input id="birthday" name="birthday" type="text"> &nbsp; 
  男<input name="gender" type="radio" value="1">女<input name="gender" type="radio" value="0"> 
  
  <br><br>
  
  電子信箱:<input id="email" type="text" > &nbsp; 
  電話:<input id="phone" name="phone" type="text"> &nbsp; 
  到職日:<input id="workingday" name="workingday" type="date">
  
  <br><br>
  
  地址:
  <select id="citySelectbox">
  	<option value="0">--請選擇--</option>
  </select>
  <select id="zoneSelectbox">
  	<option value="0">--請選擇--</option>
  </select>
  <input id="address" name="address" type="text">
  
  <br><br>
  
  興趣:
  <br><br>
  <div id="interestCheckboxDiv">
  	<input id="allCheckbox" name="allCheckbox" type="checkbox">全部
  </div>
  
  
   <br><br>
  
  <button id="returnBtn">返回</button> &nbsp;
  <button id="singinBtn">保存</button>
  <span id="singinFaildId"></span>
</body>
</html>