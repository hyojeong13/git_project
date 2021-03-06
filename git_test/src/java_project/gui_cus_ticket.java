package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui_cus_ticket {

	//고객의 티켓창
	
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_cus_ticket window = new gui_cus_ticket();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gui_cus_ticket() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(820, 250, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//뒤로가기 버튼. 고객의 마이페이지로 넘어감.
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_cus_Mypage.main(null);
			}
		});
		
		lbl_pre.setBounds(0, 36, 57, 47);
		frame.getContentPane().add(lbl_pre);

		// background 그림 - qr코드와 artist의 name이 들어있음. 큐알코드 진짜로 들어가짐 ㅎ_ㅎ
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/ticket.jpg").getImage();
		JLabel lbl_cus_mypage = new JLabel(new ImageIcon(image));
		lbl_cus_mypage.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_cus_mypage);
		
		
		}
	}
