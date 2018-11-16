package view.backmain.BackMainView.addRoomView;




import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

import control.mainback.lsnAddRoomTypeView.LsnrAddRoomTypeBtn;
import control.mainback.lsnAddRoomTypeView.LsnrAddRoomTypeCbBox;

import control.mainback.lsnAddRoomView.LsnrAddRoomView;
import model.mainbackfrm.mdlnumber.MdlNumberUp;
import view.backmain.common.GBC;

/**
 * ���ӷ������
 * @author �ź�
 * @date 2018.10.23
 * 
 * */
public class AddRoomView extends JDialog {
   
	
	
  private JTextField txtRoomId = new JTextField(10);
  private JTextField txtRoomTypeName=new JTextField(7);
  private JTextField txtRoomPrice = new JTextField(7);
  private JTextField txtRoomNumber=new JTextField(10);
  private JTextField txtRoomFloor=new JTextField(6);
  
  String[] RoomFloor={"��¥","��¥","��¥"};
 
  String[] RoomName={"���˼�","˫�˼�","�����׷�","�������ⷿ","�����","������","��ͳ�׷�"};
  int[] RoomPrice={888,999,1999,2999,3999,4999,8888};
  int[] RoomNumber={1,2,1,2,1,1,1};
  //��Ͽ�
  private JComboBox<String> cbBox=new JComboBox<String>();
  
  private JComboBox<String> cbBoxFloor=new JComboBox<String>();
  
  
  private JButton btnXiuGai= new JButton("��  ��");
  private JButton btnQueDing = new JButton("ȷ  ��");
  private JButton btnQuXiao = new JButton("ȡ  ��");
  //1��ʾ���ӣ�2��ʾ�޸�
  private String command;
  
  public  AddRoomView(JFrame ower, String title, boolean modal, String command) {
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
    this.setIconImage(new ImageIcon("pic/backimages/����.png").getImage());
    JPanel pane = addComp();
    
    this.add(pane);
    addListener();
    
  }
  /**********������**************������*************** ������***********/

  private void addListener() {
	this.cbBox.addActionListener(new LsnrAddRoomView(this));
	this.cbBoxFloor.addActionListener(new LsnrAddRoomView(this));
	this.btnQueDing.addActionListener(new LsnrAddRoomView(this));
	this.btnQuXiao.addActionListener(new LsnrAddRoomView(this));
	this.btnXiuGai.addActionListener(new LsnrAddRoomView(this));
	
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

	
	  //���ò��ɱ༭
	txtRoomId.setEditable(false);
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
    JLabel lblRoomId = new JLabel("   ����� ��");
    lblRoomId.setIcon(new ImageIcon("pic/backimages/Room/�����.png"));
    layout.setConstraints(lblRoomId, new GBC(0, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblRoomId);
  
    layout.setConstraints(txtRoomId, new GBC(1, 0).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtRoomId);
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
    JPanel p=new JPanel();
    JLabel lblRoomPriceYuan = new JLabel("  Ԫ                          ");
    txtRoomPrice.setEditable(false);
    p.add(txtRoomPrice);
    p.add(lblRoomPriceYuan);
   /*********************/
    JLabel lblRoomPrice = new JLabel("  ����۸� ��");
    lblRoomPrice.setIcon(new ImageIcon("pic/backimages/Room/�۸�.png"));
    layout.setConstraints(lblRoomPrice, new GBC(2, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblRoomPrice);
   
    layout.setConstraints(p, new GBC(3, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(p);
    
    
    //���䴲λ��λ��
    txtRoomNumber.setEditable(false);
    JLabel lblRoomNumber = new JLabel("  ��λ�� ��");
    lblRoomNumber.setIcon(new ImageIcon("pic/backimages/Room/��.png"));
    layout.setConstraints(lblRoomNumber, new GBC(0, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblRoomNumber);
    
    layout.setConstraints(txtRoomNumber, new GBC(1, 1).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(txtRoomNumber);
    /************¥��λ��******************************/
    JPanel f=new JPanel();
    for(String a:RoomFloor){
    cbBoxFloor.addItem(a);
    }
    txtRoomFloor.setEditable(false);
    f.add(txtRoomFloor);
    f.add(cbBoxFloor);
    
    JLabel lblRoomFloor = new JLabel("  ����¥�㣺");
    lblRoomFloor.setIcon(new ImageIcon("pic/backimages/Room/¥��.png"));
    layout.setConstraints(lblRoomFloor, new GBC(0, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(lblRoomFloor);
    //��ӷ��� ���һ����Ͽ�
   if(command.equals("1")){
    layout.setConstraints(f, new GBC(1, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
    pane.add(f);
   }else{
	layout.setConstraints(txtRoomFloor, new GBC(1, 2).setFill(GBC.HORIZONTAL).setInsets(new Insets(5, 5, 5, 5)));
	pane.add(txtRoomFloor);
   }
   
    
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


public JTextField getTxtRoomNumber() {
	return txtRoomNumber;
}


public JTextField getTxtRoomFloor() {
	return txtRoomFloor;
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


public JTextField getTxtRoomId() {
	return txtRoomId;
}

public JTextField getTxtRoomTypeName() {
	return txtRoomTypeName;
}


public JTextField getTxtRoomPrice() {
	return txtRoomPrice;
}


public int[] getRoomPrice() {
	return RoomPrice;
}


public JComboBox<String> getCbBoxFloor() {
	return cbBoxFloor;
}


public String[] getRoomFloor() {
	return RoomFloor;
}


public int[] getRoomNumber() {
	return RoomNumber;
}


public JComboBox<String> getCbBox() {
	return cbBox;
}


public String[] getRoomName() {
	return RoomName;
}


}

