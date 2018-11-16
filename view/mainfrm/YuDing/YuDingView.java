package view.mainfrm.YuDing;

import java.awt.BorderLayout;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
import control.mainfrm.lsnYuDing.AddYuDing.LsnrAddYuDing;

import view.backmain.common.GBC;
import view.backmain.common.JDatePicker;

/**
 * 添加修改预订房间界面视图 
 * @author： 张航
 * 
 * @date:2018.11.02
 */
public class YuDingView extends JDialog {

	private JTextField txtYDid = new JTextField(8);
	private JTextField txtVipId = new JTextField(8);
	private JTextField txtCustomerName = new JTextField(8);
	private JTextField txtCustomerType = new JTextField(8);
	private JTextField txtTel = new JTextField(8);
	private JTextField txtSex = new JTextField(6);
	private JTextField txtRoomType = new JTextField(6);
	private JTextField txtRoomId = new JTextField(6);
	private JTextField txtCustomerCId = new JTextField(8);
	private JTextField txYDtime = new JTextField(6);
	private JTextField txtBLtime = new JTextField(8);
	private JTextField txtYDState = new JTextField(6);
	//预订编号
	private String StrYdID=HotelTools.getNumber(HotelTools.YD);

	// 性别复选框
	private JRadioButton ckbSex1 = new JRadioButton ("男");
	private JRadioButton  ckbSex2 = new JRadioButton ("女");
	// 组合框
	String[] RoomName = { "标准单人间", "标准双人间", "豪华套房", "浪漫主题房", "商务间", "行政间", "总统套房" };
	String[] YDSateName={"已预订","已取消"};
	
	private JComboBox cbBoxRoomType = new JComboBox();
	public  JComboBox cbBoxRoomId = new JComboBox();
	private JComboBox cbBoxYDState = new JComboBox();

	private JButton btnXiuGai = new JButton("修  改");
	private JButton btnQueDing = new JButton("确  定");
	private JButton btnQuXiao = new JButton("取  消");

	// 日期
	JDatePicker datePickerTo = new JDatePicker(JDatePicker.STYLE_CN_DATETIME);
	// 1表示增加，2表示修改
	private String command;

	public YuDingView(JFrame ower, String title, boolean modal, String command) {
		super(ower, title, modal);
		this.command = command;
		init();
	}

	/******* 主窗体***********主窗体**************主窗体 *****************/
	private void init() {
		this.setSize(960, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("pic/YuDing/预订.png").getImage());
		JPanel pane = addComp();
		addListener();

		this.add(pane);
	}

	/********** 监听器**************监听器*************** 监听器 ***********/

	private void addListener() {
       this.ckbSex1.addActionListener(new LsnrAddYuDing(this));
       this.ckbSex2.addActionListener(new LsnrAddYuDing(this));
       this.cbBoxRoomId.addActionListener(new LsnrAddYuDing(this));
       this.cbBoxRoomType.addActionListener(new LsnrAddYuDing(this));
       this.cbBoxYDState.addActionListener(new LsnrAddYuDing(this));
       this.datePickerTo.addActionListener(new LsnrAddYuDing(this));
       this.btnQueDing.addActionListener(new LsnrAddYuDing(this));
       this.btnQuXiao.addActionListener(new LsnrAddYuDing(this));
       this.btnXiuGai.addActionListener(new LsnrAddYuDing(this));
       this.txtVipId.addActionListener(new LsnrAddYuDing(this));
       this.txtTel.addActionListener(new LsnrAddYuDing(this));
       
	}

	private JPanel addComp() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JPanel centerPane = initCenter();
		JPanel southPane = initSouth();

		pane.add(centerPane, BorderLayout.CENTER);
		pane.add(southPane, BorderLayout.SOUTH);

		return pane;
	}

	private JPanel initCenter() {

		if(command.equals("2")){
			txtCustomerName.setEditable(false);
			txtCustomerCId.setEditable(false);
			txtTel.setEditable(false);
			ckbSex1.setEnabled(false);
			ckbSex2.setEnabled(false);
			
			
		}else if(command.equals("1")){
			cbBoxYDState.setEnabled(false);
		}
		
		JPanel pane = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("pic/backimages/动态纯色.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		};
		GridBagLayout layout = new GridBagLayout();
		pane.setLayout(layout);
		// 预订号位置
		JLabel lblYDId = new JLabel("预订编号 ：");
		lblYDId.setIcon(new ImageIcon("pic/backimages/Employee/员工号.png"));
		layout.setConstraints(lblYDId, new GBC(0, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblYDId);
		// 员工号文本位置
		txtYDid.setEditable(false);
		txtYDid.setText(StrYdID);
		layout.setConstraints(txtYDid, new GBC(1, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtYDid);

		// 会员号位置
		/********************************/

		JLabel lblVipId = new JLabel("会员号（选填） ：");
		lblVipId.setIcon(new ImageIcon("pic/YuDing/会员号.png"));
                txtVipId.setToolTipText("输入会员号如（VIP1001)按Enter");
		layout.setConstraints(lblVipId, new GBC(2, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblVipId);

		layout.setConstraints(txtVipId, new GBC(3, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtVipId);

		// 宾客姓名位置
		
		JLabel lblCustomerName = new JLabel("宾客姓名 ： ");
		lblCustomerName.setIcon(new ImageIcon("pic/backimages/Employee/姓名.png"));
		layout.setConstraints(lblCustomerName, new GBC(0, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblCustomerName);

		layout.setConstraints(txtCustomerName, new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtCustomerName);

		// 宾客类型位置

		JLabel lblCustomerType = new JLabel("宾客类型 ：");
		lblCustomerType.setIcon(new ImageIcon("pic/YuDing/顾客类型.png"));
		layout.setConstraints(lblCustomerType, new GBC(4, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblCustomerType);
        txtCustomerType.setText("普通");
        txtCustomerType.setEditable(false);
		layout.setConstraints(txtCustomerType, new GBC(5, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtCustomerType);

		// 电话位置
		JLabel lblTel = new JLabel("联系电话 ：");
                txtTel.setToolTipText("历史顾客输入电话后按Enter");
		lblTel.setIcon(new ImageIcon("pic/backimages/Employee/电话.png"));
		layout.setConstraints(lblTel, new GBC(2, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblTel);

		layout.setConstraints(txtTel, new GBC(3, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtTel);

		// 顾客性别
		JPanel jp = new JPanel();
		ButtonGroup bu = new ButtonGroup();
		txtSex.setEditable(false);
		bu.add(ckbSex1);
		bu.add(ckbSex2);
		jp.add(txtSex);
		jp.add(ckbSex1);
		jp.add(ckbSex2);
		JLabel lblSex = new JLabel("宾客性别 ：");
		lblSex.setIcon(new ImageIcon("pic/backimages/Employee/姓别.png"));
		layout.setConstraints(lblSex, new GBC(4, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblSex);

		layout.setConstraints(jp, new GBC(5, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(jp);

		// 房间类型
		JPanel j = new JPanel();
		txtRoomType.setEditable(false);
		j.add(txtRoomType);
		cbBoxRoomType.removeAllItems();
		for (String a : RoomName) {
			cbBoxRoomType.addItem(a);
		}
		
		j.add(cbBoxRoomType);

		JLabel lblRoom = new JLabel("房间类型 ：");
		lblRoom.setIcon(new ImageIcon("pic/backimages/Room/房间名.png"));
		layout.setConstraints(lblRoom, new GBC(0, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblRoom);
		layout.setConstraints(j, new GBC(1, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(j);

		// 房间号位置
		JPanel p = new JPanel();
		cbBoxRoomId.addItem("R301");
		txtRoomId.setEditable(false);
		p.add(txtRoomId);
		p.add(cbBoxRoomId);
		JLabel lblRoomId = new JLabel("房间号 ：");
		lblRoomId.setIcon(new ImageIcon("pic/YuDing/房间编号.png"));
		layout.setConstraints(lblRoomId, new GBC(2, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblRoomId);
		layout.setConstraints(p, new GBC(3, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(p);

		// 身份证号位置
		JLabel lblCustomerCID = new JLabel("身份证号码 ：");
		lblCustomerCID.setIcon(new ImageIcon("pic/backimages/Employee/身份证.png"));
		layout.setConstraints(lblCustomerCID, new GBC(4, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblCustomerCID);
		layout.setConstraints(txtCustomerCId, new GBC(5, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtCustomerCId);

		// 余抵时间
		JPanel jPanel = new JPanel();
		txYDtime.setEditable(false);
		jPanel.add(txYDtime);
		jPanel.add(datePickerTo);

		JLabel lblYDtime = new JLabel("预抵时间 ：");
		lblYDtime.setIcon(new ImageIcon("pic/YuDing/预定时间.png"));
		layout.setConstraints(lblYDtime, new GBC(0, 3).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblYDtime);
		layout.setConstraints(jPanel, new GBC(1, 3).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(jPanel);

		// 保留时间

		JLabel lblBLtime = new JLabel("保留时间 ：");
		lblBLtime.setIcon(new ImageIcon("pic/YuDing/预定时间.png"));
		layout.setConstraints(lblBLtime, new GBC(2, 3).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblBLtime);
		txtBLtime.setEditable(false);
		layout.setConstraints(txtBLtime, new GBC(3, 3).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtBLtime);

		// 预订状态
		JPanel l = new JPanel();
		txtYDState.setText("已预订");
		for(String s:YDSateName){
			cbBoxYDState.addItem(s);
		}
		l.add(txtYDState);
		l.add(cbBoxYDState);
		
		JLabel lblYDState = new JLabel("预订状态 ：");
		lblYDState.setIcon(new ImageIcon("pic/YuDing/预订状态.png"));
		layout.setConstraints(lblYDState, new GBC(4, 3).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblYDState);
		layout.setConstraints(l, new GBC(5, 3).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(l);

		return pane;

	}

	private JPanel initSouth() {
		JPanel pane = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("pic/backimages/动态纯色.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		};
		if (command.equals("1")) {
			pane.add(this.btnQueDing);
		} else {
			pane.add(this.btnXiuGai);
		}
		pane.add(new JLabel("                "));
		pane.add(this.btnQuXiao);

		return pane;
	}

	public JTextField getTxtYDid() {
		return txtYDid;
	}

	public void setTxtYDid(JTextField txtYDid) {
		this.txtYDid = txtYDid;
	}

	public JTextField getTxtVipId() {
		return txtVipId;
	}

	public void setTxtVipId(JTextField txtVipId) {
		this.txtVipId = txtVipId;
	}

	public JTextField getTxtCustomerName() {
		return txtCustomerName;
	}

	public void setTxtCustomerName(JTextField txtCustomerName) {
		this.txtCustomerName = txtCustomerName;
	}

	public JTextField getTxtCustomerType() {
		return txtCustomerType;
	}

	public void setTxtCustomerType(JTextField txtCustomerType) {
		this.txtCustomerType = txtCustomerType;
	}

	public JTextField getTxtTel() {
		return txtTel;
	}

	public void setTxtTel(JTextField txtTel) {
		this.txtTel = txtTel;
	}

	public JTextField getTxtSex() {
		return txtSex;
	}

	public String[] getYDSateName() {
		return YDSateName;
	}

	public void setYDSateName(String[] yDSateName) {
		YDSateName = yDSateName;
	}

	public JComboBox getCbBoxYDState() {
		return cbBoxYDState;
	}

	public void setCbBoxYDState(JComboBox cbBoxYDState) {
		this.cbBoxYDState = cbBoxYDState;
	}

	public void setTxtSex(JTextField txtSex) {
		this.txtSex = txtSex;
	}

	public JTextField getTxtRoomType() {
		return txtRoomType;
	}

	public void setTxtRoomType(JTextField txtRoomType) {
		this.txtRoomType = txtRoomType;
	}

	public JTextField getTxtRoomId() {
		return txtRoomId;
	}

	public void setTxtRoomId(JTextField txtRoomId) {
		this.txtRoomId = txtRoomId;
	}

	public JTextField getTxtCustomerCId() {
		return txtCustomerCId;
	}

	public void setTxtCustomerCId(JTextField txtCustomerCId) {
		this.txtCustomerCId = txtCustomerCId;
	}

	public JTextField getTxYDtime() {
		return txYDtime;
	}

	public void setTxYDtime(JTextField txYDtime) {
		this.txYDtime = txYDtime;
	}

	public JTextField getTxtBLtime() {
		return txtBLtime;
	}

	public void setTxtBLtime(JTextField txtBLtime) {
		this.txtBLtime = txtBLtime;
	}

	public JTextField getTxtYDState() {
		return txtYDState;
	}

	public void setTxtYDState(JTextField txtYDState) {
		this.txtYDState = txtYDState;
	}

	

	public JRadioButton getCkbSex1() {
		return ckbSex1;
	}

	public JRadioButton getCkbSex2() {
		return ckbSex2;
	}

	public String[] getRoomName() {
		return RoomName;
	}

	public void setRoomName(String[] roomName) {
		RoomName = roomName;
	}

	public JComboBox getCbBoxRoomType() {
		return cbBoxRoomType;
	}

	public void setCbBoxRoomType(JComboBox cbBoxRoomType) {
		this.cbBoxRoomType = cbBoxRoomType;
	}

	public JComboBox getCbBoxRoomId() {
		return cbBoxRoomId;
	}

	public void setCbBoxRoomId(JComboBox cbBoxRoomId) {
		this.cbBoxRoomId = cbBoxRoomId;
	}

	public JButton getBtnXiuGai() {
		return btnXiuGai;
	}

	public void setBtnXiuGai(JButton btnXiuGai) {
		this.btnXiuGai = btnXiuGai;
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

	public JDatePicker getDatePickerTo() {
		return datePickerTo;
	}

	public void setDatePickerTo(JDatePicker datePickerTo) {
		this.datePickerTo = datePickerTo;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	
	public String getStrYdID() {
		return StrYdID;
	}

//	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel(MyLookAndFeel.LIQUIDINF);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		new YuDingView(null, "宾客预订房间", true, "1").setVisible(true);
//	}

}
