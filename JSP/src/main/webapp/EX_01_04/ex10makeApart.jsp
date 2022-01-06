<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>건설 완료</title>
</head>
<body>

	<table border="1px solid black">
			<%	
			int floor = Integer.parseInt(request.getParameter("floor"));
			int room = Integer.parseInt(request.getParameter("room"));

			for (int i = 1; i <= floor; i++) {%>
			<tr>
				<%for (int j = 1; j <= room; j++) {%>
				<td><%=i%>0<%=j%>호</td>
				<%}%>
			</tr>
			<%}%>
	</table>
</body>
</html>