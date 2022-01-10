<%@page import="Model.MemberVO"%>
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
		//로그인 정보가 담긴 session 받아오기
	MemberVO vo = (MemberVO) session.getAttribute("user_info");
	if(vo==null){ //로그인하세요
	%>

	<form action="login" method="POST">
		Id: <input type="text" name="id"> <br> pw: <input
			type="password" name="pw"> <br> <input type="submit"
			value="로그인">
	</form>
	
	<%}else{
	%>
	<h1><%=vo.getNickname()%>님 환영합니다~</h1>
	<a href="LogOutService">로그아웃하기</a>
	<%} %>
</body>
</html>