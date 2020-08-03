package java_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class gui_Insert_Join {

	//ȸ������ �ϴ� ��.
	
	private JFrame frame;
	private JTextField txt_insertID;
	private JTextField txt_insertName;
	private JTextField txt_insertPhone;
	private JTextField txt_insertAddress;
	private JButton btn_join;
	private JButton btn_joinLogin;

	DAO dao = new DAO();
	private JPasswordField txt_insertpw;
	
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
	public gui_Insert_Join() {
		initialize();
	}

 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(820, 250, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		String fontName = "Noto Sans KR";
		
		//�޺��ڽ���  �̿��ؼ� 3������ �����ϵ��� ��.
		JComboBox insert_ca = new JComboBox();
		insert_ca.setFont(new Font(fontName, Font.PLAIN, 11));
		insert_ca.setModel(new DefaultComboBoxModel(new String[] { "-category-", "artist", "customer", "lender" }));
		insert_ca.setToolTipText("");
		insert_ca.setBackground(Color.WHITE);
		insert_ca.setBounds(23, 299, 215, 30);
		frame.getContentPane().add(insert_ca);

		txt_insertID = new JTextField("");
		txt_insertID.setForeground(new Color(51, 153, 255));
		txt_insertID.setFont(new Font(fontName, Font.PLAIN, 11));
		txt_insertID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_insertID.setText("");
			}
		});
		txt_insertID.setBounds(99, 82, 127, 25);
		frame.getContentPane().add(txt_insertID);
		txt_insertID.setColumns(10);
		// �ؽ�Ʈ �׵θ� ���ֱ�
		txt_insertID.setBorder(null);
		txt_insertID.setOpaque(false);
		txt_insertID.setBorder(null);

		txt_insertName = new JTextField("");
		txt_insertName.setForeground(new Color(51, 153, 255));
		txt_insertName.setFont(new Font(fontName, Font.PLAIN,11));
		txt_insertName.setColumns(10);
		txt_insertName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_insertName.setText("");
			}
		});
		txt_insertName.setBounds(99, 171, 124, 25);
		frame.getContentPane().add(txt_insertName);
		txt_insertName.setBorder(null);
		txt_insertName.setOpaque(false);
		
		
		txt_insertpw = new JPasswordField();
		txt_insertpw.setForeground(new Color(51, 153, 255));
		txt_insertpw.setFont(new Font(fontName, Font.PLAIN,11));
		txt_insertpw.setEchoChar('*');
		txt_insertpw.setBounds(99, 129, 127, 25);
		frame.getContentPane().add(txt_insertpw);
		txt_insertpw.setBorder(null);
		txt_insertpw.setOpaque(false);
		
		
		
		txt_insertPhone = new JTextField("  ");
		txt_insertPhone.setForeground(new Color(51, 153, 255));
		txt_insertPhone.setFont(new Font(fontName, Font.PLAIN,11));
		txt_insertPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_insertPhone.setText("");
			
			}
		});
		txt_insertPhone.setBounds(99, 217, 124, 23);
		frame.getContentPane().add(txt_insertPhone);
		txt_insertPhone.setColumns(10);
		txt_insertPhone.setBorder(null);

		txt_insertAddress = new JTextField("");
		txt_insertAddress.setForeground(new Color(51, 153, 255));
		txt_insertAddress.setFont(new Font(fontName, Font.PLAIN,11));
		txt_insertAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_insertAddress.setText("");
			
			}
		});
		txt_insertAddress.setBackground(Color.WHITE);
		txt_insertAddress.setColumns(10);
		txt_insertAddress.setBounds(99, 261, 124, 25);
		frame.getContentPane().add(txt_insertAddress);
		txt_insertAddress.setBorder(null);

		//��׶��� �׸�
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/Joinpage.jpg").getImage();
		JLabel lbl_img = new JLabel(new ImageIcon(image));
		lbl_img.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_img);

		// insert�� �Ϸ� â ��������.
		btn_join = new JButton("New button");
		btn_join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = txt_insertID.getText();
				String name = txt_insertName.getText();
				String pw = txt_insertpw.getText();
				String category = (String) insert_ca.getSelectedItem();
				String address = txt_insertAddress.getText();
				String phone = txt_insertPhone.getText();

				//ȸ�������� �� �ֵ���. db�� �־���
				VO_Member vo = new VO_Member(id, pw, name, phone, address, category);
				int cnt = dao.insert_m(vo);

				if (cnt > 0) { // ����
					// ���� �˾�â ����
					// �Ű����� - �θ�������Ʈ, �޼���(���), ����, �����ܸ��
					JOptionPane.showMessageDialog(null, "ȸ������ ����", "ȸ������", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					gui_Select_Login.main(null);
				} else {
					// ���� �� �˾�â
					JOptionPane.showMessageDialog(null, "ȸ������ ����!", "ȸ������", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btn_join.setBounds(23, 350, 211, 32);
		frame.getContentPane().add(btn_join);
		btn_join.setOpaque(false);

		// joinâ�� �α��� �ٽ� ������ Select_Loginâ�� �ٽ� ��.
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
