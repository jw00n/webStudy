package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteCookie")
public class deleteCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��Ű�� ��ȿ�Ⱓ ���� 
		//��� 1
		Cookie cookie4= new Cookie("fourth_cookie", "�׹�°_��Ű");
		//�ҷ����⺸�� ����⿡ �����
		Cookie cookie2= new Cookie("second_cookie", "");
		
//		response.addCookie(cookie2);
//		response.sendRedirect("selectCookie.jsp");
		
		//setMaxAge(������) ��ȿ�Ⱓ -> �� ����
		cookie4.setMaxAge(60*60*24*365);
		
		cookie2.setMaxAge(0);
		
		
		response.addCookie(cookie4);
		response.addCookie(cookie2);
		response.sendRedirect("selectCookie.jsp");
	}

}
