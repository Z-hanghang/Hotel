package control.mainfrm.GuKe.customerguanli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.mainfrm.GuKeView.customer.DlgCustomer;
import view.mainfrm.GuKeView.guanli.FrmMain;



/*
 * �˿���Ϣ��������
 */

public class LsnrBtnXinZeng implements ActionListener {

	private FrmMain frmMain;
	public LsnrBtnXinZeng(FrmMain frmMain){
		this.frmMain=frmMain;
	}
	public void actionPerformed(ActionEvent arg0) {
		 new DlgCustomer(this.frmMain, "�ͻ���Ϣ", true, "1").setVisible(true);
	}

}
