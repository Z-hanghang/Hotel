package control.mainfrm.GuKe.customerguanli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.mainfrm.customer.MDLCustomer;
import view.mainfrm.GuKeView.guanli.FrmMain;
import vo.mainfrm.GuKe.Customervo;

/*
 * 1.ͨ���ֻ���ģ�����ҹ˿���Ϣ
 * 2.ͨ������ģ������
 * 3.ͨ�����ƺͱ�Ų���
 * 4.�ֻ��Ž�������ƥ��
 */

public class LsnrBtnChaZhao implements ActionListener {
	private MDLCustomer mdlCustomerGuanLi = new MDLCustomer();

	private FrmMain frmMain;

	public LsnrBtnChaZhao(FrmMain frmMain) {
		this.frmMain = frmMain;
	}

	public void actionPerformed(ActionEvent e) {
		Customervo vo = new Customervo();
	   
        vo.setCustomertel(this.frmMain.getTxtcustomertel().getText());
        vo.setCustomername(this.frmMain.getTxtcustomername().getText());
            boolean flag=false;
            Vector resultVector = new Vector();
		   
			 
		  if(this.frmMain.getRbCustomerTel().isSelected()){
			  resultVector = mdlCustomerGuanLi.chaZhaoCustomerByTel(vo);//ͨ���ֻ��Ų���
			  flag=true;
		  }else if(this.frmMain.getRbCustomerName().isSelected()){
	         resultVector = mdlCustomerGuanLi.chaZhaoCustomerByName(vo);//ͨ�����Ʋ���
	         flag=true;
		  }else{
			  resultVector = mdlCustomerGuanLi.chaZhaoQuanCustomer();  //����ȫ���˿���Ϣ
		  }
		// ˢ�¿ͻ�JTable
		Object[] CustomerColumnNames = this.frmMain.getCustomerColumnNames();

		Vector columnNamesV = new Vector();
		for (int i = 0; i < CustomerColumnNames.length; i++) {
			columnNamesV.add(CustomerColumnNames[i]);
		}

		frmMain.getTblcustomer().setModel(new DefaultTableModel(resultVector, columnNamesV));
		  
	}
	
}
