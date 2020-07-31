package java_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	

	// db�� ����.
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

	// �ݱ�
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

	// ȸ������
	public int insert_m(VO_Member vo_m) {
		int cnt = 0;
		try {
			getConnection();
			String sql = "insert into member values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo_m.getId()); // id
			psmt.setString(2, vo_m.getPw()); // pw
			psmt.setString(3, vo_m.getName()); // name
			psmt.setString(4, vo_m.getPhone()); // �ڵ���
			psmt.setString(5, vo_m.getAddress()); // �ּ�
			psmt.setString(6, vo_m.getCategory());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	// �α���

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

	// ȸ���������� �α���

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

	// ȸ�� Ż�� delete�Ϸ��� ���̵� �⺻ 4�� �̻�.

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

	//artist table�� �� ����ֱ�
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
	
	
	// �����뿩 ���̺�
	   
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
	   //����
	  
	   //�������̺��� �� �� ������ �ϱ�
	   public ArrayList<VO_Review> allSelect() {
	      ArrayList<VO_Review> list = new ArrayList<VO_Review>();
	      getConnection();

	      try {
	         String sql = "select * from review";
	         psmt = conn.prepareStatement(sql);
	         // ?�� �������� ���ڸ� ä���ֱ� ���ؼ� setString, setInt �� ���� ����� ���

	         rs = psmt.executeQuery();
	         while (rs.next()) {
	            String id = rs.getString(1);
	            String date = rs.getString(2);
	            String review = rs.getString(3);
	           
	            list.add(new VO_Review(id, date, review));
	         }

	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return list;

	   }
	   
	   //���� ���̺��� ���� �Է��ϱ�!!!
	   public int insert_r(VO_Review vo_r) {
	      int cnt = 0;
	      try {
	         getConnection();
	         String sql = "insert into review values(?,?,?)";
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, vo_r.getId()); // id
	         psmt.setString(2, vo_r.getEx_date()); // ����ȸ ��¥
	         psmt.setString(3, vo_r.getEx_review()); // �ı� ����
	         cnt = psmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }

	      return cnt;
	   }
	   
	   
	   
	   
	   public ArrayList<VO_Artist> allSelect_artist() {
		      ArrayList<VO_Artist> list = new ArrayList<VO_Artist>();
		      getConnection();

		      try {
		         String sql = "SELECT id, name, title, start_d, end_d  FROM artist";
		         psmt = conn.prepareStatement(sql);
		         // ?�� �������� ���ڸ� ä���ֱ� ���ؼ� setString, setInt �� ���� ����� ���

		         rs = psmt.executeQuery();
		         while (rs.next()) {
		            String id = rs.getString(1);
		            String name = rs.getString(2);
		            String title = rs.getString(3);
		            String start_d = rs.getString(4);
		            String end_d = rs.getString(5);
		            
		            list.add(new VO_Artist(id,name, title, start_d, end_d));
		         }

		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close();
		      }
		      return list;

		   }
	   
	   
	
	
	
}
