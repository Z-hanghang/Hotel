/**
 
 *  公司名        : SunshineSOFT
 *	模块名       : 带监听的文本区域
 *	文件名        : TJTextField.java
 *	文件实现功能  : 带监听的文本区域
 *	
 *	 函数说明      :
 *	public TJTextArea(int r, int c) {} :
 *		功能: 构造函数	
 *
 *	[ 遗留问题    ]  : 
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
	 *			MouseListener 监听
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