package com.smhrd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

	public void login() {
		//로그인 성공여부 판단
		try {
			//1. 	jar 파일 집어넣고 class 동적 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2, connection 객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);

			//3. sql 문 작성

			String sql = "select * from jdbc_member where id =? and pw=?";
			//4. 실행준비
			PreparedStatement psmt = conn.prepareCall(sql);

			//5. ? (바인드변수) 채우기

			psmt.setString(1, id);
			psmt.setString(2, pw);

			//6. 실행 -> insert update delete: executeUpdate() -> int형으로 몇 줄 성공했는지 리턴
			//select -> executeQuery() -> ResultSet을 리턴
			ResultSet rs = psmt.executeQuery();

			//7.성공 여부 판단
			//rs.next() -> 커서를 한칸내리고 값의 여부를 리턴
			//rs.next() == true ==> 해당하는 값이 있다.
			String nickname = null;
			if (rs.next()) {
				nickname = rs.getString("nickname");
				//String nicknam2 = rs.getString("3"); //인덱스로 불러올수있음

			}

			//DB 문 닫아주기 -> 순서대로 닫아줘야
			rs.close();
			psmt.close();
			conn.close();

		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
