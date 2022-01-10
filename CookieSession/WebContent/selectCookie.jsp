<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키조회</h1>
	<%
		//1. 쿠키 가져오기
	//2. 단, 전부 가져오기만 가능.
	Cookie[] cookies = request.getCookies();

	//for each문
	//for i in list:
	//자료형은 알맞게
	for (Cookie c : cookies) {

		//불필요한 쿠키 제외
		//쿠키라는 문자열을 포함하고 있다면 출력하는 if문을 걸어준다.
		if (c.getName().contains("cookie")) {

			// 쿠키의 값 가져오기
			//인코딩 된 값을 디코딩
			String value = URLDecoder.decode(c.getValue(), "utf-8");

			// 쿠키의 이름 가져오기
			String name = c.getName();

			out.print(name + " : " + value + "<br>");
			
		}
	}
	%>
	<a href="deleteCookie">쿠키 삭제</a>
	
</body>
</html>