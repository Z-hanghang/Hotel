/**
 *	 ģ����        : ViewList�ؼ�
 *	 �ļ���        : ViewList.java
 *	 �ļ�ʵ�ֹ���  : ���ɺ��ҵĵ��Բ������
 *	
 *	 ����˵��      :	
 *	
 *	 public ViewList(int buttons) {} :
 *		����: ���캯���������������
 *
 *	 public void remeButtons() {} :	
 *		����: ��������λ
 *
 *	 public JButton getButton(String roomNum) {} :
 *		����: �������е�ָ������
 *
 *	 public void setButtonImage(String buttonName, String state) {} :
 *		����: ���ð���ͼƬ
 *	
 *	public void addButton(String name) {} :
 *		�������ܰ�������������Ӧ��ģ���У�����JButton����������Ӽ���
 *
 *  [ ��������    ]  : 
 */
package common.component.swings;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class ViewList extends JPanel {
	
	//���ð���������
	private Hashtable buttons = new Hashtable();
	//���ð��������
	private JPanel panelMain;
	//ViewList ������򰴼��ĸ�����������
	public static int column	= 8;
	public static int row		= 5;
	
	//����ڰ�������
	public static int buttonTotal = 40;
	//����������
	private int buttonCount = 0;
	
	
	/**���캯���������������
	 *����   ��int buttons ��ʾViewList�еİ�������
	 *����   �����캯���������������
	 */
	public ViewList(int buttons) {
		super(new BorderLayout());
		
		JScrollPane spMain;								//����������
		
		//���ݰ������ݼ�����������������
		int vRow = buttons / column;
		if(vRow > row) {					//������㹻�İ������������������������
			if(buttons % column > 0) {		//����ʹ��Ĭ������ row = 5
				row = vRow + 1;
			}else {
				row = vRow;
			}
			buttonTotal = buttons;						//��ð�������
		}
		
		//�����������
		panelMain	= new JPanel(new GridLayout(row, 1, 5, 15));
//		JLabel panelLable = new JLabel(new ImageIcon("pic/room/p2.jpg"));
//		panelLable.setBounds(2, 2, new ImageIcon("pic/room/p2.jpg").getIconWidth(), new ImageIcon("pic/room/p2.jpg").getIconHeight());
//		panelMain.add(panelLable);
		//����Ĭ�ϱ���ɫ
		panelMain.setBackground(new Color(248, 242, 230));  //new Color(193, 210, 240)
		
		spMain	  = new JScrollPane(panelMain);
		//���������
		this.add("Center", spMain);
	}
	
	/**
	 * ��������λ
	 *	����   ����������λ����������������� column * row ��ӿ�JLabel��λ��
	 *  ��Ȼ�ֻܾ���	ע�⣬�÷����ڼ������а�����ʹ��
	 */
	public void remeButtons() {
		if(buttonCount < buttonTotal) {
			for (int i = 0; i < buttonTotal - buttonCount; i++) {
				JLabel lb = new JLabel("��");
				panelMain.add(lb);				//����λ
		    }
		}
	}
	
	/**		
	 *	����   ��String roomNum �����ʾ�������֣�Ҳ���Ƿ����
	 *	����   ���������е�ָ������
	 */
	public JButton getButton(String roomNum) {
		return (JButton)buttons.get(roomNum);
	}
	
	/**		
	 *����   ��String buttonName �����ʾ�����ڹ�ϣ���еļ���
	 *String State �����ʾ����״̬
	 *����   �����ð���ͼƬ
	 */
	public void setButtonImage(String buttonName, String state) {
//		System.out.println(buttonName);
//		System.out.println(state);
		String picName = "";

		if(state.equals("RS01"))      //�շ���
			picName = "pic/room/�շ�.png";
		else if(state.equals("RS02"))       //��Ԥ������
			picName = "pic/room/��Ԥ��.png";
		else if(state.equals("RS03"))        //����ס����
			picName = "pic/room/��ס.png";
		else if(state.equals("RS04"))        //�෿��
			picName = "pic/room/1.jpg";
		else if(state.equals("RS05"))        //��ά��ʱ��
			picName = "pic/room/ά��.jpg";

		((JButton)buttons.get(buttonName)).setIcon(new ImageIcon(picName));
		
	}
	
	/**
	 *����   ��String name	��ʾ���ܰ���������
	 *����   ���������ܰ�������������Ӧ��ģ���У�����JButton����������Ӽ���
	 */
	public JButton addButton(String name) {
		JButton button = new JButton(name);
		button.setBorderPainted(false);				//���ð����ޱ߿�
		button.setContentAreaFilled(false);			//���ð�������ɫ͸��
		button.setHorizontalTextPosition(SwingConstants.CENTER);//����Ico�����־���
		button.setVerticalTextPosition(SwingConstants.BOTTOM);//����Ico������ֵ�λ��
		panelMain.add(button);		  				//���������밴�����
		buttons.put(name, button);					//�����������ϣ��
		buttonCount++;								//����������+1
		return button;
	}
}