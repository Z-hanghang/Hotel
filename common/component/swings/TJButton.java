package common.component.swings;

/**
 *	 模块名        : 制作带图片和气泡提示的按键
 *	 文件名        : TJButton.java
 *	 文件实现功能  : 制作带图片和气泡提示的按键
 *	 作者          : 吴阿龙
 *	 版本          : 1.0
 *	 修改记录      : 
 *	 日  期                版本                         修改人                    修改内容 
 *	2018/10/15    1.0                        吴阿龙                        创建
 *
 *  [ 遗留问题    ]  : 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TJButton 
extends JButton 
implements MouseListener {
	
	/**
	 *			功能   ：制作带ICO和气泡提示的工具栏按键
	 */
	public TJButton(String picName, String text, String toolTip,boolean flag) {
		buildButton(picName, text, toolTip, flag);
	}
	
	/**
	 *			功能   ：制作带ICO和气泡提示的工具栏按键,仅类内使用
	 */
	private void buildButton(String picName, String text, String toolTip,boolean flag) {
		this.setIcon (new ImageIcon (picName));
		this.setText (text);
		this.setToolTipText (toolTip);
		if(flag) {
			//this.setBorderPainted (false);
			this.setContentAreaFilled(false);		//设置背景色透明
			this.setHorizontalTextPosition (SwingConstants.CENTER);
			this.setVerticalTextPosition (SwingConstants.BOTTOM);
		}//End if(flag)
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
		this.setForeground(new Color(156, 126,  66));
		this.setBackground(new Color(234, 223, 203));
	}

	public void mouseExited (MouseEvent me) {
		this.setForeground(new Color( 87,  87,  47));
		this.setBackground(new Color(231, 215, 183));
	}
}
