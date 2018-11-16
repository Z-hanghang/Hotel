package control.mainfrm.GuKe.vip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import common.component.tools.HotelTools;
import model.mainfrm.customer.MDLCustomer;
import view.mainfrm.GuKeView.guanli.FrmMain;
import view.mainfrm.GuKeView.vip.DlgVip;
import vo.mainfrm.GuKe.Vipvo;

/**
 * 
 * 新增会员信息监听器
 *
 */
public class LsnrQueDing implements ActionListener {

	private DlgVip dlgVip;
	

	private MDLCustomer mdlVip = new MDLCustomer();

	//private MDLVipGuanLi mdlVipGuanLi = new MDLVipGuanLi();

	public LsnrQueDing(DlgVip dlgVip) {
		this.dlgVip = dlgVip;
	}

	public void actionPerformed(ActionEvent e) {
		Vipvo vo = new Vipvo();

		vo.setVipid(this.dlgVip.getTxtvipid().getText());
		vo.setCustomerid(this.dlgVip.getTxtcustomerid().getText());
		String[] members=this.dlgVip.getMembers();
		for(String a:members){
			if(dlgVip.getBoxmemberid().getSelectedItem().equals(a)){
				vo.setMemberid(a);
			}
		}
		String command = this.dlgVip.getCommand();
      
		if (command.equals("1")) {
			 String V=dlgVip.getVIP();
			 HotelTools.savNumber(V, HotelTools.VIP);
			 mdlVip.xinZengVip(vo);
			 this.dlgVip.dispose();
		}else {
			 mdlVip.gengXinVip(vo);
			 this.dlgVip.dispose();
		}
		
		// 刷新会员JTable

		 FrmMain frmMain = ((FrmMain)this.dlgVip.getOwner());
		 Vector resultVector = this.mdlVip.chaZhaoQuanVip();
				Object[] VipColumnNames =frmMain.getVipColumnNames();

				Vector columnNamesV = new Vector();
				for (int i = 0; i < VipColumnNames .length; i++) {
					columnNamesV.add(VipColumnNames [i]);
				}

				frmMain.getTblVip().setModel(new DefaultTableModel(resultVector, columnNamesV));

			}


}
