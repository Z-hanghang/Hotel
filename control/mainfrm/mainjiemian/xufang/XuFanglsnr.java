package control.mainfrm.mainjiemian.xufang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import control.mainfrm.mainjiemian.roommenu.LsnrRoomMenuFrm;
import model.mainfrm.residefrm.MDLReside;
import view.mainfrm.mainjiemian.FrmXuFang;
import vo.mainfrm.ResideVO;

public class XuFanglsnr implements ActionListener {

	private FrmXuFang frmXuFang;
	
	public XuFanglsnr(FrmXuFang frmXuFang) {
		this.frmXuFang = frmXuFang;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(frmXuFang.getQueding().equals(e.getSource())) {
			ResideVO vo = new ResideVO();
			MDLReside mdlReside = new MDLReside();
			vo.setRoomID(LsnrRoomMenuFrm.roomID);
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss");
			// String ruzhuDate =
			// sdf.format(frmRuZhuRoom.getRuzhudatePickerFrom().getSelectedDate());//从界面获取输入的日期
			try {
				vo.setResideLtime(frmXuFang.getDatePickerFrom().getSelectedDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			mdlReside.updateResideLTime(vo);
			frmXuFang.dispose();
			return;
		}else if(frmXuFang.getQuxiao().equals(e.getSource())) {
			frmXuFang.dispose();
		}

	}

}
