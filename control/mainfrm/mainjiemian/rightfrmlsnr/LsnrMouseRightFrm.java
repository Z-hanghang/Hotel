package control.mainfrm.mainjiemian.rightfrmlsnr;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.mainfrm.mainjiemian.FrmHotelMain;
import view.mainfrm.mainjiemian.FrmLeftTopMain;
import view.mainfrm.mainjiemian.FrmRightTopMain;

/**
 * �������������ã����RightTop�������������жϵ���¼�
 * @author �Ⱒ��
 *
 */
public class LsnrMouseRightFrm extends MouseAdapter {
    private FrmRightTopMain frmRightTop;
	
	public LsnrMouseRightFrm(FrmRightTopMain frmRightTop) {
		this.frmRightTop = frmRightTop;
	}

	/*
	 * ������¼��ķ���
	 */
	public void mouseClicked (MouseEvent me) {
		Object o = me.getSource();
		if(o == frmRightTop.getRtp_tb()) {
			frmRightTop.tb_Name = frmRightTop.getRtp_tb().getTitleAt(frmRightTop.getRtp_tb().getSelectedIndex());		//��õ�ǰ��ǩ������
			FrmLeftTopMain.title0.setText(frmRightTop.tb_Name + ": ");
			return;
		}
		if(o == frmRightTop.getRtbt1()) {							//����״̬
			int x = me.getX();
			int y = me.getY();
			frmRightTop.getPm().show(frmRightTop.getRtbt1(), x, y);
			return;
		}
		if(o == frmRightTop.getRtbt4()) {                // ͼ���С�İ�ť
			int x = me.getX();
			int y = me.getY();
			frmRightTop.getTubiao().show(frmRightTop.getRtbt4(), x, y);
			return;
		}
		
	}
	
	/*
	 * ����ƽ���ʾ
	 */
	public void mouseEntered (MouseEvent me) {		
		Object o = me.getSource ();
		if(o == frmRightTop.getRtbt1()) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
			"����ָ����״̬��ʾ������Ϣ   ����������������������������");
		}else if(o == frmRightTop.getRtbt2()) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
			"��ʾ���еķ�����Ϣ   ������������������������������������");
		}else if(o == frmRightTop.getRtbt3()) {
			FrmHotelMain.lbA.setText (FrmHotelMain.clue + 
			"ˢ�µ�ǰ������Ϣ��ʾ   ����������������������������������");
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
