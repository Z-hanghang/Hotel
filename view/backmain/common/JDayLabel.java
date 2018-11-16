package view.backmain.common;

import java.text.*;
import java.util.Date;

import java.awt.*;
import javax.swing.*;


/**
 * <p>Title: JDatePicker</p>
 * <p>Description:JDayLable ��ѡ�����ڹ��ܵ�JLabel </p>
 * @version 1.0
 */


public class JDayLabel extends JLabel{
    /**
   * 
   */
  private static final long serialVersionUID = 1L;

    private static ImageIcon todayIcon =new ImageIcon("pic/1.gif");
//        OpenSwingUtil.getOpenSwingImage("today.gif", new ImageIcon());

    Date date = null;
    ImageIcon currentIcon = null;

    /**
     * ���ڸ�ʽ��TODAY/TIP�ã�
     */
    final SimpleDateFormat dateFormat
        = new SimpleDateFormat("yyyy/MM/dd");
    /**
     * �ո�ʽ
     */
    final SimpleDateFormat dayFormat = new SimpleDateFormat("d");

    public JDayLabel(Date date){
        this(date, true);
    }

    public JDayLabel(Date date, boolean isSmallLabel){
        setPreferredSize(new Dimension(40, 20));
        setToolTipText(dateFormat.format(date));
        this.date = date;
        if(isSmallLabel){
            setHorizontalAlignment(JLabel.CENTER);
            setText(dayFormat.format(date));
            Date d = new Date();
            if(dateFormat.format(date).equals(dateFormat.format(d))){
                currentIcon = todayIcon;
            }
        } else{
            setText("Today:" + dateFormat.format(new Date()));
            setIcon(todayIcon);
            setHorizontalAlignment(JLabel.LEFT);
        }
    }

    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public void paint(Graphics g){
        super.paint(g);
        if(currentIcon != null && isEnabled()){
            int x = (this.getWidth() - currentIcon.getIconWidth()) / 2;
            int y = (this.getHeight() - currentIcon.getIconHeight()) / 2;
            currentIcon.paintIcon(this, g, x, y);
        }
    }
}
