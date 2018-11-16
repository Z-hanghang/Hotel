package control.mainback.lsnAddEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import view.backmain.BackMainView.AddEmployeeView.AddEmployeeView;
/**
 * 添加员工界面的生日监听器
 * 
 * **/

public class LsnrDate implements ActionListener {
	 private AddEmployeeView aw;
	 public LsnrDate(AddEmployeeView aw) {
			this.aw=aw;
		}

	public void actionPerformed(ActionEvent e) {
		
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  
	try {
		 String  strDate = formatter.format(aw.getDatePickerTo().getSelectedDate());
		  aw.getTxtEbirthday().setText(strDate);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 
		    
	
	
	}

}
