package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class gui_art_Delete {

	//아티스트가 회원탈퇴를 하는 gui
	
	private JFrame frame;
	private JTextField txt_id_delete;
	private JLabel lbl_pre;
	private JPasswordField txt_pw_delete;
	DAO dao = new DAO();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_art_Delete window = new gui_art_Delete();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gui_art_Delete() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(820, 250, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
				//background 그림
				String url = getClass().getResource("").getPath();
				Image image = new ImageIcon(url + "image/artistDelete.jpg").getImage();
				frame.getContentPane().setLayout(null);
				JLabel lbl_art_delete = new JLabel(new ImageIcon(image));
				lbl_art_delete.setBounds(0, 0, 263, 571);
				frame.getContentPane().add(lbl_art_delete);
				
				//뒤로가기 버튼을 누르면 다시 마이페이지로 갑니다.
				lbl_pre = new JLabel("");
				lbl_pre.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame.dispose();
						gui_art_Mypage.main(null);
					}
				});
				lbl_pre.setBounds(12, 39, 44, 42);
				frame.getContentPane().add(lbl_pre);

				//id를 입력합니다.
				txt_id_delete = new JTextField();
				txt_id_delete.setBounds(28, 131, 200, 27);
				frame.getContentPane().add(txt_id_delete);
				txt_id_delete.setColumns(10);
				txt_id_delete.setBorder(null);
				
				//pw를 입력합니다.
				txt_pw_delete = new JPasswordField();
				txt_pw_delete.setEchoChar('*');
				txt_pw_delete.setBounds(28, 177, 201, 22);
				frame.getContentPane().add(txt_pw_delete);
				txt_pw_delete.setBorder(null);
				
				//회원삭제(lbl_delete)를 클릭하면 회원정보가 삭제됩니다.
				JLabel lbl_delete = new JLabel("");
				lbl_delete.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						String id = txt_id_delete.getText();
						String pw = txt_pw_delete.getText();
						
						VO_Member vo_m = new VO_Member(id, pw);
						int cnt = dao.delete(vo_m);
						
						if (cnt > 0) { //성공
							JOptionPane.showMessageDialog(null, "회원탈퇴 성공!", "회원탈퇴", JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
							gui_Select_Login.main(null);
						}else {//실패
							JOptionPane.showMessageDialog(null, "회원탈퇴 실패! 다시 확인해주세요", "회원탈퇴", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				});
				lbl_delete.setBounds(24, 263, 216, 33);
				frame.getContentPane().add(lbl_delete);

				

	}

}
