<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>테이블 10개 만들기</h2>
	<table border="1px solid black">
		<tr>
			<%
				// 방법1: 내장객체로 선언언된 out을 이용하여 
			for (int i = 1; i <= 10; i++) {
				out.print("<td>" + i + "</td>");
			}
			%>
		</tr>
		<tr>
			<%
				int ex = 100;
			%>
			<%
				//2번 : for문을 쪼개서 태그처럼 사용하는 방법
			for (int i = 1; i <= 10; i++) {
			%>
			<td><%=i%></td>
			<%
				}
			%>
		</tr>
	</table>
	<%
	//선언문으로 안써도 밖에 변수사용가능하긴 함.
		ex += 1;
	%>
</body>
</html>