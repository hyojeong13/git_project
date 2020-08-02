package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui_cus_ticket {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public gui_cus_ticket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(820, 250, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
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

		// background ±×¸²
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/ticket.jpg").getImage();
		JLabel lbl_cus_mypage = new JLabel(new ImageIcon(image));
		lbl_cus_mypage.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_cus_mypage);
		
		
		}
	}
