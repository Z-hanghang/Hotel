package control.mainback.lsnAddRoomView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import model.mainbackfrm.Roomtype.MDLRoomType;
import model.mainbackfrm.mdlnumber.MdlNumberUp;
import model.mainbackfrm.room.mdlRoom;
//import sun.applet.Main;
import view.backmain.BackMainView.BackMainView;
import view.backmain.BackMainView.addRoomView.AddRoomView;
import vo.mainback.Roomvo;
/**
 * ��ӻ����޸ķ�����Ϣ���� ������
 * @author �ź�
 * @date 2018.10.29
 * 
 * */
public class LsnrAddRoomView implements ActionListener {
    private BackMainView bw=new BackMainView();
	private AddRoomView aw;
	public LsnrAddRoomView(AddRoomView aw) {
		this.aw=aw;
	}
	public void actionPerformed(ActionEvent e) {
		Object t=e.getSource();
		JComboBox<String> cbBox=aw.getCbBox();
		JComboBox<String> cbxRoomFloor=aw.getCbBoxFloor();
		Vector<String> v = new MDLRoomType().selectAllRoomTypeName();
		JTextField txtRoomTypeName = aw.getTxtRoomTypeName();
		JTextField txtRoomPrice = aw.getTxtRoomPrice();
		
		JTextField txtRoomId = aw.getTxtRoomId();
		JTextField txtRoomFloor= aw.getTxtRoomFloor();
		JTextField txtRoomNumber = aw.getTxtRoomNumber();
		String[] roomName = aw.getRoomName();
		
	
	
		Roomvo room=new Roomvo();
		mdlRoom mdlRoom=new mdlRoom();
		Roomvo newRoom=new Roomvo();
		if(t.equals(cbBox)){
			//��ѡ�������
			for (int a=0;a<roomName.length;a++) {
				if (v.contains(roomName[a])) {
					if (cbBox.getSelectedItem().equals(roomName[a])) {
						txtRoomTypeName.setText(roomName[a]);	
						aw.getTxtRoomPrice().setText(""+aw.getRoomPrice()[a]);
                        aw.getTxtRoomNumber().setText(""+aw.getRoomNumber()[a]);
						break;
					}
				} else {
					if (cbBox.getSelectedItem().equals(roomName[a])) {
						JOptionPane.showMessageDialog(this.aw, "δ��Ӵ˷������ͣ���ȥ�������ͽ�����ӣ�","������ʾ",1);
						//txtRoomTypeName.setText("");
						return;
					}
					
				}

			}

		
		}if(t.equals(aw.getBtnQueDing())){
			//ȷ����ť������
			
			if(!txtRoomId.getText().equals("")&&!txtRoomTypeName.getText().equals("")){
				
				
				newRoom.setRoomtypename(txtRoomTypeName.getText());
			    room.setFloorid(txtRoomFloor.getText());
				room.setRoomid(txtRoomId.getText());
				room.setRoomtypeid(mdlRoom.selectRoomTypeId(newRoom));
				
				
				room.setRoomnumber(Integer.parseInt(txtRoomNumber.getText()));
				//��ӷ���
				mdlRoom.addRoom(room);
	           
				this.aw.dispose();
				JOptionPane.showMessageDialog(this.aw, "��ӳɹ�","������ʾ",1);
				//ˢ��
				flushRoomTable(mdlRoom.selectAllRoom());
				
				
				
			}else{
				JOptionPane.showMessageDialog(this.aw, "����ѡ�����ȷ�����","������ʾ",2);
			}
			
		}if(t.equals(aw.getBtnQuXiao())){
	
			//ȡ����ť������
			this.aw.dispose();
		}if(t.equals(aw.getBtnXiuGai())){
			//�޸İ�ť������
			if(!txtRoomId.getText().equals("")&&!txtRoomTypeName.getText().equals("")){
				int option = JOptionPane.showConfirmDialog(this.aw, "���ĺ󷿼���Ϣ�󽫻ᷢ���ı䣬ȷ���ύ��", "������ʾ",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					newRoom.setRoomtypename(txtRoomTypeName.getText());
					
					room.setFloorid(txtRoomFloor.getText());
					room.setRoomid(txtRoomId.getText());
					room.setRoomtypeid(mdlRoom.selectRoomTypeId(newRoom));
					
					
					room.setRoomnumber(Integer.parseInt(txtRoomNumber.getText()));
					//�޸�
					mdlRoom.updateRoom(room);
					this.aw.dispose();
					JOptionPane.showMessageDialog(this.aw, "�޸ĳɹ�","������ʾ",1);
					//ˢ��
					flushRoomTable(mdlRoom.selectAllRoom());
					
				}
				
			}else{
				JOptionPane.showMessageDialog(this.aw, "����ѡ������޸�","������ʾ",1);
			}
		}
		if(t.equals(aw.getCbBoxFloor())){
			
			MdlNumberUp mp=new MdlNumberUp();
			
			
			if(cbxRoomFloor.getSelectedItem().equals("��¥")){
				  //�����ı�������
				  txtRoomFloor.setText("F03");
				  //�Զ����ɷ����
				  txtRoomId.setText(mp.RoomIdMaxNumber("F03"));
			}else if(cbxRoomFloor.getSelectedItem().equals("��¥")){
				  
				  txtRoomFloor.setText("F04");
				  txtRoomId.setText(mp.RoomIdMaxNumber("F04"));
			}else if(cbxRoomFloor.getSelectedItem().equals("��¥")){
				  txtRoomFloor.setText("F05");
				  txtRoomId.setText(mp.RoomIdMaxNumber("F05"));
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
