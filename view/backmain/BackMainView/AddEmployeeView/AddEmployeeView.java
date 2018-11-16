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
 * ����޸�Ա��������ͼ
 * @author�� �ź�
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
  //�Ա�ѡ��
  private JRadioButton ckbSex1= new JRadioButton("��");
  private JRadioButton ckbSex2= new JRadioButton("Ů");
  //��Ͽ�
  private JComboBox cbBox=new JComboBox();
  
  private JButton btnXiuGai= new JButton("��  ��");
  private JButton btnQueDing = new JButton("ȷ  ��");
  private JButton btnQuXiao = new JButton("ȡ  ��");
  
  private  String strEmployeeID=HotelTools.getNumber(HotelTools.EM);

  //����
  JDatePicker datePickerTo = new JDatePicker(JDatePicker.STYLE_CN_DATE);
  //1��ʾ���ӣ�2��ʾ�޸�
  private String command;
  
  public AddEmployeeView(JFrame ower, String title, boolean modal, String command) {
    super(ower, title, modal);
    this.command = command;
    init();
   
  }
  
  
 /*******������***********������**************������*****************/
  private void init() {
    this.setSize(630, 300);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setIconImage(new ImageIcon("pic/chuangtiIcon/Ա��.png").getImage());
    JPanel pane = addComp();
    addListener();
    
    this.add(pane);
  }
  /**********������**************������*************** ������***********/

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
			 //�Զ�����Ա�����
	  
	    txtEmployeeId.setText(strEmployeeID);
	    
		}

	  //���ò��ɱ༭
    txtEmployeeId.setEditable(false);
    
    JPanel pane = new JPanel(){
		public void paintComponent(Graphics g) {
			ImageIcon icon = new ImageIcon("pic/backimages/��̬��ɫ.png");
			g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

		}
	};
    GridBagLayout layout = new GridBagLayout();
    pane.setLayout(layout);
    //Ա����λ��
    JLabel lblEmployeeId = new JLabel(" Ա���� ��");
    lblEmployeeId.setIcon(new ImageIcon("pic/backimages/Employee/Ա����.png"));
    layout.setConstraints(lblEmployeeId, new GBC(0, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblEmployeeId);
    //Ա�����ı�λ��
    layout.setConstraints(txtEmployeeId, new GBC(1, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtEmployeeId);
    
 
    //Ա�����ͱ��λ��
    /********************************/
    //�����Ͽ�
    JPanel jpEmptye=new JPanel();
    cbBox.addItem("��ͨԱ��");
    cbBox.addItem("����");
    txtEmptyeId.setEditable(false);
    jpEmptye.add(txtEmptyeId);
    jpEmptye.add(cbBox);
    /********************************/
    JLabel lblEmptyeId = new JLabel("Ա������ ��");
    lblEmptyeId.setIcon(new ImageIcon("pic/backimages/Employee/Ա������.png"));
    layout.setConstraints(lblEmptyeId , new GBC(2, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblEmptyeId);
    
    layout.setConstraints(jpEmptye, new GBC(3, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(jpEmptye);
    
    //Ա������λ��
    JLabel lblEmployeeName = new JLabel("Ա������ ��");
    lblEmployeeName.setIcon(new ImageIcon("pic/backimages/Employee/����.png"));
    layout.setConstraints(lblEmployeeName, new GBC(0, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblEmployeeName);
    
    layout.setConstraints(txtEmployeeName , new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtEmployeeName );
    
    //Ա����������λ��
    /*****************************************************/
    //�������
    JPanel c = new JPanel();
   //����Ϊ���ɱ༭
   datePickerTo.setEditable(false);
   txtEbirthday.setEditable(false);;
   c.add(txtEbirthday); 	   
   c.add(datePickerTo);
    	    
    /***********/
    JLabel lblBirthday = new JLabel("�������� ��");
    lblBirthday.setIcon(new ImageIcon("pic/backimages/Employee/����.png"));
    layout.setConstraints(lblBirthday , new GBC(2, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblBirthday);
    
    layout.setConstraints(c, new GBC(3, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(c);
    /*****************************************************************/
     //�����Ա𻥳�򣬲���д��˽�з��� ����ֲ�������
     JPanel jp=new JPanel();
     ButtonGroup bu=new ButtonGroup();
     txtEmployeeSex.setEditable(false);
     bu.add(ckbSex1);
     bu.add(ckbSex2);
     jp.add(txtEmployeeSex);
     jp.add(ckbSex1);
     jp.add(ckbSex2);
     /*******************************************************************/
    //�Ա�λ��
    JLabel lblSex = new JLabel("��  �� ��");
    lblSex.setIcon(new ImageIcon("pic/backimages/Employee/�ձ�.png"));
    layout.setConstraints(lblSex, new GBC(0, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblSex);
    
    layout.setConstraints(jp, new GBC(1, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(jp);
    
    //�绰λ��
    JLabel lblTel = new JLabel("��  �� ��");
    lblTel.setIcon(new ImageIcon("pic/backimages/Employee/�绰.png"));
    layout.setConstraints(lblTel, new GBC(2, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblTel);
    
    layout.setConstraints(txtEmployeeTel, new GBC(3, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtEmployeeTel);
    //���֤��λ��
    JLabel lblEmployeeEid = new JLabel("���֤���� ��");
    lblEmployeeEid.setIcon(new ImageIcon("pic/backimages/Employee/���֤.png"));
    layout.setConstraints(lblEmployeeEid, new GBC(0, 3).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblEmployeeEid);
    layout.setConstraints(txtEmployeeEid, new GBC(1, 3).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtEmployeeEid);
    return pane;
  }
  
  private JPanel initSouth() {
	  btnQueDing.setIcon(new ImageIcon("pic/chuangtiIcon/ȷ��.png"));
	  btnQuXiao.setIcon(new ImageIcon("pic/chuangtiIcon/ȡ��.png"));
	  btnXiuGai.setIcon(new ImageIcon("pic/chuangtiIcon/�޸�.png"));
    JPanel pane = new JPanel(){
		public void paintComponent(Graphics g) {
			ImageIcon icon = new ImageIcon("pic/backimages/��̬��ɫ.png");
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
