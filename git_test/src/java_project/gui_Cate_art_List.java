package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui_Cate_art_List {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_Cate_art_List window = new gui_Cate_art_List();
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
	public gui_Cate_art_List() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//background 그림 & 아직 아티스트 백그라운드 안바꿈!!!
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cateArt.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_art_list = new JLabel(new ImageIcon(image));
		lbl_art_list.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_art_list);
		
		//뒤로 버튼 : category창으로 넘어감니다.
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_CategoryChoice.main(null);
			}
		});
		lbl_pre.setBounds(0, 32, 56, 46);
		frame.getContentPane().add(lbl_pre);
		
		//아티스트 마이페이지로 넘어갑니다.
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
		
		//리스트 올리기가 되야함. 
		
		
		
	}
}
