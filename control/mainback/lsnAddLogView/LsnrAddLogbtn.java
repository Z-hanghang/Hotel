package control.mainback.lsnAddLogView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.mainbackfrm.register.mdlRegister;
import view.backmain.BackMainView.addLogView.AddLogView;
import vo.mainback.Register;

/**
 * ��ӵ�¼Ȩ����ͼȡ�����޸ģ�ȷ����ť�����¼�
 * 
 * @author �ź�
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
		
		if (s.equals("ȷ  ��")) {
			if (txtpwd.getText().matches(m)) {
				mdlRe.updatelogPassWord(re);
				this.aw.dispose();
				JOptionPane.showMessageDialog(this.aw, "��ӳɹ���","������ʾ",1);
			} else {
				JOptionPane.showMessageDialog(this.aw, "����������벻���ϣ�����0��ͷ��6λ���֣���","������ʾ",2);
				txtpwd.setText("");
				txtpwd.requestFocus();
				return;
				
			}
		} else if (s.equals("ȡ  ��")) {
			this.aw.dispose();
		} else {
			if (!txtpwd.getText().matches(m)) {
				JOptionPane.showMessageDialog(this.aw, "����������벻���ϣ�����0��ͷ��6λ���֣���","������ʾ",2);
				txtpwd.setText("");
				txtpwd.requestFocus();
				return;
			} else {
				int option = JOptionPane.showConfirmDialog(this.aw, "���ĺ����뽫�ᷢ���ı䣬ȷ���ύ��", "������ʾ",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					mdlRe.updatelogPassWord(re);
					this.aw.dispose();
					JOptionPane.showMessageDialog(this.aw, "���ĳɹ���","������ʾ",1);
				}
			}

		}
	}
}
