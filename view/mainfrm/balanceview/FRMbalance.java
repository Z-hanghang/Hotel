package view.mainfrm.balanceview;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.mainfrm.balanceControl.LsnrBtnfindgoods;
import control.mainfrm.balanceControl.LsnrBtnfindroom;

public class FRMbalance extends JFrame {
	
	 private JTextField txtFangJianHaofj = new JTextField(15);
	  private JTextField txtjiezhangzhuangtaifj= new JTextField(15);
	  private JButton btnfangjianChaZhao = new JButton("��  ��");
	  private Object[] fangjianColumnNames = {"���㵥��","��ס����","�˿�����","�˿�����","�����","��������","�����ܶ�","�ѽ�Ѻ��","�˻�Ѻ��","����״̬","��ע","����Ա��"};
	  private JTable tblfangjian = new JTable(new Object[][]{}, fangjianColumnNames);
	  private JTextField txtFangJianhaosp  = new JTextField(15);
	  private JTextField txtjiezhangzhuangtaisp = new JTextField(15);
	  private JButton btnshangpinChaZhao = new JButton("��  ��");
	  private Object[] shangpinColumnNames = {"�����","�˿�����","��Ʒ����","��������","��������","��������","����״̬"};
	  private JTable tblshangpin = new JTable(new Object[][]{}, shangpinColumnNames);
	  
	  public FRMbalance (String title) {//���췽��
	    super(title);
	    init();
	  }
	  
	  public JTextField getTxtfangjianhaofj() {
	    return txtFangJianHaofj;
	  }

	  public JTextField getTxtgukeMing() {
	    return txtjiezhangzhuangtaifj;
	  }

	  public Object[] getfangjianColumnNames() {
	    return fangjianColumnNames;
	  }

	  public JTable getTblfangjian() {
	    return tblfangjian;
	  }
	  public JTable getTblshangpin() {
		return tblshangpin;
	  }
	  public JTextField txtFangJianhaosp() {
	    return txtFangJianhaosp;
	  }
	  public JTextField txtjiezhangzhuangtaifj() {
	    return txtjiezhangzhuangtaifj;
	  }
	  public JTextField txtjiezhangzhuangtaisp() {
	    return txtjiezhangzhuangtaisp;
	  }
	  public Object[] getshangpinColumnNames() {
	    return shangpinColumnNames;
	  }

	
	  private void init() {
	    this.setSize(900,500);//���ô����С
	    this.setLocationRelativeTo(null);//���˴���������Ļ������
	    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ڴ��ڱ��رյ�ʱ���ر��������
	    this.setResizable(false);
	    
	    JPanel pane = addComp();
	    addListener();
	    
	    this.add(pane);
	    this.setVisible(false);
	  }
	  
	  private JPanel addComp() {
	    JPanel pane = new JPanel();//����һ�����
	    pane.setLayout(new BorderLayout());//���ò��ֹ�����
	    
	    JTabbedPane tabPane = initTabPane();//ѡ����
	    pane.add(tabPane, BorderLayout.CENTER);//�������Ӿֲ�������������
	    
	    return pane;
	  }
	  
	  private void addListener() {//��Ӽ�����
		 this.btnfangjianChaZhao.addActionListener(new LsnrBtnfindroom(this));//����Ų��Ҽ�����
		 this.btnshangpinChaZhao.addActionListener(new LsnrBtnfindgoods(this));//��Ʒ���Ҽ�����
	  }
	  
	  private JTabbedPane initTabPane() {
	    JTabbedPane tabPane = new JTabbedPane();//����һ��ѡ�
	    
	    initJieSuan(tabPane);
	    initShangPin(tabPane);
	    
	    return tabPane;
	  }
	  
	  private void initJieSuan(JTabbedPane tabPane) {
	    JPanel pane = new JPanel();//����һ�����
	    pane.setLayout(new BorderLayout());//���ò��ֹ�����
	    
	    JPanel jieSuanNorthPane = initJieSuanNorth();
	    JPanel jieSuanCenterPane = initJieSuanCenter();
	    JPanel jieSuanSouthPane = initJieSuanSouth();
	    
	    pane.add(jieSuanNorthPane, BorderLayout.NORTH);
	    pane.add(jieSuanCenterPane, BorderLayout.CENTER);
	    pane.add(jieSuanSouthPane, BorderLayout.SOUTH);
	    
	    tabPane.addTab("�����ѯ", pane);
	  }
	  
	  private JPanel initJieSuanNorth() {//�����ǩ��Ϊ��ǩ����ı���
	    JPanel pane = new JPanel();
	    
	    JLabel lblfangjianhao = new JLabel("����ţ�");
	    pane.add(lblfangjianhao);
	    pane.add(this.txtFangJianHaofj );
	   
	    JLabel lbljiezhangzhuangtai = new JLabel("����״̬ ��");
	    pane.add(lbljiezhangzhuangtai);
	    pane.add(this.txtjiezhangzhuangtaifj);
	    
	    pane.add(this.btnfangjianChaZhao);
	    
	    return pane;
	  }
	  
	  
	  private JPanel initJieSuanCenter() {
	    JPanel pane = new JPanel();//����һ�����
	    
	    pane.setLayout(new BorderLayout());
	    
	    JScrollPane spane = new JScrollPane(this.tblfangjian, 
	        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//��ӹ�����
	    
	    pane.add(spane, BorderLayout.CENTER);
	    
	    return pane;
	  }
	  
	  private JPanel initJieSuanSouth() {
	    JPanel pane = new JPanel();
	    
	    JLabel lblShuoMing = new JLabel("˵����  ����״̬    ��1�� �� �ѽ���     ��0�� �� δ���� ");
	    pane.add(lblShuoMing);
	    
	    return pane;
	  }
	  
	  private void initShangPin(JTabbedPane tabPane) {
	    JPanel pane = new JPanel();
	    pane.setLayout(new BorderLayout());//���ò��ֹ�����
	    
	    JPanel shangPinNorthPane = initShangPinNorth();
	    JPanel shangPinCenterPane = initShangPinCenter();
	    JPanel shangPinSouthPane = initShangPinSouth();
	    
	    pane.add(shangPinNorthPane, BorderLayout.NORTH);//Ϊ���ֹ�����������
	    pane.add(shangPinCenterPane, BorderLayout.CENTER);
	    pane.add(shangPinSouthPane, BorderLayout.SOUTH);
	    
	    tabPane.addTab("��Ʒ����", pane);
	  }

	  private JPanel initShangPinNorth() {
	    JPanel pane = new JPanel();//����һ�����
	    
	    JLabel lblFangJianHao = new JLabel("����� ��");//����һ����ǩ
	    pane.add(lblFangJianHao);//�������ӵ������
	    pane.add(this.txtFangJianhaosp);
	    
	    JLabel lblJieZhangZhuangTai = new JLabel("����״̬ ��");
	    pane.add(lblJieZhangZhuangTai);
	    pane.add(this.txtjiezhangzhuangtaisp);
	    pane.add(this.btnshangpinChaZhao);
	    
	    return pane;
	  }
	  
	  private JPanel initShangPinCenter() {
	    JPanel pane = new JPanel();//����һ�����
	    
	    pane.setLayout(new BorderLayout());//���ò��ֹ�����
	    
	    JScrollPane spane = new JScrollPane(this.tblshangpin, 
	        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//����������
	    
	    pane.add(spane, BorderLayout.CENTER);
	    
	    return pane;
	  }
	  
	  private JPanel initShangPinSouth() {
	    JPanel pane = new JPanel();
	    
	    JLabel lblShuoMing = new JLabel("˵����  ����״̬    ��1�� �� �ѽ���     ��0�� �� δ���� ");
	    pane.add(lblShuoMing);
	    
	    return pane;
	  }
	  
	/* public static void main(String[] args) {
	    new FRMbalance("").setVisible(true);
	 }*/
}