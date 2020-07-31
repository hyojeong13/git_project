package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Color;

public class gui_art_Mypage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_art_Mypage window = new gui_art_Mypage();
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
	public gui_art_Mypage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//업데이트를 클릭했을때 회원정보 수정 칸으로 갑니다.
		JLabel lbl_update = new JLabel("");
		lbl_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_art_Update.main(null);
			}
		});
		lbl_update.setBounds(12, 265, 239, 37);
		frame.getContentPane().add(lbl_update);
		
		//delete를 클릭했을때 회원삭제! 창이 뜹니다.
		JLabel lbl_delete = new JLabel("");
		lbl_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_art_Delete.main(null);
			}
		});
		lbl_delete.setBounds(12, 321, 239, 46);
		frame.getContentPane().add(lbl_delete);

		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_art_List cate = new gui_Cate_art_List(new File(""));
			}
		});
		lbl_pre.setBounds(0, 34, 57, 46);
		frame.getContentPane().add(lbl_pre);
		
		JLabel lblNewLabel_1 = new JLabel("                             ");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 90, 260, 152);
		frame.getContentPane().add(lblNewLabel_1);
		
		//background 그림
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/artistMypage.jpg").getImage();
		JLabel lbl_art_mypage = new JLabel(new ImageIcon(image));
		lbl_art_mypage.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_art_mypage);
		
	}
}

