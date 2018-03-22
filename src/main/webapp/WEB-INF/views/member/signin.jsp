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
		<h3>申請帳號</h3>
		
		電子信箱: <input name="email" type="text" size="20" value="${param.email}">
		<div style="color: red; font-size: 60%">${errorMsg.email}</div>
		
		<br> 
		
		密碼: <input name="password" type="password" size="20" value="${param.password}">
		<div style="color: red; font-size: 60%">${errorMsg.password}</div>
		
		<br> 
		
		確認密碼: <input name="checkPassword" type="password" size="20" value="${param.checkPassword}">
		<div style="color: red; font-size: 60%">${errorMsg.checkPassword}</div>
		
		<br>
		
		姓氏:<input name="lastName" type="text" size="5" value="${param.lastName}">
		<div style="color: red; font-size: 60%">${errorMsg.userLastName}</div>
		
		<br>
		
		名字:<input name="firstName" type="text" size="15" value="${param.firstName}">
		<div style="color: red; font-size: 60%">${errorMsg.userFirstName}</div>
		
		<br>
		
		
		<div id="area">
			地址:
		<br>
			<select name="city" id="city">
				<option value=''>請選擇</option>
				<c:forEach var="selectBoxCity" items="${selectBoxCity}">
					<option value="${selectBoxCity.cityOid}">${selectBoxCity.cityName}</option>
				</c:forEach>
			</select>	
		</div>
		
			<input name="address" type="text" size="20" value="${param.address}">
		<div style="color: red; font-size: 60%">${errorMsg.userAddress}</div>
		
		<br>
		
		手機:<input name="mobile" type="text" value="${param.mobile}"><br>
		<div style="color:red;font-size: 60%">${errorMsg.userMobile}</div>
		
		<br>
		
		電話:<input name="tel" type="text" value="${param.tel}"><br>
		<div style="color:red;font-size: 60%">${errorMsg.userTel}</div>
		
		<br>
		
		分機:<input name="telExt" type="text" value="${param.telExt}">
		
		<br><br>

     <!-- value對應到資料庫的interest_value,name對應到資料庫的interests-->

	興趣:
	<c:forEach var='checkbox' items="${checkboxes}">
		<input type="checkbox" value="${checkbox.interestValue}" name="interests">${checkbox.interestDesc}
	</c:forEach>	
	
	<br><br> 
	
	職位:
	<select name='jobs'>
		<option value=''>請選擇</option>
		<c:forEach var='selectBox' items="${selectBoxs}">
			<option value='${selectBox.jobValue}'>${selectBox.jobDesc}</option>
		</c:forEach>
	</select>
	
	<br><br><br>
	
	<input type="button" value="上一頁" onclick="history.back()">

	<input type="submit" value="確認申請">


	
	</form>
</body>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript">

//ajax只發送請求,不刷頁(當使用者選擇欄位時發送request請求,使用者不會知道,在背後端發送請求)
	$(document).ready(function(){	
		$('#city').change(function(){//監聽事件
			
			cleanZoneSelectBox();
			
			var cityValue = $('#city option:selected').val();//使用者輸入的值
			if(cityValue != null && cityValue.length > 0){
				$.ajax({
					dataType : "json",
					url : '/member/getZoneByParentId',
					data : {
						"parentId":cityValue
					},
					method : 'get',
					success : function(response) {//成功要做的事情
						generateZoneSelectBox(response);
					}
				});
			}

	
	function generateZoneSelectBox(response) {
				var zoneSelectBox = $('<select name=zone>');//動態生成selectbox
				$(response).each(function(index, element) {//把資料庫帶過來的東西用迴圈拿出來
					var currentOption = $('<option>');
					currentOption.val(element.zoneOid);
					currentOption.text(element.zoneName);//台北市
					zoneSelectBox.append(currentOption);
				});
				$('#area').append(zoneSelectBox);
			}

			function cleanZoneSelectBox() {
				$('#area select[name=zone]').remove();
			}
		});

	});
</script>
</html>