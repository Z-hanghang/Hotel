package view.mainfrm.common;

import java.awt.Component;

import javax.swing.JOptionPane;

import model.mainbackfrm.register.mdlRegister;
import view.mainfrm.mainjiemian.FrmHotelMain;
import vo.mainback.Register;

/**
 * �˳�ϵͳ�Ĺ�����
 * 
 * @author �Ⱒ��
 *
 */
public class QuitSystem {
	public void quit(Component c) {
		int flag = 0;
		String msg = "�� �� �� Ҫ �� �� ϵ ͳ �� ��";
		flag = JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_NO_OPTION);
		if (flag == JOptionPane.YES_OPTION) {
			c.setVisible(false);
			mdlRegister mdlRegister = new mdlRegister(); // ��¼����״̬��ҵ���߼�
			Register vo = new Register(); // ��¼��
			vo.setEmployeeId(FrmHotelMain.lbC.getText().substring(0, 6)); // ���������ȡ��ǰ��¼Ա����id lbcΪ��ǰ����Ա��¼��Ϣ
			FrmHotelMain fm = new FrmHotelMain();
			fm.getSystemTray().remove(fm.getTrayIcon());

			mdlRegister.updateOutLine(vo); // ����½״̬���� Ϊ0
			System.exit(0);
		}
		return;
	}

}
