package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JTextField;

public class GUI_Len_apply_place {

	//대여자(lender)가 공간 대여를 신청하는 창
	
   DAO dao = new DAO();
   private JFrame frame;
   private JTextField txt_address;
   private JTextField txt_id;
   private JTextField txt_money;

   //스테틱... 쓰지 말라고 했는데 어쩔 수 없었습니다....
   //lender의 아이디, 주소, 목표금액을 static변수로 선언해서
   //뒤에서 계속 쓸 수 있도록 했음.
   static public String id_l;
   static public String address_l;
   static public int goal_l;
   
  
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GUI_Len_apply_place window = new GUI_Len_apply_place();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   
   public GUI_Len_apply_place() {
      initialize();
   }

   private void initialize() {
      frame = new JFrame();
      frame.setBounds(820, 250, 279, 610);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //뒤로가기 버튼. 카테고리창(고객, 아티스트, 대여자를 선택하는 창)으로 넘어감.
      JLabel lbl_pre = new JLabel("");
      lbl_pre.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            frame.dispose();
            gui_Cate_len_List.main(null);
         }
      });
      lbl_pre.setBounds(12, 22, 57, 57);
      frame.getContentPane().add(lbl_pre);

      txt_address = new JTextField();
      txt_address.setBounds(102, 86, 149, 43);
      frame.getContentPane().add(txt_address);
      txt_address.setColumns(10);
      txt_address.setOpaque(false);
      txt_address.setBorder(null);

      txt_id = new JTextField();
      txt_id.setColumns(10);
      txt_id.setBounds(102, 145, 149, 29);
      frame.getContentPane().add(txt_id);
      txt_id.setOpaque(false);
      txt_id.setBorder(null);

      txt_money = new JTextField();
      txt_money.setColumns(10);
      txt_money.setBounds(102, 185, 149, 29);
      frame.getContentPane().add(txt_money);
      txt_money.setOpaque(false);
      txt_money.setBorder(null);

      JLabel lbl_place = new JLabel("");
      lbl_place.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {

        	//스테틱 변수에 넣어줌..
        	id_l = txt_id.getText();
        	address_l = txt_address.getText();
        	goal_l = Integer.parseInt(txt_money.getText());

        	//대여자 전용 창이기 때문에 category는 lender로만 넣어줌.
            String category = "lender";
            String fav_id = null;
            //fav_id는 나중에 대여해주기를 선택했을 때 선택된 아티스트의 id가 들어감.
            
            VO_Lender vo_l = new VO_Lender(id_l, category, fav_id, address_l, goal_l);

            int result = dao.place_len(vo_l); // 0이면 성공, 1이면 실패

            if (result > 0) {
               JOptionPane.showMessageDialog(null, "대여신청 성공", "대여신청", JOptionPane.INFORMATION_MESSAGE);

               frame.dispose();
               gui_Cate_len_List.main(null);
               
            } else {
               JOptionPane.showMessageDialog(null, "대여신청 실패!", "대여신청", JOptionPane.ERROR_MESSAGE);
            }

         }
      });
      lbl_place.setBounds(0, 521, 263, 50);
      frame.getContentPane().add(lbl_place);

      // background 그림
      String url = getClass().getResource("").getPath();
      Image image = new ImageIcon(url + "image/len_apply_place.jpg").getImage();
      frame.getContentPane().setLayout(null);
      JLabel lbl_cus_list = new JLabel(new ImageIcon(image));
      lbl_cus_list.setBounds(0, 0, 263, 571);
      frame.getContentPane().add(lbl_cus_list);
   }
}