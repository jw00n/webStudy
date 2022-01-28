package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MessageDAO;
import Model.MessageDTO;

@WebServlet("/MessageService")
public class MessageService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======[MessageService]======");
		
		request.setCharacterEncoding("utf-8");
		
		String sendName=request.getParameter("sendName");
		String receiveEmail=request.getParameter("receiveEmail");
		String message=request.getParameter("message");
		
		System.out.println("sendName: "+sendName+"\nreceiveEmail: "+receiveEmail+"\nmessage: "+message);
		System.out.println();
		
		MessageDAO mdao=new MessageDAO();
		int cnt=mdao.sendMessage(sendName,receiveEmail,message);
		
		
		if(cnt>0) {
			System.out.println("메시지를 보냈습니다.");
		}else {
			System.out.println("메시지를 보내는 데에 실패했습니다.");
		}
		response.sendRedirect("main.jsp");
		
	}

}
