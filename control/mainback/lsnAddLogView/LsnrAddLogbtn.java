package control.mainback.lsnAddLogView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.mainbackfrm.register.mdlRegister;
import view.backmain.BackMainView.addLogView.AddLogView;
import vo.mainback.Register;

/**
 * 添加登录权限视图取消，修改，确定按钮监听事件
 * 
 * @author 张航
 * @date 2018.10.23
 */
public class LsnrAddLogbtn implements ActionListener {

	private AddLogView aw;

	public LsnrAddLogbtn(AddLogView aw) {
		this.aw = aw;
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		mdlRegister mdlRe = new mdlRegister();
		Register re = new Register();
		String m = "[1-9][0-9]{5}";
		JTextField txtpwd=aw.getTxtLogPwd();
		re.setEmployeeId(aw.getTxtLogId().getText());
		re.setEmployeeName(aw.getTxtEmployeeName().getText());
		re.setRegisterPassword(aw.getTxtLogPwd().getText());
		re.setEmployeeState(aw.getTxtLogState().getText());
		
		if (s.equals("确  定")) {
			if (txtpwd.getText().matches(m)) {
				mdlRe.updatelogPassWord(re);
				this.aw.dispose();
				JOptionPane.showMessageDialog(this.aw, "添加成功！","温情提示",1);
			} else {
				JOptionPane.showMessageDialog(this.aw, "你输入的密码不符合（不以0开头的6位数字）！","温情提示",2);
				txtpwd.setText("");
				txtpwd.requestFocus();
				return;
				
			}
		} else if (s.equals("取  消")) {
			this.aw.dispose();
		} else {
			if (!txtpwd.getText().matches(m)) {
				JOptionPane.showMessageDialog(this.aw, "你输入的密码不符合（不以0开头的6位数字）！","温情提示",2);
				txtpwd.setText("");
				txtpwd.requestFocus();
				return;
			} else {
				int option = JOptionPane.showConfirmDialog(this.aw, "更改后密码将会发生改变，确认提交吗？", "温情提示",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					mdlRe.updatelogPassWord(re);
					this.aw.dispose();
					JOptionPane.showMessageDialog(this.aw, "更改成功！","温情提示",1);
				}
			}

		}
	}
}
