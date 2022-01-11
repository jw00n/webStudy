package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutService")
public class LogoutService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======[LOG OUT]======");
		
		//로그아웃 -> 정보가 담긴 세션을 삭제
		HttpSession session=request.getSession();
		session.removeAttribute("info"); //삭제할  세션 이름.
		
		System.out.println("로그아웃 완료");
		response.sendRedirect("main.jsp");
		
		
	}
}
