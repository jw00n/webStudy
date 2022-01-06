package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// id,pw,name, 파라미터 받아오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");

		DAO dao = new DAO();
		int cnt = dao.join(id, pw, name);

		// 결과에 따른 이동
		String moveURL = null;
		if (cnt > 0) {
			System.out.println("성공");
			response.sendRedirect("ex14login.html");
		} else {
			System.out.println("회원가입 실패");
			response.sendRedirect("ex15join.html");
		}
		

	}

}
