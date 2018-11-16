package control.mainfrm.consume;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import common.component.tools.HotelTools;
import model.mainfrm.consume.MDLFrmJieSuan;
import view.mainfrm.account.FrmAccount;
import view.mainfrm.mainjiemian.FrmHotelMain;
import vo.consumeaout.AccountVO;
import vo.consumeaout.ConsumeVO;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;

public class LsnrJieSuanFrm implements ActionListener {
	
	private FrmAccount frmAccount;
	private FrmHotelMain frmHotelMain;
	ResideVO vo1 = new ResideVO();   // 入住VO 对象
	ConsumeVO vo2 = new ConsumeVO(); //消费的VO对象
	private static String RoomID;
	MDLFrmJieSuan mdlFrmJieSuan = new MDLFrmJieSuan();   // 结算的业务逻辑
	
	public LsnrJieSuanFrm(FrmAccount frmAccount) {
		this.frmAccount=frmAccount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(frmAccount.getTxtZhuKeFangJian().equals(o)) {               //根据房间号查找信息
			RoomID = frmAccount.getTxtZhuKeFangJian().getText();
			vo1.setRoomID(RoomID);
			vo2.setRoom_id(RoomID);
			Vector v = mdlFrmJieSuan.findRoomMessage(vo1);
			if(v.size()==0) {
				JOptionPane.showMessageDialog(frmAccount, "没有该房间的入住信息！");
				return;
			}else {
				frmAccount.getTxtZhuKeXingMing().setText((String)v.get(2));
				String tId = (String)v.get(3);
				if(tId.equals("MG101")) {
					frmAccount.getRdbPuTong().setSelected(true);
					frmAccount.getRdbVip().setEnabled(false);
					frmAccount.getRdbSvip().setEnabled(false);
				} else if(tId.equals("MG102")) {
					frmAccount.getRdbVip().setSelected(true);
					frmAccount.getRdbPuTong().setEnabled(false);
					frmAccount.getRdbSvip().setEnabled(false);
				}else {
					frmAccount.getRdbSvip().setSelected(true);
					frmAccount.getRdbPuTong().setEnabled(false);
					frmAccount.getRdbVip().setEnabled(false);
				}
				Double fj = Double.valueOf((String) v.get(6));
				Date rzhu = (Date)v.get(7);
				Date tuifang = (Date)v.get(8);
				int tianshu = daysBetween(rzhu,tuifang);
				Double fangjia = fj * tianshu;
				
				Vector rev = mdlFrmJieSuan.findRoomConsume(vo2);
				if(rev.size()==0) {
					frmAccount.getTxtXiaoFeiZongE().setText(Double.toString(fangjia));
				}else {
					Double je = 0.00;
					for (Iterator it = rev.iterator(); it.hasNext();) {
						Double d = (Double) it.next();
						je+=d;
					}
					frmAccount.getTxtXiaoFeiZongE().setText(Double.toString(fangjia+je));
				}
				if(tId.equals("MG101")) {
					Double g = Double.valueOf(frmAccount.getTxtXiaoFeiZongE().getText());
					Double yhje = g*0.95;
					frmAccount.getTxtYouHuiZongE().setText(String.valueOf(yhje));
				}else if(tId.equals("MG102")) {
					Double g = Double.valueOf(frmAccount.getTxtXiaoFeiZongE().getText());
					Double yhje = g*0.9;
					frmAccount.getTxtYouHuiZongE().setText(String.valueOf(yhje));
				}else if(tId.equals("MG103")) {
					Double g = Double.valueOf(frmAccount.getTxtXiaoFeiZongE().getText());
					Double yhje = g*0.8;
					frmAccount.getTxtYouHuiZongE().setText(String.valueOf(yhje));
				}
				frmAccount.getTxtYiFuYaJin().setText((String)v.get(5));
			}
		}
		if(frmAccount.getTxtBinKeZhiFu().equals(o)) {             // 判断支付金额
			if(frmAccount.getTxtYingShouZongE().equals("") || frmAccount.getTxtHaiYingZhiFu().equals("") || frmAccount.getTxtBinKeZhiFu().equals("")) {
				JOptionPane.showMessageDialog(frmAccount, "请填写收费信息！");
				return;
			}
			Double yE=Double.valueOf(frmAccount.getTxtYingShouZongE().getText());
			Double hFu=Double.valueOf(frmAccount.getTxtHaiYingZhiFu().getText());
			Double bFu=Double.valueOf(frmAccount.getTxtBinKeZhiFu().getText());
			Double yj =Double.valueOf(frmAccount.getTxtYiFuYaJin().getText());
			frmAccount.getTxtTuiHuanYaJin().setText(String.valueOf(yj+bFu-yE-hFu));
		}
		if(frmAccount.getBtnQuXiaoJieZhang().equals(o)) {                        //取消结算
			frmAccount.dispose();
			return;
		}
		if(frmAccount.getBtnQueRenJieZhang().equals(o)) {                        //确认结算
			if(frmAccount.getTxtTuiHuanYaJin().getText().equals("")) {
				JOptionPane.showMessageDialog(frmAccount, "请填写结算信息！");
				return;
			}
			String AccountId = frmAccount.getTxtJieZhangDanHao().getText();
			
			Double zonge =Double.valueOf(frmAccount.getTxtXiaoFeiZongE().getText());
			vo1.setRoomID(RoomID);
			Vector v = mdlFrmJieSuan.findRoomMessage(vo1);

			CustomerVO vo1 = new CustomerVO();
			ResideVO vo2 = new ResideVO();
			ConsumeVO vo3 = new ConsumeVO();
			RoomVO vo4 = new RoomVO();
			AccountVO vo5 =new AccountVO();
			
			String vipId = HotelTools.getNumber(HotelTools.VIP);
			String CustomerId = (String)v.get(1);
			String tyId = (String)v.get(3);       //顾客类型id
			
			if(zonge>3000) {                                     // 判断消费情况进行升级
				if(tyId.equals("MG101")) {
					vo1.setCustomerID(CustomerId);
					vo1.setMemberId("MG102");
					vo1.setVipId(vipId);
					mdlFrmJieSuan.updateCustomerType(vo1);
					mdlFrmJieSuan.insertVip(vo1);
				}
			}if(zonge>10000) {
				if(tyId.equals("MG102")) {
					vo1.setCustomerID(CustomerId);
					vo1.setMemberId("MG103");
					mdlFrmJieSuan.updateCustomerType(vo1);
					mdlFrmJieSuan.updateVipMessage(vo1);
				}if(tyId.equals("MG101")) {
					vo1.setCustomerID(CustomerId);
					vo1.setMemberId("MG103");
					vo1.setVipId(vipId);
					mdlFrmJieSuan.updateCustomerType(vo1);
					mdlFrmJieSuan.updateVipMessage(vo1);
				}
			}
			vo2.setRoomID(RoomID);                 // 更新入住结账状态
			mdlFrmJieSuan.updateResideMes(vo2);
			
			vo3.setRoom_id(RoomID);                 // 更新房间消费结账状态
			mdlFrmJieSuan.updateRoomConsume(vo3);
			
			vo4.setRoomId(RoomID);                 // 更新房间状态
			mdlFrmJieSuan.updateRoomState(vo4);
			
			//插入一条结算信息
			vo5.setAccount_id(frmAccount.getTxtJieZhangDanHao().getText());
			vo5.setReside_id((String)v.get(0));
			vo5.setCustomer_id(CustomerId);
			vo5.setMember_id(tyId);
			vo5.setRoom_id(RoomID);
			vo5.setRoomtype_id((String)v.get(4));
			vo5.setEmployee_id(frmHotelMain.lbC.getText().substring(0, 6));
			vo5.setAccount_money(zonge);
			vo5.setDeposit(Double.valueOf(frmAccount.getTxtYiFuYaJin().getText()));
			vo5.setReturn_deposit(Double.valueOf(frmAccount.getTxtTuiHuanYaJin().getText()));
			vo5.setAccount_state("1");
			vo5.setAccount_txt(frmAccount.getTxtBeiZhu().getText());
			
			HotelTools.savNumber(AccountId, HotelTools.AC);
			mdlFrmJieSuan.insertAccoutMes(vo5);
			frmAccount.dispose();
			return;
		}
	}
	
	/** 
     * 计算两个日期之间相差的天数 
     * @param date1 
     * @param date2 
     * @return 
     */  
    public static int daysBetween(Date date1,Date date2)  
    {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date1);  
        long time1 = cal.getTimeInMillis();               
        cal.setTime(date2);  
        long time2 = cal.getTimeInMillis();       
        long between_days=(time2-time1)/(1000*3600*24);  
           
       return Integer.parseInt(String.valueOf(between_days));         
    }


}
