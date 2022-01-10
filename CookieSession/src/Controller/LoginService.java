package Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberVO;
import Model.DAO;

@WebServlet("/login")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//로그인 실패했는지 구분
	//성공하면  -> ex14loginS
	//실패하면 ex14loginF

	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	DAO dao = new DAO();
	MemberVO vo = dao.login(id, pw);

	//성공 or 실패에 따른 페이지 이동
	if (vo != null) {
		System.out.println("로그인성공");
		
		//로그인 성공시 세션으로 id값 보내기
		HttpSession session= request.getSession();
		session.setAttribute("user_info", vo); //로그인이 성공했을때 정보 넘겨줌.
		response.sendRedirect("ex14login.jsp");
	} else {
		//null
		System.out.print("로그인 실패");
		response.sendRedirect("ex14loginF.jsp");
	}
	
	}

}
