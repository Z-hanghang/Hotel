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
		super(frame, "��������", true);

		top = new JLabel(new ImageIcon("pic/toolsbar/"));
		li = new JLabel(new ImageIcon("pic/toolsbar/line1.gif"));
		tit = new JLabel("        �� ӭ ʹ �� ���� �� �� �� �� ϵ ͳ");
		ver = new JLabel("�汾:  2018 1.01��        ");
		user = new JLabel("����û�:  �������Ⱥ��" );
		boss = new JLabel("�����������    �鳤: �Ⱒ��    ���鳤���ź�   С���Ա:  ���   �º�    ��һ��    ����֥  ���� ");
		temp = new JLabel("       ");
		bt1 = new TJButton("pic/toolsbar/choose.gif", "ȷ  ��", "", false);

		pm = new JPanel(new BorderLayout());
		info = new JPanel(new GridLayout(4, 1, 0, 0));
		bott = new JPanel(new BorderLayout());
		i1 = new JPanel();
		i2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bp = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 8));

		// ������Ϣ���
		i1.add(user);
		i2.add(ver);
		info.add(tit);
		info.add(i2);
		info.add(i1);
		info.add(boss);

		// �����±����
		bp.add(bt1);
		bott.add("North", li);
		bott.add("West", temp);
		bott.add("East", bp);
		//bott.add("Center", fee);

		// ���������
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
	 * ActionListener ����
	 ** =======================================================================**
	 */
	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false);
	}
	
//	public static void main(String[] args) {
//		 new FrmAboutUs().setVisible(true);;
//	}

}
