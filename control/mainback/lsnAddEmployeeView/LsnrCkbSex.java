package control.mainback.lsnAddEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JRadioButton;
import javax.swing.JTextField;

import view.backmain.BackMainView.AddEmployeeView.AddEmployeeView;





/**
 * 增加员工信息界面性别选择框监听器
 * @author:张航
 * @date:2018.10.16
 * 
 * */
public class LsnrCkbSex implements ActionListener {

	private AddEmployeeView aw;
    public LsnrCkbSex(AddEmployeeView aw) {
		this.aw=aw;
	}
	public void actionPerformed(ActionEvent e) {
		JRadioButton ckbSex1=aw.getCkbSex1();
		JRadioButton ckbSex2=aw.getCkbSex2();
		JTextField txtSex=aw.getTxtEmployeeSex();
		if(ckbSex1.isSelected()){
			txtSex.setText("男");
			
		}else if(ckbSex2.isSelected()){
			txtSex.setText("女");
		}
				
				
				
	}

}
