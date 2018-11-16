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
 * ������������˵����ļ�����
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
		if (frmHotelMain.getMi11().equals(o)) { // �Ǽ���ס
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
		} else if (frmHotelMain.getMi12().equals(o)) { // ��ס��Ϣ��ѯ
			new Frmcheckin("��ס��ѯ").setVisible(true);
			return;
		} else if (frmHotelMain.getMi13().equals(o)) { // ��������
			if (LsnrRightMenu.RId == null) {
				JOptionPane.showMessageDialog(frmHotelMain, "����������ѡ���ö���");
			} else {

				FrmChangRoom frmChangRoom = new FrmChangRoom(frmHotelMain); // ���ķ���Ĵ���

				frmChangRoom.beforeRoom.setText(LsnrRightMenu.RId); // �������䴰�ڵ�ԭ������Ϣ
				RoomTypeVO vo = new RoomTypeVO();
				MDLChangeRoom mdlChangeRoom = new MDLChangeRoom(); // ���ķ�����Ϣ��ҵ���߼�
				MDLFrmRightBott mdlFrmRightBott = new MDLFrmRightBott(); // ����������Ϣ�ͷ���״̬����ҵ���߼�

				vo.setRoomTypeName(FrmRightTopMain.tb_Name); // ���÷�������

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
		} else if (frmHotelMain.getMi14().equals(o)) { // �޸ĵǼ�
			if (LsnrRightMenu.RId == null) {
				JOptionPane.showMessageDialog(frmHotelMain, "����������ѡ���ö���");
			} else {
				FrmXuFang xuFang = new FrmXuFang(null, "����", true);
				ResideVO vo = new ResideVO();
				vo.setRoomID(LsnrRightMenu.RId);
				MDLReside mdlReside = new MDLReside();
				String s = mdlReside.findTuiRoomTime(vo);
				FrmXuFang.ytime.setText("ԭ�˷�ʱ��Ϊ" + s);
				xuFang.setVisible(true);
			}
			return;
		} else if (frmHotelMain.getMi15().equals(o)) { // ����״̬
			return;
		} else if (frmHotelMain.getMi16().equals(o)) { // Ԥ������
			new FrmReserveMain(null).setVisible(true);
			return;
		} else if (frmHotelMain.getMi17().equals(o)) { // �˳�ϵͳ
			QuitSystem q = new QuitSystem();
			q.quit(frmHotelMain);
			return;
		} else if (frmHotelMain.getMi21().equals(o)) { // ���ͽ���
			FrmAccount frmAccount = new FrmAccount(null, "�˷�����", true);
			String jiesuanId = HotelTools.getNumber(HotelTools.AC);
			frmAccount.getTxtJieZhangDanHao().setText(jiesuanId);
			frmAccount.setVisible(true);
			return;
		} else if (frmHotelMain.getMi22().equals(o)) { // �����ѯ
			new FRMbalance("���Ѳ�ѯ").setVisible(true);
			return;
		} else if (frmHotelMain.getMi23().equals(o)) { // ���ͷ���������ϸ��ѯ
			return;
		} else if (frmHotelMain.getMi31().equals(o)) { // ����
			String msg = "�Ƿ��л���¼Ա��";
			int isAdd = JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (isAdd == JOptionPane.YES_OPTION) {
				JuiFrontLogin frontLogin = new JuiFrontLogin();
				frontLogin.setVisible(true);
				frmHotelMain.dispose();
			}
			return;
		} else if (frmHotelMain.getMi32().equals(o)) { // ��������
			new FrmAboutUs(frmHotelMain).setVisible(true);
			return;
		} else if (frmHotelMain.getMi1().equals(o)) { // ���̲˵���������
			new FrmAboutUs(null).setVisible(true);
			return;
		} else if (frmHotelMain.getMi2().equals(o)) { // ���̲˵��˳�
			mdlRegister mdlRegister = new mdlRegister(); // ��¼����״̬��ҵ���߼�
			Register vo = new Register(); // ��¼��
			vo.setEmployeeId(FrmHotelMain.lbC.getText().substring(0, 6)); // ���������ȡ��ǰ��¼Ա����id lbcΪ��ǰ����Ա��¼��Ϣ

			mdlRegister.updateOutLine(vo); // ����½״̬���� Ϊ0
			frmHotelMain.dispose();
			System.exit(1);
			frmHotelMain.getSystemTray().remove(frmHotelMain.getTrayIcon());
		}else if(frmHotelMain.getMi33().equals(o)){
                //ϵͳ����
                 new Help().setVisible(true);
                
                }

	}

}
