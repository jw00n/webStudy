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
		//POST방식일때 한글깨짐 방지
		req.setCharacterEncoding("UTF-8");
		
		System.out.println("요청이 들어옴..");
		
		//사용자가 입력한 ID와 Pw를 변수에 저장한 후 콘솔창에 출력해보기
		String id = req.getParameter("user-id");
		String pw = req.getParameter("user-pw");
		
		System.out.println(id+"  /  "+pw);
		
	}
    
   

	
}
