package control.mainfrm.GuKe.vipguanli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import view.mainfrm.GuKeView.guanli.FrmMain;
import view.mainfrm.GuKeView.vip.DlgVip;


/*
 * �޸Ļ�Ա��Ϣ
 */

public class LsnrVipXiuGai implements ActionListener {

	private FrmMain frmMain;

	public LsnrVipXiuGai(FrmMain frmMain) {
		this.frmMain = frmMain;
	}

	public void actionPerformed(ActionEvent e) {
		JTable tblVip = this.frmMain.getTblVip();
		int row = tblVip.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(this.frmMain, "��ѡ��һ�����ݣ�");
			return;
		}
		DlgVip dlgVip = new DlgVip(this.frmMain, "��Ա��Ϣ", true, "�޸�");

		dlgVip.getTxtvipid().setText((String) tblVip.getValueAt(row, 0));
		dlgVip.getTxtcustomerid().setText((String) tblVip.getValueAt(row, 1));
		dlgVip.getTxtmemberid().setText((String) tblVip.getValueAt(row, 2));

		dlgVip.setVisible(true);
	}

}
