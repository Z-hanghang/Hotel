package control.mainback.lsnBackMainView.lsnRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.mainbackfrm.room.mdlRoom;
import view.backmain.BackMainView.BackMainView;
import view.backmain.BackMainView.addRoomView.AddRoomView;
import vo.mainback.Roomvo;

/**
 * ���������� �����ť������
 * 
 * @author �ź�
 * @date 2018.10.29
 * 
 **/
public class LsnrRoombtn implements ActionListener {

	private BackMainView bw;

	public LsnrRoombtn(BackMainView bw) {
		this.bw = bw;
	}

	public void actionPerformed(ActionEvent e) {
		// ��ȡ������������
		Object t = e.getSource();
		// ������
		JTable TblRoom = bw.getTblRToom();
		// ���췿�����
		Roomvo room = new Roomvo();
		// ���뷿�䴦���߼�ҵ��
		mdlRoom mdlRoom = new mdlRoom();
		//��ѡ��
		JRadioButton ckbRoomId=bw.getCkbRToomID();
		JRadioButton ckbRoomTypeName=bw.getCkbRToomType();
		
		JTextField txtRoomId=bw.getTxtRToomID();
		JTextField txtRoomType=bw.getTxtRToomType();
		
		if (t.equals(bw.getBtnAllRToom())) {
			// ��ѯ���з��䰴ť
			 flushRoomTable(mdlRoom.selectAllRoom());

		}
		if (t.equals(bw.getBtnAddRToom())) {
			// ��ӷ��䰴ť
			new AddRoomView(this.bw, "��ӷ���", true, "1").setVisible(true);

		}
		if (t.equals(bw.getBtnSelectRToom())) {
			// �����Ͳ�ѯ���䰴ť
			if(ckbRoomId.isSelected()){
				if(!txtRoomId.getText().equals("")){
					room.setRoomid(txtRoomId.getText());
					flushRoomTable(mdlRoom.selectRoomId(room));
				}else{
					JOptionPane.showMessageDialog(bw, "�������磨R101���ķ���Ž��в���","������ʾ",1);
				}
			}if(ckbRoomTypeName.isSelected()){
				if(!txtRoomType.getText().equals("")){
					room.setRoomtypename(txtRoomType.getText());
					flushRoomTable(mdlRoom.selectRoomTypeName(room));
				}else{
					JOptionPane.showMessageDialog(bw, "�������磨���˼䣩�ķ������ƽ��в���","������ʾ",1);
				}
			}else if(!ckbRoomId.isSelected()&&!ckbRoomTypeName.isSelected()){
				JOptionPane.showMessageDialog(bw, "��ѡ�����ͺ���в���","������ʾ",2);
			}

		}
		if (t.equals(bw.getBtnDeleteRToom())) {
			// ɾ�����䰴ť
			int row = TblRoom.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this.bw, "  ��ѡ��һ�����ݣ�","������ʾ",1);
			} else {
				int option = JOptionPane.showConfirmDialog(this.bw, "ȷ��ɾ���÷�����", "������ʾ", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					 room.setRoomid((String)TblRoom.getValueAt(row, 0));
					 //ɾ��
                     mdlRoom.deleteRoom(room);
                     JOptionPane.showMessageDialog(this.bw, "��ϲɾ���ɹ���","������ʾ",1);
                     //ˢ��
                     flushRoomTable(mdlRoom.selectAllRoom());
				}
			}

		}
		if (t.equals(bw.getBtnUpdateRToom())) {
			// �޸ķ��䰴ť
			AddRoomView aw = new AddRoomView(this.bw, "�޸ķ���", true, "2");
			int row = TblRoom.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this.bw, "  ��ѡ��һ�����ݣ�");
			} else {
				aw.getTxtRoomId().setText((String) TblRoom.getValueAt(row, 0));
				aw.getTxtRoomTypeName().setText((String) TblRoom.getValueAt(row, 1));
				aw.getTxtRoomPrice().setText((String) TblRoom.getValueAt(row, 2));
				aw.getTxtRoomNumber().setText((String) TblRoom.getValueAt(row, 3));
				aw.getTxtRoomFloor().setText((String) TblRoom.getValueAt(row, 4));
				aw.setVisible(true);
			}
		}

	}
	
	 //ˢ�·����
    private void flushRoomTable(Vector resultVector) {
    	Object[] RoomColumnNames = bw.getRToomColumnNames();
    	Vector columnNamesV = new Vector();
    	for (Object temp : RoomColumnNames) {
    		columnNamesV.add(temp);
    	}
    	bw.getTblRToom().setModel(new DefaultTableModel(resultVector, columnNamesV));
    	
    }	

}
