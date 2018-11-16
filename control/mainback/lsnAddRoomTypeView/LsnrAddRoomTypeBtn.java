package control.mainback.lsnAddRoomTypeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.mainbackfrm.Roomtype.MDLRoomType;
import view.backmain.BackMainView.addRoomType.AddRoomTypeView;
import vo.mainback.Roomvo;


/**
 * 添加房间类型 三个按钮监听器
 * 
 * @author 张航
 * @date 2018.10.25
 * 
 */
public class LsnrAddRoomTypeBtn implements ActionListener {
	private AddRoomTypeView aw;

	public LsnrAddRoomTypeBtn(AddRoomTypeView aw) {
		this.aw = aw;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		MDLRoomType mdlRoom = new MDLRoomType();
		Roomvo room = new Roomvo();
		JTextField txtRoomPrice = aw.getTxtRoomPrice();
		JTextField txtRoomTypeId = aw.getTxtRoomTypeId();
		JTextField txtRoomTypeName = aw.getTxtRoomTypeName();
		room.setRoomtypename(txtRoomTypeName.getText());
		room.setRoomtypeid(txtRoomTypeId.getText());
		if (s.equals("确  定")) {
			if (!txtRoomTypeName.getText().equals("") && !txtRoomPrice.getText().equals("")) {
				double a = Integer.parseInt(txtRoomPrice.getText());
				room.setRoompiece(a);
				// 添加到数据库中
				mdlRoom.AddRoomType(room);
				// 弹窗
				JOptionPane.showMessageDialog(this.aw, "添加成功","温情提示",1);
				// 销毁
				this.aw.dispose();
			} else {
				JOptionPane.showMessageDialog(this.aw, "请完善数据后，再添加！","温情提示",2);
			}
		} else if (s.equals("修  改")) {

			if (!txtRoomPrice.getText().equals("")) {
				int option = JOptionPane.showConfirmDialog(this.aw, "更改后房间类型后将会发生改变，确认提交吗？", "温情提示",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					if(txtRoomPrice.getText().matches("[0-9]*")) {
						double a = Double.valueOf(txtRoomPrice.getText());
						room.setRoompiece(a);
						mdlRoom.UpdateRoomType(room);
						JOptionPane.showMessageDialog(this.aw, "修改成功","温情提示",1);
						this.aw.dispose();
					}else {
						String msg = "价格请输入数字";
						JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(this.aw, "请完善数据后，再修改！","温情提示",2);
			}

		} else {
			this.aw.dispose();
		}

	}

}
