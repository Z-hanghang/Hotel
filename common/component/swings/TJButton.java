package common.component.swings;

/**
 *	 ģ����        : ������ͼƬ��������ʾ�İ���
 *	 �ļ���        : TJButton.java
 *	 �ļ�ʵ�ֹ���  : ������ͼƬ��������ʾ�İ���
 *	 ����          : �Ⱒ��
 *	 �汾          : 1.0
 *	 �޸ļ�¼      : 
 *	 ��  ��                �汾                         �޸���                    �޸����� 
 *	2018/10/15    1.0                        �Ⱒ��                        ����
 *
 *  [ ��������    ]  : 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TJButton 
extends JButton 
implements MouseListener {
	
	/**
	 *			����   ��������ICO��������ʾ�Ĺ���������
	 */
	public TJButton(String picName, String text, String toolTip,boolean flag) {
		buildButton(picName, text, toolTip, flag);
	}
	
	/**
	 *			����   ��������ICO��������ʾ�Ĺ���������,������ʹ��
	 */
	private void buildButton(String picName, String text, String toolTip,boolean flag) {
		this.setIcon (new ImageIcon (picName));
		this.setText (text);
		this.setToolTipText (toolTip);
		if(flag) {
			//this.setBorderPainted (false);
			this.setContentAreaFilled(false);		//���ñ���ɫ͸��
			this.setHorizontalTextPosition (SwingConstants.CENTER);
			this.setVerticalTextPosition (SwingConstants.BOTTOM);
		}//End if(flag)
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
		this.setForeground(new Color(156, 126,  66));
		this.setBackground(new Color(234, 223, 203));
	}

	public void mouseExited (MouseEvent me) {
		this.setForeground(new Color( 87,  87,  47));
		this.setBackground(new Color(231, 215, 183));
	}
}
