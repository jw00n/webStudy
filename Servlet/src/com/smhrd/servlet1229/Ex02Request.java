package com.smhrd.servlet1229;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex02Request")
public class Ex02Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//response(���� ��ü) : ����ڿ��� ��û ����� �����ٶ� ����ϴ� ��ü
		// ���䵥���� : html�� ���� ����, �̹���, �ؽ�Ʈ,�������� ��
		//������ �̵�( redirect)
		
		//���䵥������ ������ �����ϴ� �޼ҵ�
		// MIME Type : ������ ���� ����
		// ���ڵ� : ��ǻ�Ͱ� �ؼ��� �� �ֵ��� �������� ������ ����(euc-kr/ �� << ��¸���, utf-8) 
		//plain -> �Ϲ� �ؽ�Ʈ  //  /audio Ȯ���� 
		response.setContentType("text/html; charset=utf-8");
		
		//Ŭ���̾�Ʈ���� �����͸� �����ϱ� ���� ��ü ����
		// ����� <-----(������)-----����
		PrintWriter out = response.getWriter();
		
		
		//�����ϸ� �����ð� ���� ���ΰ�ħ�ǹǷ� run ����
		//�ƴϸ� tomcat restart ���
		out.print("<html>");
		out.print("<head><title>response ��ü</title></head>");
		out.print("<body>");
		out.print("<h1>Hello �� ��</h1>");
		out.print("</body>");
		out.print("</html>");
		
		// request url : http://localhost:8080/Servlet/ex01Reuquest?num=123  -> queryString
		//91 ������ -> ����ڰ� ���� requesURL  // requestURI
		
		// URL ����
		
	}

}
