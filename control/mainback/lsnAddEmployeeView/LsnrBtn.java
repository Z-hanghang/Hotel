package control.mainback.lsnAddEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import common.component.tools.HotelTools;
import model.mainbackfrm.Employee.employeeManage;
import model.mainbackfrm.register.mdlRegister;
import view.backmain.BackMainView.BackMainView;
import view.backmain.BackMainView.AddEmployeeView.AddEmployeeView;
import vo.mainback.Employee;
import vo.mainback.Register;

/**
 * ���Ա����Ϣ�����ȷ����ȡ����ť�ļ�����
 */
public class LsnrBtn implements ActionListener {
	private BackMainView bw=new BackMainView();
	private AddEmployeeView aw;

	public LsnrBtn(AddEmployeeView aw) {
		this.aw = aw;
	}

	public void actionPerformed(ActionEvent e) {
		Register re = new Register();
		Employee em = new Employee();
		employeeManage eManage=	new employeeManage();
		String s = e.getActionCommand();
		String tel = "[1][3-8][0-9]{9}";
		String eid = "[4][0-9]{16}[0-9X]";
		JTextField EmployeeTel = aw.getTxtEmployeeTel();
		JTextField EmployeeEid = aw.getTxtEmployeeEid();
		if (s.equals("ȷ  ��")) {
			if (!EmployeeTel.getText().matches(tel)) {
				JOptionPane.showMessageDialog(this.aw, "��������ֻ������ʽ����!","������ʾ",2);
				
				//��ղ��� EmployeeTel.setText("");
				EmployeeTel.requestFocus();
				return;
			} else if (!EmployeeEid.getText().matches(eid)) {
				JOptionPane.showMessageDialog(this.aw, "����������֤�Ÿ�ʽ����!","������ʾ",2);
				//��ղ��� EmployeeEid.setText("");
				EmployeeEid.requestFocus();
				return;
			} else {
				
				//���±��
				String num=aw.getStrEmployeeID();
				HotelTools.savNumber(num, HotelTools.EM);

				em.setEmployeeId(aw.getTxtEmployeeId().getText());
				em.setEmployeeName(aw.getTxtEmployeeName().getText());
				em.setEmployeeSex(aw.getTxtEmployeeSex().getText());
				em.setEmployeeTel(EmployeeTel.getText());
				em.setEmployeeEid(EmployeeEid.getText());
				//���ݻ�õ�Ա�������� ����Ա�����ͱ�š�
				if(aw.getTxtEmptyeId().getText().equals("��ͨԱ��")){
					em.setEmtypeId("EMT01");
				}else if(aw.getTxtEmptyeId().getText().equals("����")) {
					em.setEmtypeId("EMT02");
				}
				

				re.setEmployeeId(aw.getTxtEmployeeId().getText());
				try {
					em.setEmployeeBrithday(new SimpleDateFormat("yyyy-mm-dd").parse(aw.getTxtEbirthday().getText()));
					// ��ӵ����ݿ���
					eManage.addEmployee(em);
					// ͬʱ��ӵ���¼����
					new mdlRegister().insertRegister(re);
					// ��ǰ��������
					this.aw.dispose();
					// ������ʾ
					JOptionPane.showMessageDialog(this.aw, "��ӳɹ�","������ʾ",1);
					//ˢ��Ա�����
					flushEmployeeTable(eManage.findAlleEmployee());
                    //ˢ�µ�¼���
					//flushLogTable(new mdlRegister().findAllEmployee());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		} else if (s.equals("ȡ  ��")) {
			// ȡ����ť
			this.aw.dispose();
		} else {
			// �޸İ�ť
			if (!EmployeeTel.getText().matches(tel)) {
				JOptionPane.showMessageDialog(this.aw, "��������ֻ������ʽ����!","������ʾ",2);
				//EmployeeTel.setText("");
				EmployeeTel.requestFocus();
				return;
			} else if (!EmployeeEid.getText().matches(eid)) {
				JOptionPane.showMessageDialog(this.aw, "����������֤�Ÿ�ʽ����!","������ʾ",2);
				//EmployeeEid.setText("");
				EmployeeEid.requestFocus();
				return;
			} else {

				em.setEmployeeId(aw.getTxtEmployeeId().getText());
				em.setEmployeeName(aw.getTxtEmployeeName().getText());
				em.setEmployeeSex(aw.getTxtEmployeeSex().getText());
				em.setEmployeeTel(EmployeeTel.getText());
				em.setEmployeeEid(EmployeeEid.getText());
				//���ݻ�õ�Ա�������� ����Ա�����ͱ�š�
				if(aw.getTxtEmptyeId().getText().equals("��ͨԱ��")){
					em.setEmtypeId("EMT01");
				}else if(aw.getTxtEmptyeId().getText().equals("����")) {
					em.setEmtypeId("EMT02");
				}
				try {
					em.setEmployeeBrithday(new SimpleDateFormat("yyyy-mm-dd").parse(aw.getTxtEbirthday().getText()));
					int option = JOptionPane.showConfirmDialog(this.bw, "���ĺ���Ϣ���ᷢ���ı䣬ȷ���ύ��", "��ʾ",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {
						// �����ݿ����޸�
						eManage.updateEmployee(em);
						// ��ǰ��������
						this.aw.dispose();
						// ������ʾ
						JOptionPane.showMessageDialog(this.aw, "�޸ĳɹ�","������ʾ",1);
						//ˢ��Ա����
						flushEmployeeTable(eManage.findAlleEmployee());

					}

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	//ˢ��Ա����
	 private void flushEmployeeTable(Vector resultVector) {
			Object[] EmployeeColumnNames = bw.getEmployeeColumnNames();
			Vector columnNamesV = new Vector();
			for (Object temp : EmployeeColumnNames) {
				columnNamesV.add(temp);
			}
			bw.getTblEmployee().setModel(new DefaultTableModel(resultVector, columnNamesV));

		}	
	 //ˢ�µ�¼��
	    private void flushLogTable(Vector resultVector) {
	    	Object[] LogColumnNames = bw.getLogColumnNames();
	    	Vector columnNamesV = new Vector();
	    	for (Object temp : LogColumnNames) {
	    		columnNamesV.add(temp);
	    	}
	    	bw.getTblLog().setModel(new DefaultTableModel(resultVector, columnNamesV));
	    	
	    }	

}
