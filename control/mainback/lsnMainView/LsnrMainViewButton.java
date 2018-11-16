package control.mainback.lsnMainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.logmain.JuiBackLogin;
import view.logmain.JuiFrontLogin;
import view.logmain.MainView;

//前台登录入口按钮事件
public class LsnrMainViewButton implements ActionListener {
    private MainView mv;
    public LsnrMainViewButton(MainView mv){
    	this.mv=mv;
    }
  //界面跳转 到前台登录界面
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		if(s.equals("前台登录入口")){
		JuiFrontLogin frontLogin=new JuiFrontLogin();
        frontLogin.setVisible(true);
        this.mv.dispose();
		}else{
			 //界面跳转 到后台登录界面
		      new JuiBackLogin().setVisible(true);
	          this.mv.dispose();
		}
	}

}
