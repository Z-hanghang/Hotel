package control.mainfrm.mainjiemian.mainbtnlsnr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.JOptionPane;

import common.component.tools.HotelTools;
import control.mainfrm.mainjiemian.roommenu.LsnrRightMenu;
import jdk.nashorn.internal.scripts.JO;
import model.mainbackfrm.register.mdlRegister;
import model.mainfrm.changeroomfrm.MDLChangeRoom;
import model.mainfrm.mainjiemian.rightbottfrm.MDLFrmRightBott;
import model.mainfrm.residefrm.MDLReside;
import view.logmain.JuiFrontLogin;
import view.mainfrm.YuDing.FrmReserveMain;
import view.mainfrm.aboutus.FrmAboutUs;
import view.mainfrm.account.FrmAccount;
import view.mainfrm.balanceview.FRMbalance;
import view.mainfrm.changeroom.FrmChangRoom;
import view.mainfrm.checkinview.Frmcheckin;
import view.mainfrm.common.QuitSystem;
import view.mainfrm.helpView.Help;
import view.mainfrm.mainjiemian.FrmHotelMain;
import view.mainfrm.mainjiemian.FrmRightTopMain;
import view.mainfrm.mainjiemian.FrmXuFang;
import view.mainfrm.reside.FrmRuZhuRoom;
import vo.mainback.Register;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomTypeVO;
import vo.mainfrm.RoomVO;

/**
 * 主界面中最顶部菜单栏的监听器
 * 
 * @author Administrator
 *
 */
public class LsnrFrmMainMenu implements ActionListener {

	private FrmHotelMain frmHotelMain;

	public LsnrFrmMainMenu(FrmHotelMain frmHotelMain) {
		this.frmHotelMain = frmHotelMain;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (frmHotelMain.getMi11().equals(o)) { // 登记入住
			FrmRuZhuRoom frmRuZhuRoom = new FrmRuZhuRoom(null, "入住登记", true, "入住");
			String ResideId = HotelTools.getNumber(HotelTools.D);
			frmRuZhuRoom.getTxtrzbh().setText(ResideId);
			frmRuZhuRoom.getComfjlx().removeAllItems();
			Set<Map.Entry<String, String>> entrySet = FrmRightTopMain.fjlx.entrySet();
			Iterator<Map.Entry<String, String>> it = entrySet.iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> me = it.next();
				String key = me.getKey();
				frmRuZhuRoom.getComfjlx().addItem(key);
			}
			frmRuZhuRoom.getTxtbklx().setText("普通");
			frmRuZhuRoom.getTxtbklx().setEnabled(false);
			frmRuZhuRoom.setVisible(true);
			return;
		} else if (frmHotelMain.getMi12().equals(o)) { // 入住信息查询
			new Frmcheckin("入住查询").setVisible(true);
			return;
		} else if (frmHotelMain.getMi13().equals(o)) { // 更换房间
			if (LsnrRightMenu.RId == null) {
				JOptionPane.showMessageDialog(frmHotelMain, "请点击房间再选定该对象");
			} else {

				FrmChangRoom frmChangRoom = new FrmChangRoom(frmHotelMain); // 更改房间的窗口

				frmChangRoom.beforeRoom.setText(LsnrRightMenu.RId); // 更换房间窗口的原房间信息
				RoomTypeVO vo = new RoomTypeVO();
				MDLChangeRoom mdlChangeRoom = new MDLChangeRoom(); // 更改房间信息的业务逻辑
				MDLFrmRightBott mdlFrmRightBott = new MDLFrmRightBott(); // 房间消费信息和房间状态查找业务逻辑

				vo.setRoomTypeName(FrmRightTopMain.tb_Name); // 设置房间类型

				Vector v = mdlChangeRoom.findAllSameRoom(vo);
				for (Iterator it = v.iterator(); it.hasNext();) {
					String[] s = new String[2];
					s = (String[]) it.next();
					frmChangRoom.getSomeRoom().addItem(s[0]);
					frmChangRoom.getTf2().setText(s[1]);
				}
				frmChangRoom.setVisible(true);

				return;
			}
			return;
		} else if (frmHotelMain.getMi14().equals(o)) { // 修改登记
			if (LsnrRightMenu.RId == null) {
				JOptionPane.showMessageDialog(frmHotelMain, "请点击房间再选定该对象");
			} else {
				FrmXuFang xuFang = new FrmXuFang(null, "续房", true);
				ResideVO vo = new ResideVO();
				vo.setRoomID(LsnrRightMenu.RId);
				MDLReside mdlReside = new MDLReside();
				String s = mdlReside.findTuiRoomTime(vo);
				FrmXuFang.ytime.setText("原退房时间为" + s);
				xuFang.setVisible(true);
			}
			return;
		} else if (frmHotelMain.getMi15().equals(o)) { // 房间状态
			return;
		} else if (frmHotelMain.getMi16().equals(o)) { // 预订管理
			new FrmReserveMain(null).setVisible(true);
			return;
		} else if (frmHotelMain.getMi17().equals(o)) { // 退出系统
			QuitSystem q = new QuitSystem();
			q.quit(frmHotelMain);
			return;
		} else if (frmHotelMain.getMi21().equals(o)) { // 宾客结帐
			FrmAccount frmAccount = new FrmAccount(null, "退房结算", true);
			String jiesuanId = HotelTools.getNumber(HotelTools.AC);
			frmAccount.getTxtJieZhangDanHao().setText(jiesuanId);
			frmAccount.setVisible(true);
			return;
		} else if (frmHotelMain.getMi22().equals(o)) { // 结算查询
			new FRMbalance("消费查询").setVisible(true);
			return;
		} else if (frmHotelMain.getMi23().equals(o)) { // 宾客房间消费明细查询
			return;
		} else if (frmHotelMain.getMi31().equals(o)) { // 换班
			String msg = "是否切换登录员工";
			int isAdd = JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (isAdd == JOptionPane.YES_OPTION) {
				JuiFrontLogin frontLogin = new JuiFrontLogin();
				frontLogin.setVisible(true);
				frmHotelMain.dispose();
			}
			return;
		} else if (frmHotelMain.getMi32().equals(o)) { // 关于我们
			new FrmAboutUs(frmHotelMain).setVisible(true);
			return;
		} else if (frmHotelMain.getMi1().equals(o)) { // 托盘菜单关于我们
			new FrmAboutUs(null).setVisible(true);
			return;
		} else if (frmHotelMain.getMi2().equals(o)) { // 托盘菜单退出
			mdlRegister mdlRegister = new mdlRegister(); // 登录更改状态的业务逻辑
			Register vo = new Register(); // 登录表
			vo.setEmployeeId(FrmHotelMain.lbC.getText().substring(0, 6)); // 从主界面截取当前登录员工的id lbc为当前操作员登录信息

			mdlRegister.updateOutLine(vo); // 将登陆状态更改 为0
			frmHotelMain.dispose();
			System.exit(1);
			frmHotelMain.getSystemTray().remove(frmHotelMain.getTrayIcon());
		}else if(frmHotelMain.getMi33().equals(o)){
                //系统帮助
                 new Help().setVisible(true);
                
                }

	}

}
