package control.mainback.lsnBackMainView.lsnRoomType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import view.backmain.BackMainView.BackMainView;
import view.backmain.BackMainView.addRoomType.AddRoomTypeView;


/**
 * ��������ģ�� ��Ӻ��޸� �������Ͱ�ť������
 * 
 * @author �ź�
 * @date 2018.10.25
 * 
 * 
 **/
public class LsnrRoomTypeAddBtn implements ActionListener {
	private BackMainView bw;

	public LsnrRoomTypeAddBtn(BackMainView bw) {
		this.bw = bw;
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("��ӷ�������")) {
			AddRoomTypeView aw = new AddRoomTypeView(this.bw, "��ӷ�������", true, "1");
			//Ĭ�ϼ۸�800
			aw.getTxtRoomPrice().setText("888");
			aw.setVisible(true);
		    
		} else {
			AddRoomTypeView aw = new AddRoomTypeView(this.bw, "�޸ķ�������", true, "2");
			JTable RoomTable = bw.getTblRoom();
			int row = RoomTable.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this.bw, "  ��ѡ��һ�����ݣ�","������ʾ",1);
			} else {
				aw.getTxtRoomTypeId().setText((String) RoomTable.getValueAt(row, 0));
				aw.getTxtRoomTypeName().setText((String) RoomTable.getValueAt(row, 1));
				aw.getTxtRoomPrice().setText("" + RoomTable.getValueAt(row, 2));
				aw.setVisible(true);
			}
		}

	}

}
