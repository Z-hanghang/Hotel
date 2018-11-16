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
 * 左上方用于房间所住顾客的信息和房间总态的面板
 * 
 * @author 吴阿龙
 *
 */
public class FrmLeftTopMain extends JPanel {

	// 房间信息
	public static JLabel title0, title1, title2, line;
	public static JLabel lt[] = new JLabel[14];

	// 便签与滚动面板
	private JTextArea noteTA;
	private JScrollPane JSPane;

	// 标签面板与面板
	private JTabbedPane tagTP;
	private JPanel state, notepaper; // 状态、便签

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
	 * 构造函数 功能 ：组件主窗口左边上部面板
	 */
	public FrmLeftTopMain() {
		super(new BorderLayout());
		init();
	}

	public void init() {
		tagTP = new JTabbedPane(JTabbedPane.TOP); // 标签栏

		buildState(); // 制作状态标签页

		buildNotepaper(); // 制作便签页

		// 初始化房间总状态
		initRoomstate();

		// 制作标签栏
		tagTP.addTab("状态", new ImageIcon("pic/b1.gif"), state);
		tagTP.addTab("便签", new ImageIcon("pic/b2.gif"), notepaper);

		this.add("Center", tagTP);
		// this.add("Center", type);
		
		//监听器
		addListener();
	}

	private void addListener() {
		this.jisuanqi.addActionListener(new LsnrLeftBQBtn(this));  //计算器监听
		this.rili.addActionListener(new LsnrLeftBQBtn(this));  //日历
		this.yinyue.addActionListener(new LsnrLeftBQBtn(this));  //音乐
	}

	/**
	 * 制作房间状态页面
	 */
	private void buildState() {
		String lbText[] = { "  宾客姓名：", "  宾客电话", "  顾客性别：", "  房间号：", "  入住人数：", "  入住时间：", "  已交押金：", "  员工编号：",
				"  房间总数：", "  当前可供：", "  当前预定：", "  当前占用：", "  当前脏房：", "  当前停用：" };
		JLabel lbMessage[] = new JLabel[14]; // 提取的信息的显示

		JPanel jp1, jp2, jp3, jp4, jp5, jp6;

		// 设置标题
		title0 = new JLabel("标单人间: ");
		title1 = new JLabel("");
		title2 = new JLabel("房间总状态:");
		title0.setForeground(Color.red);
		title1.setForeground(Color.red);
		title2.setForeground(Color.red);
		title0.setFont(new Font("宋体", Font.PLAIN, 25));
		title1.setFont(new Font("宋体", Font.PLAIN, 25));
		title2.setFont(new Font("宋体", Font.PLAIN, 25));

		// 定义面板
		state = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp1 = new JPanel(new FlowLayout());

		jp2 = new JPanel(new GridLayout(8, 1));
		jp3 = new JPanel(new GridLayout(8, 1));

		jp4 = new JPanel(new GridLayout(6, 1));
		jp5 = new JPanel(new GridLayout(6, 1));

		jp6 = new JPanel(new GridLayout(1, 1));

		// 初始化标签内容
		for (int i = 0; i < 8; i++) { // 加入第一个表
			lbMessage[i] = new JLabel(lbText[i]);
			lt[i] = new JLabel("");
			lt[i].setForeground(Color.BLUE);
			jp2.add(lbMessage[i]);
			jp3.add(lt[i]);
		}
		for (int i = 8; i < 14; i++) { // 加入第二个表
			lbMessage[i] = new JLabel(lbText[i]);
			lt[i] = new JLabel("");
			lt[i].setForeground(Color.BLUE);
			jp4.add(lbMessage[i]);
			jp5.add(lt[i]);
		}

		// 加入组件到面板
		jp1.add(title0);
		jp1.add(title1);
		jp6.add(title2);

		state.add(jp1); // 加标题
		state.add(jp2); // 加房间信息
		state.add(jp3);

		state.add(jp6); // 加分隔线和下面房间状态的标题
		state.add(jp4); // 加房间状态信息
		state.add(jp5);
	}

	/**
	 * 功能 ：制作便签页
	 */
	private void buildNotepaper() {
		JPanel p = new JPanel(new GridLayout(1, 1));
		jisuanqi=new TJButton("pic/toolsbar/计算器.png",  "  计算器  ", "用来计算", true);
		rili = new TJButton("pic/toolsbar/日历.png",  "  日历  ", "用来查看时间", true);
		yinyue = new TJButton("pic/toolsbar/音乐.png",  "  音乐  ", "休闲放松一下", true);
		p.add(jisuanqi);
		p.add(rili);
		p.add(yinyue);
		
		
		noteTA = new JTextArea(25, 4);
		JSPane = new JScrollPane(noteTA);
		
		noteTA.setForeground(new Color(161, 149, 121));
		noteTA.setBackground(new Color(233, 227, 214));

		notepaper = new JPanel(new BorderLayout());
		// 设置滚动面板没有横向滚动条
		JSPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		notepaper.add("Center", JSPane);

		notepaper.add("North", p);
	}

	/**
	 * 初始化房间状态信息，通过设置房间的状态id获取房间的数量
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
