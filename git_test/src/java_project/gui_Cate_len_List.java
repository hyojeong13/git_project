package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

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


		// �ڷ� ��ư : categoryâ���� �Ѿ�ϴ�
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_CategoryChoice choice = new gui_CategoryChoice(new File(""));
			}
		});
		lbl_pre.setBounds(0, 32, 56, 46);
		frame.getContentPane().add(lbl_pre);

		// lender ������������ �Ѿ�ϴ�.
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
		
		JLabel lbl_applyPlace = new JLabel("");
		lbl_applyPlace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				GUI_Len_apply_place.main(null);
			}
		});
		lbl_applyPlace.setBounds(24, 115, 216, 60);
		frame.getContentPane().add(lbl_applyPlace);

		// ����Ʈ �ø��Ⱑ �Ǿ���.
		// background �׸� :lender ��׶��� ���� �ȹٲ�!!!!....
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cateLen.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_len_list = new JLabel(new ImageIcon(image));
		lbl_len_list.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_len_list);

	}
}
