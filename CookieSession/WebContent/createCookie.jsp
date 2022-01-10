<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 쿠키 생성 </h1>
<%

//1. 쿠키 객체 생성 
//new Cookie("쿠키이름","쿠키 값(데이터)") //String 타입만 받음.
Cookie cookie1 =new Cookie("first_cookie","첫번째쿠키생성");

//오류원인 -> 쿠키는 순수 text >> 특수기호(%,'',콤마, 공백등을 사용할수 없다.
//Cookie cookie2= new Cookie("second_cookie","두번째 쿠키생성");
Cookie cookie2= new Cookie("second_cookie",URLEncoder.encode("두번째 쿠키생성","utf-8"));//이렇게하면 공백이  + 로 바뀐다.
Cookie cookie3= new Cookie("third_cookie","세번째+쿠키+생성");


//응답에 쿠키를 주기
//addCookie(쿠키객체)
response.addCookie(cookie1);
response.addCookie(cookie2);
response.addCookie(cookie3);

%>

<a href="selectCookie.jsp">쿠키확인</a>


</body>
</html>