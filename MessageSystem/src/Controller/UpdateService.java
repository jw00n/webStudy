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
		
		//로그인한 이메일과 일치하는 계정만 정보변경
		HttpSession session=request.getSession();
		MemberDTO info=(MemberDTO)session.getAttribute("info");
		
		String email=info.getEmail(); //업데이트할수없어서 미리 빼와서 저장해둔것
		
		//info 변수에 수정된 값들로 덮어쓰기
		info=new MemberDTO(email, pw, tel, address);
		
		//db 업데이트 -> update메소드 사용하기 위해 dao 호출
		MemberDAO dao= new MemberDAO();
		int cnt=dao.update(info);
		
		//성공여부 확인
		if(cnt>0) {
			System.out.println("업데이트 성공");
			//세션이 갱신이 안되서 main도 안바껴있음. 
			//세션 갱신
			session.setAttribute("info", info);
			//바뀐값으로 이름만 같게 하면 갱신완료!
		}else {
			System.out.println("업데이트 실패");
		}
		
		//무조건 메인으로 보내버림
		response.sendRedirect("main.jsp");
	}

}
