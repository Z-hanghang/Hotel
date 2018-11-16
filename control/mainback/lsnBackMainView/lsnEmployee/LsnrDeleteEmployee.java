package control.mainback.lsnBackMainView.lsnEmployee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.mainbackfrm.Employee.employeeManage;
import model.mainbackfrm.register.mdlRegister;

import view.backmain.BackMainView.BackMainView;
import vo.mainback.Employee;
import vo.mainback.Register;

/**
 * ɾ��Ա����Ϣ�Ͳ�ѯȫ��Ա����Ϣ��ť�������������������� @author�� �ź� @date��2018.10.19
 */
public class LsnrDeleteEmployee implements ActionListener {
	// ����model���Ա������
	private employeeManage me = new employeeManage();
	// ����model��ĵ�¼Ȩ�޹���
	private mdlRegister md = new mdlRegister();
	private BackMainView bw;

	public LsnrDeleteEmployee(BackMainView bw) {
		this.bw = bw;
	}

	public void actionPerformed(ActionEvent e) {
		// ��ȡview��Ա����
		Object o = e.getSource();

		if (o.equals(bw.getBtnDeleteEmployee())) {
			// ɾ���������
			JTable TblEmployee = bw.getTblEmployee();
			int row = TblEmployee.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this.bw, "    ��ѡ��һ�����ݣ�","������ʾ",1);
			} else {
				int option = JOptionPane.showConfirmDialog(this.bw, "ȷ��ɾ��������", "������ʾ", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					Employee em = new Employee();
					Register re = new Register();
					em.setEmployeeId((String) TblEmployee.getValueAt(row, 0));
					re.setEmployeeId(em.getEmployeeId());
					// ɾ��Ա��
					me.delectEmployee(em);
					// ɾ����¼������
					md.deleteLogByFK(re);
					// ����ɾ���ɹ���ʾ
					JOptionPane.showMessageDialog(this.bw, "ɾ���ɹ���","������ʾ",1);
					// ˢ��Ա����
					flushEmployeeTable(me.findAlleEmployee());
					// ˢ�µ�¼��
					flushLogTable(new mdlRegister().findAllEmployee());
				}

			}

		} else if (bw.getCkbEmployeeName().isSelected()) {
			// ��ѡ��
			bw.getTxtEmployeeId().setText("");
			bw.getTxtEmployeeName().requestFocus();
		} else if (bw.getCkbEmployeeId().isSelected()) {
			bw.getTxtEmployeeName().setText("");
			//bw.getTxtEmployeeName().requestFocus();
			bw.getTxtEmployeeId().requestFocus();
		} 

	}

	// ˢ��Ա����
	private void flushEmployeeTable(Vector resultVector) {
		Object[] EmployeeColumnNames = bw.getEmployeeColumnNames();
		Vector columnNamesV = new Vector();
		for (Object temp : EmployeeColumnNames) {
			columnNamesV.add(temp);
		}
		bw.getTblEmployee().setModel(new DefaultTableModel(resultVector, columnNamesV));

	}

	// ˢ�µ�¼��
	private void flushLogTable(Vector resultVector) {
		Object[] LogColumnNames = bw.getLogColumnNames();
		Vector columnNamesV = new Vector();
		for (Object temp : LogColumnNames) {
			columnNamesV.add(temp);
		}
		bw.getTblLog().setModel(new DefaultTableModel(resultVector, columnNamesV));

	}

}
