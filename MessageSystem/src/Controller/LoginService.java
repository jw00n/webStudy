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

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======[LoginService]======");
		
		
		request.setCharacterEncoding("utf-8");
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		
		System.out.println("email : "+email+"\npw : "+pw);
		
		MemberDTO dto=new MemberDTO(email, pw); //�̸���, ��й�ȣ�� �Ѱ��ش�.
		
		//login �޼ҵ尡 �ִ� memberDAO ȣ��
		MemberDAO dao=new MemberDAO();
		MemberDTO info= dao.login(dto);	//dto ��ü info ����
		
		//���� ���� ����
		if(info!=null) {
			System.out.println("�α��� ����"); 
			HttpSession session= request.getSession(); //�α��� ������������ ���ǿ� info�Ѱ���.
			session.setAttribute("info", info);
			
		}else {
			System.out.println("�α��� ����");
		}
		//���� ������� ����ȭ������ ������.
		response.sendRedirect("main.jsp");
		
	}

}
