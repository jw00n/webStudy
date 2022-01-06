package com.smhrd.servlet1229;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//url 맵핑 : 문자열로 servlet을 연결하는 기술 
//servlet 파일의 이름과 동일하지 않아도 연결가능
//주의 ) '/'/가 반드시 앞에 작성되어 있어야함. x? -> http404 dhfv q

@WebServlet("/TestWebPage")
public class Ex01Request extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request(요청객체) : 클라이언트가 요청을 했을 때, 사용자의 정보를 저장하는 객체
		// 정보 : IP, 브라우저 정보(버전, 언어, 인코딩 방식 등등..),

		// 사용자 ip 알아내기!

		String ip = request.getRemoteAddr();

		System.out.println("접속한 ip>>>" + ip);
		

		// ip를 확인하여 다른 출력문이 나오도록 구현하시오.
		// 팀원 또는 짝꿍 접속시 00님 환영합니다.
		// 강사 접속 시 : 강사님 환영합니다.
		// 이외 접속 시 : 손님 환영합니디ㅏ.
		// ip확인은 문자열 비교 메소드를 활용할것

		ArrayList<String> iplist = new ArrayList<>();

		iplist.add("121.147.52.44"); // 양민준
		iplist.add("220.93.229.228"); // 김도현
		iplist.add("220.80.165.69");// 허성민
		iplist.add("220.80.165.32"); // 김상태
		boolean flag=false;
		for(int i=0; i<iplist.size(); i++) {
			if (ip.equals(iplist.get(i))) {
			flag=true;
			}
		}
		
		if (flag) {
			System.out.println("팀원입니다.");
		}
		else {
			System.out.println("아닙니다.");
		}

	}

}