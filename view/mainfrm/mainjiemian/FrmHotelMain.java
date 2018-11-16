package view.mainfrm.mainjiemian;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import common.component.swings.TJButton;
import control.mainfrm.mainjiemian.mainbtnlsnr.LsnrFrmMainBtn;
import control.mainfrm.mainjiemian.mainbtnlsnr.LsnrFrmMainMenu;
import control.mainfrm.mainjiemian.mainbtnlsnr.LsnrMouseFrmMain;
import view.mainfrm.common.QuitSystem;

import java.util.Timer;

/**
 * 主界面
 * 
 * @author 吴阿龙
 *
 */
public class FrmHotelMain extends JFrame {
	public static String userid;
	public static JLabel lbA, lbB, lbC, jX;
	public static String clue = "    提 示 :  ";
	public static String face = "    当前操作界面 :  ";

	// 声名与菜单相关的类
	private JMenuBar mb;
	private JMenu m1, m2, m3; // 房间管理菜单 结算信息 系统设置菜单
	private JMenuItem mi11, mi12, mi13, mi14, mi15, mi16, mi17, mi21, mi22, mi23, mi31, mi32,mi33;

	// 工具栏
	private JToolBar tb; // 制作按钮菜单栏
	private JButton fangjianguanlibt, yudingguanlibt, ruzhudengjibt, ruzhuchaxunbt, tuifangjiezhangbt, kehuguanlibt,
			zengjiaxiaofeibt, jiesuanselectbt, aboutusbt, huanbanbt, quitsystem;
	// 分割面板
	private JSplitPane spaneMain, spaneLeft, spaneRight;
	// 模块接口
	private JPanel panelMain, bott, jp1, jp2, jp3, jp4, JTime;

	// public LsnrFrmMainBtn lsnrFrmMainBtn = new LsnrFrmMainBtn(this); //主页面中按钮的监听

	/************************** 系统托盘 ***************************************/
	private TrayIcon trayIcon = new TrayIcon(new ImageIcon("pic/denglu/酒店托盘.png").getImage());// 托盘图标
	private SystemTray systemTray = SystemTray.getSystemTray();// 系统托盘
	PopupMenu popupMenu = new PopupMenu();
	MenuItem mi1 = new MenuItem("关于我们");
	MenuItem mi2 = new MenuItem("退出");

	// 构造函数
	public FrmHotelMain() {
		panelMain = new JPanel(new BorderLayout()); // 主面板
		init();
	}

	public void init() {
                this.setIconImage(new ImageIcon("pic/backimages/酒店.jpg").getImage());
		// 制作菜单
		buildMenuBar();
		// 制作工具栏
		buildToolBar();
		// 制作分割面板
		buildSpaneMain();
		// 制作窗口底端信息框
		buildBott();

		// 加入组件到主面板
		panelMain.add("North", tb); // 加入工具栏
		panelMain.add("South", bott); // 加入窗口底端信息框
		panelMain.add("Center", spaneMain); // 加入分割面板

		// 加入菜单栏
		this.setJMenuBar(mb);

		// 加监听器
		addListener();

		// 窗口退出方法
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				quit();
			}// End windowClosing
		});

		int screewidth = ((int) Toolkit.getDefaultToolkit().getScreenSize().width);
		int screenHeight = ((int) Toolkit.getDefaultToolkit().getScreenSize().height);
		this.setContentPane(panelMain);
		this.setBounds(0, 0, screewidth, screenHeight);
		// this.setContentPane (panelMain);
		// this.setBounds (2, 2, 1020, 740);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setMinimumSize(new Dimension(1020, 740)); // 设置窗口最小尺寸
		// this.setVisible (true);

		/******************** 系统托盘 ********************/

		// 添加工具提示文本
		trayIcon.setToolTip("酒店前台管理系统v1.0");
		popupMenu.add(mi1);
		popupMenu.add(mi2);
		// 为托盘图标加弹出菜弹
		trayIcon.setPopupMenu(popupMenu);
		// systemTray.add(trayIcon);//设置托盘的图标，0.gif与该类文件同一目录
		this.dispose();

		this.addWindowListener(new WindowAdapter() {
			public void windowIconified(WindowEvent e) {
				dispose();// 窗口最小化时dispose该窗口
				try {
					systemTray.add(trayIcon);
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 设置托盘的图标，0.gif与该类文件同一目录
			}

		});
		trayIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)// 双击托盘窗口再现
				{
					setExtendedState(Frame.NORMAL);
					setVisible(true);
					systemTray.remove(trayIcon);
				}
			}
		});
	}

	public MenuItem getMi1() {
		return mi1;
	}

	public SystemTray getSystemTray() {
		return systemTray;
	}

	public TrayIcon getTrayIcon() {
		return trayIcon;
	}

	public MenuItem getMi2() {
		return mi2;
	}

	private void addListener() {
		// 功能button按钮动作监听
		this.yudingguanlibt.addActionListener(new LsnrFrmMainBtn(this));
		this.ruzhudengjibt.addActionListener(new LsnrFrmMainBtn(this));
		this.ruzhuchaxunbt.addActionListener(new LsnrFrmMainBtn(this));
		this.tuifangjiezhangbt.addActionListener(new LsnrFrmMainBtn(this));
		this.kehuguanlibt.addActionListener(new LsnrFrmMainBtn(this));
		this.zengjiaxiaofeibt.addActionListener(new LsnrFrmMainBtn(this));
		this.jiesuanselectbt.addActionListener(new LsnrFrmMainBtn(this));
		this.aboutusbt.addActionListener(new LsnrFrmMainBtn(this));
		this.huanbanbt.addActionListener(new LsnrFrmMainBtn(this));
		this.quitsystem.addActionListener(new LsnrFrmMainBtn(this));

		// 功能button鼠标监听
		this.yudingguanlibt.addMouseListener(new LsnrMouseFrmMain(this));
		this.ruzhudengjibt.addMouseListener(new LsnrMouseFrmMain(this));
		this.ruzhuchaxunbt.addMouseListener(new LsnrMouseFrmMain(this));
		this.tuifangjiezhangbt.addMouseListener(new LsnrMouseFrmMain(this));
		this.kehuguanlibt.addMouseListener(new LsnrMouseFrmMain(this));
		this.zengjiaxiaofeibt.addMouseListener(new LsnrMouseFrmMain(this));
		this.jiesuanselectbt.addMouseListener(new LsnrMouseFrmMain(this));
		this.aboutusbt.addMouseListener(new LsnrMouseFrmMain(this));
		this.huanbanbt.addMouseListener(new LsnrMouseFrmMain(this));
		this.quitsystem.addMouseListener(new LsnrMouseFrmMain(this));

		// 菜单监听
		this.mi11.addActionListener(new LsnrFrmMainMenu(this));
		this.mi12.addActionListener(new LsnrFrmMainMenu(this));
		this.mi13.addActionListener(new LsnrFrmMainMenu(this));
		this.mi14.addActionListener(new LsnrFrmMainMenu(this));
		this.mi15.addActionListener(new LsnrFrmMainMenu(this));
		this.mi16.addActionListener(new LsnrFrmMainMenu(this));
		this.mi17.addActionListener(new LsnrFrmMainMenu(this));
		this.mi21.addActionListener(new LsnrFrmMainMenu(this));
		this.mi22.addActionListener(new LsnrFrmMainMenu(this));
		this.mi23.addActionListener(new LsnrFrmMainMenu(this));
		this.mi31.addActionListener(new LsnrFrmMainMenu(this));
		this.mi32.addActionListener(new LsnrFrmMainMenu(this));
		this.mi33.addActionListener(new LsnrFrmMainMenu(this));
		//托盘菜单监听器
		this.mi1.addActionListener(new LsnrFrmMainMenu(this));  //关于我们
		this.mi2.addActionListener(new LsnrFrmMainMenu(this));  //退出
	}

	// 制作菜单
	private void buildMenuBar() {
		// 实例菜单栏
		mb = new JMenuBar();
		mb.setBackground(new Color(92, 156, 200));

		// 实例菜单
		m1 = new JMenu("房间管理 (F)");
		m2 = new JMenu("结算信息 (S)");
		m3 = new JMenu("系统设置 (R)");

		// 实例菜单项
		mi11 = new JMenuItem("登记入住　　(D)");
		mi12 = new JMenuItem("入住信息查询　　(M)");
		mi13 = new JMenuItem("更换房间　　(A)");
		mi14 = new JMenuItem("修改登记　　(J)");
		mi15 = new JMenuItem("房间状态　　(Z)");
		mi16 = new JMenuItem("预订管理　　(T)");
		mi17 = new JMenuItem("退出系统　　(X)");
		mi21 = new JMenuItem("宾客结帐　　(J)");
		mi22 = new JMenuItem("结算查询　　(E)");
		mi23 = new JMenuItem("宾客房间消费明细查询");
		mi31 = new JMenuItem("换班　　(Z)");
		mi32 = new JMenuItem("关于我们　　(A)");
                mi33 = new JMenuItem("系统帮助　　(H)");
		// //未开发完毕的功能

		// 组织菜单
		m1.add(mi11); // 房间管理
		m1.add(mi12);
		m1.add(mi13);
		m1.add(mi14);
		m1.add(mi15);
		m1.add(mi16);
		m1.addSeparator();
		m1.add(mi17);

		m2.add(mi21); // 结算信息
		m2.add(mi22);
		m2.add(mi23);

		m3.add(mi31); // 系统设置
		m3.addSeparator();
		m3.add(mi32);
                m3.add(mi33);

		mb.add(m1); // 加入菜单栏
		mb.add(m2);
		mb.add(m3);
	}

	// 制作工具栏
	private void buildToolBar() {
		tb = new JToolBar();
		tb.setBackground(new Color(193, 210, 240));
		// 制作按键
		fangjianguanlibt = new TJButton("pic/toolsbar/房间管理.png", "  房间管理  ", "进行房间信息的管理", true);
		yudingguanlibt = new TJButton("pic/toolsbar/预定.png", "  预定管理  ", "为宾客预定房间", true);
		// bt3 = new TJButton ("pic/toolsbar/查询.png", " 预定查询 ", "查询宾客预定信息", true);
		ruzhudengjibt = new TJButton("pic/toolsbar/登记.png", "  入住登记  ", "给宾客进行登记入住", true);
		ruzhuchaxunbt = new TJButton("pic/toolsbar/查询.png", "  入住查询  ", "进行退房结算", true);
		tuifangjiezhangbt = new TJButton("pic/toolsbar/秒退房.png", "  退房结帐  ", "进行退房结算", true);
		kehuguanlibt = new TJButton("pic/toolsbar/客户管理.png ", "  客户管理  ", "进行顾客信息的管理", true);
		zengjiaxiaofeibt = new TJButton("pic/toolsbar/消费.png", "  增加消费", "增加额外的消费", true);
		jiesuanselectbt = new TJButton("pic/toolsbar/结算查询.png", "  结算查询  ", "查询顾客总消费情况", true);
		aboutusbt = new TJButton("pic/toolsbar/关于我们.png", "  关于我们  ", "软件信息", true);
		huanbanbt = new TJButton("pic/toolsbar/换班.png", "  换         班  ", "切换登录", true);
		quitsystem = new TJButton("pic/toolsbar/退出系统.png", "  退出系统  ", "返回Windows", true);

		// 把按键加入工具栏
		tb.addSeparator();
		tb.add(fangjianguanlibt);
		tb.addSeparator();
		tb.add(yudingguanlibt);
		tb.addSeparator();
		tb.add(ruzhudengjibt);
		tb.addSeparator();
		tb.add(ruzhuchaxunbt);
		tb.addSeparator();
		tb.add(tuifangjiezhangbt);
		tb.addSeparator();
		tb.add(kehuguanlibt);
		tb.addSeparator();
		tb.add(zengjiaxiaofeibt);
		tb.addSeparator();
		tb.add(jiesuanselectbt);
		tb.addSeparator();
		tb.add(aboutusbt);
		tb.addSeparator();
		tb.add(huanbanbt);
		tb.addSeparator();
		tb.add(quitsystem);

		// 设置工具栏不可浮动
		tb.setFloatable(false);
	}

	// 制作主面板
	private void buildSpaneMain() {

		jp1 = new FrmLeftTopMain(); // 左上面板 楼层类型
		jp2 = new FrmLeftBottMain(); // 左下面板 快速通道
		jp3 = new FrmRightTopMain(); ///////////////////////////////
		jp4 = new FrmRightBottMain();

		// 声名分割面板
		spaneLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jp1, jp2); // jp2
		spaneRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jp3, jp4);
		spaneMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, spaneLeft, spaneRight);

		// 设置面板最小尺寸
		jp1.setMinimumSize(new Dimension(160, 580));
		jp2.setMinimumSize(new Dimension(160, 300));
		jp3.setMinimumSize(new Dimension(875, 300));
		jp4.setMinimumSize(new Dimension(875, 94));
		spaneRight.setMinimumSize(new Dimension(875, 565));

		// 设置分割条是否有伸缩键
		spaneMain.setOneTouchExpandable(true);
		spaneRight.setOneTouchExpandable(true);

		// 设置各面板的初起尺寸
		spaneMain.setDividerLocation(215);
		spaneLeft.setDividerLocation(450);
		spaneRight.setDividerLocation(700);

		// 设置分隔条宽度
		spaneMain.setDividerSize(0);
		spaneLeft.setDividerSize(3);
		spaneRight.setDividerSize(23);
	}

	// 制作bott栏
	private void buildBott() {
		JLabel lb1, lb2, lb3, lb4;

		lbA = new JLabel(clue + "请选择功能项 ... ");
		lbB = new JLabel(face + "泊隐酒 店 管 理 系 统 ：            1.01 版  ");
		lb1 = new JLabel("    泊隐 酒 店 管 理 系 统    ");
		lb2 = new JLabel("    当前操作员 :  ");
		lbC = new JLabel(userid + "                  ");
		lb3 = new JLabel("                      ");
		lb4 = new JLabel("当前时间： ");
		jX = new JLabel();

		// 加外框线
		lbA.setBorder(new LineBorder(new Color(100, 100, 60)));
		lbB.setBorder(new LineBorder(new Color(100, 100, 60)));
		lb1.setBorder(new LineBorder(new Color(100, 100, 60)));
		lbC.setBorder(new LineBorder(new Color(100, 100, 60)));
		jX.setBorder(new LineBorder(new Color(100, 100, 60)));

		bott = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 3));

		bott.add(lb1);
		bott.add(lbB);
		bott.add(lbA);
		bott.add(lb2);
		bott.add(lbC);
		bott.add(lb3);
		bott.add(lb4);
		bott.add(jX);
		Timer timer = new Timer();
		timer.schedule(new ShowTime(), new Date(), 1000);

	}

	/**
	 * 时间显示方法区，通过
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH : mm : ss ");

	class ShowTime extends TimerTask {
		public void run() {
			// 刷新
			jX.setText(sdf.format(new Date()));
			repaint();
		}
	}

	/**
	 * private void quit () {} : 系统退出 功能 ：关闭系统函数，仅类内使用
	 */
	private void quit() {
		QuitSystem q = new QuitSystem();
		q.quit(this);

	}

	public JButton getFangjianguanlibt() { // 房间管理
		return fangjianguanlibt;
	}

	public JButton getYudingguanlibt() { // 预定管理
		return yudingguanlibt;
	}

	public JButton getRuzhudengjibt() { // 入住登记
		return ruzhudengjibt;
	}

	public JButton getRuzhuchaxunbt() { // 入住查询
		return ruzhuchaxunbt;
	}

	public JButton getTuifangjiezhangbt() { // 退房结算
		return tuifangjiezhangbt;
	}

	public JButton getKehuguanlibt() { // 客户管理
		return kehuguanlibt;
	}

	public JButton getZengjiaxiaofeibt() { // 增加消费
		return zengjiaxiaofeibt;
	}

	public JButton getJiesuanselectbt() { // 结算查询
		return jiesuanselectbt;
	}

	public JButton getAboutus() { // 关于我们
		return aboutusbt;
	}

	public JButton getHuanbanbt() { // 换班
		return huanbanbt;
	}

    public JMenuItem getMi33() {//系统帮助
        return mi33;
    }

   

	public JButton getQuitsystem() { // 退出系统
		return quitsystem;
	}

	// ------------------------------------------ // 菜单按钮
	public JMenuItem getMi11() { // 登记入住
		return mi11;
	}

	public JMenuItem getMi12() { // 入住信息查询
		return mi12;
	}

	public JMenuItem getMi13() { // 更换房间
		return mi13;
	}

	public JMenuItem getMi14() { // 修改登记
		return mi14;
	}

	public JMenuItem getMi15() { // 房间状态
		return mi15;
	}

	public JMenuItem getMi16() { // 预定管理
		return mi16;
	}

	public JMenuItem getMi17() { // 退出系统
		return mi17;
	}

	public JMenuItem getMi21() { // 宾客结账
		return mi21;
	}

	public JMenuItem getMi22() { // 结算查询
		return mi22;
	}

	public JMenuItem getMi23() { // 宾客房间消费查询
		return mi23;
	}

	public JMenuItem getMi31() { // 换班
		return mi31;
	}

	public JMenuItem getMi32() { // 关于我们
		return mi32;
	}

/*	public static void main(String sd[]) {

		new FrmHotelMain().setVisible(true);
		;
	}*/
}
