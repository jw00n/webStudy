package com.smhrd.servlet1229;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex02Request")
public class Ex02Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//response(응답 객체) : 사용자에게 요청 결과를 보내줄때 사용하는 객체
		// 응답데이터 : html과 같은 문서, 이미지, 텍스트,파일형태 등
		//페이지 이동( redirect)
		
		//응답데이터의 포맷을 설정하는 메소드
		// MIME Type : 데이터 포맷 설정
		// 인코딩 : 컴퓨터가 해석할 수 있도록 데이터의 형식을 지정(euc-kr/ 햬 << 출력못함, utf-8) 
		//plain -> 일반 텍스트  //  /audio 확장자 
		response.setContentType("text/html; charset=utf-8");
		
		//클라이언트에게 데이터를 전달하기 위한 객체 생성
		// 사용자 <-----(데이터)-----서버
		PrintWriter out = response.getWriter();
		
		
		//저장하면 일정시간 이후 새로고침되므로 run 자제
		//아니면 tomcat restart 사용
		out.print("<html>");
		out.print("<head><title>response 객체</title></head>");
		out.print("<body>");
		out.print("<h1>Hello 해 햬</h1>");
		out.print("</body>");
		out.print("</html>");
		
		// request url : http://localhost:8080/Servlet/ex01Reuquest?num=123  -> queryString
		//91 페이지 -> 사용자가 보낸 requesURL  // requestURI
		
		// URL 맵핑
		
	}

}
