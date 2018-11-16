package control.mainfrm.GuKe.customerguanli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.mainfrm.customer.MDLCustomer;
import view.mainfrm.GuKeView.guanli.FrmMain;
import vo.mainfrm.GuKe.Customervo;


/*
 * ɾ������
 */
public class LsnrBtnShanChu implements ActionListener {
	private MDLCustomer mdlCustomerGuanLi = new MDLCustomer();

	private FrmMain frmMain;

	public LsnrBtnShanChu(FrmMain frmMain) {
		this.frmMain = frmMain;
	}

	public void actionPerformed(ActionEvent e) {
		JTable tblCustomer = frmMain.getTblcustomer();

		int row = tblCustomer.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(frmMain, "��ѡ��һ�����ݣ�");
		} else {
			int option = JOptionPane.showConfirmDialog(frmMain, "ȷ��ɾ��������", "��ʾ", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE);

			if (option == JOptionPane.OK_OPTION) {
				Customervo voDelete = new Customervo();
				voDelete.setCustomerid((String) tblCustomer.getValueAt(row, 0));
				mdlCustomerGuanLi.shanChuCustomer(voDelete);

				// ˢ�¿ͻ���ϢJTable
				Customervo vo = new Customervo();
				// vo.setBanJiMing(this.frmMain.getTxtBanJiMing().getText());

				Vector resultVector = mdlCustomerGuanLi.chaZhaoCustomerByName(vo);

				Object[] CustomerColumnNames = this.frmMain.getCustomerColumnNames();

				Vector columnNamesV = new Vector();
				for (int i = 0; i < CustomerColumnNames.length; i++) {
					columnNamesV.add(CustomerColumnNames[i]);
				}

				frmMain.getTblcustomer().setModel(new DefaultTableModel(resultVector, columnNamesV));

			}
		}
	}

}
