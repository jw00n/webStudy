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
	//�̰Ǥ� �ٽ� �������߰ڱ�
		
		//�α׾ƿ� -> �α��� ������ ��� session(user_info)
		//�α׾ƿ� -> ���� ����
		HttpSession session=request.getSession();
		session.removeAttribute("user_info");
//		session.invalidate();//��� ������ ����
		
		System.out.println("�α׾ƿ� ����");
		response.sendRedirect("ex14login.jsp");
	
	}

}
