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
//로그인 실패했는지 구분
//성공하면  -> ex14loginS
//실패하면 ex14loginF

request.setCharacterEncoding("utf-8");

String id= request.getParameter("id");
String pw= request.getParameter("pw");


if(id.equals("smhrd") && pw.equals("123")){
//request객체는 유지되지않아서 생기는 문제 해결하는법
	//데이터를 url에 붙여서 보내는 Query String 방식?
	//url? name=value
	response.sendRedirect("ex14loginS.jsp?id="+id);
}
else{
	response.sendRedirect("ex14loginF.jsp");
}
%>
</body>
</html>