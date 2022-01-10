<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 생성</h1>
	<%
	//세션 객체 생성 -> jsp에서는 객체 생성없이 사용가능하다. < 내장객체>
	//세션에 값 추가
	//(세션이름, 저장할 데이터(object type로 업캐스팅됨))
	session.setAttribute("session1","첫번째세션");
	session.setAttribute("session2",15);
	%>
	
<a href="selectSession.jsp"> 세션확인</a>
</body>
</html>