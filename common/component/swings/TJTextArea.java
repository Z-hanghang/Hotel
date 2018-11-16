/**
 
 *  ��˾��        : SunshineSOFT
 *	ģ����       : ���������ı�����
 *	�ļ���        : TJTextField.java
 *	�ļ�ʵ�ֹ���  : ���������ı�����
 *	
 *	 ����˵��      :
 *	public TJTextArea(int r, int c) {} :
 *		����: ���캯��	
 *
 *	[ ��������    ]  : 
 */
package common.component.swings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TJTextArea 
extends JTextArea 
implements MouseListener {
	
	public TJTextArea(int r, int c) {
		super(r, c);
		this.setForeground(new Color(161, 149, 121));
		this.setBackground(new Color(233, 227, 214));
		this.addMouseListener(this);
	}
	
	/**
	 *			MouseListener ����
	 */
	public void mouseClicked (MouseEvent me) {
	}

	public void mousePressed (MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseEntered (MouseEvent me) {
		this.setForeground(new Color( 87,  87,  47));
		this.setBackground(new Color(248, 242, 230));
	}

	public void mouseExited (MouseEvent me) {
		this.setForeground(new Color(161, 149, 121));
		this.setBackground(new Color(233, 227, 214));
	}
}