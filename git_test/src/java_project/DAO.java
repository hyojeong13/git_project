package java_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	// db와 연결
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

	// 닫기
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

	// 회원가입
	public int insert_m(VO_Member vo_m) {
		int cnt = 0;
		try {
			getConnection();
			String sql = "insert into member values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo_m.getId()); // id
			psmt.setString(2, vo_m.getPw()); // pw
			psmt.setString(3, vo_m.getName()); // name
			psmt.setString(4, vo_m.getPhone()); // 핸드폰
			psmt.setString(5, vo_m.getAddress()); // 주소
			psmt.setString(6, vo_m.getCategory());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	// 로그인

	public int login(String id, String pw) {

		int result = 0;
		try {
			getConnection();
			String sql = "select * from member where id =? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(2).equals(pw)) {
					result = 0; // 아이디가 있고, 비밀번호가 같은 경우 .성공
				} else {
					// 아이디가 같으나 비밀번호가 다른경우. 실패
					result = 1;
				}

			} else {// 아이디가 없는 경우. 실패
				result = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	// 회원정보수정 로그인

	public int update(String id, String pw) {

		int result = 0;
		try {
			getConnection();
			String sql = "select * from member where id =? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(id) && rs.getString(2).equals(pw)) {
					result = 0; // 아이디가 있고, 비밀번호가 같은 경우 .성공
				} else {
					// 아이디가 같으나 비밀번호가 다른경우. 실패
					result = 1;
				}

			} else {// 아이디가 없는 경우. 실패
				result = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	// updateFinal

	public int updateFinal(String pw, String name, String address, String phone,String id) {

		int result = 0;
		try {
			getConnection();
			String sql = "update member set pw =?,name = ?,address = ?,phone = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.setString(2, name);
			psmt.setString(3, address);
			psmt.setString(4, phone);
			psmt.setString(5, id);

			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	// 회원 탈퇴 delete하려면 아이디 기본 4개 이상.

	public int delete(VO_Member vo_m) {
		int cnt = 0;

		try {
			getConnection();
			String sql = "DELETE FROM member WHERE id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo_m.getId());
			psmt.setString(2, vo_m.getPw());

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	//artist table에 값 집어넣기
	public int insert_artist(VO_Artist vo_a) {
		int cnt = 0;
		
		try {
			getConnection();
			String sql = "insert into artist values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo_a.getId());
			psmt.setString(2, vo_a.getName());
			psmt.setString(3, vo_a.getCategory());
			psmt.setString(4, vo_a.getTitle());
			psmt.setString(5, vo_a.getStart_d());
			psmt.setString(6, vo_a.getEnd_d());
			
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	
	// 공간대여 테이블
	   
	   public int place_len(VO_Lender vo_l ) {
	      int cnt = 0;

	      try {
	         getConnection();
	         String sql = "insert into lender values( ?,?,?,?,?)";
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, vo_l.getId());
	         psmt.setString(2, vo_l.getCategory());
	         psmt.setString(3, vo_l.getFav_id());
	         psmt.setString(4, vo_l.getAddress());
	         psmt.setInt(5, vo_l.getGoal());

	         cnt = psmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return cnt;
	   
	      
	   }
	
	
	
	
	
}
