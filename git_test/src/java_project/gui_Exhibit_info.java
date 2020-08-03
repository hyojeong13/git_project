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

	//���� ���� ��.
	
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
      
         //�ڷ� ���� ������ ī�װ�â���� ���ϴ�.
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
         
         //�ݵ� ��Ȳ ���̺�� ��.
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
         
         //���̵�, ��¥, ���� �Է�.
         //�ı��ۼ� : id �Է�
         txt_id = new JTextField();
         txt_id.setBounds(59, 385, 169, 21);
         frame.getContentPane().add(txt_id);
         txt_id.setColumns(10);
         txt_id.setOpaque(false);
         txt_id.setBorder(null);
         
         //�ı��ۼ� : ��¥ �Է�
         txt_date = new JTextField();
         txt_date.setColumns(10);
         txt_date.setBounds(59, 425, 169, 21);
         frame.getContentPane().add(txt_date);
         txt_date.setOpaque(false);
         txt_date.setBorder(null);
         
         //�ı��ۼ� : ���� �Է�
         txt_review = new JTextField();
         txt_review.setColumns(10);
         txt_review.setBounds(59, 460, 169, 21);
         frame.getContentPane().add(txt_review);
         txt_review.setOpaque(false);
         txt_review.setBorder(null);
         
         // insert�� �Ϸ� â ��������.
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
               if (cnt > 0) { // ����
                  // ���� �˾�â ����
                  // �Ű����� - �θ�������Ʈ, �޼���(���), ����, �����ܸ��
                  JOptionPane.showMessageDialog(null, "���並 �����ּż� �����մϴ�!", "����", JOptionPane.INFORMATION_MESSAGE);
                 
                  //�����ϸ�, �����ٰ� �ٽ� ����. -���� ���̺� �Է��� ���� �ö�Դ��� Ȯ��.
                  frame.dispose();
                  gui_Exhibit_info.main(null);
               } else {
                  // ���� �� �˾�â
                  JOptionPane.showMessageDialog(null, "���� ��� ����", "����", JOptionPane.ERROR_MESSAGE);
               }
            }
         });
         btn_review_insert.setBounds(12, 491, 239, 21);
         frame.getContentPane().add(btn_review_insert);
         
         //���� ���� Ȯ��
         DAO dao = new DAO();
         ArrayList<VO_Review> list = dao.allSelect();
         String colNames[] = {"id","��¥","�����ı�"};
         Object data[][] = new Object[list.size()][colNames.length];
            
           for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getEx_date();
            data[i][2] = list.get(i).getEx_review();
         }
         
           
         //scroll������ �κ�
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
            scrollPane.setBounds(12, 91, 239, 275);
            frame.getContentPane().add(scrollPane);
            
            
            //���̺� ����
            table = new JTable(data,colNames)
            {
    			public boolean isCellEditable(int rowIndex, int mCollndex) {
    				return false;
    			}
    		};
         
            //��ũ�� �ϸ� ���̺� ���̰� �ϱ�
            scrollPane.setViewportView(table);
      
         //��� �̹��� �ֱ� 
         String url = getClass().getResource("").getPath();
         Image image = new ImageIcon(url + "image/ex_review.png").getImage();
         frame.getContentPane().setLayout(null);
         JLabel lbl_art_mypage = new JLabel(new ImageIcon(image));
         lbl_art_mypage.setBounds(0, 0, 263, 571);
         frame.getContentPane().add(lbl_art_mypage);
         
         
         
         

   }
}