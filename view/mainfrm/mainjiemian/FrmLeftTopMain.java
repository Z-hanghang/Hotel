package view.mainfrm.mainjiemian;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import common.component.swings.TJButton;
import control.mainfrm.mainjiemian.leftfrmlsnr.LsnrLeftBQBtn;
import model.mainfrm.mainjiemian.lefttopfrm.MDLFrmLeftTop;
import vo.mainfrm.RoomVO;

/**
 * ���Ϸ����ڷ�����ס�˿͵���Ϣ�ͷ�����̬�����
 * 
 * @author �Ⱒ��
 *
 */
public class FrmLeftTopMain extends JPanel {

	// ������Ϣ
	public static JLabel title0, title1, title2, line;
	public static JLabel lt[] = new JLabel[14];

	// ��ǩ��������
	private JTextArea noteTA;
	private JScrollPane JSPane;

	// ��ǩ��������
	private JTabbedPane tagTP;
	private JPanel state, notepaper; // ״̬����ǩ

	private TJButton jisuanqi,rili,yinyue;

	
	public TJButton getJisuanqi() {
		return jisuanqi;
	}

	public TJButton getRili() {
		return rili;
	}

	public TJButton getYinyue() {
		return yinyue;
	}
	/**
	 * ���캯�� ���� ���������������ϲ����
	 */
	public FrmLeftTopMain() {
		super(new BorderLayout());
		init();
	}

	public void init() {
		tagTP = new JTabbedPane(JTabbedPane.TOP); // ��ǩ��

		buildState(); // ����״̬��ǩҳ

		buildNotepaper(); // ������ǩҳ

		// ��ʼ��������״̬
		initRoomstate();

		// ������ǩ��
		tagTP.addTab("״̬", new ImageIcon("pic/b1.gif"), state);
		tagTP.addTab("��ǩ", new ImageIcon("pic/b2.gif"), notepaper);

		this.add("Center", tagTP);
		// this.add("Center", type);
		
		//������
		addListener();
	}

	private void addListener() {
		this.jisuanqi.addActionListener(new LsnrLeftBQBtn(this));  //����������
		this.rili.addActionListener(new LsnrLeftBQBtn(this));  //����
		this.yinyue.addActionListener(new LsnrLeftBQBtn(this));  //����
	}

	/**
	 * ��������״̬ҳ��
	 */
	private void buildState() {
		String lbText[] = { "  ����������", "  ���͵绰", "  �˿��Ա�", "  ����ţ�", "  ��ס������", "  ��סʱ�䣺", "  �ѽ�Ѻ��", "  Ա����ţ�",
				"  ����������", "  ��ǰ�ɹ���", "  ��ǰԤ����", "  ��ǰռ�ã�", "  ��ǰ�෿��", "  ��ǰͣ�ã�" };
		JLabel lbMessage[] = new JLabel[14]; // ��ȡ����Ϣ����ʾ

		JPanel jp1, jp2, jp3, jp4, jp5, jp6;

		// ���ñ���
		title0 = new JLabel("�굥�˼�: ");
		title1 = new JLabel("");
		title2 = new JLabel("������״̬:");
		title0.setForeground(Color.red);
		title1.setForeground(Color.red);
		title2.setForeground(Color.red);
		title0.setFont(new Font("����", Font.PLAIN, 25));
		title1.setFont(new Font("����", Font.PLAIN, 25));
		title2.setFont(new Font("����", Font.PLAIN, 25));

		// �������
		state = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp1 = new JPanel(new FlowLayout());

		jp2 = new JPanel(new GridLayout(8, 1));
		jp3 = new JPanel(new GridLayout(8, 1));

		jp4 = new JPanel(new GridLayout(6, 1));
		jp5 = new JPanel(new GridLayout(6, 1));

		jp6 = new JPanel(new GridLayout(1, 1));

		// ��ʼ����ǩ����
		for (int i = 0; i < 8; i++) { // �����һ����
			lbMessage[i] = new JLabel(lbText[i]);
			lt[i] = new JLabel("");
			lt[i].setForeground(Color.BLUE);
			jp2.add(lbMessage[i]);
			jp3.add(lt[i]);
		}
		for (int i = 8; i < 14; i++) { // ����ڶ�����
			lbMessage[i] = new JLabel(lbText[i]);
			lt[i] = new JLabel("");
			lt[i].setForeground(Color.BLUE);
			jp4.add(lbMessage[i]);
			jp5.add(lt[i]);
		}

		// ������������
		jp1.add(title0);
		jp1.add(title1);
		jp6.add(title2);

		state.add(jp1); // �ӱ���
		state.add(jp2); // �ӷ�����Ϣ
		state.add(jp3);

		state.add(jp6); // �ӷָ��ߺ����淿��״̬�ı���
		state.add(jp4); // �ӷ���״̬��Ϣ
		state.add(jp5);
	}

	/**
	 * ���� ��������ǩҳ
	 */
	private void buildNotepaper() {
		JPanel p = new JPanel(new GridLayout(1, 1));
		jisuanqi=new TJButton("pic/toolsbar/������.png",  "  ������  ", "��������", true);
		rili = new TJButton("pic/toolsbar/����.png",  "  ����  ", "�����鿴ʱ��", true);
		yinyue = new TJButton("pic/toolsbar/����.png",  "  ����  ", "���з���һ��", true);
		p.add(jisuanqi);
		p.add(rili);
		p.add(yinyue);
		
		
		noteTA = new JTextArea(25, 4);
		JSPane = new JScrollPane(noteTA);
		
		noteTA.setForeground(new Color(161, 149, 121));
		noteTA.setBackground(new Color(233, 227, 214));

		notepaper = new JPanel(new BorderLayout());
		// ���ù������û�к��������
		JSPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		notepaper.add("Center", JSPane);

		notepaper.add("North", p);
	}

	/**
	 * ��ʼ������״̬��Ϣ��ͨ�����÷����״̬id��ȡ���������
	 */
	private MDLFrmLeftTop mdlFrmLeftTop = new MDLFrmLeftTop();

	public void initRoomstate() {
		RoomVO vo = new RoomVO();
		vo.setRoomStateId("");
		String[] obj1 = mdlFrmLeftTop.findRoomCount(vo);
		lt[8].setText(obj1[0]);
		// System.out.println(lt[8].getText());
		vo.setRoomStateId("RS01");
		String[] obj2 = mdlFrmLeftTop.findRoomCount(vo);
		lt[9].setText(obj2[0]);
		vo.setRoomStateId("RS02");
		String[] obj3 = mdlFrmLeftTop.findRoomCount(vo);
		lt[10].setText(obj3[0]);
		vo.setRoomStateId("RS03");
		String[] obj4 = mdlFrmLeftTop.findRoomCount(vo);
		lt[11].setText(obj4[0]);
		vo.setRoomStateId("RS04");
		String[] obj5 = mdlFrmLeftTop.findRoomCount(vo);
		lt[12].setText(obj5[0]);
		vo.setRoomStateId("RS05");
		String[] obj6 = mdlFrmLeftTop.findRoomCount(vo);
		lt[13].setText(obj6[0]);
	}

}
