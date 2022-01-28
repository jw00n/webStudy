package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WeatherDAO {
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

	public RecipeDTO choice(String type) {
		DBconn();
		
		RecipeDTO rDto=null;
		try {
			
			String sql="select * from test_recipe where food_type=?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, type);
			 rs = psmt.executeQuery();
	         if (rs.next()) {
	        	 int num=rs.getInt(1);
	        	 String recipe_name=rs.getString(2);
	        	 String food_type=rs.getString(3);
	        	 String recipe_weather=rs.getString(4);
	        	 int recipe_calory=rs.getInt(5);
	        	 String recipe_date=rs.getString(6);
	        	 float carbohydrate =rs.getFloat(7);  
	        	 float protein=rs.getFloat(8);
	        	 float fat=rs.getFloat(9);
	        	 float calcium=rs.getFloat(10);
	        	 float sodium=rs.getFloat(11);      
	        	 
	        	 
	        	 rDto=new RecipeDTO(num, recipe_name, food_type, recipe_weather, 
	        			 recipe_calory, recipe_date, carbohydrate, protein, fat, calcium, sodium);
	        			 
	         }
	         
			
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			DBclose();
		}return rDto;
	}
}
