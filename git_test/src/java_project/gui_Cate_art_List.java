package java_project;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gui_Cate_art_List {

	//공간 대여 정보를 입력하고, 신청하는 페이지
	//공간 대여를 신청하기 위해서는 선행 조건으로 - 아티스트가 펀딩 신청을 먼저 해야함
	//때문에 밑에서 메인문을 지움
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

	public gui_Cate_art_List(File file) {
		initialize(file);
		frame.setVisible(true);
	}

	
	private void initialize(File file) {
		frame = new JFrame();
		frame.setBounds(820, 250, 279, 610);
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
		lbl_funding.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				GUI_Art_apply_funding.main(null);
			}
		});
		frame.getContentPane().add(lbl_funding);
		
		// 리스트 올리기가 되야함.

		// background 그림
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cateArt.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_len_list = new JLabel(new ImageIcon(image));
		
		lbl_len_list.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_len_list);
		
		
		JLabel lbl_AD = new JLabel("");
		lbl_AD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//광고 클릭 - 맥도날드로 들어감 ㅎ_ㅎ
				try {
					Desktop.getDesktop().browse(new URI("https://www.mcdonalds.co.kr/kor/main.do"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}

			}
		});
		lbl_AD.setBounds(0, 415, 263, 131);
		frame.getContentPane().add(lbl_AD);


	}
}
