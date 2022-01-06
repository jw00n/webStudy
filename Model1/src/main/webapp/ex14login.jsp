<%@page import="com.smhrd.model.MemberVO"%>
<%@page import="com.smhrd.model.DAO"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	DAO dao = new DAO();
	MemberVO vo = dao.login(id, pw);

	//성공 or 실패에 따른 페이지 이동
	if (vo != null) {
		System.out.print("로그인성공");
		response.sendRedirect("ex14loginS.jsp?nickname=" + URLEncoder.encode(vo.getNickname(), "utf-8"));
	} else {
		//null
		System.out.print("로그인 실패");
		response.sendRedirect("ex14loginF.jsp");
	}
	%>
</body>
</html>