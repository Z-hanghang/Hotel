package control.mainback.lsnAddRoomTypeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.mainbackfrm.Roomtype.MDLRoomType;
import view.backmain.BackMainView.addRoomType.AddRoomTypeView;
import vo.mainback.Roomvo;


/**
 * ��ӷ������� ������ť������
 * 
 * @author �ź�
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
		if (s.equals("ȷ  ��")) {
			if (!txtRoomTypeName.getText().equals("") && !txtRoomPrice.getText().equals("")) {
				double a = Integer.parseInt(txtRoomPrice.getText());
				room.setRoompiece(a);
				// ��ӵ����ݿ���
				mdlRoom.AddRoomType(room);
				// ����
				JOptionPane.showMessageDialog(this.aw, "��ӳɹ�","������ʾ",1);
				// ����
				this.aw.dispose();
			} else {
				JOptionPane.showMessageDialog(this.aw, "���������ݺ�����ӣ�","������ʾ",2);
			}
		} else if (s.equals("��  ��")) {

			if (!txtRoomPrice.getText().equals("")) {
				int option = JOptionPane.showConfirmDialog(this.aw, "���ĺ󷿼����ͺ󽫻ᷢ���ı䣬ȷ���ύ��", "������ʾ",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					if(txtRoomPrice.getText().matches("[0-9]*")) {
						double a = Double.valueOf(txtRoomPrice.getText());
						room.setRoompiece(a);
						mdlRoom.UpdateRoomType(room);
						JOptionPane.showMessageDialog(this.aw, "�޸ĳɹ�","������ʾ",1);
						this.aw.dispose();
					}else {
						String msg = "�۸�����������";
						JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(this.aw, "���������ݺ����޸ģ�","������ʾ",2);
			}

		} else {
			this.aw.dispose();
		}

	}

}
