<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入商品</title>
</head>
<body>
	<h1>新增商品</h1>

	<form action="addProduct" method="POST" enctype="multipart/form-data" >
		
		1.商品名稱:
		<input type="text" name="pName">
		<span style="color:red;font-size: 60%">${errorMsg.pName}</span>
		</P>
		
		2.商品數量:
		<input type="text" name="pNumber"  >
		<span style="color:red;font-size: 60%">${errorMsg.pNumber}</span>
		</p>
		
		3.商品價格:
		<input type="text" name="price">
		<span style="color:red;font-size: 60%">${errorMsg.price}</span>
		</p>
		
		4.商品說明:
		<input type="text" name="pDesc">
		<span style="color:red;font-size: 60%">${errorMsg.pDesc}</span>
		</p>
		
		5.庫存數量:
		<input type="text" name="sNumber" >
		<span style="color:red;font-size: 60%">${errorMsg.sNumber}</span>
		</P>
		
		6.圖片名稱:
		<input type="text" name="iName">
		<span style="color:red;font-size: 60%">${errorMsg.iName}</span>
		</P>
		
		7.商品圖片:
		<input type="file" name="pImage">
		${errorMsg.pImage}
		</P>
		
		<input type="submit" value="新增商品">
	</form>

</body>
</html>