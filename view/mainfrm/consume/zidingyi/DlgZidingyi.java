package view.mainfrm.consume.zidingyi;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.gui.GBC;
import control.mainfrm.consume.zidingyi.LsnrZiDingYi;


public class DlgZidingyi extends JDialog {

	private JTextField txtShangPinMing = new JTextField(15);
	private JTextField txtDanJia = new JTextField(15);
	private JTextField txtShuLiang = new JTextField(15);
	
	private JButton btnQueDing = new JButton("确  定");
	private JButton btnQuXiao = new JButton("取  消");
	
	private String command;
	
//	private LsnrZiDingYi LsnrZiDingYi = new LsnrZiDingYi(this);
	
	public DlgZidingyi(JDialog ower, String title, boolean modal, String command){
		super(ower,title,modal);
		this.command = command;
		init();
	}

	public JButton getBtnQueDing() {
		return btnQueDing;
	}

	public JButton getBtnQuXiao() {
		return btnQuXiao;
	}


	public JTextField getTxtShangPinMing() {
		return txtShangPinMing;
	}

	public JTextField getTxtDanJia() {
		return txtDanJia;
	}

	public JTextField getTxtShuLiang() {
		return txtShuLiang;
	}

	public String getCommand() {
		return command;
	}
	
	private void init(){
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel pnlComp = addComp();
		this.add(pnlComp);
		addListener();
	}
	
	private void addListener(){
		this.btnQueDing.addActionListener(new LsnrZiDingYi(this));
		this.txtShangPinMing.addActionListener(new LsnrZiDingYi(this));
	}
	
	private JPanel addComp(){
		JPanel pnl = new JPanel();
		pnl.setLayout(new BorderLayout());
		
		JPanel pnlCenter = initCenter();
		JPanel pnlSouth = initSouth();
		pnl.add(pnlCenter, BorderLayout.CENTER);
		pnl.add(pnlSouth, BorderLayout.SOUTH);
		
		return pnl;
	}
	
	private JPanel initCenter(){
		JPanel pnl = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		pnl.setLayout(gbl);
		
		JLabel lblShangPinMing = new JLabel("商品名：");
		gbl.setConstraints(lblShangPinMing, new GBC(0,0).setInsets(new Insets(5,5,5,5)));
		pnl.add(lblShangPinMing);
		gbl.setConstraints(txtShangPinMing, new GBC(1,0).setInsets(new Insets(5,5,5,5)));
		pnl.add(txtShangPinMing);
		
		JLabel lblDanJia = new JLabel("单    价：");
		gbl.setConstraints(lblDanJia, new GBC(0,1).setInsets(new Insets(5,5,5,5)));
		pnl.add(lblDanJia);
		gbl.setConstraints(txtDanJia, new GBC(1,1).setInsets(new Insets(5,5,5,5)));
		pnl.add(txtDanJia);
		
		JLabel lblShuLiang = new JLabel("数    量：");
		gbl.setConstraints(lblShuLiang, new GBC(0,2).setInsets(new Insets(5,5,5,5)));
		pnl.add(lblShuLiang);
		gbl.setConstraints(txtShuLiang, new GBC(1,2).setInsets(new Insets(5,5,5,5)));
		pnl.add(txtShuLiang);
		
		return pnl;
	}
	
	private JPanel initSouth(){
		JPanel pnl = new JPanel();
		
		pnl.add(btnQueDing);
		pnl.add(btnQuXiao);
		
		return pnl;
	}
}
