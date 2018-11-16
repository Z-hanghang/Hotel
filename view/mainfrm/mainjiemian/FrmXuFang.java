package view.mainfrm.mainjiemian;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.mainfrm.mainjiemian.xufang.XuFanglsnr;
import view.backmain.common.JDatePicker;

public class FrmXuFang extends JDialog {
	private JButton queding;
	private JButton quxiao;
	public static JLabel ytime;
	private static JDatePicker datePickerFrom;

	public FrmXuFang(JDialog ower, String title, boolean modal) {
		super(ower, title, modal);
		this.setSize(400, 150);
		this.setLocationRelativeTo(null);
		JPanel c = new JPanel();
		// c.add(new JLabel("From:"));
		// 可编辑，带时分秒
		datePickerFrom = new JDatePicker(JDatePicker.STYLE_CN_DATETIME);

		// 把java.util.Date格式化为一个String，并打印输出
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDate = formatter.format(datePickerFrom.getSelectedDate().getTime());// 从界面获取输入的日期
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			datePickerFrom.setSelectedDate(new Date());// 设置界面组件显示的日期
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(new JLabel("新退房时间:"));
		c.add(datePickerFrom);

		this.getContentPane().add(c, BorderLayout.CENTER);

		// 窗体的顶部添加一个JDatePicker
		JPanel yuanTime = new JPanel();
		ytime = new JLabel("原退房时间");
		yuanTime.add(ytime);
		this.getContentPane().add(yuanTime, BorderLayout.NORTH);

		JPanel anniu = new JPanel();
		queding = new JButton("确定");
		quxiao = new JButton("取消");
		anniu.add(queding);
		anniu.add(quxiao);
		this.getContentPane().add(anniu, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//监听器
		addListener();

	}

	private void addListener() {
		this.queding.addActionListener(new XuFanglsnr(this));   //确定按钮
		this.quxiao.addActionListener(new XuFanglsnr(this));    //取消按钮
	}

	public JButton getQueding() {
		return queding;
	}

	public JButton getQuxiao() {
		return quxiao;
	}

	public JLabel getYtime() {
		return ytime;
	}
	
	public JDatePicker getDatePickerFrom() {
		return datePickerFrom;
	}

	/*public static void main(String[] args) {
		new FrmXuFang(null, "续房", true).setVisible(true);
	}*/
}
