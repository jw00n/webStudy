package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	Connection conn = null; // 전역변수로
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;

	// *-------DB 연결-------*
	public void DBconn() {
		// 1. jar 파일 집어넣고 class 동적 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2, connection 객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// *-------DB 닫기-------*
	public void DBclose() {
		try {
			// null이 아닐때만 닫아준다
			if (rs != null) {
				rs.close(); // 안 열린 rs를 닫으라하면 오류가 발생한다.
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
		}
	}

	public int upload(BoardDTO dto) {
		try {
			DBconn();
			String sql = "insert into web_board values(num_board.nextval,?,?,?,?,sysdate)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getWriter());
			psmt.setString(3, dto.getFilename());
			psmt.setString(4, dto.getContent());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return cnt;
	}

	public ArrayList<BoardDTO> showBoard() {
		ArrayList<BoardDTO> list=new ArrayList<BoardDTO>();
		try {
			DBconn();
			String sql="select * from web_board order by b_date desc";
			
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			while (rs.next()) {
				int num=rs.getInt(1);
				String title=rs.getString(2);
				String writer=rs.getString(3);
				String filename=rs.getString(4);
				String content=rs.getString(5);
				String b_date=rs.getString(6);
				
				BoardDTO dto=new BoardDTO(num,title,writer,filename,content,b_date);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBclose();
		}return list;
	}
	
	
	// 게시글 상세 내용 메소드
	   public BoardDTO selectOne(int choice) {

	      BoardDTO dto = null;

	      DBconn();

	      String sql = "select * from web_board where num = ?";

	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setInt(1, choice);

	         rs = psmt.executeQuery();
	         if (rs.next()) {
	            int num = rs.getInt(1);
	            String title = rs.getString(2);
	            String writer = rs.getString(3);
	            String filename = rs.getString(4);
	            String content = rs.getString(5);
	            String b_date = rs.getString(6);

	            dto = new BoardDTO(num, title, writer, filename, content, b_date);
	         }

	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         DBclose();
	      }
	      return dto;

	   }
}
