package control.mainfrm.mainjiemian.mainbtnlsnr;
/**
 * 主界面鼠标监听器
 * 功能： 为主界面中移动到相应的功能选项上，页面下面功能提示栏显示提示信息
 * @author 吴阿龙
 *
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.mainfrm.mainjiemian.FrmHotelMain;

public class LsnrMouseFrmMain extends MouseAdapter {
	
	private FrmHotelMain frmHotelMain;
	
	public LsnrMouseFrmMain(FrmHotelMain frmHotelMain){
		this.frmHotelMain = frmHotelMain;
	}
	
	/*
	 * 鼠标移进提示
	 */
	public void mouseEntered (MouseEvent me) {		
		Object o = me.getSource ();
		if(frmHotelMain.getFangjianguanlibt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"在该主界面中进行房间的维护管理   　　　　　　　　　　");
		}else if(frmHotelMain.getYudingguanlibt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"进行预订管理和预订查询的功能   　　　　　　　　　　");
		}else if(frmHotelMain.getRuzhudengjibt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"进行房间入住登记并安排用户房间   　　　　　　　　　　");
		}else if(frmHotelMain.getRuzhuchaxunbt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"根据房间号或用户姓名查找在本酒店入住的信息   　　　　　　　　");
		}else if(frmHotelMain.getTuifangjiezhangbt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"进行房间结算退房功能   　　　　　　　　");
		}else if(frmHotelMain.getKehuguanlibt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"对本酒店中的客户信息进行管理   　　　　　　　　");
		}else if(frmHotelMain.getZengjiaxiaofeibt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"根据房间号增加额外的商品消费   　　　　　　　　");
		}else if(frmHotelMain.getJiesuanselectbt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"根据用户提供的信息进行结算消费信息的查找   　　　　　　　　");
		}else if(frmHotelMain.getAboutus().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"关于本酒店项目的信息显示   　　　　　　　　");
		}else if(frmHotelMain.getHuanbanbt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"切换员工登录   　　　　　　　　");
		}else if(frmHotelMain.getQuitsystem().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"退出该系统   　　　　　　　　");
		}
	}
	
	/**
	 * 鼠标退出恢复提示信息
	 */
	public void mouseExited (MouseEvent me) {
		FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
		"请选择功能项 ...   　　　　　　　　　　　　　　　　　　　　");
	}

}
