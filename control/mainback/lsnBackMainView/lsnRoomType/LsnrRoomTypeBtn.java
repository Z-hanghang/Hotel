package control.mainback.lsnBackMainView.lsnRoomType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.mainbackfrm.Roomtype.MDLRoomType;
import view.backmain.BackMainView.BackMainView;
import vo.mainback.Roomvo;



/**
 * �������͹����������Һ�ɾ��btn
 */
public class LsnrRoomTypeBtn implements ActionListener {

	private BackMainView bw;

	public LsnrRoomTypeBtn(BackMainView bw) {
		this.bw = bw;
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		MDLRoomType mdlRoom = new MDLRoomType();
		Roomvo room = new Roomvo();
		JRadioButton ckbRoomName = bw.getCkbRoomName();
		JRadioButton ckbRoomPrice = bw.getCkbRoomPrice();
		JTextField txtRoomPrice1 = bw.getTxtRoomPrice1();
		JTextField txtRoomPrice2 = bw.getTxtRoomPrice2();
		JTextField txtRoomName = bw.getTxtRoomName();
		if (s.equals("ȫ����Ϣ")) {
			//��ѯ����
			flushTable(mdlRoom.SelectAllRoom());
		} else if (s.equals("��  ��")) {
			if (ckbRoomName.isSelected()) {
				//���Ʊ�ѡ��ʱ��
				txtRoomPrice1.setText("");
				txtRoomPrice2.setText("");
				if (txtRoomName.getText().equals("")) {
					JOptionPane.showMessageDialog(this.bw, "�����뷿����������","������ʾ",1);
				} else {
					room.setRoomtypename(txtRoomName.getText());
					flushTable(mdlRoom.SelectRoomTypeName(room));

				}
			} else if (ckbRoomPrice.isSelected()) {
				//�۸�ѡ��ʱ��
				txtRoomName.setText("");
				String s1 = txtRoomPrice1.getText();
				String s2 = txtRoomPrice2.getText();
				if ((!s1.equals(""))&&(!s2.equals(""))) {
					int a = Integer.parseInt(s1);
					int b = Integer.parseInt(s2);
					if(a<=b){
						flushTable(mdlRoom.SelectRoomPrice(s1, s2));
					}else{
						flushTable(mdlRoom.SelectRoomPrice(s2, s1));
					}
				}else {
					JOptionPane.showMessageDialog(this.bw, "�����뷿��۸���ң�","������ʾ",1);
					
				} 

			} else {
				JOptionPane.showMessageDialog(this.bw, "��ѡ��һ�����ͣ�","������ʾ",1);
			}

		} else if (s.equals("ɾ����������")) {
			JTable TblLog = bw.getTblRoom();
			int row = TblLog.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this.bw, "   ��ѡ��һ�����ݣ�","������ʾ",1);
			} else {
				int option = JOptionPane.showConfirmDialog(this.bw, "ȷ��ɾ���÷���������?", "������ʾ", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					room.setRoomtypeid((String) TblLog.getValueAt(row, 0));
					mdlRoom.DeleteRoomType(room);
					flushTable(mdlRoom.SelectAllRoom());
				}
			}

		}else if(ckbRoomName.isSelected()){
			//���Ʊ�ѡ��ʱ��
			txtRoomPrice1.setText("");
			txtRoomPrice2.setText("");
			txtRoomName.requestFocus();
			
		}else if(ckbRoomPrice.isSelected()){
			//�۸�ѡ��ʱ��
			txtRoomName.setText("");
			
			txtRoomPrice1.requestFocus();
		}

	}

	// ˢ�·���
	private void flushTable(Vector resultVector) {
		Object[] RoomColumnNames = bw.getRoomColumnNames();
		Vector columnNamesV = new Vector();
		for (Object temp : RoomColumnNames) {
			columnNamesV.add(temp);
		}
		bw.getTblRoom().setModel(new DefaultTableModel(resultVector, columnNamesV));

	}
}
