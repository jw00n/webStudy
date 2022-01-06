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
		String url = request.getParameter("url");
	
		if (url.equals("네이버")) {
			response.sendRedirect("https://naver.com");
		} else if (url.equals("구글")) {
			response.sendRedirect("https://www.google.co.kr/");
		} else {
			response.sendRedirect("https://www.youtube.com/");
		}
	%>
</body>
</html>