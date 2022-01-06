<%@page import="java.util.GregorianCalendar"%>
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
		GregorianCalendar gc= new GregorianCalendar(); //인수가 없으면 오늘 날짜를 반환.
		int year=gc.get(gc.YEAR);//연도 가져오기
		int month=1+gc.get(gc.MONTH); //월 가져오기 ->0월부터 시작함.
		int day=gc.get(gc.DATE);
	%>
	
	<h1><%=year %>년<%=month %>월<%=day %>일</h1>
</body>
</html>