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
 * ������������ݿ���еĲ���
 * ��ť�¼��У��� ȷ��   ȡ����
 * @author �Ⱒ��
 *
 */
public class LsnrChangeRoomBtn implements ActionListener {
	
	private FrmChangRoom    frmChangRoom;     // ���ķ������
	private FrmRightTopMain frmRightTopMain;     // ����button����

	private MDLChangeRoom mdlChangeRoom = new MDLChangeRoom();  //���������ҵ���߼�
	
	public LsnrChangeRoomBtn(FrmChangRoom frmChangRoom){
		this.frmChangRoom = frmChangRoom;
	}

	/**
	 * ����ȷ����ȡ���ļ����¼�
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
			
			//���뻻����¼��һ����Ϣ
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
			
			//������ס��Ϣ
			mdlChangeRoom.updateReside(vo1, afterRoomID);
			//���ķ�̬
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
