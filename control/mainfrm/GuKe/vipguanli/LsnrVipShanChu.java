package control.mainfrm.GuKe.vipguanli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.mainfrm.customer.MDLCustomer;
import view.mainfrm.GuKeView.guanli.FrmMain;
import vo.mainfrm.GuKe.Vipvo;



/*
 * ͨ����Ա���ɾ��
 */
public class LsnrVipShanChu implements ActionListener {
	 private MDLCustomer mdlVipguanli = new MDLCustomer();
	  
	  private FrmMain frmMain;
	  
	  public LsnrVipShanChu(FrmMain frmMain) {
	    this.frmMain = frmMain;
	  }
	  
	  public void actionPerformed(ActionEvent e) {
	    JTable tblvip = frmMain.getTblVip();
	    
	    int row =tblvip.getSelectedRow();
	    
	    if(row == -1) {
	      JOptionPane.showMessageDialog(frmMain, "��ѡ��һ�����ݣ�");
	    } else {
	      int option = JOptionPane.showConfirmDialog(frmMain, "ȷ��ɾ��������", "��ʾ", 
	          JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
	      
	      if(option == JOptionPane.OK_OPTION) {
	        Vipvo voDelete = new Vipvo ();
	        voDelete.setVipid((String)tblvip.getValueAt(row, 0));
	        mdlVipguanli.shanChuVip(voDelete);
	        
	        //ˢ�»�ԱJTable
	       Vipvo vo = new  Vipvo();
	       
	        Vector resultVector = mdlVipguanli.chaZhaoVipByVipId(vo);
	        
	        Object[] vipColumnNames = this.frmMain.getVipColumnNames();
	        
	        Vector columnNamesV = new Vector();
	        for(int i = 0; i < vipColumnNames.length; i++) {
	          columnNamesV.add(vipColumnNames[i]);
	        }
	        
	        frmMain.getTblVip().setModel(
	            new DefaultTableModel(resultVector, columnNamesV));
	        
	      }
	    }
	  }

}
