package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class gui_CategoryChoice {

	private JFrame frame;

	//고객, 아티스트, 대여자로 들어갈 수 있는 카테고리가 있음.
	//로그인 전에 들어 올 수 없음.

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					gui_CategoryChoice window = new gui_CategoryChoice();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public gui_CategoryChoice(File file) {
		initialize(file);
		frame.setVisible(true);
	}

	
	private void initialize(File file) {
		frame = new JFrame();
		frame.setBounds(820, 250, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 고객 버튼 클릭하면 고객이보는 아티스트 리스트창(+마이페이지)으로 감.
		JLabel btn_cus = new JLabel("");
		btn_cus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_cus_List list = new gui_Cate_cus_List(file);
			}
		});
		btn_cus.setBounds(12, 209, 239, 100);
		frame.getContentPane().add(btn_cus);

		// 작가버튼 클릭하면 작가가 보는 대여 장소 리스트창(+마이페이지)으로 뜸.
		
		JLabel btn_art = new JLabel("");
		btn_art.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_art_List list = new gui_Cate_art_List(new File(""));
			}
		});
		btn_art.setBounds(12, 322, 239, 100);
		frame.getContentPane().add(btn_art);
		
	// 대여자 버튼 클릭하면 대여자가 보는 작가리스트창(+마이페이지)으로 뜸.
		

		JLabel btn_place = new JLabel("");
		btn_place.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_len_List.main(null);
			}
		});
		btn_place.setBounds(12, 431, 239, 100);
		frame.getContentPane().add(btn_place);
		

      //전시정보 페이지로 넘어가는 버튼
      JLabel btn_exhibit = new JLabel("");
      btn_exhibit.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 frame.dispose();
        	 gui_Exhibit_info.main(null);
         }
      });
      btn_exhibit.setBounds(174, 44, 77, 80);
      frame.getContentPane().add(btn_exhibit);
      
      
      
   
   
   // 백그라운드 경로설정
      String url = getClass().getResource("").getPath();
      Image image = new ImageIcon(url + "image/Category.jpg").getImage();
      
      frame.getContentPane().setLayout(null);
      JLabel lbl_cate = new JLabel(new ImageIcon(image));
      lbl_cate.setBounds(0, 0, 263, 571);
      frame.getContentPane().add(lbl_cate);
      
      JLabel lbl_logout = new JLabel("");
      lbl_logout.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent arg0) {
      		
      		frame.dispose();
      		gui_Select_Login.main(null);
      		
      	}
      });
      lbl_logout.setBounds(0, 0, 112, 43);
      frame.getContentPane().add(lbl_logout);
   }
}