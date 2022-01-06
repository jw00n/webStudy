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
	
		//1st. ���ڵ�
		request.setCharacterEncoding("UTF-8");
		
		//2nd. 
		String id=request.getParameter("id");
		//����
		//gender -> radio : ���� �ϳ��� ���޵�.
		String gender=request.getParameter("gender");
		
		//hobby -> üũ�ڽ� : ���� ���� ����. -> �迭�� �޾ƿ�. 
		String[] hobby=request.getParameterValues("hobby");
		//����, String ������ �޾ƿ���ȴ�.
		
		// ------ html������ Ŭ���̾�Ʈ���� ���� -------
		// 1st. Content Type ����.
		response.setContentType("text/html ; charset=utf-8");
		
		//2nd. PrintWriter ��ü ����
		//PrintWriter out= new PrintWriter(System.out)  -> �ܼ�â��  ����ϴ� ���
		PrintWriter out= response.getWriter();
		
		//3rd. ����
		out.print("<html>");
		out.print("<body>");
		
		out.print("<p> ID : "+id+"</p>");
		out.print("<p> gender : "+gender+"</p>");
		out.print("<p> hobby : "+Arrays.toString(hobby)+"</p>");
		//hobby�� �迭�̴ϱ�
		
		out.print("</body>");
		out.print("</html>");
		
		
	}

}
