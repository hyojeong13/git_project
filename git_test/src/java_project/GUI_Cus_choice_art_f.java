package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class GUI_Cus_choice_art_f {

	private File file;
	private JFrame frame;
	private JTextField txt_money;
	DAO dao = new DAO();
	int sum_done;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Cus_choice_art_f window = new GUI_Cus_choice_art_f();
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
	public GUI_Cus_choice_art_f() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//뒤로 가기
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Cate_cus_List cateCus = new gui_Cate_cus_List(new File(""));
			}
		});
		lbl_pre.setBounds(12, 42, 40, 38);
		frame.getContentPane().add(lbl_pre);
		
		
		ArrayList<VO_Artist> artArr = new ArrayList<VO_Artist>();
		artArr = dao.art_Faker();
		
		ArrayList<VO_Funding> funArr = new ArrayList<VO_Funding>();
		funArr = dao.funding_faker();
		
		//작가 아이디
		JLabel lbl_id = new JLabel(artArr.get(0).getId());
		lbl_id.setBounds(108, 102, 132, 28);
		frame.getContentPane().add(lbl_id);
		
		//이름
		JLabel lbl_name = new JLabel(artArr.get(0).getName());
		lbl_name.setBounds(108, 145, 132, 28);
		frame.getContentPane().add(lbl_name);
		
		//제목
		JLabel lbl_title = new JLabel(artArr.get(0).getTitle());
		lbl_title.setBounds(108, 193, 132, 28);
		frame.getContentPane().add(lbl_title);
		
		//목표금액
		JLabel lbl_goal = new JLabel(Integer.toString((funArr.get(0).getGoal())));
		lbl_goal.setBounds(108, 235, 132, 28);
		frame.getContentPane().add(lbl_goal);
		
		JLabel lbl_sum_done = new JLabel(Integer.toString((funArr.get(0).getSum_done())));
		lbl_sum_done.setBounds(108, 281, 132, 28);
		frame.getContentPane().add(lbl_sum_done);
		
		sum_done =  (funArr.get(0).getSum_done());
		
		//전시 시작일
		JLabel lbl_start = new JLabel(artArr.get(0).getStart_d());
		lbl_start.setBounds(108, 325, 132, 28);
		frame.getContentPane().add(lbl_start);
		
		JLabel lbl_end = new JLabel(artArr.get(0).getEnd_d());
		lbl_end.setBounds(108, 368, 132, 28);
		frame.getContentPane().add(lbl_end);
		
		txt_money = new JTextField("금액을 입력해주세요");
		txt_money.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_money.setText("");
			}
		});
		
		txt_money.setBounds(105, 478, 131, 26);
		frame.getContentPane().add(txt_money);
		txt_money.setColumns(10);
		
		//후원하기 누르기
		JLabel lbl_funding = new JLabel("");
		lbl_funding.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				
				int money = Integer.parseInt(txt_money.getText());
				sum_done += money;
				dao.updatemoney_f(sum_done);
				
				gui_Cate_cus_List cateCus = new gui_Cate_cus_List(new File(""));
			}
		});
		lbl_funding.setBounds(0, 520, 263, 50);
		frame.getContentPane().add(lbl_funding);
		
		
		// background 그림
				String url = getClass().getResource("").getPath();
				Image image = new ImageIcon(url + "image/cus_choice_art.jpg").getImage();
				frame.getContentPane().setLayout(null);
				JLabel lbl_cus_list = new JLabel(new ImageIcon(image));
				lbl_cus_list.setBounds(0, 0, 263, 571);
				frame.getContentPane().add(lbl_cus_list);
	}
}
