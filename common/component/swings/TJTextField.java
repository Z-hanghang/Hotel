package common.component.swings;
/**
 *	 模块名        : 带监听的文本框
 *  文件名        : TJTextField.java
 *	 文件实现功能  : 带监听的文本框
 *	函数说明      :
 *	public TJTextField(String text) {} 
 *		功能: 构造函数	
 *
 *  public TJTextField(String text, int column) {} 
 *		功能: 构造函数  
 *	
 *	 public void setLineWidth(int l) {} :
 *		功能: 设置外框线宽
 *
 *   遗留问题      : 
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class TJTextField 
extends JTextField 
implements MouseListener, FocusListener {
	
	private int houdu = 1;   //布局厚度
	
	public TJTextField() {
		setStyle();
	}
	
	public TJTextField(int col) {
		super(col);
		setStyle();
	}
	
	public TJTextField(String text) {
		super(text);
		setStyle();
	}
	
	public TJTextField(String text, int column) {
		super(text, column);
		setStyle();
	}
	
	public void setLineWidth(int l) {
		houdu = l;
		this.setBorder(new LineBorder(new Color(159, 145, 118), houdu));
	}
	
	private void setStyle() {
		this.setForeground(new Color( 87,  87,  47));
		this.setBackground(new Color(248, 242, 230));
		this.setBorder(new LineBorder(new Color(159, 145, 118), houdu));
		this.addMouseListener(this);
		this.addFocusListener(this);
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
		this.setBorder(new LineBorder(new Color(241, 171, 84), houdu));
	}

	public void mouseExited (MouseEvent me) {
		this.setBorder(new LineBorder(new Color(159, 145, 118), houdu));
	}
	
	/**
	 *			FocusListener 监听
	 */
	public void focusGained (FocusEvent fe) {
		this.setBorder(new LineBorder(new Color(241, 171, 84), houdu));
	}
	
	public void focusLost (FocusEvent fe) {
		this.setBorder(new LineBorder(new Color(159, 145, 118), houdu));
	}
}