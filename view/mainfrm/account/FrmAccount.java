package view.mainfrm.account;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import common.gui.GBC;
import control.mainfrm.consume.LsnrJieSuanFrm;
import view.logmain.MainView;

public class FrmAccount extends JDialog {

	private JButton btnChaKanMingXi = new JButton("查看明细");
	private JButton btnQueRenJieZhang = new JButton("确认结账");
	private JButton btnQuXiaoJieZhang = new JButton("取消结账");
	private JTextField txtJieZhangDanHao = new JTextField(15);
	private JTextField txtZhuKeFangJian = new JTextField(15);
	private JTextField txtZhuKeXingMing = new JTextField(15);
	private JRadioButton rdbPuTong = new JRadioButton("普通");
	private JRadioButton rdbVip = new JRadioButton("VIP");
	private JRadioButton rdbSvip = new JRadioButton("SVIP");
	private JTextField txtXiaoFeiZongE = new JTextField(15);
	private JTextField txtYouHuiZongE = new JTextField(15);
	private JTextField txtYiFuYaJin = new JTextField(15);
	private JTextField txtYingShouZongE = new JTextField(15);
	private JTextField txtHaiYingZhiFu = new JTextField(15);
	private JTextField txtBinKeZhiFu = new JTextField(15);
	private JTextField txtTuiHuanYaJin = new JTextField(15);
	private JTextArea txtBeiZhu = new JTextArea(10, 30);

	public FrmAccount(JDialog ower, String title, boolean modal){
		super(ower, title, modal);
		init();
	}
	
	public JTextField getTxtTuiHuanYaJin() {
		return txtTuiHuanYaJin;
	}
	
	public JTextField getTxtJieZhangDanHao() {
		return txtJieZhangDanHao;
	}

	public JTextField getTxtZhuKeFangJian() {
		return txtZhuKeFangJian;
	}

	public JTextField getTxtZhuKeXingMing() {
		return txtZhuKeXingMing;
	}

	public JTextField getTxtXiaoFeiZongE() {
		return txtXiaoFeiZongE;
	}

	public JTextField getTxtYouHuiZongE() {
		return txtYouHuiZongE;
	}

	public JTextField getTxtYiFuYaJin() {
		return txtYiFuYaJin;
	}

	public JTextField getTxtYingShouZongE() {
		return txtYingShouZongE;
	}

	public JTextField getTxtHaiYingZhiFu() {
		return txtHaiYingZhiFu;
	}

	public JTextField getTxtBinKeZhiFu() {
		return txtBinKeZhiFu;
	}

	public JTextArea getTxtBeiZhu() {
		return txtBeiZhu;
	}

	public JRadioButton getRdbPuTong() {
		return rdbPuTong;
	}

	public JRadioButton getRdbVip() {
		return rdbVip;
	}

	public JRadioButton getRdbSvip() {
		return rdbSvip;
	}
	
	public JButton getBtnQueRenJieZhang() {
		return btnQueRenJieZhang;
	}

	public JButton getBtnQuXiaoJieZhang() {
		return btnQuXiaoJieZhang;
	}

	private void init(){
		this.setSize(750, 470);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel pnlComp = addComp();
		this.add(pnlComp);
		addListener();
		
	}
	/**
	 * 结算界面的监听器
	 */
	private void addListener(){
		this.txtZhuKeFangJian.addActionListener(new LsnrJieSuanFrm(this));
		this.txtBinKeZhiFu.addActionListener(new LsnrJieSuanFrm(this));
		this.btnQueRenJieZhang.addActionListener(new LsnrJieSuanFrm(this));
		this.btnQuXiaoJieZhang.addActionListener(new LsnrJieSuanFrm(this));
	}
	
	private JPanel addComp(){
		JPanel pnlComp = new JPanel();
		pnlComp.setLayout(new BorderLayout());
		
		JPanel pnlNorth = initNorth();
		JPanel pnlSouth = initSouth();
		
		pnlComp.add(pnlNorth, BorderLayout.NORTH);
		pnlComp.add(pnlSouth, BorderLayout.SOUTH);
		
		return pnlComp;
	}
	
	private JPanel initNorth(){
		JPanel pnl = new JPanel();
		pnl.setLayout(new BorderLayout());
		
		JPanel pnlNorthWest = initNorthWest();
		JPanel pnlNorthEast = initNorthEast();
		
		pnl.add(pnlNorthWest, BorderLayout.WEST);
		pnl.add(pnlNorthEast, BorderLayout.EAST);
		
		return pnl;
	}
	
	private JPanel initNorthWest(){
		JPanel pnl = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		pnl.setLayout(gbl);
		pnl.setBorder(BorderFactory.createEtchedBorder());
		
		JLabel lblJieZhangDanHao = new JLabel("结账单号：");
		gbl.setConstraints(lblJieZhangDanHao, new GBC(0,0,1,1).setInsets(new Insets(20,8,8,8)));
		pnl.add(lblJieZhangDanHao);
		this.txtJieZhangDanHao.setOpaque(false);
		this.txtJieZhangDanHao.setBorder(new EmptyBorder(0,0,0,0));
		gbl.setConstraints(txtJieZhangDanHao, new GBC(1,0,3,1).setInsets(new Insets(20,8,8,8)).setFill(GBC.HORIZONTAL));
		pnl.add(txtJieZhangDanHao);
		
		JLabel lblZhuKeFangJian = new JLabel("主客房间：");
		gbl.setConstraints(lblZhuKeFangJian, new GBC(0,1,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(lblZhuKeFangJian);
		this.txtZhuKeFangJian.setOpaque(false);
		this.txtZhuKeFangJian.setBorder(new EmptyBorder(0,0,0,0));
		gbl.setConstraints(txtZhuKeFangJian, new GBC(1,1,3,1).setInsets(new Insets(8,8,8,8)).setFill(GBC.HORIZONTAL));
		pnl.add(txtZhuKeFangJian);
		
		JLabel lblZhuKeXingMing = new JLabel("主客姓名：");
		gbl.setConstraints(lblZhuKeXingMing, new GBC(0,2,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(lblZhuKeXingMing);
		this.txtZhuKeXingMing.setOpaque(false);
		this.txtZhuKeXingMing.setBorder(new EmptyBorder(0,0,0,0));
		gbl.setConstraints(txtZhuKeXingMing, new GBC(1,2,3,1).setInsets(new Insets(8,8,8,8)).setFill(GBC.HORIZONTAL));
		pnl.add(txtZhuKeXingMing);
		
		JLabel lblZhuKeLeiXing = new JLabel("主客类型：");
		gbl.setConstraints(lblZhuKeLeiXing, new GBC(0,3,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(lblZhuKeLeiXing);
		
		ButtonGroup bg = new ButtonGroup();
	    bg.add(this.rdbPuTong);
	    bg.add(this.rdbVip);
	    bg.add(this.rdbSvip);
		gbl.setConstraints(rdbPuTong, new GBC(1,3,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(rdbPuTong);
		gbl.setConstraints(rdbVip, new GBC(2,3,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(rdbVip);
		gbl.setConstraints(rdbSvip, new GBC(3,3,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(rdbSvip);
		
		JLabel lblXiaoFeiZongE = new JLabel("消费总额：");
		gbl.setConstraints(lblXiaoFeiZongE, new GBC(0,4,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(lblXiaoFeiZongE);
		this.txtXiaoFeiZongE.setOpaque(false);
		this.txtXiaoFeiZongE.setBorder(new EmptyBorder(0,0,0,0));
		gbl.setConstraints(txtXiaoFeiZongE, new GBC(1,4,3,1).setInsets(new Insets(8,8,8,8)).setFill(GBC.HORIZONTAL));
		pnl.add(txtXiaoFeiZongE);
		
		JLabel lblYouHuiZongE = new JLabel("优惠总额：");
		gbl.setConstraints(lblYouHuiZongE, new GBC(0,5,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(lblYouHuiZongE);
		this.txtYouHuiZongE.setOpaque(false);
		this.txtYouHuiZongE.setBorder(new EmptyBorder(0,0,0,0));
		gbl.setConstraints(txtYouHuiZongE, new GBC(1,5,3,1).setInsets(new Insets(8,8,8,8)).setFill(GBC.HORIZONTAL));
		pnl.add(txtYouHuiZongE);
		
		JLabel lblYiFuYaJin = new JLabel("已付押金：");
		gbl.setConstraints(lblYiFuYaJin, new GBC(0,6,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(lblYiFuYaJin);
		this.txtYiFuYaJin.setOpaque(false);
		this.txtYiFuYaJin.setBorder(new EmptyBorder(0,0,0,0));
		gbl.setConstraints(txtYiFuYaJin, new GBC(1,6,3,1).setInsets(new Insets(8,8,8,8)).setFill(GBC.HORIZONTAL));
		pnl.add(txtYiFuYaJin);
		
		JLabel lblYingShouZongE = new JLabel("应收总额：");
		gbl.setConstraints(lblYingShouZongE, new GBC(0,7,1,1).setInsets(new Insets(8,8,20,8)));
		pnl.add(lblYingShouZongE);
		this.txtYingShouZongE.setOpaque(false);
		this.txtYingShouZongE.setBorder(new EmptyBorder(0,0,0,0));
		gbl.setConstraints(this.txtYingShouZongE, new GBC(1,7,3,1).setInsets(new Insets(8,8,20,8)).setFill(GBC.HORIZONTAL));
		pnl.add(txtYingShouZongE);
		
		return pnl;
	}
	
	private JPanel initNorthEast(){
		JPanel pnl = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		pnl.setLayout(gbl);
		pnl.setBorder(BorderFactory.createEtchedBorder());
		
		JLabel lblHaiYingZhiFu = new JLabel("还应支付：");
		gbl.setConstraints(lblHaiYingZhiFu, new GBC(0,0,1,1).setInsets(new Insets(20,8,8,8)));
		pnl.add(lblHaiYingZhiFu);
		this.txtHaiYingZhiFu.setOpaque(false);
		this.txtHaiYingZhiFu.setBorder(new EmptyBorder(0,0,0,0));
		gbl.setConstraints(txtHaiYingZhiFu, new GBC(1,0,3,1).setInsets(new Insets(20,8,8,8)).setFill(GBC.HORIZONTAL));
		pnl.add(txtHaiYingZhiFu);
		
		JLabel lblBinKeZhiFu = new JLabel("宾客支付：");
		gbl.setConstraints(lblBinKeZhiFu, new GBC(0,1,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(lblBinKeZhiFu);
		gbl.setConstraints(txtBinKeZhiFu, new GBC(1,1,3,1).setInsets(new Insets(8,8,8,8)).setFill(GBC.HORIZONTAL));
		pnl.add(txtBinKeZhiFu);
		
		JLabel lblTuiHuanYaJin = new JLabel("退还押金：");
		gbl.setConstraints(lblTuiHuanYaJin, new GBC(0,2,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(lblTuiHuanYaJin);
		gbl.setConstraints(txtTuiHuanYaJin, new GBC(1,2,3,1).setInsets(new Insets(8,8,8,8)).setFill(GBC.HORIZONTAL));
		pnl.add(txtTuiHuanYaJin);
		
		JLabel lblBeiZhu = new JLabel("结账备注：");
		gbl.setConstraints(lblBeiZhu, new GBC(0,3,1,1).setInsets(new Insets(8,8,8,8)));
		pnl.add(lblBeiZhu);
		JScrollPane scpTxtBeiZhu = new JScrollPane(
		        this.txtBeiZhu,
		        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		gbl.setConstraints(scpTxtBeiZhu, new GBC(1,3,1,1).setInsets(new Insets(8,8,20,8)));
		pnl.add(scpTxtBeiZhu);
		
		return pnl;
	}
	
	private JPanel initSouth(){
		JPanel pnl = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		pnl.setLayout(gbl);
		//pnl.setBorder(BorderFactory.createEtchedBorder());
		
		gbl.setConstraints(btnChaKanMingXi, new GBC(0,0).setInsets(new Insets(20,10,30,10)));
		this.btnChaKanMingXi.setBackground(Color.DARK_GRAY);
		this.btnChaKanMingXi.setForeground(Color.white);
		pnl.add(btnChaKanMingXi);
		gbl.setConstraints(btnQueRenJieZhang, new GBC(1,0).setInsets(new Insets(20,20,30,10)));
		this.btnQueRenJieZhang.setBackground(Color.DARK_GRAY);
		this.btnQueRenJieZhang.setForeground(Color.WHITE);
		pnl.add(btnQueRenJieZhang);
		gbl.setConstraints(btnQuXiaoJieZhang, new GBC(2,0).setInsets(new Insets(20,20,30,10)));
		this.btnQuXiaoJieZhang.setBackground(Color.DARK_GRAY);
		this.btnQuXiaoJieZhang.setForeground(Color.WHITE);
		pnl.add(btnQuXiaoJieZhang);
		
		return pnl;
	}
	
    /*public static void main(String[] args) {
	  new FrmAccount(null, "退房结算", true).setVisible(true);
   }*/

}
