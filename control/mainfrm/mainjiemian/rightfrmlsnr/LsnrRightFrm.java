package control.mainfrm.mainjiemian.rightfrmlsnr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import org.omg.Messaging.SyncScopeHelper;

import common.component.swings.ViewList;
import control.mainfrm.mainjiemian.roommenu.LsnrRightMenu;
import model.mainfrm.mainjiemian.lefttopfrm.MDLFrmLeftTop;
import model.mainfrm.mainjiemian.rightbottfrm.MDLFrmRightBott;
import view.mainfrm.mainjiemian.FrmLeftTopMain;
import view.mainfrm.mainjiemian.FrmRightBottMain;
import view.mainfrm.mainjiemian.FrmRightTopMain;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;
/**
 * 右上方房间信息的显示监听器
 * @author 吴阿龙
 *
 */
public class LsnrRightFrm implements ActionListener {
	private FrmRightTopMain frmRightTop;

	/**
	 * 构造函数
	 * @param frmRightTop   右上方的面板
	 */
	public LsnrRightFrm(FrmRightTopMain frmRightTop) {
		this.frmRightTop = frmRightTop;
	}

	/**
	 * 判断触发的按钮，并执行相对应的事件
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == frmRightTop.getRtbt2()) {
			frmRightTop.setSqlProviso("");
			frmRightTop.sxRooms(); // 重建标签栏
			return;
		} else if (o == frmRightTop.getRtbt3()) { // 刷新
			frmRightTop.remove(frmRightTop.getPrm());
			frmRightTop.sxRooms(); // 重建标签栏
			//刷新房间供应状态
			RoomVO vo = new RoomVO();
			vo.setRoomStateId("");
			MDLFrmLeftTop mdlFrmLeftTop = new MDLFrmLeftTop();
			String[] obj1 = mdlFrmLeftTop.findRoomCount(vo);
			FrmLeftTopMain.lt[8].setText(obj1[0]);
			// System.out.println(lt[8].getText());
			vo.setRoomStateId("RS01");
			String[] obj2 = mdlFrmLeftTop.findRoomCount(vo);
			FrmLeftTopMain.lt[9].setText(obj2[0]);
			vo.setRoomStateId("RS02");
			String[] obj3 = mdlFrmLeftTop.findRoomCount(vo);
			FrmLeftTopMain.lt[10].setText(obj3[0]);
			vo.setRoomStateId("RS03");
			String[] obj4 = mdlFrmLeftTop.findRoomCount(vo);
			FrmLeftTopMain.lt[11].setText(obj4[0]);
			vo.setRoomStateId("RS04");
			String[] obj5 = mdlFrmLeftTop.findRoomCount(vo);
			FrmLeftTopMain.lt[12].setText(obj5[0]);
			vo.setRoomStateId("RS05");
			String[] obj6 = mdlFrmLeftTop.findRoomCount(vo);
			FrmLeftTopMain.lt[13].setText(obj6[0]);
			LsnrRightMenu.RId = null;
			return;
		} else if (o == frmRightTop.getMi1()) { // 显示可供
			frmRightTop.setSqlProviso(" and Roomstate_id='RS01'");
			frmRightTop.sxRooms(); // 重建标签栏
			return;
		} else if (o == frmRightTop.getMi2()) { // 显示预定
			frmRightTop.setSqlProviso(" and Roomstate_id='RS02'");
			frmRightTop.sxRooms(); // 重建标签栏
			return;
		} else if (o == frmRightTop.getMi3()) { // 显示占用
			frmRightTop.setSqlProviso(" and Roomstate_id='RS03'");
			frmRightTop.sxRooms(); // 重建标签栏
			return;
		} else if (o == frmRightTop.getMi4()) { // 显示维护
			frmRightTop.setSqlProviso(" and Roomstate_id='RS05'");
			frmRightTop.sxRooms(); // 重建标签栏
			return;
		} else if (o == frmRightTop.getMi5()) { // 显示脏房
			frmRightTop.setSqlProviso(" and Roomstate_id='RS04'");
			frmRightTop.sxRooms(); // 重建标签栏
			return;
		}else if(o == frmRightTop.getTub1()) {   //小图标
			ViewList.column = 10;
			ViewList.row = 4;
			frmRightTop.sxRooms();
			return;
		}else if(o == frmRightTop.getTub2()) {   //中图标
			ViewList.column = 6;
			ViewList.row = 6;
			frmRightTop.sxRooms();
			return;
		}else if(o == frmRightTop.getTub3()) {   //大图标	
			ViewList.column = 5;
			ViewList.row = 8;
			frmRightTop.sxRooms();
			return;
		}

		// 刷新主窗口左边的信息
		String chooseRoomNum = ((JButton) o).getText();
		FrmLeftTopMain.title0.setText(frmRightTop.tb_Name + ": ");
		FrmLeftTopMain.title1.setText(chooseRoomNum);
		
		ResideVO vo1 = new ResideVO();
		CustomerVO vo2 = new CustomerVO();
		MDLFrmLeftTop mdlFrmLeftTop = new MDLFrmLeftTop();
		vo1.setRoomID(chooseRoomNum);

		Vector v = mdlFrmLeftTop.findResideMessage(vo1, vo2);
		int i=0;

		if(v.size() !=0) {
			for (Iterator it = v.iterator(); it.hasNext();) {
				String Str = (String) it.next();			
				FrmLeftTopMain.lt[i].setText(Str);	
				i++;
			}	
		}else {
			for(int j=0;j<8;j++) {
				FrmLeftTopMain.lt[j].setText("");
			}
		}
		
		//刷新右下方的消费情况
		MDLFrmRightBott mdlFrmRightBott = new MDLFrmRightBott();
		Vector resultv = mdlFrmRightBott.findRoomConsumMessage(vo1);

		//刷新JTable
	    //FrmRightBottMain frmRightBott = new FrmRightBottMain();
		Object[] consumColumnNames = FrmRightBottMain.getConsumColumnNames();

		Vector columnNamesV = new Vector();
		for(int k=0; k < consumColumnNames.length; k++) {
			columnNamesV.add(consumColumnNames[k]);
		}

		FrmRightBottMain.getTblConsum().setModel(
			new DefaultTableModel(resultv, columnNamesV));
	}
	
}
