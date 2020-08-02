package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JTextField;

public class GUI_Art_apply_funding {

	private JFrame frame;
	private File file;
	private JTextField txt_id;
	private JTextField txt_name;
	private JTextField txt_title;
	private JTextField txt_startD;
	private JTextField txt_endD;
	DAO dao = new DAO();

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
				chooser.setCurrentDirectory(new File("C:\\Users\\SMT015\\Desktop\\파일"));
				int val = chooser.showSaveDialog(null);

				if (val == 0) {
					file = chooser.getSelectedFile();
					Image image = new ImageIcon(file.getPath()).getImage();
					lbl_photo1.setIcon(new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				}

			}
		});
		lbl_photo1.setBounds(88, 373, 88, 88);
		frame.getContentPane().add(lbl_photo1);

		txt_id = new JTextField();
		txt_id.setBounds(109, 81, 132, 29);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);
		txt_id.setOpaque(false);
		txt_id.setBorder(null);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(109, 120, 132, 29);
		frame.getContentPane().add(txt_name);
		txt_name.setOpaque(false);
		txt_name.setBorder(null);
		
		txt_title = new JTextField();
		txt_title.setColumns(10);
		txt_title.setBounds(109, 168, 126, 29);
		frame.getContentPane().add(txt_title);
		txt_title.setOpaque(false);
		txt_title.setBorder(null);
		
		txt_startD = new JTextField();
		txt_startD.setColumns(10);
		txt_startD.setBounds(109, 226, 116, 29);
		frame.getContentPane().add(txt_startD);
		txt_startD.setOpaque(false);
		txt_startD.setBorder(null);
		
		txt_endD = new JTextField();
		txt_endD.setColumns(10);
		txt_endD.setBounds(109, 265, 116, 29);
		frame.getContentPane().add(txt_endD);
		txt_endD.setOpaque(false);
		txt_endD.setBorder(null);
		
		
		//지원하기 누르는 버튼 값 넣는 부분 , 꼭 커밋해서 값 넣기!!!!!!!!!!!!!!!!!!
		JLabel lbl_artapply = new JLabel("");
		lbl_artapply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = txt_id.getText();
				String name = txt_name.getText();
				String title = txt_title.getText();
				String start_d = txt_startD.getText();
				String end_d = txt_endD.getText();
				String category = "artist";
				
				VO_Artist vo_a = new VO_Artist(id, name, category, title, start_d, end_d);
				int cnt = dao.insert_artist(vo_a);
				
				if (cnt > 0) { // 성공
					
					JOptionPane.showMessageDialog(null, "펀딩신청 성공", "펀딩신청", JOptionPane.INFORMATION_MESSAGE);
					
					frame.dispose();
					gui_Cate_art_List cate = new gui_Cate_art_List(file);
				} else {
					// 실패 시 팝업창
					JOptionPane.showMessageDialog(null, "펀딩신청 실패!", "펀딩신청", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		lbl_artapply.setBounds(0, 518, 263, 53);
		frame.getContentPane().add(lbl_artapply);
		
		
		
		// background 그림
				String url = getClass().getResource("").getPath();
				Image image = new ImageIcon(url + "image/art_apply_funding.jpg").getImage();
				frame.getContentPane().setLayout(null);
				JLabel lbl_cus_list = new JLabel(new ImageIcon(image));
				lbl_cus_list.setBounds(0, 0, 263, 571);
				frame.getContentPane().add(lbl_cus_list);
	}
}
