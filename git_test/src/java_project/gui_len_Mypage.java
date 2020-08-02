package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui_len_Mypage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_len_Mypage window = new gui_len_Mypage();
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
	public gui_len_Mypage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(820, 250, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//업데이트를 클릭했을때 회원정보 수정 칸으로 갑니다.
		JLabel lbl_update = new JLabel("");
		lbl_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_len_Update.main(null);
			}
		});
		lbl_update.setBounds(12, 101, 239, 32);
		frame.getContentPane().add(lbl_update);
		
		//delete를 클릭했을때 회원삭제! 창이 뜹니다.
		JLabel lbl_delete = new JLabel("");
		lbl_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_len_Delete.main(null);
			}
		});
		lbl_delete.setBounds(12, 143, 239, 32);
		frame.getContentPane().add(lbl_delete);

		//background 그림
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/lenMypage.jpg").getImage();
		JLabel lbl_len_mypage = new JLabel(new ImageIcon(image));
		lbl_len_mypage.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_len_mypage);
		
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_len_List.main(null);
			}
		});
		lbl_pre.setBounds(0, 26, 57, 74);
		frame.getContentPane().add(lbl_pre);
	}
}
