package control.mainfrm.GuKe.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.mainfrm.GuKeView.customer.DlgCustomer;

/*
 * 取消功能
 */

public class LsnrBtnQuXiao implements ActionListener{
	 private DlgCustomer dlgCustomer;
	  
	  public LsnrBtnQuXiao(DlgCustomer dlgCustomer) {
	    this.dlgCustomer = dlgCustomer;
	  }
	  
	  public void actionPerformed(ActionEvent e) {
	    this.dlgCustomer.dispose();
	  }
}
