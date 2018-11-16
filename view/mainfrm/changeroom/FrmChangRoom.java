package view.mainfrm.changeroom;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.component.swings.TJButton;
import common.component.swings.TJTextField;
import common.component.tools.SetWindow;
import control.mainfrm.mainjiemian.roommenu.LsnrChangeRoomBtn;

/**
 * 更改房间界面
 * @author Administrator
 *
 */
public class FrmChangRoom extends JDialog {

	public  static JLabel beforeRoom;    // 原房间
	private JTextField tf2;              // 房价显示
	private JCheckBox chk;               // 新房间
	private JButton queDingBt,quXiaoBt;
	private JPanel panelMain;
	private JComboBox someRoom;
	private Object[] room={};

	public JComboBox getSomeRoom() {
		return someRoom;
	}
	
	public JTextField getTf2() {
		return tf2;
	}
	
	public void setBeforeRoom(JLabel beforeRoom) {
		this.beforeRoom = beforeRoom;
	}

	public JLabel getBeforeRoom() {
		return beforeRoom;
	}

	public JButton getQueDingBt() {
		return queDingBt;
	}

	public JButton getQuXiaoBt() {
		return quXiaoBt;
	}

	public FrmChangRoom(JFrame frame) {
		super(frame,"更换房间",true);
		
		buildPanel();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (300,240));
		this.setMinimumSize (new Dimension (300,240));
		this.setResizable(false);		//不允许改变窗口大小
		pack();
		SetWindow.setWindowCenter(this);	//窗口屏幕居中
		//添加时间监听
		addListener();
	}
	
	//事件监听
	private void addListener() {
		
		queDingBt.addActionListener(new LsnrChangeRoomBtn(this));
		quXiaoBt.addActionListener(new LsnrChangeRoomBtn(this));

	}
	
	//建立界面
	private void buildPanel() {
		JPanel pcc,p1,p2,p3,p4,p5;
		JLabel lb1,lb2,lb3,lb4,lb5,lb6; 
		
		panelMain = new JPanel(new BorderLayout(0,5));
		pcc		  = new JPanel(new GridLayout(5,1));
		p1		  = new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
		p2 	      = new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
		p3 		  = new JPanel(new FlowLayout(FlowLayout.LEFT,25,0));
		p4 		  = new JPanel(new FlowLayout(FlowLayout.LEFT,25,0));
		p5 		  = new JPanel(new FlowLayout(FlowLayout.CENTER,35,0));
		
		lb1 	  = new JLabel("         原房间：");
		lb2 	  = new JLabel("         调整为：");
		lb3 	  = new JLabel("     房价：");
		lb4 	  = new JLabel(" 注：只能调整为同类型的房间！");
		lb5 	  = new JLabel();
		lb6 	  = new JLabel();
		beforeRoom = new JLabel("");
		
		chk       = new JCheckBox("    保留原房间的房间费");
		queDingBt = new TJButton ("pic/toolsbar/save.gif", "确定", "确定信息",false); 
		quXiaoBt 	  = new TJButton ("pic/toolsbar/u01.gif", "取消", "取消操作",false); 
		
		someRoom  = new JComboBox(room);
		tf2       = new JTextField(6);
		tf2.setEditable(false);


		p1.add(lb1);
		p1.add(beforeRoom);
		p2.add(lb2);
		p2.add(someRoom);
		p2.add(lb3);
		p2.add(tf2);
	
		p3.add(chk);
		p4.add(lb4);
		p5.add(queDingBt);
		p5.add(quXiaoBt);
		
		pcc.add(p1);
		pcc.add(p2);
		pcc.add(p3);
		pcc.add(p4);
		pcc.add(p5);
		
		
		panelMain.add("North",lb5);
		panelMain.add(pcc);
		panelMain.add("South",lb6);
	} 
	
	/*public static void main(String[] args) {
		new FrmChangRoom(null).setVisible(true);;
	}*/
}
