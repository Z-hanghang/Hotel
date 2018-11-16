package view.mainfrm.common;

import java.awt.Component;

import javax.swing.JOptionPane;

import model.mainbackfrm.register.mdlRegister;
import view.mainfrm.mainjiemian.FrmHotelMain;
import vo.mainback.Register;

/**
 * 退出系统的公共类
 * 
 * @author 吴阿龙
 *
 */
public class QuitSystem {
	public void quit(Component c) {
		int flag = 0;
		String msg = "您 现 在 要 关 闭 系 统 吗 ？";
		flag = JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_NO_OPTION);
		if (flag == JOptionPane.YES_OPTION) {
			c.setVisible(false);
			mdlRegister mdlRegister = new mdlRegister(); // 登录更改状态的业务逻辑
			Register vo = new Register(); // 登录表
			vo.setEmployeeId(FrmHotelMain.lbC.getText().substring(0, 6)); // 从主界面截取当前登录员工的id lbc为当前操作员登录信息
			FrmHotelMain fm = new FrmHotelMain();
			fm.getSystemTray().remove(fm.getTrayIcon());

			mdlRegister.updateOutLine(vo); // 将登陆状态更改 为0
			System.exit(0);
		}
		return;
	}

}
