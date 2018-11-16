package control.mainfrm.lsnYuDing.AddYuDing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import common.component.tools.HotelTools;
import control.mainfrm.residefrm.LsnrResideFrmBtn;
import model.mainbackfrm.Roomtype.MDLRoomType;
import model.mainbackfrm.room.mdlRoom;
import model.mainfrm.YuDing.MdlYuDing;
import view.mainfrm.YuDing.YuDingView;
import view.mainfrm.mainjiemian.FrmHotelMain;
import vo.mainback.Roomvo;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ReserveVO;

/**
 * ���Ԥ����Ϣ�����޸�Ԥ����Ϣ������
 * 
 * @author �ź�
 * @date 2018.11.02
 */
public class LsnrAddYuDing implements ActionListener {
	private YuDingView yd;

	public LsnrAddYuDing(YuDingView yd) {
		this.yd = yd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		JTextField txtYDid = yd.getTxtYDid();
		JTextField txtVipId = yd.getTxtVipId();
		JTextField txtCustomerName = yd.getTxtCustomerName();
		JTextField txtCustomerType = yd.getTxtCustomerType();
		JTextField txtTel = yd.getTxtTel();
		JTextField txtSex = yd.getTxtSex();
		JTextField txtRoomType = yd.getTxtRoomType();
		JTextField txtRoomId = yd.getTxtRoomId();
		JTextField txtCustomerCId = yd.getTxtCustomerCId();
		JTextField txYDtime = yd.getTxYDtime();
		JTextField txtBLtime = yd.getTxtBLtime();
		JTextField txtYDState = yd.getTxtYDState();
		ReserveVO ydVo = new ReserveVO();
		MdlYuDing mdlYD = new MdlYuDing();
		mdlRoom mdlRoom = new mdlRoom();
		Roomvo roomvo = new Roomvo();
		CustomerVO customervo = new CustomerVO();
		if (o.equals(yd.getCkbSex1())) {
			// �Ա��м�����
			if (yd.getCkbSex1().isSelected()) {
				txtSex.setText("��");
			}

		} else if (o.equals(yd.getCkbSex2())) {
			// �Ա�Ů������
			if (yd.getCkbSex2().isSelected()) {
				txtSex.setText("Ů");
			}

		} else if (o.equals(yd.getCbBoxYDState())) {
			// Ԥ��״̬��Ͽ������
			String[] s = yd.getYDSateName();
			for (String a : s) {
				if (yd.getCbBoxYDState().getSelectedItem().equals(a)) {
					txtYDState.removeAll();
					txtYDState.setText(a);
				}
			}

		} else if (o.equals(yd.getCbBoxRoomType())) {
			// ����������Ͽ������
			JComboBox cbx = yd.getCbBoxRoomType();
			JComboBox cbx1 = yd.getCbBoxRoomId();
			Vector<String> v = new MDLRoomType().selectAllRoomTypeName();
			String[] roomType = yd.getRoomName();

			// Vector rev = new Vector();
			// for (int i = 0; i < roomType.length; i++) {
			// rev.add(roomType[i]);
			// }

			if (v.contains(cbx.getSelectedItem())) {
				cbx1.removeAllItems();
				txtRoomType.setText(cbx.getSelectedItem().toString());
				Vector ve = mdlRoom.findRoomByRoomState(cbx.getSelectedItem().toString());
				// System.out.println(ve.size());
				String[] str = new String[ve.size()];
				for (Iterator it = ve.iterator(); it.hasNext();) {
					str = (String[]) it.next();
					cbx1.addItem(str[0]);
				}
			} else {
				JOptionPane.showMessageDialog(yd, "�÷������Ͳ����ڣ�����ϵ��̨����Ա��Ӵ˷������ͣ�", "������ʾ�� ", 1);
				txtRoomType.setText("");
				cbx1.removeAllItems();
				return;
			}

		} else if (o.equals(yd.getCbBoxRoomId())) {
			// �������Ͽ������
			JComboBox cbx1 = yd.getCbBoxRoomId();
			if (cbx1.getSelectedItem() != null) {
				txtRoomId.setText(cbx1.getSelectedItem().toString());
			} else {
				txtRoomId.setText("");
			}
		} else if (o.equals(yd.getDatePickerTo())) {

			// ���ڼ�����
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			try {
				String strDate = formatter.format(yd.getDatePickerTo().getSelectedDate());
				txYDtime.setText(strDate);

				Date d = (Date) yd.getDatePickerTo().getSelectedDate();
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(d);
				calendar.add(calendar.DATE, 1);
				d = (Date) calendar.getTime();
				String s = formatter.format(d);

				txtBLtime.setText(s);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (o.equals(yd.getBtnQueDing())) {
			// ȷ����ť������
			if (!txtCustomerName.getText().equals("") && !txtSex.getText().equals("")
					&& !txtRoomType.getText().equals("") && !txtRoomId.getText().equals("")
					&& !txYDtime.getText().equals("") && !txtBLtime.getText().equals("")) {
				if (!txtTel.getText().matches("[1][3-8][0-9]{9}")) {
					JOptionPane.showMessageDialog(yd, "��������ֻ������ʽ����ȷ�����������", "������ʾ�� ", 2);
				} else if (!txtCustomerCId.getText().matches("[4][0-9]{16}[0-9X]")) {
					JOptionPane.showMessageDialog(yd, "����������֤�����ʽ����ȷ�����������", "������ʾ�� ", 2);
				} else {
					customervo.setCustomerTel(txtTel.getText());
					if (mdlYD.findCustomerByTel(customervo).isEmpty()) {
						String GukeID = HotelTools.getNumber(HotelTools.G);
						HotelTools.savNumber(GukeID, HotelTools.G);
						LsnrResideFrmBtn.CustID = GukeID;   // ������ס
						customervo.setCustomerID(GukeID);
						customervo.setCustomerName(txtCustomerName.getText());
						customervo.setCustomerSex(txtSex.getText());
						customervo.setCustomerCID(txtCustomerCId.getText());
						customervo.setMemberId("MG101");// ��ʼΪ��ͨ
						// �����¹˿�
						mdlYD.xinZengCustomer(customervo);

						// ���±��
						HotelTools.savNumber(yd.getStrYdID(), HotelTools.YD);
						String strRoomTypeId = new mdlRoom().findRoomTypeID(txtRoomId.getText());

						ydVo.setReserveId(txtYDid.getText());
						ydVo.setCustomerId(customervo.getCustomerID());
						ydVo.setMemberId("MG101");
						ydVo.setRoomTypeId(strRoomTypeId);
						ydVo.setRoomId(txtRoomId.getText());
						ydVo.setReserveState(txtYDState.getText());
						ydVo.setReserveRTime(txYDtime.getText());
						ydVo.setReserveLTime(txtBLtime.getText());
						// ������Ҫ��ȡ��¼��Ա��id
						 ydVo.setEmployeeId(FrmHotelMain.lbC.getText().substring(0, 6));
						//ydVo.setEmployeeId("EM1002");// ������
						// ���Ԥ����Ϣ
						mdlYD.addYuDing(ydVo);
						// ���·���״̬
						roomvo.setRoomid(txtRoomId.getText());
						roomvo.setRoomstateid("RS02");

						mdlRoom.updateRoomSate(roomvo);
						this.yd.dispose();
						JOptionPane.showMessageDialog(yd, "Ԥ���ɹ���", "������ʾ�� ", 1);

					} else {
						CustomerVO cc = mdlYD.findCustomerIDByTel(customervo);
						LsnrResideFrmBtn.CustID = cc.getCustomerID();
						String strRoomTypeId = new mdlRoom().findRoomTypeID(txtRoomId.getText());
						// ���±��
						HotelTools.savNumber(yd.getStrYdID(), HotelTools.YD);
						ydVo.setReserveId(txtYDid.getText());
						ydVo.setCustomerId(cc.getCustomerID());
						ydVo.setMemberId(cc.getMemberId());
						ydVo.setRoomTypeId(strRoomTypeId);
						ydVo.setRoomId(txtRoomId.getText());
						ydVo.setReserveState(txtYDState.getText());
						ydVo.setReserveRTime(txYDtime.getText());
						ydVo.setReserveLTime(txtBLtime.getText());
						// ������Ҫ��ȡ��¼��Ա��id
					    ydVo.setEmployeeId(FrmHotelMain.lbC.getText().substring(0, 6));
					
						// ���Ԥ����Ϣ
						mdlYD.addYuDing(ydVo);
						// ���·���״̬
						roomvo.setRoomid(txtRoomId.getText());
						roomvo.setRoomstateid("RS02");
						mdlRoom.updateRoomSate(roomvo);

						this.yd.dispose();
						JOptionPane.showMessageDialog(yd, "Ԥ���ɹ���", "������ʾ�� ", 1);

					}
				}

			} else {
				JOptionPane.showMessageDialog(yd, "����д�������Ϣ", "������ʾ�� ", 2);
			}

		} else if (o.equals(yd.getBtnXiuGai())) {
			// �޸İ�ť������
			if (!txtRoomType.getText().equals("") && !txtRoomId.getText().equals("")) {
				int option = JOptionPane.showConfirmDialog(this.yd, "ȷ��Ҫ�޸�Ԥ����Ϣ��", "������ʾ", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					customervo.setCustomerTel(txtTel.getText());

					CustomerVO cc = mdlYD.findCustomerIDByTel(customervo);
					String strRoomTypeId = new mdlRoom().findRoomTypeID(txtRoomId.getText());
					// ���±��
					ydVo.setReserveId(txtYDid.getText());
					ydVo.setRoomTypeId(strRoomTypeId);
					ydVo.setRoomId(txtRoomId.getText());
					ydVo.setReserveState(txtYDState.getText());
					ydVo.setReserveRTime(txYDtime.getText());
					ydVo.setReserveLTime(txtBLtime.getText());
					// ������Ҫ��ȡ��¼��Ա��id
					//ydVo.setEmployeeId(FrmHotelMain.lbC.getText().substring(0, 6));
					//ydVo.setEmployeeId("EM1002");// ������
					// ����Ԥ����Ϣ
					mdlYD.updateYuDing(ydVo);
					//���ȡ�����޸ķ���״̬
                    if(txtYDState.getText().equals("��ȡ��")){
                    	roomvo.setRoomid(txtRoomId.getText());
						roomvo.setRoomstateid("RS01");
						mdlRoom.updateRoomSate(roomvo);
                    }
					
					
					this.yd.dispose();
					JOptionPane.showMessageDialog(yd, "�޸ĳɹ���", "������ʾ�� ", 1);

				}
			} else {
				JOptionPane.showMessageDialog(yd, "����д�������Ϣ", "������ʾ�� ", 2);
			}
		} else if (o.equals(yd.getBtnQuXiao())) {
			// ȡ����ť
			this.yd.dispose();
		} else if (o.equals(yd.getTxtVipId())) {
			// txt vipid������
			if (txtVipId.getText().matches("VIP[0-9]{4}")) {
				customervo.setVipId(txtVipId.getText());
				CustomerVO cc = mdlYD.findCustomerByVIP(customervo);
				if (cc != null) {
					txtCustomerName.setText(cc.getCustomerName());
					txtCustomerType.setText(cc.getMemberName());
					txtCustomerCId.setText(cc.getCustomerCID());
					txtSex.setText(cc.getCustomerSex());
					txtTel.setText(cc.getCustomerTel());
				} else {
					JOptionPane.showMessageDialog(yd, "��VIP�˺Ų����ڣ����������", "������ʾ�� ", 1);
				}
			} else {
				JOptionPane.showMessageDialog(yd, "�������磨VIP1001����ʽ��vip", "������ʾ�� ", 2);
			}

		} else if (o.equals(yd.getTxtTel())) {
			customervo.setCustomerTel(txtTel.getText());
			CustomerVO cc = mdlYD.findCustomerIDByTel(customervo);
			if (cc != null) {
				txtCustomerName.setText(cc.getCustomerName());
				txtCustomerType.setText(cc.getMemberName());
				txtCustomerCId.setText(cc.getCustomerCID());
				txtSex.setText(cc.getCustomerSex());
				txtTel.setText(cc.getCustomerTel());
			}

		}

	}

}
