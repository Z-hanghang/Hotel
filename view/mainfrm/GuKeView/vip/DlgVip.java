package view.mainfrm.GuKeView.vip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.component.tools.HotelTools;
import control.mainfrm.GuKe.vip.LsnrQuXiao;
import control.mainfrm.GuKe.vip.LsnrQueDing;
import view.backmain.common.GBC;





public class DlgVip extends JDialog{
	private JTextField txtvipid=new JTextField(20);         //��Ա���
	private JTextField txtcustomerid=new JTextField(20);    //�˿ͱ��
	private JTextField txtmemberid=new JTextField(20);
	private JComboBox boxmemberid = new JComboBox();    //�˿����ͱ��
	String[] members={"MG101","MG102","MG103"};
	private JTextField txtaccountmoney = new JTextField(20);//�����ܶ�
	private JButton btnQueDing = new JButton("ȷ  ��");
	private JButton btnQuXiao = new JButton("ȡ  ��");
	private String command;
	
	private String Vip=HotelTools.getNumber(HotelTools.VIP);
	
	public DlgVip(JFrame ower, String title, boolean modal, String command) {
		super(ower, title, modal);
		this.command = command;
		init();
	}
   
    
	private void addListener() {
		this.btnQueDing.addActionListener(new LsnrQueDing(this));
		this.btnQuXiao.addActionListener(new LsnrQuXiao(this));
	}


	private void init() {
		this.setSize(700, 300);                                      //���ô�С
		this.setLocationRelativeTo(null);                            //����
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);     //�ر�
                                   
		JPanel pane = addComp();                                     //�������
        
		this.add(pane);
		
	}


	private JPanel addComp() {
		JPanel pane = new JPanel();
		//���ñ߽粼�ֹ�����
		pane.setLayout(new BorderLayout());
        //������������ϸ�»���
		JPanel centerPane = initCenter();
		JPanel southPane = initSouth();
        //�����������С����
		pane.add(centerPane, BorderLayout.CENTER);
		pane.add(southPane, BorderLayout.SOUTH);
		
		addListener();
		return pane;
	}
	private JPanel initCenter() {
		/*
		 * ��дJPanel������������ӱ���
		 */
		JPanel pane = new JPanel(){
	        public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("src/image/�ͻ�.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		 };
		
		GridBagLayout layout = new GridBagLayout();  //�в����ֹ�����
		pane.setLayout(layout);
		
		if (command.equals("1")) {
	    	  txtvipid.setText(Vip);
		}
		txtvipid.setEditable(false);
		JLabel lblVipid = new JLabel("��Ա��� ��");
		layout.setConstraints(lblVipid, new GBC(0, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblVipid);
		lblVipid.setForeground(Color.blue);  //������ɫ
		layout.setConstraints(txtvipid, new GBC(1, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		
		pane.add(txtvipid);

	      

		JLabel lblcustomerid = new JLabel("�˿ͱ�ţ�");
		layout.setConstraints(lblcustomerid, new GBC(2, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblcustomerid);
		lblcustomerid.setForeground(Color.blue);

		layout.setConstraints(txtcustomerid, new GBC(3, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtcustomerid);
		

		JLabel lblmemberid = new JLabel(" �˿����ͱ�� ��");
		
		
		layout.setConstraints(lblmemberid, new GBC(0, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblmemberid);
		lblmemberid.setForeground(Color.blue);
		
		
		
		layout.setConstraints(boxmemberid, new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(boxmemberid);
		for(String a:members){
			boxmemberid.addItem(a);
		}
		return pane;

	}
	private JPanel initSouth() {
		JPanel pane = new JPanel(){
	        public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("src/image/�ͻ�.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		 };
        pane.setBackground(Color.darkGray);
		pane.add(this.btnQueDing);
		pane.add(this.btnQuXiao);

		return pane;
	}
	public JTextField getTxtaccountmoney() {
		return txtaccountmoney;
	}


	public void setTxtaccountmoney(JTextField txtaccountmoney) {
		this.txtaccountmoney = txtaccountmoney;
	}


	public JTextField getTxtvipid() {
		return txtvipid;
	}


	public void setTxtvipid(JTextField txtvipid) {
		this.txtvipid = txtvipid;
	}


	public JTextField getTxtcustomerid() {
		return txtcustomerid;
	}


	public void setTxtcustomerid(JTextField txtcustomerid) {
		this.txtcustomerid = txtcustomerid;
	}


	public JTextField getTxtmemberid() {
		return txtmemberid;
	}

	public String getVIP() {
		return Vip;
	}


	public void setTxtmemberid(JTextField txtmemberid) {
		this.txtmemberid = txtmemberid;
	}


	public JButton getBtnQueDing() {
		return btnQueDing;
	}


	public void setBtnQueDing(JButton btnQueDing) {
		this.btnQueDing = btnQueDing;
	}


	public JButton getBtnQuXiao() {
		return btnQuXiao;
	}


	public void setBtnQuXiao(JButton btnQuXiao) {
		this.btnQuXiao = btnQuXiao;
	}


	public String getCommand() {
		return command;
	}


	public void setCommand(String command) {
		this.command = command;
	}
	
	
	public JComboBox getBoxmemberid() {
		return boxmemberid;
	}


	public String[] getMembers() {
		return members;
	}


	
}
