<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>查看會員</title>
<!-- bootstrap -->
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!-- 自定義js -->
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/selectMember.js"></script>
</head>
<body>
 名字:<input  id ="name"name="name" type="text" readonly> &nbsp;  
 生日:<input id ="birthday" name="birthday" type="text" readonly> &nbsp; 
  男<input name="gender" type="radio" value="1" disabled>
  女<input name="gender" type="radio" value="0" disabled> 
  
  <br><br>
  
  電子信箱:<input id="email" type="text" readonly>&nbsp;
  電話:<input id="phone" type="text" readonly>&nbsp;
  到職日:<input id="workingday" type="date" readonly>
  
  <br><br>
  
   地址:
  <select id="citySelectbox" disabled>
  	<option value="0">--請選擇--</option>
  </select>
  <select id="zoneSelectbox" disabled>
  	<option>--請選擇--</option>
  </select>
  <input id="address" name="address" type="text" readonly>
  
  <br><br>
  
  興趣:
  <br><br>
  <div id="interestCheckboxDiv">
  	<input id="allCheckbox" name="allCheckbox" type="checkbox" disabled>全部
  </div>
  
   <br><br>
   
  <button id="returnBtn">返回</button>
  
</body>
</html>