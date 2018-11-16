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
 * 登记入住的主界面
 * 
 * @author 陈浩
 *
 */
public class FrmRuZhuRoom extends JDialog {
	public String[] ydlx = {};// new String[0];// 存放房间类型包厢
	public String[] fjbh = {};// ;// 根据相应包间类型显示可供类型包厢
	private static String YDState;
	private static String YDId;
	JLabel labrzbh; // 入住编号
	JLabel labhybh; // 会员编号
	JLabel labbkxm; // 宾客姓名
	JLabel labbklx; // 宾客类型
	JLabel lablxdh; // 联系电话
	JLabel labgkxb; // 顾客性别
	JLabel labsfz; // 身份证号码

	JLabel labfjlx; // 房间类型
	JLabel labfjbh; // 房间编号
	JLabel labrzsj; // 入住时间
	JLabel labtfsj; // 退房时间
	JLabel labrs; // 入住人数
	JLabel labyj; // 押金

	JTextField txtrzbh;// 入住编号
	TJTextField txtHybh;// 会员编号
	JTextField txtbkxm;// 宾客姓名
	JTextField txtbklx;// 宾客类型
	JTextField txtlxdh;// 联系电话
	JTextField txtsfz;// 身份证号码

	// JTextField txtydsj;//入住时间
	// JTextField txttfsj;//退房时间
	JTextField txtrs; // 入住人数
	JTextField txtyj; // 押金

	JComboBox comfjlx;// 房间类型
	JComboBox comfjbh;// 包间编号
	JComboBox comgkxb;// 顾客性别

	JButton baocun;// 保存
	JButton quxiao;// 取消

	public LsnrResideFrmBtn lsnrResideFrmBtn = new LsnrResideFrmBtn(this);

	private Date TuiFangTime=new Date();
	JDatePicker ruzhudatePickerFrom = // 日历插件
			new JDatePicker(JDatePicker.STYLE_CN_DATETIME);

	JDatePicker tuifangdatePickerFrom = // 日历插件
			new JDatePicker(JDatePicker.STYLE_CN_DATETIME,tuiFangTime());

	public FrmRuZhuRoom(JDialog ower, String title, boolean modal, String command) {
		super(ower, title, modal);
		this.setIconImage(new ImageIcon("pic/RuZhu/入住.png").getImage());
		// 初始化标签
		labrzbh = new JLabel("入住编号:");
		labrzbh.setIcon(new ImageIcon("pic/backimages/Employee/员工号.png"));

		labhybh = new JLabel("会员编号:");
		labhybh.setIcon(new ImageIcon("pic/RuZhu/会员.png"));

		labbkxm = new JLabel("宾客姓名:");
		labbkxm.setIcon(new ImageIcon("pic/backimages/Employee/姓名.png"));

		labbklx = new JLabel("宾客类型:");
		labbklx.setIcon(new ImageIcon("pic/YuDing/顾客类型.png"));

		lablxdh = new JLabel("联系电话:");
		lablxdh.setIcon(new ImageIcon("pic/backimages/Employee/电话.png"));

		labgkxb = new JLabel("顾客性别:");
		labgkxb.setIcon(new ImageIcon("pic/backimages/Employee/姓别.png"));

		labsfz = new JLabel("身份证:");
		labsfz.setIcon(new ImageIcon("pic/backimages/Employee/身份证.png"));

		labfjlx = new JLabel("房间类型:");
		labfjlx.setIcon(new ImageIcon("pic/backimages/Room/房间名.png"));

		labfjbh = new JLabel("房间编号:");
		labfjbh.setIcon(new ImageIcon("pic/YuDing/房间编号.png"));

		labrzsj = new JLabel("入住时间:");
		labrzsj.setIcon(new ImageIcon("pic/YuDing/预定时间.png"));

		labtfsj = new JLabel("退房时间:");
		labtfsj.setIcon(new ImageIcon("pic/YuDing/预定时间.png"));

		labrs = new JLabel("入住人数:");
		labrs.setIcon(new ImageIcon("pic/RuZhu/人数.png"));

		labyj = new JLabel("押  金 :");
		labyj.setIcon(new ImageIcon("pic/RuZhu/押金.png"));
		// 初始化文本框
		txtrzbh = new JTextField();// 预定编号 自动生成
		txtrzbh.setEditable(false);// 预定编号文本框不可编辑
		txtHybh = new TJTextField("", 10); // 会员编号
		txtbkxm = new JTextField();// 宾客姓名
		txtbklx = new JTextField(); // 宾客类型
		// txtbklx.setEditable(false);//宾客类型文本框不可编辑
		txtlxdh = new JTextField();// 联系电话
		txtsfz = new JTextField();// 身份证号码

		txtrs = new JTextField();// 备注
		txtyj = new JTextField("", 4);// 押金
		// 初始化下拉框
		String[] gkxb = { "男", "女" };

		comfjlx = new JComboBox(ydlx);
		comfjbh = new JComboBox(fjbh);
		comgkxb = new JComboBox(gkxb);

		// 初始化按钮
		baocun = new JButton("保  存", new ImageIcon("pic/toolsbar/save.gif"));
		quxiao = new JButton("取  消", new ImageIcon("pic/toolsbar/u01.gif"));

		// 初始化面板 ---添加背景
		JPanel pane = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("pic/backimages/动态纯色.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		};
		pane.setBackground(new ColorUIResource(243, 208, 100));
		pane.setLayout(null);

		JLabel labYudingjibenxingxi = new JLabel("开 房  基  本  信  息");
		labYudingjibenxingxi.setFont(new Font("宋体", Font.PLAIN, 22));// 设置字体大小
		labYudingjibenxingxi.setBounds(270, 10, 580, 20);
		labYudingjibenxingxi.setForeground(Color.darkGray);// 设置字体颜色
		pane.add(labYudingjibenxingxi);

		labrzbh.setBounds(30, 30, 100, 70); // 入住编号
		labrzbh.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小
		// labrzbh.setForeground(Color.blue);// 设置字体颜色
		pane.add(labrzbh);
		txtrzbh.setBounds(120, 50, 150, 30);
		pane.add(txtrzbh);

		labhybh.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 //会与编号
		// labhybh.setForeground(Color.blue);// 设置字体颜色
		labhybh.setBounds(290, 30, 100, 70);
		pane.add(labhybh);
		txtHybh.setBounds(380, 50, 150, 30);
		pane.add(txtHybh);

		labbkxm.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 // 宾客姓名
		// labbkxm.setForeground(Color.blue);// 设置字体颜色
		labbkxm.setBounds(550, 30, 100, 70);
		pane.add(labbkxm);
		txtbkxm.setBounds(650, 50, 100, 30);
		pane.add(txtbkxm);

		labbklx.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 //宾客类型
		// labbklx.setForeground(Color.blue);// 设置字体颜色
		labbklx.setBounds(30, 100, 100, 70);
		pane.add(labbklx);
		txtbklx.setBounds(120, 120, 150, 30);
		pane.add(txtbklx);

		lablxdh.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 // 联系电话
		// lablxdh.setForeground(Color.blue);// 设置字体颜色
		lablxdh.setBounds(290, 100, 100, 70);
		pane.add(lablxdh);
		txtlxdh.setBounds(380, 120, 150, 30);
		pane.add(txtlxdh);

		labgkxb.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 // 宾客性别
		// labgkxb.setForeground(Color.blue);// 设置字体颜色
		labgkxb.setBounds(550, 100, 100, 70);
		pane.add(labgkxb);
		comgkxb.setBounds(650, 120, 100, 30);
		pane.add(comgkxb);

		labbkxm.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 // 宾客姓名
		// labbkxm.setForeground(Color.blue);// 设置字体颜色
		labbkxm.setBounds(550, 30, 100, 70);
		pane.add(labbkxm);
		txtbkxm.setBounds(650, 50, 100, 30);
		pane.add(txtbkxm);

		labfjlx.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 // 房间类型
		// labfjlx.setForeground(Color.blue);// 设置字体颜色
		labfjlx.setBounds(30, 170, 100, 70);
		pane.add(labfjlx);
		comfjlx.setBounds(120, 190, 100, 30);
		pane.add(comfjlx);

		labfjbh.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 // 房间编号
		// labfjbh.setForeground(Color.blue);// 设置字体颜色
		labfjbh.setBounds(290, 170, 100, 70);
		pane.add(labfjbh);
		comfjbh.setBounds(380, 190, 100, 30);
		pane.add(comfjbh);

		labsfz.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 // 身份证号码
		// labsfz.setForeground(Color.blue);// 设置字体颜色
		labsfz.setBounds(520, 170, 100, 70);
		pane.add(labsfz);
		txtsfz.setBounds(600, 190, 160, 30);
		pane.add(txtsfz);

		labrzsj.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 // 入住时间
		// labrzsj.setForeground(Color.blue);// 设置字体颜色
		labrzsj.setBounds(30, 240, 100, 70);
		pane.add(labrzsj);
		ruzhudatePickerFrom.setBounds(120, 260, 150, 30);
		pane.add(ruzhudatePickerFrom);

		// txtydsj.setEditable(false);
		// txtblsj.setEditable(false);

		labtfsj.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 // 退房时间
		// labtfsj.setForeground(Color.blue);// 设置字体颜色
		labtfsj.setBounds(480, 240, 100, 70);
		pane.add(labtfsj);
		tuifangdatePickerFrom.setBounds(610, 260, 150, 30);
		pane.add(tuifangdatePickerFrom);

		labrs.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 // 入住人数
		// labrs.setForeground(Color.blue);// 设置字体颜色
		labrs.setBounds(30, 310, 100, 70);
		pane.add(labrs);
		txtrs.setBounds(120, 330, 150, 30);
		pane.add(txtrs);

		labyj.setFont(new Font("宋体", Font.PLAIN, 14));// 设置字体大小 // 退房时间
		// labyj.setForeground(Color.blue);// 设置字体颜色
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

	/* 监听器 */
	private void addLisener() {
		this.baocun.addActionListener(lsnrResideFrmBtn);
		this.quxiao.addActionListener(lsnrResideFrmBtn);
		this.txtHybh.addActionListener(lsnrResideFrmBtn);
		this.txtlxdh.addActionListener(lsnrResideFrmBtn);
		this.comfjlx.addActionListener(lsnrResideFrmBtn);

	}

	public JTextField getTxtrzbh() { // 入住编号
		return txtrzbh;
	}

	public JTextField getTxtHybh() { // 会员编号
		return txtHybh;
	}

	public JTextField getTxtbkxm() { // 宾客姓名
		return txtbkxm;
	}

	public JTextField getTxtbklx() { // 宾客类型
		return txtbklx;
	}

	public JTextField getTxtlxdh() { // 联系电话
		return txtlxdh;
	}

	public JTextField getTxtsfz() { // 身份证
		return txtsfz;
	}

	public JTextField getTxtrs() { // 入住人数
		return txtrs;
	}

	public JTextField getTxtyj() { // 押金
		return txtyj;
	}

	public JComboBox getComfjlx() { // 房间类型
		return comfjlx;
	}

	public static String getYDId() {
		return YDId;
	}

	public static void setYDId(String yDId) {
		YDId = yDId;
	}

	public JComboBox getComfjbh() { // 房间编号
		return comfjbh;
	}

	public JComboBox getComgkxb() { // 顾客性别
		return comgkxb;
	}

	public JButton getBaocun() { // 保存按钮
		return baocun;
	}

	public JButton getQuxiao() { // 取消按钮
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
		// 日期监听器
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
		new FrmRuZhuRoom(null, "入住登记", true, "修改").setVisible(true);
	}*/
}
