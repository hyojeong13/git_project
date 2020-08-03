package java_project;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class gui_Cate_len_List {

	//공간 대여 신청을 누르는 창
	
	private JFrame frame;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_Cate_len_List window = new gui_Cate_len_List();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public gui_Cate_len_List() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(820, 250, 279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// 뒤로 버튼 : category창으로 넘어감니다
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_CategoryChoice choice = new gui_CategoryChoice(new File(""));
			}
		});
		lbl_pre.setBounds(0, 32, 56, 46);
		frame.getContentPane().add(lbl_pre);

		// lender 마이페이지로 넘어갑니다.
		JLabel lbl_len_my = new JLabel("");
		lbl_len_my.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_len_Mypage.main(null);
			}
		});
		lbl_len_my.setBounds(206, 32, 57, 46);
		frame.getContentPane().add(lbl_len_my);
		
		JLabel lbl_applyPlace = new JLabel("");
		lbl_applyPlace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//클릭하면 신청하기 창으로 넘어감
				frame.dispose();
				GUI_Len_apply_place.main(null);
			}
		});
		lbl_applyPlace.setBounds(24, 115, 216, 60);
		frame.getContentPane().add(lbl_applyPlace);

		// 펀딩 신청한 아티스트 목록을 보여줌.
	     DAO dao = new DAO();
         ArrayList<VO_Artist> list = dao.allSelect_artist();
         String colNames[] = {"아이디","이름", "주제", "전시시작일", "전시종료일"};
         Object data[][] = new Object[list.size()][colNames.length];
            
           for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getName();
            data[i][2] = list.get(i).getTitle();
            data[i][3] = list.get(i).getStart_d();
            data[i][4] = list.get(i).getEnd_d();
            
         }
           

		//스크롤 내리기 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 204, 263, 340);
		frame.getContentPane().add(scrollPane);
		
		//테이블 생성 
		table = new JTable(data,colNames) {
			//+ 클릭하면 값 수정되는 것 방지.
			public boolean isCellEditable(int rowIndex, int mCollndex) {
				return false;
			}
		};

		
		//테이블 속 값 클릭하면 정보를 볼 수 있도록 해줌.
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        	int row = table.getSelectedRow();
	        	
				Object value =  table.getValueAt(row, 0).toString(); //아이디
				Object value2 = table.getValueAt(row, 1).toString(); //이름
				Object value3 = table.getValueAt(row, 2).toString(); //주제
				Object value4 = table.getValueAt(row, 3).toString(); //전시 시작일
				Object value5 = table.getValueAt(row, 4).toString(); //전시종료일
				
				
				String finalvalue = (String) value;
				String finalvalue2 = (String) value2;
				String finalvalue3 = (String) value3;
				String finalvalue4 = (String) value4;
				String finalvalue5 = (String) value5;
				
				//VO를 하나 생성해서 안에 넣어줌.
				VO_Jtablevalue ffinalvalue = new VO_Jtablevalue(finalvalue, finalvalue2, finalvalue3, finalvalue4, finalvalue5);
	            
	            gui_Len_choice_art art = new gui_Len_choice_art(ffinalvalue);
	           
	        }
	    });
		
		table.setShowHorizontalLines(false);
		
		scrollPane.setViewportView(table);

		// background 그림 :lender 
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/cateLen.jpg").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_len_list = new JLabel(new ImageIcon(image));
		lbl_len_list.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_len_list);
		
		
	}
	
}
