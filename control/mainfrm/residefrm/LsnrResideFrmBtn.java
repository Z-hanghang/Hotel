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
 * 主要用于入住界面中按钮的监听组件
 * 
 * @author 吴阿龙
 *
 */
public class LsnrResideFrmBtn implements ActionListener {
	private FrmRuZhuRoom frmRuZhuRoom;

	public static boolean flag = false; // 用于判定是新顾客还是老顾客

	public static String CustID; // 用来保存查询出来的顾客id
	public static String MemberID; // 用来保存顾客类型id
	MDLReside mdlReside = new MDLReside();

	public LsnrResideFrmBtn(FrmRuZhuRoom frmRuZhuRoom) {
		this.frmRuZhuRoom = frmRuZhuRoom;
	}

	/**
	 * 开房入住界面组件的监听器
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (frmRuZhuRoom.getBaocun().equals(o)) { // 保存信息按钮
			if (isValidity()) { // 判断内容输入的是否有误的写在另外的监听器中，进行检验
				int isAdd = JOptionPane.showConfirmDialog(null,
						"您确定以当前宾客信息，以 [ " + frmRuZhuRoom.getComfjbh().getSelectedItem().toString() + " ] 为主房间，开设房间吗？",
						"提示", JOptionPane.YES_NO_OPTION);
				if (isAdd == JOptionPane.YES_OPTION) {
					saveMessage(); // 保存信息
					RoomVO vo = new RoomVO();
					vo.setRoomStateId("RS03");
					vo.setRoomId(frmRuZhuRoom.getComfjbh().getSelectedItem().toString());
					mdlReside.updateRoomState(vo);
					// 更改预订状态 判断静态字符串是否为预订的
					if (frmRuZhuRoom.getYDState() != null && !frmRuZhuRoom.getYDState().equals("")) {
						if (frmRuZhuRoom.getYDState().equals("已预订")) {
							ReserveVO reserveVO = new ReserveVO();
							reserveVO.setReserveId(frmRuZhuRoom.getYDId());
							reserveVO.setReserveState("已入住");
							new MdlYuDing().UpdateYuDingState(reserveVO);
						}
					}
					frmRuZhuRoom.dispose();
				}
			}
			return;
		} else if (frmRuZhuRoom.getQuxiao().equals(o)) { // 取消按钮
			frmRuZhuRoom.dispose();
			return;
		} else if (frmRuZhuRoom.getTxtHybh().equals(o)) { // 根据会员编号查询
			CustomerVO vo = new CustomerVO();
			vo.setVipId(frmRuZhuRoom.getTxtHybh().getText());
			Vector v = mdlReside.findCustomerByVIP(vo);
			if (v.size() == 0) {
				String msg = "本酒店没有该会员，请确认是否输入有误";
				JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
			} else {
				flag = true;
				String[] str = new String[v.size()];
				int i = 0;
				for (Iterator it = v.iterator(); it.hasNext();) {
					String s = (String) it.next();
					str[i] = s;
					i++;
				}
				CustID = str[0]; // 顾客姓名id
				MemberID = str[2]; // 顾客类型id

				frmRuZhuRoom.getTxtbkxm().setText(str[1]);
				frmRuZhuRoom.getTxtbklx().setText(str[3]);
				frmRuZhuRoom.getTxtlxdh().setText(str[4]);
				frmRuZhuRoom.getTxtsfz().setText(str[5]);
				if (str[6].equals("女")) {
					frmRuZhuRoom.getComgkxb().removeAllItems();
					frmRuZhuRoom.getComgkxb().addItem("女");
					frmRuZhuRoom.getComgkxb().addItem("男");
				}
			}
		} else if (frmRuZhuRoom.getTxtlxdh().equals(o)) { // 根据手机号码进行查询顾客信息
			if (frmRuZhuRoom.getTxtlxdh().getText().matches("[1][3-8][0-9]{9}")) {
				CustomerVO vo = new CustomerVO();
				vo.setCustomerTel(frmRuZhuRoom.getTxtlxdh().getText());
				Vector v = mdlReside.findCustomerByTel(vo);
				if (v.size() == 0) {
					String msg = "本酒店没有该老顾客，请确认再输入";
					JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
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
					CustID = str[0]; // 顾客姓名id
					MemberID = str[2]; // 顾客类型id

					frmRuZhuRoom.getTxtbkxm().setText(str[1]);
					frmRuZhuRoom.getTxtbklx().setText(str[3]);
					frmRuZhuRoom.getTxtsfz().setText(str[4]);
					if (str[5].equals("女")) {
						frmRuZhuRoom.getComgkxb().removeItem("男");
					} else {
						frmRuZhuRoom.getComgkxb().removeItem("女");
					}
				}
			} else {
				String msg = "请填写正确手机号码";
				JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
			}
			return;
		} else if (frmRuZhuRoom.getComfjlx().equals(o) && LsnrRoomMenuFrm.flag) { // 房间类型
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
	 * private boolean isValidity() {} : 测试用户输入的数据是否合法 参数 ：无 返回值 ：boolean 修饰符
	 * ：private 功能 ：测试用户输入的数据是否合法
	 */
	private boolean isValidity() {
		String[] str = { "普通", "vip", "svip" }; // 判断顾客类型是否合格

		boolean bResult = true;
		for (String temp : str) {
			if (temp.equals(frmRuZhuRoom.getTxtbklx().getText())) {
				bResult = false;
			}
		}
		if (frmRuZhuRoom.getTxtbkxm().getText().equals("")) {
			String msg = "请填写顾客姓名";
			JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (frmRuZhuRoom.getTxtbklx().equals("") || bResult) {
			String msg = "请填写正确顾客类型信息";
			JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (frmRuZhuRoom.getTxtlxdh().equals("")
				|| !frmRuZhuRoom.getTxtlxdh().getText().matches("[1][3-8][0-9]{9}")) {
			String msg = "请填写正确联系电话信息";
			JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (frmRuZhuRoom.getTxtsfz().equals("")
				|| !frmRuZhuRoom.getTxtsfz().getText().matches("[1-9][0-9]{17}")) {
			String msg = "请填写正确身份证信息";
			JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (frmRuZhuRoom.getTxtrs().equals("") || !frmRuZhuRoom.getTxtrs().getText().matches("[1-9]")) {
			String msg = "请填写小于10人的人数";
			JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (frmRuZhuRoom.getTxtyj().equals("")
				|| !frmRuZhuRoom.getTxtyj().getText().matches("[1-9][0-9]{2,3}")) {
			String msg = "请填写3位数到4位数押金信息";
			JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * 通过判断保存顾客信息和入住信息
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

			if (frmRuZhuRoom.getTxtbklx().getText().equals("普通")) {
				vo1.setMemberId("MG101");
			} else if (frmRuZhuRoom.getTxtbklx().getText().equals("vip")) {
				vo1.setMemberId("MG102");
			} else {
				vo1.setMemberId("MG103");
			}
			mdlReside.insertCustomer(vo1);
			HotelTools.savNumber(CustomerId, HotelTools.G); // 在配置文件中保存顾客编号
			setResideMessage(CustomerId, ResideId, vo2); // 设置入住信息
			HotelTools.savNumber(ResideId, HotelTools.D); // 在配置文件中保存入住编号

			return;
		} else {
			setResideMessage(CustID, ResideId, vo2); // 设置入住信息
			HotelTools.savNumber(ResideId, HotelTools.D);
			return;
		}
	}

	/**
	 * 设置保存的入住信息
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
		if (frmRuZhuRoom.getTxtbklx().getText().equals("普通")) {
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
		// sdf.format(frmRuZhuRoom.getRuzhudatePickerFrom().getSelectedDate());//从界面获取输入的日期
		try {
			vo2.setResideRtime(frmRuZhuRoom.getRuzhudatePickerFrom().getSelectedDate()); // 入住时间
			vo2.setResideLtime(frmRuZhuRoom.getTuifangdatePickerFrom().getSelectedDate()); // 退房时间
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		mdlReside.insertReside(vo2);
		// 更改预订信息表
		ReserveVO vo3 = new ReserveVO();
		vo3.setRoomId(frmRuZhuRoom.getComfjbh().getSelectedItem().toString());
		MDLReside mdlReside = new MDLReside();
		mdlReside.updateReserve(vo3);
	}

}
