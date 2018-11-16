package view.mainfrm.aboutus;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.component.swings.TJButton;
import common.component.tools.HotelTools;
import view.mainfrm.mainjiemian.FrmHotelMain;

public class FrmAboutUs extends JDialog implements ActionListener {

	JLabel top, li, tit, ver, user, boss, temp;
	JPanel pm, info, i1, i2, bott, bp;
	JButton bt1;

	public FrmAboutUs(JFrame frame) {
		super(frame, "关于我们", true);

		top = new JLabel(new ImageIcon("pic/toolsbar/"));
		li = new JLabel(new ImageIcon("pic/toolsbar/line1.gif"));
		tit = new JLabel("        欢 迎 使 用 泊隐 酒 店 管 理 系 统");
		ver = new JLabel("版本:  2018 1.01版        ");
		user = new JLabel("软件用户:  广大人民群众" );
		boss = new JLabel("美国队设计组    组长: 吴阿龙    副组长：张航   小组成员:  赵淼   陈浩    蒋一锋    沈灵芝  周琪 ");
		temp = new JLabel("       ");
		bt1 = new TJButton("pic/toolsbar/choose.gif", "确  定", "", false);

		pm = new JPanel(new BorderLayout());
		info = new JPanel(new GridLayout(4, 1, 0, 0));
		bott = new JPanel(new BorderLayout());
		i1 = new JPanel();
		i2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bp = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 8));

		// 制作信息面板
		i1.add(user);
		i2.add(ver);
		info.add(tit);
		info.add(i2);
		info.add(i1);
		info.add(boss);

		// 制作下边组件
		bp.add(bt1);
		bott.add("North", li);
		bott.add("West", temp);
		bott.add("East", bp);
		//bott.add("Center", fee);

		// 制作主面板
		pm.add("North", top);
		pm.add("South", bott);
		pm.add("Center", info);

		bt1.addActionListener(this);

		this.setContentPane(pm);
		this.setResizable(false);
		pack();
		// sunswing.setWindowCenter(this);
	}

	/**
	 * =======================================================================**
	 * ActionListener 监听
	 ** =======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false);
	}
	
//	public static void main(String[] args) {
//		 new FrmAboutUs().setVisible(true);;
//	}

}
