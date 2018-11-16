package control.mainback.lsnAddRoomTypeView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.mainbackfrm.Roomtype.MDLRoomType;
import view.backmain.BackMainView.addRoomType.AddRoomTypeView;


/**
 * 添加房间类型界面 组合框 监听器
 * 
 * @author 张航
 * @date 2018.10.25
 * 
 */
public class LsnrAddRoomTypeCbBox implements ActionListener {

	private AddRoomTypeView aw;

	public LsnrAddRoomTypeCbBox(AddRoomTypeView aw) {
		this.aw = aw;
	}

	public void actionPerformed(ActionEvent e) {
		JComboBox<String> cbBox = aw.getCbBox();
		Vector<String> v = new MDLRoomType().selectAllRoomTypeName();
		JTextField txtRoomTypeName = aw.getTxtRoomTypeName();
		String[] roomName = aw.getRoomName();
		int i=0;
		for (int a=0;a<roomName.length;a++) {
			if (v.contains(roomName[a])) {
				if (cbBox.getSelectedItem().equals(roomName[a])) {
					cbBox.setEditable(false);	
					JOptionPane.showMessageDialog(aw, "该房间类型已存在，请选择其他的类型!","温情提示",2);
				  //txtRoomTypeName.setText("");
					return;
				}
			} else {
				if (cbBox.getSelectedItem().equals(roomName[a])) {
					
					txtRoomTypeName.setText(roomName[a]);
					aw.getTxtRoomPrice().setText(""+aw.getRoomPrice()[a]);
					break;
				}
				
			}

		}

	}

}
