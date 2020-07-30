package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui_len_Mypage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_len_Mypage window = new gui_len_Mypage();
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
	public gui_len_Mypage() {
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

		
		//lbl_id�� login�Ҷ� id�� �־��ּ��� 
		JLabel lbl_id = new JLabel("���⿡ ������ �־��ָ� �˴ϴ�."); 
		lbl_id.setBounds(78, 129, 130, 21);
		frame.getContentPane().add(lbl_id);
		lbl_id.setOpaque(false);
		lbl_id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		//lbl_name�� login �Ҷ� name �� �־��ּ���
		JLabel lbl_name = new JLabel("���⿡ ������ �־��ָ� �˴ϴ�.");
		lbl_name.setBounds(78, 155, 130, 21);
		frame.getContentPane().add(lbl_name);
		lbl_name.setOpaque(false);
		lbl_name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		

		//�ݵ���Ȳ�� Ŭ�������� â�� ��̴ϴ�.
		JLabel lbl_funding = new JLabel("");
		lbl_funding.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				//�ݵ�â Ŭ���� �ֱ�.main(null);
			}
		});
		lbl_funding.setBounds(12, 203, 239, 37);
		frame.getContentPane().add(lbl_funding);
		
		//������Ʈ�� Ŭ�������� ȸ������ ���� ĭ���� ���ϴ�.
		JLabel lbl_update = new JLabel("");
		lbl_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_len_Update.main(null);
			}
		});
		lbl_update.setBounds(12, 265, 239, 37);
		frame.getContentPane().add(lbl_update);
		
		//delete�� Ŭ�������� ȸ������! â�� ��ϴ�.
		JLabel lbl_delete = new JLabel("");
		lbl_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_len_Delete.main(null);
			}
		});
		lbl_delete.setBounds(12, 321, 239, 46);
		frame.getContentPane().add(lbl_delete);

		//background �׸�
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/lenderMypage.jpg").getImage();
		JLabel lbl_len_mypage = new JLabel(new ImageIcon(image));
		lbl_len_mypage.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_len_mypage);
	}
}