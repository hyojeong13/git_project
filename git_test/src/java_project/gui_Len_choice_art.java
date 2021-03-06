package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale.Category;
import javax.swing.JTextField;

public class gui_Len_choice_art {

	//대여자가 아티스트를 선택하는 창
	//gui_Cate_len_List에서 밑에 있는 jtable의 값을 누르면 그 값의 행 정보가 뜸.(선행조건)
	// 선행조건 필수 . 단독으로 들어올 수 없기 때문에 main을 지워줌.
	
	private JFrame frame;
	DAO dao = new DAO();
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					gui_Len_choice_art window = new gui_Len_choice_art();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	public gui_Len_choice_art(VO_Jtablevalue ffinalvalue) {
		initialize(ffinalvalue);
		frame.setVisible(true);
	}

	
	private void initialize(VO_Jtablevalue v) {
		frame = new JFrame();
		frame.setBounds(820, 250, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(GUI_Len_apply_place.goal_l);
				frame.dispose();
				gui_Cate_len_List.main(null);
			}
		});
		lbl_pre.setBounds(0, 22, 57, 60);
		frame.getContentPane().add(lbl_pre);
		
		//null 값 있으면 클릭 ㄴㄴ, 값 다 넣기
	    JLabel lbl_id = new JLabel();
        lbl_id.setBounds(115, 103, 123, 25);
        frame.getContentPane().add(lbl_id);
        lbl_id.setText(v.getA());
	
        JLabel lbl_name = new JLabel();
        lbl_name.setBounds(115, 140, 125, 25);
        frame.getContentPane().add(lbl_name);
        lbl_name.setText(v.getB());
        
        JLabel lbl_title = new JLabel((String) null);
        lbl_title.setBounds(115, 180, 125, 25);
        frame.getContentPane().add(lbl_title);
        lbl_title.setText(v.getC());
        
        
        JLabel lbl_start = new JLabel((String) null);
        lbl_start.setBounds(115, 223, 125, 25);
        frame.getContentPane().add(lbl_start);
        lbl_start.setText(v.getD());
        
        JLabel lbl_end = new JLabel((String) null);
        lbl_end.setBounds(115, 259, 125, 25);
        frame.getContentPane().add(lbl_end);
        lbl_end.setText(v.getE());
        
        JLabel lbl_goodchoice = new JLabel("");
        lbl_goodchoice.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//값이 insert되야함!!!
        		//funding table에 들어갈 value값들 적어줌.
        		//static 변수 의 값들을 가지고 옴
        		String id= v.getA(); //table에서 선택한 
        		int goal = GUI_Len_apply_place.goal_l; //static 변수 - 대여자의 대여금액
        		int sum_done = 0;
        		String funding_s = "X"; //처음에는 펀딩성공 X를 넣어줌
        		String address = GUI_Len_apply_place.address_l; //static 변수 - 대여자의 주소
        		
        		
        		int result = dao.insert_f(id, goal, sum_done, funding_s, address); // 0이면 성공, 1이면 실패

				if (result > 0) {
					JOptionPane.showMessageDialog(null, "아티스트 선택 성공", "아티스트 선택", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					gui_Cate_len_List.main(null);;
				} else {
					JOptionPane.showMessageDialog(null, "아티스트 선택 실패", "아티스트 선택", JOptionPane.ERROR_MESSAGE);
				}
				
				// 선호작가에 넣기
				dao.updateFav_id(id, GUI_Len_apply_place.id_l);	//static변수 id_l을 기준으로 fav_id에 (아티스트의)id를 넣어줌
        	}
        	
        	
        });
        lbl_goodchoice.setBounds(0, 523, 263, 48);
        frame.getContentPane().add(lbl_goodchoice);
        
       
    
        //배경 이미지 넣기 
        String url = getClass().getResource("").getPath();
        Image image = new ImageIcon(url + "image/len_choice_art.jpg").getImage();
        frame.getContentPane().setLayout(null);
        JLabel lbl_lenchoice = new JLabel(new ImageIcon(image));
        lbl_lenchoice.setBounds(0, 0, 263, 571);
        frame.getContentPane().add(lbl_lenchoice);
        
        
      
	}
}
