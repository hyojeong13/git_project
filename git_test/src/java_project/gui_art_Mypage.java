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

public class gui_art_Mypage {

	private JFrame frame;

	//아티스트의 마이 페이지 - 회원정보 수정과 회원정보 탈퇴로 이어짐	
	
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

	
	public gui_art_Mypage() {
		initialize();
	}

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
				gui_art_Update.main(null);
			}
		});
		lbl_update.setBounds(12, 110, 239, 24);
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
		lbl_delete.setBounds(12, 144, 239, 30);
		frame.getContentPane().add(lbl_delete);

		//background 그림
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/artMypage.jpg").getImage();
		JLabel lbl_art_mypage = new JLabel(new ImageIcon(image));
		lbl_art_mypage.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_art_mypage);
		
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
		
		
	}
}
