package control.mainfrm.balanceControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.mainfrm.balancemodel.MDLroombalance;
import model.mainfrm.balancemodel.MDLgoodsbalance;
import view.mainfrm.balanceview.FRMbalance;
import vo.mainfrm.ruzhucha.balancevo.goodsbalanceVO;


public class LsnrBtnfindgoods implements ActionListener {

	private MDLgoodsbalance mdljiesuan = new MDLgoodsbalance();
	  
	  private FRMbalance jiesuan;
	  
	  public LsnrBtnfindgoods(FRMbalance jiesuan) {
	       this.jiesuan = jiesuan;
	  }
	  
	  public void actionPerformed(ActionEvent e) {
	      goodsbalanceVO vo = new goodsbalanceVO();
	    vo.setfangjianhaosp(jiesuan.txtFangJianhaosp().getText());
	    vo.setjiezhangzhuangtaisp(jiesuan.txtjiezhangzhuangtaisp().getText());
	    String fangjianhaosp = vo.getfangjianhaosp(); 
	    String jiezhangzhuangtaisp = vo.getjiezhangzhuangtaisp();
	    //�������źͽ���״̬��û��������Ϣ����������������
	    /*if(fangjianhaosp.equals("")&&jiezhangzhuangtaisp.equals("")){
		   	JOptionPane.showMessageDialog(null, "������Ҫ���������ݣ�");
		    }*/
	    Vector resultVector = mdljiesuan.findNewsBymessage((vo));
	     //ˢ���б�
	    Object[] shangpinColumnNames  = this.jiesuan.getshangpinColumnNames ();
	    
	    Vector columnNamesV = new Vector();
	 
		for(int i = 0; i < shangpinColumnNames.length; i++) {
	      columnNamesV.add(shangpinColumnNames[i]);
	    }
	  
	    jiesuan.getTblshangpin().setModel(new DefaultTableModel(resultVector, columnNamesV));
	  }  
}
