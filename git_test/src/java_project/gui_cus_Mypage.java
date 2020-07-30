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

		
		//lbl_id�� login�Ҷ� id�� �־��ּ��� 
		JLabel lbl_id = new JLabel("���⿡ ������ �־��ָ� �˴ϴ�."); 
		lbl_id.setBounds(82, 121, 130, 21);
		frame.getContentPane().add(lbl_id);
		lbl_id.setOpaque(false);
		lbl_id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		//lbl_name�� login �Ҷ� name �� �־��ּ���
		JLabel lbl_name = new JLabel("���⿡ ������ �־��ָ� �˴ϴ�.");
		lbl_name.setBounds(82, 147, 130, 21);
		frame.getContentPane().add(lbl_name);
		lbl_name.setOpaque(false);
		lbl_name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		

		//Ƽ�� Ŭ���� ������ Ƽ��â���� ���ϴ�.
		JLabel lbl_ticketpage = new JLabel("");
		lbl_ticketpage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				//Ƽ��â Ŭ���� �ֱ�.main(null);
			}
		});
		lbl_ticketpage.setBounds(12, 193, 239, 37);
		frame.getContentPane().add(lbl_ticketpage);
		
		//������Ʈ�� Ŭ�������� ȸ������ ���� ĭ���� ���ϴ�.
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
		
		//delete�� Ŭ�������� ȸ������! â�� ��ϴ�.
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

		//background �׸�
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
