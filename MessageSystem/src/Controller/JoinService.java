package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberDTO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("======[JoinService]======");

		// 1. post��� ���ڵ�
		request.setCharacterEncoding("UTF-8");

		// 2. ������ ��������
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDTO dto=new MemberDTO(email, pw, tel, address);
		//Ȯ�ο�
		System.out.println(email+"\n"+pw+"\n"+tel+"\n"+address);
		
		//3. db�� �� �ֱ�
		MemberDAO dao=new MemberDAO();
		int cnt=dao.join(dto);
		
		//4. ���� ����� ���� �ٸ� ������ ����ϱ�
		if(cnt>0) {
			System.out.println("ȸ������ ����");
			
			//�α��� ������ �Ѱ��ֱ� ���� ������ �Ѱ��ش�.
			HttpSession session = request.getSession();
			session.setAttribute("email", dto.getEmail());
			response.sendRedirect("join_success.jsp");
		}else {
			System.out.println("ȸ������ ����");
			response.sendRedirect("main.jsp");
		}
		
		
	}
}
