package control.mainback.lsnMainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.logmain.JuiBackLogin;
import view.logmain.JuiFrontLogin;
import view.logmain.MainView;

//ǰ̨��¼��ڰ�ť�¼�
public class LsnrMainViewButton implements ActionListener {
    private MainView mv;
    public LsnrMainViewButton(MainView mv){
    	this.mv=mv;
    }
  //������ת ��ǰ̨��¼����
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		if(s.equals("ǰ̨��¼���")){
		JuiFrontLogin frontLogin=new JuiFrontLogin();
        frontLogin.setVisible(true);
        this.mv.dispose();
		}else{
			 //������ת ����̨��¼����
		      new JuiBackLogin().setVisible(true);
	          this.mv.dispose();
		}
	}

}
