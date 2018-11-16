package view.mainfrm.checkinview;

//import ruzhu1016;
//import gui.guanli.FrmMain;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;


import control.mainfrm.checkinControl.LsnrBtnfindcheckin;
import control.mainfrm.checkinControl.LsnrBtnradiobutton;
//import control.xueshengguanli.LsnrBtnxueshengchazhao;
/**
 * @author ����֥
 * 
 * **/
public class Frmcheckin extends JFrame {

	private JTextField txtFangJianHao = new JTextField(15);// �����ı����С
	private JTextField Txtgukeming = new JTextField(15);
	private JButton btnkehuChaZhao = new JButton("��  ��");// ���ð�ť
	private JRadioButton s1 = new JRadioButton("�ѽ���");
	private JRadioButton s2 = new JRadioButton("δ����");
	private JRadioButton s3 = new JRadioButton("��ʾ������ס��Ϣ");// ���ð�ť��
	ButtonGroup group = new ButtonGroup();

	private Object[] fangjianColumnNames = { "������", "�˿�����", "�˿�����", "�����", "��������", "��ס����", "Ѻ��",
			"��סʱ��", "�˷�ʱ��", "����״̬", "����Ա��"};
	private JTable tblfangjian = new JTable(new Object[][] {}, fangjianColumnNames);

	public Frmcheckin(String title) {
		super(title);
		init();
	}

	public JTextField getTxtFangJianHao() {// ���췽��
		return txtFangJianHao;
	}

	public Object[] getfangjianColumnNames() {
		return fangjianColumnNames;
	}

	public JTextField getTxtgukeming() {
		// TODO Auto-generated method stub
		return Txtgukeming;
	}

	public JTable gettblfangjian() {
		return tblfangjian;
	}

	private void init() {
		this.setSize(780, 500); // ���崰���С
		this.setLocationRelativeTo(null);
		
		JPanel pane = addComp();// ����һ�����
		addListener();
		this.add(pane); // �������
		this.setVisible(true);// ��ʾ���
	}

	private JPanel addComp() {
		JPanel pane = new JPanel();// ����һ�����
		pane.setLayout(new BorderLayout());// ���ֹ�����

		JPanel ruZhuNorthPane = initRuZhuNorth();
		JPanel ruZhuCenterPane = initRuZhuCenter();
		JPanel ruZhuSouthPane = initRuZhuSouth();

		pane.add(ruZhuNorthPane, BorderLayout.NORTH);// Ϊ���ֹ�����������
		pane.add(ruZhuCenterPane, BorderLayout.CENTER);
		pane.add(ruZhuSouthPane, BorderLayout.SOUTH);
		
//		JTabbedPane tabPane = initTabPane();// ����ѡ����
//		pane.add(tabPane, BorderLayout.CENTER);// �������ӵ��߽粼�ֹ������м�
		return pane;
	}

	private void addListener() {// ����������
		this.btnkehuChaZhao.addActionListener(new LsnrBtnfindcheckin(this));
		this.s1.addActionListener(new LsnrBtnradiobutton(this));
		this.s2.addActionListener(new LsnrBtnradiobutton(this));
		this.s3.addActionListener(new LsnrBtnradiobutton(this));

	}

//	private JTabbedPane initTabPane() {
//		JTabbedPane tabPane = new JTabbedPane();
//
//		// initBanJi(tabPane);
//		initRuZhu(tabPane);
//
//		return tabPane;
//	}
//
//	private void initRuZhu(JTabbedPane tabPane) {
//		JPanel pane = new JPanel();
//		pane.setLayout(new BorderLayout());// ���ò��ֹ�����
//
//		tabPane.addTab("��ס��Ϣ", pane);
//	}

	private JPanel initRuZhuNorth() {
		JPanel pane = new JPanel();// ����һ�����

		JLabel lblfangjianhao = new JLabel("����ţ�");// ����һ����ǩ
		pane.add(lblfangjianhao);// �������ӵ������
		pane.add(this.getTxtFangJianHao());

		JLabel lblgukeMing = new JLabel("�˿��� ��");// ����һ����ǩ
		pane.add(lblgukeMing);// �������ӵ������
		pane.add(this.getTxtgukeming());
		pane.add(this.btnkehuChaZhao);
		return pane;
	}

	private JPanel initRuZhuCenter() {// ��ӹ�����
		JPanel pane = new JPanel();// ����һ�����
		pane.setLayout(new BorderLayout());// ���ֹ�����
		JScrollPane spane = new JScrollPane(this.tblfangjian, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);// ������
		pane.add(spane, BorderLayout.CENTER);// �����嵽���ֹ������м�
		// pane.setVisible(true);
		return pane;
	}

	private JPanel initRuZhuSouth() {
		JPanel pane = new JPanel();

		group.add(s1);// ����ť��ӵ���ť��
		group.add(s2);
		group.add(s3);
		pane.add(s1);// ����ť��ӵ������
		pane.add(s2);
		pane.add(s3);
		return pane;
	}

	/*public static void main(String[] args) {
		new Frmcheckin("").setVisible(true);
	}*/

	public String getgukebianhao(Object setgukeming) {
		// TODO Auto-generated method stub
		return getgukebianhao(null);
	}

	public Object getS3() {

		return s3;
	}

	public Object getS2() {

		return s2;
	}

	public Object getS1() {

		return s1;
	}
}
