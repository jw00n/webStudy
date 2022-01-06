package com.smhrd.servlet1231;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserInfo")
public class Ex09UserInfo extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      
       // 체크를 중복으로해도 한개의 값만 가져온다.
//      String food = request.getParameter("food");
      
      // checkbox타입의 값을 접근할 때 아래 메소드 활용!
      // or name 속성값이 동일한 여러개의 입력값을 접근할 때 (ex) text입력창-> name이 똑같은 여러개의 값을 가지고 올 경우도 동일하다)
      // 문자열배열로 반환!
      String[] foods = request.getParameterValues("food");
      System.out.println(Arrays.toString(foods)); // Arrays.toString() : 반복문을 쓰지 않고 한번에 배열 출력하기
      
      
      
   }

}