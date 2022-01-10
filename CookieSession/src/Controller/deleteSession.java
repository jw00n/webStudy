package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteSession")
public class deleteSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//技记 昏力
		
	//技记 按眉 积己
		HttpSession session= request.getSession();
		
		//つさ记 窍唱 昏力
		 session.removeAttribute("session1");
		 response.sendRedirect("selectSession.jsp");
	}

}
