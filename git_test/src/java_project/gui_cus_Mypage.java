package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui_cus_Mypage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_cus_Mypage window = new gui_cus_Mypage();
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
	public gui_cus_Mypage() {
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

		
		//lbl_id에 login할때 id값 넣어주세요 
		JLabel lbl_id = new JLabel("여기에 변수로 넣어주면 됩니다."); 
		lbl_id.setBounds(82, 121, 130, 21);
		frame.getContentPane().add(lbl_id);
		lbl_id.setOpaque(false);
		lbl_id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		//lbl_name에 login 할때 name 값 넣어주세요
		JLabel lbl_name = new JLabel("여기에 변수로 넣어주면 됩니다.");
		lbl_name.setBounds(82, 147, 130, 21);
		frame.getContentPane().add(lbl_name);
		lbl_name.setOpaque(false);
		lbl_name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		

		//티켓 클릭을 했을때 티켓창으로 갑니다.
		JLabel lbl_ticketpage = new JLabel("");
		lbl_ticketpage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				//티켓창 클래스 넣기.main(null);
			}
		});
		lbl_ticketpage.setBounds(12, 193, 239, 37);
		frame.getContentPane().add(lbl_ticketpage);
		
		//업데이트를 클릭했을때 회원정보 수정 칸으로 갑니다.
		JLabel lbl_updatepage = new JLabel("");
		lbl_updatepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_cus_Update.main(null);
			}
		});
		lbl_updatepage.setBounds(12, 255, 239, 37);
		frame.getContentPane().add(lbl_updatepage);
		
		//delete를 클릭했을때 회원삭제! 창이 뜹니다.
		JLabel lbl_deletepage = new JLabel("");
		lbl_deletepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_cus_Delete.main(null);
			}
		});
		lbl_deletepage.setBounds(12, 311, 239, 46);
		frame.getContentPane().add(lbl_deletepage);

		//background 그림
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cusMypage.jpg").getImage();
		JLabel lbl_cus_mypage = new JLabel(new ImageIcon(image));
		lbl_cus_mypage.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_cus_mypage);
		
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_cus_List.main(null);
			}
		});
		lbl_pre.setBounds(0, 32, 57, 46);
		frame.getContentPane().add(lbl_pre);

	}
}
