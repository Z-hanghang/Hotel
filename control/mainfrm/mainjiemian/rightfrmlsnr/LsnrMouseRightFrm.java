package control.mainfrm.mainjiemian.rightfrmlsnr;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.mainfrm.mainjiemian.FrmHotelMain;
import view.mainfrm.mainjiemian.FrmLeftTopMain;
import view.mainfrm.mainjiemian.FrmRightTopMain;

/**
 * 鼠标监听器的设置，添加RightTop的鼠标监听器，判断点击事件
 * @author 吴阿龙
 *
 */
public class LsnrMouseRightFrm extends MouseAdapter {
    private FrmRightTopMain frmRightTop;
	
	public LsnrMouseRightFrm(FrmRightTopMain frmRightTop) {
		this.frmRightTop = frmRightTop;
	}

	/*
	 * 鼠标点击事件的发生
	 */
	public void mouseClicked (MouseEvent me) {
		Object o = me.getSource();
		if(o == frmRightTop.getRtp_tb()) {
			frmRightTop.tb_Name = frmRightTop.getRtp_tb().getTitleAt(frmRightTop.getRtp_tb().getSelectedIndex());		//获得当前标签栏标题
			FrmLeftTopMain.title0.setText(frmRightTop.tb_Name + ": ");
			return;
		}
		if(o == frmRightTop.getRtbt1()) {							//过滤状态
			int x = me.getX();
			int y = me.getY();
			frmRightTop.getPm().show(frmRightTop.getRtbt1(), x, y);
			return;
		}
		if(o == frmRightTop.getRtbt4()) {                // 图标大小的按钮
			int x = me.getX();
			int y = me.getY();
			frmRightTop.getTubiao().show(frmRightTop.getRtbt4(), x, y);
			return;
		}
		
	}
	
	/*
	 * 鼠标移进提示
	 */
	public void mouseEntered (MouseEvent me) {		
		Object o = me.getSource ();
		if(o == frmRightTop.getRtbt1()) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
			"按照指定的状态显示房间信息   　　　　　　　　　　　　　　");
		}else if(o == frmRightTop.getRtbt2()) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
			"显示所有的房间信息   　　　　　　　　　　　　　　　　　　");
		}else if(o == frmRightTop.getRtbt3()) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
			"刷新当前房间信息显示   　　　　　　　　　　　　　　　　　");
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
