package java_project;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gui_Cate_art_List {

	private JFrame frame;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					gui_Cate_art_List window = new gui_Cate_art_List();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */

	public gui_Cate_art_List(File file) {
		initialize(file);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(File file) {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 뒤로 버튼 : category창으로 넘어감니다
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_CategoryChoice choice = new gui_CategoryChoice(file);
			}
		});
		lbl_pre.setBounds(0, 32, 56, 46);
		frame.getContentPane().add(lbl_pre);

		// artist 마이페이지로 넘어갑니다.
		JLabel lbl_art_my = new JLabel("");
		lbl_art_my.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_art_Mypage.main(null);
			}
		});
		lbl_art_my.setBounds(206, 32, 57, 46);
		frame.getContentPane().add(lbl_art_my);
		
		//funding 하기 클릭 버튼
		
		JLabel lbl_funding = new JLabel("");
		lbl_funding.setBounds(26, 118, 214, 59);
		frame.getContentPane().add(lbl_funding);
		
		// 리스트 올리기가 되야함.

		// background 그림
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cateArt.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_len_list = new JLabel(new ImageIcon(image));
		lbl_len_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				GUI_Art_apply_funding.main(null);
			}
		});
		lbl_len_list.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_len_list);


	}
}
