package view.mainfrm.common;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




/**
 * 小型日历
 * 
 * 
 * 
 * **/


public class TestCalendar extends JFrame {
	JButton b1, b2, b3, b4, b5, b6, b7, bx, by;
	CalendaBean cb = new CalendaBean();
	JLabel[] label;
	JLabel now;
 
	/*public static void main(String[] args) {
		TestCalendar frame = new TestCalendar();
	
		frame.setVisible(true);
		
	}*/
 
	public TestCalendar() {
		setTitle("日历");
		setSize(350, 260);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("pic/rili/日 历.png").getImage());
		int year, month;
		setLayout(new BorderLayout());
		JPanel pNorth = new JPanel();
		cb = new CalendaBean();
		cb.setYear(2018);
		cb.setMonth(11);
		String[] a = cb.getCalendar();
		
		   ImageIcon i1=new ImageIcon("pic/rili/星期日.png");
	       JButton b1 = new JButton(i1); 
           
		   ImageIcon i2=new ImageIcon("pic/rili/星期一.png");
	       JButton b2 = new JButton(i2);  
	       ImageIcon i3=new ImageIcon("pic/rili/星期二.png");
	       JButton b3 = new JButton(i3);  
	       ImageIcon i4=new ImageIcon("pic/rili/星期三.png");
	       JButton b4 = new JButton(i4);  
	       ImageIcon i5=new ImageIcon("pic/rili/星期四.png");
	       JButton b5 = new JButton(i5);
	       ImageIcon i6=new ImageIcon("pic/rili/星期五.png");
	       JButton b6 = new JButton(i6);  
	       ImageIcon i7=new ImageIcon("pic/rili/星期六.png");
	       JButton b7 = new JButton(i7);
	       ImageIcon i8=new ImageIcon("pic/rili/上个月.png");
	       ImageIcon i9=new ImageIcon("pic/rili/下个月.png");
	       
		   
	       
		bx = new JButton("上个月");
		bx.setIcon(i8);
		by = new JButton("下个月");
		by.setIcon(i9);
		bx.setActionCommand("lastmonth");
		by.setActionCommand("nextmonth");
		bx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb.actionPerformed(e);
			}
		});
		by.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb.actionPerformed(e);
			}
		});
		pNorth.add(bx);
		pNorth.add(by);
		add(pNorth, BorderLayout.NORTH);
		GridLayout grid = new GridLayout(7, 7);
		JPanel pCenter = new JPanel();
		
		b1.setIcon(i1);
		b2.setIcon(i2);
		b3.setIcon(i3);
		b4.setIcon(i4);
		b5.setIcon(i5);
		b6.setIcon(i6);
		b7.setIcon(i7);
		
		pCenter.add(b1);
		pCenter.add(b2);
		pCenter.add(b3);
		pCenter.add(b4);
		pCenter.add(b5);
		pCenter.add(b6);
		pCenter.add(b7);
		label = new JLabel[42];
		for (int i = 0; i < 42; i++) {
			label[i] = new JLabel();
			pCenter.add(label[i]);
		}
		cb.label = this.label;
		for (int i = 0; i < a.length; i++) {
			label[i].setText("          "+a[i]);
		}
		pCenter.setLayout(grid);
		add(pCenter, BorderLayout.CENTER);
		JPanel pSouth = new JPanel();
		now = new JLabel();
		now.setText("日历:" + cb.year + "年" + cb.month + "月");
		cb.now = now;
		pSouth.add(now);
		add(pSouth, BorderLayout.SOUTH);
	}
 
}
