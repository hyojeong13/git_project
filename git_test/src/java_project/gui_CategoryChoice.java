package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class gui_CategoryChoice {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_CategoryChoice window = new gui_CategoryChoice();
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
	public gui_CategoryChoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image image = new ImageIcon("C:\\Users\\SMT015\\git\\git_test\\git_test\\bin\\java_project\\image\\Categorypage.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_choice = new JLabel(new ImageIcon(image));
		lbl_choice.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_choice);
		
		JButton btn_choiceCustomer = new JButton("New button");
		btn_choiceCustomer.setBounds(33, 197, 189, 79);
		frame.getContentPane().add(btn_choiceCustomer);
		btn_choiceCustomer.setOpaque(false);
		
		JButton btn_choiceArtist = new JButton("New button");
		btn_choiceArtist.setBounds(33, 294, 189, 79);
		frame.getContentPane().add(btn_choiceArtist);
		btn_choiceArtist.setOpaque(false);
		
		JButton btn_choiceLender = new JButton("New button");
		btn_choiceLender.setBounds(33, 391, 189, 79);
		frame.getContentPane().add(btn_choiceLender);
		btn_choiceLender.setOpaque(false);
	}

}
