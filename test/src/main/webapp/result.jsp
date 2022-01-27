<%@page import="Model.WeatherDTO"%>
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
WeatherDTO wdto=(WeatherDTO)session.getAttribute("wdto");
%>
<h2>현재 <%=wdto.getLocation() %>의 날씨는</h2>
<span> <%=wdto.getWeather() %> 입니다.</span>
<br>
<span> <%=wdto.getTemperature() %> 입니다.</span>

</body>
</html>