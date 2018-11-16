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
 * 添加或者修改房间信息界面 监听器
 * @author 张航
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
			//复选框监听器
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
						JOptionPane.showMessageDialog(this.aw, "未添加此房间类型，请去房间类型界面添加！","温情提示",1);
						//txtRoomTypeName.setText("");
						return;
					}
					
				}

			}

		
		}if(t.equals(aw.getBtnQueDing())){
			//确定按钮监听器
			
			if(!txtRoomId.getText().equals("")&&!txtRoomTypeName.getText().equals("")){
				
				
				newRoom.setRoomtypename(txtRoomTypeName.getText());
			    room.setFloorid(txtRoomFloor.getText());
				room.setRoomid(txtRoomId.getText());
				room.setRoomtypeid(mdlRoom.selectRoomTypeId(newRoom));
				
				
				room.setRoomnumber(Integer.parseInt(txtRoomNumber.getText()));
				//添加房间
				mdlRoom.addRoom(room);
	           
				this.aw.dispose();
				JOptionPane.showMessageDialog(this.aw, "添加成功","温情提示",1);
				//刷新
				flushRoomTable(mdlRoom.selectAllRoom());
				
				
				
			}else{
				JOptionPane.showMessageDialog(this.aw, "请点击选择后再确认添加","温情提示",2);
			}
			
		}if(t.equals(aw.getBtnQuXiao())){
	
			//取消按钮监听器
			this.aw.dispose();
		}if(t.equals(aw.getBtnXiuGai())){
			//修改按钮监听器
			if(!txtRoomId.getText().equals("")&&!txtRoomTypeName.getText().equals("")){
				int option = JOptionPane.showConfirmDialog(this.aw, "更改后房间信息后将会发生改变，确认提交吗？", "温情提示",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					newRoom.setRoomtypename(txtRoomTypeName.getText());
					
					room.setFloorid(txtRoomFloor.getText());
					room.setRoomid(txtRoomId.getText());
					room.setRoomtypeid(mdlRoom.selectRoomTypeId(newRoom));
					
					
					room.setRoomnumber(Integer.parseInt(txtRoomNumber.getText()));
					//修改
					mdlRoom.updateRoom(room);
					this.aw.dispose();
					JOptionPane.showMessageDialog(this.aw, "修改成功","温情提示",1);
					//刷新
					flushRoomTable(mdlRoom.selectAllRoom());
					
				}
				
			}else{
				JOptionPane.showMessageDialog(this.aw, "请点击选择后再修改","温情提示",1);
			}
		}
		if(t.equals(aw.getCbBoxFloor())){
			
			MdlNumberUp mp=new MdlNumberUp();
			
			
			if(cbxRoomFloor.getSelectedItem().equals("三楼")){
				  //设置文本框数据
				  txtRoomFloor.setText("F03");
				  //自动生成房间号
				  txtRoomId.setText(mp.RoomIdMaxNumber("F03"));
			}else if(cbxRoomFloor.getSelectedItem().equals("四楼")){
				  
				  txtRoomFloor.setText("F04");
				  txtRoomId.setText(mp.RoomIdMaxNumber("F04"));
			}else if(cbxRoomFloor.getSelectedItem().equals("五楼")){
				  txtRoomFloor.setText("F05");
				  txtRoomId.setText(mp.RoomIdMaxNumber("F05"));
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
