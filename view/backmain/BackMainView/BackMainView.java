package view.backmain.BackMainView;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import common.backpifu.pifu.MyLookAndFeel;
import control.mainback.lsnBackMainView.lsnCbx.LsnrBackMainViewCbxRoom;
import control.mainback.lsnBackMainView.lsnEmployee.LsnrDeleteEmployee;
import control.mainback.lsnBackMainView.lsnEmployee.LsnrEmployeeSelect;
import control.mainback.lsnBackMainView.lsnEmployee.LsnrUpdateEmployee;
import control.mainback.lsnBackMainView.lsnLog.LsnrLogBtnSelectDelete;
import control.mainback.lsnBackMainView.lsnLog.LsnrbtnQuanXian;
import control.mainback.lsnBackMainView.lsnRoom.LsnrRoombtn;
import control.mainback.lsnBackMainView.lsnRoomType.LsnrRoomTypeAddBtn;
import control.mainback.lsnBackMainView.lsnRoomType.LsnrRoomTypeBtn;
import control.mainback.lsnBackMainView.lsncaidan.LsnrBackCaiDan;
import view.logmain.MainView;


/*
 * 后台主界面
 * @author:张航
 * @date:2018.10.25
 * */
public class BackMainView extends JFrame {
	/*******************************************************/
	private JLabel jWelcome = new JLabel("欢迎光临酒店后台管理系统");
	private JLabel jUserName = new JLabel();

	/***************** 菜单 **************************************/
	// 菜单
	private JMenuBar mb = new JMenuBar();
	// 创建菜单
	private JMenu m = new JMenu("主菜单");
	// 创建菜单项
	private JMenuItem miqiehuan1 = new JMenuItem("切换用户");
	private JMenuItem miqiehuan2 = new JMenuItem("切换至前台");
	private JMenuItem mituichu = new JMenuItem("退出");
	/***********房间管理界面 *******房间管理界面 **********房间管理界面  ***********************/
	
	
	
	private JRadioButton ckbRToomID= new JRadioButton("房间号");
	private JRadioButton ckbRToomType = new JRadioButton("房间类型");

	String[] RoomName={"标准单人间","标准双人间","豪华套房","浪漫主题房","商务间","行政间","总统套房"};
	private JComboBox<String> cbBoxRoom=new JComboBox<String>();
	 
	private JTextField txtRToomID = new JTextField(10);
	private JTextField txtRToomType = new JTextField(7);
	private JLabel JlRToomSelect = new JLabel("      按类型查询:");
	private JButton btnAllRToom = new JButton("全部信息");
	private JButton btnSelectRToom = new JButton("查  找");
	private Object[] RToomColumnNames = { "房间号", "房间名称", "房间价格","床位数", "所在楼层编号"};
	private JTable tblRToom = new JTable(new DefaultTableModel(new Object[][] {}, RToomColumnNames)) {
		public boolean isCellEditable(int row, int column) {// 表格不允许被编辑
			return false;
		};
	};

	private JButton btnAddRToom = new JButton("添加房间");
	private JButton btnUpdateRToom = new JButton("修改房间");
	private JButton btnDeleteRToom = new JButton("删除房间");
	
	
	/********* 房间类型管理界面 *****************************************************/
	private JRadioButton ckbRoomName = new JRadioButton("房间名称");
	private JRadioButton ckbRoomPrice = new JRadioButton("价格");

	private JTextField txtRoomPrice1 = new JTextField(5);
	private JTextField txtRoomPrice2 = new JTextField(5);
	private JTextField txtRoomName = new JTextField(10);
	private JLabel JlRoomSelect = new JLabel("      按类型查询:");
	private JButton btnAllRoom = new JButton("全部信息");
	private JButton btnSelectRoom = new JButton("查  找");
	private Object[] RoomColumnNames = { "房间类型编号", "房间名称", "房间价格" };
	private JTable tblRoom = new JTable(new DefaultTableModel(new Object[][] {}, RoomColumnNames)) {
		public boolean isCellEditable(int row, int column) {// 表格不允许被编辑
			return false;
		};
	};

	private JButton btnAddRoom = new JButton("添加房间类型");
	private JButton btnUpdateRoom = new JButton("修改房间类型");
	private JButton btnDeleteRoom = new JButton("删除房间类型");
	
	
	
	
	

	/********** 登录权限界面*******登录权限界面**********登录权限界面 ***********************/
	private JRadioButton ckbLogName = new JRadioButton("姓名");
	private JRadioButton ckbLogId = new JRadioButton("编号");

	private JTextField txtLogName = new JTextField(10);
	private JTextField txtLogId = new JTextField(10);
	private JLabel JSelectLog = new JLabel("      按类型查询:");
	private JButton btnSelectAllLog = new JButton("全部信息");
	private JButton btnSelectLog = new JButton("查  找");
	private Object[] LogColumnNames = { "员工编号", "姓 名", "密码", "登录状态(0离线,1在线)" };
	private JTable tblLog = new JTable(new DefaultTableModel(new Object[][] {}, LogColumnNames)) {
		public boolean isCellEditable(int row, int column) {// 表格不允许被编辑
			return false;
		};
	};

	private JButton btnAddLog = new JButton("给予权限");
	private JButton btnUpdateLog = new JButton("修改密码");
	private JButton btnDeleteLog = new JButton("撤销权限");

	/******** 员工信息界面*************员工信息界面***********员工信息界面 **************************/
	// 员工信息界面

	private JRadioButton ckbEmployeeName = new JRadioButton("姓名");
	private JRadioButton ckbEmployeeId = new JRadioButton("员工号");

	private JTextField txtEmployeeName = new JTextField(10);
	private JTextField txtEmployeeId = new JTextField(10);
	private JLabel JSelectEmployee = new JLabel("      按类型查询:");
	private JButton btnEmployeenSelectAll = new JButton("全部信息");
	private JButton btnEmployeenSelect = new JButton("查  找");
	private Object[] EmployeeColumnNames = { "员工号", "员工类型", "姓  名", "出生日期", "性   别", "电   话", "身 份 证 号" };

	private JTable tblEmployee = new JTable(new DefaultTableModel(new Object[][] {}, EmployeeColumnNames)) {
		public boolean isCellEditable(int row, int column) {// 表格不允许被编辑
			return false;
		};
	};
	private JButton btnAddEmployee = new JButton("增  加");
	private JButton btnUpdateEmployee = new JButton("修  改");
	private JButton btnDeleteEmployee = new JButton("删  除");

	/**************************系统托盘***************************************/
	private TrayIcon trayIcon= new TrayIcon(new ImageIcon("pic/denglu/酒店托盘.png").getImage());//托盘图标
    private SystemTray systemTray= SystemTray.getSystemTray();//系统托盘
    PopupMenu popupMenu = new PopupMenu();
    MenuItem   m1= new MenuItem("关于我们");
    MenuItem   m2= new MenuItem("退出");
    
	

	// 构造方法
	public BackMainView() {
		init();
	
	}
	
	// 主窗体
	private void init() {
		// this.setUndecorated(true);
		this.setTitle("酒店后台管理系统V1.0");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		this.setIconImage(new ImageIcon("pic/backimages/酒店.jpg").getImage());
		m.setIcon(new ImageIcon("pic/backimages/菜单.png"));
                m.setToolTipText("选择菜单项操作");
		miqiehuan1.setIcon(new ImageIcon("pic/backimages/切换用户.png"));
                miqiehuan1.setToolTipText("切换到后台用户");
                miqiehuan2.setToolTipText("切换到前台用户");
                mituichu.setToolTipText("退出系统");
		miqiehuan2.setIcon(new ImageIcon("pic/backimages/切换用户.png"));
		mituichu.setIcon(new ImageIcon("pic/backimages/退出.png"));
		m.add(miqiehuan1);
		m.add(miqiehuan2);
		m.add(mituichu);
		// 设置菜单栏
		mb.add(m);
		this.setJMenuBar(mb);
		// 顶部
		JPanel top = addTop();
		// 中间
		JPanel pane = addComp();
		// 底部
		JPanel last = addLast();
		addListener();
		this.add(pane, BorderLayout.CENTER);
		this.add(top, BorderLayout.NORTH);
		this.add(last, BorderLayout.SOUTH);
		/********************系统托盘********************/
		
	            // 添加工具提示文本
	            trayIcon.setToolTip("酒店后台管理系统v1.0");
	            popupMenu.add(m1);
	            popupMenu.add(m2);
	            // 为托盘图标加弹出菜弹
	            trayIcon.setPopupMenu(popupMenu);
	           // systemTray.add(trayIcon);//设置托盘的图标，0.gif与该类文件同一目录
	           
	            this.dispose();
	       
	      
	        this.addWindowListener(
	                new WindowAdapter() {
	                    public void windowIconified(WindowEvent e) {
	                        dispose();//窗口最小化时dispose该窗口
	                        try {
								systemTray.add(trayIcon);
							} catch (AWTException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	                    }
	                    public void windowClosing (WindowEvent we) {
	                    	System.exit(0);
	                    	systemTray.remove(trayIcon); 
	        			}//End windowClosing
	                });
	        trayIcon.addMouseListener(
	                new MouseAdapter() {
	                    public void mouseClicked(MouseEvent e) {
	                        if (e.getClickCount() == 2)//双击托盘窗口再现
	                        {
	                            setExtendedState(Frame.NORMAL);
	                            setVisible(true);
	                            systemTray.remove(trayIcon); 
	                        }
	                    }
	                });
		
	}

	// 顶部添加标签属性
	private JPanel addTop() {
		
		JPanel jp= new JPanel(){
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("pic/backimages/酒店后台背景.jpg");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		};
		jWelcome.setForeground(Color.WHITE);
		jp.add(jWelcome);
		return jp;
	}

	// 底部添加当前用户和时间等属性
	private JPanel addLast() {
		JPanel jp = new JPanel(){
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("pic/backimages/背景3.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		};
		jp.add(jUserName);
		jp.add(jx);
		Timer timer = new Timer();
		timer.schedule(new ShowTime(), new Date(), 1000);
		return jp;
	}
	/* 监听器*监听器*监听器*监听器*监听器*监听器*监听器 */

	private void addListener() {
		
		// 菜单监听器
		this.miqiehuan1.addActionListener(new LsnrBackCaiDan(this));
		this.miqiehuan2.addActionListener(new LsnrBackCaiDan(this));
		this.mituichu.addActionListener(new LsnrBackCaiDan(this));
		//托盘监听器
		this.m1.addActionListener(new LsnrBackCaiDan(this));
		this.m2.addActionListener(new LsnrBackCaiDan(this));
		//this.trayIcon.addMouseListener(new LsnrBackCaiDan(this));
               

		// 员工信息部分五个按钮监听器和两互斥框监听器
		this.btnEmployeenSelect.addActionListener(new LsnrEmployeeSelect(this));
		this.btnDeleteEmployee.addActionListener(new LsnrDeleteEmployee(this));
		this.btnEmployeenSelectAll.addActionListener(new LsnrEmployeeSelect(this));
		this.btnAddEmployee.addActionListener(new LsnrUpdateEmployee(this));
		this.btnUpdateEmployee.addActionListener(new LsnrUpdateEmployee(this));

		this.ckbEmployeeId.addActionListener(new LsnrDeleteEmployee(this));
		this.ckbEmployeeName.addActionListener(new LsnrDeleteEmployee(this));
		// 登录权限五个按钮监听器和两互斥框监听器
		this.btnSelectLog.addActionListener(new LsnrLogBtnSelectDelete(this));
		this.btnDeleteLog.addActionListener(new LsnrLogBtnSelectDelete(this));
		this.btnSelectAllLog.addActionListener(new LsnrLogBtnSelectDelete(this));
		this.btnAddLog.addActionListener(new LsnrbtnQuanXian(this));
		this.btnUpdateLog.addActionListener(new LsnrbtnQuanXian(this));

		this.ckbLogId.addActionListener(new LsnrLogBtnSelectDelete(this));
		this.ckbLogName.addActionListener(new LsnrLogBtnSelectDelete(this));
		// 房间类型五个按钮监听器和两互斥框监听器
		this.btnAllRoom.addActionListener(new LsnrRoomTypeBtn(this));
		this.btnSelectRoom.addActionListener(new LsnrRoomTypeBtn(this));
		this.btnDeleteRoom.addActionListener(new LsnrRoomTypeBtn(this));
		this.btnAddRoom.addActionListener(new LsnrRoomTypeAddBtn(this));
		this.btnUpdateRoom.addActionListener(new LsnrRoomTypeAddBtn(this));

		this.ckbRoomName.addActionListener(new LsnrRoomTypeBtn(this));
		this.ckbRoomPrice.addActionListener(new LsnrRoomTypeBtn(this));
	    
		//房间管理模块五个按钮监听器和两互斥框监听器 和一个组合框监听器
		this.cbBoxRoom.addActionListener(new LsnrBackMainViewCbxRoom(this));
		this.ckbRToomID.addActionListener(new LsnrBackMainViewCbxRoom(this));
		this.ckbRToomType.addActionListener(new LsnrBackMainViewCbxRoom(this));
		
		this.btnAddRToom.addActionListener(new LsnrRoombtn(this));
		this.btnAllRToom.addActionListener(new LsnrRoombtn(this));
		this.btnDeleteRToom.addActionListener(new LsnrRoombtn(this));
		this.btnSelectRToom.addActionListener(new LsnrRoombtn(this));
		this.btnUpdateRToom.addActionListener(new LsnrRoombtn(this));
	      	
	}

	// 主界面中间部分添加组件
	private JPanel addComp() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JTabbedPane tabPane1 = initTabPane();
		pane.add(tabPane1, BorderLayout.CENTER);
		return pane;
	}

	// 主界面中间部分的组件
	private JTabbedPane initTabPane() {
		JTabbedPane tabPane = new JTabbedPane();
         //员工
		initEmployee(tabPane);
		//登录权限
		initLog(tabPane);
		//房间类型
		initRoomType(tabPane);
		//房间
		initRToom(tabPane);
		
		
		return tabPane;
	}
	/** 房间管理界面************************房间管理界面 *******/
	
	private void initRToom(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JPanel RoomNorthPane = initRoomNorth();
		JPanel RoomCenterPane = initRoomCenter();
		JPanel RoomSouthPane = initRoomSouth();
		pane.add(RoomNorthPane, BorderLayout.NORTH);
		pane.add(RoomCenterPane, BorderLayout.CENTER);
		pane.add(RoomSouthPane, BorderLayout.SOUTH);
		tabPane.addTab("房间管理", pane);
		
	}
	// 房间管理中间部分放置表格
	private JPanel initRoomCenter() {
	
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JScrollPane spane = new JScrollPane(tblRToom, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(spane, BorderLayout.CENTER);

		return pane;
	}
	// 房间管理南边部分 即下面部分 三个增删改按钮
	private JPanel initRoomSouth() {
		JPanel pane = new JPanel();
		btnAddRToom.setIcon(new ImageIcon("pic/backimages/Room/增加房间.png"));
                btnAddRToom.setToolTipText("添加房间");
		btnUpdateRToom.setIcon(new ImageIcon("pic/backimages/Room/更新房间.png"));
                btnUpdateRToom.setToolTipText("更改房间");
		btnDeleteRToom.setIcon(new ImageIcon("pic/backimages/Room/删除房间.png"));
                btnDeleteRToom.setToolTipText("删除房间");
		pane.add(btnAddRToom);
		pane.add(btnUpdateRToom);
		pane.add(btnDeleteRToom);
		return pane;
	}
	// 房间管理北边部分放置查找按钮
	private JPanel initRoomNorth() {
                btnAllRToom.setToolTipText("查询全部房间");
                btnSelectRToom.setToolTipText("根据选择的条件查询");
		for(String a:RoomName){
			cbBoxRoom.addItem(a);
		}
		btnSelectRToom.setIcon(new ImageIcon("pic/backimages/Room/查询房间.png"));
		btnAllRToom.setIcon(new ImageIcon("pic/backimages/查找全部.png"));
		
		ButtonGroup bu = new ButtonGroup();
		bu.add(ckbRToomID);
		bu.add(ckbRToomType);
		JPanel pane = new JPanel();
		pane.add(btnAllRToom);
		pane.add(JlRToomSelect);

		pane.add(ckbRToomID);
		pane.add(txtRToomID);

		pane.add(ckbRToomType);
		pane.add(txtRToomType);
		pane.add(cbBoxRoom);

		pane.add(btnSelectRToom);
		return pane;
	}

	/** 房间类型管理界面************************房间类型管理界面 *******/
	private void initRoomType(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JPanel RoomNorthPane = initRoomTypeNorth();
		JPanel RoomCenterPane = initRoomTypeCenter();
		JPanel RoomSouthPane = initRoomTypeSouth();
		pane.add(RoomNorthPane, BorderLayout.NORTH);
		pane.add(RoomCenterPane, BorderLayout.CENTER);
		pane.add(RoomSouthPane, BorderLayout.SOUTH);
		tabPane.addTab("房间类型管理", pane);
	}

	// 房间类型管理南边部分 即下面部分 三个增删改按钮
	private JPanel initRoomTypeSouth() {
		JPanel pane = new JPanel();
                btnAddRoom.setToolTipText("添加房间类型");
                btnUpdateRoom.setToolTipText("修改房间类型");
                btnDeleteRoom.setToolTipText("删除房间类型");
		btnAddRoom.setIcon(new ImageIcon("pic/backimages/Room/增加房间.png"));
		btnUpdateRoom.setIcon(new ImageIcon("pic/backimages/Room/更新房间.png"));
		btnDeleteRoom.setIcon(new ImageIcon("pic/backimages/Room/删除房间.png"));
		pane.add(btnAddRoom);
		pane.add(btnUpdateRoom);
		pane.add(btnDeleteRoom);
		return pane;
	}

	// 房间类型管理中间部分放置表格
	private JPanel initRoomTypeCenter() {

		

		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JScrollPane spane = new JScrollPane(tblRoom, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(spane, BorderLayout.CENTER);

		return pane;

	} // 房间类型管理北边部分放置查找按钮

	private JPanel initRoomTypeNorth() {
		btnSelectRoom.setIcon(new ImageIcon("pic/backimages/Room/查询房间.png"));
		btnAllRoom.setIcon(new ImageIcon("pic/backimages/查找全部.png"));
		btnSelectRoom.setToolTipText("根据条件查询房间类型");
                btnAllRoom.setToolTipText("查询所有房间类型");
		ButtonGroup bu = new ButtonGroup();
		bu.add(ckbRoomName);
		bu.add(ckbRoomPrice);
		JPanel pane = new JPanel();
		pane.add(btnAllRoom);
		pane.add(JlRoomSelect);

		pane.add(ckbRoomName);
		pane.add(txtRoomName);

		pane.add(ckbRoomPrice);
		pane.add(txtRoomPrice1);
		pane.add(new JLabel("~"));
		pane.add(txtRoomPrice2);

		pane.add(btnSelectRoom);
		return pane;
	}

	/******** 员工信息界面*************员工信息界面***********员工信息界面 **************************/
	// 员工信息布局
	private void initEmployee(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JPanel EmployeeNorthPane = initEmployeeNorth();
		JPanel EmployeeCenterPane = initEmployeeCenter();
		JPanel EmployeeSouthPane = initEmployeeSouth();

		pane.add(EmployeeNorthPane, BorderLayout.NORTH);
		pane.add(EmployeeCenterPane, BorderLayout.CENTER);
		pane.add(EmployeeSouthPane, BorderLayout.SOUTH);

		tabPane.addTab("员工信息", pane);
	}

	// 员工信息查询的地方添加组件 复选框姓名 编号信息
	private JPanel initEmployeeNorth() {
		btnEmployeenSelectAll.setIcon(new ImageIcon("pic/backimages/查找全部.png"));
		btnEmployeenSelect.setIcon(new ImageIcon("pic/backimages/查找人.png"));
                btnEmployeenSelectAll.setToolTipText("查询所有员工");
                btnEmployeenSelect.setToolTipText("根据条件查询员工");
		ButtonGroup bu = new ButtonGroup();
		bu.add(this.ckbEmployeeId);
		bu.add(this.ckbEmployeeName);
		JPanel pane = new JPanel();
		// this.btnEmployeenSelect.setBorder(BorderFactory.createRaisedBevelBorder());

		pane.add(this.btnEmployeenSelectAll);
		pane.add(this.JSelectEmployee);
		pane.add(this.ckbEmployeeName);
		pane.add(this.txtEmployeeName);
		// 编号
		pane.add(this.ckbEmployeeId);
		pane.add(this.txtEmployeeId);

		pane.add(this.btnEmployeenSelect);

		return pane;
	}

	// 员工信息表格部分
	private JPanel initEmployeeCenter() {
		
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JScrollPane spane = new JScrollPane(tblEmployee, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(spane, BorderLayout.CENTER);

		return pane;
	}

	// 员工信息添加组件增删改
	private JPanel initEmployeeSouth() {
                btnAddEmployee.setToolTipText("添加员工");
                btnUpdateEmployee.setToolTipText("修改员工信息");
                btnDeleteEmployee.setToolTipText("删除员工信息");
		btnAddEmployee.setIcon(new ImageIcon("pic/backimages/增加员工.png"));
		btnUpdateEmployee.setIcon(new ImageIcon("pic/backimages/更改信息.png"));
		btnDeleteEmployee.setIcon(new ImageIcon("pic/backimages/删除员工.png"));
		JPanel pane = new JPanel();

		pane.add(this.btnAddEmployee);
		pane.add(this.btnUpdateEmployee);
		pane.add(this.btnDeleteEmployee);
		return pane;

	}

	/*************** 登录权限模块***************登录权限模块*****登录权限模块 ****************/
	private void initLog(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JPanel LogNorthPane = initLogNorth();
		JPanel LogCenterPane = initLogCenter();
		JPanel LogSouthPane = initLogSouth();

		pane.add(LogNorthPane, BorderLayout.NORTH);
		pane.add(LogCenterPane, BorderLayout.CENTER);
		pane.add(LogSouthPane, BorderLayout.SOUTH);

		tabPane.addTab("登录权限", pane);
	}

	// 登录权限查找模块北边
	private JPanel initLogNorth() {
                btnSelectAllLog.setToolTipText("查询全部登录权限");
                btnSelectLog.setToolTipText("根据条件查询登录权限");
		btnSelectAllLog.setIcon(new ImageIcon("pic/backimages/查找全部.png"));
		btnSelectLog.setIcon(new ImageIcon("pic/backimages/查找人.png"));
		ButtonGroup bu = new ButtonGroup();
		bu.add(this.ckbLogId);
		bu.add(this.ckbLogName);
		JPanel pane = new JPanel();
		pane.add(this.btnSelectAllLog);
		pane.add(this.JSelectLog);
		pane.add(this.ckbLogName);
		pane.add(this.txtLogName);

		pane.add(this.ckbLogId);
		pane.add(this.txtLogId);

		pane.add(this.btnSelectLog);

		return pane;
	}

	// 登录权限 表格中心部分
	private JPanel initLogCenter() {
		JPanel pane = new JPanel();

		pane.setLayout(new BorderLayout());

		JScrollPane spane = new JScrollPane(this.tblLog, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(spane, BorderLayout.CENTER);

		return pane;
	}

	// 登录权限 南边按钮部分
	private JPanel initLogSouth() {
		JPanel pane = new JPanel();
           btnAddLog.setToolTipText("添加登录权限");
           btnUpdateLog.setToolTipText("更改密码");
           btnDeleteLog.setToolTipText("永久删除登录权限");
        btnAddLog.setIcon(new ImageIcon("pic/backimages/dengluquanxian/添加权限.png"));
        btnUpdateLog.setIcon(new ImageIcon("pic/backimages/dengluquanxian/更改密码.png"));
        btnDeleteLog.setIcon(new ImageIcon("pic/backimages/dengluquanxian/权限删除.png"));
		pane.add(this.btnAddLog);
		pane.add(this.btnUpdateLog);
		pane.add(this.btnDeleteLog);

		return pane;
	}

	/******************get私有属性 *************************************************/
	
	public JLabel getjUserName() {
		return jUserName;
	}

	public JButton getBtnAllRToom() {
		return btnAllRToom;
	}

	public JButton getBtnSelectRToom() {
		return btnSelectRToom;
	}

	public JButton getBtnAddRToom() {
		return btnAddRToom;
	}

	public JButton getBtnUpdateRToom() {
		return btnUpdateRToom;
	}

	public JButton getBtnDeleteRToom() {
		return btnDeleteRToom;
	}

	public SystemTray getSystemTray() {
		return systemTray;
	}


	public JButton getBtnAllRoom() {
		return btnAllRoom;
	}

	public JButton getBtnSelectRoom() {
		return btnSelectRoom;
	}
	public TrayIcon getTrayIcon() {
		return trayIcon;
	}

	public MenuItem getM1() {
		return m1;
	}


	public MenuItem getM2() {
		return m2;
	}


	public JButton getBtnAddRoom() {
		return btnAddRoom;
	}

	public JButton getBtnUpdateRoom() {
		return btnUpdateRoom;
	}

	public JButton getBtnDeleteRoom() {
		return btnDeleteRoom;
	}

	public JButton getBtnSelectAllLog() {
		return btnSelectAllLog;
	}

	public JButton getBtnSelectLog() {
		return btnSelectLog;
	}

	public JButton getBtnAddLog() {
		return btnAddLog;
	}

	public JButton getBtnUpdateLog() {
		return btnUpdateLog;
	}

	public JButton getBtnDeleteLog() {
		return btnDeleteLog;
	}

	public JComboBox<String> getCbBoxRoom() {
		return cbBoxRoom;
	}

	public String[] getRoomName() {
		return RoomName;
	}



	public JTextField getTxtRToomID() {
		return txtRToomID;
	}

	public JTextField getTxtRToomType() {
		return txtRToomType;
	}

	public Object[] getRToomColumnNames() {
		return RToomColumnNames;
	}

	public JTable getTblRToom() {
		return tblRToom;
	}

	

	public JTextField getTxtRoomPrice1() {
		return txtRoomPrice1;
	}

	public JTextField getTxtRoomPrice2() {
		return txtRoomPrice2;
	}

	public JTextField getTxtRoomName() {
		return txtRoomName;
	}

	public Object[] getRoomColumnNames() {
		return RoomColumnNames;
	}

	public JTable getTblRoom() {
		return tblRoom;
	}

	public JButton getBtnEmployeenSelectAll() {
		return btnEmployeenSelectAll;
	}

	
	public JRadioButton getCkbRToomID() {
		return ckbRToomID;
	}

	public JRadioButton getCkbRToomType() {
		return ckbRToomType;
	}

	public JRadioButton getCkbRoomName() {
		return ckbRoomName;
	}

	public JRadioButton getCkbRoomPrice() {
		return ckbRoomPrice;
	}

	public JRadioButton getCkbLogName() {
		return ckbLogName;
	}

	public JRadioButton getCkbLogId() {
		return ckbLogId;
	}

	public JTextField getTxtLogName() {
		return txtLogName;
	}

	public JTextField getTxtLogId() {
		return txtLogId;
	}

	public Object[] getLogColumnNames() {
		return LogColumnNames;
	}

	public JTable getTblLog() {
		return tblLog;
	}

	
	public JRadioButton getCkbEmployeeName() {
		return ckbEmployeeName;
	}

	public JRadioButton getCkbEmployeeId() {
		return ckbEmployeeId;
	}

	public JTextField getTxtEmployeeName() {
		return txtEmployeeName;
	}

	public JTextField getTxtEmployeeId() {
		return txtEmployeeId;
	}

	public JButton getBtnEmployeenSelect() {
		return btnEmployeenSelect;
	}

	public Object[] getEmployeeColumnNames() {
		return EmployeeColumnNames;
	}

	public JTable getTblEmployee() {
		return tblEmployee;
	}

	public JButton getBtnAddEmployee() {
		return btnAddEmployee;
	}

	public JButton getBtnUpdateEmployee() {
		return btnUpdateEmployee;
	}

	public JButton getBtnDeleteEmployee() {
		return btnDeleteEmployee;
	}

	

	public JMenuItem getMiqiehuan1() {
		return miqiehuan1;
	}

	public JMenuItem getMiqiehuan2() {
		return miqiehuan2;
	}

	public JMenuItem getMituichu() {
		return mituichu;
	}



	/*****************************************************/
	// 添加系统当前时间
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private JLabel jx = new JLabel();

	class ShowTime extends TimerTask {
		public void run() {
			// 刷新
			jx.setText("   系统时间: " + sdf.format(new Date()));
			repaint();
		}
	}

	class TimePanel extends JPanel {
		public void paint(Graphics g) {
			super.paint(g);
			// 显示时间
			g.drawString(sdf.format(new Date()), 10, 10);
		}
	}

	/******************* main ******************************/
/*	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(MyLookAndFeel.LIQUIDINF);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				new BackMainView().setVisible(true); //这个就是程序界面初始化
		
		
	}*/

}