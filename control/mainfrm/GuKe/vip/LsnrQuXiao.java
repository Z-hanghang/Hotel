package control.mainfrm.GuKe.vip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.mainfrm.GuKeView.vip.DlgVip;


/**
 * 
 * ��Աȡ��������
 *
 */
public class LsnrQuXiao implements ActionListener {

	  private DlgVip dlgVip ;
	  
	  public LsnrQuXiao(DlgVip dlgVip) {
	    this.dlgVip  = dlgVip ;
	  }
	  
	  public void actionPerformed(ActionEvent e) {
	    this.dlgVip .dispose();
	  }

}
