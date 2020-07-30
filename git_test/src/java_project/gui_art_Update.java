package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class gui_art_Update {

	private JFrame frame;
	private JTextField txt_id_update;
	private JLabel lbl_pre;
	private JPasswordField txt_pw_update;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_art_Update window = new gui_art_Update();
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
	public gui_art_Update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//background 그림
		Image image = new ImageIcon("C:\\Users\\SMT061\\git\\git_project\\git_test\\bin\\java_project\\image\\art\\artUpdate.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_art_update = new JLabel(new ImageIcon(image));
		lbl_art_update.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_art_update);

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
				txt_id_update = new JTextField();
				txt_id_update.setBounds(29, 135, 203, 23);
				frame.getContentPane().add(txt_id_update);
				txt_id_update.setColumns(10);
				txt_id_update.setBorder(null);

				//pw입력 **
				txt_pw_update = new JPasswordField();
				txt_pw_update.setEchoChar('*');
				txt_pw_update.setBounds(29, 178, 203, 23);
				frame.getContentPane().add(txt_pw_update);
				txt_pw_update.setBorder(null);
				
				//회원삭제(lbl_update)를 클릭하면 회원정보수정창이 뜹니다.
				JLabel lbl_update = new JLabel("");
				lbl_update.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("아이디와 비밀번호가 맞으면 다음페이지로 넘어가게해주세요");
						frame.dispose();
						gui_art_UpdateFinal.main(null);
					}
				});
				lbl_update.setBounds(24, 263, 216, 33);
				frame.getContentPane().add(lbl_update);


	}
}
