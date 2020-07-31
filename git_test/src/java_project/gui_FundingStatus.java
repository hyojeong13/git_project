package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class gui_FundingStatus {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_FundingStatus window = new gui_FundingStatus();
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
	public gui_FundingStatus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,  279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//이전 버튼 
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_CategoryChoice cate = new gui_CategoryChoice(new File(""));
			}
		});
		lbl_pre.setBounds(12, 30, 57, 31);
		frame.getContentPane().add(lbl_pre);
		
		//리뷰 버튼
		
		JLabel lbl_review = new JLabel("");
		lbl_review.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Exhibit_info.main(null);
			}
		});
		lbl_review.setBounds(22, 64, 110, 42);
		frame.getContentPane().add(lbl_review);
		
		//백그라운드 이미지
		
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/ex_fundingStatus.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_art_mypage = new JLabel(new ImageIcon(image));
		lbl_art_mypage.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_art_mypage);
		
	}

}
