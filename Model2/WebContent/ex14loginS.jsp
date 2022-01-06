<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String id=request.getParameter("nickname");
%>
<fieldset>
<h1> <%= id %> 로그인 성공</h1>

</fieldset>
</body>
</html>