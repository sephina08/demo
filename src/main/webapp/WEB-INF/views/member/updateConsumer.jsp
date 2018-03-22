<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消費者會員修改</title>
</head>

<body>
	<!-- 記得加 name的mail -->
	<form action="edit" method="get" id="form">
		<h1>編輯消費者會員</h1>
		<input name="email" value="${memberFormBean.email}" hidden> 
		
		<label>電子信箱:${memberFormBean.email}</label> 
			
		<br><br> 
		
		姓氏:<input name="lastName" type="text" size="5" value=${memberFormBean.lastName}> 
			
		<br><br> 
		
		名字:<input name="firstName" type="text" size="15" value=${memberFormBean.firstName}> 
			
		<br><br>
		
		<div id="area">
		
		地址:<br>
		
		<select name="city" id="city">
				<option value=''>請選擇</option>
				<c:forEach var="selectBoxCity" items="${selectBoxCity}">
					<c:if test="${selectBoxCity.cityOid eq memberFormBean.city}">
						<option value="${selectBoxCity.cityOid}" selected>${selectBoxCity.cityName}</option>
					</c:if>
					<c:if test="${selectBoxCity.cityOid ne memberFormBean.city}">
						<option value="${selectBoxCity.cityOid}">${selectBoxCity.cityName}</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		
		<select name='zone' >
			<c:forEach var='zoneParent' items='${zoneParent}'>
				<c:if test="${zoneParent.zoneParent eq memberFormBean.zone}">
					<option value="${zoneParent.zoneParent}" selected>selectBoxCity.cityName</option>
				</c:if>
			
			</c:forEach>
		
		</select>
		
		<input name="address" type="text" size="15" value=${memberFormBean.address}>
		
		<br><br>
		
		 手機:<input name="mobile" type="text" value=${memberFormBean.mobile}> 
			
		<br><br>
		
		 電話:<input name="tel" type="text" value=${memberFormBean.tel}>

		<br><br> 
		
		分機:<input name="telExt" type="text" value=${memberFormBean.telExt}>
		
		<br><br> 
		
		興趣:
			<c:forEach var='checkbox' items="${checkboxes}">
				<input type="checkbox" value="${checkbox.interestValue}"
					name="interests" class="interest">${checkbox.interestDesc}
			</c:forEach>

		<br><br> 
		
		職位:
		<!-- 			name對應到傳直進去的Bean(memberFormBean)的欄位 -->
		<!-- 			因為不能給使用者預設的欄位所以第一個選項要是空白的<option value=''></option> -->
		<%-- 			如果使用者之前有選擇就不是空的<c:if test="${not empty memberFormBean.jobs}">(test裡面可以計算) --%>
		<!-- 			當使用者選擇的欄位等於資料庫裡的欄位就顯示之前選擇的欄位(selected) -->
		<!-- 			不然就正常顯示下拉式選單出來 -->
		<!-- 			如果使用者原本就沒有選擇欄位(是空的),就正常顯示下拉式選單出來 -->

		<select name='jobs'>
			<option value=''>請選擇</option>
			<c:forEach var='selectBox' items="${selectBoxs}" varStatus="status">
				<c:if test="${not empty memberFormBean.jobs}">
					<c:choose>
						<c:when test="${memberFormBean.jobs eq selectBox.jobValue}">
							<option value='${selectBox.jobValue}' selected>${selectBox.jobDesc}</option>
						</c:when>
						<c:otherwise>
							<option value='${selectBox.jobValue}'>${selectBox.jobDesc}</option>
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:if test="${empty memberFormBean.jobs}">
					<option value='${selectBox.jobValue}'>${selectBox.jobDesc}</option>
				</c:if>
			</c:forEach>
		</select> 
		
		<br><br><br> 
		
			<input type="submit" value="確認修改"> 
			<!--  
			<input class="delete" type="button" value="刪除會員"
			onclick="confirmDelete('${memberFormBean.email}')"
			style="background-color: pink;"> 
			-->
<!-- 			button按紐除了ie會自動執行submit的方式,所以要加type="button"才不會自動刷頁 -->
			<button id="deleteBtn" type="button" style="background-color: pink;"> 刪除會員 </button>
			
		<br><br><br> 
		
		<a href="memberIndex">回會員首頁</a>
	</form>

</body>

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript">

	
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
<script type="text/javascript">
	//當畫面準備完成時, 才會執行此區塊的程式碼. 一般來說也是正常的 jquery 起手式
	$(document).ready(function(){
		var interests = '${memberFormBean.interestsThroughComma}';//這個是使用者輸入的值(從資料庫拿出來是字串)
		var interestsArray = interests.split(',');//去掉逗號變成陣列["writer","banker","athlete"]
		var checkboxList = $('.interest');//資料庫顯示的值

// 		c_index引數(0,1,2,3) c_element當下(checkboxList)進來的元素(這裡做雙迴圈)
		checkboxList.each(function(c_index,c_element){	
			$(interestsArray).each(function(i_index,i_element){
				if($(c_element).val() == i_element){//如果資料庫裏面的值和使用者輸入的值一樣[ (c_element).val()取得元素值的語法   ]
					$(c_element).prop('checked',true)//就打勾(checkbox打勾的語法)
				}
			});
			
		});
		
	    $('#deleteBtn').click(function() {//如果使用者按下了確定按鈕,詢問確認是否刪除
		    if(confirm("確認是否刪除?")){
		    	$('#form').attr('action', 'deleteMember');//form標籤裡面的action轉換成deleteMember submit出去
			    $('#form').submit();
			}
	    });
	});
</script>

<!-- <script src="https://code.jquery.com/jquery-2.2.4.min.js" -->
<!-- 	integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" -->
<!-- 	crossorigin="anonymous"></script> -->

<!-- 
<script type="text/javascript">
	// 	function confirmDelete(email) {
	// 		var result = confirm("確定要刪除此筆資料?");
	// 		var form = document.getElementById('#form');
	// 		form.action = "deleteMember");
	//  		form.submit();
	// 	}
	
// 按了按鈕發生事件改變	
// 'click'事件,".delete"選擇器,function()做什麼事情
// 如果只有寫一個是傳回屬性的值(.attr是html)
// 如果寫兩個第一個是屬性名稱,改變屬性的值
//            css的寫法			
// 			$('#form').css({
// 			'width':'20px',
// 				})


	function confirmDelete(email) {
		var result = confirm("確定要刪除此筆資料?");
	}
	$(window).ready(function() {
		$('body').on('click', ".delete", function() {
			$('#form').attr('action', 'deleteMember')
			$('#form').submit()

		})

	})
</script>
 -->



</html>