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

		// 1. post방식 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 저장할 경로 file_img
		// 서블릿은 webcontent내에서 실행됨 -> ""가 비어있다면 = 절대경로라는
		String savePath = request.getServletContext().getRealPath("file_img");
		System.out.println(savePath);
		
		//3. 사이즈(이미지 크기)
		int maxsize=10*1024*1024;
		
		//4. 인코딩 방식
		String encoding="UTF-8";
		
		//5. 파일명 중복제거 
		DefaultFileRenamePolicy norepeat= new DefaultFileRenamePolicy();
		
		
		// new Multipart (request, 저장할 경로, 사이즈, 인코딩방식, 파일명 중복제거)
		//
		MultipartRequest multi=new MultipartRequest(request, savePath,maxsize,encoding,norepeat);
		
		
		//DB에 저장하기 위해 multi 객체에서 꺼내오기
		String title=multi.getParameter("title");
		String writer=multi.getParameter("writer");
		String content=multi.getParameter("content");
		//한글이름으로 된 파일이름까지 얻기위해 인코딩
		String filename= URLEncoder.encode(multi.getFilesystemName("filename"),"UTF-8");
		
		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);
		System.out.println(filename);
		
		
		BoardDAO dao=new BoardDAO();
		int cnt=dao.upload(new BoardDTO(title, writer, filename, content));
		
		if(cnt>0) {
			System.out.println("게시물 등록");
		}else {
			System.out.println("실패");
		}response.sendRedirect("boardMain.jsp");
	}

}
