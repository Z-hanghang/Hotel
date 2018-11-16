package control.mainfrm.balanceControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.mainfrm.balancemodel.MDLroombalance;
import model.mainfrm.checkinmodel.MDLcheckin;
import view.mainfrm.balanceview.FRMbalance;
import view.mainfrm.checkinview.Frmcheckin;
import vo.mainfrm.ruzhucha.balancevo.roombalanceVO;

public class LsnrBtnfindroom  implements ActionListener {

	  private MDLroombalance mdljiesuan = new MDLroombalance();
	  
	  private FRMbalance jiesuan;
	  
	  public LsnrBtnfindroom(FRMbalance jiesuan) {
	       this.jiesuan = jiesuan;
	  }
	  
	  public void actionPerformed(ActionEvent e) {
	      roombalanceVO vo = new roombalanceVO();
	    vo.setfangjianhaofj(jiesuan.getTxtfangjianhaofj().getText());
	    vo.setjiezhangzhuangtaifj(jiesuan.txtjiezhangzhuangtaifj().getText());
	    String fangjianhaofj = vo.getfangjianhaofj(); 
	    String jiezhangzhuangtaifj = vo.getjiezhangzhuangtaifj();
	    //�������źͽ���״̬��û��������Ϣ����������������
	   /*if(fangjianhaofj.equals("")&&jiezhangzhuangtaifj.equals("")){
		   	JOptionPane.showMessageDialog(null, "������Ҫ���������ݣ�");
		    }*/
	    //Vector resultVector = mdljiesuan.chaZhaoQuanBujiesuanxinxi((vo));
	    Vector resultVector = mdljiesuan. findNewsByMessage(vo);
	    
	    Object[] fangjianColumnNames  = this.jiesuan.getfangjianColumnNames ();
	    //ˢ���б�
	    Vector columnNamesV = new Vector();
	    for(int i = 0; i < fangjianColumnNames.length; i++) {
	      columnNamesV.add(fangjianColumnNames [i]);
	    }
	  
	    jiesuan.getTblfangjian().setModel(new DefaultTableModel(resultVector, columnNamesV));
	  }  
}

