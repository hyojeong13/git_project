package java_project;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JButton;

public class gui_Cate_cus_List {

	
	//고객이 후원을 하기 위해서 아티스트를 선택하는 창
	// 선행조건 - 아티스트가 펀딩신청을 해야만(사진 업로드를 해야 사진이 뜸) 사진이 뜨게 됨. -메인문 삭제
	// 사진을 넣어도 첫 번째 후원할 때만 보임 ㅎ_ㅎ 
	// 업로드한 사진 빼고 위에 있는 사진들은 다 페이크 
	
	
	private JFrame frame;

	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					gui_Cate_cus_List window = new gui_Cate_cus_List();
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
	public gui_Cate_cus_List(File file) {
		initialize(file);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(File file) {
		frame = new JFrame();
		frame.setBounds(820, 250, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 뒤로 버튼 : category창으로 넘어감니다.
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_CategoryChoice choice = new gui_CategoryChoice(new File(""));
				//사진을 주고받고 싶으면 매개변수로 받아오고 있는 file을 넘겨주면 되고!
				//특정한 값을 넘길 필요성이 없다면 new File("")넘겨주시면 됩니다!
				//단, main문이 없기 때문에, main이 있는 공간을 거쳐야만 실행이 될거에요!
			}
		});
		lbl_pre.setBounds(0, 32, 56, 46);
		frame.getContentPane().add(lbl_pre);

		// customer마이페이지로 넘어갑니다.
		JLabel lbl_cus_my = new JLabel("");
		lbl_cus_my.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_cus_Mypage.main(null);
			}
		});
		lbl_cus_my.setBounds(206, 32, 57, 46);
		frame.getContentPane().add(lbl_cus_my);

		Image image2 = new ImageIcon(file.getPath()).getImage();
		JLabel lbl_true = new JLabel(new ImageIcon(image2.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		lbl_true.setBounds(0, 427, 88, 88);
		frame.getContentPane().add(lbl_true);

		
		
		//사진 삽입 --> 클릭하면 gui_cus_choice_art
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				GUI_Cus_choice_art.main(null);
			}
		});
		lblNewLabel.setBounds(0, 427, 86, 86);
		frame.getContentPane().add(lblNewLabel);
		
		//fake 클릭하면 
		JLabel lbl_fake = new JLabel("");
		lbl_fake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				
				GUI_Cus_choice_art_f.main(null);
				
			}
		});
		lbl_fake.setBounds(0, 77, 263, 350);
		frame.getContentPane().add(lbl_fake);
		
		// background 그림
				String url = getClass().getResource("").getPath();
				Image image = new ImageIcon(url + "image/cateCus.jpg").getImage();
				frame.getContentPane().setLayout(null);
				JLabel lbl_cus_list = new JLabel(new ImageIcon(image));
				lbl_cus_list.setBounds(0, 0, 263, 571);
				frame.getContentPane().add(lbl_cus_list);
	}
}
