package control.mainfrm.checkinControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import model.mainfrm.checkinmodel.MDLcheckin;
import view.mainfrm.checkinview.Frmcheckin;
import vo.mainfrm.ruzhucha.checkinvo.checkinVO;

public class LsnrBtnradiobutton implements ActionListener {
	
	  private MDLcheckin mdlruzhu = new MDLcheckin();
	  
	  private Frmcheckin ruzhu;
	  
	  public LsnrBtnradiobutton(Frmcheckin ruzhu) {
	       this.ruzhu = ruzhu;
	  }
	  public void actionPerformed(ActionEvent e) {
		  Object o = e.getSource();
		  if(this.ruzhu.getS1().equals(o)){//���ѡ��S1��ť����ʾ�ѽ��˷�����Ϣ
			  checkinVO vo = new checkinVO();
			 vo.setjiezhangzhuangtai("1");
			 
			  Vector resultVector = mdlruzhu.yijiezhangruzhuxinxi(vo);
			  Object[] fangjianColumnNames  = this.ruzhu.getfangjianColumnNames ();
			  //ˢ���б�
			  Vector columnNamesV = new Vector();
			  for(int i = 0; i < fangjianColumnNames .length; i++) {
				  columnNamesV.add(fangjianColumnNames [i]);
			  }
			  
			  ruzhu.gettblfangjian().setModel(new DefaultTableModel(resultVector, columnNamesV));
		  }//ȷ���Ƿ�ѡ��
		  if(this.ruzhu.getS2().equals(o)){//���ѡ��S2��ť����ʾδ���˷�����Ϣ
			  checkinVO vo = new checkinVO();
			 vo.setjiezhangzhuangtai("0");
			  Vector resultVector = mdlruzhu.weijiezhangruzhuxinxi(vo);
			 Object[] fangjianColumnNames  = this.ruzhu.getfangjianColumnNames ();
			  //ˢ���б�
			  Vector columnNamesV = new Vector();
			  for(int i = 0; i < fangjianColumnNames .length; i++) {
				  columnNamesV.add(fangjianColumnNames [i]);
			  }
			  ruzhu.gettblfangjian().setModel(new DefaultTableModel(resultVector, columnNamesV));
		  }
		  if(this.ruzhu.getS3().equals(o)){//���ѡ��S3��ť����ʾ���з�����Ϣ
			  checkinVO vo = new checkinVO();
			  
			  Vector resultVector = mdlruzhu.allnews(vo);
			  Object[] fangjianColumnNames  = this.ruzhu.getfangjianColumnNames ();
			  //ˢ���б�
			  Vector columnNamesV = new Vector();
			  for(int i = 0; i < fangjianColumnNames .length; i++) {
				  columnNamesV.add(fangjianColumnNames [i]);
			  }
			  
			  ruzhu.gettblfangjian().setModel(new DefaultTableModel(resultVector, columnNamesV));
		  }
		  
	}
		    
}
	  
		
  
  
