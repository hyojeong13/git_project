package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_Len_apply_place {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Len_apply_place window = new GUI_Len_apply_place();
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
	public GUI_Len_apply_place() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//background ±×¸²
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/len_apply_place.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_cus_list = new JLabel(new ImageIcon(image));
		lbl_cus_list.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_cus_list);
		
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_len_List.main(null);
			}
		});
		lbl_pre.setBounds(12, 22, 57, 57);
		frame.getContentPane().add(lbl_pre);
		
		JLabel lbl_place = new JLabel("");
		lbl_place.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_len_List.main(null);
			}
		});
		lbl_place.setBounds(0, 521, 263, 50);
		frame.getContentPane().add(lbl_place);
		
	}

}
