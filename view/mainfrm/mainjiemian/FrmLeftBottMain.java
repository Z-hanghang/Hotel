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
 * ���·�����������Ϣ�����
 * @author �Ⱒ��
 *
 */
public class FrmLeftBottMain extends JPanel {

	private TJTextField tf;
	private JLabel lb;
	
	
	public TJTextField getTf() {
		return tf;
	}

	/**
	 * ���캯��
	 * ����   ���������������²����
	 */
	public FrmLeftBottMain() {
		//���������Ϊ�߽粿��
		super (new BorderLayout());
		
		lb = new JLabel (new ImageIcon ("pic/toolsbar/����.png"));
		tf = new TJTextField ("", 10);
		lb.setBorder (new LineBorder (new Color (199, 183, 143)));
		tf.setLineWidth(1);
		//����������ʾ��Ϣ
		tf.setToolTipText("���뷿����룬��ֱ�ӻ�÷����������Ϣ");
		//��������
		tf.setFont (new Font ("����", Font.PLAIN, 15));
		
		this.add ("North", tf);
		this.add ("Center", lb);
		
		//�������¼�
		addListener();
	}

	private void addListener() {
		this.tf.addActionListener(new LsnrLeftFrm(this));
	}
}
