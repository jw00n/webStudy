package com.smhrd.servlet1230;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DataSend")
public class Ex04DataSend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서버에 요청이 들어왔다.");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 사용자가 입력한 데이터를 가져오기!
		String data = request.getParameter("data");
		System.out.println(data);

		out.print("<html><head><title>응답결과</title></head>");
		out.print("<body>서버에서 보낸값: " + data + "</body></html>");


	}

}
