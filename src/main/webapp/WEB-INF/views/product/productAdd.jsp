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
	

	<form action="addProduct" method="POST">
		
		1.產品名稱:
		<input type="text" name="pName">
		${errorMsg.pName}
		</P>
		
		2.產品數量:
		<input type="text" name="pNumber">
		
		</p>
		
		3.產品價格:
		<input type="text" name="price">
		
		</p>
		
		4.產品說明:
		<input type="text" name="pDesc">
		
		</p>
		
		5.庫存數量:
		<input type="text" name="sNumber">
		
		</P>
		
		6.圖片名稱:
		<input type="text" name="iName">
		
		</P>
		
		7.產品圖片:
		<input type="file" name="pImage">
		
		</P>
		
		<input type="submit" value="新增商品">
	</form>

</body>
</html>