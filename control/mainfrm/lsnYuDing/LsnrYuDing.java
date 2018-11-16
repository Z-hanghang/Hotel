package control.mainfrm.lsnYuDing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import common.component.tools.HotelTools;
import control.mainfrm.mainjiemian.roommenu.LsnrRoomMenuFrm;
import control.mainfrm.residefrm.LsnrResideFrmBtn;
import model.mainfrm.YuDing.MdlYuDing;
import view.mainfrm.YuDing.FrmReserveMain;
import view.mainfrm.YuDing.YuDingView;
import view.mainfrm.mainjiemian.FrmHotelMain;
import view.mainfrm.reside.FrmRuZhuRoom;
import vo.mainfrm.ReserveVO;
/**
 * Ԥ�����漸����ť������
 * @author �ź�
 * @date 2018.11.01
 * 
 * **/
public class LsnrYuDing implements ActionListener {
    private FrmReserveMain fm;
    
    public LsnrYuDing(FrmReserveMain fm) {
		this.fm=fm;
	}
	
	public void actionPerformed(ActionEvent e) {
	Object o=e.getSource();
	JTextField txtselect=fm.getTf1();
	JTable TabYuDing=fm.getTblReserve();
	ReserveVO re=new ReserveVO();
	MdlYuDing mdlYD=new MdlYuDing();
	if(o.equals(fm.getSeleteBt())){
		//���Ұ�ť����
		if(txtselect.getText().matches("R[1-9][0-9]{0,2}")){
			re.setRoomId(txtselect.getText());
			flushReserveTable(mdlYD.selectYuDingRoom(re));
		}else if(txtselect.getText().matches("[\u4e00-\u9fa5]{1,3}")){
			re.setCustomerName(txtselect.getText());
			flushReserveTable(mdlYD.selectYuDingCustomer(re));
		}else if(txtselect.getText().matches("[1][3-8][0-9]{0,9}")){
			re.setCustomerTel(txtselect.getText());
			flushReserveTable(mdlYD.selectYuDingCustomerTel(re));
		}else if(txtselect.getText().equals("")){
			JOptionPane.showMessageDialog(fm, "�����뷿���磨R101������ ���� ���� �绰 ���в�ѯ","������ʾ",1);
		}
		
	}else if(o.equals(fm.getDeleteBt())){
		//ɾ����ť����
		int row =TabYuDing.getSelectedRow();
		if(row==-1){
			JOptionPane.showMessageDialog(fm, "��ѡ��һ��","������ʾ",1);
		}else{
			int option = JOptionPane.showConfirmDialog(this.fm, "ȷ��ɾ����Ԥ����Ϣ��", "������ʾ", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (option == JOptionPane.OK_OPTION) {
				re.setReserveId((String)TabYuDing.getValueAt(row, 0));
				mdlYD.deleteYuDing(re);
				JOptionPane.showMessageDialog(fm, "ɾ���ɹ�","������ʾ",1);
				flushReserveTable(mdlYD.selectAllYuDing());
			}
		}
		
	}else if(o.equals(fm.getShuaXinBt())){
		//ˢ�°�ť����
		if(txtselect.getText().matches("R[1-9]{3}")){
			re.setRoomId(txtselect.getText());
			flushReserveTable(mdlYD.selectYuDingRoom(re));
		}else if(txtselect.getText().matches("[\u4e00-\u9fa5]{1,3}")){
			re.setCustomerName(txtselect.getText());
			flushReserveTable(mdlYD.selectYuDingCustomer(re));
		}else if(txtselect.getText().matches("[1][3-8][0-9]{9}")){
			re.setCustomerTel(txtselect.getText());
			flushReserveTable(mdlYD.selectYuDingCustomerTel(re));
		}else if(txtselect.getText().equals("")){
			flushReserveTable(mdlYD.selectAllYuDing());
		}
	}else if(o.equals(fm.getUpdateBt())){
		//���°�ť����
	  
		int row =TabYuDing.getSelectedRow();
		if(row==-1){
			JOptionPane.showMessageDialog(fm, "��ѡ��һ��","������ʾ",1);
		}else{
			if(TabYuDing.getValueAt(row, 10).equals("��Ԥ��")){
			YuDingView fe=new YuDingView(null, "����Ԥ������", true, "2");
			String s=(String)TabYuDing.getValueAt(row, 0);
			String vip=mdlYD.findVipId(s);
		    fe.getTxtYDid().setText((String)TabYuDing.getValueAt(row, 0));
		    fe.getTxtCustomerName().setText((String)TabYuDing.getValueAt(row, 1));
		    fe.getTxtSex().setText((String)TabYuDing.getValueAt(row, 2));
		    fe.getTxtTel().setText((String)TabYuDing.getValueAt(row, 3));
		    fe.getTxtVipId().setText(vip);
		    fe.getTxtCustomerCId().setText((String)TabYuDing.getValueAt(row, 4));
		    fe.getTxtCustomerType().setText((String)TabYuDing.getValueAt(row, 5));
		    fe.getTxtRoomId().setText((String)TabYuDing.getValueAt(row, 6));
		    fe.getTxtRoomType().setText((String)TabYuDing.getValueAt(row, 7));
		    
		    fe.getTxtYDState().setText((String)TabYuDing.getValueAt(row, 10));
		    fe.getTxYDtime().setText((String)TabYuDing.getValueAt(row, 11));
		    fe.getTxtBLtime().setText((String)TabYuDing.getValueAt(row,12));
		    fe.cbBoxRoomId.removeAllItems();;
		    fe.getCbBoxRoomId().addItem((String)TabYuDing.getValueAt(row, 6));
			fe.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(fm, "ֻ���޸�Ԥ������Ϣ�����ѡ��","������ʾ",1);
			}
			
		}
		
	}else if(o.equals(fm.getAddBt())){
		//���Ԥ����Ϣ��ť����
		new YuDingView(null, "����Ԥ������", true, "1").setVisible(true);
	}else if(o.equals(fm.getOpenRoomBt())){
		//������ť����
		int row =TabYuDing.getSelectedRow();
		if(row==-1){
			JOptionPane.showMessageDialog(fm, "��ѡ��һ��","������ʾ",1);
		}else{
			if(TabYuDing.getValueAt(row, 10).equals("��Ԥ��")){
				
			LsnrResideFrmBtn.flag=true;       //�����ж��¹˿ͺ��Ϲ˿�
			LsnrRoomMenuFrm.flag = false;     // �����ж��費��Ҫ������ӷ���
			FrmRuZhuRoom frmRuZhuRoom = new FrmRuZhuRoom(fm, "��ס�Ǽ�", true, "��ס");	
			String resideId = HotelTools.getNumber(HotelTools.D);
			frmRuZhuRoom.getTxtrzbh().setText(resideId);
			//��Ԥ��״̬��ֵ
			frmRuZhuRoom.setYDState((String)TabYuDing.getValueAt(row, 10));
			//��Ԥ����Ÿ�ֵ
			frmRuZhuRoom.setYDId((String)TabYuDing.getValueAt(row, 0));
			
			frmRuZhuRoom.getComfjlx().removeAllItems();        //ȥ�����������
			frmRuZhuRoom.getComfjbh().removeAllItems();
			frmRuZhuRoom.getComgkxb().removeAllItems();
			
			frmRuZhuRoom.getTxtbkxm().setText((String)TabYuDing.getValueAt(row, 1));
			frmRuZhuRoom.getTxtbklx().setText((String)TabYuDing.getValueAt(row, 5));
			frmRuZhuRoom.getTxtlxdh().setText((String)TabYuDing.getValueAt(row, 3));
			frmRuZhuRoom.getComgkxb().addItem((String)TabYuDing.getValueAt(row, 2));
			frmRuZhuRoom.getComfjlx().addItem((String)TabYuDing.getValueAt(row, 7));
			frmRuZhuRoom.getComfjbh().addItem((String)TabYuDing.getValueAt(row, 6));
			frmRuZhuRoom.getTxtsfz().setText((String)TabYuDing.getValueAt(row, 4));
			
			
			frmRuZhuRoom.setVisible(true);
			return;		
			}else{
				JOptionPane.showMessageDialog(fm, "���ѡ����Ԥ���Ĺ˿ͽ�����ס","������ʾ",1);
			}
		}
		
	}else if(o.equals(fm.getJcbxYDState())){
		//����Ԥ��״̬����
		String[] stateName=fm.getYDStateName();
		for(String a:stateName){
			if(fm.getJcbxYDState().getSelectedItem().equals(a)){
				re.setReserveState(a);
				flushReserveTable(mdlYD.selectYuDingSate(re));
			}
		}
	}
		
	}
	// ˢ��Ԥ����Ϣ��
		private void flushReserveTable(Vector resultVector) {
			Object[] ReserveColumnNames = fm.getReserveColumnNames();
			Vector columnNamesV = new Vector();
			for (Object temp : ReserveColumnNames) {
				columnNamesV.add(temp);
			}
			fm.getTblReserve().setModel(new DefaultTableModel(resultVector, columnNamesV));

		}

}
