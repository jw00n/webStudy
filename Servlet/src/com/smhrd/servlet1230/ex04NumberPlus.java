package com.smhrd.servlet1230;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NumberPlus")
public class ex04NumberPlus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서버에 요청이 들어왔다.");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		
		// 문자열은 기본타입이 아니라 강제 형변환이 안돼용
		// 사용자가 입력한 데이터를 가져오기!
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
	
		//java.lang.NumberFormatException 문자열 입력하면 발생하는 예외사항
		out.print("<html><head><title> Number Plus 결과</title></head>");
		out.print("<body><h1>"+num1+"+"+num2+"=" + (num1+num2) +" </h1> </body></html>");
	}

}


