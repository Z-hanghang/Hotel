package control.mainback.lsnAddEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import common.component.tools.HotelTools;
import model.mainbackfrm.Employee.employeeManage;
import model.mainbackfrm.register.mdlRegister;
import view.backmain.BackMainView.BackMainView;
import view.backmain.BackMainView.AddEmployeeView.AddEmployeeView;
import vo.mainback.Employee;
import vo.mainback.Register;

/**
 * 添加员工信息界面的确定和取消按钮的监听器
 */
public class LsnrBtn implements ActionListener {
	private BackMainView bw=new BackMainView();
	private AddEmployeeView aw;

	public LsnrBtn(AddEmployeeView aw) {
		this.aw = aw;
	}

	public void actionPerformed(ActionEvent e) {
		Register re = new Register();
		Employee em = new Employee();
		employeeManage eManage=	new employeeManage();
		String s = e.getActionCommand();
		String tel = "[1][3-8][0-9]{9}";
		String eid = "[4][0-9]{16}[0-9X]";
		JTextField EmployeeTel = aw.getTxtEmployeeTel();
		JTextField EmployeeEid = aw.getTxtEmployeeEid();
		if (s.equals("确  定")) {
			if (!EmployeeTel.getText().matches(tel)) {
				JOptionPane.showMessageDialog(this.aw, "你输入的手机号码格式错误!","温情提示",2);
				
				//清空操作 EmployeeTel.setText("");
				EmployeeTel.requestFocus();
				return;
			} else if (!EmployeeEid.getText().matches(eid)) {
				JOptionPane.showMessageDialog(this.aw, "你输入的身份证号格式错误!","温情提示",2);
				//清空操作 EmployeeEid.setText("");
				EmployeeEid.requestFocus();
				return;
			} else {
				
				//更新编号
				String num=aw.getStrEmployeeID();
				HotelTools.savNumber(num, HotelTools.EM);

				em.setEmployeeId(aw.getTxtEmployeeId().getText());
				em.setEmployeeName(aw.getTxtEmployeeName().getText());
				em.setEmployeeSex(aw.getTxtEmployeeSex().getText());
				em.setEmployeeTel(EmployeeTel.getText());
				em.setEmployeeEid(EmployeeEid.getText());
				//根据获得的员工类型名 设置员工类型编号。
				if(aw.getTxtEmptyeId().getText().equals("普通员工")){
					em.setEmtypeId("EMT01");
				}else if(aw.getTxtEmptyeId().getText().equals("经理")) {
					em.setEmtypeId("EMT02");
				}
				

				re.setEmployeeId(aw.getTxtEmployeeId().getText());
				try {
					em.setEmployeeBrithday(new SimpleDateFormat("yyyy-mm-dd").parse(aw.getTxtEbirthday().getText()));
					// 添加到数据库中
					eManage.addEmployee(em);
					// 同时添加到登录表中
					new mdlRegister().insertRegister(re);
					// 当前窗体销毁
					this.aw.dispose();
					// 弹窗提示
					JOptionPane.showMessageDialog(this.aw, "添加成功","温情提示",1);
					//刷新员工表格
					flushEmployeeTable(eManage.findAlleEmployee());
                    //刷新登录表格
					//flushLogTable(new mdlRegister().findAllEmployee());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		} else if (s.equals("取  消")) {
			// 取消按钮
			this.aw.dispose();
		} else {
			// 修改按钮
			if (!EmployeeTel.getText().matches(tel)) {
				JOptionPane.showMessageDialog(this.aw, "你输入的手机号码格式错误!","温情提示",2);
				//EmployeeTel.setText("");
				EmployeeTel.requestFocus();
				return;
			} else if (!EmployeeEid.getText().matches(eid)) {
				JOptionPane.showMessageDialog(this.aw, "你输入的身份证号格式错误!","温情提示",2);
				//EmployeeEid.setText("");
				EmployeeEid.requestFocus();
				return;
			} else {

				em.setEmployeeId(aw.getTxtEmployeeId().getText());
				em.setEmployeeName(aw.getTxtEmployeeName().getText());
				em.setEmployeeSex(aw.getTxtEmployeeSex().getText());
				em.setEmployeeTel(EmployeeTel.getText());
				em.setEmployeeEid(EmployeeEid.getText());
				//根据获得的员工类型名 设置员工类型编号。
				if(aw.getTxtEmptyeId().getText().equals("普通员工")){
					em.setEmtypeId("EMT01");
				}else if(aw.getTxtEmptyeId().getText().equals("经理")) {
					em.setEmtypeId("EMT02");
				}
				try {
					em.setEmployeeBrithday(new SimpleDateFormat("yyyy-mm-dd").parse(aw.getTxtEbirthday().getText()));
					int option = JOptionPane.showConfirmDialog(this.bw, "更改后信息将会发生改变，确认提交吗？", "提示",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {
						// 到数据库中修改
						eManage.updateEmployee(em);
						// 当前窗体销毁
						this.aw.dispose();
						// 弹窗提示
						JOptionPane.showMessageDialog(this.aw, "修改成功","温情提示",1);
						//刷新员工表
						flushEmployeeTable(eManage.findAlleEmployee());

					}

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	//刷新员工表
	 private void flushEmployeeTable(Vector resultVector) {
			Object[] EmployeeColumnNames = bw.getEmployeeColumnNames();
			Vector columnNamesV = new Vector();
			for (Object temp : EmployeeColumnNames) {
				columnNamesV.add(temp);
			}
			bw.getTblEmployee().setModel(new DefaultTableModel(resultVector, columnNamesV));

		}	
	 //刷新登录表
	    private void flushLogTable(Vector resultVector) {
	    	Object[] LogColumnNames = bw.getLogColumnNames();
	    	Vector columnNamesV = new Vector();
	    	for (Object temp : LogColumnNames) {
	    		columnNamesV.add(temp);
	    	}
	    	bw.getTblLog().setModel(new DefaultTableModel(resultVector, columnNamesV));
	    	
	    }	

}
