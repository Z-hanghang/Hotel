package view.backmain.BackMainView.addRoomType;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.mainback.lsnAddRoomTypeView.LsnrAddRoomTypeBtn;
import control.mainback.lsnAddRoomTypeView.LsnrAddRoomTypeCbBox;
import model.mainbackfrm.mdlnumber.MdlNumberUp;
import view.backmain.common.GBC;

/**
 * 增加房间类型界面
 * @author 张航
 * @date 2018.10.23
 * 
 * */
public class AddRoomTypeView extends JDialog {
  
  private JTextField txtRoomTypeId = new JTextField(10);
  private JTextField txtRoomTypeName=new JTextField(8);
  private JTextField txtRoomPrice = new JTextField(8);
  
  String[] RoomName={"标准单人间","标准双人间","豪华套房","浪漫主题房","商务间","行政间","总统套房"};
  int[] RoomPrice={888,999,1999,2999,3999,4999,8888};
  //组合框
  private JComboBox<String> cbBox=new JComboBox<String>();
//  private JComboBox<Integer> cbBoxPrice=new JComboBox<Integer>();

  
  private JButton btnXiuGai= new JButton("修  改");
  private JButton btnQueDing = new JButton("确  定");
  private JButton btnQuXiao = new JButton("取  消");
  //1表示增加，2表示修改
  private String command;
  
  public  AddRoomTypeView(JFrame ower, String title, boolean modal, String command) {
    super(ower, title, modal);
    this.command = command;
    init();
  }
  
 
 /*******主窗体***********主窗体**************主窗体*****************/
  private void init() {
    this.setSize(600, 300);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    /*******/
    this.setIconImage(new ImageIcon("pic/backimages/房间类型.png").getImage());
    JPanel pane = addComp();
    
    this.add(pane);
    addListener();
    
  }
  /**********监听器**************监听器*************** 监听器***********/

  private void addListener() {
	this.cbBox.addActionListener(new LsnrAddRoomTypeCbBox(this));
	this.btnQueDing.addActionListener(new LsnrAddRoomTypeBtn(this));
	this.btnQuXiao.addActionListener(new LsnrAddRoomTypeBtn(this));
	this.btnXiuGai.addActionListener(new LsnrAddRoomTypeBtn(this));
     }
  /****************************************************************/
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
		  //自动生成编号
		  MdlNumberUp number=new MdlNumberUp();
		  txtRoomTypeId.setText("RT0"+number.RoomTypeMaxNumber());
	  }
	  //设置不可编辑
	txtRoomTypeId.setEditable(false);
    JPanel pane = new JPanel(){
		public void paintComponent(Graphics g) {
			ImageIcon icon = new ImageIcon("pic/backimages/动态纯色.png");
			g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

		}
	};
    GridBagLayout layout = new GridBagLayout();
    pane.setLayout(layout);
    /*
    ImageIcon  image=new ImageIcon("F:\\Word\\eclipseword\\酒店\\images\\背景.jpg");
    JLabel   jl=new JLabel(image);
    pane.add(jl);
    */
    //房间类型编号位置
    JLabel lblRoomTypeId = new JLabel("房间类型编号 ：");
    lblRoomTypeId.setIcon(new ImageIcon("pic/backimages/Room/房间号.png"));
    layout.setConstraints(lblRoomTypeId, new GBC(0, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblRoomTypeId);
  
    layout.setConstraints(txtRoomTypeId, new GBC(1, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtRoomTypeId);
    /******房间类型名位置**********房间类型名位置**************************/
    JPanel j=new JPanel();
    txtRoomTypeName.setEditable(false);
    for(String s:RoomName){
    	cbBox.addItem(s);
    }
    j.add(txtRoomTypeName);
    j.add(cbBox);
    /******************************/
    JLabel lblRoomTypeName= new JLabel("房间类型名称 ：");
    lblRoomTypeName.setIcon(new ImageIcon("pic/backimages/Room/房间名.png"));
    layout.setConstraints(lblRoomTypeName, new GBC(2, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblRoomTypeName);
    
    layout.setConstraints(j, new GBC(3, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(j);
    /******房间价格位置**********房间价格位置*************************/
    /*JPanel p=new JPanel();
    for(int a:RoomPrice){
    	cbBoxPrice.addItem(a);
    }
    p.add(txtRoomPrice);
    p.add(cbBoxPrice);*/
   /*********************/
    JLabel lblRoomPrice = new JLabel("  房间价格 ：");
    lblRoomPrice.setIcon(new ImageIcon("pic/backimages/Room/价格.png"));
    layout.setConstraints(lblRoomPrice, new GBC(0, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblRoomPrice);
   
    layout.setConstraints(txtRoomPrice, new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtRoomPrice);
    
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


public JTextField getTxtRoomTypeId() {
	return txtRoomTypeId;
}


public JTextField getTxtRoomTypeName() {
	return txtRoomTypeName;
}


public JTextField getTxtRoomPrice() {
	return txtRoomPrice;
}


public JComboBox<String> getCbBox() {
	return cbBox;
}


public String[] getRoomName() {
	return RoomName;
}


public int[] getRoomPrice() {
	return RoomPrice;
}



  

  
}

