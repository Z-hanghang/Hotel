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
		  if(this.ruzhu.getS1().equals(o)){//如果选中S1按钮，显示已结账房间信息
			  checkinVO vo = new checkinVO();
			 vo.setjiezhangzhuangtai("1");
			 
			  Vector resultVector = mdlruzhu.yijiezhangruzhuxinxi(vo);
			  Object[] fangjianColumnNames  = this.ruzhu.getfangjianColumnNames ();
			  //刷新列表
			  Vector columnNamesV = new Vector();
			  for(int i = 0; i < fangjianColumnNames .length; i++) {
				  columnNamesV.add(fangjianColumnNames [i]);
			  }
			  
			  ruzhu.gettblfangjian().setModel(new DefaultTableModel(resultVector, columnNamesV));
		  }//确认是否被选中
		  if(this.ruzhu.getS2().equals(o)){//如果选中S2按钮，显示未结账房间信息
			  checkinVO vo = new checkinVO();
			 vo.setjiezhangzhuangtai("0");
			  Vector resultVector = mdlruzhu.weijiezhangruzhuxinxi(vo);
			 Object[] fangjianColumnNames  = this.ruzhu.getfangjianColumnNames ();
			  //刷新列表
			  Vector columnNamesV = new Vector();
			  for(int i = 0; i < fangjianColumnNames .length; i++) {
				  columnNamesV.add(fangjianColumnNames [i]);
			  }
			  ruzhu.gettblfangjian().setModel(new DefaultTableModel(resultVector, columnNamesV));
		  }
		  if(this.ruzhu.getS3().equals(o)){//如果选中S3按钮，显示所有房间信息
			  checkinVO vo = new checkinVO();
			  
			  Vector resultVector = mdlruzhu.allnews(vo);
			  Object[] fangjianColumnNames  = this.ruzhu.getfangjianColumnNames ();
			  //刷新列表
			  Vector columnNamesV = new Vector();
			  for(int i = 0; i < fangjianColumnNames .length; i++) {
				  columnNamesV.add(fangjianColumnNames [i]);
			  }
			  
			  ruzhu.gettblfangjian().setModel(new DefaultTableModel(resultVector, columnNamesV));
		  }
		  
	}
		    
}
	  
		
  
  
