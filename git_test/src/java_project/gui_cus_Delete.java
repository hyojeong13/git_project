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

public class gui_cus_Delete {

	private JFrame frame;
	private JTextField txt_id_delete;
	private JLabel lbl_pre;
	private JPasswordField txt_pw_delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_cus_Delete window = new gui_cus_Delete();
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
	public gui_cus_Delete() {
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
				Image image = new ImageIcon("C:\\Users\\SMT061\\git\\git_project\\git_test\\bin\\java_project\\image\\cus\\cusDelete.jpg").getImage();
				frame.getContentPane().setLayout(null);
				JLabel lbl_cus_delete = new JLabel(new ImageIcon(image));
				lbl_cus_delete.setBounds(0, 0, 263, 571);
				frame.getContentPane().add(lbl_cus_delete);
				
				//뒤로가기 버튼을 누르면 다시 마이페이지로 갑니다.
				lbl_pre = new JLabel("");
				lbl_pre.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame.dispose();
						gui_cus_Mypage.main(null);
					}
				});
				lbl_pre.setBounds(12, 39, 44, 42);
				frame.getContentPane().add(lbl_pre);

				//id를 입력합니다.
				txt_id_delete = new JTextField();
				txt_id_delete.setBounds(24, 126, 211, 28);
				frame.getContentPane().add(txt_id_delete);
				txt_id_delete.setColumns(10);
				txt_id_delete.setBorder(null);
				
				//pw를 입력합니다.
				txt_pw_delete = new JPasswordField();
				txt_pw_delete.setEchoChar('*');
				txt_pw_delete.setBounds(24, 172, 211, 28);
				frame.getContentPane().add(txt_pw_delete);
				txt_pw_delete.setBorder(null);
				
				//회원삭제(lbl_delete)를 클릭하면 회원정보가 삭제됩니다.
				JLabel lbl_delete = new JLabel("");
				lbl_delete.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("함수를 넣어서 delete해주세요");
					}
				});
				lbl_delete.setBounds(24, 263, 216, 33);
				frame.getContentPane().add(lbl_delete);

				

	}

}
