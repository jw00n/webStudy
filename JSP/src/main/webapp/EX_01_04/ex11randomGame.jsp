<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랜덤 당첨 작성</title>
</head>
<body>
<fieldset style="width: 30%; height: 50%">
		<legend>랜덤 당첨 작성</legend>
		<form action="ex11randomResult.jsp">
		<div align="center">
		주제 :<input type="text" name="sub"> 
		<%
		int count=Integer.parseInt(request.getParameter("num"));
		
		for(int i=1; i<=count; i++){%>
		<br>
		아이템 <%=i%>: <input type="text" name="item<%=i%>">
		<%}%>
		<br>
		<input type="submit" value="생성하기">
		<%--bound값이랄까 --%>
		<input type="hidden" value="<%=count %>" name="count">
		</div>
		</form>

	</fieldset>
</body>
</html>