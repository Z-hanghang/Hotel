package view.mainfrm.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JLabel;

public class CalendaBean implements ActionListener {
	JLabel[] label;
	JLabel now;
	String[] day;
	int year = 0, month = 0;
	public void setYear(int year) {
		this.year = year;
	}
 
	public void setMonth(int month) {
		this.month = month;
	}
 
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("lastmonth")) {
			month--;
			if (month == 0) {
				month = 12;
				year--;
			}
		}
		else if (str.equals("nextmonth")) {
			month++;
			if (month == 13) {
				month = 1;
				year++;
			}
		}
		now.setText("日历:" + year + "年" + month + "月");
		String[] a = getCalendar();
		for (int i = 0; i < a.length; i++) {
			label[i].setText("          "+a[i]);
		}
		
	}
 
	public String[] getCalendar() {
		String[] a = new String[42];
		Calendar rili = Calendar.getInstance();
		rili.set(year, month - 1, 1);
		int weekDay = rili.get(Calendar.DAY_OF_WEEK) - 1;
		int day = 0;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			day = 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = 30;
		}
		if (month == 2) {
			if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
				day = 29;
			else
				day = 28;
		}
		for (int i = 0; i < weekDay; i++)
			a[i] = " ";
		for (int i = weekDay, n = 1; i < weekDay + day; i++) {
			a[i] = String.valueOf(n);
			n++;
		}
		for (int i = weekDay + day; i < a.length; i++)
			a[i] = " ";
		return a;
	}

}
