package view.backmain.BackMainView.AddEmployeeView;

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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import common.backpifu.pifu.MyLookAndFeel;
import common.component.tools.HotelTools;
import control.mainback.lsnAddEmployeeView.LsnrBtn;
import control.mainback.lsnAddEmployeeView.LsnrCbBox;
import control.mainback.lsnAddEmployeeView.LsnrCkbSex;
import control.mainback.lsnAddEmployeeView.LsnrDate;
import model.mainbackfrm.mdlnumber.MdlNumberUp;
import view.backmain.common.GBC;
import view.backmain.common.JDatePicker;

/**
 * 添加修改员工界面视图
 * @author： 张航
 * @date:2018.10.24
 * */
public class AddEmployeeView extends JDialog {
  
  private JTextField txtEmployeeId = new JTextField(10);
  private JTextField txtEmptyeId = new JTextField(8);
  private JTextField txtEmployeeName = new JTextField(10);
  private JTextField txtEbirthday = new JTextField(8);
  private JTextField txtEmployeeSex= new JTextField(6);
  private JTextField txtEmployeeTel= new JTextField(10);
  private JTextField txtEmployeeEid=new JTextField(10);
  JTextField txt1 = new JTextField(10);
  //性别复选框
  private JRadioButton ckbSex1= new JRadioButton("男");
  private JRadioButton ckbSex2= new JRadioButton("女");
  //组合框
  private JComboBox cbBox=new JComboBox();
  
  private JButton btnXiuGai= new JButton("修  改");
  private JButton btnQueDing = new JButton("确  定");
  private JButton btnQuXiao = new JButton("取  消");
  
  private  String strEmployeeID=HotelTools.getNumber(HotelTools.EM);

  //日期
  JDatePicker datePickerTo = new JDatePicker(JDatePicker.STYLE_CN_DATE);
  //1表示增加，2表示修改
  private String command;
  
  public AddEmployeeView(JFrame ower, String title, boolean modal, String command) {
    super(ower, title, modal);
    this.command = command;
    init();
   
  }
  
  
 /*******主窗体***********主窗体**************主窗体*****************/
  private void init() {
    this.setSize(630, 300);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setIconImage(new ImageIcon("pic/chuangtiIcon/员工.png").getImage());
    JPanel pane = addComp();
    addListener();
    
    this.add(pane);
  }
  /**********监听器**************监听器*************** 监听器***********/

  private void addListener() {
	  
     this.cbBox.addActionListener(new LsnrCbBox(this));
     this.ckbSex1.addActionListener(new LsnrCkbSex(this));
     this.ckbSex2.addActionListener(new LsnrCkbSex(this));
     this.btnQueDing.addActionListener(new LsnrBtn(this));
     this.btnQuXiao.addActionListener(new LsnrBtn(this));
     this.btnXiuGai.addActionListener(new LsnrBtn(this));
     this.datePickerTo.addActionListener(new LsnrDate(this));
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
	 
	  if(command.equals("1")){
			 //自动生成员工编号
	  
	    txtEmployeeId.setText(strEmployeeID);
	    
		}

	  //设置不可编辑
    txtEmployeeId.setEditable(false);
    
    JPanel pane = new JPanel(){
		public void paintComponent(Graphics g) {
			ImageIcon icon = new ImageIcon("pic/backimages/动态纯色.png");
			g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

		}
	};
    GridBagLayout layout = new GridBagLayout();
    pane.setLayout(layout);
    //员工号位置
    JLabel lblEmployeeId = new JLabel(" 员工号 ：");
    lblEmployeeId.setIcon(new ImageIcon("pic/backimages/Employee/员工号.png"));
    layout.setConstraints(lblEmployeeId, new GBC(0, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblEmployeeId);
    //员工号文本位置
    layout.setConstraints(txtEmployeeId, new GBC(1, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtEmployeeId);
    
 
    //员工类型编号位置
    /********************************/
    //添加组合框
    JPanel jpEmptye=new JPanel();
    cbBox.addItem("普通员工");
    cbBox.addItem("经理");
    txtEmptyeId.setEditable(false);
    jpEmptye.add(txtEmptyeId);
    jpEmptye.add(cbBox);
    /********************************/
    JLabel lblEmptyeId = new JLabel("员工类型 ：");
    lblEmptyeId.setIcon(new ImageIcon("pic/backimages/Employee/员工类型.png"));
    layout.setConstraints(lblEmptyeId , new GBC(2, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblEmptyeId);
    
    layout.setConstraints(jpEmptye, new GBC(3, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(jpEmptye);
    
    //员工姓名位置
    JLabel lblEmployeeName = new JLabel("员工姓名 ：");
    lblEmployeeName.setIcon(new ImageIcon("pic/backimages/Employee/姓名.png"));
    layout.setConstraints(lblEmployeeName, new GBC(0, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblEmployeeName);
    
    layout.setConstraints(txtEmployeeName , new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtEmployeeName );
    
    //员工出生日期位置
    /*****************************************************/
    //添加日期
    JPanel c = new JPanel();
   //设置为不可编辑
   datePickerTo.setEditable(false);
   txtEbirthday.setEditable(false);;
   c.add(txtEbirthday); 	   
   c.add(datePickerTo);
    	    
    /***********/
    JLabel lblBirthday = new JLabel("出生日期 ：");
    lblBirthday.setIcon(new ImageIcon("pic/backimages/Employee/生日.png"));
    layout.setConstraints(lblBirthday , new GBC(2, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblBirthday);
    
    layout.setConstraints(c, new GBC(3, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(c);
    /*****************************************************************/
     //增加性别互斥框，不能写成私有方法 会出现布局问题
     JPanel jp=new JPanel();
     ButtonGroup bu=new ButtonGroup();
     txtEmployeeSex.setEditable(false);
     bu.add(ckbSex1);
     bu.add(ckbSex2);
     jp.add(txtEmployeeSex);
     jp.add(ckbSex1);
     jp.add(ckbSex2);
     /*******************************************************************/
    //性别位置
    JLabel lblSex = new JLabel("性  别 ：");
    lblSex.setIcon(new ImageIcon("pic/backimages/Employee/姓别.png"));
    layout.setConstraints(lblSex, new GBC(0, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblSex);
    
    layout.setConstraints(jp, new GBC(1, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(jp);
    
    //电话位置
    JLabel lblTel = new JLabel("电  话 ：");
    lblTel.setIcon(new ImageIcon("pic/backimages/Employee/电话.png"));
    layout.setConstraints(lblTel, new GBC(2, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblTel);
    
    layout.setConstraints(txtEmployeeTel, new GBC(3, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtEmployeeTel);
    //身份证号位置
    JLabel lblEmployeeEid = new JLabel("身份证号码 ：");
    lblEmployeeEid.setIcon(new ImageIcon("pic/backimages/Employee/身份证.png"));
    layout.setConstraints(lblEmployeeEid, new GBC(0, 3).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblEmployeeEid);
    layout.setConstraints(txtEmployeeEid, new GBC(1, 3).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtEmployeeEid);
    return pane;
  }
  
  private JPanel initSouth() {
	  btnQueDing.setIcon(new ImageIcon("pic/chuangtiIcon/确定.png"));
	  btnQuXiao.setIcon(new ImageIcon("pic/chuangtiIcon/取消.png"));
	  btnXiuGai.setIcon(new ImageIcon("pic/chuangtiIcon/修改.png"));
    JPanel pane = new JPanel(){
		public void paintComponent(Graphics g) {
			ImageIcon icon = new ImageIcon("pic/backimages/动态纯色.png");
			g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

		}
	};
    if(command.equals("1")){
    pane.add(this.btnQueDing);
    }else{
    	pane.add(this.btnXiuGai);
    }
    
    pane.add(this.btnQuXiao);
    
    return pane;
  }

  
public JDatePicker getDatePickerTo() {
	return datePickerTo;
}


public JTextField getTxtEmployeeName() {
	return txtEmployeeName;
}


public JTextField getTxtEbirthday() {
	return txtEbirthday;
}


public JTextField getTxtEmployeeTel() {
	return txtEmployeeTel;
}


public JTextField getTxtEmployeeEid() {
	return txtEmployeeEid;
}


public String getStrEmployeeID() {
	return strEmployeeID;
}


public JTextField getTxtEmployeeSex() {
	return txtEmployeeSex;
}






public JRadioButton getCkbSex1() {
	return ckbSex1;
}


public JRadioButton getCkbSex2() {
	return ckbSex2;
}


public JTextField getTxtEmptyeId() {
	return txtEmptyeId;
}



public JComboBox getCbBox() {
	return cbBox;
}



public JTextField getTxtEmployeeId() {
	return txtEmployeeId;
}



public JButton getBtnQueDing() {
	return btnQueDing;
}



public JButton getBtnQuXiao() {
	return btnQuXiao;
}
 
  
}
