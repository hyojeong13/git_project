package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class gui_Exhibit_info {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_Exhibit_info window = new gui_Exhibit_info();
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
	public gui_Exhibit_info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
			JLabel lbl_pre = new JLabel("");
			lbl_pre.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
					gui_CategoryChoice cate = new gui_CategoryChoice(new File(""));
				}
			});
			lbl_pre.setBounds(12, 36, 57, 29);
			frame.getContentPane().add(lbl_pre);
			//펀딩현황보는 페이지
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
					gui_FundingStatus.main(null);
				}
			});
			lblNewLabel.setBounds(132, 62, 119, 45);
			frame.getContentPane().add(lblNewLabel);
		
			//백그라운드 이미지
			
			String url = getClass().getResource("").getPath();
			Image image = new ImageIcon(url + "image/ex_review.jpg").getImage();
			frame.getContentPane().setLayout(null);
			JLabel lbl_art_mypage = new JLabel(new ImageIcon(image));
			lbl_art_mypage.setBounds(0, 0, 263, 571);
			frame.getContentPane().add(lbl_art_mypage);
			
	}

}
