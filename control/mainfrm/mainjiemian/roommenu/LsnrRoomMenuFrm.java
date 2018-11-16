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
 * ���ڷ����Ҽ���ʾ�˵��Ͳ˵�ѡ��
 * @author �Ⱒ��
 *
 */
public class LsnrRoomMenuFrm  implements ActionListener {

	private FrmRightTopMain frmRightTop;
	private FrmHotelMain frmHotelMain;
	public  static String roomID; // ���������ķ���id��������ʱ�洢
	private RoomVO vo = new RoomVO();                                    // ����VO����
	MDLChangeRoom mdlChangeRoom = new MDLChangeRoom();            //���ķ�����Ϣ��ҵ���߼�
	MDLFrmRightBott mdlFrmRightBott = new MDLFrmRightBott(); // ����������Ϣ�ͷ���״̬����ҵ���߼�
	
	public static boolean flag=true;     //�����ж��Ƿ�ͨ���Ҽ��˵�����

	public LsnrRoomMenuFrm(FrmRightTopMain frmRightTop) {
		this.frmRightTop = frmRightTop;
	}

	//����˵�������������
	@Override
	public void actionPerformed(ActionEvent e) {           
		Object o = e.getSource();
		if (frmRightTop.getMri1().equals(o)) {           // Ԥ���Ǽ�
			YuDingView yuDingView = new YuDingView(frmHotelMain, "����Ԥ������", true, "1");

			yuDingView.getTxtRoomType().setText(frmRightTop.tb_Name);
			yuDingView.getTxtRoomId().setText(roomID);
			yuDingView.getCbBoxRoomType().setEnabled(false);
			yuDingView.getCbBoxRoomId().setEnabled(false);
			yuDingView.setVisible(true);
			return;
		}
		else if (frmRightTop.getMri2().equals(o)) {           // ��ס�Ǽ�
			flag = false;
			FrmRuZhuRoom frmRuZhuRoom = new FrmRuZhuRoom(null, "��ס�Ǽ�", true, "��ס");		
//			frmRuZhuRoom.getComfjlx().removeAllItems();
//			frmRuZhuRoom.getComfjbh().removeAllItems();
			vo.setRoomId(roomID);
			String RoomStateID = mdlFrmRightBott.findOneRoomState(vo);
			if(RoomStateID.equals("RS01")) {                                 // ���δԤ��
				frmRuZhuRoom.getComfjlx().addItem(frmRightTop.tb_Name);
				frmRuZhuRoom.getComfjbh().addItem(roomID);

				String resideId = HotelTools.getNumber(HotelTools.D);
				frmRuZhuRoom.getTxtrzbh().setText(resideId);
				frmRuZhuRoom.getTxtbklx().setText("��ͨ");
				frmRuZhuRoom.getTxtbklx().setEnabled(false);
				frmRuZhuRoom.setVisible(true);	
			}else if(RoomStateID.equals("RS02")){                                                         // �����Ԥ��
				String resideId = HotelTools.getNumber(HotelTools.D);
				frmRuZhuRoom.getTxtrzbh().setText(resideId);
				
				frmRuZhuRoom.getComfjlx().removeAllItems();        //ȥ�����������
				frmRuZhuRoom.getComfjbh().removeAllItems();
				
				frmRuZhuRoom.getComfjlx().addItem(frmRightTop.tb_Name);
				frmRuZhuRoom.getComfjbh().addItem(roomID);
				
				//�˿ͻ�����Ϣ
				MDLReside mdlReside = new MDLReside();
				ReserveVO vo = new ReserveVO();
				vo.setRoomId(roomID);
				Vector v = mdlReside.findCustomerByReserve(vo);
				if(v.size()==0) {
					String msg = "�÷���Ԥ����ϢΪ�գ���ȷ���Ƿ�����";
					JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
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
					if (str[6].equals("Ů")) {
						frmRuZhuRoom.getComgkxb().removeAllItems();
						frmRuZhuRoom.getComgkxb().addItem("Ů");
						frmRuZhuRoom.getComgkxb().addItem("��");
					}
					frmRuZhuRoom.getTxtbklx().setEnabled(false);
					frmRuZhuRoom.setVisible(true);	
				}
			}
			return;
		}
		else if (frmRightTop.getMri3().equals(o)) {           // ��������
			FrmChangRoom frmChangRoom = new FrmChangRoom(frmHotelMain);  //  ���ķ���Ĵ���
			
			frmChangRoom.beforeRoom.setText(roomID); // �������䴰�ڵ�ԭ������Ϣ
			RoomTypeVO vo = new RoomTypeVO();
			vo.setRoomTypeName(frmRightTop.tb_Name); // ���÷�������

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
		else if (frmRightTop.getMri4().equals(o)) {           // ��������
			FrmConsume frmConsume = new FrmConsume(null, "��Ʒ����", true, "����");
			frmConsume.getTxtFangJianHao().setText(roomID);
			frmConsume.setVisible(true);
			return;
		}
		else if (frmRightTop.getMri5().equals(o)) {           // �˷�����
			FrmAccount frmAccount = new FrmAccount(null, "�˷�����", true);
			String jiesuanId = HotelTools.getNumber(HotelTools.AC);
			frmAccount.getTxtJieZhangDanHao().setText(jiesuanId);;
			frmAccount.getTxtZhuKeFangJian().setText(roomID);;
			frmAccount.setVisible(true);
			return;
		}
		else if (frmRightTop.getMri6().equals(o)) {           // ����
			FrmXuFang xuFang = new FrmXuFang(null, "����", true);
			ResideVO vo = new ResideVO();
			vo.setRoomID(roomID);
			MDLReside mdlReside = new MDLReside();
			String s = mdlReside.findTuiRoomTime(vo);
			FrmXuFang.ytime.setText("ԭ�˷�ʱ��Ϊ"+s);
			xuFang.setVisible(true);
			return;
		}
		else if (frmRightTop.getRtm1().equals(o)) {           // �޸ķ�̬  ���
			vo.setRoomStateId("RS01");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
//			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS01");
			frmRightTop.sxRooms();
			return;
		}
		else if (frmRightTop.getRtm2().equals(o)) {           // �޸ķ�̬
			vo.setRoomStateId("RS02");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS02");
			return;
		}
		else if (frmRightTop.getRtm3().equals(o)) {           // �޸ķ�̬
			vo.setRoomStateId("RS03");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS03");
			return;
		}
		else if (frmRightTop.getRtm4().equals(o)) {           // �޸ķ�̬
			vo.setRoomStateId("RS04");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS04");
			return;
		}
		else if (frmRightTop.getRtm5().equals(o)) {           // �޸ķ�̬
			vo.setRoomStateId("RS05");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS05");
			return;
		}
		else if (frmRightTop.getMri8().equals(o)) {           // ��ɨ�ɾ�
			vo.setRoomStateId("RS01");
			vo.setRoomId(roomID);
			mdlChangeRoom.updateRoomState(vo);
			FrmRightTopMain.setViewListButtonImage(frmRightTop.tb_Name, roomID,"RS01");
			return;
		}
		else if (frmRightTop.getMri9().equals(o)) {           // ���ɱ���
			 
				//JxlTool tool=new JxlTool();
				JTable table=FrmRightBottMain.getTblConsum();
				JFileChooser fcsSave = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "XLS ������", "xlsx");
			    
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
