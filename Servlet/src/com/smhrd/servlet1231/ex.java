package com.smhrd.servlet1231;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ex
 */
@WebServlet("/maketable1") // /�� ���ܳ����Ѵ�.
public class ex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("������ ��û�� ���Դ�.");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// ���ڿ��� �⺻Ÿ���� �ƴ϶� ���� ����ȯ�� �ȵſ�
		// ����ڰ� �Է��� �����͸� ��������!
		int num = Integer.parseInt(request.getParameter("num"));
	
	
		//java.lang.NumberFormatException ���ڿ� �Է��ϸ� �߻��ϴ� ���ܻ���
		out.print("<html><head><title> ���̺� ���� ���</title></head>");
		out.print("<body>");
		out.print("<table border= \"1px solid black\" ><tr>");
		for (int i = 1; i <= num; i++) {
			out.print("<td>"+i+"</td>");
		}
		
		out.print("</tr></table>");
		out.print("</body></html>");
	}

}
