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
 * ���ӷ������ͽ���
 * @author �ź�
 * @date 2018.10.23
 * 
 * */
public class AddRoomTypeView extends JDialog {
  
  private JTextField txtRoomTypeId = new JTextField(10);
  private JTextField txtRoomTypeName=new JTextField(8);
  private JTextField txtRoomPrice = new JTextField(8);
  
  String[] RoomName={"��׼���˼�","��׼˫�˼�","�����׷�","�������ⷿ","�����","������","��ͳ�׷�"};
  int[] RoomPrice={888,999,1999,2999,3999,4999,8888};
  //��Ͽ�
  private JComboBox<String> cbBox=new JComboBox<String>();
//  private JComboBox<Integer> cbBoxPrice=new JComboBox<Integer>();

  
  private JButton btnXiuGai= new JButton("��  ��");
  private JButton btnQueDing = new JButton("ȷ  ��");
  private JButton btnQuXiao = new JButton("ȡ  ��");
  //1��ʾ���ӣ�2��ʾ�޸�
  private String command;
  
  public  AddRoomTypeView(JFrame ower, String title, boolean modal, String command) {
    super(ower, title, modal);
    this.command = command;
    init();
  }
  
 
 /*******������***********������**************������*****************/
  private void init() {
    this.setSize(600, 300);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    /*******/
    this.setIconImage(new ImageIcon("pic/backimages/��������.png").getImage());
    JPanel pane = addComp();
    
    this.add(pane);
    addListener();
    
  }
  /**********������**************������*************** ������***********/

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
		  //�Զ����ɱ��
		  MdlNumberUp number=new MdlNumberUp();
		  txtRoomTypeId.setText("RT0"+number.RoomTypeMaxNumber());
	  }
	  //���ò��ɱ༭
	txtRoomTypeId.setEditable(false);
    JPanel pane = new JPanel(){
		public void paintComponent(Graphics g) {
			ImageIcon icon = new ImageIcon("pic/backimages/��̬��ɫ.png");
			g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

		}
	};
    GridBagLayout layout = new GridBagLayout();
    pane.setLayout(layout);
    /*
    ImageIcon  image=new ImageIcon("F:\\Word\\eclipseword\\�Ƶ�\\images\\����.jpg");
    JLabel   jl=new JLabel(image);
    pane.add(jl);
    */
    //�������ͱ��λ��
    JLabel lblRoomTypeId = new JLabel("�������ͱ�� ��");
    lblRoomTypeId.setIcon(new ImageIcon("pic/backimages/Room/�����.png"));
    layout.setConstraints(lblRoomTypeId, new GBC(0, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblRoomTypeId);
  
    layout.setConstraints(txtRoomTypeId, new GBC(1, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtRoomTypeId);
    /******����������λ��**********����������λ��**************************/
    JPanel j=new JPanel();
    txtRoomTypeName.setEditable(false);
    for(String s:RoomName){
    	cbBox.addItem(s);
    }
    j.add(txtRoomTypeName);
    j.add(cbBox);
    /******************************/
    JLabel lblRoomTypeName= new JLabel("������������ ��");
    lblRoomTypeName.setIcon(new ImageIcon("pic/backimages/Room/������.png"));
    layout.setConstraints(lblRoomTypeName, new GBC(2, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblRoomTypeName);
    
    layout.setConstraints(j, new GBC(3, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(j);
    /******����۸�λ��**********����۸�λ��*************************/
    /*JPanel p=new JPanel();
    for(int a:RoomPrice){
    	cbBoxPrice.addItem(a);
    }
    p.add(txtRoomPrice);
    p.add(cbBoxPrice);*/
   /*********************/
    JLabel lblRoomPrice = new JLabel("  ����۸� ��");
    lblRoomPrice.setIcon(new ImageIcon("pic/backimages/Room/�۸�.png"));
    layout.setConstraints(lblRoomPrice, new GBC(0, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblRoomPrice);
   
    layout.setConstraints(txtRoomPrice, new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtRoomPrice);
    
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

