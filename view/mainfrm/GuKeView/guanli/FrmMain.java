package view.mainfrm.GuKeView.guanli;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.mainfrm.GuKe.customerguanli.LsnrBtnChaZhao;
import control.mainfrm.GuKe.customerguanli.LsnrBtnShanChu;
import control.mainfrm.GuKe.customerguanli.LsnrBtnXinZeng;
import control.mainfrm.GuKe.customerguanli.LsnrBtnXiuGai;

import control.mainfrm.GuKe.vipguanli.LsnrVipChaZhao;
import control.mainfrm.GuKe.vipguanli.LsnrVipShanChu;

import control.mainfrm.GuKe.vipguanli.LsnrVipXiuGai;
import javax.swing.ImageIcon;



/**
 * �ͻ����������� ###################################################################
 * 
 * @author ��һ�� ���ܣ��Կͻ�����Ϣ������ɾ�Ĳ� �������ڣ�10/16
 */

public class FrmMain extends JFrame {
	/*
	 * �ͻ���Ϣģ��
	 */
	private JRadioButton rbCustomerTel = new JRadioButton("�ֻ���");
	private JRadioButton rbCustomerName = new JRadioButton("�˿�����");
	private JTextField txtcustomertel = new JTextField(20);
	private JTextField txtcustomername = new JTextField(20);
	private JTextField txtcustomerid = new JTextField(20);
	public JTextField getTxtcustomerid() {
		return txtcustomerid;
	}



	public void setTxtcustomerid(JTextField txtcustomerid) {
		this.txtcustomerid = txtcustomerid;
	}

	private Object[] CustomerColumnNames = { "�˿ͱ��", "�˿�����", "�Ա�", "�ֻ���", "���֤��", "�˿����ͱ��" };
	private JTable tblcustomer = new JTable(new Object[][] {}, CustomerColumnNames);
	private JButton btncustomerchazhao = new JButton("����");
	private JButton btnaddVip= new JButton("��ӻ�Ա");
	private JButton btncustomerXinZeng = new JButton("����");
	private JButton btncustomerXiuGai = new JButton("��  ��");
	private JButton btncustomerShanChu = new JButton("ɾ  ��");

	// ---------------------------------------------------------------

	

	/*
	 * ��Աģ��
	 */
	private JTextField txtVipId = new JTextField(20);
	private Object[] VipColumnNames = { "��Ա���", "�˿ͱ��", "�˿����ͱ��" };
	private JTable tblVip = new JTable(new Object[][] {}, VipColumnNames);
	private JButton btnVipChaZhao = new JButton("����");
	
	private JButton btnVipXiuGai = new JButton("��  ��");
	private JButton btnVipShanChu = new JButton("ɾ  ��");

	// ---------------------------------------------------------------------------
	public FrmMain(String title) {
		super(title);
		init();
	}

	

	public JButton getBtncustomerXiuGai() {
		return btncustomerXiuGai;
	}



	public JRadioButton getRbCustomerTel() {
		return rbCustomerTel;
	}



	public JRadioButton getRbCustomerName() {
		return rbCustomerName;
	}



	public JTextField getTxtcustomertel() {
		return txtcustomertel;
	}

	public JTextField getTxtcustomername() {
		return txtcustomername;
	}

	public Object[] getCustomerColumnNames() {
		return CustomerColumnNames;
	}

	public JTable getTblcustomer() {
		return tblcustomer;

	}


	public JButton getBtnaddVip() {
		return btnaddVip;
	}



	public JTextField getTxtVipId() {
		return txtVipId;
	}

	public Object[] getVipColumnNames() {
		return VipColumnNames;
	}

	public JTable getTblVip() {
		return tblVip;
	}

	private void init() {
		this.setSize(800, 400); // ���ô�С
		this.setLocationRelativeTo(null); // ����λ��
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ر�ʱ�Ĳ���
                this.setIconImage(new ImageIcon("pic/toolsbar/�ͻ�.png").getImage());
		JPanel pane = addComp(); // ������
		addListener(); // ��Ӽ�����

		this.add(pane);
		this.setVisible(true); // ���ÿ���

	}

	private JPanel addComp() {
		JFrame frame = new JFrame();

		JPanel pane = new JPanel(); // �������
		pane.setLayout(new BorderLayout()); // ���ò��ֹ�����

		JTabbedPane tabPane = initTabPane(); // ���ñ�ǩ
		// һ��������������û�ͨ���������и��������/��ͼ���ѡ�����һ�����֮������л�
		pane.add(tabPane, BorderLayout.CENTER);

		return pane;
	}

	/* ���ù˿���Ϣ/�˿����ͱ�ǩ/��Ա */
	private JTabbedPane initTabPane() {

		JTabbedPane tabPane = new JTabbedPane();

		initCustomer(tabPane);
		
		initVip(tabPane);
		return tabPane;
	}



	

	

	/* �в��˿���Ϣ������� */
	private void initCustomer(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JPanel CustomerNorthPane = initCustomerNorth();
		JPanel CustomerCenterPane = initCustomerCenter();
		JPanel CustomerSouthPane = initCustomerSouth();

		pane.add(CustomerNorthPane, BorderLayout.NORTH);
		pane.add(CustomerCenterPane, BorderLayout.CENTER);
		pane.add(CustomerSouthPane, BorderLayout.SOUTH);

		tabPane.addTab("�˿���Ϣ", pane);
	}

	// ����
	private JPanel initCustomerNorth() {
		JPanel pane = new JPanel();
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbCustomerTel);
        bg.add(rbCustomerName);
		pane.add(this.rbCustomerTel);

		pane.add(this.txtcustomertel);

		pane.add(this.rbCustomerName);

		pane.add(this.txtcustomername);
		pane.add(this.btncustomerchazhao);
		pane.add(btnaddVip);
		return pane;
	}

	// �в�
	private JPanel initCustomerCenter() {
		JPanel pane = new JPanel();

		pane.setLayout(new BorderLayout()); // ���ñ߿򲼾ֹ�����

		JScrollPane spane = new JScrollPane(this.tblcustomer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // ��ӹ�����

		pane.add(spane, BorderLayout.CENTER);

		return pane;
	}

	// �ϲ�
	private JPanel initCustomerSouth() {
		JPanel pane = new JPanel();

		pane.add(this.btncustomerXinZeng);

		pane.add(this.btncustomerXiuGai);

		pane.add(this.btncustomerShanChu);

		return pane;
	}

	private void addListener() {
		/* �˿���Ϣ������ */
		this.btncustomerchazhao.addActionListener(new LsnrBtnChaZhao(this)); //�˿Ͳ��ҹ���
		this.btncustomerShanChu.addActionListener(new LsnrBtnShanChu(this)); //�˿�ɾ������
		this.btncustomerXinZeng.addActionListener(new LsnrBtnXinZeng(this)); //�˿���������
		this.btncustomerXiuGai.addActionListener(new LsnrBtnXiuGai(this));   //�˿��޸Ĺ���
		this.btnaddVip.addActionListener(new LsnrBtnXiuGai(this)); 
        /*��Ա������*/
		this.btnVipChaZhao.addActionListener(new LsnrVipChaZhao(this));   //��Ա���ҹ���
		this.btnVipShanChu.addActionListener(new LsnrVipShanChu(this));   //��Աɾ������
		this.btnVipXiuGai.addActionListener(new LsnrVipXiuGai(this));     //��Ա�޸Ĺ���
		   //��Ա��������
	}
    //��Ա����
	private void initVip(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		/* ������Ϊ�����У��ϣ������� */
		JPanel vipNorthPane = initVipNorth();
		JPanel vipCenterPane = initVipCenter();

		pane.add(vipNorthPane,BorderLayout.NORTH);
		pane.add(vipCenterPane, BorderLayout.CENTER);

		tabPane.addTab("��Ա����", pane);
		
	}
   //����
	private JPanel initVipNorth() {
		JPanel pane = new JPanel();
		
		JLabel lblVip = new JLabel("��Ա��� ��");
		pane.add(lblVip);
		pane.add(this.txtVipId);
		pane.add(this.btnVipChaZhao);
		pane.add(this.btnVipXiuGai);
	   pane.add(this.btnVipShanChu);
		return pane;
	}
    //�в�
	private JPanel initVipCenter() {
		JPanel pane = new JPanel();

		pane.setLayout(new BorderLayout()); // ���ñ߿򲼾ֹ�����

		JScrollPane spane = new JScrollPane(this.tblVip, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // ��ӹ�����

		pane.add(spane, BorderLayout.CENTER);

		return pane;
	}

	/*public static void main(String[] args) {
		new FrmMain("").setVisible(true);
	}*/

	

}
