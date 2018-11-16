package control.mainback.lsnBackMainView.lsnEmployee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.mainbackfrm.Employee.employeeManage;
import view.backmain.BackMainView.BackMainView;
import vo.mainback.Employee;

/**
 * 员工信息查询部分监听器
 * 
 * @author 张航
 * @date 2018.10.15
 */
public class LsnrEmployeeSelect implements ActionListener {

	private BackMainView bw;

	public LsnrEmployeeSelect(BackMainView bw) {
		this.bw = bw;
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		JRadioButton ckbEmployeeName = bw.getCkbEmployeeName();
		JRadioButton ckbEmployeeId = bw.getCkbEmployeeId();
		JTextField txtEmployeeName = bw.getTxtEmployeeName();
		JTextField txtEmployeeId = bw.getTxtEmployeeId();
		Employee em = new Employee();
		employeeManage empl = new employeeManage();
		Object[] EmployeeColumnNames = bw.getEmployeeColumnNames();
		if (o.equals(bw.getBtnEmployeenSelectAll())) {
			ckbEmployeeName.setSelected(false);
			ckbEmployeeId.setSelected(false);
			// 查询全部员工监听器
			flushTable(empl.findAlleEmployee());
		} else if (ckbEmployeeName.isSelected()) {
			String txtName = txtEmployeeName.getText();
			if (txtName.equals("")) {
				JOptionPane.showMessageDialog(this.bw, "请输入姓名再查找", "温情提示", 1);
			} else {
				em.setEmployeeName(txtName);
				Vector resultVector = empl.selectNameEmployee(em);
				flushTable(resultVector);

			}

		} else if (ckbEmployeeId.isSelected()) {
			String txtId = txtEmployeeId.getText();
			if (txtId.equals("")) {
				JOptionPane.showMessageDialog(this.bw, "请输入ID再查找", "温情提示", 1);
			} else {
				em.setEmployeeId(txtEmployeeId.getText());
				Vector resultVector = empl.selectIdEmployee(em);
				flushTable(resultVector);
			}
		} else if (!ckbEmployeeName.isSelected() && !ckbEmployeeId.isSelected()) {
			JOptionPane.showMessageDialog(this.bw, " 请选择类型后进行查找!", "温情提示", 2);
		}

	}

	// 刷新员工信息表
	private void flushTable(Vector resultVector) {
		Object[] EmployeeColumnNames = bw.getEmployeeColumnNames();
		Vector columnNamesV = new Vector();
		for (Object temp : EmployeeColumnNames) {
			columnNamesV.add(temp);
		}
		bw.getTblEmployee().setModel(new DefaultTableModel(resultVector, columnNamesV));

	}

}
