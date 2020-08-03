package java_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

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

	// �ݾ��ֱ�
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

	//ȸ������ ����
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

	//artist table�� �� ����ֱ�(�ݵ� ��û�ϱ� â����)
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
	
	
	// lender table�� �߰�(�뿩���� ��û�ϱ�)
	   
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
	   
	   
	   //����â���� �����ֱ�
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
	   
	   
	   
	   //�ݵ� ��Ȳ �����ֱ�
	   public ArrayList<VO_Artist> allSelect_artist() {
		      ArrayList<VO_Artist> list = new ArrayList<VO_Artist>();
		      getConnection();

		      try {
		         String sql = "SELECT id, name, title, start_d, end_d  FROM artist where id not in(select id from funding)";
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
	   
	   
	   //�ݵ� ���̺� ���� �߰�
	   public int insert_f(String id, int goal,int sum_done,String funding_s, String address) {
			int cnt = 0;
			try {
				getConnection();
				String sql = "insert into funding values (funding_num_seq.nextval,?,?,?,?,?)";
				psmt = conn.prepareStatement(sql);
				 
				psmt.setString(1, id); // pw
				psmt.setInt(2, goal); // name
				psmt.setInt(3, sum_done); // �ڵ���
				psmt.setString(4, funding_s); // �ּ�
				psmt.setString(5, address);
				cnt = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}

			return cnt;
		}
	
	   
	   //artist�̸��� true�� ���.
	   public ArrayList<VO_Artist> art_True() {
		      ArrayList<VO_Artist> true_list = new ArrayList<VO_Artist>();
		      getConnection();

		      try {
		         String sql = "SELECT id, name, title, start_d, end_d  FROM artist where id = 'true'";
		         psmt = conn.prepareStatement(sql);

		         rs = psmt.executeQuery();
		       while (rs.next()) {
		    	      String id = rs.getString(1);
			            String name = rs.getString(2);
			            String title = rs.getString(3);
			            String start_d = rs.getString(4);
			            String end_d = rs.getString(5);
			            
			            true_list.add(new VO_Artist(id,name, title, start_d, end_d));
			      
			};
		         

		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close();
		      }
		      return true_list;

		   }
	   
	   //artist ���̵� true�� ���. goal(��ǥ �ݾ�)�� sum_done(���� ���� �ݾ�)��  select
	   public ArrayList<VO_Funding> funding_True() {
		      ArrayList<VO_Funding> true_list_f = new ArrayList<VO_Funding>();
		      getConnection();

		      try {
		         String sql = "SELECT goal, sum_done FROM funding where id = 'true'";
		         psmt = conn.prepareStatement(sql);

		         rs = psmt.executeQuery();
		         while (rs.next()) {
		            int goal = rs.getInt(1);
		            int sum_done = rs.getInt(2);
		            
		            
		            true_list_f.add(new VO_Funding(goal, sum_done));
		         };

		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close();
		      }
		      return true_list_f;

		   }
	   
	   
	   //���� �ݾ��� ������Ʈ ����
	   public int updatemoney(int done) {

			int result = 0;
			try {
				getConnection();
				String sql = "update funding set sum_done = ? where id = 'true'";
				psmt = conn.prepareStatement(sql);
				psmt.setLong(1, done);

				result = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}

			return result;
		}
	   
	   
	   
	   //funding table�� �÷��� ������ ��� select
	   public ArrayList<VO_Funding> allSelect_f() {
		      ArrayList<VO_Funding> list = new ArrayList<VO_Funding>();
		      getConnection();

		      try {
		         String sql = "select * from funding";
		         psmt = conn.prepareStatement(sql);

		         rs = psmt.executeQuery();
		         while (rs.next()) {
		        	int funding_num = rs.getInt(1);
		            String id = rs.getString(2);
		            int goal = rs.getInt(3);
		            int sum_done= rs.getInt(4);
		            String funding_s= rs.getString(5);
		            String address = rs.getString(6);
		           
		            list.add(new VO_Funding(funding_num, id, goal, sum_done, funding_s, address));
		         }

		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      } finally {
		         close();
		      }
		      return list;

		   }
	   
	  //sum_done(���� ���� �ݾ�)�� goal(��ǥ�ݾ�)�� ������ ��� funding table�� funding_s(�ݵ� ���� ����)�� O���� X�� �ٲ�
	   public void success() {

			int result = 0;
			try {
				getConnection();
				String sql = "update funding set funding_s = 'O' where goal<= sum_done";
				psmt = conn.prepareStatement(sql);

				result = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}

			
		}
	   
	   
	   //����ũ ��Ƽ��Ʈ ���� ��_��
	   public ArrayList<VO_Artist> art_Faker() {
		      ArrayList<VO_Artist> faker_list = new ArrayList<VO_Artist>();
		      getConnection();

		      try {
		         String sql = "SELECT id, name, title, start_d, end_d  FROM artist where id = 'faker'";
		         psmt = conn.prepareStatement(sql);

		         rs = psmt.executeQuery();
		       while (rs.next()) {
		    	      String id = rs.getString(1);
			            String name = rs.getString(2);
			            String title = rs.getString(3);
			            String start_d = rs.getString(4);
			            String end_d = rs.getString(5);
			            
			            faker_list.add(new VO_Artist(id,name, title, start_d, end_d));
			      
			};
		         

		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close();
		      }
		      return faker_list;

		   }
	   //����ũ�� �� ���̾�,,,
	   public ArrayList<VO_Funding> funding_faker() {
		      ArrayList<VO_Funding> faker_list_f = new ArrayList<VO_Funding>();
		      getConnection();

		      try {
		         String sql = "SELECT goal, sum_done FROM funding where id = 'faker'";
		         psmt = conn.prepareStatement(sql);

		         rs = psmt.executeQuery();
		         while (rs.next()) {
		            int goal = rs.getInt(1);
		            int sum_done = rs.getInt(2);
		            
		            
		            faker_list_f.add(new VO_Funding(goal, sum_done));
		         };

		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close();
		      }
		      return faker_list_f;

		   }
	   
	   
	   //����ũ �Ӵ� ������Ʈ
	   public int updatemoney_f(int done) {

			int result = 0;
			try {
				getConnection();
				String sql = "update funding set sum_done = ? where id = 'faker'";
				psmt = conn.prepareStatement(sql);
				psmt.setLong(1, done);

				result = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}

			return result;
		}
	   
	   
	   //�ݵ� ���̺��� �ݵ� ���� ���� -O�� ī��Ʈ(�ð�ȭ-��Ʈ�� ���� ����)
		public int cntSuccess() {

			int cnt = 0;
			try {
				getConnection();
				String sql = "select * from funding where funding_s = 'O'";
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();

				if (rs.next()) {
					cnt += 1;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return cnt;
		}
		//�ݵ� ���̺��� �ݵ� ���� ���� -X�� ī��Ʈ(�ð�ȭ-��Ʈ�� ���� ����)
		public int cntProceed() {
			int cnt = 0;
			try {
				getConnection();
				String sql = "select * from funding where funding_s = 'X'";
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();

				if (rs.next()) {
					cnt += 1;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return cnt;

		}

		// ���� ��Ʈ ������
		public PieDataset createDataset() {

			DefaultPieDataset dataset = new DefaultPieDataset();
			dataset.setValue("����", cntSuccess());
			dataset.setValue("������", cntProceed());

			return dataset;
		}
	   
	   //lender�� fav_id - update
		public int updateFav_id(String fav_id, String lender_id) {

			int result = 0;
			try {
				getConnection();
				String sql = "update lender set fav_id =? where id = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, fav_id);
				psmt.setString(2, lender_id);
				

				result = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}

			return result;
		}
	   
		
		
		//funding ���̺��� �ݵ� ������(���̵�� true) Ƽ�� �߱��� �ϱ� ����
		 public ArrayList<VO_Funding> f_s_ticket() {
		      ArrayList<VO_Funding> f_ticket = new ArrayList<VO_Funding>();
		      getConnection();

		      try {
		         String sql = "SELECT funding_s FROM funding where id = 'true'";
		         psmt = conn.prepareStatement(sql);

		         rs = psmt.executeQuery();
		         while (rs.next()) {
		            String o = rs.getString(1);
		            
		            f_ticket.add(new VO_Funding(o));
		         };

		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close();
		      }
		      return f_ticket;

		   }
		
	   
}
