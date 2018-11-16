package control.mainfrm.mainjiemian.roommenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.mainfrm.mainjiemian.rightbottfrm.MDLFrmRightBott;
import view.mainfrm.mainjiemian.FrmRightTopMain;
import vo.mainfrm.RoomVO;

public class LsnrRightMenu extends MouseAdapter {
	private FrmRightTopMain frmRightTop;
	public static String RId;
	
	private RoomVO vo = new RoomVO();                                    // 房间VO对象
	MDLFrmRightBott mdlFrmRightBott = new MDLFrmRightBott(); // 房间消费信息和房间状态查找业务逻辑
	
	public LsnrRightMenu(FrmRightTopMain frmRightTop) {
		this.frmRightTop = frmRightTop;
	}
	// 鼠标监听
	public void mouseClicked(MouseEvent me) {
		frmRightTop.remove(frmRightTop.getPrm());
		Object o = me.getSource();

		String chooseRoomNum = ((JButton) o).getText(); // 获取按钮的房间id
		RId = chooseRoomNum;
		LsnrRoomMenuFrm.roomID = chooseRoomNum; // 将按钮的房间id

//		System.out.println(frmRightTop.tb_Name);
//		System.out.println(chooseRoomNum);
//		System.out.println(FrmRightTopMain.getViewListButton(frmRightTop.getTb_Name(), chooseRoomNum).getLocation());
		if (me.getButton() == MouseEvent.BUTTON3) { // 鼠标右键显示菜单信息
			int x = me.getX();
			int y = me.getY();
			frmRightTop.getPrm().setPopupSize(120, 260);
			if(FrmRightTopMain.getViewListButton(frmRightTop.getTb_Name(), chooseRoomNum)==null) {
				JOptionPane.showMessageDialog(frmRightTop, "请重新点击下房间按钮");
				return;
			}
			frmRightTop.getPrm().show(FrmRightTopMain.getViewListButton(frmRightTop.getTb_Name(), chooseRoomNum), x, y);
			vo.setRoomId(chooseRoomNum); // 设置房间名

			String roomST = mdlFrmRightBott.findOneRoomState(vo); // 查找房间状态

			if (roomST.equals("RS01")) { // 对应房间状态显示不同的选项
				frmRightTop.getMri1().setEnabled(true);
				frmRightTop.getMri2().setEnabled(true);
				frmRightTop.getMri3().setEnabled(false);
				frmRightTop.getMri4().setEnabled(false);
				frmRightTop.getMri5().setEnabled(false);
				frmRightTop.getMri6().setEnabled(false);
				frmRightTop.getMri7().setEnabled(true);
				frmRightTop.getMri8().setEnabled(false);
				frmRightTop.getMri9().setEnabled(true);
				frmRightTop.getRtm1().setEnabled(false);
				frmRightTop.getRtm2().setEnabled(true);
				frmRightTop.getRtm3().setEnabled(true);
				frmRightTop.getRtm4().setEnabled(true);
				frmRightTop.getRtm5().setEnabled(true);
				return;
			} else if (roomST.equals("RS02")) {
				frmRightTop.getMri1().setEnabled(false);
				frmRightTop.getMri2().setEnabled(true);
				frmRightTop.getMri3().setEnabled(false);
				frmRightTop.getMri4().setEnabled(false);
				frmRightTop.getMri5().setEnabled(false);
				frmRightTop.getMri6().setEnabled(false);
				frmRightTop.getMri7().setEnabled(true);
				frmRightTop.getMri8().setEnabled(false);
				frmRightTop.getMri9().setEnabled(false);
				frmRightTop.getRtm1().setEnabled(true);
				frmRightTop.getRtm2().setEnabled(false);
				frmRightTop.getRtm3().setEnabled(true);
				frmRightTop.getRtm4().setEnabled(true);
				frmRightTop.getRtm5().setEnabled(true);
			} else if (roomST.equals("RS04")) {
				frmRightTop.getMri1().setEnabled(false);
				frmRightTop.getMri2().setEnabled(false);
				frmRightTop.getMri3().setEnabled(false);
				frmRightTop.getMri4().setEnabled(false);
				frmRightTop.getMri5().setEnabled(false);
				frmRightTop.getMri6().setEnabled(false);
				frmRightTop.getMri7().setEnabled(true);
				frmRightTop.getMri8().setEnabled(true);
				frmRightTop.getMri9().setEnabled(true);
				frmRightTop.getRtm1().setEnabled(true);
				frmRightTop.getRtm2().setEnabled(true);
				frmRightTop.getRtm3().setEnabled(true);
				frmRightTop.getRtm4().setEnabled(false);
				frmRightTop.getRtm5().setEnabled(true);
			} else if (roomST.equals("RS05")) {
				frmRightTop.getMri1().setEnabled(false);
				frmRightTop.getMri2().setEnabled(false);
				frmRightTop.getMri3().setEnabled(false);
				frmRightTop.getMri4().setEnabled(false);
				frmRightTop.getMri5().setEnabled(false);
				frmRightTop.getMri6().setEnabled(false);
				frmRightTop.getMri7().setEnabled(true);
				frmRightTop.getMri8().setEnabled(false);
				frmRightTop.getMri9().setEnabled(false);
				frmRightTop.getRtm1().setEnabled(true);
				frmRightTop.getRtm2().setEnabled(true);
				frmRightTop.getRtm3().setEnabled(true);
				frmRightTop.getRtm4().setEnabled(true);
				frmRightTop.getRtm5().setEnabled(false);
			} else if (roomST.equals("RS03")){
				frmRightTop.getMri1().setEnabled(false);
				frmRightTop.getMri2().setEnabled(false);
				frmRightTop.getMri3().setEnabled(true);
				frmRightTop.getMri4().setEnabled(true);
				frmRightTop.getMri5().setEnabled(true);
				frmRightTop.getMri6().setEnabled(true);
				frmRightTop.getMri7().setEnabled(true);
				frmRightTop.getMri8().setEnabled(false);
				frmRightTop.getMri9().setEnabled(true);
				frmRightTop.getRtm1().setEnabled(true);
				frmRightTop.getRtm2().setEnabled(true);
				frmRightTop.getRtm3().setEnabled(false);
				frmRightTop.getRtm4().setEnabled(true);
				frmRightTop.getRtm5().setEnabled(true);
			}
			return;
		}
	}

}
