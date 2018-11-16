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
 * 预订界面几个按钮监听器
 * @author 张航
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
		//查找按钮监听
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
			JOptionPane.showMessageDialog(fm, "请输入房号如（R101）或者 姓名 或者 电话 进行查询","温情提示",1);
		}
		
	}else if(o.equals(fm.getDeleteBt())){
		//删除按钮监听
		int row =TabYuDing.getSelectedRow();
		if(row==-1){
			JOptionPane.showMessageDialog(fm, "请选中一行","温情提示",1);
		}else{
			int option = JOptionPane.showConfirmDialog(this.fm, "确定删除改预订信息吗？", "温情提示", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (option == JOptionPane.OK_OPTION) {
				re.setReserveId((String)TabYuDing.getValueAt(row, 0));
				mdlYD.deleteYuDing(re);
				JOptionPane.showMessageDialog(fm, "删除成功","温情提示",1);
				flushReserveTable(mdlYD.selectAllYuDing());
			}
		}
		
	}else if(o.equals(fm.getShuaXinBt())){
		//刷新按钮监听
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
		//更新按钮监听
	  
		int row =TabYuDing.getSelectedRow();
		if(row==-1){
			JOptionPane.showMessageDialog(fm, "请选中一行","温情提示",1);
		}else{
			if(TabYuDing.getValueAt(row, 10).equals("已预订")){
			YuDingView fe=new YuDingView(null, "宾客预订房间", true, "2");
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
				JOptionPane.showMessageDialog(fm, "只能修改预订的信息，请从选择","温情提示",1);
			}
			
		}
		
	}else if(o.equals(fm.getAddBt())){
		//添加预订信息按钮监听
		new YuDingView(null, "宾客预订房间", true, "1").setVisible(true);
	}else if(o.equals(fm.getOpenRoomBt())){
		//开房按钮监听
		int row =TabYuDing.getSelectedRow();
		if(row==-1){
			JOptionPane.showMessageDialog(fm, "请选中一行","温情提示",1);
		}else{
			if(TabYuDing.getValueAt(row, 10).equals("已预订")){
				
			LsnrResideFrmBtn.flag=true;       //用于判断新顾客和老顾客
			LsnrRoomMenuFrm.flag = false;     // 用于判断需不需要重新添加房间
			FrmRuZhuRoom frmRuZhuRoom = new FrmRuZhuRoom(fm, "入住登记", true, "入住");	
			String resideId = HotelTools.getNumber(HotelTools.D);
			frmRuZhuRoom.getTxtrzbh().setText(resideId);
			//给预订状态赋值
			frmRuZhuRoom.setYDState((String)TabYuDing.getValueAt(row, 10));
			//给预订编号赋值
			frmRuZhuRoom.setYDId((String)TabYuDing.getValueAt(row, 0));
			
			frmRuZhuRoom.getComfjlx().removeAllItems();        //去除房间的属性
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
				JOptionPane.showMessageDialog(fm, "请从选择已预订的顾客进行入住","温情提示",1);
			}
		}
		
	}else if(o.equals(fm.getJcbxYDState())){
		//过滤预订状态监听
		String[] stateName=fm.getYDStateName();
		for(String a:stateName){
			if(fm.getJcbxYDState().getSelectedItem().equals(a)){
				re.setReserveState(a);
				flushReserveTable(mdlYD.selectYuDingSate(re));
			}
		}
	}
		
	}
	// 刷新预订信息表
		private void flushReserveTable(Vector resultVector) {
			Object[] ReserveColumnNames = fm.getReserveColumnNames();
			Vector columnNamesV = new Vector();
			for (Object temp : ReserveColumnNames) {
				columnNamesV.add(temp);
			}
			fm.getTblReserve().setModel(new DefaultTableModel(resultVector, columnNamesV));

		}

}
