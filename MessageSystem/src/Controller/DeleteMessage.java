package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Model.MemberDTO;
import Model.MessageDAO;

@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======[DELETE MESSAGE]======");
		
		//로그인 정보 불러오기
		HttpSession session=request.getSession();
		MemberDTO dto=(MemberDTO)session.getAttribute("info");
		
		MessageDAO dao=new MessageDAO();
		int cnt=dao.deleteMessage(dto.getEmail());
		
		if(cnt>0) {
			System.out.println("메세지 삭제 성공");
		}else {
			System.out.println("메세지 삭제 실패");
		}
		
		response.sendRedirect("main.jsp");
	}
}
