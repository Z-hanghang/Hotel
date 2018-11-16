package view.mainfrm.mainjiemian;

/**
 *
 *
 *	[ ��Ŀ��      ]  : �Ƶ����ϵͳ
 *	[ ģ����      ]  : �������ұ߷�����Ϣ���
 *	[ �ļ���      ]  : FrmRightMain.java
 *	[ ����ļ�    ]  : 
 *	[ �ļ�ʵ�ֹ���]  : ��ViewList�ؼ�˼�룬ʵ�ַ���ͼ�껯
 *	[ ����        ]  : �Ⱒ��
 *	[ �汾        ]  : 1.0
 *	----------------------------------------------------------------------------
 *	[ ��ע        ]  : 
 *	----------------------------------------------------------------------------
 *	[ �޸ļ�¼    ]  : 
 *
 *	[ ��  �� ]     [�汾]         [�޸���]         [�޸�����] 
 *	2018/10/16    1.0                         �Ⱒ��                      ����
 *
 *  [ ��������    ]  : 
 *
 */

import javax.swing.*;
import javax.swing.border.LineBorder;

import common.component.swings.TJButton;
import common.component.swings.ViewList;
import control.mainfrm.mainjiemian.rightfrmlsnr.LsnrMouseRightFrm;
import control.mainfrm.mainjiemian.rightfrmlsnr.LsnrRightFrm;
import control.mainfrm.mainjiemian.roommenu.LsnrRightMenu;
import control.mainfrm.mainjiemian.roommenu.LsnrRoomMenuFrm;
import dao.mainfrm.mainjiemian.righttopfrm.RoomDAO;
import dao.mainfrm.mainjiemian.righttopfrm.RoomTypeDAO;
import javafx.scene.control.RadioButton;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class FrmRightTopMain extends JPanel {

	private JButton rtbt1, rtbt2, rtbt3, rtbt4; // ��ʾȫ�� ����״̬ ˢ��������ť //����ͼ���С
	private JTabbedPane rtypeTb; // ��ǩ��

	private JPanel rjp_bott; // ����ˢ�µȰ������

	private JPopupMenu pm; // ������˲˵�
	private JMenuItem mi1, mi2, mi3, mi4, mi5; // �˵�����������԰�ť ���ɹ�����ס��Ԥ�����෿��ά����
	
	private JPopupMenu tubiao; // ����ͼ���С�Ĳ˵�
	private JMenuItem tub1, tub2, tub3; // �˵�����״̬���ֱ��Ǵ���С
	
	private JPopupMenu prm; // ������˲˵�  prm
	private JMenuItem mri1, mri2, mri3, mri4, mri5, mri6, mri8, mri9;  // ���������˵�ѡ��Ϊmri
	private JMenu mri7;  // ���巿��״̬�޸ĵĶ����˵�
	

	private JMenuItem rtm1, rtm2, rtm3, rtm4, rtm5;   //��Ӧ�����״̬
	    
	
	private LsnrRoomMenuFrm LsnrRoomMenuFrm = new LsnrRoomMenuFrm(this);  // ���ڷ����Ҽ���ʾ�˵�

	// ���淿������ViewList�ؼ����Ĺ�ϣ��
	private static Hashtable ht;
	
	public static Hashtable fjlx;
	// ��ǰ��ǩ��ҳ
	public static String tb_Name;
	
//	public static String[] tbb_N;

	// ɸѡ������Ϣ������ ������ʾ
	private String sqlProviso = "";

	/*
	 * ��ɸѡ���������޸�
	 */
	public void setSqlProviso(String sqlProviso) {
		this.sqlProviso = sqlProviso;
	}

	/**
	 * public RightTopPanel() {} ���� ���齨�������ұ߷�����Ϣ���
	 */
	public FrmRightTopMain() {
		super(new BorderLayout());
		init();
	}
	
	public String getTb_Name() {
		return tb_Name;
	}

	public JButton getRtbt1() {          //����״̬������ť
		return rtbt1;
	}

	public JButton getRtbt2() {
		return rtbt2;
	}

	public JButton getRtbt3() {
		return rtbt3;
	}
	
	public JPopupMenu getPm() {           //���˲˵���get
		return pm;
	}

	public JMenuItem getMi1() {
		return mi1;
	}

	public JMenuItem getMi2() {
		return mi2;
	}

	public JMenuItem getMi3() {
		return mi3;
	}

	public JMenuItem getMi4() {
		return mi4;
	}

	public JMenuItem getMi5() {
		return mi5;
	}

	public JTabbedPane getRtp_tb() {    //����������
		return rtypeTb;
	}
	
	public JPopupMenu getPrm() {      //�����Ҽ��˵�ѡ��
		return prm;
	}
	
	public JMenuItem getMri1() {       // Ԥ���Ǽ�
		return mri1;
	}

	public JMenuItem getMri2() {       // ��ס�Ǽ�
		return mri2;
	}

	public JMenuItem getMri3() {       // ��������
		return mri3;
	}

	public JMenuItem getMri4() {       // ��������
		return mri4;
	}

	public JMenuItem getMri5() {       // �˷�����
		return mri5;
	}

	public JMenuItem getMri6() {       // ����
		return mri6;
	}

	public JMenu getMri7() {       // �޸ķ�̬  ����״̬�����˵�
		return mri7;
	}

	public JMenuItem getMri8() {       // ��ɨ�ɾ�
		return mri8;
	}

	public JMenuItem getMri9() {       // ���ɱ���
		return mri9;
	}
	
	public JMenuItem getRtm1() {        // ���
		return rtm1;
	}

	public JMenuItem getRtm2() {        // Ԥ��
		return rtm2;
	}

	public JMenuItem getRtm3() {        // ��ס
		return rtm3;
	}

	public JMenuItem getRtm4() {        // �෿
		return rtm4;
	}

	public JMenuItem getRtm5() {        // ά��
		return rtm5;
	}
	
	public JButton getRtbt4() {        //����ͼ���С�İ�ť 
		return rtbt4;
	}

	public JPopupMenu getTubiao() {        //ͼ��Ĳ˵�
		return tubiao;
	}

	public JMenuItem getTub1() {         //С
		return tub1;
	}

	public JMenuItem getTub2() {         //��
		return tub2;
	}

	public JMenuItem getTub3() {         //��
		return tub3;
	}
	

	public void init() {
		// �������˲˵�
		pm = new JPopupMenu();
		mi1 = new JMenuItem("��ʾ�ɹ�");
		mi2 = new JMenuItem("��ʾԤ��");
		mi3 = new JMenuItem("��ʾռ��");
		mi4 = new JMenuItem("��ʾά��");
		mi5 = new JMenuItem("��ʾ�෿");

		pm.addSeparator(); // ����˵���
		pm.add(mi1);
		pm.add(mi2);
		pm.add(mi3);
		pm.add(mi4);
		pm.add(mi5);
		pm.addSeparator();

		// �Ҽ������Ӧ�������˵�
		buildRoomMenu();

		//����״̬���������˵�
		buildRoomTypeMenu();
		
		//����ͼ���С�ĸ��ĵĲ˵�
		buildRoomTuBiao();
		
		// //��ŷ�������
		ht = new Hashtable();
		
		//��ŷ������Ͷ�Ӧ�ķ�������id;
		fjlx = new Hashtable();
		// �������ͱ�ǩ��
		rtypeTb = new JTabbedPane();
		rtypeTb.setBackground(new Color(255, 255, 255));

		// ������ǩ��
		buildJTabbedPane();

		// ����ˢ�µȰ������
		rjp_bott = buildrjp_bott();

		// �������
		this.add("South", rjp_bott);
		this.add("Center", rtypeTb);
		// System.out.println("*****");

		// �Ӽ�����
		addListener();

	}
	/**
	 * ����ͼ���С�ĸ���
	 */
	private void buildRoomTuBiao() {
		//ͼ��˵�
		tubiao = new JPopupMenu();
		tub1 = new JMenuItem("Сͼ��");
		tub2 = new JMenuItem("��ͼ��");
		tub3 = new JMenuItem("��ͼ��");
		
		tubiao.addSeparator(); // ����˵���
		tubiao.add(tub1);
		tubiao.addSeparator();
		tubiao.add(tub2);
		tubiao.addSeparator();
		tubiao.add(tub3);
		tubiao.addSeparator();
	}
	/**
	 *  ���������˵�����ʾ
	 */
	private void buildRoomMenu() {
		// �������������˵�
		prm = new JPopupMenu();
		mri1 = new JMenuItem("Ԥ���Ǽ�");
		mri2 = new JMenuItem("��ס�Ǽ�");
		mri3 = new JMenuItem("��������");
		mri4 = new JMenuItem("��������");
		mri5 = new JMenuItem("�˷�����");
		mri6 = new JMenuItem("����");
		mri7 = new JMenu("�޸ķ�̬");
		mri8 = new JMenuItem("��ɨ�ɾ�");
		mri9 = new JMenuItem("���ɱ���");
 
		prm.addSeparator();
		prm.add(mri1);     // ����˵���
		prm.addSeparator();
		prm.add(mri2);
		prm.addSeparator();
		prm.add(mri3);
		prm.addSeparator();
		prm.add(mri4);
		prm.addSeparator();
		prm.add(mri5);
		prm.addSeparator();
		prm.add(mri6);
		prm.addSeparator();
		prm.add(mri7);
		prm.addSeparator();
		prm.add(mri8);
		prm.addSeparator();
		prm.add(mri9);	
	}
	/**
	 *  ����״̬���ĵĶ����˵�
	 */
	private void buildRoomTypeMenu() {
		
		rtm1 = new JMenuItem("���");    // ��������ѡ��
		rtm2 = new JMenuItem("Ԥ��");
		rtm3 = new JMenuItem("��ס");
		rtm4 = new JMenuItem("�෿");
		rtm5 = new JMenuItem("ά��");
		
		mri7.add(rtm1);
		mri7.add(rtm2);
		mri7.add(rtm3);
		mri7.add(rtm4);
		mri7.add(rtm5);	
	}
	

	/**
	 * private void addListener() {} : ���� �����¼�����
	 */
	private void addListener() {
		// ���������ˢ�µȰ�ť�¼�����
		this.rtbt2.addActionListener(new LsnrRightFrm(this));
		this.rtbt3.addActionListener(new LsnrRightFrm(this));
		this.mi1.addActionListener(new LsnrRightFrm(this));
		this.mi2.addActionListener(new LsnrRightFrm(this));
		this.mi3.addActionListener(new LsnrRightFrm(this));
		this.mi4.addActionListener(new LsnrRightFrm(this));
		this.mi5.addActionListener(new LsnrRightFrm(this));
		/***********************************************/
		// ͼ���С�İ�ť
		this.tub1.addActionListener(new LsnrRightFrm(this));
		this.tub2.addActionListener(new LsnrRightFrm(this));
		this.tub3.addActionListener(new LsnrRightFrm(this));
		/***********************************************/
		// ��ť����������������ʾ��Ϣ����ʾ
		this.rtbt1.addMouseListener(new LsnrMouseRightFrm(this));
		this.rtbt2.addMouseListener(new LsnrMouseRightFrm(this));
		this.rtbt3.addMouseListener(new LsnrMouseRightFrm(this));
		this.rtbt4.addMouseListener(new LsnrMouseRightFrm(this));     //ͼ�갴ť�ļ�����
		this.rtypeTb.addMouseListener(new LsnrMouseRightFrm(this));
		/************************************************/
		//����˵��޸ķ�̬�����˵�
		this.rtm1.addActionListener(LsnrRoomMenuFrm);       // 
		this.rtm2.addActionListener(LsnrRoomMenuFrm);
		this.rtm3.addActionListener(LsnrRoomMenuFrm);
		this.rtm4.addActionListener(LsnrRoomMenuFrm);
		this.rtm5.addActionListener(LsnrRoomMenuFrm);
		/************************************************/
		//�������˵�
		this.mri1.addActionListener(LsnrRoomMenuFrm);          // Ԥ��
		this.mri2.addActionListener(LsnrRoomMenuFrm);          // �Ǽ���ס
		this.mri3.addActionListener(LsnrRoomMenuFrm);          // ��������
		this.mri4.addActionListener(LsnrRoomMenuFrm);          // ��������
		this.mri5.addActionListener(LsnrRoomMenuFrm);          // �˷�
		this.mri6.addActionListener(LsnrRoomMenuFrm);          // ����
		this.mri8.addActionListener(LsnrRoomMenuFrm);          // ��ɨ�ɾ�
		this.mri9.addActionListener(LsnrRoomMenuFrm);          // ���ɱ���
		
	}

	/**
	 * ��������������˵Ĺ��ܰ���button�� 
	 * @return
	 */
	private JPanel buildrjp_bott() {
		JPanel bott = new JPanel(new FlowLayout(FlowLayout.RIGHT, 45, 6));
		bott.setBackground(new Color(193, 210, 240));
		rtbt1 = new TJButton("pic/toolsbar/choose.gif", "����״̬", "��ʾָ��״̬�ķ���", false);
		rtbt2 = new TJButton("pic/toolsbar/browse.gif", "��ʾȫ��", "��ʾ���з���", false);
		rtbt3 = new TJButton("pic/toolsbar/refurbish.gif", "  ˢ   ��  ", "ˢ�·�����Ϣ", false);
		rtbt4 = new TJButton("pic/toolsbar/u01.gif", "����ͼ�� ", "����ͼ���С", false);

		bott.add(rtbt4);
		bott.add(rtbt1);
		bott.add(rtbt2);
		bott.add(rtbt3);

		return bott;
	}

	/**
	 * �����������͵ı�ǩ����ͬʱ�ڱ�ǩ�������ͬ���͵ķ���button
	 */
	private void buildJTabbedPane() {
		RoomTypeDAO roomTypeDAO = new RoomTypeDAO();
		Vector vrtype = roomTypeDAO.findAllRoomType();
//		for (Iterator it = vrtype.iterator(); it.hasNext();) {
//			String[] o = (String[]) it.next();
//			for (String s : o) {
//				System.out.println(s);
//			}
//		}
		RoomDAO roomDAO = new RoomDAO();

		for (Iterator iterator = vrtype.iterator(); iterator.hasNext();) {
			String[] str = (String[]) iterator.next(); // str[0]Ϊ��������id��str[1]Ϊ����������

			JPanel jp = new JPanel(new GridLayout(1, 1)); // ����һ���������͵ı�ǩ����ҳ

			Vector vroom = roomDAO.findRoom(str[0], sqlProviso); // ����ViewList��岢����jp

			JPanel vl = buildViewList(vroom);
			jp.add(vl);
			
				rtypeTb.addTab(str[1], jp); // ����������
				fjlx.put(str[1], str[0]); //������������Ӧ�ķ�������id 
				
				ht.put(str[1], vl); // ����ǰ��������(ViewList�ؼ�)�����ϣ��
				
				tb_Name = rtypeTb.getTitleAt(0); // ��õ�ǰ��ǩ������
			
		}
	}

	
	/**
	 * �������Ӧ���͵����з���button
	 */
	private JPanel buildViewList(Vector vroom) {
		ViewList vl = null; // ����һ��ViewList����
		String picName = ""; // ����״̬ͼƬ����
		vl = new ViewList(vroom.size());
		for (Iterator iterator = vroom.iterator(); iterator.hasNext();) {
			String[] str = (String[]) iterator.next();

			// ��ViewList�н�������
			vl.addButton(str[0]).addActionListener(new LsnrRightFrm(this)); // ��Ӽ�����
			vl.getButton(str[0]).addMouseListener(new LsnrRightMenu(this));  //�������������Ҽ���ʾ�˵�
			vl.setButtonImage(str[0], str[1]);
		}
		// �������û�дﵽҪ��ĸ�����VL�Զ�����
		vl.remeButtons();
		return vl;
	}

	/**
	 * ���� ������뷿���Ӧ�İ��� roomtypeID: ���������� , roomID ����id
	 */
	public static JButton getViewListButton(String roomtypeID, String roomID) {
//		System.out.println(((ViewList) ht.get(roomtypeID)));
		return ((ViewList) ht.get(roomtypeID)).getButton(roomID);
	}

	/**
	 * ����ָ�������״̬ͼƬ roomtypeID: ���������� , roomID ����id stateID: ����״̬id
	 */
	public static void setViewListButtonImage(String roomtypeID, String roomID, String stateID) {
		((ViewList) ht.get(roomtypeID)).setButtonImage(roomID, stateID);
	}

	/**
	 * ���� ������ ��ť����sqlProviso ɸѡ�������� ָ��������ˢ������Ϣ��ʾ
	 */
	public void sxRooms() {
		// �õ���ǩ����ǰҳ��
		int tbSelectIndex = rtypeTb.getSelectedIndex();
		// ��չ�ϣ��
		ht.clear();
		// ��ձ�ǩ��
		rtypeTb.removeAll();
		// �����ڴ�
		System.gc();
		// �ؽ���ǩ��
		buildJTabbedPane();
		// ���ñ�ǩ��Ϊ����ǰ����ʾҳ
		rtypeTb.setSelectedIndex(tbSelectIndex);
	}

}