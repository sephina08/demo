<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="base/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Demo project</title>
</head>
<body>
<h1>This is index page</h1>
<c:out value="if you wanna use jstl, just pay attention on the second line in index.jsp"/> <br>
<c:out value="<%@ include file='base/common.jsp' %>"/> <br>
<c:out value="Make sure this statement in your jsp's top"/> <br>
<c:out value="Note that the value of file attribute is correct or not"/> <br>
</body>
</html>