package view.mainfrm.mainjiemian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
/**
 * 用于右下方房间消费信息的显示面板
 * @author Administrator
 *
 */
public class FrmRightBottMain extends JPanel {
//	public static DefaultTableModel rbDTM;
	private JScrollPane sp;
	private static Object[] consumColumnNames = {"入 住 单 号", "房 间 号", "房 间 价 格 ","押  金", 
		      "商品名称","购买数量", "商品消费日期","商品消费金额"};
	private static JTable tblConsum = new JTable(new Object[][]{},consumColumnNames);   //商品信息表头
	
	
	public static Object[] getConsumColumnNames() {
		return consumColumnNames;
	}
	
	public static JTable getTblConsum() {
		return tblConsum;
	}

	/**
	 *功能   ：右下面板构造函数
	 */
	public FrmRightBottMain() {
		super (new BorderLayout());
		//声名表格
		init();	
	}
	
	public void init() {
		tblConsum.getTableHeader().setReorderingAllowed(false);
		sp = new JScrollPane(this.tblConsum, 
		        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tblConsum.setRowHeight (18);			//表格的行高度
		tblConsum.setEnabled(false);
		tblConsum.setMinimumSize(new Dimension(600, 90));
		sp.setBorder(new LineBorder(new Color(199, 183, 143)));
		//将表格加入面板
		this.add("Center", sp);
	}
}
