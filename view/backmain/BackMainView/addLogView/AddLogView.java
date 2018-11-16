package view.backmain.BackMainView.addLogView;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.TreeSet;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.mainback.lsnAddLogView.LsnrAddLogCbx;
import control.mainback.lsnAddLogView.LsnrAddLogbtn;
import model.mainbackfrm.register.mdlRegister;
import view.backmain.common.GBC;
import vo.mainback.Register;

/**
 * 给予和撤销权限界面
 * 
 * @author 张航
 * @date 2018.10.23
 * 
 */
public class AddLogView extends JDialog {

	private JTextField txtLogId = new JTextField(6);
	private JTextField txtLogPwd = new JTextField(10);
	private JTextField txtEmployeeName = new JTextField(10);
	private JTextField txtLogState = new JTextField(10);

	private JComboBox<String> jcbx = new JComboBox<String>();

	private JButton btnXiuGai = new JButton("修  改");
	private JButton btnQueDing = new JButton("确  定");
	private JButton btnQuXiao = new JButton("取  消");
	// 1表示增加，2表示修改
	private String command;

	public AddLogView(JFrame ower, String title, boolean modal, String command) {
		super(ower, title, modal);
		this.command = command;
		init();
	}

	/******* 主窗体***********主窗体**************主窗体 *****************/
	private void init() {
		this.setSize(630, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("pic/backimages/权限.png").getImage());
		JPanel pane = addComp();
		addListener();

		this.add(pane);
	}

	/********** 监听器**************监听器*************** 监听器 ***********/

	private void addListener() {
		this.btnQueDing.addActionListener(new LsnrAddLogbtn(this));
		this.btnQuXiao.addActionListener(new LsnrAddLogbtn(this));
		this.btnXiuGai.addActionListener(new LsnrAddLogbtn(this));
		this.jcbx.addActionListener(new LsnrAddLogCbx(this));
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

		// 设置不可编辑
		txtLogId.setEditable(false);
		JPanel pane = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("pic/backimages/动态纯色.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		};
		GridBagLayout layout = new GridBagLayout();
		pane.setLayout(layout);
		// 员工号位置
		JLabel lblLogId = new JLabel("  员工号 ：");
		lblLogId.setIcon(new ImageIcon("pic/backimages/Employee/员工号.png"));
		layout.setConstraints(lblLogId, new GBC(0, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblLogId);
		// 员工号文本位置
		/****************************/
		// 组合框

		/************************************/
		layout.setConstraints(initLogId(), new GBC(1, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(initLogId());

		// 密码位置
		JLabel lblLogPwd = new JLabel("密码 ：");
		lblLogPwd.setIcon(new ImageIcon("pic/backimages/dengluquanxian/密码.png"));
		layout.setConstraints(lblLogPwd, new GBC(2, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblLogPwd);

		layout.setConstraints(txtLogPwd, new GBC(3, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtLogPwd);

		// 员工姓名位置
		JLabel lblLogName = new JLabel("员工姓名 ：");
		lblLogName.setIcon(new ImageIcon("pic/backimages/Employee/姓名.png"));
		layout.setConstraints(lblLogName, new GBC(0, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblLogName);
		txtEmployeeName.setEnabled(false);
		layout.setConstraints(txtEmployeeName, new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtEmployeeName);

		// 员工登录状态位置
		JLabel lblLogState = new JLabel("登录状态 ：");
		lblLogState.setIcon(new ImageIcon("pic/backimages/dengluquanxian/登录状态.png"));
		layout.setConstraints(lblLogState, new GBC(2, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(lblLogState);
		txtLogState.setEditable(false);
		layout.setConstraints(txtLogState, new GBC(3, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
		pane.add(txtLogState);

		return pane;

	}

	private JPanel initLogId() {
		 
		TreeSet<Register>  t=new TreeSet<Register> ();
		
		JPanel jp = new JPanel();
	    if(command.equals("2")){
	    	 t = new mdlRegister().selectAllLogPwdNull();
	    	 jcbx.removeAllItems();
	    	 for(Register s:t){
	    		
	    		 jcbx.addItem(s.getEmployeeId());
	 		}
	    }else if(command.equals("1")){
	    	 t = new mdlRegister().selectAllLogPwdNotNull();
	    	 jcbx.removeAllItems();
	    	 for(Register s:t){
	    	
	    		 jcbx.addItem(s.getEmployeeId());
	 		}
	    }
	
		
		jp.add(txtLogId);
		jp.add(jcbx);
		return jp;
	}

	private JPanel initSouth() {
		 btnQueDing.setIcon(new ImageIcon("pic/chuangtiIcon/确定.png"));
		  btnQuXiao.setIcon(new ImageIcon("pic/chuangtiIcon/取消.png"));
		  btnXiuGai.setIcon(new ImageIcon("pic/chuangtiIcon/修改.png"));
		JPanel pane = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("pic/backimages/动态纯色.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		};
		if (command.equals("2")) {
			pane.add(this.btnQueDing);
		} else {
			pane.add(this.btnXiuGai);
		}

		pane.add(this.btnQuXiao);

		return pane;
	}

	public JTextField getTxtLogId() {
		return txtLogId;
	}

	public JTextField getTxtLogPwd() {
		return txtLogPwd;
	}

	public JTextField getTxtEmployeeName() {
		return txtEmployeeName;
	}

	public JTextField getTxtLogState() {
		return txtLogState;
	}

	public JButton getBtnXiuGai() {
		return btnXiuGai;
	}

	public JButton getBtnQueDing() {
		return btnQueDing;
	}

	public JButton getBtnQuXiao() {
		return btnQuXiao;
	}

	public String getCommand() {
		return command;
	}

	public JComboBox<String> getJcbx() {
		return jcbx;
	}

	public void setJcbx(JComboBox<String> jcbx) {
		this.jcbx = jcbx;
	}

}
