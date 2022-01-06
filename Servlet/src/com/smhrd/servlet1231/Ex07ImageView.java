package com.smhrd.servlet1231;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageView")
public class Ex07ImageView extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      response.setContentType("text/html; charset = utf-8");
      PrintWriter out = response.getWriter();
      
      int num = Integer.parseInt(request.getParameter("num"));
      
      String src = "";
      
      if(num == 1) {
         src = "img/img.jpg";
      }else if(num == 2) {
         src = "img/img2.jpg";
      }else if(num == 3) {
         src = "img/img3.jpg";
      }
      
      out.print("<html>");
      out.print("<head><title>도너츠 고르기</title></head>");
      out.print("<body>");
      
      out.print("<img src = '"+src+"' alt = '해당 이미지를 불러올 수 없습니다.'>");
      // alt -> 이미지가 없다면 "이미지가 존재하지 않습니다."를 출력하기 위한 것
      
      out.print("</body>");
      out.print("</html>");
      
   }

}