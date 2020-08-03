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

	//고객이 아티스트를 후원할 수 있는 페이지
	//gui_Cate_cus_List 에서 위 사진들을 누르면 들어오는 페이지
	//새로 업로드 한 사진을 빼면 모두 다 fake로 들어옴 ㅎ_ㅎ 훼이크다 
	
	private File file;
	private JFrame frame;
	private JTextField txt_money;
	DAO dao = new DAO();
	//누적 금액을 필드에서 선언. 0을 넣으면 누적 금액이 계속 0이 됨.
	int sum_done;

	
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

	
	public GUI_Cus_choice_art_f() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(820, 250,279, 610);
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
		
		//art_Faker를 불러옴 - ArrayList형태
		ArrayList<VO_Artist> artArr = new ArrayList<VO_Artist>();
		artArr = dao.art_Faker();
		
		//funArr를 불러옴 - ArrayList형태 
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
		
		//목표 금액은 funArr의 sum_done(누적금액)임. 계속해서 누적해주기 위해.
		sum_done =  (funArr.get(0).getSum_done());
		
		//전시 시작일
		JLabel lbl_start = new JLabel(artArr.get(0).getStart_d());
		lbl_start.setBounds(108, 325, 132, 28);
		frame.getContentPane().add(lbl_start);
		
		//전시 종료일
		JLabel lbl_end = new JLabel(artArr.get(0).getEnd_d());
		lbl_end.setBounds(108, 368, 132, 28);
		frame.getContentPane().add(lbl_end);
		
		//후원할 금액 입력
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
				//입력한 돈을 sum_done에 누적 시켜줌
				int money = Integer.parseInt(txt_money.getText());
				sum_done += money;
				dao.updatemoney_f(sum_done);
				//누적 금액이 목표금액과 같거나 많아지면 funding_s(펀딩성공유무)를 X에서 O로 바꿔줌
				dao.success();
				
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
