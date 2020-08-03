package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//main ������(�α��� ��)
public class gui_main {

	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_main window = new gui_main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public gui_main() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(820, 250, 279,610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//�ƹ����� Ŭ���ϸ� �α����������� �Ѿ
		JLabel lbl_click = new JLabel("");
		lbl_click.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Select_Login.main(null);
				
			}
		});
		lbl_click.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_click);
		
		
		//��׶��� �׸�
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/main.jpg").getImage();
		JLabel lbl_img = new JLabel(new ImageIcon(image));
		lbl_img.setBounds(0, 0, 260, 571);
		frame.getContentPane().add(lbl_img);
		
	}
}
