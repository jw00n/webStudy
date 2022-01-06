package com.smhrd.servlet1229;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex03Request")
public class Ex03Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String ip = request.getRemoteAddr();
		
		ArrayList<String> iplist = new ArrayList<>();
		iplist.add("121.147.52.44"); // ¾ç¹ÎÁØ
		iplist.add("220.93.229.228"); // ±èµµÇö
		iplist.add("220.80.165.69");// Çã¼º¹Î
		iplist.add("220.80.165.32"); // ±è»óÅÂ
		iplist.add("121.147.52.219"); 
		boolean flag=false;
		for(int i=0; i<iplist.size(); i++) {
			if (ip.equals(iplist.get(i))) {
			flag=true;
			}
		}
		
		out.print("<html>");
		out.print("<head><title>Request & Response ½Ç½À </title></head>");
		out.print("<body>");
		if (flag) {
			out.println("<h1>ÆÀ¿øÀÔ´Ï´Ù.</h1>");
		}
		else {
			out.println("<h1> NAGA </h1>");
		}
		out.print("</body>");
		out.print("</html>");
	}
	

}
