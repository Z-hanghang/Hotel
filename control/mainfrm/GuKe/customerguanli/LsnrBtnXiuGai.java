package control.mainfrm.GuKe.customerguanli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import dao.mainfrm.GuKe.GuKeDao;
import view.mainfrm.GuKeView.customer.DlgCustomer;
import view.mainfrm.GuKeView.guanli.FrmMain;
import view.mainfrm.GuKeView.vip.DlgVip;



/*
 * �޸Ĺ���
 */
public class LsnrBtnXiuGai implements ActionListener {

	private FrmMain frmMain;
	
	public LsnrBtnXiuGai(FrmMain frmMain){
		this.frmMain=frmMain;
	}
	public void actionPerformed(ActionEvent e) {
		JTable tblCustomer = this.frmMain.getTblcustomer();
	    int row = tblCustomer.getSelectedRow();
	    Object o=e.getSource();
	    if(o.equals(frmMain.getBtncustomerXiuGai())){
	    if(row == -1) {
	      JOptionPane.showMessageDialog(this.frmMain, "��ѡ��һ�����ݣ�");
	      return;
	    }
	    
	    DlgCustomer  dlgCustomer = new DlgCustomer (this.frmMain, "�ͻ�����", true, "�޸�");
	    
	    dlgCustomer.getTxtcustomerid().setText((String)tblCustomer.getValueAt(row, 0));
	    dlgCustomer.getTxtcustomername().setText((String)tblCustomer.getValueAt(row, 1));
	    dlgCustomer.getBoxcustomersex().setToolTipText((String)tblCustomer.getValueAt(row, 2));
	    dlgCustomer.getTxtcustomertel().setText((String)tblCustomer.getValueAt(row, 3));
	    dlgCustomer.getTxtcustomercid().setText((String)tblCustomer.getValueAt(row, 4));
	    dlgCustomer.getBoxmemberid().setToolTipText((String)tblCustomer.getValueAt(row, 5));
	    
	    dlgCustomer.setVisible(true);
	    }
	    else if(o.equals(frmMain.getBtnaddVip())){
	    	if(row == -1) {
			      JOptionPane.showMessageDialog(this.frmMain, "��ѡ��һ�����ݣ�");
			      return;
			    }else{
			      String s=new GuKeDao().findCustomerById((String)tblCustomer.getValueAt(row, 0));
			    	if(s!=null&&!s.equals("")){
			    		
			    		 JOptionPane.showMessageDialog(this.frmMain, "�ù˿����л�Ա");
			    	}else{
			    		DlgVip dv=new DlgVip(this.frmMain, "�ͻ�����", true, "1");
			    		dv.getTxtcustomerid().setText((String)tblCustomer.getValueAt(row, 0));
			    		dv.getTxtmemberid().setText((String)tblCustomer.getValueAt(row, 5));
			    		dv.setVisible(true);
			    	}
			    	
			    	
			    }
	    	
	    }
	}

}
