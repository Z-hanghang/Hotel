package control.mainback.lsnAddEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import view.backmain.BackMainView.AddEmployeeView.AddEmployeeView;



/**增加员工信息界面的组合框选择员工类型编号监听器
 * 
 * @author: 张航
 * @date: 2018.10.22
 * */
public class LsnrCbBox implements ActionListener {
    private AddEmployeeView aw;
    public LsnrCbBox(AddEmployeeView aw) {
		this.aw=aw;
	}
	public void actionPerformed(ActionEvent e) {
		 JComboBox cbBox = aw.getCbBox();
		 JTextField txtEmptyeId = aw.getTxtEmptyeId();
		if(cbBox.getSelectedItem().equals("普通员工")){
			txtEmptyeId.setText((String) cbBox.getSelectedItem());
		}else{
			txtEmptyeId.setText((String) cbBox.getSelectedItem());
		}
		 
	}

}
