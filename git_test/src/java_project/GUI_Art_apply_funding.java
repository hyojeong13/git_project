package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class GUI_Art_apply_funding {

	private JFrame frame;
	private File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Art_apply_funding window = new GUI_Art_apply_funding();
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
	public GUI_Art_apply_funding() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		// 내용이 insert가 되면
//		JButton btn_apply = new JButton("");
//		btn_apply.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				frame.dispose();
//				gui_Cate_art_List cate = new gui_Cate_art_List(file);
//
//			}
//		});
//		btn_apply.setBounds(0, 517, 263, 54);
//		frame.getContentPane().add(btn_apply);
//		btn_apply.setOpaque(false);
		
		//지원하기 누르는 버튼
		JLabel lbl_artapply = new JLabel("");
		lbl_artapply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_art_List cate = new gui_Cate_art_List(file);
			}
		});
		lbl_artapply.setBounds(0, 518, 263, 53);
		frame.getContentPane().add(lbl_artapply);
		

		// 뒤로가기 버튼
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_CategoryChoice choice = new gui_CategoryChoice(file);
			}
		});
		lbl_pre.setBounds(0, 25, 69, 54);
		frame.getContentPane().add(lbl_pre);

		//라벨에 그림넣기
		JLabel lbl_photo1 = new JLabel("");
		lbl_photo1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JFileChooser chooser = new JFileChooser();
				int val = chooser.showSaveDialog(null);

				if (val == 0) {
					file = chooser.getSelectedFile();
					Image image = new ImageIcon(file.getPath()).getImage();
					lbl_photo1.setIcon(new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				}

			}
		});
		lbl_photo1.setBounds(32, 304, 88, 88);
		frame.getContentPane().add(lbl_photo1);

		// background 그림
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/art_apply_funding.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_cus_list = new JLabel(new ImageIcon(image));
		lbl_cus_list.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_cus_list);
		
	}
}
