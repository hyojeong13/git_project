package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class gui_Exhibit_info {

	//리뷰 쓰는 곳.
	
   private JFrame frame;
   private JTable table;
   private JTextField txt_id;
   private JTextField txt_date;
   private JTextField txt_review;
   
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               gui_Exhibit_info window = new gui_Exhibit_info();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

  
   public gui_Exhibit_info() {
      initialize();
   }

   
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(820, 250, 279, 610);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
         //뒤로 가기 누르면 카테고리창으로 갑니다.
         JLabel lbl_pre = new JLabel("");
         lbl_pre.setBounds(0, 10, 57, 29);
         lbl_pre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               frame.dispose();
               gui_CategoryChoice cate = new gui_CategoryChoice(new File(""));
            }
         });
         frame.getContentPane().setLayout(null);
         frame.getContentPane().add(lbl_pre);
         
         //펀딩 현황 테이블로 감.
         JLabel lbl_Status = new JLabel("");
         lbl_Status.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               frame.dispose();
               gui_FundingStatus.main(null);
            }
         });
         lbl_Status.setBounds(129, 33, 122, 56);
         frame.getContentPane().add(lbl_Status);
         
         //아이디, 날짜, 리뷰 입력.
         //후기작성 : id 입력
         txt_id = new JTextField();
         txt_id.setBounds(59, 385, 169, 21);
         frame.getContentPane().add(txt_id);
         txt_id.setColumns(10);
         txt_id.setOpaque(false);
         txt_id.setBorder(null);
         
         //후기작성 : 날짜 입력
         txt_date = new JTextField();
         txt_date.setColumns(10);
         txt_date.setBounds(59, 425, 169, 21);
         frame.getContentPane().add(txt_date);
         txt_date.setOpaque(false);
         txt_date.setBorder(null);
         
         //후기작성 : 내용 입력
         txt_review = new JTextField();
         txt_review.setColumns(10);
         txt_review.setBounds(59, 460, 169, 21);
         frame.getContentPane().add(txt_review);
         txt_review.setOpaque(false);
         txt_review.setBorder(null);
         
         // insert후 완료 창 만들어야함.
         JLabel btn_review_insert = new JLabel("");
         btn_review_insert.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               DAO dao = new DAO();
               String id = txt_id.getText();
               String date = txt_date.getText();
               String review = txt_review.getText();

               VO_Review vo = new VO_Review(id, date, review);
               int cnt = dao.insert_r(vo);
               if (cnt > 0) { // 성공
                  // 성공 팝업창 띄우기
                  // 매개변수 - 부모컴포넌트, 메세지(출력), 제목, 아이콘모양
                  JOptionPane.showMessageDialog(null, "리뷰를 남겨주셔서 감사합니다!", "리뷰", JOptionPane.INFORMATION_MESSAGE);
                 
                  //성공하면, 꺼졌다가 다시 들어옴. -위의 테이블에 입력한 것이 올라왔는지 확인.
                  frame.dispose();
                  gui_Exhibit_info.main(null);
               } else {
                  // 실패 시 팝업창
                  JOptionPane.showMessageDialog(null, "리뷰 등록 실패", "리뷰", JOptionPane.ERROR_MESSAGE);
               }
            }
         });
         btn_review_insert.setBounds(12, 491, 239, 21);
         frame.getContentPane().add(btn_review_insert);
         
         //리뷰 내용 확인
         DAO dao = new DAO();
         ArrayList<VO_Review> list = dao.allSelect();
         String colNames[] = {"id","날짜","한줄후기"};
         Object data[][] = new Object[list.size()][colNames.length];
            
           for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getEx_date();
            data[i][2] = list.get(i).getEx_review();
         }
         
           
         //scroll내리는 부분
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
            scrollPane.setBounds(12, 91, 239, 275);
            frame.getContentPane().add(scrollPane);
            
            
            //테이블 생성
            table = new JTable(data,colNames)
            {
    			public boolean isCellEditable(int rowIndex, int mCollndex) {
    				return false;
    			}
    		};
         
            //스크롤 하면 테이블 보이게 하기
            scrollPane.setViewportView(table);
      
         //배경 이미지 넣기 
         String url = getClass().getResource("").getPath();
         Image image = new ImageIcon(url + "image/ex_review.png").getImage();
         frame.getContentPane().setLayout(null);
         JLabel lbl_art_mypage = new JLabel(new ImageIcon(image));
         lbl_art_mypage.setBounds(0, 0, 263, 571);
         frame.getContentPane().add(lbl_art_mypage);
         
         
         
         

   }
}