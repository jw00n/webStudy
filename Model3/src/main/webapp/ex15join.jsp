<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		request.setCharacterEncoding("utf-8");

	//id,pw,name, 파라미터 받아오기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");

	Class.forName("oracle.jdbc.driver.OracleDriver");

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbid = "hr";
	String dbpw = "hr";

	Connection conn = DriverManager.getConnection(url, dbid, dbpw);

	String sql = "insert into jdbc_member values(?,?,?)";

	PreparedStatement psmt = conn.prepareCall(sql);

	psmt.setString(1, id);
	psmt.setString(2, pw);
	psmt.setString(3, name);

	int cnt = psmt.executeUpdate();

	//DB 문 닫아주기 -> 순서대로 닫아줘야
	psmt.close();
	conn.close();

	//결과에 따른 이동
	String moveURL=null;
	if (cnt > 0) {
		System.out.println("성공");
		moveURL="ex14login.html";
	}
	else{
		System.out.println("회원가입 실패");
		moveURL="ex15join.html";
	}
		response.sendRedirect(moveURL);
	%>
</body>
</html>