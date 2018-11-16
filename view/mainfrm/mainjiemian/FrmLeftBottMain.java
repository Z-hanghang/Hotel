package view.mainfrm.mainjiemian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import common.component.swings.TJTextField;
import control.mainfrm.mainjiemian.leftfrmlsnr.LsnrLeftFrm;
/**
 * 左下方用于搜索信息的面板
 * @author 吴阿龙
 *
 */
public class FrmLeftBottMain extends JPanel {

	private TJTextField tf;
	private JLabel lb;
	
	
	public TJTextField getTf() {
		return tf;
	}

	/**
	 * 构造函数
	 * 功能   ：组件主窗口左边下部面板
	 */
	public FrmLeftBottMain() {
		//设置主面板为边界部局
		super (new BorderLayout());
		
		lb = new JLabel (new ImageIcon ("pic/toolsbar/快速.png"));
		tf = new TJTextField ("", 10);
		lb.setBorder (new LineBorder (new Color (199, 183, 143)));
		tf.setLineWidth(1);
		//设置气泡提示信息
		tf.setToolTipText("输入房间号码，可直接获得房间的所有信息");
		//设置字体
		tf.setFont (new Font ("宋体", Font.PLAIN, 15));
		
		this.add ("North", tf);
		this.add ("Center", lb);
		
		//监听器事件
		addListener();
	}

	private void addListener() {
		this.tf.addActionListener(new LsnrLeftFrm(this));
	}
}
