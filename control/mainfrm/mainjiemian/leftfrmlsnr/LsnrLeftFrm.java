package control.mainfrm.mainjiemian.leftfrmlsnr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.mainfrm.mainjiemian.lefttopfrm.MDLFrmLeftTop;
import model.mainfrm.mainjiemian.rightbottfrm.MDLFrmRightBott;
import view.mainfrm.mainjiemian.FrmLeftBottMain;
import view.mainfrm.mainjiemian.FrmLeftTopMain;
import view.mainfrm.mainjiemian.FrmRightBottMain;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;
/**
 * �����ļ�������
 * ���ܣ� ���ڿ�������ʱ���ҷ����Ӧ����Ϣ
 * @author �Ⱒ��
 *
 */
public class LsnrLeftFrm implements ActionListener {

	private FrmLeftBottMain frmLeftBott;

	public LsnrLeftFrm(FrmLeftBottMain frmLeftBott) {
		this.frmLeftBott = frmLeftBott;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String roomid = frmLeftBott.getTf().getText();

		ResideVO vo1 = new ResideVO();
		CustomerVO vo2 = new CustomerVO();
		RoomVO vo3 = new RoomVO();
		MDLFrmLeftTop mdlFrmLeftTop = new MDLFrmLeftTop();  //��ߵ�ҵ���߼���
		vo1.setRoomID("R" + roomid);
		vo3.setRoomId("R" + roomid);
		
		boolean flag = mdlFrmLeftTop.findRoomExits(vo3);
		if(flag == true) {
			FrmLeftTopMain.title1.setText("R" + roomid);   //������������ݿ��д�������ʾ����
		}else {
			FrmLeftTopMain.title1.setText("");
		}
		
		Vector v = mdlFrmLeftTop.findResideMessage(vo1, vo2);
		int i = -1;
		
		if (v.size() != 0) {
			for (Iterator it = v.iterator(); it.hasNext();) {
				i++;
				String str = (String) it.next();
				FrmLeftTopMain.lt[i].setText(str);
			}
		} else {
			for (int j = 0; j < 8; j++) {
				FrmLeftTopMain.lt[j].setText("");
			}
		}

		// ˢ�����·����������
		MDLFrmRightBott mdlFrmRightBott = new MDLFrmRightBott();
		Vector resultv = mdlFrmRightBott.findRoomConsumMessage(vo1);

		// ˢ��JTable
		// FrmRightBottMain frmRightBott = new FrmRightBottMain();
		Object[] consumColumnNames = FrmRightBottMain.getConsumColumnNames();

		Vector columnNamesV = new Vector();
		for (int k = 0; k < consumColumnNames.length; k++) {
			columnNamesV.add(consumColumnNames[k]);
		}

		FrmRightBottMain.getTblConsum().setModel(new DefaultTableModel(resultv, columnNamesV));

	}
}
