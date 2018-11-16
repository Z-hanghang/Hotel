package control.mainback.lsnBackMainView.lsnEmployee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import view.backmain.BackMainView.BackMainView;
import view.backmain.BackMainView.AddEmployeeView.AddEmployeeView;

/***
 *  BackMainView员工信息模块增加员工或者修改员工按钮监听器
 * 
 * */

public class LsnrUpdateEmployee implements ActionListener {
    
	private BackMainView bw;
	public LsnrUpdateEmployee(BackMainView bw) {
		this.bw=bw;
	}
	public void actionPerformed(ActionEvent e) {
		
		Object o=e.getSource();
		if(o.equals(bw.getBtnAddEmployee())){
		   new AddEmployeeView(this.bw, "添加员工信息",  true, "1").setVisible(true);
		}else if(o.equals(bw.getBtnUpdateEmployee())){
			    AddEmployeeView aw=new AddEmployeeView(this.bw, "修改员工信息",  true, "2");
			    JTable Tbl=bw.getTblEmployee();
		        int row=Tbl.getSelectedRow();
		        if(row==-1){
		         JOptionPane.showMessageDialog(this.bw, "  请选中一行数据！","温情提示",2);
		        }else{
		        	//Employee em=new Employee();
		        	//String string=new SimpleDateFormat("yyyy-MM-dd").format(Tbl.getValueAt(row, 4));
		        	aw.getTxtEmployeeId().setText((String)Tbl.getValueAt(row, 0));
		        	aw.getTxtEmptyeId().setText((String)Tbl.getValueAt(row, 1));
		        	aw.getTxtEmployeeName().setText((String)Tbl.getValueAt(row, 2));
		        	aw.getTxtEbirthday().setText(new SimpleDateFormat("yyyy-MM-dd").format(Tbl.getValueAt(row, 3)));
		        	aw.getTxtEmployeeSex().setText((String)Tbl.getValueAt(row, 4));
		        	aw.getTxtEmployeeTel().setText((String)Tbl.getValueAt(row, 5));
		        	aw.getTxtEmployeeEid().setText((String)Tbl.getValueAt(row, 6));
		        	aw.setVisible(true);
		        }
		}
	}

}
