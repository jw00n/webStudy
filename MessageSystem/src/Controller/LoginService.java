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
		
		MemberDTO dto=new MemberDTO(email, pw); //이메일, 비밀번호만 넘겨준다.
		
		//login 메소드가 있는 memberDAO 호출
		MemberDAO dao=new MemberDAO();
		MemberDTO info= dao.login(dto);	//dto 객체 info 생성
		
		//성공 실패 여부
		if(info!=null) {
			System.out.println("로그인 성공"); 
			HttpSession session= request.getSession(); //로그인 성공했을때만 세션에 info넘겨줌.
			session.setAttribute("info", info);
			
		}else {
			System.out.println("로그인 실패");
		}
		//여부 관계없이 메인화면으로 보내줌.
		response.sendRedirect("main.jsp");
		
	}

}
