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
 * 添加预订信息或者修改预订信息监听器
 * 
 * @author 张航
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
			// 性别男监听器
			if (yd.getCkbSex1().isSelected()) {
				txtSex.setText("男");
			}

		} else if (o.equals(yd.getCkbSex2())) {
			// 性别女监听器
			if (yd.getCkbSex2().isSelected()) {
				txtSex.setText("女");
			}

		} else if (o.equals(yd.getCbBoxYDState())) {
			// 预订状态组合框监听器
			String[] s = yd.getYDSateName();
			for (String a : s) {
				if (yd.getCbBoxYDState().getSelectedItem().equals(a)) {
					txtYDState.removeAll();
					txtYDState.setText(a);
				}
			}

		} else if (o.equals(yd.getCbBoxRoomType())) {
			// 房间类型组合框监听器
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
				JOptionPane.showMessageDialog(yd, "该房间类型不存在，请联系后台管理员添加此房间类型！", "温情提示： ", 1);
				txtRoomType.setText("");
				cbx1.removeAllItems();
				return;
			}

		} else if (o.equals(yd.getCbBoxRoomId())) {
			// 房间号组合框监听器
			JComboBox cbx1 = yd.getCbBoxRoomId();
			if (cbx1.getSelectedItem() != null) {
				txtRoomId.setText(cbx1.getSelectedItem().toString());
			} else {
				txtRoomId.setText("");
			}
		} else if (o.equals(yd.getDatePickerTo())) {

			// 日期监听器
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
			// 确定按钮监听器
			if (!txtCustomerName.getText().equals("") && !txtSex.getText().equals("")
					&& !txtRoomType.getText().equals("") && !txtRoomId.getText().equals("")
					&& !txYDtime.getText().equals("") && !txtBLtime.getText().equals("")) {
				if (!txtTel.getText().matches("[1][3-8][0-9]{9}")) {
					JOptionPane.showMessageDialog(yd, "你输入的手机号码格式不正确，请从新输入", "温情提示： ", 2);
				} else if (!txtCustomerCId.getText().matches("[4][0-9]{16}[0-9X]")) {
					JOptionPane.showMessageDialog(yd, "你输入的身份证号码格式不正确，请从新输入", "温情提示： ", 2);
				} else {
					customervo.setCustomerTel(txtTel.getText());
					if (mdlYD.findCustomerByTel(customervo).isEmpty()) {
						String GukeID = HotelTools.getNumber(HotelTools.G);
						HotelTools.savNumber(GukeID, HotelTools.G);
						LsnrResideFrmBtn.CustID = GukeID;   // 传给入住
						customervo.setCustomerID(GukeID);
						customervo.setCustomerName(txtCustomerName.getText());
						customervo.setCustomerSex(txtSex.getText());
						customervo.setCustomerCID(txtCustomerCId.getText());
						customervo.setMemberId("MG101");// 初始为普通
						// 插入新顾客
						mdlYD.xinZengCustomer(customervo);

						// 更新编号
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
						// 这里需要获取登录的员工id
						 ydVo.setEmployeeId(FrmHotelMain.lbC.getText().substring(0, 6));
						//ydVo.setEmployeeId("EM1002");// 测试用
						// 添加预订信息
						mdlYD.addYuDing(ydVo);
						// 更新房间状态
						roomvo.setRoomid(txtRoomId.getText());
						roomvo.setRoomstateid("RS02");

						mdlRoom.updateRoomSate(roomvo);
						this.yd.dispose();
						JOptionPane.showMessageDialog(yd, "预定成功！", "温情提示： ", 1);

					} else {
						CustomerVO cc = mdlYD.findCustomerIDByTel(customervo);
						LsnrResideFrmBtn.CustID = cc.getCustomerID();
						String strRoomTypeId = new mdlRoom().findRoomTypeID(txtRoomId.getText());
						// 更新编号
						HotelTools.savNumber(yd.getStrYdID(), HotelTools.YD);
						ydVo.setReserveId(txtYDid.getText());
						ydVo.setCustomerId(cc.getCustomerID());
						ydVo.setMemberId(cc.getMemberId());
						ydVo.setRoomTypeId(strRoomTypeId);
						ydVo.setRoomId(txtRoomId.getText());
						ydVo.setReserveState(txtYDState.getText());
						ydVo.setReserveRTime(txYDtime.getText());
						ydVo.setReserveLTime(txtBLtime.getText());
						// 这里需要获取登录的员工id
					    ydVo.setEmployeeId(FrmHotelMain.lbC.getText().substring(0, 6));
					
						// 添加预订信息
						mdlYD.addYuDing(ydVo);
						// 更新房间状态
						roomvo.setRoomid(txtRoomId.getText());
						roomvo.setRoomstateid("RS02");
						mdlRoom.updateRoomSate(roomvo);

						this.yd.dispose();
						JOptionPane.showMessageDialog(yd, "预定成功！", "温情提示： ", 1);

					}
				}

			} else {
				JOptionPane.showMessageDialog(yd, "请填写完基本信息", "温情提示： ", 2);
			}

		} else if (o.equals(yd.getBtnXiuGai())) {
			// 修改按钮监听器
			if (!txtRoomType.getText().equals("") && !txtRoomId.getText().equals("")) {
				int option = JOptionPane.showConfirmDialog(this.yd, "确定要修改预订信息吗？", "温情提示", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					customervo.setCustomerTel(txtTel.getText());

					CustomerVO cc = mdlYD.findCustomerIDByTel(customervo);
					String strRoomTypeId = new mdlRoom().findRoomTypeID(txtRoomId.getText());
					// 更新编号
					ydVo.setReserveId(txtYDid.getText());
					ydVo.setRoomTypeId(strRoomTypeId);
					ydVo.setRoomId(txtRoomId.getText());
					ydVo.setReserveState(txtYDState.getText());
					ydVo.setReserveRTime(txYDtime.getText());
					ydVo.setReserveLTime(txtBLtime.getText());
					// 这里需要获取登录的员工id
					//ydVo.setEmployeeId(FrmHotelMain.lbC.getText().substring(0, 6));
					//ydVo.setEmployeeId("EM1002");// 测试用
					// 更新预订信息
					mdlYD.updateYuDing(ydVo);
					//如果取消则修改房间状态
                    if(txtYDState.getText().equals("已取消")){
                    	roomvo.setRoomid(txtRoomId.getText());
						roomvo.setRoomstateid("RS01");
						mdlRoom.updateRoomSate(roomvo);
                    }
					
					
					this.yd.dispose();
					JOptionPane.showMessageDialog(yd, "修改成功！", "温情提示： ", 1);

				}
			} else {
				JOptionPane.showMessageDialog(yd, "请填写完基本信息", "温情提示： ", 2);
			}
		} else if (o.equals(yd.getBtnQuXiao())) {
			// 取消按钮
			this.yd.dispose();
		} else if (o.equals(yd.getTxtVipId())) {
			// txt vipid监听器
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
					JOptionPane.showMessageDialog(yd, "该VIP账号不存在，请从新输入", "温情提示： ", 1);
				}
			} else {
				JOptionPane.showMessageDialog(yd, "请输入如（VIP1001）格式的vip", "温情提示： ", 2);
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
