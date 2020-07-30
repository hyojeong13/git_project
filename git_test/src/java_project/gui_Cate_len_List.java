package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui_Cate_len_List {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_Cate_len_List window = new gui_Cate_len_List();
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
	public gui_Cate_len_List() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//background �׸� :lender ��׶��� ���� �ȹٲ�!!!!
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cateLen.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_len_list = new JLabel(new ImageIcon(image));
		lbl_len_list.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_len_list);
		
		//�ڷ� ��ư : categoryâ���� �Ѿ�ϴ�.
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_CategoryChoice.main(null);
			}
		});
		lbl_pre.setBounds(0, 32, 56, 46);
		frame.getContentPane().add(lbl_pre);
		
		//lender ������������ �Ѿ�ϴ�.
		JLabel lbl_len_my = new JLabel("");
		lbl_len_my.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_len_Mypage.main(null);
			}
		});
		lbl_len_my.setBounds(206, 32, 57, 46);
		frame.getContentPane().add(lbl_len_my);
		
		//����Ʈ �ø��Ⱑ �Ǿ���. 
		
		
		
	}
}