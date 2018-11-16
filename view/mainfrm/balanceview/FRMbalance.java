package view.mainfrm.balanceview;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.mainfrm.balanceControl.LsnrBtnfindgoods;
import control.mainfrm.balanceControl.LsnrBtnfindroom;

public class FRMbalance extends JFrame {
	
	 private JTextField txtFangJianHaofj = new JTextField(15);
	  private JTextField txtjiezhangzhuangtaifj= new JTextField(15);
	  private JButton btnfangjianChaZhao = new JButton("查  找");
	  private Object[] fangjianColumnNames = {"结算单号","入住单号","顾客姓名","顾客类型","房间号","房间类型","消费总额","已交押金","退还押金","结账状态","备注","操作员工"};
	  private JTable tblfangjian = new JTable(new Object[][]{}, fangjianColumnNames);
	  private JTextField txtFangJianhaosp  = new JTextField(15);
	  private JTextField txtjiezhangzhuangtaisp = new JTextField(15);
	  private JButton btnshangpinChaZhao = new JButton("查  找");
	  private Object[] shangpinColumnNames = {"房间号","顾客姓名","商品名称","购买数量","购买日期","单笔消费","结账状态"};
	  private JTable tblshangpin = new JTable(new Object[][]{}, shangpinColumnNames);
	  
	  public FRMbalance (String title) {//构造方法
	    super(title);
	    init();
	  }
	  
	  public JTextField getTxtfangjianhaofj() {
	    return txtFangJianHaofj;
	  }

	  public JTextField getTxtgukeMing() {
	    return txtjiezhangzhuangtaifj;
	  }

	  public Object[] getfangjianColumnNames() {
	    return fangjianColumnNames;
	  }

	  public JTable getTblfangjian() {
	    return tblfangjian;
	  }
	  public JTable getTblshangpin() {
		return tblshangpin;
	  }
	  public JTextField txtFangJianhaosp() {
	    return txtFangJianhaosp;
	  }
	  public JTextField txtjiezhangzhuangtaifj() {
	    return txtjiezhangzhuangtaifj;
	  }
	  public JTextField txtjiezhangzhuangtaisp() {
	    return txtjiezhangzhuangtaisp;
	  }
	  public Object[] getshangpinColumnNames() {
	    return shangpinColumnNames;
	  }

	
	  private void init() {
	    this.setSize(900,500);//设置窗体大小
	    this.setLocationRelativeTo(null);//将此窗口置于屏幕的中央
	    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//在窗口被关闭的时候会关闭这个窗口
	    this.setResizable(false);
	    
	    JPanel pane = addComp();
	    addListener();
	    
	    this.add(pane);
	    this.setVisible(false);
	  }
	  
	  private JPanel addComp() {
	    JPanel pane = new JPanel();//定义一个面板
	    pane.setLayout(new BorderLayout());//设置布局管理器
	    
	    JTabbedPane tabPane = initTabPane();//选项卡面板
	    pane.add(tabPane, BorderLayout.CENTER);//将面板添加局部管理器的中央
	    
	    return pane;
	  }
	  
	  private void addListener() {//添加监听器
		 this.btnfangjianChaZhao.addActionListener(new LsnrBtnfindroom(this));//房间号查找监听器
		 this.btnshangpinChaZhao.addActionListener(new LsnrBtnfindgoods(this));//商品查找监听器
	  }
	  
	  private JTabbedPane initTabPane() {
	    JTabbedPane tabPane = new JTabbedPane();//定义一个选项卡
	    
	    initJieSuan(tabPane);
	    initShangPin(tabPane);
	    
	    return tabPane;
	  }
	  
	  private void initJieSuan(JTabbedPane tabPane) {
	    JPanel pane = new JPanel();//定义一个面板
	    pane.setLayout(new BorderLayout());//设置布局管理器
	    
	    JPanel jieSuanNorthPane = initJieSuanNorth();
	    JPanel jieSuanCenterPane = initJieSuanCenter();
	    JPanel jieSuanSouthPane = initJieSuanSouth();
	    
	    pane.add(jieSuanNorthPane, BorderLayout.NORTH);
	    pane.add(jieSuanCenterPane, BorderLayout.CENTER);
	    pane.add(jieSuanSouthPane, BorderLayout.SOUTH);
	    
	    tabPane.addTab("结算查询", pane);
	  }
	  
	  private JPanel initJieSuanNorth() {//定义标签，为标签添加文本框
	    JPanel pane = new JPanel();
	    
	    JLabel lblfangjianhao = new JLabel("房间号：");
	    pane.add(lblfangjianhao);
	    pane.add(this.txtFangJianHaofj );
	   
	    JLabel lbljiezhangzhuangtai = new JLabel("结账状态 ：");
	    pane.add(lbljiezhangzhuangtai);
	    pane.add(this.txtjiezhangzhuangtaifj);
	    
	    pane.add(this.btnfangjianChaZhao);
	    
	    return pane;
	  }
	  
	  
	  private JPanel initJieSuanCenter() {
	    JPanel pane = new JPanel();//定义一个面板
	    
	    pane.setLayout(new BorderLayout());
	    
	    JScrollPane spane = new JScrollPane(this.tblfangjian, 
	        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//添加滚动条
	    
	    pane.add(spane, BorderLayout.CENTER);
	    
	    return pane;
	  }
	  
	  private JPanel initJieSuanSouth() {
	    JPanel pane = new JPanel();
	    
	    JLabel lblShuoMing = new JLabel("说明：  结账状态    ‘1’ — 已结账     ‘0’ — 未结账 ");
	    pane.add(lblShuoMing);
	    
	    return pane;
	  }
	  
	  private void initShangPin(JTabbedPane tabPane) {
	    JPanel pane = new JPanel();
	    pane.setLayout(new BorderLayout());//设置布局管理器
	    
	    JPanel shangPinNorthPane = initShangPinNorth();
	    JPanel shangPinCenterPane = initShangPinCenter();
	    JPanel shangPinSouthPane = initShangPinSouth();
	    
	    pane.add(shangPinNorthPane, BorderLayout.NORTH);//为布局管理器添加面板
	    pane.add(shangPinCenterPane, BorderLayout.CENTER);
	    pane.add(shangPinSouthPane, BorderLayout.SOUTH);
	    
	    tabPane.addTab("商品消费", pane);
	  }

	  private JPanel initShangPinNorth() {
	    JPanel pane = new JPanel();//定义一个面板
	    
	    JLabel lblFangJianHao = new JLabel("房间号 ：");//定义一个标签
	    pane.add(lblFangJianHao);//将组件添加到面板上
	    pane.add(this.txtFangJianhaosp);
	    
	    JLabel lblJieZhangZhuangTai = new JLabel("结账状态 ：");
	    pane.add(lblJieZhangZhuangTai);
	    pane.add(this.txtjiezhangzhuangtaisp);
	    pane.add(this.btnshangpinChaZhao);
	    
	    return pane;
	  }
	  
	  private JPanel initShangPinCenter() {
	    JPanel pane = new JPanel();//定义一个面板
	    
	    pane.setLayout(new BorderLayout());//设置布局管理器
	    
	    JScrollPane spane = new JScrollPane(this.tblshangpin, 
	        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//滚动条设置
	    
	    pane.add(spane, BorderLayout.CENTER);
	    
	    return pane;
	  }
	  
	  private JPanel initShangPinSouth() {
	    JPanel pane = new JPanel();
	    
	    JLabel lblShuoMing = new JLabel("说明：  结账状态    ‘1’ — 已结账     ‘0’ — 未结账 ");
	    pane.add(lblShuoMing);
	    
	    return pane;
	  }
	  
	/* public static void main(String[] args) {
	    new FRMbalance("").setVisible(true);
	 }*/
}