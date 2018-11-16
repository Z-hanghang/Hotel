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
 * 房间管理界面 五个按钮监听器
 * 
 * @author 张航
 * @date 2018.10.29
 * 
 **/
public class LsnrRoombtn implements ActionListener {

	private BackMainView bw;

	public LsnrRoombtn(BackMainView bw) {
		this.bw = bw;
	}

	public void actionPerformed(ActionEvent e) {
		// 获取监听器变量名
		Object t = e.getSource();
		// 房间表格
		JTable TblRoom = bw.getTblRToom();
		// 创造房间对象
		Roomvo room = new Roomvo();
		// 引入房间处理逻辑业务
		mdlRoom mdlRoom = new mdlRoom();
		//复选框
		JRadioButton ckbRoomId=bw.getCkbRToomID();
		JRadioButton ckbRoomTypeName=bw.getCkbRToomType();
		
		JTextField txtRoomId=bw.getTxtRToomID();
		JTextField txtRoomType=bw.getTxtRToomType();
		
		if (t.equals(bw.getBtnAllRToom())) {
			// 查询所有房间按钮
			 flushRoomTable(mdlRoom.selectAllRoom());

		}
		if (t.equals(bw.getBtnAddRToom())) {
			// 添加房间按钮
			new AddRoomView(this.bw, "添加房间", true, "1").setVisible(true);

		}
		if (t.equals(bw.getBtnSelectRToom())) {
			// 按类型查询房间按钮
			if(ckbRoomId.isSelected()){
				if(!txtRoomId.getText().equals("")){
					room.setRoomid(txtRoomId.getText());
					flushRoomTable(mdlRoom.selectRoomId(room));
				}else{
					JOptionPane.showMessageDialog(bw, "请输入如（R101）的房间号进行查找","温情提示",1);
				}
			}if(ckbRoomTypeName.isSelected()){
				if(!txtRoomType.getText().equals("")){
					room.setRoomtypename(txtRoomType.getText());
					flushRoomTable(mdlRoom.selectRoomTypeName(room));
				}else{
					JOptionPane.showMessageDialog(bw, "请输入如（单人间）的房间名称进行查找","温情提示",1);
				}
			}else if(!ckbRoomId.isSelected()&&!ckbRoomTypeName.isSelected()){
				JOptionPane.showMessageDialog(bw, "请选择类型后进行查找","温情提示",2);
			}

		}
		if (t.equals(bw.getBtnDeleteRToom())) {
			// 删除房间按钮
			int row = TblRoom.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this.bw, "  请选中一行数据！","温情提示",1);
			} else {
				int option = JOptionPane.showConfirmDialog(this.bw, "确定删除该房间吗？", "温情提示", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					 room.setRoomid((String)TblRoom.getValueAt(row, 0));
					 //删除
                     mdlRoom.deleteRoom(room);
                     JOptionPane.showMessageDialog(this.bw, "恭喜删除成功！","温情提示",1);
                     //刷新
                     flushRoomTable(mdlRoom.selectAllRoom());
				}
			}

		}
		if (t.equals(bw.getBtnUpdateRToom())) {
			// 修改房间按钮
			AddRoomView aw = new AddRoomView(this.bw, "修改房间", true, "2");
			int row = TblRoom.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this.bw, "  请选中一行数据！");
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
	
	 //刷新房间表
    private void flushRoomTable(Vector resultVector) {
    	Object[] RoomColumnNames = bw.getRToomColumnNames();
    	Vector columnNamesV = new Vector();
    	for (Object temp : RoomColumnNames) {
    		columnNamesV.add(temp);
    	}
    	bw.getTblRToom().setModel(new DefaultTableModel(resultVector, columnNamesV));
    	
    }	

}
