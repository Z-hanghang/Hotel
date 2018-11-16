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
		// �ɱ༭����ʱ����
		datePickerFrom = new JDatePicker(JDatePicker.STYLE_CN_DATETIME);

		// ��java.util.Date��ʽ��Ϊһ��String������ӡ���
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDate = formatter.format(datePickerFrom.getSelectedDate().getTime());// �ӽ����ȡ���������
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			datePickerFrom.setSelectedDate(new Date());// ���ý��������ʾ������
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(new JLabel("���˷�ʱ��:"));
		c.add(datePickerFrom);

		this.getContentPane().add(c, BorderLayout.CENTER);

		// ����Ķ������һ��JDatePicker
		JPanel yuanTime = new JPanel();
		ytime = new JLabel("ԭ�˷�ʱ��");
		yuanTime.add(ytime);
		this.getContentPane().add(yuanTime, BorderLayout.NORTH);

		JPanel anniu = new JPanel();
		queding = new JButton("ȷ��");
		quxiao = new JButton("ȡ��");
		anniu.add(queding);
		anniu.add(quxiao);
		this.getContentPane().add(anniu, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//������
		addListener();

	}

	private void addListener() {
		this.queding.addActionListener(new XuFanglsnr(this));   //ȷ����ť
		this.quxiao.addActionListener(new XuFanglsnr(this));    //ȡ����ť
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
		new FrmXuFang(null, "����", true).setVisible(true);
	}*/
}
