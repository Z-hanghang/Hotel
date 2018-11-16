package control.mainfrm.mainjiemian.roommenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import common.component.tools.HotelTools;
import model.mainfrm.changeroomfrm.MDLChangeRoom;
import view.mainfrm.changeroom.FrmChangRoom;
import view.mainfrm.mainjiemian.FrmHotelMain;
import view.mainfrm.mainjiemian.FrmRightTopMain;
import vo.mainfrm.CsrecordVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;

/**
 * 更换房间对数据库进行的操作
 * 按钮事件有：（ 确定   取消）
 * @author 吴阿龙
 *
 */
public class LsnrChangeRoomBtn implements ActionListener {
	
	private FrmChangRoom    frmChangRoom;     // 更改房间界面
	private FrmRightTopMain frmRightTopMain;     // 房间button界面

	private MDLChangeRoom mdlChangeRoom = new MDLChangeRoom();  //更换房间的业务逻辑
	
	public LsnrChangeRoomBtn(FrmChangRoom frmChangRoom){
		this.frmChangRoom = frmChangRoom;
	}

	/**
	 * 用于确定和取消的监听事件
	 */
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(frmChangRoom.getQueDingBt().equals(o)) {
			String beforeRoomID=frmChangRoom.beforeRoom.getText();
			frmRightTopMain = new FrmRightTopMain();
			ResideVO vo1 = new ResideVO();
			RoomVO   vo2 = new RoomVO();
			CsrecordVO vo3 = new CsrecordVO();
			
			String afterRoomID  = frmChangRoom.getSomeRoom().getSelectedItem().toString();
			
			vo1.setRoomID(beforeRoomID);
			vo2.setRoomId(afterRoomID);
			
			//插入换房记录表一条信息
			String cSrecordId = HotelTools.getNumber(HotelTools.CS);
			String CustomerId = mdlChangeRoom.findCustomerId(vo1);
			vo3.setcSrecordId(cSrecordId);
			vo3.setCustomerId(CustomerId);
			vo3.setRoomId(afterRoomID);
			vo3.setBeforeRoomId(beforeRoomID);
			SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH : mm : ss ");
			try {
				vo3.setCSrecordDate(sdf.parse(FrmHotelMain.jX.getText()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			mdlChangeRoom.insertCsrecord(vo3);
			HotelTools.savNumber(cSrecordId,HotelTools.CS);
			
			//更改入住信息
			mdlChangeRoom.updateReside(vo1, afterRoomID);
			//更改房态
			vo2.setRoomStateId("RS04");
			vo2.setRoomId(beforeRoomID);
			mdlChangeRoom.updateRoomState(vo2);
			vo2.setRoomStateId("RS03");
			vo2.setRoomId(afterRoomID);
			mdlChangeRoom.updateRoomState(vo2);
			
			frmChangRoom.dispose();
			return;
		}
		else if(frmChangRoom.getQuXiaoBt().equals(o)) {
			frmChangRoom.dispose();
			return;
		}

	}

}
