package java_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_member {

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	
	private void syso() {()???????????????????????????);
			
		

	}
	
	//db와 연결
	private void getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//닫기
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	//회원가입
	public int insert(VO_member vo_m, VO_category vo_c) {
		int cnt = 0;
		try {
			getConnection();
			String sql = "insert into member values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo_m.getId()); //id
			psmt.setString(2, vo_m.getPw()); //pw
			psmt.setString(3, vo_m.getName()); //name
			psmt.setString(4, vo_m.getPhone()); //핸드폰
			psmt.setString(5, vo_m.getAddress()); //주소
			psmt.setString(6, vo_c.getCategory()); //구분
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	
	
	
	
	
	
	
	
	
}
