<!--  
charset , pageEncoding, charset 
다 똑같아야. 
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
	* 가끔 빨간줄 안없어질때는 다시 작성해볼것. 자체버그임
	1. 스크립트릿
	주석안이여도 먹힘ㅋㅋ
	<% %> 
	html 코드 안에 java코드를 사용할수 있게  지정하는 영역
	-->
	
	<%
		int num1= 10;
		int num2= 15;
		int sum= num1+num2;
	%>  
	
	<!-- 
	2. 표현식
	< %= %>
	자바 코드의 결과물을 출력
	-->
	<h2>두 수의 합은 <%=sum%> 입니다.</h2>



</body>
</html>