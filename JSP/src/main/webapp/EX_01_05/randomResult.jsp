<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset align="center">
		<legend>랜덤 당첨 결과</legend>
		<%
		String subject=request.getParameter("sub");
		String[] items=request.getParameterValues("item");
		//오오 한꺼번에 받아올수있구나 
		Random rd=new Random();
		int randNum=rd.nextInt(items.length)+1;
		
		%>
		<div align="center">
		<p>주제: <%=subject%></p>
		<p>결과: <%=items[randNum]%>
		</div>
		</fieldset>
</body>
</html>