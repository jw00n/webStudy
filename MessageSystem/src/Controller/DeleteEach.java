package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MessageDAO;

@WebServlet("/DeleteEach")
public class DeleteEach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======[DELETE EACH MESSAGE ]======");
		
		String num=request.getParameter("num");
		MessageDAO mdao=new MessageDAO();
		int cnt=mdao.deleteEachM(num);
		
		if(cnt>0) {
			System.out.println("개별삭제 성공");
		}else {
			System.out.println("개별삭제 실패");
		}
		
		response.sendRedirect("main.jsp");
	}

	
}
