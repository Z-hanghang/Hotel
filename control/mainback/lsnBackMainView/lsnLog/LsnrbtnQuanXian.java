package control.mainback.lsnBackMainView.lsnLog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import view.backmain.BackMainView.BackMainView;
import view.backmain.BackMainView.addLogView.AddLogView;


/**
 * 登录权限界面中的 给予和撤销权限按钮监听器
 * @author 张航
 * @date:2018.10.23
 * */
public class LsnrbtnQuanXian implements ActionListener {
   
	private BackMainView bw;
	public LsnrbtnQuanXian(BackMainView bw) {
		this.bw=bw;
	}
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		
		if(s.equals("修改密码")){
		 AddLogView aw=new AddLogView(this.bw, "登录权限",  true, "1");
		    JTable Tbl=bw.getTblLog();
	        int row=Tbl.getSelectedRow();
	        if(row==-1){
	         JOptionPane.showMessageDialog(this.bw, "  请选中一行数据！","温情提示",1);
	        }else{
	           
				aw.getTxtLogId().setText((String) Tbl.getValueAt(row, 0));
		        aw.getTxtEmployeeName().setText((String)Tbl.getValueAt(row, 1));
	        	aw.getTxtLogPwd().setText((String)Tbl.getValueAt(row, 2));
	        	aw.getTxtLogState().setText((String)Tbl.getValueAt(row, 3));
	        	aw.setVisible(true);
	        } 
		 
		}else{
			
			     AddLogView aw=new AddLogView(this.bw, "登录权限",  true, "2");
			    JTable Tbl=bw.getTblLog();
		        int row=Tbl.getSelectedRow();
		        if(row==-1){
		         JOptionPane.showMessageDialog(this.bw, "  请选中一行数据！","温情提示",1);
		        }else{
		        	
					aw.getTxtLogId().setText((String) Tbl.getValueAt(row, 0));
			        aw.getTxtEmployeeName().setText((String)Tbl.getValueAt(row, 1));
		        	aw.getTxtLogPwd().setText((String)Tbl.getValueAt(row, 2));
		        	aw.getTxtLogState().setText((String)Tbl.getValueAt(row, 3));
		        	aw.setVisible(true);
		        	
		        } 
			
			
		}
	}

}
