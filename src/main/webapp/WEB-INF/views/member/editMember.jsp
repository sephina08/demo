<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>Insert title here</title>
</head>
<body>
  名字:<input name="name" type="text"> &nbsp 生日:<input name="birthday" type="text"> &nbsp 
  男<input name="gneder" type="radio">女<input name="gneder" type="radio"> 
  
  <br><br>
  
  電子信箱:<input type="text"> &nbsp 電話:<input name="phone" type="text"> &nbsp 到職日:<input name="workingDay" type="date">
  
  <br><br>
  
  地址:
  <select>
    <option>--請選擇--</option>
    <option>台北市</option>
  </select>
  <select>
    <option>--請選擇--</option>
    <option>內湖區</option>
  </select>
  <input name="address" type="text">
  
  <br><br>
  
  興趣:
  <br><br>
  <input name="interest" type="checkbox">游泳
  <input name="interest" type="checkbox">爬山
  <input name="interest" type="checkbox">逛街
  
   <br><br>
  
  <button id="returnBtn">返回</button> &nbsp
  <button id="saveBtn">保存</button>
  
</body>
</html>