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

public class gui_CategoryChoice {

   private JFrame frame;

//   /**
//    * Launch the application.
//    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               gui_CategoryChoice window = new gui_CategoryChoice();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   /**
    * Create the application.
    */
   public gui_CategoryChoice(File file) {
      initialize(file);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(File file) {
      frame = new JFrame();
      frame.setBounds(100, 100, 279, 610);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // �� ��ư Ŭ���ϸ� ���̺��� ��Ƽ��Ʈ ����Ʈâ(+����������)���� ��.
      JLabel btn_cus = new JLabel("");
      btn_cus.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            frame.dispose();
            gui_Cate_cus_List list = new gui_Cate_cus_List(file);
         }
      });
      btn_cus.setBounds(28, 192, 198, 86);
      frame.getContentPane().add(btn_cus);

      // �۰���ư Ŭ���ϸ� �۰��� ���� �뿩 ��� ����Ʈâ(+����������)���� ��.
      
      JLabel btn_art = new JLabel("");
      btn_art.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            frame.dispose();
            gui_Cate_art_List list = new gui_Cate_art_List(new File(""));
         }
      });
      btn_art.setBounds(28, 288, 198, 86);
      frame.getContentPane().add(btn_art);
      
   // �뿩�� ��ư Ŭ���ϸ� �뿩�ڰ� ���� �۰�����Ʈâ(+����������)���� ��.
      

      JLabel btn_place = new JLabel("");
      btn_place.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            frame.dispose();
            gui_Cate_len_List.main(null);
         }
      });
      btn_place.setBounds(28, 383, 198, 86);
      frame.getContentPane().add(btn_place);
      

      //�������� �������� �Ѿ�� ��ư
      JLabel btn_exhibit = new JLabel("");
      btn_exhibit.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            //���������������� �Ѿ�ϴ�. :��������!!
         }
      });
      btn_exhibit.setBounds(174, 44, 77, 80);
      frame.getContentPane().add(btn_exhibit);
      
      
      
   
   
   // ��׶��� ��μ���
      String url = getClass().getResource("").getPath();
      Image image = new ImageIcon(url + "image/Category.jpg").getImage();
      
      frame.getContentPane().setLayout(null);
      JLabel lbl_cate = new JLabel(new ImageIcon(image));
      lbl_cate.setBounds(0, 0, 263, 571);
      frame.getContentPane().add(lbl_cate);
   }
}