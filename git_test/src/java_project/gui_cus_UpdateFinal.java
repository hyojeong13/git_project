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

public class gui_cus_UpdateFinal {

	private JFrame frame;
	private JTextField txt_name_update;
	private JLabel lbl_pre;
	private JTextField txt_address_update;
	private JTextField txt_phone_update;
	private JPasswordField txt_pw_update;
	DAO dao = new DAO();

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_cus_UpdateFinal window = new gui_cus_UpdateFinal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public gui_cus_UpdateFinal(String id, String pw) {
		initialize(id, pw);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String id, String pw) {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// background 그림
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cusUpdateFinal.jpg").getImage();

		frame.getContentPane().setLayout(null);
		JLabel lbl_cus_updateFinal = new JLabel(new ImageIcon(image));
		lbl_cus_updateFinal.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_cus_updateFinal);

		// 뒤로가기 버튼을 누르면 update페이지로 갑니다.
		lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_cus_Update.main(null);
			}
		});
		lbl_pre.setBounds(12, 39, 44, 42);
		frame.getContentPane().add(lbl_pre);

		// 수정할 비밀번호를 입력합니다.
		txt_pw_update = new JPasswordField();
		txt_pw_update.setEchoChar('*');
		txt_pw_update.setBounds(29, 130, 203, 23);
		frame.getContentPane().add(txt_pw_update);
		txt_pw_update.setBorder(null);

		// 이름을 입력합니다.
		txt_name_update = new JTextField();
		txt_name_update.setColumns(10);
		txt_name_update.setBounds(29, 177, 203, 23);
		frame.getContentPane().add(txt_name_update);
		txt_name_update.setBorder(null);

		// 주소를 입력하세요
		txt_address_update = new JTextField();
		txt_address_update.setColumns(10);
		txt_address_update.setBorder(null);
		txt_address_update.setBounds(29, 220, 203, 23);
		frame.getContentPane().add(txt_address_update);

		// 연락처를 입력합니다.
		txt_phone_update = new JTextField();
		txt_phone_update.setColumns(10);
		txt_phone_update.setBorder(null);
		txt_phone_update.setBounds(29, 263, 203, 23);
		frame.getContentPane().add(txt_phone_update);

		// 회원정보 수정(lbl_updateFinal)를 클릭하면 회원정보가 수정완료됩니다.
		JLabel lbl_updateFinal = new JLabel("");
		lbl_updateFinal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String pw = txt_pw_update.getText();
				String name = txt_name_update.getText();
				String address = txt_address_update.getText();
				String phone = txt_phone_update.getText();
				

				// VO_Member vo_m = new VO_Member(id, pw);
				int result = dao.updateFinal(pw, name, address, phone,id); // 0이면 성공, 1이면 실패

				if (result > 0) {
					JOptionPane.showMessageDialog(null, "회원정보 수정 성공", "회원정보", JOptionPane.INFORMATION_MESSAGE);					frame.dispose();
					gui_cus_Mypage.main(null);
				}

			}
		});
		lbl_updateFinal.setBounds(27, 342, 216, 33);
		frame.getContentPane().add(lbl_updateFinal);

	}

}
