package control.mainfrm.mainjiemian.roommenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import common.component.tools.HotelTools;
import common.component.tools.JxlTool;
import control.mainfrm.residefrm.LsnrResideFrmBtn;
import model.mainfrm.changeroomfrm.MDLChangeRoom;
import model.mainfrm.mainjiemian.rightbottfrm.MDLFrmRightBott;
import model.mainfrm.residefrm.MDLReside;

import view.mainfrm.YuDing.YuDingView;
import view.mainfrm.account.FrmAccount;
import view.mainfrm.changeroom.FrmChangRoom;
import view.mainfrm.consume.FrmConsume;
import view.mainfrm.mainjiemian.FrmHotelMain;
import view.mainfrm.mainjiemian.FrmRightBottMain;
import view.mainfrm.mainjiemian.FrmRightTopMain;
import view.mainfrm.mainjiemian.FrmXuFang;
import view.mainfrm.reside.FrmRuZhuRoom;
import vo.mainfrm.ReserveVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomTypeVO;
import vo.mainfrm.RoomVO;

/**
 * 用于房间右键显示菜单和菜单选项
 * @author 吴阿龙
 *
 */
public class LsnrRoomMenuFrm  implements ActionListener {

	private FrmRightTopMain frmRightTop;
	private FrmHotelMain frmHotelMain;
	public  static String roomID; // 鼠标所点击的房间id，进行暂时存储
	private RoomVO vo = new RoomVO();                                    // 房间VO对象
	MDLChangeRoom mdlChangeRoom = new MDLChangeRoom();            //更改房间信息的业务逻辑
	MDLFrmRightBott mdlFrmRightBott = new MDLFrmRightBott(); // 房间消费信息和房间状态查找业务逻辑
	
	public static boolean flag=true;     //用于判定是否通过右键菜单进入

	public LsnrRoomMenuFrm(FrmRightTopMain frmRightTop) {
		this.frmRightTop = frmRightTop;
	}

	//房间菜单动作监听机制
	@Override
	public void actionPerformed(ActionEvent e) {           
		Object o = e.getSource();
		if (frmRightTop.getMri1().equals(o)) {           // 预定登记
			YuDingView yuDingView = new YuDingView(frmHotelMain, "宾客预订房间", true, "1");

			yuDingView.getTxtRoomType().setText(frmRightTop.tb_Name);
			yuDingView.getTxtRoomId().setText(roomID);
			yuDingView.getCbBoxRoomType().setEnabled(false);
			yuDingView.getCbBoxRoomId().setEnabled(false);
			yuDingView.setVisible(true);
			return;
		}
		else if (frmRightTop.getMri2().equals(o)) {           // 入住登记
			flag = false;
			FrmRuZhuRoom frmRuZhuRoom = new FrmRuZhuRoom(null, "入住登记", true, "入住");		
//			frmRuZhuRoom.getComfjlx().removeAllItems();
//			frmRuZhuRoom.getComfjbh().removeAllItems();
			vo.setRoomId(roomID);
			String RoomStateID = mdlFrmRightBott.findOneRoomState(vo);
			if(RoomStateID.equals("RS01")) {                                 // 如果未预定
				frmRuZhuRoom.getComfjlx().addItem(frmRightTop.tb_Name);
				frmRuZhuRoom.getComfjbh().addItem(roomID);

				String resideId = HotelTools.getNumber(HotelTools.D);
				frmRuZhuRoom.getTxtrzbh().setText(resideId);
				frmRuZhuRoom.getTxtbklx().setText("普通");
				frmRuZhuRoom.getTxtbklx().setEnabled(false);
				frmRuZhuRoom.setVisible(true);	
			}else if(RoomStateID.equals("RS02")){                                                         // 如果已预订
				String resideId = HotelTools.getNumber(HotelTools.D);
				frmRuZhuRoom.getTxtrzbh().setText(resideId);
				
				frmRuZhuRoom.getComfjlx().removeAllItems();        //去除房间的属性
				frmRuZhuRoom.getComfjbh().removeAllItems();
				
				frmRuZhuRoom.getComfjlx().addItem(frmRightTop.tb_Name);
				frmRuZhuRoom.getComfjbh().addItem(roomID);
				
				//顾客基本信息
				MDLReside mdlReside = new MDLReside();
				ReserveVO vo = new ReserveVO();
				vo.setRoomId(roomID);
				Vector v = mdlReside.findCustomerByReserve(vo);
				if(v.size()==0) {
					String msg = "该房间预订信息为空，请确认是否有误";
					JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
				}else {
					String[] str = new String[7];
					int i=0;
					for (Iterator it = v.iterator(); it.hasNext();) {
						str[i] = (String) it.next();
						i++;					
					}
					LsnrResideFrmBtn.flag=true;
					LsnrResideFrmBtn.CustID=str[0];

					LsnrResideFrmBtn.MemberID=str[2];
					frmRuZhuRoom.getTxtbkxm().setText(str[1]);
					frmRuZhuRoom.getTxtbklx().setText(str[3]);
					frmRuZhuRoom.getTxtlxdh().setText(str[4]);
					frmRuZhuRoom.getTxtsfz().setText(str[5]);
					if (str[6].equals("女")) {
						frmRuZhuRoom.getComgkxb().removeAllItems();
						frmRuZhuRoom.getComgkxb().addItem("女");
						frmRuZhuRoom.getComgkxb().addItem("男");
					}
					frmRuZhuRoom.getTxtbklx().setEnabled(false);
					frmRuZhuRoom.setVisible(true);	
				}
			}
			return;
		}
		else if (frmRightTop.getMri3().equals(o)) {           // 更换房间
			FrmChangRoom frmChangRoom = new FrmChangRoom(frmHotelMain);  //  更改房间的窗口
			
			frmChangRoom.beforeRoom.setText(roomID); // 更换房间窗口的原房间信息
			RoomTypeVO vo = new RoomTypeVO();
			vo.setRoomTypeName(frmRightTop.tb_Name); // 设置房间类型

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
		else if (frmRightTop.getMri4().equals(o)) {           // 增加消费
			FrmConsume frmConsume = new FrmConsume(null, "商品消费", true, "消费");
			frmConsume.getTxtFangJianHao().setText(roomID);
			frmConsume.setVisible(true);
			return;
		}
		else if (frmRightTop.getMri5().equals(o)) {           // 退房结账
			FrmAccount frmAccount = new FrmAccount(null, "退房结算", true);
			String jiesuanId = HotelTools.getNumber(HotelTools.AC);
			frmAccount.getTxtJieZhangDanHao().setText(jiesuanId);;
			frmAccount.getTxtZhuKeFangJian().setText(roomID);;
			frmAccount.setVisible(true);
			return;
		}
		else if (frmRightTop.getMri6().equals(o)) {           // 续房
			FrmXuFang xuFang = new FrmXuFang(null, "续房", true);
			ResideVO vo = new ResideVO();
			vo.setRoomID(roomID);
			MDLReside mdlReside = new MDLReside();
			String s = mdlReside.findTuiRoomTime(vo);
			FrmXuFang.ytime.setText("原退房时间为"+s);
			xuFang.setVisible(true);
			return;
		}
		else if (frmRightTop.getRtm1().equals(o)) {           // 修改房态  清洁
			vo.setRoomStateId("RS01");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
//			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS01");
			frmRightTop.sxRooms();
			return;
		}
		else if (frmRightTop.getRtm2().equals(o)) {           // 修改房态
			vo.setRoomStateId("RS02");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS02");
			return;
		}
		else if (frmRightTop.getRtm3().equals(o)) {           // 修改房态
			vo.setRoomStateId("RS03");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS03");
			return;
		}
		else if (frmRightTop.getRtm4().equals(o)) {           // 修改房态
			vo.setRoomStateId("RS04");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS04");
			return;
		}
		else if (frmRightTop.getRtm5().equals(o)) {           // 修改房态
			vo.setRoomStateId("RS05");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS05");
			return;
		}
		else if (frmRightTop.getMri8().equals(o)) {           // 打扫干净
			vo.setRoomStateId("RS01");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS01");
			return;
		}
		else if (frmRightTop.getMri9().equals(o)) {           // 生成报表
			 
				//JxlTool tool=new JxlTool();
				JTable table=FrmRightBottMain.getTblConsum();
				JFileChooser fcsSave = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "XLS 工作表", "xlsx");
			    
			    fcsSave.setFileFilter(filter);
			    int value = fcsSave.showSaveDialog(FrmRightBottMain.getTblConsum());
			    if(value == JFileChooser.APPROVE_OPTION) {
			      File file = fcsSave.getSelectedFile();
	
					try {
						JxlTool.exportTable(table, file);
					} catch (IOException eq) {
						eq.printStackTrace();
					}
			    }		
			}

			return;
		}
}
