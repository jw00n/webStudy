<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랜덤 생성결과</title>
</head>
<body>
	<fieldset style="width: 25%; height: 25%">
		<legend>랜덤 당첨 결과</legend>
		<%
		String subject=request.getParameter("sub");
		int count=Integer.parseInt(request.getParameter("count"));
		
		Random rd=new Random();
		int randNum=rd.nextInt(count)+1;
		String randItem=request.getParameter("item"+randNum);
		%>
		<div align="center">
		<p>주제: <%=subject%></p>
		<p>결과: <%=randItem%>
		</div>
		</fieldset>
</body>
</html>