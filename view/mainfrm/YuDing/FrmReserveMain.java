package view.mainfrm.YuDing;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import common.backpifu.pifu.MyLookAndFeel;
import common.component.swings.TJButton;
import common.component.tools.SetWindow;
import control.mainfrm.lsnYuDing.LsnrYuDing;


/**
 * Ԥ������ģ���������
 * @author �Ⱒ��
 *
 */
public class FrmReserveMain extends JDialog {

	private static Object[] ReserveColumnNames = {"Ԥ������","�˿�����","�Ա�","�绰","���֤","�˿�����","�����","��������","Ա�����","Ա������","Ԥ��״̬","Ԥ�ִ�ʱ��","Ԥ����ʱ��"};
	public static DefaultTableModel modelReserve = new DefaultTableModel(new Object[][]{},ReserveColumnNames);
	private static JTable tblReserve = new JTable(modelReserve);   //��Ʒ��Ϣ��ͷ

	private JScrollPane sp ;//= new JScrollPane(tb);
	private JButton addBt, updateBt, deleteBt, seleteBt, shuaXinBt, openRoomBt;
	private JTextField tf1, tf2;
	private JPopupMenu pm;
	private JMenuItem mi1, mi2;
    private String[] YDStateName={"��ѡ��","��Ԥ��","����ס","��ȡ��"};
    private JComboBox<String> jcbxYDState=new JComboBox<String>();
	public FrmReserveMain(JFrame frame) {
		super(frame, "�ͻ�Ԥ��", true);
		init();
	}
	
	public void init() {
		JPanel panelMain, panelCent, panelNort;
		panelMain = new JPanel(new BorderLayout());
		panelNort = buildNorth();    // ��ťһ��
		panelCent = buildDTM();      // ��Ϣ���һ��

		panelMain.add("North", panelNort);
		panelMain.add(panelCent);
		// ���¼�����
		addListener();
		
		this.setContentPane(panelMain);
		this.setPreferredSize(new Dimension(880, 508));
		this.setMinimumSize(new Dimension(880, 508));
		this.setResizable(false); // ������ı䴰�ڴ�С
		pack();
		SetWindow.setWindowCenter(this); // ������Ļ����
	}

	private void addListener() {
         this.addBt.addActionListener(new LsnrYuDing(this));  
         this.seleteBt.addActionListener(new LsnrYuDing(this));  
         this.deleteBt.addActionListener(new LsnrYuDing(this));  
         
         this.updateBt.addActionListener(new LsnrYuDing(this));  
         this.jcbxYDState.addActionListener(new LsnrYuDing(this));  
         this.shuaXinBt.addActionListener(new LsnrYuDing(this));  
         this.openRoomBt.addActionListener(new LsnrYuDing(this));  
	}

	/**
	 * ������ťһ���������
	 * @return
	 */
	private JPanel buildNorth() {
		JPanel panelNort1 = new JPanel();
		JLabel lb = new JLabel("     �����/����/�绰:");
		tf1 = new JTextField(10);
		addBt = new TJButton("pic/toolsbar/����1.gif", "����", "����Ԥ����Ϣ", false);
		updateBt = new TJButton("pic/toolsbar/�޸�.gif", "�޸�", "�޸�Ԥ����Ϣ", false);
		deleteBt = new TJButton("pic/toolsbar/ɾ��.gif", "ɾ��", "ɾ��Ԥ����Ϣ", false);
		seleteBt = new TJButton("pic/toolsbar/��ѯ.gif", "��ѯ", "��ѯԤ����Ϣ", false);
		
		shuaXinBt = new TJButton("pic/toolsbar/ˢ��.gif", "ˢ��", "ˢ��Ԥ����Ϣ", false);
		openRoomBt = new TJButton("pic/toolsbar/���跿��.gif", "��ס", "ΪԤ�����俪��", false);

		for(String a:YDStateName){
			jcbxYDState.addItem(a);
		}
		
		pm = new JPopupMenu();
		mi1 = new JMenuItem("����Ԥ�Ƶִ�ı���");
		mi2 = new JMenuItem("����Ԥ�Ƶִ�ı���");
		pm.addSeparator();
		pm.add(mi1);
		pm.add(mi2);
		pm.addSeparator();
        
		panelNort1.add(addBt);
		panelNort1.add(updateBt);
		panelNort1.add(deleteBt);
		panelNort1.add(lb);
		panelNort1.add(tf1);
		panelNort1.add(seleteBt);
		panelNort1.add(jcbxYDState);
		panelNort1.add(shuaXinBt);
		panelNort1.add(openRoomBt);

		return panelNort1;
	}
	/**
	 * ���������Ϣ��ʾ���ģ��
	 * @return
	 */
	private JPanel buildDTM() {
		JPanel panelCent1 = new JPanel(new BorderLayout());
		tblReserve.getTableHeader().setReorderingAllowed(false);
		sp = new JScrollPane(this.tblReserve, 
		        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tf2 = new JTextField("����Ԥ����Ϣ");
		tf2.setHorizontalAlignment(JTextField.CENTER);
		tf2.setBackground(new Color(199, 183, 143));
		tf2.setBorder(new LineBorder(new Color(87, 87, 47)));
		tf2.setEditable(false);

		panelCent1.add("North", tf2);
		panelCent1.add(sp);
		panelCent1.setBorder(BorderFactory.createTitledBorder(""));

		return panelCent1;
	}
	
	
	
	public static JTable getTblReserve() {
		return tblReserve;
	}

	public JButton getAddBt() {
		return addBt;
	}

	public JButton getUpdateBt() {
		return updateBt;
	}

	public JButton getDeleteBt() {
		return deleteBt;
	}

	public JButton getSeleteBt() {
		return seleteBt;
	}

	public JComboBox<String> getJcbxYDState() {
		return jcbxYDState;
	}

	public JButton getShuaXinBt() {
		return shuaXinBt;
	}

	public JButton getOpenRoomBt() {
		return openRoomBt;
	}

	public JTextField getTf1() {
		return tf1;
	}

	public JTextField getTf2() {
		return tf2;
	}

	public static Object[] getReserveColumnNames() {
		return ReserveColumnNames;
	}

	public String[] getYDStateName() {
		return YDStateName;
	}

	/*public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(MyLookAndFeel.LIQUIDINF);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new FrmReserveMain(null).setVisible(true);
	}*/
	
}
