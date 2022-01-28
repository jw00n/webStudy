package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MessageDAO {
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

	// *-------�޽��� ������-------*
	public int sendMessage(String sendName, String receiveEmail, String message) {
		try {
			DBconn();
			// ���� values(num_message.nextval,'admin','smhrd@gmail.com','�ȳ��޽���
			// �帳�ϴ�.',SYSDATE)

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

	// *-------�޽��� �����ֱ�-------*
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

	// *-------�޽��� ����-------*
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

	// *-------�޽���  ���� ����-------*
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
