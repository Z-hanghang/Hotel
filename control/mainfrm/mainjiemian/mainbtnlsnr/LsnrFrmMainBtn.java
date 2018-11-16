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
 * ����һ������������button��ťʹ�õļ�����
 * 
 * @author �Ⱒ��
 *
 */
public class LsnrFrmMainBtn implements ActionListener {

	private FrmRightTopMain frmRightTop;
	private FrmHotelMain frmHotelMain;

	private String roomID; // ������ŷ���id

	/**
	 * ���캯�����г�ʼ��
	 */
	public LsnrFrmMainBtn(FrmHotelMain frmHotelMain) {
		this.frmHotelMain = frmHotelMain;
	}

	/**
	 * ��������button��ť�ļ����¼�
	 */
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (frmHotelMain.getYudingguanlibt().equals(o)) {    // Ԥ������
			new FrmReserveMain(null).setVisible(true);
			return;
		} else if (frmHotelMain.getRuzhudengjibt().equals(o)) { // ��ס�Ǽ�

			FrmRuZhuRoom frmRuZhuRoom = new FrmRuZhuRoom(null, "��ס�Ǽ�", true, "��ס");
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
			frmRuZhuRoom.getTxtbklx().setText("��ͨ");
			frmRuZhuRoom.getTxtbklx().setEnabled(false);
			frmRuZhuRoom.setVisible(true);
			return;
		} else if (frmHotelMain.getRuzhuchaxunbt().equals(o)) { // ��ס��ѯ
			new Frmcheckin("��ס��ѯ").setVisible(true);
			return;
		} else if (frmHotelMain.getTuifangjiezhangbt().equals(o)) { // �˷�����
			FrmAccount frmAccount =new FrmAccount(null, "�˷�����", true);
			String jiesuanId = HotelTools.getNumber(HotelTools.AC);
			frmAccount.getTxtJieZhangDanHao().setText(jiesuanId);
			frmAccount.setVisible(true);
			return;
		} else if (frmHotelMain.getKehuguanlibt().equals(o)) { // �ͻ�����
			new FrmMain("�ͻ�����").setVisible(true);
			return;
		} else if (frmHotelMain.getZengjiaxiaofeibt().equals(o)) { // ��������
			new FrmConsume(null, "��Ʒ����", true, "����").setVisible(true);
			return;
		} else if (frmHotelMain.getJiesuanselectbt().equals(o)) { // �����ѯ
			new FRMbalance("���Ѳ�ѯ").setVisible(true);
			return;
		} else if (frmHotelMain.getAboutus().equals(o)) { // ��������
			new FrmAboutUs(frmHotelMain).setVisible(true);
			return;
		} else if (frmHotelMain.getHuanbanbt().equals(o)) { // ����
			String msg = "�Ƿ��л���¼Ա��";
			int isAdd = JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
			if (isAdd == JOptionPane.YES_OPTION) {
			   JuiFrontLogin frontLogin=new JuiFrontLogin();
	           frontLogin.setVisible(true);
	           frmHotelMain.dispose();
			}
			return;
		} else if (frmHotelMain.getQuitsystem().equals(o)) { // �˳�ϵͳ
			QuitSystem q = new QuitSystem();
			q.quit(frmHotelMain);
			return;
		}
	}
}
