package control.mainback.lsnBackMainView.lsnLog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import view.backmain.BackMainView.BackMainView;
import view.backmain.BackMainView.addLogView.AddLogView;


/**
 * ��¼Ȩ�޽����е� ����ͳ���Ȩ�ް�ť������
 * @author �ź�
 * @date:2018.10.23
 * */
public class LsnrbtnQuanXian implements ActionListener {
   
	private BackMainView bw;
	public LsnrbtnQuanXian(BackMainView bw) {
		this.bw=bw;
	}
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		
		if(s.equals("�޸�����")){
		 AddLogView aw=new AddLogView(this.bw, "��¼Ȩ��",  true, "1");
		    JTable Tbl=bw.getTblLog();
	        int row=Tbl.getSelectedRow();
	        if(row==-1){
	         JOptionPane.showMessageDialog(this.bw, "  ��ѡ��һ�����ݣ�","������ʾ",1);
	        }else{
	           
				aw.getTxtLogId().setText((String) Tbl.getValueAt(row, 0));
		        aw.getTxtEmployeeName().setText((String)Tbl.getValueAt(row, 1));
	        	aw.getTxtLogPwd().setText((String)Tbl.getValueAt(row, 2));
	        	aw.getTxtLogState().setText((String)Tbl.getValueAt(row, 3));
	        	aw.setVisible(true);
	        } 
		 
		}else{
			
			     AddLogView aw=new AddLogView(this.bw, "��¼Ȩ��",  true, "2");
			    JTable Tbl=bw.getTblLog();
		        int row=Tbl.getSelectedRow();
		        if(row==-1){
		         JOptionPane.showMessageDialog(this.bw, "  ��ѡ��һ�����ݣ�","������ʾ",1);
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
