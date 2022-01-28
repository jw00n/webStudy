<%@page import="Model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <title>Forty by HTML5 UP</title>
      <meta charset="utf-8" />
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
      <link rel="stylesheet" href="assetsBoard/css/main.css" />
      <link rel="stylesheet" href="assetsBoard/css/board.css" />
      <!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
      <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
      
</head>
<body>   

<%
BoardDAO dao=new BoardDAO();
ArrayList<BoardDTO> b_list=dao.showBoard();
%>
         <div id="board">
            <table id = "list">
               <tr>
                  <td>번호</td>
                  <td>제목</td>
                  <td>작성자</td>
                  <td>시간</td>
               </tr>
               
               <% for(int i=0; i<b_list.size();i++){ %>
               <tr>
                  <td><%=i+1 %></td>
                  <td><a href="viewBoard.jsp?num<%=b_list.get(i).getNum()%>"><%=b_list.get(i).getTitle() %></a></td>
                  <td><%=b_list.get(i).getWriter()%></td>
                  <td><%=b_list.get(i).getB_date() %></td>
               </tr>
				<%} %>               
               
            </table>
            
            <a href="main.jsp"><button id="writer">홈으로가기</button></a>
            <a href="writerBoard.jsp"><button id="writer">작성하러가기</button></a>
         </div>


         <!-- Scripts -->
         <script src="assets/js/jquery.min.js"></script>
         <script src="assets/js/jquery.scrolly.min.js"></script>
         <script src="assets/js/jquery.scrollex.min.js"></script>
         <script src="assets/js/skel.min.js"></script>
         <script src="assets/js/util.js"></script>
         <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
         <script src="assets/js/main.js"></script>
</body>
</html>