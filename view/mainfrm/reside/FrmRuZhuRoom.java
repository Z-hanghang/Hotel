package view.mainfrm.reside;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;

import common.component.swings.TJTextField;
import control.mainfrm.residefrm.LsnrResideFrmBtn;
import view.backmain.common.JDatePicker;

/**
 * �Ǽ���ס��������
 * 
 * @author �º�
 *
 */
public class FrmRuZhuRoom extends JDialog {
	public String[] ydlx = {};// new String[0];// ��ŷ������Ͱ���
	public String[] fjbh = {};// ;// ������Ӧ����������ʾ�ɹ����Ͱ���
	private static String YDState;
	private static String YDId;
	JLabel labrzbh; // ��ס���
	JLabel labhybh; // ��Ա���
	JLabel labbkxm; // ��������
	JLabel labbklx; // ��������
	JLabel lablxdh; // ��ϵ�绰
	JLabel labgkxb; // �˿��Ա�
	JLabel labsfz; // ���֤����

	JLabel labfjlx; // ��������
	JLabel labfjbh; // ������
	JLabel labrzsj; // ��סʱ��
	JLabel labtfsj; // �˷�ʱ��
	JLabel labrs; // ��ס����
	JLabel labyj; // Ѻ��

	JTextField txtrzbh;// ��ס���
	TJTextField txtHybh;// ��Ա���
	JTextField txtbkxm;// ��������
	JTextField txtbklx;// ��������
	JTextField txtlxdh;// ��ϵ�绰
	JTextField txtsfz;// ���֤����

	// JTextField txtydsj;//��סʱ��
	// JTextField txttfsj;//�˷�ʱ��
	JTextField txtrs; // ��ס����
	JTextField txtyj; // Ѻ��

	JComboBox comfjlx;// ��������
	JComboBox comfjbh;// ������
	JComboBox comgkxb;// �˿��Ա�

	JButton baocun;// ����
	JButton quxiao;// ȡ��

	public LsnrResideFrmBtn lsnrResideFrmBtn = new LsnrResideFrmBtn(this);

	private Date TuiFangTime=new Date();
	JDatePicker ruzhudatePickerFrom = // �������
			new JDatePicker(JDatePicker.STYLE_CN_DATETIME);

	JDatePicker tuifangdatePickerFrom = // �������
			new JDatePicker(JDatePicker.STYLE_CN_DATETIME,tuiFangTime());

	public FrmRuZhuRoom(JDialog ower, String title, boolean modal, String command) {
		super(ower, title, modal);
		this.setIconImage(new ImageIcon("pic/RuZhu/��ס.png").getImage());
		// ��ʼ����ǩ
		labrzbh = new JLabel("��ס���:");
		labrzbh.setIcon(new ImageIcon("pic/backimages/Employee/Ա����.png"));

		labhybh = new JLabel("��Ա���:");
		labhybh.setIcon(new ImageIcon("pic/RuZhu/��Ա.png"));

		labbkxm = new JLabel("��������:");
		labbkxm.setIcon(new ImageIcon("pic/backimages/Employee/����.png"));

		labbklx = new JLabel("��������:");
		labbklx.setIcon(new ImageIcon("pic/YuDing/�˿�����.png"));

		lablxdh = new JLabel("��ϵ�绰:");
		lablxdh.setIcon(new ImageIcon("pic/backimages/Employee/�绰.png"));

		labgkxb = new JLabel("�˿��Ա�:");
		labgkxb.setIcon(new ImageIcon("pic/backimages/Employee/�ձ�.png"));

		labsfz = new JLabel("���֤:");
		labsfz.setIcon(new ImageIcon("pic/backimages/Employee/���֤.png"));

		labfjlx = new JLabel("��������:");
		labfjlx.setIcon(new ImageIcon("pic/backimages/Room/������.png"));

		labfjbh = new JLabel("������:");
		labfjbh.setIcon(new ImageIcon("pic/YuDing/������.png"));

		labrzsj = new JLabel("��סʱ��:");
		labrzsj.setIcon(new ImageIcon("pic/YuDing/Ԥ��ʱ��.png"));

		labtfsj = new JLabel("�˷�ʱ��:");
		labtfsj.setIcon(new ImageIcon("pic/YuDing/Ԥ��ʱ��.png"));

		labrs = new JLabel("��ס����:");
		labrs.setIcon(new ImageIcon("pic/RuZhu/����.png"));

		labyj = new JLabel("Ѻ  �� :");
		labyj.setIcon(new ImageIcon("pic/RuZhu/Ѻ��.png"));
		// ��ʼ���ı���
		txtrzbh = new JTextField();// Ԥ����� �Զ�����
		txtrzbh.setEditable(false);// Ԥ������ı��򲻿ɱ༭
		txtHybh = new TJTextField("", 10); // ��Ա���
		txtbkxm = new JTextField();// ��������
		txtbklx = new JTextField(); // ��������
		// txtbklx.setEditable(false);//���������ı��򲻿ɱ༭
		txtlxdh = new JTextField();// ��ϵ�绰
		txtsfz = new JTextField();// ���֤����

		txtrs = new JTextField();// ��ע
		txtyj = new JTextField("", 4);// Ѻ��
		// ��ʼ��������
		String[] gkxb = { "��", "Ů" };

		comfjlx = new JComboBox(ydlx);
		comfjbh = new JComboBox(fjbh);
		comgkxb = new JComboBox(gkxb);

		// ��ʼ����ť
		baocun = new JButton("��  ��", new ImageIcon("pic/toolsbar/save.gif"));
		quxiao = new JButton("ȡ  ��", new ImageIcon("pic/toolsbar/u01.gif"));

		// ��ʼ����� ---��ӱ���
		JPanel pane = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("pic/backimages/��̬��ɫ.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		};
		pane.setBackground(new ColorUIResource(243, 208, 100));
		pane.setLayout(null);

		JLabel labYudingjibenxingxi = new JLabel("�� ��  ��  ��  ��  Ϣ");
		labYudingjibenxingxi.setFont(new Font("����", Font.PLAIN, 22));// ���������С
		labYudingjibenxingxi.setBounds(270, 10, 580, 20);
		labYudingjibenxingxi.setForeground(Color.darkGray);// ����������ɫ
		pane.add(labYudingjibenxingxi);

		labrzbh.setBounds(30, 30, 100, 70); // ��ס���
		labrzbh.setFont(new Font("����", Font.PLAIN, 14));// ���������С
		// labrzbh.setForeground(Color.blue);// ����������ɫ
		pane.add(labrzbh);
		txtrzbh.setBounds(120, 50, 150, 30);
		pane.add(txtrzbh);

		labhybh.setFont(new Font("����", Font.PLAIN, 14));// ���������С //������
		// labhybh.setForeground(Color.blue);// ����������ɫ
		labhybh.setBounds(290, 30, 100, 70);
		pane.add(labhybh);
		txtHybh.setBounds(380, 50, 150, 30);
		pane.add(txtHybh);

		labbkxm.setFont(new Font("����", Font.PLAIN, 14));// ���������С // ��������
		// labbkxm.setForeground(Color.blue);// ����������ɫ
		labbkxm.setBounds(550, 30, 100, 70);
		pane.add(labbkxm);
		txtbkxm.setBounds(650, 50, 100, 30);
		pane.add(txtbkxm);

		labbklx.setFont(new Font("����", Font.PLAIN, 14));// ���������С //��������
		// labbklx.setForeground(Color.blue);// ����������ɫ
		labbklx.setBounds(30, 100, 100, 70);
		pane.add(labbklx);
		txtbklx.setBounds(120, 120, 150, 30);
		pane.add(txtbklx);

		lablxdh.setFont(new Font("����", Font.PLAIN, 14));// ���������С // ��ϵ�绰
		// lablxdh.setForeground(Color.blue);// ����������ɫ
		lablxdh.setBounds(290, 100, 100, 70);
		pane.add(lablxdh);
		txtlxdh.setBounds(380, 120, 150, 30);
		pane.add(txtlxdh);

		labgkxb.setFont(new Font("����", Font.PLAIN, 14));// ���������С // �����Ա�
		// labgkxb.setForeground(Color.blue);// ����������ɫ
		labgkxb.setBounds(550, 100, 100, 70);
		pane.add(labgkxb);
		comgkxb.setBounds(650, 120, 100, 30);
		pane.add(comgkxb);

		labbkxm.setFont(new Font("����", Font.PLAIN, 14));// ���������С // ��������
		// labbkxm.setForeground(Color.blue);// ����������ɫ
		labbkxm.setBounds(550, 30, 100, 70);
		pane.add(labbkxm);
		txtbkxm.setBounds(650, 50, 100, 30);
		pane.add(txtbkxm);

		labfjlx.setFont(new Font("����", Font.PLAIN, 14));// ���������С // ��������
		// labfjlx.setForeground(Color.blue);// ����������ɫ
		labfjlx.setBounds(30, 170, 100, 70);
		pane.add(labfjlx);
		comfjlx.setBounds(120, 190, 100, 30);
		pane.add(comfjlx);

		labfjbh.setFont(new Font("����", Font.PLAIN, 14));// ���������С // ������
		// labfjbh.setForeground(Color.blue);// ����������ɫ
		labfjbh.setBounds(290, 170, 100, 70);
		pane.add(labfjbh);
		comfjbh.setBounds(380, 190, 100, 30);
		pane.add(comfjbh);

		labsfz.setFont(new Font("����", Font.PLAIN, 14));// ���������С // ���֤����
		// labsfz.setForeground(Color.blue);// ����������ɫ
		labsfz.setBounds(520, 170, 100, 70);
		pane.add(labsfz);
		txtsfz.setBounds(600, 190, 160, 30);
		pane.add(txtsfz);

		labrzsj.setFont(new Font("����", Font.PLAIN, 14));// ���������С // ��סʱ��
		// labrzsj.setForeground(Color.blue);// ����������ɫ
		labrzsj.setBounds(30, 240, 100, 70);
		pane.add(labrzsj);
		ruzhudatePickerFrom.setBounds(120, 260, 150, 30);
		pane.add(ruzhudatePickerFrom);

		// txtydsj.setEditable(false);
		// txtblsj.setEditable(false);

		labtfsj.setFont(new Font("����", Font.PLAIN, 14));// ���������С // �˷�ʱ��
		// labtfsj.setForeground(Color.blue);// ����������ɫ
		labtfsj.setBounds(480, 240, 100, 70);
		pane.add(labtfsj);
		tuifangdatePickerFrom.setBounds(610, 260, 150, 30);
		pane.add(tuifangdatePickerFrom);

		labrs.setFont(new Font("����", Font.PLAIN, 14));// ���������С // ��ס����
		// labrs.setForeground(Color.blue);// ����������ɫ
		labrs.setBounds(30, 310, 100, 70);
		pane.add(labrs);
		txtrs.setBounds(120, 330, 150, 30);
		pane.add(txtrs);

		labyj.setFont(new Font("����", Font.PLAIN, 14));// ���������С // �˷�ʱ��
		// labyj.setForeground(Color.blue);// ����������ɫ
		labyj.setBounds(480, 310, 100, 70);
		pane.add(labyj);
		txtyj.setBounds(610, 330, 150, 30);
		pane.add(txtyj);

		baocun.setBounds(200, 420, 90, 40);
		pane.add(baocun);
		quxiao.setBounds(450, 420, 90, 40);
		pane.add(quxiao);

		addLisener();

		this.add(pane);
		this.setSize(800, 550);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);

	}

	/* ������ */
	private void addLisener() {
		this.baocun.addActionListener(lsnrResideFrmBtn);
		this.quxiao.addActionListener(lsnrResideFrmBtn);
		this.txtHybh.addActionListener(lsnrResideFrmBtn);
		this.txtlxdh.addActionListener(lsnrResideFrmBtn);
		this.comfjlx.addActionListener(lsnrResideFrmBtn);

	}

	public JTextField getTxtrzbh() { // ��ס���
		return txtrzbh;
	}

	public JTextField getTxtHybh() { // ��Ա���
		return txtHybh;
	}

	public JTextField getTxtbkxm() { // ��������
		return txtbkxm;
	}

	public JTextField getTxtbklx() { // ��������
		return txtbklx;
	}

	public JTextField getTxtlxdh() { // ��ϵ�绰
		return txtlxdh;
	}

	public JTextField getTxtsfz() { // ���֤
		return txtsfz;
	}

	public JTextField getTxtrs() { // ��ס����
		return txtrs;
	}

	public JTextField getTxtyj() { // Ѻ��
		return txtyj;
	}

	public JComboBox getComfjlx() { // ��������
		return comfjlx;
	}

	public static String getYDId() {
		return YDId;
	}

	public static void setYDId(String yDId) {
		YDId = yDId;
	}

	public JComboBox getComfjbh() { // ������
		return comfjbh;
	}

	public JComboBox getComgkxb() { // �˿��Ա�
		return comgkxb;
	}

	public JButton getBaocun() { // ���水ť
		return baocun;
	}

	public JButton getQuxiao() { // ȡ����ť
		return quxiao;
	}

	public JDatePicker getRuzhudatePickerFrom() {
		return ruzhudatePickerFrom;
	}

	public static String getYDState() {
		return YDState;
	}

	public static void setYDState(String yDState) {
		YDState = yDState;
	}

	public JDatePicker getTuifangdatePickerFrom() {
		return tuifangdatePickerFrom;
	}

	public Date tuiFangTime() {
		// ���ڼ�����
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=null;
		try {
		    d = (Date) ruzhudatePickerFrom.getSelectedDate();

			Calendar calendar = new GregorianCalendar();
			calendar.setTime(d);
			calendar.add(calendar.DATE, 1);
			d = (Date) calendar.getTime();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return d;
	}

	/*public static void main(String[] args) {
		new FrmRuZhuRoom(null, "��ס�Ǽ�", true, "�޸�").setVisible(true);
	}*/
}
