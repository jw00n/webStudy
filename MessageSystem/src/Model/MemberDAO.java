package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	Connection conn = null; // 전역변수로
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt=0;

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

	// *-------회원가입-------*
	public int join(MemberDTO dto) {
		 
		try {
			 DBconn();
			 
			 String sql= "insert into web_member values(?,?,?,?)";
			 
			 //sql->db에 전달
			 psmt=conn.prepareStatement(sql);
			 
			 //?에 값 넣어주기 dto로 넣어줄거다
			 psmt.setString(1, dto.getEmail());
			 psmt.setString(2, dto.getPw());
			 psmt.setString(3, dto.getTel());
			 psmt.setString(4, dto.getAddress());
			 
			 //실행
			cnt=psmt.executeUpdate();

			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBclose();
		}
		return cnt;
	}
}
