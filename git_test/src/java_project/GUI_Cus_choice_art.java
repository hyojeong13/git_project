package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI_Cus_choice_art {

	private JFrame frame;
	private File file;
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
					GUI_Cus_choice_art window = new GUI_Cus_choice_art();
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
	public GUI_Cus_choice_art() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(820, 250, 279, 610);
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
		lbl_pre.setBounds(0, 26, 57, 64);
		frame.getContentPane().add(lbl_pre);
		
		
		ArrayList<VO_Artist> artArray= new ArrayList<VO_Artist>();
		artArray=  dao.art_True();
		
		ArrayList<VO_Funding> fundArray = new ArrayList<VO_Funding>();
		fundArray = dao.funding_True();
		
		//작가 아이디
		JLabel lbl_id = new JLabel(artArray.get(0).getId());
		lbl_id.setBounds(108, 102, 132, 28);
		frame.getContentPane().add(lbl_id);
		
		//작가 이름
		JLabel lblname = new JLabel(artArray.get(0).getName());
		lblname.setBounds(108, 145, 132, 28);
		frame.getContentPane().add(lblname);
		
		//전시 주제
		JLabel lbl_title = new JLabel(artArray.get(0).getTitle());
		lbl_title.setBounds(108, 190, 132, 28);
		frame.getContentPane().add(lbl_title);
		
		//목표금액
		JLabel lbl_goal = new JLabel(Integer.toString((fundArray.get(0).getGoal())));
		lbl_goal.setBounds(108, 235, 132, 28);
		frame.getContentPane().add(lbl_goal);
		
		//누적 금액
		JLabel lbl_sum_done = new JLabel(Integer.toString((fundArray.get(0).getSum_done())));
		lbl_sum_done.setBounds(108, 280, 132, 28);
		frame.getContentPane().add(lbl_sum_done);
		
		sum_done = fundArray.get(0).getSum_done();
		
		//전시 시작일
		JLabel lbl_start = new JLabel(artArray.get(0).getStart_d());
		lbl_start.setBounds(108, 325, 132, 28);
		frame.getContentPane().add(lbl_start);
		
		//전시 종료일
		JLabel lbl_end = new JLabel(artArray.get(0).getEnd_d());
		lbl_end.setBounds(108, 368, 132, 28);
		frame.getContentPane().add(lbl_end);
		
		//후원 금액 입력
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
		txt_money.setOpaque(false);
		txt_money.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		
		//후원하기 클릭하기
		JLabel lbl_funding = new JLabel("");
		lbl_funding.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				
				int money  = Integer.parseInt(txt_money.getText());
				sum_done += money;
				dao.updatemoney(sum_done);
				dao.success();
				
				gui_Cate_cus_List cateCus = new gui_Cate_cus_List(new File(""));
				   
				
			}
		});
		lbl_funding.setBounds(0, 521, 263, 50);
		frame.getContentPane().add(lbl_funding);
		
		//background 그림
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cus_choice_art.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_cus_list = new JLabel(new ImageIcon(image));
		lbl_cus_list.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_cus_list);
		
	}
}
