package control.mainfrm.mainjiemian.mainbtnlsnr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import common.component.tools.HotelTools;
import control.mainfrm.mainjiemian.roommenu.LsnrRoomMenuFrm;
import view.logmain.JuiFrontLogin;
import view.mainfrm.GuKeView.guanli.FrmMain;
import view.mainfrm.YuDing.FrmReserveMain;
import view.mainfrm.aboutus.FrmAboutUs;
import view.mainfrm.account.FrmAccount;
import view.mainfrm.balanceview.FRMbalance;
import view.mainfrm.checkinview.Frmcheckin;
import view.mainfrm.common.QuitSystem;
import view.mainfrm.consume.FrmConsume;
import view.mainfrm.mainjiemian.FrmHotelMain;
import view.mainfrm.mainjiemian.FrmRightTopMain;
import view.mainfrm.reside.FrmRuZhuRoom;

/**
 * 制作一个供主界面中button按钮使用的监听器
 * 
 * @author 吴阿龙
 *
 */
public class LsnrFrmMainBtn implements ActionListener {

	private FrmRightTopMain frmRightTop;
	private FrmHotelMain frmHotelMain;

	private String roomID; // 用来存放房间id

	/**
	 * 构造函数进行初始化
	 */
	public LsnrFrmMainBtn(FrmHotelMain frmHotelMain) {
		this.frmHotelMain = frmHotelMain;
	}

	/**
	 * 主界面中button按钮的监听事件
	 */
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (frmHotelMain.getYudingguanlibt().equals(o)) {    // 预定管理
			new FrmReserveMain(null).setVisible(true);
			return;
		} else if (frmHotelMain.getRuzhudengjibt().equals(o)) { // 入住登记

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
		} else if (frmHotelMain.getRuzhuchaxunbt().equals(o)) { // 入住查询
			new Frmcheckin("入住查询").setVisible(true);
			return;
		} else if (frmHotelMain.getTuifangjiezhangbt().equals(o)) { // 退房结算
			FrmAccount frmAccount =new FrmAccount(null, "退房结算", true);
			String jiesuanId = HotelTools.getNumber(HotelTools.AC);
			frmAccount.getTxtJieZhangDanHao().setText(jiesuanId);
			frmAccount.setVisible(true);
			return;
		} else if (frmHotelMain.getKehuguanlibt().equals(o)) { // 客户管理
			new FrmMain("客户管理").setVisible(true);
			return;
		} else if (frmHotelMain.getZengjiaxiaofeibt().equals(o)) { // 增加消费
			new FrmConsume(null, "商品消费", true, "消费").setVisible(true);
			return;
		} else if (frmHotelMain.getJiesuanselectbt().equals(o)) { // 结算查询
			new FRMbalance("消费查询").setVisible(true);
			return;
		} else if (frmHotelMain.getAboutus().equals(o)) { // 关于我们
			new FrmAboutUs(frmHotelMain).setVisible(true);
			return;
		} else if (frmHotelMain.getHuanbanbt().equals(o)) { // 换班
			String msg = "是否切换登录员工";
			int isAdd = JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
			if (isAdd == JOptionPane.YES_OPTION) {
			   JuiFrontLogin frontLogin=new JuiFrontLogin();
	           frontLogin.setVisible(true);
	           frmHotelMain.dispose();
			}
			return;
		} else if (frmHotelMain.getQuitsystem().equals(o)) { // 退出系统
			QuitSystem q = new QuitSystem();
			q.quit(frmHotelMain);
			return;
		}
	}
}
