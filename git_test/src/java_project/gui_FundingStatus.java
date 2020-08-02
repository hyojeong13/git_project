package java_project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import javax.swing.JPanel;

public class gui_FundingStatus {

	private JFrame frame;
	private JTable funding_table;
	DAO dao = new DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_FundingStatus window = new gui_FundingStatus();
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
	public gui_FundingStatus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(820, 250,  279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//이전 버튼 
		JLabel lbl_pre = new JLabel("");
		lbl_pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_CategoryChoice cate = new gui_CategoryChoice(new File(""));
			}
		});
		lbl_pre.setBounds(12, 30, 57, 31);
		frame.getContentPane().add(lbl_pre);
		
		//리뷰 버튼
		
		JLabel lbl_review = new JLabel("");
		lbl_review.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				gui_Exhibit_info.main(null);
			}
		});
		lbl_review.setBounds(22, 64, 110, 42);
		frame.getContentPane().add(lbl_review);
		
		///차트 넣기
		JPanel panel = new JPanel();
		panel.setBounds(12, 93, 239, 217);
		frame.getContentPane().add(panel);
		
	    JFreeChart chart = ChartFactory.createPieChart("펀딩홧팅",dao.createDataset(),true, true, false);
	    ChartFrame frame = new ChartFrame("Bigdata3", chart);
	      frame.setBounds(100,100,500,700);
	      frame.setSize(500,700);
	      frame.getChartPanel().setLayout(null);
	      
	      
	      JLabel lblNewLabel = new JLabel("New label");
	      lblNewLabel.setBounds(213, 5, 57, 15);
	      frame.getChartPanel().add(lblNewLabel);
	      
	      JLabel lblNewLabel_1 = new JLabel("New label");

	      lblNewLabel_1.setBounds(36, 48, 90, 66);
	      frame.getChartPanel().add(lblNewLabel_1);
	      frame.setVisible(true);


		
	
		dao.success();
        ArrayList<VO_Funding> list = dao.allSelect_f();
        String colNames[] = {"번호","아이디","목표","현재", "성공","주소"};
        Object data[][] = new Object[list.size()][colNames.length];
           
          for (int i = 0; i < list.size(); i++) {
           data[i][0] = list.get(i).getFunding_num();
           data[i][1] = list.get(i).getId();
           data[i][2] = list.get(i).getGoal();
           data[i][3] = list.get(i).getSum_done();
           data[i][4] = list.get(i).getFunding_s();
           data[i][5] = list.get(i).getAddress();
        }
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 308, 239, 211);
		frame.getContentPane().add(scrollPane);
		
		
		
		funding_table = new JTable(data, colNames){
			public boolean isCellEditable(int rowIndex, int mCollndex) {
				return false;
			}
		};
		
		scrollPane.setViewportView(funding_table);
		
		
		
		//백그라운드 이미지
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/ex_fundingStatus.png").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_art_mypage = new JLabel(new ImageIcon(image));
		
		lbl_art_mypage.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_art_mypage);
		
		
		
		
	}
}
