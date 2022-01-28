package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	Connection conn = null; // ����������
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;

	// *-------DB ����-------*
	public void DBconn() {
		// 1. jar ���� ����ְ� class ���� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2, connection ��ü ����
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// *-------DB �ݱ�-------*
	public void DBclose() {
		try {
			// null�� �ƴҶ��� �ݾ��ش�
			if (rs != null) {
				rs.close(); // �� ���� rs�� �������ϸ� ������ �߻��Ѵ�.
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
	
	
	// �Խñ� �� ���� �޼ҵ�
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
