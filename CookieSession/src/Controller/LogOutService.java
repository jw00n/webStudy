package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogOutService")
public class LogOutService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//이건ㄷ 다시 만들어봐야겠군
		
		//로그아웃 -> 로그인 정보가 담긴 session(user_info)
		//로그아웃 -> 세션 삭제
		HttpSession session=request.getSession();
		session.removeAttribute("user_info");
//		session.invalidate();//모든 세션을 삭제
		
		System.out.println("로그아웃 성공");
		response.sendRedirect("ex14login.jsp");
	
	}

}
