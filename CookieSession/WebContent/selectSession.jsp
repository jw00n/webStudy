<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 조회</h1>
	<%
		String value1 = (String) session.getAttribute("session1");
	//여기서 nullpoint error -> int는 null이 들어갈수없기때문에
	//Integer를 사용한다.
	Integer value2 = (Integer) session.getAttribute("session2");

	out.print(value1 + "<br>");
	out.print(value2 + "<br>");
	%>
	<a href="deleteSession">세션 삭제</a>
	<br>
	<a href="deleteAllSession">세션 전체 삭제</a>


</body>
</html>





