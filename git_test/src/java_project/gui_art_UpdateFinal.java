package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class gui_art_UpdateFinal {

	private JFrame frame;
	private JTextField txt_name_update;
	private JLabel lbl_pre;
	private JTextField txt_address_update;
	private JTextField txt_phone_update;
	private JPasswordField txt_pw_update;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_art_UpdateFinal window = new gui_art_UpdateFinal();
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
	public gui_art_UpdateFinal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//background �׸�
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/artistUpdateFinal.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_cus_updateFinal = new JLabel(new ImageIcon(image));
		lbl_cus_updateFinal.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_cus_updateFinal);
				
		//�ڷΰ��� ��ư�� ������ update�������� ���ϴ�.
		lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_art_Update.main(null);
			}
		});
		lbl_pre.setBounds(12, 39, 44, 42);
		frame.getContentPane().add(lbl_pre);
		
		//������ ��й�ȣ�� �Է��մϴ�.
		txt_pw_update = new JPasswordField();
		txt_pw_update.setEchoChar('*');
		txt_pw_update.setBounds(29, 130, 203, 23);
		frame.getContentPane().add(txt_pw_update);
		txt_pw_update.setBorder(null);
		
		//�̸��� �Է��մϴ�.
		txt_name_update = new JTextField();
		txt_name_update.setColumns(10);
		txt_name_update.setBounds(29, 177, 203, 23);
		frame.getContentPane().add(txt_name_update);
		txt_name_update.setBorder(null);
				
		//�ּҰ��� �Է��մϴ�.
		txt_address_update = new JTextField();
		txt_address_update.setColumns(10);
		txt_address_update.setBorder(null);
		txt_address_update.setBounds(29, 220, 203, 23);
		frame.getContentPane().add(txt_address_update);
		
		//����ó�� �Է��մϴ�.
		txt_phone_update = new JTextField();
		txt_phone_update.setColumns(10);
		txt_phone_update.setBorder(null);
		txt_phone_update.setBounds(29, 263, 203, 23);
		frame.getContentPane().add(txt_phone_update);
		
				//ȸ������(lbl_updateFinal)�� Ŭ���ϸ� ȸ�������� �����˴ϴ�.
				JLabel lbl_updateFinal = new JLabel("");
				lbl_updateFinal.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println("�Լ��� �־ update���ּ���");
					}
				});
				lbl_updateFinal.setBounds(27, 342, 216, 33);
				frame.getContentPane().add(lbl_updateFinal);


				

	}

}
