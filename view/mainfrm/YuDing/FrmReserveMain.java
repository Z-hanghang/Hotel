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
 * 预定功能模块的主界面
 * @author 吴阿龙
 *
 */
public class FrmReserveMain extends JDialog {

	private static Object[] ReserveColumnNames = {"预定单号","顾客姓名","性别","电话","身份证","顾客类型","房间号","房间类型","员工编号","员工姓名","预定状态","预抵达时间","预保留时间"};
	public static DefaultTableModel modelReserve = new DefaultTableModel(new Object[][]{},ReserveColumnNames);
	private static JTable tblReserve = new JTable(modelReserve);   //商品信息表头

	private JScrollPane sp ;//= new JScrollPane(tb);
	private JButton addBt, updateBt, deleteBt, seleteBt, shuaXinBt, openRoomBt;
	private JTextField tf1, tf2;
	private JPopupMenu pm;
	private JMenuItem mi1, mi2;
    private String[] YDStateName={"请选择","已预订","已入住","已取消"};
    private JComboBox<String> jcbxYDState=new JComboBox<String>();
	public FrmReserveMain(JFrame frame) {
		super(frame, "客户预订", true);
		init();
	}
	
	public void init() {
		JPanel panelMain, panelCent, panelNort;
		panelMain = new JPanel(new BorderLayout());
		panelNort = buildNorth();    // 按钮一栏
		panelCent = buildDTM();      // 信息表格一栏

		panelMain.add("North", panelNort);
		panelMain.add(panelCent);
		// 加事件监听
		addListener();
		
		this.setContentPane(panelMain);
		this.setPreferredSize(new Dimension(880, 508));
		this.setMinimumSize(new Dimension(880, 508));
		this.setResizable(false); // 不允许改变窗口大小
		pack();
		SetWindow.setWindowCenter(this); // 窗口屏幕居中
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
	 * 建立按钮一块的面板组件
	 * @return
	 */
	private JPanel buildNorth() {
		JPanel panelNort1 = new JPanel();
		JLabel lb = new JLabel("     房间号/姓名/电话:");
		tf1 = new JTextField(10);
		addBt = new TJButton("pic/toolsbar/增加1.gif", "增加", "增加预定信息", false);
		updateBt = new TJButton("pic/toolsbar/修改.gif", "修改", "修改预定信息", false);
		deleteBt = new TJButton("pic/toolsbar/删除.gif", "删除", "删除预定信息", false);
		seleteBt = new TJButton("pic/toolsbar/查询.gif", "查询", "查询预定信息", false);
		
		shuaXinBt = new TJButton("pic/toolsbar/刷新.gif", "刷新", "刷新预定信息", false);
		openRoomBt = new TJButton("pic/toolsbar/开设房间.gif", "入住", "为预定房间开单", false);

		for(String a:YDStateName){
			jcbxYDState.addItem(a);
		}
		
		pm = new JPopupMenu();
		mi1 = new JMenuItem("今天预计抵达的宾客");
		mi2 = new JMenuItem("明天预计抵达的宾客");
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
	 * 构建表格信息显示面板模块
	 * @return
	 */
	private JPanel buildDTM() {
		JPanel panelCent1 = new JPanel(new BorderLayout());
		tblReserve.getTableHeader().setReorderingAllowed(false);
		sp = new JScrollPane(this.tblReserve, 
		        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tf2 = new JTextField("宾客预定信息");
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
