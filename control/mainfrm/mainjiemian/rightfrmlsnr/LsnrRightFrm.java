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
 * ���Ϸ�������Ϣ����ʾ������
 * @author �Ⱒ��
 *
 */
public class LsnrRightFrm implements ActionListener {
	private FrmRightTopMain frmRightTop;

	/**
	 * ���캯��
	 * @param frmRightTop   ���Ϸ������
	 */
	public LsnrRightFrm(FrmRightTopMain frmRightTop) {
		this.frmRightTop = frmRightTop;
	}

	/**
	 * �жϴ����İ�ť����ִ�����Ӧ���¼�
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == frmRightTop.getRtbt2()) {
			frmRightTop.setSqlProviso("");
			frmRightTop.sxRooms(); // �ؽ���ǩ��
			return;
		} else if (o == frmRightTop.getRtbt3()) { // ˢ��
			frmRightTop.remove(frmRightTop.getPrm());
			frmRightTop.sxRooms(); // �ؽ���ǩ��
			//ˢ�·��乩Ӧ״̬
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
		} else if (o == frmRightTop.getMi1()) { // ��ʾ�ɹ�
			frmRightTop.setSqlProviso(" and Roomstate_id='RS01'");
			frmRightTop.sxRooms(); // �ؽ���ǩ��
			return;
		} else if (o == frmRightTop.getMi2()) { // ��ʾԤ��
			frmRightTop.setSqlProviso(" and Roomstate_id='RS02'");
			frmRightTop.sxRooms(); // �ؽ���ǩ��
			return;
		} else if (o == frmRightTop.getMi3()) { // ��ʾռ��
			frmRightTop.setSqlProviso(" and Roomstate_id='RS03'");
			frmRightTop.sxRooms(); // �ؽ���ǩ��
			return;
		} else if (o == frmRightTop.getMi4()) { // ��ʾά��
			frmRightTop.setSqlProviso(" and Roomstate_id='RS05'");
			frmRightTop.sxRooms(); // �ؽ���ǩ��
			return;
		} else if (o == frmRightTop.getMi5()) { // ��ʾ�෿
			frmRightTop.setSqlProviso(" and Roomstate_id='RS04'");
			frmRightTop.sxRooms(); // �ؽ���ǩ��
			return;
		}else if(o == frmRightTop.getTub1()) {   //Сͼ��
			ViewList.column = 10;
			ViewList.row = 4;
			frmRightTop.sxRooms();
			return;
		}else if(o == frmRightTop.getTub2()) {   //��ͼ��
			ViewList.column = 6;
			ViewList.row = 6;
			frmRightTop.sxRooms();
			return;
		}else if(o == frmRightTop.getTub3()) {   //��ͼ��	
			ViewList.column = 5;
			ViewList.row = 8;
			frmRightTop.sxRooms();
			return;
		}

		// ˢ����������ߵ���Ϣ
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
		
		//ˢ�����·����������
		MDLFrmRightBott mdlFrmRightBott = new MDLFrmRightBott();
		Vector resultv = mdlFrmRightBott.findRoomConsumMessage(vo1);

		//ˢ��JTable
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
