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
	

	
	
	//db�� ����
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
	
	//�ݱ�
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
	
	
	//ȸ������
	public int insert_m(VO_Member vo_m) {
		int cnt = 0;
		try {
			getConnection();
			String sql = "insert into member values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo_m.getId()); //id
			psmt.setString(2, vo_m.getPw()); //pw
			psmt.setString(3, vo_m.getName()); //name
			psmt.setString(4, vo_m.getPhone()); //�ڵ���
			psmt.setString(5, vo_m.getAddress()); //�ּ�
			psmt.setString(6, vo_m.getCategory());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	
	//�α���
	
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
					result = 0; // ���̵� �ְ�, ��й�ȣ�� ���� ��� .����
				} else {
					// ���̵� ������ ��й�ȣ�� �ٸ����. ����
					result = 1;
				}

			} else {// ���̵� ���� ���. ����
				result = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	
	//ȸ�� Ż��
	
	public int delete(VO_Member vo_m) {
		int cnt = 0;

		try {
			getConnection();
			String sql = "DELETE FROM MEMBER WHERE id = ? and pw = ?";
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
	
	
	
	

	
	
	
}
