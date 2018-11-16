package control.mainback.lsnBackMainView.lsnLog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.mainbackfrm.register.mdlRegister;
import view.backmain.BackMainView.BackMainView;
import vo.mainback.Register;


/**
 * 登录权限查找按钮 全部信息按钮以及撤销权限按钮监听器
 * he互斥框监听器
 * @author 张航
 * @date 2018.10.21
 */
public class LsnrLogBtnSelectDelete implements ActionListener {

	private BackMainView bw;

	public LsnrLogBtnSelectDelete(BackMainView bw) {
		this.bw = bw;
	}

	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		// 获取组件名称
		String s = e.getActionCommand();
		// 获取登录对象类
		Register re = new Register();
		// 获取逻辑登录处理业务
		mdlRegister mdlRe = new mdlRegister();

		JRadioButton ckbLogName = bw.getCkbLogName();
		JRadioButton ckbLogId = bw.getCkbLogId();
		JTextField txtLogId = bw.getTxtLogId();
		JTextField txtLogName = bw.getTxtLogName();
		if(o.equals(bw.getBtnSelectAllLog())){
			// 全部信息
			flushTable(mdlRe.findAllEmployee());
		}
		else if (o.equals(bw.getBtnSelectLog())) {
			if (ckbLogName.isSelected()) {
				if (txtLogName.getText().equals("")) {
					JOptionPane.showMessageDialog(bw, "请输入姓名后查找!","温情提示",1);
				} else {
					re.setEmployeeName(txtLogName.getText());
					Vector resultVector = mdlRe.selectEemployeeName(re);
					flushTable(resultVector);
				}
			} else if (ckbLogId.isSelected()) {
				if (txtLogId.getText().equals("")) {
					JOptionPane.showMessageDialog(bw, "请输入员工Id后查找!","温情提示",1);
				} else {
					re.setEmployeeId(txtLogId.getText());
					Vector resultVector = mdlRe.selectEmployeeId(re);
					flushTable(resultVector);
				}
			   } 
			 else {
				JOptionPane.showMessageDialog(bw, "请选择类型后进行查找!","温情提示",2);
			}

		} else if (o.equals(bw.getBtnDeleteLog())) {
			JTable TblLog = bw.getTblLog();
			int row = TblLog.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this.bw, "   请选中一行数据！","温情提示",1);
			} else {
				int option = JOptionPane.showConfirmDialog(this.bw, "确定撤销该员工权限吗?删除后无法添加!!!", "温情提示",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					re.setEmployeeId((String) TblLog.getValueAt(row, 0));
					mdlRe.deleteLogByFK(re);
					// 刷新表格
					flushTable(mdlRe.findAllEmployee());
				}
			}

		} else if(ckbLogName.isSelected()){
			//清空
			txtLogId.setText("");
			txtLogName.requestFocus();
			
		}else if(ckbLogId.isSelected()){
			//清空
			txtLogName.setText("");
			
			txtLogId.requestFocus();
		}

	}

	// 刷新方法
	private void flushTable(Vector resultVector) {
		Object[] LogColumnNames = bw.getLogColumnNames();
		Vector columnNamesV = new Vector();
		for (Object temp : LogColumnNames) {
			columnNamesV.add(temp);
		}
		bw.getTblLog().setModel(new DefaultTableModel(resultVector, columnNamesV));

	}
}
