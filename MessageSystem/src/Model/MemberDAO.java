package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

public class MemberDAO {
	Connection conn = null; // 전역변수로
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	MemberDTO dto= null; 
	
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

			String sql = "insert into web_member values(?,?,?,?)";

			// sql->db에 전달
			psmt = conn.prepareStatement(sql);

			// ?에 값 넣어주기 dto로 넣어줄거다
			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getAddress());

			// 실행
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return cnt;
	}

	// *-------로그인-------*
	public MemberDTO login(MemberDTO dto) {
		MemberDTO info = null; // 새로이 주지않으면 무작정 반환이되기때문에 -> 분리시켜준다.
		try {
			DBconn();

			String sql = "select * from web_member where email=? and pw=? ";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			// 굳이 ?

			// 실행
			rs = psmt.executeQuery(); // resultset으로 반환함.

			// rs.next -> 있으면 true / 없으면 false
			if (rs.next()) { // 존재한다면 해당 행을 가져온다.
				String email = rs.getString("email");
				String pw = rs.getString("pw");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				info = new MemberDTO(email, pw, tel, address);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return info;
	}

	// *-------회원정보 수정-------*
	public int update(MemberDTO info) {
		try {
			DBconn();

			String sql = "update web_member set pw=?, tel=?, address=? where email=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, info.getPw());
			psmt.setString(2, info.getTel());
			psmt.setString(3, info.getAddress());
			psmt.setString(4, info.getEmail());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return cnt;

	}

	// *-------회원정보관리 메소드-------*
	public ArrayList<MemberDTO> showMember() {
		//dto객체를 담을 수 있는 arraylist 생성
		ArrayList<MemberDTO> dtoList=new ArrayList<MemberDTO>();
		
		try {
			DBconn();
			String sql= "select email,tel,address from web_member";
			
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			//행이 존재하는 동안은 -> 없으면 false 돼서 끝남.
			while(rs.next()) {
				String email=rs.getString(1);
				String tel=rs.getString(2);
				String address=rs.getString(3);
				
				dto=new MemberDTO(email,tel,address);
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}return dtoList;
		
	}
	

}
