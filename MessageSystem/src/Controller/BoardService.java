package Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Model.BoardDAO;
import Model.BoardDTO;

@WebServlet("/BoardService")
public class BoardService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("boardService");

		// title , writer filename text

		// 1. post��� ���ڵ�
		request.setCharacterEncoding("UTF-8");
		
		// 2. ������ ��� file_img
		// ������ webcontent������ ����� -> ""�� ����ִٸ� = �����ζ��
		String savePath = request.getServletContext().getRealPath("file_img");
		System.out.println(savePath);
		
		//3. ������(�̹��� ũ��)
		int maxsize=10*1024*1024;
		
		//4. ���ڵ� ���
		String encoding="UTF-8";
		
		//5. ���ϸ� �ߺ����� 
		DefaultFileRenamePolicy norepeat= new DefaultFileRenamePolicy();
		
		
		// new Multipart (request, ������ ���, ������, ���ڵ����, ���ϸ� �ߺ�����)
		//
		MultipartRequest multi=new MultipartRequest(request, savePath,maxsize,encoding,norepeat);
		
		
		//DB�� �����ϱ� ���� multi ��ü���� ��������
		String title=multi.getParameter("title");
		String writer=multi.getParameter("writer");
		String content=multi.getParameter("content");
		//�ѱ��̸����� �� �����̸����� ������� ���ڵ�
		String filename= URLEncoder.encode(multi.getFilesystemName("filename"),"UTF-8");
		
		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);
		System.out.println(filename);
		
		
		BoardDAO dao=new BoardDAO();
		int cnt=dao.upload(new BoardDTO(title, writer, filename, content));
		
		if(cnt>0) {
			System.out.println("�Խù� ���");
		}else {
			System.out.println("����");
		}response.sendRedirect("boardMain.jsp");
	}

}
