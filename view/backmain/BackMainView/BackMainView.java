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
 * ��̨������
 * @author:�ź�
 * @date:2018.10.25
 * */
public class BackMainView extends JFrame {
	/*******************************************************/
	private JLabel jWelcome = new JLabel("��ӭ���پƵ��̨����ϵͳ");
	private JLabel jUserName = new JLabel();

	/***************** �˵� **************************************/
	// �˵�
	private JMenuBar mb = new JMenuBar();
	// �����˵�
	private JMenu m = new JMenu("���˵�");
	// �����˵���
	private JMenuItem miqiehuan1 = new JMenuItem("�л��û�");
	private JMenuItem miqiehuan2 = new JMenuItem("�л���ǰ̨");
	private JMenuItem mituichu = new JMenuItem("�˳�");
	/***********���������� *******���������� **********����������  ***********************/
	
	
	
	private JRadioButton ckbRToomID= new JRadioButton("�����");
	private JRadioButton ckbRToomType = new JRadioButton("��������");

	String[] RoomName={"��׼���˼�","��׼˫�˼�","�����׷�","�������ⷿ","�����","������","��ͳ�׷�"};
	private JComboBox<String> cbBoxRoom=new JComboBox<String>();
	 
	private JTextField txtRToomID = new JTextField(10);
	private JTextField txtRToomType = new JTextField(7);
	private JLabel JlRToomSelect = new JLabel("      �����Ͳ�ѯ:");
	private JButton btnAllRToom = new JButton("ȫ����Ϣ");
	private JButton btnSelectRToom = new JButton("��  ��");
	private Object[] RToomColumnNames = { "�����", "��������", "����۸�","��λ��", "����¥����"};
	private JTable tblRToom = new JTable(new DefaultTableModel(new Object[][] {}, RToomColumnNames)) {
		public boolean isCellEditable(int row, int column) {// ��������༭
			return false;
		};
	};

	private JButton btnAddRToom = new JButton("��ӷ���");
	private JButton btnUpdateRToom = new JButton("�޸ķ���");
	private JButton btnDeleteRToom = new JButton("ɾ������");
	
	
	/********* �������͹������ *****************************************************/
	private JRadioButton ckbRoomName = new JRadioButton("��������");
	private JRadioButton ckbRoomPrice = new JRadioButton("�۸�");

	private JTextField txtRoomPrice1 = new JTextField(5);
	private JTextField txtRoomPrice2 = new JTextField(5);
	private JTextField txtRoomName = new JTextField(10);
	private JLabel JlRoomSelect = new JLabel("      �����Ͳ�ѯ:");
	private JButton btnAllRoom = new JButton("ȫ����Ϣ");
	private JButton btnSelectRoom = new JButton("��  ��");
	private Object[] RoomColumnNames = { "�������ͱ��", "��������", "����۸�" };
	private JTable tblRoom = new JTable(new DefaultTableModel(new Object[][] {}, RoomColumnNames)) {
		public boolean isCellEditable(int row, int column) {// ��������༭
			return false;
		};
	};

	private JButton btnAddRoom = new JButton("��ӷ�������");
	private JButton btnUpdateRoom = new JButton("�޸ķ�������");
	private JButton btnDeleteRoom = new JButton("ɾ����������");
	
	
	
	
	

	/********** ��¼Ȩ�޽���*******��¼Ȩ�޽���**********��¼Ȩ�޽��� ***********************/
	private JRadioButton ckbLogName = new JRadioButton("����");
	private JRadioButton ckbLogId = new JRadioButton("���");

	private JTextField txtLogName = new JTextField(10);
	private JTextField txtLogId = new JTextField(10);
	private JLabel JSelectLog = new JLabel("      �����Ͳ�ѯ:");
	private JButton btnSelectAllLog = new JButton("ȫ����Ϣ");
	private JButton btnSelectLog = new JButton("��  ��");
	private Object[] LogColumnNames = { "Ա�����", "�� ��", "����", "��¼״̬(0����,1����)" };
	private JTable tblLog = new JTable(new DefaultTableModel(new Object[][] {}, LogColumnNames)) {
		public boolean isCellEditable(int row, int column) {// ��������༭
			return false;
		};
	};

	private JButton btnAddLog = new JButton("����Ȩ��");
	private JButton btnUpdateLog = new JButton("�޸�����");
	private JButton btnDeleteLog = new JButton("����Ȩ��");

	/******** Ա����Ϣ����*************Ա����Ϣ����***********Ա����Ϣ���� **************************/
	// Ա����Ϣ����

	private JRadioButton ckbEmployeeName = new JRadioButton("����");
	private JRadioButton ckbEmployeeId = new JRadioButton("Ա����");

	private JTextField txtEmployeeName = new JTextField(10);
	private JTextField txtEmployeeId = new JTextField(10);
	private JLabel JSelectEmployee = new JLabel("      �����Ͳ�ѯ:");
	private JButton btnEmployeenSelectAll = new JButton("ȫ����Ϣ");
	private JButton btnEmployeenSelect = new JButton("��  ��");
	private Object[] EmployeeColumnNames = { "Ա����", "Ա������", "��  ��", "��������", "��   ��", "��   ��", "�� �� ֤ ��" };

	private JTable tblEmployee = new JTable(new DefaultTableModel(new Object[][] {}, EmployeeColumnNames)) {
		public boolean isCellEditable(int row, int column) {// ��������༭
			return false;
		};
	};
	private JButton btnAddEmployee = new JButton("��  ��");
	private JButton btnUpdateEmployee = new JButton("��  ��");
	private JButton btnDeleteEmployee = new JButton("ɾ  ��");

	/**************************ϵͳ����***************************************/
	private TrayIcon trayIcon= new TrayIcon(new ImageIcon("pic/denglu/�Ƶ�����.png").getImage());//����ͼ��
    private SystemTray systemTray= SystemTray.getSystemTray();//ϵͳ����
    PopupMenu popupMenu = new PopupMenu();
    MenuItem   m1= new MenuItem("��������");
    MenuItem   m2= new MenuItem("�˳�");
    
	

	// ���췽��
	public BackMainView() {
		init();
	
	}
	
	// ������
	private void init() {
		// this.setUndecorated(true);
		this.setTitle("�Ƶ��̨����ϵͳV1.0");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		this.setIconImage(new ImageIcon("pic/backimages/�Ƶ�.jpg").getImage());
		m.setIcon(new ImageIcon("pic/backimages/�˵�.png"));
                m.setToolTipText("ѡ��˵������");
		miqiehuan1.setIcon(new ImageIcon("pic/backimages/�л��û�.png"));
                miqiehuan1.setToolTipText("�л�����̨�û�");
                miqiehuan2.setToolTipText("�л���ǰ̨�û�");
                mituichu.setToolTipText("�˳�ϵͳ");
		miqiehuan2.setIcon(new ImageIcon("pic/backimages/�л��û�.png"));
		mituichu.setIcon(new ImageIcon("pic/backimages/�˳�.png"));
		m.add(miqiehuan1);
		m.add(miqiehuan2);
		m.add(mituichu);
		// ���ò˵���
		mb.add(m);
		this.setJMenuBar(mb);
		// ����
		JPanel top = addTop();
		// �м�
		JPanel pane = addComp();
		// �ײ�
		JPanel last = addLast();
		addListener();
		this.add(pane, BorderLayout.CENTER);
		this.add(top, BorderLayout.NORTH);
		this.add(last, BorderLayout.SOUTH);
		/********************ϵͳ����********************/
		
	            // ��ӹ�����ʾ�ı�
	            trayIcon.setToolTip("�Ƶ��̨����ϵͳv1.0");
	            popupMenu.add(m1);
	            popupMenu.add(m2);
	            // Ϊ����ͼ��ӵ����˵�
	            trayIcon.setPopupMenu(popupMenu);
	           // systemTray.add(trayIcon);//�������̵�ͼ�꣬0.gif������ļ�ͬһĿ¼
	           
	            this.dispose();
	       
	      
	        this.addWindowListener(
	                new WindowAdapter() {
	                    public void windowIconified(WindowEvent e) {
	                        dispose();//������С��ʱdispose�ô���
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
	                        if (e.getClickCount() == 2)//˫�����̴�������
	                        {
	                            setExtendedState(Frame.NORMAL);
	                            setVisible(true);
	                            systemTray.remove(trayIcon); 
	                        }
	                    }
	                });
		
	}

	// ������ӱ�ǩ����
	private JPanel addTop() {
		
		JPanel jp= new JPanel(){
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("pic/backimages/�Ƶ��̨����.jpg");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		};
		jWelcome.setForeground(Color.WHITE);
		jp.add(jWelcome);
		return jp;
	}

	// �ײ���ӵ�ǰ�û���ʱ�������
	private JPanel addLast() {
		JPanel jp = new JPanel(){
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("pic/backimages/����3.png");
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

			}
		};
		jp.add(jUserName);
		jp.add(jx);
		Timer timer = new Timer();
		timer.schedule(new ShowTime(), new Date(), 1000);
		return jp;
	}
	/* ������*������*������*������*������*������*������ */

	private void addListener() {
		
		// �˵�������
		this.miqiehuan1.addActionListener(new LsnrBackCaiDan(this));
		this.miqiehuan2.addActionListener(new LsnrBackCaiDan(this));
		this.mituichu.addActionListener(new LsnrBackCaiDan(this));
		//���̼�����
		this.m1.addActionListener(new LsnrBackCaiDan(this));
		this.m2.addActionListener(new LsnrBackCaiDan(this));
		//this.trayIcon.addMouseListener(new LsnrBackCaiDan(this));
               

		// Ա����Ϣ���������ť��������������������
		this.btnEmployeenSelect.addActionListener(new LsnrEmployeeSelect(this));
		this.btnDeleteEmployee.addActionListener(new LsnrDeleteEmployee(this));
		this.btnEmployeenSelectAll.addActionListener(new LsnrEmployeeSelect(this));
		this.btnAddEmployee.addActionListener(new LsnrUpdateEmployee(this));
		this.btnUpdateEmployee.addActionListener(new LsnrUpdateEmployee(this));

		this.ckbEmployeeId.addActionListener(new LsnrDeleteEmployee(this));
		this.ckbEmployeeName.addActionListener(new LsnrDeleteEmployee(this));
		// ��¼Ȩ�������ť��������������������
		this.btnSelectLog.addActionListener(new LsnrLogBtnSelectDelete(this));
		this.btnDeleteLog.addActionListener(new LsnrLogBtnSelectDelete(this));
		this.btnSelectAllLog.addActionListener(new LsnrLogBtnSelectDelete(this));
		this.btnAddLog.addActionListener(new LsnrbtnQuanXian(this));
		this.btnUpdateLog.addActionListener(new LsnrbtnQuanXian(this));

		this.ckbLogId.addActionListener(new LsnrLogBtnSelectDelete(this));
		this.ckbLogName.addActionListener(new LsnrLogBtnSelectDelete(this));
		// �������������ť��������������������
		this.btnAllRoom.addActionListener(new LsnrRoomTypeBtn(this));
		this.btnSelectRoom.addActionListener(new LsnrRoomTypeBtn(this));
		this.btnDeleteRoom.addActionListener(new LsnrRoomTypeBtn(this));
		this.btnAddRoom.addActionListener(new LsnrRoomTypeAddBtn(this));
		this.btnUpdateRoom.addActionListener(new LsnrRoomTypeAddBtn(this));

		this.ckbRoomName.addActionListener(new LsnrRoomTypeBtn(this));
		this.ckbRoomPrice.addActionListener(new LsnrRoomTypeBtn(this));
	    
		//�������ģ�������ť�������������������� ��һ����Ͽ������
		this.cbBoxRoom.addActionListener(new LsnrBackMainViewCbxRoom(this));
		this.ckbRToomID.addActionListener(new LsnrBackMainViewCbxRoom(this));
		this.ckbRToomType.addActionListener(new LsnrBackMainViewCbxRoom(this));
		
		this.btnAddRToom.addActionListener(new LsnrRoombtn(this));
		this.btnAllRToom.addActionListener(new LsnrRoombtn(this));
		this.btnDeleteRToom.addActionListener(new LsnrRoombtn(this));
		this.btnSelectRToom.addActionListener(new LsnrRoombtn(this));
		this.btnUpdateRToom.addActionListener(new LsnrRoombtn(this));
	      	
	}

	// �������м䲿��������
	private JPanel addComp() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JTabbedPane tabPane1 = initTabPane();
		pane.add(tabPane1, BorderLayout.CENTER);
		return pane;
	}

	// �������м䲿�ֵ����
	private JTabbedPane initTabPane() {
		JTabbedPane tabPane = new JTabbedPane();
         //Ա��
		initEmployee(tabPane);
		//��¼Ȩ��
		initLog(tabPane);
		//��������
		initRoomType(tabPane);
		//����
		initRToom(tabPane);
		
		
		return tabPane;
	}
	/** ����������************************���������� *******/
	
	private void initRToom(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JPanel RoomNorthPane = initRoomNorth();
		JPanel RoomCenterPane = initRoomCenter();
		JPanel RoomSouthPane = initRoomSouth();
		pane.add(RoomNorthPane, BorderLayout.NORTH);
		pane.add(RoomCenterPane, BorderLayout.CENTER);
		pane.add(RoomSouthPane, BorderLayout.SOUTH);
		tabPane.addTab("�������", pane);
		
	}
	// ��������м䲿�ַ��ñ��
	private JPanel initRoomCenter() {
	
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JScrollPane spane = new JScrollPane(tblRToom, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(spane, BorderLayout.CENTER);

		return pane;
	}
	// ��������ϱ߲��� �����沿�� ������ɾ�İ�ť
	private JPanel initRoomSouth() {
		JPanel pane = new JPanel();
		btnAddRToom.setIcon(new ImageIcon("pic/backimages/Room/���ӷ���.png"));
                btnAddRToom.setToolTipText("��ӷ���");
		btnUpdateRToom.setIcon(new ImageIcon("pic/backimages/Room/���·���.png"));
                btnUpdateRToom.setToolTipText("���ķ���");
		btnDeleteRToom.setIcon(new ImageIcon("pic/backimages/Room/ɾ������.png"));
                btnDeleteRToom.setToolTipText("ɾ������");
		pane.add(btnAddRToom);
		pane.add(btnUpdateRToom);
		pane.add(btnDeleteRToom);
		return pane;
	}
	// ��������߲��ַ��ò��Ұ�ť
	private JPanel initRoomNorth() {
                btnAllRToom.setToolTipText("��ѯȫ������");
                btnSelectRToom.setToolTipText("����ѡ���������ѯ");
		for(String a:RoomName){
			cbBoxRoom.addItem(a);
		}
		btnSelectRToom.setIcon(new ImageIcon("pic/backimages/Room/��ѯ����.png"));
		btnAllRToom.setIcon(new ImageIcon("pic/backimages/����ȫ��.png"));
		
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

	/** �������͹������************************�������͹������ *******/
	private void initRoomType(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JPanel RoomNorthPane = initRoomTypeNorth();
		JPanel RoomCenterPane = initRoomTypeCenter();
		JPanel RoomSouthPane = initRoomTypeSouth();
		pane.add(RoomNorthPane, BorderLayout.NORTH);
		pane.add(RoomCenterPane, BorderLayout.CENTER);
		pane.add(RoomSouthPane, BorderLayout.SOUTH);
		tabPane.addTab("�������͹���", pane);
	}

	// �������͹����ϱ߲��� �����沿�� ������ɾ�İ�ť
	private JPanel initRoomTypeSouth() {
		JPanel pane = new JPanel();
                btnAddRoom.setToolTipText("��ӷ�������");
                btnUpdateRoom.setToolTipText("�޸ķ�������");
                btnDeleteRoom.setToolTipText("ɾ����������");
		btnAddRoom.setIcon(new ImageIcon("pic/backimages/Room/���ӷ���.png"));
		btnUpdateRoom.setIcon(new ImageIcon("pic/backimages/Room/���·���.png"));
		btnDeleteRoom.setIcon(new ImageIcon("pic/backimages/Room/ɾ������.png"));
		pane.add(btnAddRoom);
		pane.add(btnUpdateRoom);
		pane.add(btnDeleteRoom);
		return pane;
	}

	// �������͹����м䲿�ַ��ñ��
	private JPanel initRoomTypeCenter() {

		

		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JScrollPane spane = new JScrollPane(tblRoom, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(spane, BorderLayout.CENTER);

		return pane;

	} // �������͹����߲��ַ��ò��Ұ�ť

	private JPanel initRoomTypeNorth() {
		btnSelectRoom.setIcon(new ImageIcon("pic/backimages/Room/��ѯ����.png"));
		btnAllRoom.setIcon(new ImageIcon("pic/backimages/����ȫ��.png"));
		btnSelectRoom.setToolTipText("����������ѯ��������");
                btnAllRoom.setToolTipText("��ѯ���з�������");
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

	/******** Ա����Ϣ����*************Ա����Ϣ����***********Ա����Ϣ���� **************************/
	// Ա����Ϣ����
	private void initEmployee(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JPanel EmployeeNorthPane = initEmployeeNorth();
		JPanel EmployeeCenterPane = initEmployeeCenter();
		JPanel EmployeeSouthPane = initEmployeeSouth();

		pane.add(EmployeeNorthPane, BorderLayout.NORTH);
		pane.add(EmployeeCenterPane, BorderLayout.CENTER);
		pane.add(EmployeeSouthPane, BorderLayout.SOUTH);

		tabPane.addTab("Ա����Ϣ", pane);
	}

	// Ա����Ϣ��ѯ�ĵط������� ��ѡ������ �����Ϣ
	private JPanel initEmployeeNorth() {
		btnEmployeenSelectAll.setIcon(new ImageIcon("pic/backimages/����ȫ��.png"));
		btnEmployeenSelect.setIcon(new ImageIcon("pic/backimages/������.png"));
                btnEmployeenSelectAll.setToolTipText("��ѯ����Ա��");
                btnEmployeenSelect.setToolTipText("����������ѯԱ��");
		ButtonGroup bu = new ButtonGroup();
		bu.add(this.ckbEmployeeId);
		bu.add(this.ckbEmployeeName);
		JPanel pane = new JPanel();
		// this.btnEmployeenSelect.setBorder(BorderFactory.createRaisedBevelBorder());

		pane.add(this.btnEmployeenSelectAll);
		pane.add(this.JSelectEmployee);
		pane.add(this.ckbEmployeeName);
		pane.add(this.txtEmployeeName);
		// ���
		pane.add(this.ckbEmployeeId);
		pane.add(this.txtEmployeeId);

		pane.add(this.btnEmployeenSelect);

		return pane;
	}

	// Ա����Ϣ��񲿷�
	private JPanel initEmployeeCenter() {
		
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JScrollPane spane = new JScrollPane(tblEmployee, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(spane, BorderLayout.CENTER);

		return pane;
	}

	// Ա����Ϣ��������ɾ��
	private JPanel initEmployeeSouth() {
                btnAddEmployee.setToolTipText("���Ա��");
                btnUpdateEmployee.setToolTipText("�޸�Ա����Ϣ");
                btnDeleteEmployee.setToolTipText("ɾ��Ա����Ϣ");
		btnAddEmployee.setIcon(new ImageIcon("pic/backimages/����Ա��.png"));
		btnUpdateEmployee.setIcon(new ImageIcon("pic/backimages/������Ϣ.png"));
		btnDeleteEmployee.setIcon(new ImageIcon("pic/backimages/ɾ��Ա��.png"));
		JPanel pane = new JPanel();

		pane.add(this.btnAddEmployee);
		pane.add(this.btnUpdateEmployee);
		pane.add(this.btnDeleteEmployee);
		return pane;

	}

	/*************** ��¼Ȩ��ģ��***************��¼Ȩ��ģ��*****��¼Ȩ��ģ�� ****************/
	private void initLog(JTabbedPane tabPane) {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JPanel LogNorthPane = initLogNorth();
		JPanel LogCenterPane = initLogCenter();
		JPanel LogSouthPane = initLogSouth();

		pane.add(LogNorthPane, BorderLayout.NORTH);
		pane.add(LogCenterPane, BorderLayout.CENTER);
		pane.add(LogSouthPane, BorderLayout.SOUTH);

		tabPane.addTab("��¼Ȩ��", pane);
	}

	// ��¼Ȩ�޲���ģ�鱱��
	private JPanel initLogNorth() {
                btnSelectAllLog.setToolTipText("��ѯȫ����¼Ȩ��");
                btnSelectLog.setToolTipText("����������ѯ��¼Ȩ��");
		btnSelectAllLog.setIcon(new ImageIcon("pic/backimages/����ȫ��.png"));
		btnSelectLog.setIcon(new ImageIcon("pic/backimages/������.png"));
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

	// ��¼Ȩ�� ������Ĳ���
	private JPanel initLogCenter() {
		JPanel pane = new JPanel();

		pane.setLayout(new BorderLayout());

		JScrollPane spane = new JScrollPane(this.tblLog, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.add(spane, BorderLayout.CENTER);

		return pane;
	}

	// ��¼Ȩ�� �ϱ߰�ť����
	private JPanel initLogSouth() {
		JPanel pane = new JPanel();
           btnAddLog.setToolTipText("��ӵ�¼Ȩ��");
           btnUpdateLog.setToolTipText("��������");
           btnDeleteLog.setToolTipText("����ɾ����¼Ȩ��");
        btnAddLog.setIcon(new ImageIcon("pic/backimages/dengluquanxian/���Ȩ��.png"));
        btnUpdateLog.setIcon(new ImageIcon("pic/backimages/dengluquanxian/��������.png"));
        btnDeleteLog.setIcon(new ImageIcon("pic/backimages/dengluquanxian/Ȩ��ɾ��.png"));
		pane.add(this.btnAddLog);
		pane.add(this.btnUpdateLog);
		pane.add(this.btnDeleteLog);

		return pane;
	}

	/******************get˽������ *************************************************/
	
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
	// ���ϵͳ��ǰʱ��
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private JLabel jx = new JLabel();

	class ShowTime extends TimerTask {
		public void run() {
			// ˢ��
			jx.setText("   ϵͳʱ��: " + sdf.format(new Date()));
			repaint();
		}
	}

	class TimePanel extends JPanel {
		public void paint(Graphics g) {
			super.paint(g);
			// ��ʾʱ��
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
		
				new BackMainView().setVisible(true); //������ǳ�������ʼ��
		
		
	}*/

}