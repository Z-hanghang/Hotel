package control.mainback.lsnBackMainView.lsnRoomType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import view.backmain.BackMainView.BackMainView;
import view.backmain.BackMainView.addRoomType.AddRoomTypeView;


/**
 * 房间类型模块 添加和修改 房间类型按钮监听器
 * 
 * @author 张航
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
		if (s.equals("添加房间类型")) {
			AddRoomTypeView aw = new AddRoomTypeView(this.bw, "添加房间类型", true, "1");
			//默认价格800
			aw.getTxtRoomPrice().setText("888");
			aw.setVisible(true);
		    
		} else {
			AddRoomTypeView aw = new AddRoomTypeView(this.bw, "修改房间类型", true, "2");
			JTable RoomTable = bw.getTblRoom();
			int row = RoomTable.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this.bw, "  请选中一行数据！","温情提示",1);
			} else {
				aw.getTxtRoomTypeId().setText((String) RoomTable.getValueAt(row, 0));
				aw.getTxtRoomTypeName().setText((String) RoomTable.getValueAt(row, 1));
				aw.getTxtRoomPrice().setText("" + RoomTable.getValueAt(row, 2));
				aw.setVisible(true);
			}
		}

	}

}
