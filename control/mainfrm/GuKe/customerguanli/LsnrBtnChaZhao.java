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
 * 1.通过手机号模糊查找顾客信息
 * 2.通过名称模糊查找
 * 3.通过名称和编号查找
 * 4.手机号进行正则匹配
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
			  resultVector = mdlCustomerGuanLi.chaZhaoCustomerByTel(vo);//通过手机号查找
			  flag=true;
		  }else if(this.frmMain.getRbCustomerName().isSelected()){
	         resultVector = mdlCustomerGuanLi.chaZhaoCustomerByName(vo);//通过名称查找
	         flag=true;
		  }else{
			  resultVector = mdlCustomerGuanLi.chaZhaoQuanCustomer();  //查找全部顾客信息
		  }
		// 刷新客户JTable
		Object[] CustomerColumnNames = this.frmMain.getCustomerColumnNames();

		Vector columnNamesV = new Vector();
		for (int i = 0; i < CustomerColumnNames.length; i++) {
			columnNamesV.add(CustomerColumnNames[i]);
		}

		frmMain.getTblcustomer().setModel(new DefaultTableModel(resultVector, columnNamesV));
		  
	}
	
}
