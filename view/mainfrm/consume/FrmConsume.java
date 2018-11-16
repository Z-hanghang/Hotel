package view.mainfrm.consume;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import common.gui.GBC;
import control.mainfrm.consume.LsnrConsumeJDlg;
import control.mainfrm.consume.LsnrTblShangPin;

public class FrmConsume extends JDialog {
	public static Vector resultVector = new Vector();
	
	private JLabel lblTime = new JLabel();
	private JButton btnShuaXin = new JButton();
	private JButton btnZiDingYi = new JButton();
	private JButton btnShanChu = new JButton();
//	private JButton btnDaYin = new JButton();
	private JButton btnRuZhang = new JButton();
	private JButton btnGUanBi = new JButton();
	private JButton btnJieSuan = new JButton();
	private JButton btnChaZhao = new JButton();
//	private JButton btnZengJiaXiaoFei = new JButton("增加消费");
	private JTextField txtShangPinMing = new JTextField(15);
	private Object[] shangPinColumnNames = {"商品编号","名称","单价","库存"};
	private DefaultTableModel model1=new DefaultTableModel(new Object[][]{},shangPinColumnNames);
    private JTable tblShangPin = new JTable(model1){
    	public boolean isCellEditable(int row,int column){
    		return false;
    	}
    };
   	
    private static Object[] gouMaiColumnNames = {"房间号","商品名","数量","金额","时间"};
    private static DefaultTableModel model2=new DefaultTableModel(new Object[][]{},gouMaiColumnNames);
    private static JTable tblGouMai = new JTable(model2){
    	public boolean isCellEditable(int row,int column){
    		return false;
    	}
    };
    private JTextField txtFangJianHao = new JTextField(12);
    private JTextField txtRuZhuShiJian = new JTextField(12);
    private JTextField txtXiaoFeiZongE = new JTextField(12);
    private JTextField txtYaJin = new JTextField(12);
    
	public FrmConsume(JDialog ower, String title, boolean modal, String command){
		super(ower, title, modal);
		init();
	}
	
	public JButton getBtnShuaXin() {
		return btnShuaXin;
	}

	public JButton getBtnZiDingYi() {
		return btnZiDingYi;
	}

	public JButton getBtnShanChu() {
		return btnShanChu;
	}

	public JButton getBtnRuZhang() {
		return btnRuZhang;
	}

	public JButton getBtnGuanBi() {
		return btnGUanBi;
	}

	public JButton getBtnJieSuan() {
		return btnJieSuan;
	}

	public JButton getBtnChaZhao() {
		return btnChaZhao;
	}

	public JLabel getLblTime() {
		return lblTime;
	}

	public JTextField getTxtFangJianHao() {
		return txtFangJianHao;
	}

	public JTextField getTxtShangPinMing() {
		return txtShangPinMing;
	}

	public Object[] getShangPinColumnNames() {
		return shangPinColumnNames;
	}

	public JTable getTblShangPin() {
		return tblShangPin;
	}

	public Object[] getGouMaiColumnNames() {
		return gouMaiColumnNames;
	}

	public JTable getTblGouMai() {
		return tblGouMai;
	}

	public static DefaultTableModel getModel2() {
		return model2;
	}

	public static void setModel2(DefaultTableModel model2) {
		FrmConsume.model2 = model2;
	}

	
	public JTextField getTxtRuZhuShiJian() {
		return txtRuZhuShiJian;
	}

	public JTextField getTxtXiaoFeiZongE() {
		return txtXiaoFeiZongE;
	}

	public JTextField getTxtYaJin() {
		return txtYaJin;
	}

	
	private void init(){
		this.setSize(945, 550);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel pnlComp = addComp();
		this.add(pnlComp);
		addListener();
	}
	
	private void addListener(){
		this.btnChaZhao.addActionListener(new LsnrConsumeJDlg(this));
		this.btnShuaXin.addActionListener(new LsnrConsumeJDlg(this));
		this.btnRuZhang.addActionListener(new LsnrConsumeJDlg(this));
		this.btnZiDingYi.addActionListener(new LsnrConsumeJDlg(this));
		this.btnShanChu.addActionListener(new LsnrConsumeJDlg(this));
		this.btnGUanBi.addActionListener(new LsnrConsumeJDlg(this));
		this.tblShangPin.addMouseListener(new LsnrTblShangPin(this));
		this.btnJieSuan.addActionListener(new LsnrConsumeJDlg(this));
	}
	
	private JPanel addComp(){
		JPanel pnlComp = new JPanel();
		pnlComp.setLayout(new BorderLayout());
		
		JPanel pnlNorth = initNorth();
		JPanel pnlCenter = initCenter();
		JPanel pnlWest = initWest();
		
		pnlComp.add(pnlNorth, BorderLayout.NORTH);
		pnlComp.add(pnlCenter, BorderLayout.CENTER);
		pnlComp.add(pnlWest, BorderLayout.WEST);
		
		return pnlComp;
	}
	
	private JPanel initNorth(){
		JPanel pnl = new JPanel();
		pnl.setLayout(new BorderLayout());
		pnl.setBorder(BorderFactory.createEtchedBorder());//.createLineBorder(Color.GRAY, 1));
		
		JPanel pnlNorthWest = initNorthWest();
		
		pnl.add(pnlNorthWest, BorderLayout.WEST);
		
		return pnl;
	}
	
	private JPanel initNorthWest(){
		JPanel pnl = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		pnl.setLayout(gbl);
		
		btnShanChu.setIcon(new ImageIcon("pic/consume/shanchu.png"));
		btnShanChu.setMargin(new Insets(10,30,5,30));//边框间距
		btnShanChu.setContentAreaFilled(false);//按钮透明
		btnShanChu.setBorderPainted(false);
		gbl.setConstraints(btnShanChu, new GBC(0,0,2,1));
		pnl.add(this.btnShanChu);
		
		JLabel lblShanChu = new JLabel("删除");
		gbl.setConstraints(lblShanChu, new GBC(0,1,2,1));
		pnl.add(lblShanChu);
		
		/**打印功能已废弃*/
//		btnDaYin.setIcon(new ImageIcon("image/consume/dayin.jpg"));
//		btnDaYin.setMargin(new Insets(10,30,5,30));
//		btnDaYin.setContentAreaFilled(false);
//		btnDaYin.setBorderPainted(false);
//		gbl.setConstraints(btnDaYin, new GBC(2,0,2,1));
//		pnl.add(this.btnDaYin);
//		
//		JLabel lblDaYin = new JLabel("打印");
//		gbl.setConstraints(lblDaYin, new GBC(2,1,2,1));
//		pnl.add(lblDaYin);
		
		btnRuZhang.setIcon(new ImageIcon("pic/consume/ruzhang.png"));
		btnRuZhang.setMargin(new Insets(10,30,5,30));
		btnRuZhang.setContentAreaFilled(false);
		btnRuZhang.setBorderPainted(false);
		gbl.setConstraints(btnRuZhang, new GBC(2,0,2,1));
		pnl.add(this.btnRuZhang);
		
		JLabel lblRuZhang = new JLabel("入账");
		gbl.setConstraints(lblRuZhang, new GBC(2,1,2,1));
		pnl.add(lblRuZhang);
		
		btnGUanBi.setIcon(new ImageIcon("pic/consume/quxiaoguanbi.png"));
		btnGUanBi.setMargin(new Insets(10,30,5,30));
		btnGUanBi.setContentAreaFilled(false);
		btnGUanBi.setBorderPainted(false);
		gbl.setConstraints(btnGUanBi, new GBC(4,0,2,1));
		pnl.add(this.btnGUanBi);
		
		JLabel lblDanBi = new JLabel("取消");
		gbl.setConstraints(lblDanBi, new GBC(4,1,2,1));
		pnl.add(lblDanBi);
		
		btnJieSuan.setIcon(new ImageIcon("pic/consume/jiesuan.png"));
		btnJieSuan.setMargin(new Insets(10,30,5,30));
		btnJieSuan.setContentAreaFilled(false);
		btnJieSuan.setBorderPainted(false);
		gbl.setConstraints(btnJieSuan, new GBC(6,0,2,1));
		pnl.add(this.btnJieSuan);
		
		JLabel lblJieSuan = new JLabel("退房");
		gbl.setConstraints(lblJieSuan, new GBC(6,1,2,1));
		pnl.add(lblJieSuan);
		
		btnZiDingYi.setIcon(new ImageIcon("pic/consume/zidingyi.png"));
		btnZiDingYi.setMargin(new Insets(10,30,5,30));
		btnZiDingYi.setContentAreaFilled(false);
		btnZiDingYi.setBorderPainted(false);
		gbl.setConstraints(btnZiDingYi, new GBC(8,0,2,1));
		pnl.add(this.btnZiDingYi);
		
		JLabel lblZiDingYi = new JLabel("自定义");
		gbl.setConstraints(lblZiDingYi, new GBC(8,1,2,1));
		pnl.add(lblZiDingYi);
		
		btnShuaXin.setIcon(new ImageIcon("pic/consume/shuaxin.png"));
		btnShuaXin.setMargin(new Insets(10,30,5,30));
		btnShuaXin.setContentAreaFilled(false);
		btnShuaXin.setBorderPainted(false);
		gbl.setConstraints(btnShuaXin, new GBC(10,0,2,1));
		pnl.add(this.btnShuaXin);
		
		JLabel lblShuaXin = new JLabel("刷新");
		gbl.setConstraints(lblShuaXin, new GBC(10,1,2,1));
		pnl.add(lblShuaXin);
		
		gbl.setConstraints(lblTime, new GBC(12,0,2,1).setInsets(new Insets(10,180,0,0)));
		pnl.add(lblTime);
		Timer timer = new Timer();
		timer.schedule(new ShowTime(), new Date(), 1000);
		
		return pnl;
	}
	
	/**
	 * 时间显示方法区，通过
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH : mm : ss ");
	class ShowTime extends TimerTask {	
		public void run() {
			lblTime.setText(sdf.format(new Date()));// 刷新
			repaint();
		}
	}
	
	private JPanel initWest(){
		JPanel pnl = new JPanel();
		pnl.setLayout(new BorderLayout());
		//pnl.setBorder(BorderFactory.createEtchedBorder());//.createLineBorder(Color.GRAY, 1));
		
		JPanel pnlWestNorth = initWestNorth();
		JPanel pnlWestCenter = initWestCenter();
		pnl.add(pnlWestNorth, BorderLayout.NORTH);
		pnl.add(pnlWestCenter, BorderLayout.CENTER);
		
		return pnl;
	}
	
	private JPanel initWestNorth(){
		JPanel pnl = new JPanel();
		
		JLabel lblShangPin = new JLabel("商品查找：");
		pnl.add(lblShangPin);
		pnl.add(this.txtShangPinMing);
		btnChaZhao.setIcon(new ImageIcon("pic/consume/chazhao.png"));
		btnChaZhao.setContentAreaFilled(false);
		btnChaZhao.setBorderPainted(false);	
		pnl.add(btnChaZhao);
		
//		btnZengJiaXiaoFei.setBackground(Color.DARK_GRAY);
//		btnZengJiaXiaoFei.setForeground(Color.white);
//		pnl.add(this.btnZengJiaXiaoFei);
		
		return pnl;
	}
	
	private JPanel initWestCenter(){
		JPanel pnl = new JPanel();
		pnl.setLayout(new BorderLayout());
		
		JScrollPane spnl = new JScrollPane(this.tblShangPin,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnl.add(spnl, BorderLayout.WEST);
		
		return pnl;
	}
	
	private JPanel initCenter(){
		JPanel pnl = new JPanel();
		pnl.setLayout(new BorderLayout());
		//pnl.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

		JPanel pnlCenterNorth = initCenterNorth();
		JPanel pnlCenterCenter = initCenterCenter();
		pnl.add(pnlCenterNorth, BorderLayout.NORTH);
		pnl.add(pnlCenterCenter, BorderLayout.CENTER);
		
		return pnl;
	}
	
	private JPanel initCenterNorth(){
		JPanel pnl = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		pnl.setLayout(gbl);
		
		JLabel lblFangJianHao = new JLabel("当前房号：");
		gbl.setConstraints(lblFangJianHao, new GBC(0,0).setInsets(new Insets(4,4,4,4)));
		pnl.add(lblFangJianHao);
		gbl.setConstraints(txtFangJianHao, new GBC(1,0).setInsets(new Insets(4,4,4,4)));
		txtFangJianHao.setOpaque(false);
		txtFangJianHao.setBorder(new EmptyBorder(0,0,0,0));
		pnl.add(this.txtFangJianHao);
		
		JLabel lblRuZhuShiJian = new JLabel("入住时间：");
		gbl.setConstraints(lblRuZhuShiJian, new GBC(2,0).setInsets(new Insets(4,4,4,4)));
		pnl.add(lblRuZhuShiJian);
		gbl.setConstraints(txtRuZhuShiJian, new GBC(3,0).setInsets(new Insets(4,4,4,4)));
		txtRuZhuShiJian.setOpaque(false);
		txtRuZhuShiJian.setBorder(new EmptyBorder(0,0,0,0));
		pnl.add(this.txtRuZhuShiJian);
		
		JLabel lblXiaoFeiZongE = new JLabel("消费总额：");
		gbl.setConstraints(lblXiaoFeiZongE, new GBC(0,1).setInsets(new Insets(4,4,4,4)));
		pnl.add(lblXiaoFeiZongE);
		gbl.setConstraints(txtXiaoFeiZongE, new GBC(1,1).setInsets(new Insets(4,4,4,4)));
		txtXiaoFeiZongE.setOpaque(false);
		txtXiaoFeiZongE.setBorder(new EmptyBorder(0,0,0,0));
		pnl.add(this.txtXiaoFeiZongE);
		
		JLabel lblYaJin = new JLabel("押        金：");
		gbl.setConstraints(lblYaJin, new GBC(2,1).setInsets(new Insets(4,4,4,4)));
		pnl.add(lblYaJin);
		gbl.setConstraints(txtYaJin, new GBC(3,1).setInsets(new Insets(4,4,4,4)));
		txtYaJin.setOpaque(false);
		txtYaJin.setBorder(new EmptyBorder(0,0,0,0));
		pnl.add(this.txtYaJin);
		
		return pnl;
	}
	
	private JPanel initCenterCenter(){
		JPanel pnl = new JPanel();
		pnl.setLayout(new BorderLayout());
		
		JScrollPane spnl = new JScrollPane(this.tblGouMai,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnl.add(spnl, BorderLayout.CENTER);
		return pnl;
	}
	
	/*public static void main(String[] args) {
		new FrmConsume(null, "商品消费", true, "消费").setVisible(true);
	}*/

}
