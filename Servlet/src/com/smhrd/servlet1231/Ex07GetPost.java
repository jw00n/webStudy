package com.smhrd.servlet1231;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetPost")
public class Ex07GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//POST����϶� �ѱ۱��� ����
		req.setCharacterEncoding("UTF-8");
		
		System.out.println("��û�� ����..");
		
		//����ڰ� �Է��� ID�� Pw�� ������ ������ �� �ܼ�â�� ����غ���
		String id = req.getParameter("user-id");
		String pw = req.getParameter("user-pw");
		
		System.out.println(id+"  /  "+pw);
		
	}
    
   

	
}
