package common.component.tools;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.GregorianCalendar;
import java.util.Properties;
/**
 * �Զ����ɱ��
 * 
 * 
 * ***/
public class HotelTools {
	public static final int YD	= 0;        //��ʾԤ�����
	public static final int D	= 1;        //��ʾ��ס����
	public static final int AC	= 2;        //��ʾ���㵥��
	public static final int CS  = 3;        //������¼���
	public static final int G = 4;			//��ʾ�˿ͱ��
    public static  final int VIP=5;         //��ʾ��Ա���
    public static final int EM= 6;		//��ʾԱ�����
    
    private static Properties ini = null;
	
	static {
		try	{
			ini = new Properties ();
			ini.load (new FileInputStream ("�����ļ�/Config.ini"));
		}catch (Exception ex) {
			System.out.println ("the config.ini false!!");
		}//End try
	}
	
	/**
	 * 		����   ���Զ����䵥�ݱ��, �Զ�����
	 */
    public static String getNumber (int type) {
		
		GregorianCalendar gc = new GregorianCalendar();
		String tp=null, number = null;
		//int numLen = 0;						//���ŵ�Ĭ��λ��
		
		if(type == YD) {				//Ҫ��Ԥ������
			tp = getIniKey ("YuDingName");
			number = getIniKey ("YuDingNumber");
		}else if(type == D){					//Ҫ��ȡ��ס����
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
		number = Integer.parseInt (number) + 1 + "";	//��������1,��ת���ַ���
		tp = tp + number;
		
		return tp;			//���ص���
	}
	
    /**
     *  	����   �������ñ�ű��浽INI�ļ�
     */
    public static void savNumber (String num, int type) {
		//INI�ļ��еļ���
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
		
		//���浽INI�ļ�
		saveIni (ini);
	}
	
	
	/**			����   �����INI�ļ��е�ָ�����ļ�ֵ
	 */
	public static String getIniKey (String k) {
		if(!ini.containsKey (k)) {		//�Ƿ��� k �����
			System.out.println ("The" + k + "Key is not exist!!");
			return "";
		}
		return ini.get (k).toString ();
	}
	public static void setIniKey (String k, String v) {
		if(!ini.containsKey (k)) {		//�Ƿ��� k �����
			System.out.println ("The " + k + "Key is not exist!!");
			return;
		}
		ini.put (k, v);
	}
	
	/**����   ����k�ַ����������м�����Ӧ�ļ�ֵ���浽INI�ļ���
	 */
	public static void saveIni (String k[]) {
		try	{
			FileWriter fw = new FileWriter ("�����ļ�/Config.ini");
			BufferedWriter bw = new BufferedWriter ( fw );
			//ѭ������i��k�ַ���������±�
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
