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
 * ���ķ������
 * @author Administrator
 *
 */
public class FrmChangRoom extends JDialog {

	public  static JLabel beforeRoom;    // ԭ����
	private JTextField tf2;              // ������ʾ
	private JCheckBox chk;               // �·���
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
		super(frame,"��������",true);
		
		buildPanel();
		this.setContentPane(panelMain);
		this.setPreferredSize (new Dimension (300,240));
		this.setMinimumSize (new Dimension (300,240));
		this.setResizable(false);		//������ı䴰�ڴ�С
		pack();
		SetWindow.setWindowCenter(this);	//������Ļ����
		//���ʱ�����
		addListener();
	}
	
	//�¼�����
	private void addListener() {
		
		queDingBt.addActionListener(new LsnrChangeRoomBtn(this));
		quXiaoBt.addActionListener(new LsnrChangeRoomBtn(this));

	}
	
	//��������
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
		
		lb1 	  = new JLabel("         ԭ���䣺");
		lb2 	  = new JLabel("         ����Ϊ��");
		lb3 	  = new JLabel("     ���ۣ�");
		lb4 	  = new JLabel(" ע��ֻ�ܵ���Ϊͬ���͵ķ��䣡");
		lb5 	  = new JLabel();
		lb6 	  = new JLabel();
		beforeRoom = new JLabel("");
		
		chk       = new JCheckBox("    ����ԭ����ķ����");
		queDingBt = new TJButton ("pic/toolsbar/save.gif", "ȷ��", "ȷ����Ϣ",false); 
		quXiaoBt 	  = new TJButton ("pic/toolsbar/u01.gif", "ȡ��", "ȡ������",false); 
		
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
