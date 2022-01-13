package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

public class MemberDAO {
	Connection conn = null; // ����������
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	MemberDTO dto= null; 
	
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

	// *-------ȸ������-------*
	public int join(MemberDTO dto) {

		try {
			DBconn();

			String sql = "insert into web_member values(?,?,?,?)";

			// sql->db�� ����
			psmt = conn.prepareStatement(sql);

			// ?�� �� �־��ֱ� dto�� �־��ٰŴ�
			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getAddress());

			// ����
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return cnt;
	}

	// *-------�α���-------*
	public MemberDTO login(MemberDTO dto) {
		MemberDTO info = null; // ������ ���������� ������ ��ȯ�̵Ǳ⶧���� -> �и������ش�.
		try {
			DBconn();

			String sql = "select * from web_member where email=? and pw=? ";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			// ���� ?

			// ����
			rs = psmt.executeQuery(); // resultset���� ��ȯ��.

			// rs.next -> ������ true / ������ false
			if (rs.next()) { // �����Ѵٸ� �ش� ���� �����´�.
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

	// *-------ȸ������ ����-------*
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

	// *-------ȸ���������� �޼ҵ�-------*
	public ArrayList<MemberDTO> showMember() {
		//dto��ü�� ���� �� �ִ� arraylist ����
		ArrayList<MemberDTO> dtoList=new ArrayList<MemberDTO>();
		
		try {
			DBconn();
			String sql= "select email,tel,address from web_member";
			
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			//���� �����ϴ� ������ -> ������ false �ż� ����.
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
