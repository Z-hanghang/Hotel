package view.mainfrm.mainjiemian;

/**
 *
 *
 *	[ 项目名      ]  : 酒店管理系统
 *	[ 模块名      ]  : 主窗口右边房间信息面板
 *	[ 文件名      ]  : FrmRightMain.java
 *	[ 相关文件    ]  : 
 *	[ 文件实现功能]  : 以ViewList控件思想，实现房间图标化
 *	[ 作者        ]  : 吴阿龙
 *	[ 版本        ]  : 1.0
 *	----------------------------------------------------------------------------
 *	[ 备注        ]  : 
 *	----------------------------------------------------------------------------
 *	[ 修改记录    ]  : 
 *
 *	[ 日  期 ]     [版本]         [修改人]         [修改内容] 
 *	2018/10/16    1.0                         吴阿龙                      创建
 *
 *  [ 遗留问题    ]  : 
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

	private JButton rtbt1, rtbt2, rtbt3, rtbt4; // 显示全部 过滤状态 刷新三个按钮 //更改图标大小
	private JTabbedPane rtypeTb; // 标签栏

	private JPanel rjp_bott; // 制作刷新等按键面板

	private JPopupMenu pm; // 定义过滤菜单
	private JMenuItem mi1, mi2, mi3, mi4, mi5; // 菜单五个过滤属性按钮 （可供，入住，预定，脏房，维护）
	
	private JPopupMenu tubiao; // 定义图标大小的菜单
	private JMenuItem tub1, tub2, tub3; // 菜单三个状态，分别是大中小
	
	private JPopupMenu prm; // 定义过滤菜单  prm
	private JMenuItem mri1, mri2, mri3, mri4, mri5, mri6, mri8, mri9;  // 房间下拉菜单选项为mri
	private JMenu mri7;  // 定义房间状态修改的二级菜单
	

	private JMenuItem rtm1, rtm2, rtm3, rtm4, rtm5;   //对应的五个状态
	    
	
	private LsnrRoomMenuFrm LsnrRoomMenuFrm = new LsnrRoomMenuFrm(this);  // 用于房间右键显示菜单

	// 保存房间类型ViewList控件面板的哈希表
	private static Hashtable ht;
	
	public static Hashtable fjlx;
	// 当前标签栏页
	public static String tb_Name;
	
//	public static String[] tbb_N;

	// 筛选房间信息的条件 过滤显示
	private String sqlProviso = "";

	/*
	 * 对筛选条件进行修改
	 */
	public void setSqlProviso(String sqlProviso) {
		this.sqlProviso = sqlProviso;
	}

	/**
	 * public RightTopPanel() {} 功能 ：组建主窗口右边房间信息面板
	 */
	public FrmRightTopMain() {
		super(new BorderLayout());
		init();
	}
	
	public String getTb_Name() {
		return tb_Name;
	}

	public JButton getRtbt1() {          //房间状态三个按钮
		return rtbt1;
	}

	public JButton getRtbt2() {
		return rtbt2;
	}

	public JButton getRtbt3() {
		return rtbt3;
	}
	
	public JPopupMenu getPm() {           //过滤菜单的get
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

	public JTabbedPane getRtp_tb() {    //房间类型栏
		return rtypeTb;
	}
	
	public JPopupMenu getPrm() {      //房间右键菜单选项
		return prm;
	}
	
	public JMenuItem getMri1() {       // 预定登记
		return mri1;
	}

	public JMenuItem getMri2() {       // 入住登记
		return mri2;
	}

	public JMenuItem getMri3() {       // 更换房间
		return mri3;
	}

	public JMenuItem getMri4() {       // 增加消费
		return mri4;
	}

	public JMenuItem getMri5() {       // 退房结账
		return mri5;
	}

	public JMenuItem getMri6() {       // 续房
		return mri6;
	}

	public JMenu getMri7() {       // 修改房态  房间状态二级菜单
		return mri7;
	}

	public JMenuItem getMri8() {       // 打扫干净
		return mri8;
	}

	public JMenuItem getMri9() {       // 生成报表
		return mri9;
	}
	
	public JMenuItem getRtm1() {        // 清洁
		return rtm1;
	}

	public JMenuItem getRtm2() {        // 预定
		return rtm2;
	}

	public JMenuItem getRtm3() {        // 入住
		return rtm3;
	}

	public JMenuItem getRtm4() {        // 脏房
		return rtm4;
	}

	public JMenuItem getRtm5() {        // 维修
		return rtm5;
	}
	
	public JButton getRtbt4() {        //更改图标大小的按钮 
		return rtbt4;
	}

	public JPopupMenu getTubiao() {        //图标的菜单
		return tubiao;
	}

	public JMenuItem getTub1() {         //小
		return tub1;
	}

	public JMenuItem getTub2() {         //中
		return tub2;
	}

	public JMenuItem getTub3() {         //大
		return tub3;
	}
	

	public void init() {
		// 制作过滤菜单
		pm = new JPopupMenu();
		mi1 = new JMenuItem("显示可供");
		mi2 = new JMenuItem("显示预定");
		mi3 = new JMenuItem("显示占用");
		mi4 = new JMenuItem("显示维护");
		mi5 = new JMenuItem("显示脏房");

		pm.addSeparator(); // 加入菜单项
		pm.add(mi1);
		pm.add(mi2);
		pm.add(mi3);
		pm.add(mi4);
		pm.add(mi5);
		pm.addSeparator();

		// 右键房间对应的下拉菜单
		buildRoomMenu();

		//房间状态更改下拉菜单
		buildRoomTypeMenu();
		
		//房间图标大小的更改的菜单
		buildRoomTuBiao();
		
		// //存放房间类型
		ht = new Hashtable();
		
		//存放房间类型对应的房间类型id;
		fjlx = new Hashtable();
		// 房间类型标签栏
		rtypeTb = new JTabbedPane();
		rtypeTb.setBackground(new Color(255, 255, 255));

		// 制作标签栏
		buildJTabbedPane();

		// 制作刷新等按键面板
		rjp_bott = buildrjp_bott();

		// 加入组件
		this.add("South", rjp_bott);
		this.add("Center", rtypeTb);
		// System.out.println("*****");

		// 加监听器
		addListener();

	}
	/**
	 * 房间图标大小的更改
	 */
	private void buildRoomTuBiao() {
		//图标菜单
		tubiao = new JPopupMenu();
		tub1 = new JMenuItem("小图标");
		tub2 = new JMenuItem("中图标");
		tub3 = new JMenuItem("大图标");
		
		tubiao.addSeparator(); // 加入菜单项
		tubiao.add(tub1);
		tubiao.addSeparator();
		tubiao.add(tub2);
		tubiao.addSeparator();
		tubiao.add(tub3);
		tubiao.addSeparator();
	}
	/**
	 *  房间下拉菜单的显示
	 */
	private void buildRoomMenu() {
		// 制作房间下拉菜单
		prm = new JPopupMenu();
		mri1 = new JMenuItem("预定登记");
		mri2 = new JMenuItem("入住登记");
		mri3 = new JMenuItem("更换房间");
		mri4 = new JMenuItem("增加消费");
		mri5 = new JMenuItem("退房结账");
		mri6 = new JMenuItem("续房");
		mri7 = new JMenu("修改房态");
		mri8 = new JMenuItem("打扫干净");
		mri9 = new JMenuItem("生成报表");
 
		prm.addSeparator();
		prm.add(mri1);     // 加入菜单项
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
	 *  房间状态更改的二级菜单
	 */
	private void buildRoomTypeMenu() {
		
		rtm1 = new JMenuItem("清洁");    // 房间类型选项
		rtm2 = new JMenuItem("预定");
		rtm3 = new JMenuItem("入住");
		rtm4 = new JMenuItem("脏房");
		rtm5 = new JMenuItem("维修");
		
		mri7.add(rtm1);
		mri7.add(rtm2);
		mri7.add(rtm3);
		mri7.add(rtm4);
		mri7.add(rtm5);	
	}
	

	/**
	 * private void addListener() {} : 功能 ：加事件监听
	 */
	private void addListener() {
		// 房间界面中刷新等按钮事件监听
		this.rtbt2.addActionListener(new LsnrRightFrm(this));
		this.rtbt3.addActionListener(new LsnrRightFrm(this));
		this.mi1.addActionListener(new LsnrRightFrm(this));
		this.mi2.addActionListener(new LsnrRightFrm(this));
		this.mi3.addActionListener(new LsnrRightFrm(this));
		this.mi4.addActionListener(new LsnrRightFrm(this));
		this.mi5.addActionListener(new LsnrRightFrm(this));
		/***********************************************/
		// 图标大小的按钮
		this.tub1.addActionListener(new LsnrRightFrm(this));
		this.tub2.addActionListener(new LsnrRightFrm(this));
		this.tub3.addActionListener(new LsnrRightFrm(this));
		/***********************************************/
		// 按钮的鼠标监听，用于提示信息的显示
		this.rtbt1.addMouseListener(new LsnrMouseRightFrm(this));
		this.rtbt2.addMouseListener(new LsnrMouseRightFrm(this));
		this.rtbt3.addMouseListener(new LsnrMouseRightFrm(this));
		this.rtbt4.addMouseListener(new LsnrMouseRightFrm(this));     //图标按钮的监听器
		this.rtypeTb.addMouseListener(new LsnrMouseRightFrm(this));
		/************************************************/
		//房间菜单修改房态二级菜单
		this.rtm1.addActionListener(LsnrRoomMenuFrm);       // 
		this.rtm2.addActionListener(LsnrRoomMenuFrm);
		this.rtm3.addActionListener(LsnrRoomMenuFrm);
		this.rtm4.addActionListener(LsnrRoomMenuFrm);
		this.rtm5.addActionListener(LsnrRoomMenuFrm);
		/************************************************/
		//房间界面菜单
		this.mri1.addActionListener(LsnrRoomMenuFrm);          // 预定
		this.mri2.addActionListener(LsnrRoomMenuFrm);          // 登记入住
		this.mri3.addActionListener(LsnrRoomMenuFrm);          // 更换房间
		this.mri4.addActionListener(LsnrRoomMenuFrm);          // 增加消费
		this.mri5.addActionListener(LsnrRoomMenuFrm);          // 退房
		this.mri6.addActionListener(LsnrRoomMenuFrm);          // 续房
		this.mri8.addActionListener(LsnrRoomMenuFrm);          // 打扫干净
		this.mri9.addActionListener(LsnrRoomMenuFrm);          // 生成报表
		
	}

	/**
	 * 制作房间情况过滤的功能按键button。 
	 * @return
	 */
	private JPanel buildrjp_bott() {
		JPanel bott = new JPanel(new FlowLayout(FlowLayout.RIGHT, 45, 6));
		bott.setBackground(new Color(193, 210, 240));
		rtbt1 = new TJButton("pic/toolsbar/choose.gif", "过滤状态", "显示指定状态的房间", false);
		rtbt2 = new TJButton("pic/toolsbar/browse.gif", "显示全部", "显示所有房间", false);
		rtbt3 = new TJButton("pic/toolsbar/refurbish.gif", "  刷   新  ", "刷新房间信息", false);
		rtbt4 = new TJButton("pic/toolsbar/u01.gif", "更改图标 ", "更改图标大小", false);

		bott.add(rtbt4);
		bott.add(rtbt1);
		bott.add(rtbt2);
		bott.add(rtbt3);

		return bott;
	}

	/**
	 * 制作房间类型的标签栏，同时在标签栏中添加同类型的房间button
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
			String[] str = (String[]) iterator.next(); // str[0]为房间类型id，str[1]为房间类型名

			JPanel jp = new JPanel(new GridLayout(1, 1)); // 建立一个房间类型的标签栏单页

			Vector vroom = roomDAO.findRoom(str[0], sqlProviso); // 制作ViewList面板并加入jp

			JPanel vl = buildViewList(vroom);
			jp.add(vl);
			
				rtypeTb.addTab(str[1], jp); // 房间类型名
				fjlx.put(str[1], str[0]); //房间类型名对应的房间类型id 
				
				ht.put(str[1], vl); // 将当前房间类型(ViewList控件)存入哈希表
				
				tb_Name = rtypeTb.getTitleAt(0); // 获得当前标签栏标题
			
		}
	}

	
	/**
	 * 制作相对应类型的所有房间button
	 */
	private JPanel buildViewList(Vector vroom) {
		ViewList vl = null; // 定义一个ViewList对象
		String picName = ""; // 房间状态图片名称
		vl = new ViewList(vroom.size());
		for (Iterator iterator = vroom.iterator(); iterator.hasNext();) {
			String[] str = (String[]) iterator.next();

			// 在ViewList中建立按键
			vl.addButton(str[0]).addActionListener(new LsnrRightFrm(this)); // 需加监听器
			vl.getButton(str[0]).addMouseListener(new LsnrRightMenu(this));  //加鼠标监听器，右键显示菜单
			vl.setButtonImage(str[0], str[1]);
		}
		// 如果按键没有达到要求的个数，VL自动补空
		vl.remeButtons();
		return vl;
	}

	/**
	 * 功能 ：获得与房间对应的按键 roomtypeID: 房间类型名 , roomID 房间id
	 */
	public static JButton getViewListButton(String roomtypeID, String roomID) {
//		System.out.println(((ViewList) ht.get(roomtypeID)));
		return ((ViewList) ht.get(roomtypeID)).getButton(roomID);
	}

	/**
	 * 设置指定房间的状态图片 roomtypeID: 房间类型名 , roomID 房间id stateID: 房间状态id
	 */
	public static void setViewListButtonImage(String roomtypeID, String roomID, String stateID) {
		((ViewList) ht.get(roomtypeID)).setButtonImage(roomID, stateID);
	}

	/**
	 * 功能 ：根据 按钮给的sqlProviso 筛选条件进行 指定的条件刷房间信息显示
	 */
	public void sxRooms() {
		// 得到标签栏当前页码
		int tbSelectIndex = rtypeTb.getSelectedIndex();
		// 清空哈希表
		ht.clear();
		// 清空标签栏
		rtypeTb.removeAll();
		// 清理内存
		System.gc();
		// 重建标签栏
		buildJTabbedPane();
		// 设置标签栏为建立前的显示页
		rtypeTb.setSelectedIndex(tbSelectIndex);
	}

}