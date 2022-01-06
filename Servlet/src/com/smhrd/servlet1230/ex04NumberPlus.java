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
		System.out.println("������ ��û�� ���Դ�.");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		
		// ���ڿ��� �⺻Ÿ���� �ƴ϶� ���� ����ȯ�� �ȵſ�
		// ����ڰ� �Է��� �����͸� ��������!
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
	
		//java.lang.NumberFormatException ���ڿ� �Է��ϸ� �߻��ϴ� ���ܻ���
		out.print("<html><head><title> Number Plus ���</title></head>");
		out.print("<body><h1>"+num1+"+"+num2+"=" + (num1+num2) +" </h1> </body></html>");
	}

}


