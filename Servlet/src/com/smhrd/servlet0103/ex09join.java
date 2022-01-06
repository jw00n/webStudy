package com.smhrd.servlet0103;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinService")
public class ex09join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1st. 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//2nd. 
		String id=request.getParameter("id");
		//생략
		//gender -> radio : 값이 하나만 전달됨.
		String gender=request.getParameter("gender");
		
		//hobby -> 체크박스 : 여러 값을 가짐. -> 배열로 받아옴. 
		String[] hobby=request.getParameterValues("hobby");
		//이하, String 변수로 받아오면된다.
		
		// ------ html문서로 클라이언트에게 응답 -------
		// 1st. Content Type 지정.
		response.setContentType("text/html ; charset=utf-8");
		
		//2nd. PrintWriter 객체 생성
		//PrintWriter out= new PrintWriter(System.out)  -> 콘솔창에  출력하는 경우
		PrintWriter out= response.getWriter();
		
		//3rd. 응답
		out.print("<html>");
		out.print("<body>");
		
		out.print("<p> ID : "+id+"</p>");
		out.print("<p> gender : "+gender+"</p>");
		out.print("<p> hobby : "+Arrays.toString(hobby)+"</p>");
		//hobby는 배열이니깐
		
		out.print("</body>");
		out.print("</html>");
		
		
	}

}
