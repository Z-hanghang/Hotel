package control.mainback.lsnAddEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import view.backmain.BackMainView.AddEmployeeView.AddEmployeeView;



/**����Ա����Ϣ�������Ͽ�ѡ��Ա�����ͱ�ż�����
 * 
 * @author: �ź�
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
		if(cbBox.getSelectedItem().equals("��ͨԱ��")){
			txtEmptyeId.setText((String) cbBox.getSelectedItem());
		}else{
			txtEmptyeId.setText((String) cbBox.getSelectedItem());
		}
		 
	}

}
