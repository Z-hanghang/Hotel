package view.mainfrm.checkinview;

//import ruzhu1016;
//import gui.guanli.FrmMain;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;


import control.mainfrm.checkinControl.LsnrBtnfindcheckin;
import control.mainfrm.checkinControl.LsnrBtnradiobutton;
//import control.xueshengguanli.LsnrBtnxueshengchazhao;
/**
 * @author 沈灵芝
 * 
 * **/
public class Frmcheckin extends JFrame {

	private JTextField txtFangJianHao = new JTextField(15);// 设置文本框大小
	private JTextField Txtgukeming = new JTextField(15);
	private JButton btnkehuChaZhao = new JButton("查  找");// 设置按钮
	private JRadioButton s1 = new JRadioButton("已结账");
	private JRadioButton s2 = new JRadioButton("未结账");
	private JRadioButton s3 = new JRadioButton("显示所有入住信息");// 设置按钮组
	ButtonGroup group = new ButtonGroup();

	private Object[] fangjianColumnNames = { "订单号", "顾客姓名", "顾客类型", "房间号", "房间类型", "入住人数", "押金",
			"入住时间", "退房时间", "结账状态", "操作员工"};
	private JTable tblfangjian = new JTable(new Object[][] {}, fangjianColumnNames);

	public Frmcheckin(String title) {
		super(title);
		init();
	}

	public JTextField getTxtFangJianHao() {// 构造方法
		return txtFangJianHao;
	}

	public Object[] getfangjianColumnNames() {
		return fangjianColumnNames;
	}

	public JTextField getTxtgukeming() {
		// TODO Auto-generated method stub
		return Txtgukeming;
	}

	public JTable gettblfangjian() {
		return tblfangjian;
	}

	private void init() {
		this.setSize(780, 500); // 定义窗体大小
		this.setLocationRelativeTo(null);
		
		JPanel pane = addComp();// 定义一个面板
		addListener();
		this.add(pane); // 加入面板
		this.setVisible(true);// 显示面板
	}

	private JPanel addComp() {
		JPanel pane = new JPanel();// 定义一个面板
		pane.setLayout(new BorderLayout());// 布局管理器

		JPanel ruZhuNorthPane = initRuZhuNorth();
		JPanel ruZhuCenterPane = initRuZhuCenter();
		JPanel ruZhuSouthPane = initRuZhuSouth();

		pane.add(ruZhuNorthPane, BorderLayout.NORTH);// 为布局管理器添加面板
		pane.add(ruZhuCenterPane, BorderLayout.CENTER);
		pane.add(ruZhuSouthPane, BorderLayout.SOUTH);
		
//		JTabbedPane tabPane = initTabPane();// 定义选项卡面板
//		pane.add(tabPane, BorderLayout.CENTER);// 将表格添加到边界布局管理器中间
		return pane;
	}

	private void addListener() {// 监听器设置
		this.btnkehuChaZhao.addActionListener(new LsnrBtnfindcheckin(this));
		this.s1.addActionListener(new LsnrBtnradiobutton(this));
		this.s2.addActionListener(new LsnrBtnradiobutton(this));
		this.s3.addActionListener(new LsnrBtnradiobutton(this));

	}

//	private JTabbedPane initTabPane() {
//		JTabbedPane tabPane = new JTabbedPane();
//
//		// initBanJi(tabPane);
//		initRuZhu(tabPane);
//
//		return tabPane;
//	}
//
//	private void initRuZhu(JTabbedPane tabPane) {
//		JPanel pane = new JPanel();
//		pane.setLayout(new BorderLayout());// 设置布局管理器
//
//		tabPane.addTab("入住信息", pane);
//	}

	private JPanel initRuZhuNorth() {
		JPanel pane = new JPanel();// 定义一个面板

		JLabel lblfangjianhao = new JLabel("房间号：");// 定义一个标签
		pane.add(lblfangjianhao);// 将组件添加到面板上
		pane.add(this.getTxtFangJianHao());

		JLabel lblgukeMing = new JLabel("顾客名 ：");// 定义一个标签
		pane.add(lblgukeMing);// 将组件添加到面板上
		pane.add(this.getTxtgukeming());
		pane.add(this.btnkehuChaZhao);
		return pane;
	}

	private JPanel initRuZhuCenter() {// 添加滚动条
		JPanel pane = new JPanel();// 定义一个面板
		pane.setLayout(new BorderLayout());// 布局管理器
		JScrollPane spane = new JScrollPane(this.tblfangjian, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);// 滚动条
		pane.add(spane, BorderLayout.CENTER);// 添加面板到布局管理器中间
		// pane.setVisible(true);
		return pane;
	}

	private JPanel initRuZhuSouth() {
		JPanel pane = new JPanel();

		group.add(s1);// 将按钮添加到按钮组
		group.add(s2);
		group.add(s3);
		pane.add(s1);// 将按钮添加到面板里
		pane.add(s2);
		pane.add(s3);
		return pane;
	}

	/*public static void main(String[] args) {
		new Frmcheckin("").setVisible(true);
	}*/

	public String getgukebianhao(Object setgukeming) {
		// TODO Auto-generated method stub
		return getgukebianhao(null);
	}

	public Object getS3() {

		return s3;
	}

	public Object getS2() {

		return s2;
	}

	public Object getS1() {

		return s1;
	}
}
