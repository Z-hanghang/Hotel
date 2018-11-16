package control.mainback.lsnBackMainView.lsnCbx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import view.backmain.BackMainView.BackMainView;
/**
 * 后台 房间管理界面复选框和组合框的监听器
 * @author 张航
 * @date 2018.10.27
 * 
 * 
 * **/
public class LsnrBackMainViewCbxRoom implements ActionListener {

	private BackMainView bw;

	public LsnrBackMainViewCbxRoom(BackMainView bw) {
		this.bw = bw;
	}

	public void actionPerformed(ActionEvent e) {
		Object commond =e.getSource();
		JComboBox<String> jCbxRoom = bw.getCbBoxRoom();
		String[] a = bw.getRoomName();
		if (commond.equals(jCbxRoom)) {
			for (String tem : a) {
				if (jCbxRoom.getSelectedItem().equals(tem)) {
					bw.getTxtRToomType().setText(tem);
				}
			}
		}
		if (commond.equals(bw.getCkbRToomID())) {
			if (bw.getCkbRToomID().isSelected()) {
                     bw.getTxtRToomType().setText("");
                     bw.getTxtRToomID().requestFocus();
			}
		}if (commond.equals(bw.getCkbRToomType())){
			if(bw.getCkbRToomType().isSelected()){
				bw.getTxtRToomID().setText("");
				 bw.getTxtRToomType().requestFocus();
			}
		}
	}
}
