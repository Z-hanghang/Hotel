package control.mainback.lsnBackMainView.lsncaidan;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import view.backmain.BackMainView.BackMainView;
import view.logmain.JuiBackLogin;
import view.logmain.JuiFrontLogin;
import view.mainfrm.aboutus.FrmAboutUs;

/**
 * ��̨�˵�������
 * @author:�ź�
 * @date:2018.10.19
 * */
public class LsnrBackCaiDan implements ActionListener {
	
	private  BackMainView bw;
	//��̨��¼�������
	private JuiBackLogin jback=new JuiBackLogin();
	//ǰ̨��¼�������
	private JuiFrontLogin jfront=new JuiFrontLogin();
	public LsnrBackCaiDan(BackMainView bw) {
		this.bw=bw;
	}
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
	  
       if(o.equals(bw.getMiqiehuan1())){
    	   jback.setVisible(true);
    	   this.bw.dispose();
       }else if(o.equals(bw.getMiqiehuan2())){
    	   jfront.setVisible(true);
    	   this.bw.dispose();
       }else if(o.equals(bw.getMituichu())){
    	   this.bw.dispose();
    	   System.exit(0);
       }else if(o.equals(bw.getM2())){
    	   //�����˳�
    	  this.bw.dispose();
    	  this.bw.getSystemTray().remove(bw.getTrayIcon());
    	  System.exit(0);
       }else if(o.equals(bw.getM1())){
    	  //��������
    	FrmAboutUs fm =  new FrmAboutUs(null);
    	//fm.getUser().removeAll();
    	//fm.getUser().setText(bw.getjUserName().getText());
    	fm.setVisible(true);
    	   
       }
	}
	
	
	

}
