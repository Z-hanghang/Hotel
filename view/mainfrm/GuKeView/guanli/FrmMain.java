package view.mainfrm.GuKeView.guanli;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.mainfrm.GuKe.customerguanli.LsnrBtnChaZhao;
import control.mainfrm.GuKe.customerguanli.LsnrBtnShanChu;
import control.mainfrm.GuKe.customerguanli.LsnrBtnXinZeng;
import control.mainfrm.GuKe.customerguanli.LsnrBtnXiuGai;

import control.mainfrm.GuKe.vipguanli.LsnrVipChaZhao;
import control.mainfrm.GuKe.vipguanli.LsnrVipShanChu;

import control.mainfrm.GuKe.vipguanli.LsnrVipXiuGai;
import javax.swing.ImageIcon;



/**
 * 客户管理主界面 ###################################################################
 * 
 * @author 蒋一锋 功能：对客户的信息进行增删改查 创建日期：10/16
 */

public class FrmMain extends JFrame {
	/*
	 * 客户信息模块
	 */
	private JRadioButton rbCustomerTel = new JRadioButton("手机号");
	private JRadioButton rbCustomerName = new JRadioButton("顾客姓名");
	private JTextField txtcustomertel = new JTextField(20);
	private JTextField txtcustomername = new JTextField(20);
	private JTextField txtcustomerid = new JTextField(20);
	public JTextField getTxtcustomerid() {
		return txtcustomerid;
	}



	public void setTxtcustomerid(JTextField txtcustomerid) {
		this.txtcustomerid = txtcustomerid;
	}

	private Object[] CustomerColumnNames = { "顾客编号", "顾客姓名", "性别", "手机号", "身份证号", "顾客类型编号" };
	private JTable tblcustomer = new JTable(new Object[][] {}, CustomerColumnNames);
	private JButton btncustomerchazhao = new JButton("查找");
	private JButton btnaddVip= new JButton("添加会员");
	private JButton btncustomerXinZeng = new JButton("新增");
	private JButton btncustomerXiuGai = new JButton("修  改");
	private JButton btncustomerShanChu = new JButton("删  除");

	// ---------------------------------------------------------------

	

	/*
	 * 会员模块
	 */
	private JTextField txtVipId = new JTextField(20);
	private Object[] VipColumnNames = { "会员编号", "顾客编号", "顾客类型编号" };
	private JTable tblVip = new JTable(new Object[][] {}, VipColumnNames);
	private JButton btnVipChaZhao = new JButton("查找");
	
	private JButton btnVipXiuGai = new JButton("修  改");
	private JButton btnVipShanChu = new JButton("删  除");

	// ---------------------------------------------------------------------------
	public FrmMain(String title) {
		super(title);
		init();
	}

	

	public JButton getBtncustomerXiuGai() {
		return btncustomerXiuGai;
	}



	public JRadioButton getRbCustomerTel() {
		return rbCustomerTel;
	}



	public JRadioButton getRbCustomerName() {
		return rbCustomerName;
	}



	public JTextField getTxtcustomertel() {
		return txtcustomertel;
	}

	public JTextField getTxtcustomername() {
		return txtcustomername;
	}

	public Object[] getCustomerColumnNames() {
		return CustomerColumnNames;
	}

	public JTable getTblcustomer() {
		return tblcustomer;

	}


	public JButton getBtnaddVip() {
		return btnaddVip;
	}



	public JTextField getTxtVipId() {
		return txtVipId;
	}

	public Object[] getVipColumnNames() {
		return VipColumnNames;
	}

	public JTable getTblVip() {
		return tblVip;
	}

	private void init() {
		this.setSize(800, 400); // 设置大小
		this.setLocationRelativeTo(null); // 设置位置
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭时的操作
                this.setIconImage(new ImageIcon("pic/toolsbar/客户.png").getImage());
		JPanel pane = addComp(); // 添加组件
		addListener(); // 添加监听器

		this.add(pane);
		this.setVisible(true); // 设置可视

	}

	private JPanel addComp() {
		JFrame frame = new JFrame();

		JPanel pane = new JPanel(); // 设置面板
		pane.setLayout(new BorderLayout()); // 设置布局管理器

		JTabbedPane tabPane = initTabPane(); // 设置标签
		// 一个组件，它允许用户通过单击具有给定标题和/或图标的选项卡，在一组组件之间进行切换
		pane.add(tabPane, BorderLayout.CENTER);

		return pane;
	}

	/* 放置顾客信息/顾客类型标签/会员 */
	private JTabbedPane initTabPane() {

		JTabbedPane tabPane = new JTabbedPane();

		initCustomer(tabPane);
		
		initVip(tabPane);
		return tabPane;
	}



	

	

	/* 中部顾客信息放置组件 */
	private void initCustomer(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JPanel CustomerNorthPane = initCustomerNorth();
		JPanel CustomerCenterPane = initCustomerCenter();
		JPanel CustomerSouthPane = initCustomerSouth();

		pane.add(CustomerNorthPane, BorderLayout.NORTH);
		pane.add(CustomerCenterPane, BorderLayout.CENTER);
		pane.add(CustomerSouthPane, BorderLayout.SOUTH);

		tabPane.addTab("顾客信息", pane);
	}

	// 北部
	private JPanel initCustomerNorth() {
		JPanel pane = new JPanel();
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbCustomerTel);
        bg.add(rbCustomerName);
		pane.add(this.rbCustomerTel);

		pane.add(this.txtcustomertel);

		pane.add(this.rbCustomerName);

		pane.add(this.txtcustomername);
		pane.add(this.btncustomerchazhao);
		pane.add(btnaddVip);
		return pane;
	}

	// 中部
	private JPanel initCustomerCenter() {
		JPanel pane = new JPanel();

		pane.setLayout(new BorderLayout()); // 设置边框布局管理器

		JScrollPane spane = new JScrollPane(this.tblcustomer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 添加滚动条

		pane.add(spane, BorderLayout.CENTER);

		return pane;
	}

	// 南部
	private JPanel initCustomerSouth() {
		JPanel pane = new JPanel();

		pane.add(this.btncustomerXinZeng);

		pane.add(this.btncustomerXiuGai);

		pane.add(this.btncustomerShanChu);

		return pane;
	}

	private void addListener() {
		/* 顾客信息监听器 */
		this.btncustomerchazhao.addActionListener(new LsnrBtnChaZhao(this)); //顾客查找功能
		this.btncustomerShanChu.addActionListener(new LsnrBtnShanChu(this)); //顾客删除功能
		this.btncustomerXinZeng.addActionListener(new LsnrBtnXinZeng(this)); //顾客新增功能
		this.btncustomerXiuGai.addActionListener(new LsnrBtnXiuGai(this));   //顾客修改功能
		this.btnaddVip.addActionListener(new LsnrBtnXiuGai(this)); 
        /*会员监听器*/
		this.btnVipChaZhao.addActionListener(new LsnrVipChaZhao(this));   //会员查找功能
		this.btnVipShanChu.addActionListener(new LsnrVipShanChu(this));   //会员删除功能
		this.btnVipXiuGai.addActionListener(new LsnrVipXiuGai(this));     //会员修改功能
		   //会员新增功能
	}
    //会员布局
	private void initVip(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		/* 容器分为北，中，南，三部分 */
		JPanel vipNorthPane = initVipNorth();
		JPanel vipCenterPane = initVipCenter();

		pane.add(vipNorthPane,BorderLayout.NORTH);
		pane.add(vipCenterPane, BorderLayout.CENTER);

		tabPane.addTab("会员管理", pane);
		
	}
   //北部
	private JPanel initVipNorth() {
		JPanel pane = new JPanel();
		
		JLabel lblVip = new JLabel("会员编号 ：");
		pane.add(lblVip);
		pane.add(this.txtVipId);
		pane.add(this.btnVipChaZhao);
		pane.add(this.btnVipXiuGai);
	   pane.add(this.btnVipShanChu);
		return pane;
	}
    //中部
	private JPanel initVipCenter() {
		JPanel pane = new JPanel();

		pane.setLayout(new BorderLayout()); // 设置边框布局管理器

		JScrollPane spane = new JScrollPane(this.tblVip, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 添加滚动条

		pane.add(spane, BorderLayout.CENTER);

		return pane;
	}

	/*public static void main(String[] args) {
		new FrmMain("").setVisible(true);
	}*/

	

}
