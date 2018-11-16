 package view.mainfrm.GuKeView.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import common.component.tools.HotelTools;
import control.mainfrm.GuKe.customer.LsnrBtnQuXiao;
import control.mainfrm.GuKe.customer.LsnrBtnQueDing;
import view.backmain.common.GBC;



/**
 * �ͻ���������
 * @author h
 *���ܣ��Կͻ�����ɾ�Ĳ�
 *����ʱ�䣺10/16
 */
public class DlgCustomer extends JDialog {
	private JTextField txtcustomerid = new JTextField(20);  //�˿ͱ��
	private JTextField txtcustomername = new JTextField(20);//�˿�����
	private JComboBox  boxcustomersex = new JComboBox();; //�˿��Ա�
	String[] sexes={"��","Ů"};
	private JTextField txtcustomertel = new JTextField(20); //�绰
	private JTextField txtcustomercid = new JTextField(20); //���֤��
	private JComboBox boxmemberid = new JComboBox(); //�˿����ͱ��
	String[] members={"MG101","MG102","MG103"};
	private JTextField txtmembername=new JTextField(20);    //�˿���������
	private JTextField txtmembercount=new JTextField(20);   //�ۿ�
	//public static final int G   = 1;        //��ʾ�˿ͱ��
	//public static final int MG  = 2;        //��ʾ�˿����ͱ��
	//private static Properties ini = null;
	private JButton btnQueDing = new JButton("ȷ  ��");
	private JButton btnQuXiao = new JButton("ȡ  ��");
	private String command;
	private String G=HotelTools.getNumber(HotelTools.G);
	public DlgCustomer(JFrame ower, String title, boolean modal, String command) {
		super(ower, title, modal);
		this.command = command;
		init();
	}
	public JTextField getTxtcustomerid() {
		return txtcustomerid;
	}
	
	public JTextField getTxtcustomername() {
		return txtcustomername;
	}
	public JComboBox getBoxcustomersex() {
		return boxcustomersex;
	}

	public String[] getSexes() {
		return sexes;
	}
	

	public JComboBox getBoxmemberid() {
		return boxmemberid;
	}
	public String[] getMembers() {
		return members;
	}
	public JTextField getTxtcustomertel() {
		return txtcustomertel;
	}

	public JTextField getTxtcustomercid() {
		return txtcustomercid;
	}

	

	public String getCommand() {
		return command;
	}
	public String getG() {
		return G;
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

	private void addListener() {
		this.btnQueDing.addActionListener(new LsnrBtnQueDing(this));
		this.btnQuXiao.addActionListener(new LsnrBtnQuXiao(this));
	}

	/*static {
		try	{
			ini = new Properties ();
			ini.load (new FileInputStream ("config.ini"));
		}catch (Exception ex) {
			System.out.println ("the config.ini false!!");
		}//End try
	}*/
    //�в�
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
			 txtcustomerid.setText(G);	
			 //system.println("------");
		 }

		 txtcustomerid.setEditable(false);
		JLabel lblcustomerid = new JLabel("�˿ͱ�� ��");
		layout.setConstraints(lblcustomerid, new GBC(0, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblcustomerid);
		lblcustomerid.setForeground(Color.blue);  //������ɫ
		layout.setConstraints(txtcustomerid, new GBC(1, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtcustomerid);


		JLabel lblcustomername = new JLabel("�˿�������");
		layout.setConstraints(lblcustomername, new GBC(2, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblcustomername);
		lblcustomername.setForeground(Color.blue);

		layout.setConstraints(txtcustomername, new GBC(3, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtcustomername);

		JLabel lblcustomersex = new JLabel("  ��       �� ��");
		
		layout.setConstraints(lblcustomersex, new GBC(0, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblcustomersex);
		lblcustomersex.setForeground(Color.blue);
		
		
		
		layout.setConstraints(boxcustomersex, new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(boxcustomersex);
		for (String a:sexes) {
			boxcustomersex.addItem(a);
		}

		JLabel lblcustomertel = new JLabel("��  ��  �ţ�");
		layout.setConstraints(lblcustomertel, new GBC(2, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblcustomertel);
		
		lblcustomertel.setForeground(Color.blue);
		layout.setConstraints(txtcustomertel, new GBC(3, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtcustomertel);

		JLabel lblcustomercid = new JLabel("���֤�� ��");
		layout.setConstraints(lblcustomercid, new GBC(0, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblcustomercid);
		lblcustomercid.setForeground(Color.blue);
		layout.setConstraints(txtcustomercid, new GBC(1, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtcustomercid);

		JLabel lblmemberid= new JLabel(" �˿����ͱ�� ��");
		layout.setConstraints(lblmemberid, new GBC(2, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblmemberid);
		lblmemberid.setForeground(Color.blue);
		layout.setConstraints(boxmemberid, new GBC(3, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(boxmemberid);
		for (String a:members) {
			boxmemberid.addItem(a);
		}
        pane.setBackground(Color.cyan);
		
		
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
	

}
