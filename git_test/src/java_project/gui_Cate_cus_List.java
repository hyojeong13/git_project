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

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �ڷ� ��ư : categoryâ���� �Ѿ�ϴ�.
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_CategoryChoice choice = new gui_CategoryChoice(new File(""));
				//������ �ְ�ް� ������ �Ű������� �޾ƿ��� �ִ� file�� �Ѱ��ָ� �ǰ�!
				//Ư���� ���� �ѱ� �ʿ伺�� ���ٸ� new File("")�Ѱ��ֽø� �˴ϴ�!
				//��, main���� ���� ������, main�� �ִ� ������ ���ľ߸� ������ �ɰſ���!
			}
		});
		lbl_pre.setBounds(0, 32, 56, 46);
		frame.getContentPane().add(lbl_pre);

		// customer������������ �Ѿ�ϴ�.
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
		JLabel lbl_imageTest = new JLabel(new ImageIcon(image2.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		lbl_imageTest.setBounds(134, 88, 88, 88);
		frame.getContentPane().add(lbl_imageTest);

		
		
		// ����Ʈ �ø��Ⱑ �Ǿ���.

		// background �׸�
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cateCus.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_cus_list = new JLabel(new ImageIcon(image));
		lbl_cus_list.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_cus_list);
		
		//���� ���� --> Ŭ���ϸ� gui_cus_choice_art
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
		

	}
}
