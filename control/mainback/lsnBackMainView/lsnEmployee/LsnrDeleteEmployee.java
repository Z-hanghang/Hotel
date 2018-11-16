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
 * 删除员工信息和查询全部员工信息按钮监听器和两互斥框监听器 @author： 张航 @date：2018.10.19
 */
public class LsnrDeleteEmployee implements ActionListener {
	// 引入model层的员工管理
	private employeeManage me = new employeeManage();
	// 引入model层的登录权限管理
	private mdlRegister md = new mdlRegister();
	private BackMainView bw;

	public LsnrDeleteEmployee(BackMainView bw) {
		this.bw = bw;
	}

	public void actionPerformed(ActionEvent e) {
		// 获取view中员工表
		Object o = e.getSource();

		if (o.equals(bw.getBtnDeleteEmployee())) {
			// 删除表监听器
			JTable TblEmployee = bw.getTblEmployee();
			int row = TblEmployee.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this.bw, "    请选中一行数据！","温情提示",1);
			} else {
				int option = JOptionPane.showConfirmDialog(this.bw, "确定删除数据吗？", "温情提示", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					Employee em = new Employee();
					Register re = new Register();
					em.setEmployeeId((String) TblEmployee.getValueAt(row, 0));
					re.setEmployeeId(em.getEmployeeId());
					// 删除员工
					me.delectEmployee(em);
					// 删除登录表数据
					md.deleteLogByFK(re);
					// 弹窗删除成功提示
					JOptionPane.showMessageDialog(this.bw, "删除成功！","温情提示",1);
					// 刷新员工表
					flushEmployeeTable(me.findAlleEmployee());
					// 刷新登录表
					flushLogTable(new mdlRegister().findAllEmployee());
				}

			}

		} else if (bw.getCkbEmployeeName().isSelected()) {
			// 复选框
			bw.getTxtEmployeeId().setText("");
			bw.getTxtEmployeeName().requestFocus();
		} else if (bw.getCkbEmployeeId().isSelected()) {
			bw.getTxtEmployeeName().setText("");
			//bw.getTxtEmployeeName().requestFocus();
			bw.getTxtEmployeeId().requestFocus();
		} 

	}

	// 刷新员工表
	private void flushEmployeeTable(Vector resultVector) {
		Object[] EmployeeColumnNames = bw.getEmployeeColumnNames();
		Vector columnNamesV = new Vector();
		for (Object temp : EmployeeColumnNames) {
			columnNamesV.add(temp);
		}
		bw.getTblEmployee().setModel(new DefaultTableModel(resultVector, columnNamesV));

	}

	// 刷新登录表
	private void flushLogTable(Vector resultVector) {
		Object[] LogColumnNames = bw.getLogColumnNames();
		Vector columnNamesV = new Vector();
		for (Object temp : LogColumnNames) {
			columnNamesV.add(temp);
		}
		bw.getTblLog().setModel(new DefaultTableModel(resultVector, columnNamesV));

	}

}
