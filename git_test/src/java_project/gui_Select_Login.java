package java_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JPasswordField;
import java.awt.Font;

public class gui_Select_Login {

	private JFrame frame;
	private JTextField txt_id;
	private JLabel lbl_background;
	private JLabel btn_login;
	private JLabel btn_join;
	private JLabel lbl_id;
	private JLabel lbl_pw;
	private JPasswordField txt_pw;

	DAO dao = new DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_Select_Login window = new gui_Select_Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui_Select_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lbl_id = new JLabel(" ID");
		lbl_id.setFont(new Font("Arial", Font.PLAIN, 12));
		lbl_id.setForeground(Color.WHITE);
		lbl_id.setBounds(37, 231, 57, 34);
		frame.getContentPane().add(lbl_id);

		lbl_pw = new JLabel("PW");
		lbl_pw.setFont(new Font("Arial", Font.PLAIN, 12));
		lbl_pw.setForeground(Color.WHITE);
		lbl_pw.setBounds(37, 277, 57, 34);
		frame.getContentPane().add(lbl_pw);

		txt_id = new JTextField();
		txt_id.setBounds(65, 232, 183, 34);
		txt_id.setForeground(Color.WHITE);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		txt_id.setOpaque(false);
		txt_id.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		// 비밀번호 창
		txt_pw = new JPasswordField();
		txt_pw.setForeground(Color.WHITE);
		txt_pw.setEchoChar('*');
		txt_pw.setBounds(65, 284, 155, 21);
		frame.getContentPane().add(txt_pw);
		txt_pw.setOpaque(false);
		txt_pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		// background에 이미지 넣을게요 : login_first page에서 넘어옴.//경로설정수정
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/Login.jpg").getImage();

		frame.getContentPane().setLayout(null);
		JLabel lbl_login = new JLabel(new ImageIcon(image));
		lbl_login.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_login);

		// login 클릭 : categorychoice로 넘어감
		// if구문으로 아이디 pw select가 되는지 확인하는 기능 넣어야합니다.
		btn_login = new JLabel("");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = txt_id.getText();
				String pw = txt_pw.getText();

				// VO_Member vo_m = new VO_Member(id, pw);
				int result = dao.login(id, pw); // 0이면 성공, 1이면 실패

				if (result == 0) {
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					gui_CategoryChoice choice = new gui_CategoryChoice(new File(""));
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패!", "로그인", JOptionPane.ERROR_MESSAGE);
				}

				// frame.dispose();
				// gui_CategoryChoice.main(null);
			}
		});

		btn_login.setBounds(37, 325, 183, 34);
		frame.getContentPane().add(btn_login);

		// btn_join 클릭 : insert_join클래스로 넘어감 회원가입 ㄱㄱ
		btn_join = new JLabel("New label");
		btn_join.setForeground(Color.WHITE);
		btn_join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Insert_Join.main(null);

			}
		});

		btn_join.setBounds(93, 413, 73, 15);
		frame.getContentPane().add(btn_join);

	}
}
