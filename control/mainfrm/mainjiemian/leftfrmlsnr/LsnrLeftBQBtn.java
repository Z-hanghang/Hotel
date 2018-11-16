package control.mainfrm.mainjiemian.leftfrmlsnr;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.mainfrm.common.JiSuanQi;
import view.mainfrm.common.Mp3;
import view.mainfrm.common.TestCalendar;
import view.mainfrm.mainjiemian.FrmLeftTopMain;
import view.mainfrm.reside.FrmRuZhuRoom;

public class LsnrLeftBQBtn implements ActionListener {

	private FrmLeftTopMain frmLeftTopMain;

	public LsnrLeftBQBtn(FrmLeftTopMain frmLeftTopMain) {
		this.frmLeftTopMain = frmLeftTopMain;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (frmLeftTopMain.getJisuanqi().equals(o)) {
			new JiSuanQi(null, "º∆À„∆˜", true, "º∆À„").setVisible(true);
		}else if(frmLeftTopMain.getRili().equals(o)){
			 new TestCalendar().setVisible(true);
				
		}else if(frmLeftTopMain.getYinyue().equals(o)){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Mp3 frame = new Mp3();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
	}
}
