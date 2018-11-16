package common.component.tools;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.GregorianCalendar;
import java.util.Properties;
/**
 * 自动生成编号
 * 
 * 
 * ***/
public class HotelTools {
	public static final int YD	= 0;        //表示预定编号
	public static final int D	= 1;        //表示入住单号
	public static final int AC	= 2;        //表示结算单号
	public static final int CS  = 3;        //换房记录编号
	public static final int G = 4;			//表示顾客编号
    public static  final int VIP=5;         //表示会员编号
    public static final int EM= 6;		//表示员工编号
    
    private static Properties ini = null;
	
	static {
		try	{
			ini = new Properties ();
			ini.load (new FileInputStream ("配置文件/Config.ini"));
		}catch (Exception ex) {
			System.out.println ("the config.ini false!!");
		}//End try
	}
	
	/**
	 * 		功能   ：自动分配单据编号, 自动递增
	 */
    public static String getNumber (int type) {
		
		GregorianCalendar gc = new GregorianCalendar();
		String tp=null, number = null;
		//int numLen = 0;						//单号的默认位数
		
		if(type == YD) {				//要获预定单号
			tp = getIniKey ("YuDingName");
			number = getIniKey ("YuDingNumber");
		}else if(type == D){					//要获取入住单号
			tp = getIniKey ("RuZhuName");
			number = getIniKey ("RuZhuNumber");
		}else if(type == AC){
			tp = getIniKey ("JieSuanName");
			number = getIniKey ("JieSuanNumber");
		}else if(type == CS) {
			tp = getIniKey ("CsrecordName");
			number = getIniKey ("CsrecordNumber");
		}else if(type == G) {
			tp = getIniKey("CustomerName");
			number = getIniKey ("CustomerNumber");
		}else if(type == VIP) {
			tp = getIniKey("VIPName");
			number = getIniKey ("VIPNumber");
		}else if(type == EM) {
			tp = getIniKey("EmployeeName");
			number = getIniKey ("EmployeeNumber");
		}
		number = Integer.parseInt (number) + 1 + "";	//将单号增1,再转成字符串
		tp = tp + number;
		
		return tp;			//返回单号
	}
	
    /**
     *  	功能   ：将已用编号保存到INI文件
     */
    public static void savNumber (String num, int type) {
		//INI文件中的键名
		String ini[] = { "[NUMBER]","YuDingName","YuDingNumber","RuZhuName",
				        "RuZhuNumber","JieSuanName","JieSuanNumber","CsrecordName","CsrecordNumber","CustomerName","CustomerNumber",
				        "VIPName","VIPNumber","EmployeeName","EmployeeNumber"};
		String bt;
		if(type == YD) {
			bt = getIniKey ("YuDingName");
			setIniKey ("YuDingNumber", num.substring (bt.length () ));
		}
		else if(type == D){
			bt = getIniKey ("RuZhuName");
			setIniKey ("RuZhuNumber", num.substring (bt.length () ));
		} 
		else if(type == AC){
			bt = getIniKey ("JieSuanName");
			setIniKey ("JieSuanNumber", num.substring (bt.length () ));
		}
		else if(type == CS) {
			bt = getIniKey ("CsrecordName");
			setIniKey ("CsrecordNumber", num.substring (bt.length () ));
		}
		else if(type == G) {
			bt = getIniKey ("CustomerName");
			setIniKey ("CustomerNumber", num.substring (bt.length () ));
		}else if(type == VIP) {
			bt = getIniKey ("VIPName");
			setIniKey ("VIPNumber", num.substring (bt.length () ));
		}else if(type == EM) {
			bt = getIniKey ("EmployeeName");
			setIniKey ("EmployeeNumber", num.substring (bt.length () ));
		}
		
		//保存到INI文件
		saveIni (ini);
	}
	
	
	/**			功能   ：获得INI文件中的指定键的键值
	 */
	public static String getIniKey (String k) {
		if(!ini.containsKey (k)) {		//是否有 k 这个键
			System.out.println ("The" + k + "Key is not exist!!");
			return "";
		}
		return ini.get (k).toString ();
	}
	public static void setIniKey (String k, String v) {
		if(!ini.containsKey (k)) {		//是否有 k 这个键
			System.out.println ("The " + k + "Key is not exist!!");
			return;
		}
		ini.put (k, v);
	}
	
	/**功能   ：将k字符数组中所有键所对应的键值保存到INI文件中
	 */
	public static void saveIni (String k[]) {
		try	{
			FileWriter fw = new FileWriter ("配置文件/Config.ini");
			BufferedWriter bw = new BufferedWriter ( fw );
			//循环变量i是k字符串数组的下标
			for (int i = 0; i < k.length; i++) {
				bw.write (k[i] + "=" + getIniKey (k[i]));
				bw.newLine ();
			}
			bw.close ();
			fw.close ();
		}catch (Exception ex) {
			System.out.println ("Save CONFIG.INI is false.");
		}
	}
/*	public static void main(String[] args) {
		String s=HotelTools.getNumber(HotelTools.EM);
		HotelTools.savNumber(s,HotelTools.EM);
		System.out.println(s);
		
	}
*/	
}
