package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	Connection conn = null; // ����������
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt=0;

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
			 
			 String sql= "insert into web_member values(?,?,?,?)";
			 
			 //sql->db�� ����
			 psmt=conn.prepareStatement(sql);
			 
			 //?�� �� �־��ֱ� dto�� �־��ٰŴ�
			 psmt.setString(1, dto.getEmail());
			 psmt.setString(2, dto.getPw());
			 psmt.setString(3, dto.getTel());
			 psmt.setString(4, dto.getAddress());
			 
			 //����
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