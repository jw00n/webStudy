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

@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("======[UPDATE]======");
	
		request.setCharacterEncoding("utf-8");
		
		String pw=request.getParameter("pw");
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		
		System.out.println("pw : "+pw+"\ntel : "+tel+"\naddress : "+address);
		
		//�α����� �̸��ϰ� ��ġ�ϴ� ������ ��������
		HttpSession session=request.getSession();
		MemberDTO info=(MemberDTO)session.getAttribute("info");
		
		String email=info.getEmail(); //������Ʈ�Ҽ���� �̸� ���ͼ� �����صа�
		
		//info ������ ������ ����� �����
		info=new MemberDTO(email, pw, tel, address);
		
		//db ������Ʈ -> update�޼ҵ� ����ϱ� ���� dao ȣ��
		MemberDAO dao= new MemberDAO();
		int cnt=dao.update(info);
		
		//�������� Ȯ��
		if(cnt>0) {
			System.out.println("������Ʈ ����");
			//������ ������ �ȵǼ� main�� �ȹٲ�����. 
			//���� ����
			session.setAttribute("info", info);
			//�ٲﰪ���� �̸��� ���� �ϸ� ���ſϷ�!
		}else {
			System.out.println("������Ʈ ����");
		}
		
		//������ �������� ��������
		response.sendRedirect("main.jsp");
	}

}
