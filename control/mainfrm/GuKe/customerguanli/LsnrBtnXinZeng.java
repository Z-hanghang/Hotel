package control.mainfrm.GuKe.customerguanli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.mainfrm.GuKeView.customer.DlgCustomer;
import view.mainfrm.GuKeView.guanli.FrmMain;



/*
 * 顾客信息新增功能
 */

public class LsnrBtnXinZeng implements ActionListener {

	private FrmMain frmMain;
	public LsnrBtnXinZeng(FrmMain frmMain){
		this.frmMain=frmMain;
	}
	public void actionPerformed(ActionEvent arg0) {
		 new DlgCustomer(this.frmMain, "客户信息", true, "1").setVisible(true);
	}

}
