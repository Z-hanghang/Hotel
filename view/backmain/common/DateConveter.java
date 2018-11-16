package view.backmain.common;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConveter {
  public static Date strNoTimetoDate(String str) {
    Date date = null;
    SimpleDateFormat formatter = new SimpleDateFormat("MM-yyyy-dd");
    try {
      date = new Date(formatter.parse(str).getTime());
    } catch (ParseException e) {
      System.out.println("×ª»»Ê§°Ü¡£¡£¡£");
      e.printStackTrace();
    }
    return date;
  }
  
  public static Date strWithTimetoDate(String str) {
    Date date = null;
    SimpleDateFormat formatter = new SimpleDateFormat("MM-yyyy-dd HH:mm:ss");
    try {
      date = new Date(formatter.parse(str).getTime());
    } catch (ParseException e) {
      System.out.println("×ª»»Ê§°Ü¡£¡£¡£");
      e.printStackTrace();
    }
    return date;
  }
  
  public static String dateToStringNoTime(Date date) {
    String str = null;
    SimpleDateFormat formatter = new SimpleDateFormat("MM-yyyy-dd");
    str = formatter.format(date);
    return str;
  }
  
  public static String dateToStringWithTime(Date date) {
    String str = null;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
    str = formatter.format(date);
    return str;
  }
  
  
  /*public static void main(String[] args) {
    System.out.println(dateToStringWithTime(new Date(System.currentTimeMillis())));
  }*/
}
