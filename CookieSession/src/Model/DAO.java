package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import 단축키 ctrl shift O

public class DAO {
	Connection conn = null; // 전역변수로
	PreparedStatement psmt = null;
	ResultSet rs = null;

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
			//null이 아닐때만 닫아준다 
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

	// *-------로그인 메소드-------*
	public MemberVO login(String id, String pw) {
		// 로그인 성공여부 판단
		MemberVO vo = null; // 처음엔 null로
		try {
			DBconn(); // 연결
			// 3. sql 문 작성
			String sql = "select * from jdbc_member where id =? and pw=?";
			// 4. 실행준비
			psmt = conn.prepareCall(sql);

			// 5. ? (바인드변수) 채우기
			psmt.setString(1, id);
			psmt.setString(2, pw);

			// 6. 실행 -> insert update delete: executeUpdate() -> int형으로 몇 줄 성공했는지 리턴
			// select -> executeQuery() -> ResultSet을 리턴
			rs = psmt.executeQuery();

			// 7.성공 여부 판단
			// rs.next() -> 커서를 한칸내리고 값의 여부를 리턴
			// rs.next() == true ==> 해당하는 값이 있다.
			String nickname = null;

			if (rs.next()) {
				// DB에서 불러오기
				String uid = rs.getString(1);
				String upw = rs.getString(2);
				nickname = rs.getString("nickname");
				// String nicknam2 = rs.getString("3"); //인덱스로 불러올수있음

				// 결과를 membeVo에 묶어주기
				vo = new MemberVO(uid, upw, nickname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//무조건
		finally {
			// DB 문 닫아주기 -> 순서대로 닫아줘야
			DBclose();
		}
		return vo;
	}

	// *-------회원가입 메소드-------*
	public int join(String id, String pw, String name) {
		int cnt = 0;
		try {
			DBconn();
			String sql = "insert into jdbc_member values(?,?,?)";

			psmt = conn.prepareCall(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);

			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			// 예외사항은 전부 하나로 처리
			e.printStackTrace();
		}	
		//무조건
		finally {
			// DB 문 닫아주기 -> 순서대로 닫아줘야
			DBclose();
		}
		return cnt;
	}

}
