package control.mainfrm.residefrm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import common.component.tools.HotelTools;
import control.mainfrm.mainjiemian.roommenu.LsnrRoomMenuFrm;
import model.mainfrm.YuDing.MdlYuDing;
import model.mainfrm.residefrm.MDLReside;
import view.mainfrm.mainjiemian.FrmHotelMain;
import view.mainfrm.mainjiemian.FrmRightTopMain;
import view.mainfrm.reside.FrmRuZhuRoom;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ReserveVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;

/**
 * ��Ҫ������ס�����а�ť�ļ������
 * 
 * @author �Ⱒ��
 *
 */
public class LsnrResideFrmBtn implements ActionListener {
	private FrmRuZhuRoom frmRuZhuRoom;

	public static boolean flag = false; // �����ж����¹˿ͻ����Ϲ˿�

	public static String CustID; // ���������ѯ�����Ĺ˿�id
	public static String MemberID; // ��������˿�����id
	MDLReside mdlReside = new MDLReside();

	public LsnrResideFrmBtn(FrmRuZhuRoom frmRuZhuRoom) {
		this.frmRuZhuRoom = frmRuZhuRoom;
	}

	/**
	 * ������ס��������ļ�����
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (frmRuZhuRoom.getBaocun().equals(o)) { // ������Ϣ��ť
			if (isValidity()) { // �ж�����������Ƿ������д������ļ������У����м���
				int isAdd = JOptionPane.showConfirmDialog(null,
						"��ȷ���Ե�ǰ������Ϣ���� [ " + frmRuZhuRoom.getComfjbh().getSelectedItem().toString() + " ] Ϊ�����䣬���跿����",
						"��ʾ", JOptionPane.YES_NO_OPTION);
				if (isAdd == JOptionPane.YES_OPTION) {
					saveMessage(); // ������Ϣ
					RoomVO vo = new RoomVO();
					vo.setRoomStateId("RS03");
					vo.setRoomId(frmRuZhuRoom.getComfjbh().getSelectedItem().toString());
					mdlReside.updateRoomState(vo);
					// ����Ԥ��״̬ �жϾ�̬�ַ����Ƿ�ΪԤ����
					if (frmRuZhuRoom.getYDState() != null && !frmRuZhuRoom.getYDState().equals("")) {
						if (frmRuZhuRoom.getYDState().equals("��Ԥ��")) {
							ReserveVO reserveVO = new ReserveVO();
							reserveVO.setReserveId(frmRuZhuRoom.getYDId());
							reserveVO.setReserveState("����ס");
							new MdlYuDing().UpdateYuDingState(reserveVO);
						}
					}
					frmRuZhuRoom.dispose();
				}
			}
			return;
		} else if (frmRuZhuRoom.getQuxiao().equals(o)) { // ȡ����ť
			frmRuZhuRoom.dispose();
			return;
		} else if (frmRuZhuRoom.getTxtHybh().equals(o)) { // ���ݻ�Ա��Ų�ѯ
			CustomerVO vo = new CustomerVO();
			vo.setVipId(frmRuZhuRoom.getTxtHybh().getText());
			Vector v = mdlReside.findCustomerByVIP(vo);
			if (v.size() == 0) {
				String msg = "���Ƶ�û�иû�Ա����ȷ���Ƿ���������";
				JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
			} else {
				flag = true;
				String[] str = new String[v.size()];
				int i = 0;
				for (Iterator it = v.iterator(); it.hasNext();) {
					String s = (String) it.next();
					str[i] = s;
					i++;
				}
				CustID = str[0]; // �˿�����id
				MemberID = str[2]; // �˿�����id

				frmRuZhuRoom.getTxtbkxm().setText(str[1]);
				frmRuZhuRoom.getTxtbklx().setText(str[3]);
				frmRuZhuRoom.getTxtlxdh().setText(str[4]);
				frmRuZhuRoom.getTxtsfz().setText(str[5]);
				if (str[6].equals("Ů")) {
					frmRuZhuRoom.getComgkxb().removeAllItems();
					frmRuZhuRoom.getComgkxb().addItem("Ů");
					frmRuZhuRoom.getComgkxb().addItem("��");
				}
			}
		} else if (frmRuZhuRoom.getTxtlxdh().equals(o)) { // �����ֻ�������в�ѯ�˿���Ϣ
			if (frmRuZhuRoom.getTxtlxdh().getText().matches("[1][3-8][0-9]{9}")) {
				CustomerVO vo = new CustomerVO();
				vo.setCustomerTel(frmRuZhuRoom.getTxtlxdh().getText());
				Vector v = mdlReside.findCustomerByTel(vo);
				if (v.size() == 0) {
					String msg = "���Ƶ�û�и��Ϲ˿ͣ���ȷ��������";
					JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
				} else {
					flag = true;
					frmRuZhuRoom.getTxtHybh().setEnabled(false);
					String[] str = new String[v.size()];
					int i = 0;
					for (Iterator it = v.iterator(); it.hasNext();) {
						String s = (String) it.next();
						str[i] = s;
						i++;
					}
					CustID = str[0]; // �˿�����id
					MemberID = str[2]; // �˿�����id

					frmRuZhuRoom.getTxtbkxm().setText(str[1]);
					frmRuZhuRoom.getTxtbklx().setText(str[3]);
					frmRuZhuRoom.getTxtsfz().setText(str[4]);
					if (str[5].equals("Ů")) {
						frmRuZhuRoom.getComgkxb().removeItem("��");
					} else {
						frmRuZhuRoom.getComgkxb().removeItem("Ů");
					}
				}
			} else {
				String msg = "����д��ȷ�ֻ�����";
				JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
			}
			return;
		} else if (frmRuZhuRoom.getComfjlx().equals(o) && LsnrRoomMenuFrm.flag) { // ��������
			String s = frmRuZhuRoom.getComfjlx().getSelectedItem().toString();
			Vector v = mdlReside.findRoomBytype(FrmRightTopMain.fjlx.get(s).toString(), " and Roomstate_id='RS01'");
			frmRuZhuRoom.getComfjbh().removeAllItems();
			String[] str = new String[v.size()];
			for (Iterator it = v.iterator(); it.hasNext();) {
				str = (String[]) it.next();
				frmRuZhuRoom.getComfjbh().addItem(str[0]);
			}
		}
	}

	/**
	 * private boolean isValidity() {} : �����û�����������Ƿ�Ϸ� ���� ���� ����ֵ ��boolean ���η�
	 * ��private ���� �������û�����������Ƿ�Ϸ�
	 */
	private boolean isValidity() {
		String[] str = { "��ͨ", "vip", "svip" }; // �жϹ˿������Ƿ�ϸ�

		boolean bResult = true;
		for (String temp : str) {
			if (temp.equals(frmRuZhuRoom.getTxtbklx().getText())) {
				bResult = false;
			}
		}
		if (frmRuZhuRoom.getTxtbkxm().getText().equals("")) {
			String msg = "����д�˿�����";
			JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (frmRuZhuRoom.getTxtbklx().equals("") || bResult) {
			String msg = "����д��ȷ�˿�������Ϣ";
			JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (frmRuZhuRoom.getTxtlxdh().equals("")
				|| !frmRuZhuRoom.getTxtlxdh().getText().matches("[1][3-8][0-9]{9}")) {
			String msg = "����д��ȷ��ϵ�绰��Ϣ";
			JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (frmRuZhuRoom.getTxtsfz().equals("")
				|| !frmRuZhuRoom.getTxtsfz().getText().matches("[1-9][0-9]{17}")) {
			String msg = "����д��ȷ���֤��Ϣ";
			JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (frmRuZhuRoom.getTxtrs().equals("") || !frmRuZhuRoom.getTxtrs().getText().matches("[1-9]")) {
			String msg = "����дС��10�˵�����";
			JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (frmRuZhuRoom.getTxtyj().equals("")
				|| !frmRuZhuRoom.getTxtyj().getText().matches("[1-9][0-9]{2,3}")) {
			String msg = "����д3λ����4λ��Ѻ����Ϣ";
			JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * ͨ���жϱ���˿���Ϣ����ס��Ϣ
	 */
	private void saveMessage() {
		CustomerVO vo1 = new CustomerVO();
		ResideVO vo2 = new ResideVO();
		// String ResideId = HotelTools.getNumber(HotelTools.D);
		String ResideId = frmRuZhuRoom.getTxtrzbh().getText();
		String CustomerId = HotelTools.getNumber(HotelTools.G);
		if (flag == false) {
			vo1.setCustomerID(CustomerId);
			vo1.setCustomerName(frmRuZhuRoom.getTxtbkxm().getText());
			vo1.setCustomerSex(frmRuZhuRoom.getComgkxb().getSelectedItem().toString());
			vo1.setCustomerTel(frmRuZhuRoom.getTxtlxdh().getText());
			vo1.setCustomerCID(frmRuZhuRoom.getTxtsfz().getText());

			if (frmRuZhuRoom.getTxtbklx().getText().equals("��ͨ")) {
				vo1.setMemberId("MG101");
			} else if (frmRuZhuRoom.getTxtbklx().getText().equals("vip")) {
				vo1.setMemberId("MG102");
			} else {
				vo1.setMemberId("MG103");
			}
			mdlReside.insertCustomer(vo1);
			HotelTools.savNumber(CustomerId, HotelTools.G); // �������ļ��б���˿ͱ��
			setResideMessage(CustomerId, ResideId, vo2); // ������ס��Ϣ
			HotelTools.savNumber(ResideId, HotelTools.D); // �������ļ��б�����ס���

			return;
		} else {
			setResideMessage(CustID, ResideId, vo2); // ������ס��Ϣ
			HotelTools.savNumber(ResideId, HotelTools.D);
			return;
		}
	}

	/**
	 * ���ñ������ס��Ϣ
	 * 
	 * @param CustomerID
	 * @param ResideId
	 * @param vo2
	 */
	public void setResideMessage(String CustomerID, String ResideId, ResideVO vo2) {
		vo2.setResiderID(ResideId);
		vo2.setDeposit(Integer.parseInt(frmRuZhuRoom.getTxtyj().getText()));
		vo2.setCheckoutState("0");
		vo2.setResideNumber(Integer.parseInt(frmRuZhuRoom.getTxtrs().getText()));
		vo2.setCustomerID(CustomerID);
		if (frmRuZhuRoom.getTxtbklx().getText().equals("��ͨ")) {
			vo2.setMemberID("MG101");
		} else if (frmRuZhuRoom.getTxtbklx().getText().equals("vip")) {
			vo2.setMemberID("MG102");
		} else {
			vo2.setMemberID("MG103");
		}
		vo2.setRoomID(frmRuZhuRoom.getComfjbh().getSelectedItem().toString());
		String RoomTypeID = (String) FrmRightTopMain.fjlx.get(frmRuZhuRoom.getComfjlx().getSelectedItem().toString());
		vo2.setRoomTypeID(RoomTypeID);
		vo2.setEmployeeID(FrmHotelMain.lbC.getText().substring(0, 6));
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss");
		// String ruzhuDate =
		// sdf.format(frmRuZhuRoom.getRuzhudatePickerFrom().getSelectedDate());//�ӽ����ȡ���������
		try {
			vo2.setResideRtime(frmRuZhuRoom.getRuzhudatePickerFrom().getSelectedDate()); // ��סʱ��
			vo2.setResideLtime(frmRuZhuRoom.getTuifangdatePickerFrom().getSelectedDate()); // �˷�ʱ��
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		mdlReside.insertReside(vo2);
		// ����Ԥ����Ϣ��
		ReserveVO vo3 = new ReserveVO();
		vo3.setRoomId(frmRuZhuRoom.getComfjbh().getSelectedItem().toString());
		MDLReside mdlReside = new MDLReside();
		mdlReside.updateReserve(vo3);
	}

}
