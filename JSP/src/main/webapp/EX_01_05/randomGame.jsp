<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="randomResult.jsp">
		<fieldset align="center">
			<legend>랜덤 당첨 작성</legend>
			<%
			int num=Integer.parseInt(request.getParameter("num"));
			for(int i=1; i<=num; i++){%>
			<br>
			아이템 <%=i%>: <input type="text" name="item">
			<%}%>
			
			<br>
			<input type="submit" value="생성하기">
			
			
		</fieldset>
	</form>
</body>
</html>