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
 * �������·�����������Ϣ����ʾ���
 * @author Administrator
 *
 */
public class FrmRightBottMain extends JPanel {
//	public static DefaultTableModel rbDTM;
	private JScrollPane sp;
	private static Object[] consumColumnNames = {"�� ס �� ��", "�� �� ��", "�� �� �� �� ","Ѻ  ��", 
		      "��Ʒ����","��������", "��Ʒ��������","��Ʒ���ѽ��"};
	private static JTable tblConsum = new JTable(new Object[][]{},consumColumnNames);   //��Ʒ��Ϣ��ͷ
	
	
	public static Object[] getConsumColumnNames() {
		return consumColumnNames;
	}
	
	public static JTable getTblConsum() {
		return tblConsum;
	}

	/**
	 *����   ��������幹�캯��
	 */
	public FrmRightBottMain() {
		super (new BorderLayout());
		//�������
		init();	
	}
	
	public void init() {
		tblConsum.getTableHeader().setReorderingAllowed(false);
		sp = new JScrollPane(this.tblConsum, 
		        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tblConsum.setRowHeight (18);			//�����и߶�
		tblConsum.setEnabled(false);
		tblConsum.setMinimumSize(new Dimension(600, 90));
		sp.setBorder(new LineBorder(new Color(199, 183, 143)));
		//�����������
		this.add("Center", sp);
	}
}
