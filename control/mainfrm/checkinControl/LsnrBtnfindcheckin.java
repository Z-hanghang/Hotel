package control.mainfrm.checkinControl;

//import gui.guanli.FrmMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.mainfrm.checkinmodel.MDLcheckin;
import view.mainfrm.checkinview.Frmcheckin;
import vo.mainfrm.ruzhucha.checkinvo.checkinVO;


public class LsnrBtnfindcheckin implements ActionListener {

	  private MDLcheckin mdlruzhu = new MDLcheckin();
	  
	  private Frmcheckin ruzhu;
	  
	  public LsnrBtnfindcheckin(Frmcheckin ruzhu) {
	       this.ruzhu = ruzhu;
	  }
	  
	  public void actionPerformed(ActionEvent e) {
	      checkinVO vo = new checkinVO();
	   vo.setfangjianhao(ruzhu.getTxtFangJianHao().getText());
	   vo.setgukeming(ruzhu.getTxtgukeming().getText());
	    Vector resultVector = mdlruzhu.findnews(vo);
	    String fangjianhao = vo.getfangjianhao(); 
	    String gukeming=vo.getgukeming();
	   /*if(fangjianhao.equals("")&&gukeming.equals("")){//�������ź͹˿�����û���������ݣ�������
    	JOptionPane.showMessageDialog(null, "������Ҫ���������ݣ�");
	   	}*/
	    Object[] fangjianColumnNames  = this.ruzhu.getfangjianColumnNames ();
	    //ˢ�±��
	    Vector columnNamesV = new Vector();
	    for(int i = 0; i < fangjianColumnNames.length; i++) {
	      columnNamesV.add(fangjianColumnNames [i]);
	    }
	    
	    ruzhu.gettblfangjian().setModel(new DefaultTableModel(resultVector, columnNamesV));
	  }  
}

