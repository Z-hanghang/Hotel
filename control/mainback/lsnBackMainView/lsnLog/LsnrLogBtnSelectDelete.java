package control.mainback.lsnBackMainView.lsnLog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.mainbackfrm.register.mdlRegister;
import view.backmain.BackMainView.BackMainView;
import vo.mainback.Register;


/**
 * ��¼Ȩ�޲��Ұ�ť ȫ����Ϣ��ť�Լ�����Ȩ�ް�ť������
 * he����������
 * @author �ź�
 * @date 2018.10.21
 */
public class LsnrLogBtnSelectDelete implements ActionListener {

	private BackMainView bw;

	public LsnrLogBtnSelectDelete(BackMainView bw) {
		this.bw = bw;
	}

	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		// ��ȡ�������
		String s = e.getActionCommand();
		// ��ȡ��¼������
		Register re = new Register();
		// ��ȡ�߼���¼����ҵ��
		mdlRegister mdlRe = new mdlRegister();

		JRadioButton ckbLogName = bw.getCkbLogName();
		JRadioButton ckbLogId = bw.getCkbLogId();
		JTextField txtLogId = bw.getTxtLogId();
		JTextField txtLogName = bw.getTxtLogName();
		if(o.equals(bw.getBtnSelectAllLog())){
			// ȫ����Ϣ
			flushTable(mdlRe.findAllEmployee());
		}
		else if (o.equals(bw.getBtnSelectLog())) {
			if (ckbLogName.isSelected()) {
				if (txtLogName.getText().equals("")) {
					JOptionPane.showMessageDialog(bw, "���������������!","������ʾ",1);
				} else {
					re.setEmployeeName(txtLogName.getText());
					Vector resultVector = mdlRe.selectEemployeeName(re);
					flushTable(resultVector);
				}
			} else if (ckbLogId.isSelected()) {
				if (txtLogId.getText().equals("")) {
					JOptionPane.showMessageDialog(bw, "������Ա��Id�����!","������ʾ",1);
				} else {
					re.setEmployeeId(txtLogId.getText());
					Vector resultVector = mdlRe.selectEmployeeId(re);
					flushTable(resultVector);
				}
			   } 
			 else {
				JOptionPane.showMessageDialog(bw, "��ѡ�����ͺ���в���!","������ʾ",2);
			}

		} else if (o.equals(bw.getBtnDeleteLog())) {
			JTable TblLog = bw.getTblLog();
			int row = TblLog.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this.bw, "   ��ѡ��һ�����ݣ�","������ʾ",1);
			} else {
				int option = JOptionPane.showConfirmDialog(this.bw, "ȷ��������Ա��Ȩ����?ɾ�����޷����!!!", "������ʾ",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					re.setEmployeeId((String) TblLog.getValueAt(row, 0));
					mdlRe.deleteLogByFK(re);
					// ˢ�±��
					flushTable(mdlRe.findAllEmployee());
				}
			}

		} else if(ckbLogName.isSelected()){
			//���
			txtLogId.setText("");
			txtLogName.requestFocus();
			
		}else if(ckbLogId.isSelected()){
			//���
			txtLogName.setText("");
			
			txtLogId.requestFocus();
		}

	}

	// ˢ�·���
	private void flushTable(Vector resultVector) {
		Object[] LogColumnNames = bw.getLogColumnNames();
		Vector columnNamesV = new Vector();
		for (Object temp : LogColumnNames) {
			columnNamesV.add(temp);
		}
		bw.getTblLog().setModel(new DefaultTableModel(resultVector, columnNamesV));

	}
}
