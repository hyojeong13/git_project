package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JPanel;

public class gui_Insert_Join {

	private JFrame frame;
	private JTextField txt_insertID;
	private JTextField txt_insertPW;
	private JTextField txt_insertName;
	private JTextField txt_insertPhonenumber;
	private JTextField txt_insertAddress;
	private JButton btn_join;
	private JButton btn_joinLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_Insert_Join window = new gui_Insert_Join();
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
	public gui_Insert_Join() {
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
		
		Image image = new ImageIcon("C:\\Users\\SMT015\\git\\git_test\\git_test\\bin\\java_project\\image\\Joinpage.jpg").getImage();
		JLabel lbl_img = new JLabel(new ImageIcon(image));
		lbl_img.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_img);
		
		txt_insertID = new JTextField();
		txt_insertID.setBounds(30, 80, 200, 27);
		frame.getContentPane().add(txt_insertID);
		txt_insertID.setColumns(10);
		//텍스트 테두리 없애기
		txt_insertID.setBorder(null);
		
		
		txt_insertPW = new JTextField();
		txt_insertPW.setColumns(10);
		txt_insertPW.setBounds(30, 170, 200, 27);
		frame.getContentPane().add(txt_insertPW);
		txt_insertPW.setBorder(null);
		
		txt_insertName = new JTextField();
		txt_insertName.setColumns(10);
		txt_insertName.setBounds(30, 125, 200, 27);
		frame.getContentPane().add(txt_insertName);
		txt_insertName.setBorder(null);
		
		txt_insertPhonenumber = new JTextField();
		txt_insertPhonenumber.setBounds(30, 247, 200, 27);
		frame.getContentPane().add(txt_insertPhonenumber);
		txt_insertPhonenumber.setColumns(10);
		txt_insertPhonenumber.setBorder(null);
	
		txt_insertAddress = new JTextField();
		txt_insertAddress.setBackground(Color.WHITE);
		txt_insertAddress.setColumns(10);
		txt_insertAddress.setBounds(30, 290, 200, 27);
		frame.getContentPane().add(txt_insertAddress);
		txt_insertAddress.setBorder(null);
		
		//insert후 완료 창 만들어야함. 
		btn_join = new JButton("New button");
		btn_join.setBounds(23, 350, 211, 32);
		frame.getContentPane().add(btn_join);
		btn_join.setOpaque(false);
		
		//join창에 로그인 다시 누르면 Select_Login창이 다시 뜸.
		btn_joinLogin = new JButton("New button");
		btn_joinLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Select_Login.main(null);
			}
		});
		btn_joinLogin.setBounds(83, 439, 97, 23);
		frame.getContentPane().add(btn_joinLogin);
		btn_joinLogin.setOpaque(false);
		
	}
}
