package control.mainback.lsnAddLogView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JComboBox;

import model.mainbackfrm.register.mdlRegister;
import view.backmain.BackMainView.addLogView.AddLogView;
import vo.mainback.Register;

/**
 * 添加登录权限界面的组合框监听器
 * JcomBoBox
 * @author 张航
 * @date: 2018.10.26
 * **/
public class LsnrAddLogCbx implements ActionListener {
  private AddLogView aw;
  public LsnrAddLogCbx(AddLogView aw) {
	this.aw=aw;
}
	
	public void actionPerformed(ActionEvent e) {
	JComboBox<String> cbx=aw.getJcbx();
	TreeSet<Register>  v = new TreeSet<Register>();
	TreeSet<Register> v1=new mdlRegister().selectAllLogPwdNotNull();
	TreeSet<Register> v2=new mdlRegister().selectAllLogPwdNull();
	v.addAll(v1);
	v.addAll(v2);
	if(!v.isEmpty()){
		for(Register a:v){
			if(cbx.getSelectedItem().equals(a.getEmployeeId())){
				aw.getTxtLogId().setText(a.getEmployeeId());
				break;
			}
		}
		
		}
	}
	
	}


