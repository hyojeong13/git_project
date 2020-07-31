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

public class GUI_Cus_choice_art {

	private JFrame frame;
	private File file;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Cus_choice_art window = new GUI_Cus_choice_art();
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
	public GUI_Cus_choice_art() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//background 그림
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cus_choice_art.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_cus_list = new JLabel(new ImageIcon(image));
		lbl_cus_list.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_cus_list);
		
		
		//후원하기 클릭하기
		JLabel lbl_funding = new JLabel("");
		lbl_funding.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_cus_List cateCus = new gui_Cate_cus_List(new File(""));
				   
			}
		});
		lbl_funding.setBounds(0, 521, 263, 50);
		frame.getContentPane().add(lbl_funding);
		
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_cus_List cateCus = new gui_Cate_cus_List(new File(""));
			}
		});
		lbl_pre.setBounds(0, 26, 57, 64);
		frame.getContentPane().add(lbl_pre);
		
	}
}
