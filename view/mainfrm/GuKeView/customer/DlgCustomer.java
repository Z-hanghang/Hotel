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
 * 客户二级界面
 * @author h
 *功能：对客户的增删改查
 *创建时间：10/16
 */
public class DlgCustomer extends JDialog {
	private JTextField txtcustomerid = new JTextField(20);  //顾客编号
	private JTextField txtcustomername = new JTextField(20);//顾客名称
	private JComboBox  boxcustomersex = new JComboBox();; //顾客性别
	String[] sexes={"男","女"};
	private JTextField txtcustomertel = new JTextField(20); //电话
	private JTextField txtcustomercid = new JTextField(20); //身份证号
	private JComboBox boxmemberid = new JComboBox(); //顾客类型编号
	String[] members={"MG101","MG102","MG103"};
	private JTextField txtmembername=new JTextField(20);    //顾客类型名称
	private JTextField txtmembercount=new JTextField(20);   //折扣
	//public static final int G   = 1;        //表示顾客编号
	//public static final int MG  = 2;        //表示顾客类型编号
	//private static Properties ini = null;
	private JButton btnQueDing = new JButton("确  定");
	private JButton btnQuXiao = new JButton("取  消");
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
		this.setSize(700, 300);                                      //设置大小
		this.setLocationRelativeTo(null);                            //居中
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);     //关闭
                                   
		JPanel pane = addComp();                                     //设置面板
        
		this.add(pane);
		
	}

	private JPanel addComp() {
		JPanel pane = new JPanel();
		//设置边界布局管理器
		pane.setLayout(new BorderLayout());
        //对面板进行中南细致划分
		JPanel centerPane = initCenter();
		JPanel southPane = initSouth();
        //大容器里添加小容器
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
    //中部
	private JPanel initCenter() {
		/*
		 * 重写JPanel方法，便于添加背景
		 */
		JPanel pane = new JPanel(){
	        public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("src/image/客户.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		 };
		
		GridBagLayout layout = new GridBagLayout();  //中部布局管理器
		pane.setLayout(layout);
		
		 if (command.equals("1")) {
			 txtcustomerid.setText(G);	
			 //system.println("------");
		 }

		 txtcustomerid.setEditable(false);
		JLabel lblcustomerid = new JLabel("顾客编号 ：");
		layout.setConstraints(lblcustomerid, new GBC(0, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblcustomerid);
		lblcustomerid.setForeground(Color.blue);  //设置颜色
		layout.setConstraints(txtcustomerid, new GBC(1, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtcustomerid);


		JLabel lblcustomername = new JLabel("顾客姓名：");
		layout.setConstraints(lblcustomername, new GBC(2, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblcustomername);
		lblcustomername.setForeground(Color.blue);

		layout.setConstraints(txtcustomername, new GBC(3, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtcustomername);

		JLabel lblcustomersex = new JLabel("  性       别 ：");
		
		layout.setConstraints(lblcustomersex, new GBC(0, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblcustomersex);
		lblcustomersex.setForeground(Color.blue);
		
		
		
		layout.setConstraints(boxcustomersex, new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(boxcustomersex);
		for (String a:sexes) {
			boxcustomersex.addItem(a);
		}

		JLabel lblcustomertel = new JLabel("手  机  号：");
		layout.setConstraints(lblcustomertel, new GBC(2, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblcustomertel);
		
		lblcustomertel.setForeground(Color.blue);
		layout.setConstraints(txtcustomertel, new GBC(3, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtcustomertel);

		JLabel lblcustomercid = new JLabel("身份证号 ：");
		layout.setConstraints(lblcustomercid, new GBC(0, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblcustomercid);
		lblcustomercid.setForeground(Color.blue);
		layout.setConstraints(txtcustomercid, new GBC(1, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtcustomercid);

		JLabel lblmemberid= new JLabel(" 顾客类型编号 ：");
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
				ImageIcon icon = new ImageIcon("src/image/客户.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		 };
        pane.setBackground(Color.darkGray);
		pane.add(this.btnQueDing);
		pane.add(this.btnQuXiao);

		return pane;
		
	}
	

}
