package java_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;

import javax.swing.JPanel;

public class gui_FundingStatus {

	//�ݵ� ��Ȳ ����
	
	private JFrame frame;
	private JTable funding_table;
	DAO dao = new DAO();

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

	
	public gui_FundingStatus() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(820, 250,  279, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���� ��ư 
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
		
		//���� ���� ��ư
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
		
		
	      // ��Ʈ �ֱ�!!!

	      JFreeChart chart = ChartFactory.createPieChart("", dao.createDataset(dao.cntSuccess(),dao.cntProceed()), true, true, false);

	      chart.getTitle().setFont(new Font("�������", Font.BOLD,20));
	      chart.getLegend().setItemFont(new Font("�������", Font.PLAIN, 15));

	//   CategoryPlot plot = chart.getCategoryPlot();
	//   CategoryToPieDataset pie = chart.getCategoryPlot()

	      PiePlot plot = (PiePlot) chart.getPlot();
	      plot.setBackgroundPaint(new Color(255, 255, 255, 0));
	  //  plot.setBackgroundImageAlpha(0.0f); //�ȵǴ� �ڵ�
	      plot.setOutlinePaint(null);
	      plot.setShadowPaint(null); //�׸��� ���ֱ�
	      plot.setSectionPaint("����", new Color(67, 116, 217)); // plot���� �ٲٴ� ���, key������ �󺧸� ���� �˴ϴ�!
	      plot.setSectionPaint("������", new Color(158, 213, 97)); // ^^�������� ������ ��Ź�ؿ� ^^...:)
	      plot.setLabelGenerator(null);
	      // chart.setBorderPaint(Color.white);
	      ChartPanel pan = new ChartPanel(chart);
	      pan.setBounds(-13, 150, 200, 200);
	      pan.setSize(290, 200);
	      pan.setVisible(true);
	      frame.getContentPane().add(pan);
		
		
		//�ݵ� ��Ȳ jtable
        ArrayList<VO_Funding> list = dao.allSelect_f();
        String colNames[] = {"��ȣ","���̵�","��ǥ","����", "����","�ּ�"};
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
		scrollPane.setBounds(12, 350, 239, 169);
		frame.getContentPane().add(scrollPane);
		
		funding_table = new JTable(data, colNames){
			//�� ���� ���ϰ� �ϱ�
			public boolean isCellEditable(int rowIndex, int mCollndex) {
				return false;
			}
		};
		
		scrollPane.setViewportView(funding_table);
		
		
		
		//��׶��� �̹���
		String url = getClass().getResource("").getPath();
		Image image = new ImageIcon(url + "image/ex_fundingStatus.png").getImage();
		frame.getContentPane().setLayout(null);
		JLabel lbl_art_mypage = new JLabel(new ImageIcon(image));
		
		lbl_art_mypage.setBounds(0, 0, 263, 571);
		frame.getContentPane().add(lbl_art_mypage);
		
		
		
		
	}
}
