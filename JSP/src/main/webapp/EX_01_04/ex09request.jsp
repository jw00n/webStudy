<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>

<%!
public String getDegree(int exp){
	String degree="";
	
	if (exp >= 100)
		degree = "+A";
	else if (exp >= 90)
		degree = "A";
	else if (exp >= 80)
		degree = "B";
	else if (exp >= 70)
		degree = "C";
	else
		degree = "D";
	
	return degree;
}
%>
	<%
	request.setCharacterEncoding("utf-8"); //인코딩
	
	String day= request.getParameter("today");
	String name = request.getParameter("name");
	int javaScore = Integer.parseInt(request.getParameter("java"));
	int pythonScore = Integer.parseInt(request.getParameter("python"));
	int WebScore = Integer.parseInt(request.getParameter("web"));
	int MLScore = Integer.parseInt(request.getParameter("ml"));

	int exp = (javaScore + pythonScore + WebScore + MLScore) / 4;
	String degree=getDegree(exp);
	%>

	<fieldset style="width: 250px; height: 200px">
		<legend>학점 확인 프로그램</legend>
		<form method="post">
			<table>
				<tr>
					<td>이름</td>
					<td><%=name%></td>
				</tr>
				<tr>
					<td>Java 점수</td>
					<td><%=javaScore%></td>
				</tr>
				<tr>
					<td>Python 점수</td>
					<td><%=pythonScore%></td>
				</tr>
				<tr>
					<td>Web 점수</td>
					<td><%=WebScore%></td>
				</tr>
				<tr>
					<td>Machine Learning 점수</td>
					<td><%=MLScore%></td>
				</tr>
				<tr>
					<td>평균</td>
					<td><%=exp%></td>
				</tr>
				<tr>
					<td>학점</td>
					<td style="font-weight: bold;"><%=degree%></td>
				</tr>
			</table>

		</form>
<%=day %>
	</fieldset>
</body>
</html>