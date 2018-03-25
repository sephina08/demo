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
		<h1>會員資料:</h1>

		<table border="1">
			<tr>
				<th>信箱</th>
				<th>姓氏</th>
				<th>名字</th>
				<th>城市</th>
				<th>地區</th>
				<th>地址</th>
				<th>手機</th>
				<th>電話</th>
				<th>分機</th>
				<th>職業</th>
				<th>興趣</th>
			</tr>
			<c:forEach var='memberFormBean' items="${memberFormBeanList}">
				<tr>
					<td><a href='showMember?email=${memberFormBean.email}&zone=${memberFormBean.zone}'>${memberFormBean.email}</a></td>
					<td>${memberFormBean.lastName}</td>
					<td>${memberFormBean.firstName}</td>

				<c:forEach var="cityList" items="${cityList}">
					<c:if test="${memberFormBean.city eq cityList.cityOid}">
						<td>${cityList.cityName}</td>
					</c:if>
				</c:forEach>

				<c:forEach var="zoneList" items="${zoneList}">
					<c:if test="${memberFormBean.zone eq zoneList.zoneOid}">
						<td>${zoneList.zoneName}</td>
					</c:if>
				</c:forEach>
				
					<td>${memberFormBean.address}</td>
					<td>${memberFormBean.mobile}</td>
					<td>${memberFormBean.tel}</td>
					<td>${memberFormBean.telExt}</td>

<%-- 				<c:forEach var="interestList" items="${interestList}"> --%>
<%-- 					<c:if test="${memberFormBean.interests eq interestList.interestValue}">  --%>
<%-- 						<td>${interestList.interestDesc}</td>  --%>
<%-- 					</c:if>  --%>
<%-- 				</c:forEach>  --%>


				<c:forEach var="jobList" items="${jobList}">
					<c:if test="${memberFormBean.jobs eq jobList.jobValue}">
						<td>${jobList.jobDesc}</td>
					</c:if>
	   			</c:forEach>
	   			
	              <td>${memberFormBean.interestsThroughComma}</td>



			</tr>
			</c:forEach>
		</table>
		
		<br>
		<br>
		<br>
		
<!-- 		<input type="button" value="上一頁" onclick="history.back()"> -->
		<button type="button" id="backBtn">上一頁</button>
</body>

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript">


	$(document).ready(function(){
	    $('#backBtn').click(function() {
		    window.location = '/member/memberIndex';
	    });
	});
</script>
</html>