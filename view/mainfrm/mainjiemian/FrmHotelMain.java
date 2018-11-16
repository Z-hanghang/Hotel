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
 * ������
 * 
 * @author �Ⱒ��
 *
 */
public class FrmHotelMain extends JFrame {
	public static String userid;
	public static JLabel lbA, lbB, lbC, jX;
	public static String clue = "    �� ʾ :  ";
	public static String face = "    ��ǰ�������� :  ";

	// ������˵���ص���
	private JMenuBar mb;
	private JMenu m1, m2, m3; // �������˵� ������Ϣ ϵͳ���ò˵�
	private JMenuItem mi11, mi12, mi13, mi14, mi15, mi16, mi17, mi21, mi22, mi23, mi31, mi32,mi33;

	// ������
	private JToolBar tb; // ������ť�˵���
	private JButton fangjianguanlibt, yudingguanlibt, ruzhudengjibt, ruzhuchaxunbt, tuifangjiezhangbt, kehuguanlibt,
			zengjiaxiaofeibt, jiesuanselectbt, aboutusbt, huanbanbt, quitsystem;
	// �ָ����
	private JSplitPane spaneMain, spaneLeft, spaneRight;
	// ģ��ӿ�
	private JPanel panelMain, bott, jp1, jp2, jp3, jp4, JTime;

	// public LsnrFrmMainBtn lsnrFrmMainBtn = new LsnrFrmMainBtn(this); //��ҳ���а�ť�ļ���

	/************************** ϵͳ���� ***************************************/
	private TrayIcon trayIcon = new TrayIcon(new ImageIcon("pic/denglu/�Ƶ�����.png").getImage());// ����ͼ��
	private SystemTray systemTray = SystemTray.getSystemTray();// ϵͳ����
	PopupMenu popupMenu = new PopupMenu();
	MenuItem mi1 = new MenuItem("��������");
	MenuItem mi2 = new MenuItem("�˳�");

	// ���캯��
	public FrmHotelMain() {
		panelMain = new JPanel(new BorderLayout()); // �����
		init();
	}

	public void init() {
                this.setIconImage(new ImageIcon("pic/backimages/�Ƶ�.jpg").getImage());
		// �����˵�
		buildMenuBar();
		// ����������
		buildToolBar();
		// �����ָ����
		buildSpaneMain();
		// �������ڵ׶���Ϣ��
		buildBott();

		// ��������������
		panelMain.add("North", tb); // ���빤����
		panelMain.add("South", bott); // ���봰�ڵ׶���Ϣ��
		panelMain.add("Center", spaneMain); // ����ָ����

		// ����˵���
		this.setJMenuBar(mb);

		// �Ӽ�����
		addListener();

		// �����˳�����
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
		this.setMinimumSize(new Dimension(1020, 740)); // ���ô�����С�ߴ�
		// this.setVisible (true);

		/******************** ϵͳ���� ********************/

		// ��ӹ�����ʾ�ı�
		trayIcon.setToolTip("�Ƶ�ǰ̨����ϵͳv1.0");
		popupMenu.add(mi1);
		popupMenu.add(mi2);
		// Ϊ����ͼ��ӵ����˵�
		trayIcon.setPopupMenu(popupMenu);
		// systemTray.add(trayIcon);//�������̵�ͼ�꣬0.gif������ļ�ͬһĿ¼
		this.dispose();

		this.addWindowListener(new WindowAdapter() {
			public void windowIconified(WindowEvent e) {
				dispose();// ������С��ʱdispose�ô���
				try {
					systemTray.add(trayIcon);
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // �������̵�ͼ�꣬0.gif������ļ�ͬһĿ¼
			}

		});
		trayIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)// ˫�����̴�������
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
		// ����button��ť��������
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

		// ����button������
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

		// �˵�����
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
		//���̲˵�������
		this.mi1.addActionListener(new LsnrFrmMainMenu(this));  //��������
		this.mi2.addActionListener(new LsnrFrmMainMenu(this));  //�˳�
	}

	// �����˵�
	private void buildMenuBar() {
		// ʵ���˵���
		mb = new JMenuBar();
		mb.setBackground(new Color(92, 156, 200));

		// ʵ���˵�
		m1 = new JMenu("������� (F)");
		m2 = new JMenu("������Ϣ (S)");
		m3 = new JMenu("ϵͳ���� (R)");

		// ʵ���˵���
		mi11 = new JMenuItem("�Ǽ���ס����(D)");
		mi12 = new JMenuItem("��ס��Ϣ��ѯ����(M)");
		mi13 = new JMenuItem("�������䡡��(A)");
		mi14 = new JMenuItem("�޸ĵǼǡ���(J)");
		mi15 = new JMenuItem("����״̬����(Z)");
		mi16 = new JMenuItem("Ԥ��������(T)");
		mi17 = new JMenuItem("�˳�ϵͳ����(X)");
		mi21 = new JMenuItem("���ͽ��ʡ���(J)");
		mi22 = new JMenuItem("�����ѯ����(E)");
		mi23 = new JMenuItem("���ͷ���������ϸ��ѯ");
		mi31 = new JMenuItem("���ࡡ��(Z)");
		mi32 = new JMenuItem("�������ǡ���(A)");
                mi33 = new JMenuItem("ϵͳ��������(H)");
		// //δ������ϵĹ���

		// ��֯�˵�
		m1.add(mi11); // �������
		m1.add(mi12);
		m1.add(mi13);
		m1.add(mi14);
		m1.add(mi15);
		m1.add(mi16);
		m1.addSeparator();
		m1.add(mi17);

		m2.add(mi21); // ������Ϣ
		m2.add(mi22);
		m2.add(mi23);

		m3.add(mi31); // ϵͳ����
		m3.addSeparator();
		m3.add(mi32);
                m3.add(mi33);

		mb.add(m1); // ����˵���
		mb.add(m2);
		mb.add(m3);
	}

	// ����������
	private void buildToolBar() {
		tb = new JToolBar();
		tb.setBackground(new Color(193, 210, 240));
		// ��������
		fangjianguanlibt = new TJButton("pic/toolsbar/�������.png", "  �������  ", "���з�����Ϣ�Ĺ���", true);
		yudingguanlibt = new TJButton("pic/toolsbar/Ԥ��.png", "  Ԥ������  ", "Ϊ����Ԥ������", true);
		// bt3 = new TJButton ("pic/toolsbar/��ѯ.png", " Ԥ����ѯ ", "��ѯ����Ԥ����Ϣ", true);
		ruzhudengjibt = new TJButton("pic/toolsbar/�Ǽ�.png", "  ��ס�Ǽ�  ", "�����ͽ��еǼ���ס", true);
		ruzhuchaxunbt = new TJButton("pic/toolsbar/��ѯ.png", "  ��ס��ѯ  ", "�����˷�����", true);
		tuifangjiezhangbt = new TJButton("pic/toolsbar/���˷�.png", "  �˷�����  ", "�����˷�����", true);
		kehuguanlibt = new TJButton("pic/toolsbar/�ͻ�����.png ", "  �ͻ�����  ", "���й˿���Ϣ�Ĺ���", true);
		zengjiaxiaofeibt = new TJButton("pic/toolsbar/����.png", "  ��������", "���Ӷ��������", true);
		jiesuanselectbt = new TJButton("pic/toolsbar/�����ѯ.png", "  �����ѯ  ", "��ѯ�˿����������", true);
		aboutusbt = new TJButton("pic/toolsbar/��������.png", "  ��������  ", "�����Ϣ", true);
		huanbanbt = new TJButton("pic/toolsbar/����.png", "  ��         ��  ", "�л���¼", true);
		quitsystem = new TJButton("pic/toolsbar/�˳�ϵͳ.png", "  �˳�ϵͳ  ", "����Windows", true);

		// �Ѱ������빤����
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

		// ���ù��������ɸ���
		tb.setFloatable(false);
	}

	// ���������
	private void buildSpaneMain() {

		jp1 = new FrmLeftTopMain(); // ������� ¥������
		jp2 = new FrmLeftBottMain(); // ������� ����ͨ��
		jp3 = new FrmRightTopMain(); ///////////////////////////////
		jp4 = new FrmRightBottMain();

		// �����ָ����
		spaneLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jp1, jp2); // jp2
		spaneRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jp3, jp4);
		spaneMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, spaneLeft, spaneRight);

		// ���������С�ߴ�
		jp1.setMinimumSize(new Dimension(160, 580));
		jp2.setMinimumSize(new Dimension(160, 300));
		jp3.setMinimumSize(new Dimension(875, 300));
		jp4.setMinimumSize(new Dimension(875, 94));
		spaneRight.setMinimumSize(new Dimension(875, 565));

		// ���÷ָ����Ƿ���������
		spaneMain.setOneTouchExpandable(true);
		spaneRight.setOneTouchExpandable(true);

		// ���ø����ĳ���ߴ�
		spaneMain.setDividerLocation(215);
		spaneLeft.setDividerLocation(450);
		spaneRight.setDividerLocation(700);

		// ���÷ָ������
		spaneMain.setDividerSize(0);
		spaneLeft.setDividerSize(3);
		spaneRight.setDividerSize(23);
	}

	// ����bott��
	private void buildBott() {
		JLabel lb1, lb2, lb3, lb4;

		lbA = new JLabel(clue + "��ѡ������ ... ");
		lbB = new JLabel(face + "������ �� �� �� ϵ ͳ ��            1.01 ��  ");
		lb1 = new JLabel("    ���� �� �� �� �� ϵ ͳ    ");
		lb2 = new JLabel("    ��ǰ����Ա :  ");
		lbC = new JLabel(userid + "                  ");
		lb3 = new JLabel("                      ");
		lb4 = new JLabel("��ǰʱ�䣺 ");
		jX = new JLabel();

		// �������
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
	 * ʱ����ʾ��������ͨ��
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH : mm : ss ");

	class ShowTime extends TimerTask {
		public void run() {
			// ˢ��
			jX.setText(sdf.format(new Date()));
			repaint();
		}
	}

	/**
	 * private void quit () {} : ϵͳ�˳� ���� ���ر�ϵͳ������������ʹ��
	 */
	private void quit() {
		QuitSystem q = new QuitSystem();
		q.quit(this);

	}

	public JButton getFangjianguanlibt() { // �������
		return fangjianguanlibt;
	}

	public JButton getYudingguanlibt() { // Ԥ������
		return yudingguanlibt;
	}

	public JButton getRuzhudengjibt() { // ��ס�Ǽ�
		return ruzhudengjibt;
	}

	public JButton getRuzhuchaxunbt() { // ��ס��ѯ
		return ruzhuchaxunbt;
	}

	public JButton getTuifangjiezhangbt() { // �˷�����
		return tuifangjiezhangbt;
	}

	public JButton getKehuguanlibt() { // �ͻ�����
		return kehuguanlibt;
	}

	public JButton getZengjiaxiaofeibt() { // ��������
		return zengjiaxiaofeibt;
	}

	public JButton getJiesuanselectbt() { // �����ѯ
		return jiesuanselectbt;
	}

	public JButton getAboutus() { // ��������
		return aboutusbt;
	}

	public JButton getHuanbanbt() { // ����
		return huanbanbt;
	}

    public JMenuItem getMi33() {//ϵͳ����
        return mi33;
    }

   

	public JButton getQuitsystem() { // �˳�ϵͳ
		return quitsystem;
	}

	// ------------------------------------------ // �˵���ť
	public JMenuItem getMi11() { // �Ǽ���ס
		return mi11;
	}

	public JMenuItem getMi12() { // ��ס��Ϣ��ѯ
		return mi12;
	}

	public JMenuItem getMi13() { // ��������
		return mi13;
	}

	public JMenuItem getMi14() { // �޸ĵǼ�
		return mi14;
	}

	public JMenuItem getMi15() { // ����״̬
		return mi15;
	}

	public JMenuItem getMi16() { // Ԥ������
		return mi16;
	}

	public JMenuItem getMi17() { // �˳�ϵͳ
		return mi17;
	}

	public JMenuItem getMi21() { // ���ͽ���
		return mi21;
	}

	public JMenuItem getMi22() { // �����ѯ
		return mi22;
	}

	public JMenuItem getMi23() { // ���ͷ������Ѳ�ѯ
		return mi23;
	}

	public JMenuItem getMi31() { // ����
		return mi31;
	}

	public JMenuItem getMi32() { // ��������
		return mi32;
	}

/*	public static void main(String sd[]) {

		new FrmHotelMain().setVisible(true);
		;
	}*/
}
