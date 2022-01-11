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

		// 1. post방식 인코딩
		request.setCharacterEncoding("UTF-8");

		// 2. 데이터 가져오기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDTO dto=new MemberDTO(email, pw, tel, address);
		//확인용
		System.out.println(email+"\n"+pw+"\n"+tel+"\n"+address);
		
		//3. db에 값 넣기
		MemberDAO dao=new MemberDAO();
		int cnt=dao.join(dto);
		
		//4. 실행 결과에 따라 다른 페이지 출력하기
		if(cnt>0) {
			System.out.println("회원가입 성공");
			
			//로그인 정보를 넘겨주기 위해 세션을 넘겨준다.
			HttpSession session = request.getSession();
			session.setAttribute("email", dto.getEmail());
			response.sendRedirect("join_success.jsp");
		}else {
			System.out.println("회원가입 실패");
			response.sendRedirect("main.jsp");
		}
		
		
	}
}
