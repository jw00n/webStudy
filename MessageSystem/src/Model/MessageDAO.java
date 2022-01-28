package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MessageDAO {
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

	// *-------메시지 보내기-------*
	public int sendMessage(String sendName, String receiveEmail, String message) {
		try {
			DBconn();
			// 예시 values(num_message.nextval,'admin','smhrd@gmail.com','안내메시지
			// 드립니다.',SYSDATE)

			String sql = "insert into web_message values(num_message.nextval,?,?,?,SYSDATE)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, sendName);
			psmt.setString(2, receiveEmail);
			psmt.setString(3, message);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return cnt;
	}

	// *-------메시지 보여주기-------*
	public ArrayList<MessageDTO> showMessage(String email) {
		ArrayList<MessageDTO> list=new ArrayList<MessageDTO>();
		try {
			DBconn();
			
			String sql="select * from web_message where receiveEmail = ? order by m_date desc";
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, email);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				int num=rs.getInt(1);
				String sendName=rs.getString(2);
				String receiveEmail=rs.getString(3);
				String message=rs.getString(4);
				String m_date=rs.getString(5);
				
				MessageDTO mdto= new MessageDTO(num, sendName, receiveEmail, message, m_date);
				list.add(mdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBclose();
		}return list;
	}

	// *-------메시지 삭제-------*
	public int deleteMessage(String email) {
		try {
			DBconn();
			
			String sql="delete from web_message where receiveEmail = ?";
			psmt=conn.prepareStatement(sql);
			
			psmt.setString(1, email);
			
			cnt=psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBclose();
		}return cnt;
	}

	// *-------메시지  개별 삭제-------*
	public int deleteEachM(String num) {
		try {
			DBconn();
			
			String sql="delete from web_message where num=?";
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, num);
			
			cnt= psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBclose();
		}return cnt;
		
	}
}
