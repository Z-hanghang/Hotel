package control.mainfrm.mainjiemian.mainbtnlsnr;
/**
 * ��������������
 * ���ܣ� Ϊ���������ƶ�����Ӧ�Ĺ���ѡ���ϣ�ҳ�����湦����ʾ����ʾ��ʾ��Ϣ
 * @author �Ⱒ��
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
	 * ����ƽ���ʾ
	 */
	public void mouseEntered (MouseEvent me) {		
		Object o = me.getSource ();
		if(frmHotelMain.getFangjianguanlibt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"�ڸ��������н��з����ά������   ��������������������");
		}else if(frmHotelMain.getYudingguanlibt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"����Ԥ�������Ԥ����ѯ�Ĺ���   ��������������������");
		}else if(frmHotelMain.getRuzhudengjibt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"���з�����ס�Ǽǲ������û�����   ��������������������");
		}else if(frmHotelMain.getRuzhuchaxunbt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"���ݷ���Ż��û����������ڱ��Ƶ���ס����Ϣ   ����������������");
		}else if(frmHotelMain.getTuifangjiezhangbt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"���з�������˷�����   ����������������");
		}else if(frmHotelMain.getKehuguanlibt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"�Ա��Ƶ��еĿͻ���Ϣ���й���   ����������������");
		}else if(frmHotelMain.getZengjiaxiaofeibt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"���ݷ�������Ӷ������Ʒ����   ����������������");
		}else if(frmHotelMain.getJiesuanselectbt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"�����û��ṩ����Ϣ���н���������Ϣ�Ĳ���   ����������������");
		}else if(frmHotelMain.getAboutus().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"���ڱ��Ƶ���Ŀ����Ϣ��ʾ   ����������������");
		}else if(frmHotelMain.getHuanbanbt().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"�л�Ա����¼   ����������������");
		}else if(frmHotelMain.getQuitsystem().equals(o)) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
					"�˳���ϵͳ   ����������������");
		}
	}
	
	/**
	 * ����˳��ָ���ʾ��Ϣ
	 */
	public void mouseExited (MouseEvent me) {
		FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
		"��ѡ������ ...   ����������������������������������������");
	}

}
