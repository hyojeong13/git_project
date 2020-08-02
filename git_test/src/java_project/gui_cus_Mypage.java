package java_project;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class gui_cus_Mypage {

	private JFrame frame;
	DAO dao = new DAO();

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
		frame.setBounds(820, 250,279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		//티켓 클릭을 했을때 티켓창으로 갑니다.
		JLabel lbl_ticketpage = new JLabel("");
		lbl_ticketpage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				ArrayList<VO_Funding> fun = new ArrayList<VO_Funding>();
				fun = dao.f_s_ticket();
				String o = fun.get(0).getFunding_s();
				
				
				if (o.equals("O")) {
					frame.dispose();
					gui_cus_ticket.main(null);
				}else {
					JOptionPane.showMessageDialog(null, "사용할 수 있는 티켓이 없습니다.", "", JOptionPane.WARNING_MESSAGE);
				}
				
				
				
			}
		});
		lbl_ticketpage.setBounds(12, 104, 239, 28);
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
		lbl_updatepage.setBounds(12, 142, 239, 28);
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
		lbl_deletepage.setBounds(12, 179, 239, 28);
		frame.getContentPane().add(lbl_deletepage);

		//background 그림
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cusMypage.jpg").getImage();
		JLabel lbl_cus_mypage = new JLabel(new ImageIcon(image));
		lbl_cus_mypage.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_cus_mypage);
		
		//이전 버튼
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_cus_List list = new gui_Cate_cus_List(new File(""));
				
			}
		});
		lbl_pre.setBounds(0, 32, 57, 46);
		frame.getContentPane().add(lbl_pre);

	}
}
