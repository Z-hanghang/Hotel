package control.mainfrm.GuKe.vipguanli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.mainfrm.customer.MDLCustomer;
import view.mainfrm.GuKeView.guanli.FrmMain;
import vo.mainfrm.GuKe.Vipvo;



public class LsnrVipChaZhao implements ActionListener {

	/*
	 *  ���ҹ��ܣ�����Ա��Ų���
	 */

	
		private MDLCustomer mdlVipGuanLi = new MDLCustomer();

		private FrmMain frmMain;

		public LsnrVipChaZhao(FrmMain frmMain) {
			this.frmMain = frmMain;
		}

		public void actionPerformed(ActionEvent e) {
			Vipvo vo = new Vipvo();

			vo.setVipid(this.frmMain.getTxtVipId().getText());

			Vector resultVector = mdlVipGuanLi.chaZhaoVipByVipId(vo);

			// ˢ�»�ԱJTable
			Object[] VipColumnNames = this.frmMain.getVipColumnNames();

			Vector columnNamesV = new Vector();
			for (int i = 0; i < VipColumnNames .length; i++) {
				columnNamesV.add(VipColumnNames [i]);
			}

			frmMain.getTblVip().setModel(new DefaultTableModel(resultVector, columnNamesV));

		}

	

}
