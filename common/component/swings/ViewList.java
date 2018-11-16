/**
 *	 模块名        : ViewList控件
 *	 文件名        : ViewList.java
 *	 文件实现功能  : 生成和我的电脑差不多的面板
 *	
 *	 函数说明      :	
 *	
 *	 public ViewList(int buttons) {} :
 *		功能: 构造函数，并制作主面板
 *
 *	 public void remeButtons() {} :	
 *		功能: 补按键空位
 *
 *	 public JButton getButton(String roomNum) {} :
 *		功能: 获得面板中的指定按键
 *
 *	 public void setButtonImage(String buttonName, String state) {} :
 *		功能: 设置按键图片
 *	
 *	public void addButton(String name) {} :
 *		制作功能按键，并加入相应的模板中，返回JButton方便主程序加监听
 *
 *  [ 遗留问题    ]  : 
 */
package common.component.swings;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class ViewList extends JPanel {
	
	//放置按键的数组
	private Hashtable buttons = new Hashtable();
	//放置按键的面板
	private JPanel panelMain;
	//ViewList 里面横向按键的个数，和行数
	public static int column	= 8;
	public static int row		= 5;
	
	//面板内按键总数
	public static int buttonTotal = 40;
	//按键记数器
	private int buttonCount = 0;
	
	
	/**构造函数，并制作主面板
	 *参数   ：int buttons 表示ViewList中的按键数量
	 *功能   ：构造函数，并制作主面板
	 */
	public ViewList(int buttons) {
		super(new BorderLayout());
		
		JScrollPane spMain;								//定义滚动面板
		
		//根据按键数据计算面板的行数和列数
		int vRow = buttons / column;
		if(vRow > row) {					//如果有足够的按键数量，则设置面板行数，
			if(buttons % column > 0) {		//否则使用默认行数 row = 5
				row = vRow + 1;
			}else {
				row = vRow;
			}
			buttonTotal = buttons;						//获得按键总数
		}
		
		//建立按键面板
		panelMain	= new JPanel(new GridLayout(row, 1, 5, 15));
//		JLabel panelLable = new JLabel(new ImageIcon("pic/room/p2.jpg"));
//		panelLable.setBounds(2, 2, new ImageIcon("pic/room/p2.jpg").getIconWidth(), new ImageIcon("pic/room/p2.jpg").getIconHeight());
//		panelMain.add(panelLable);
		//设置默认背景色
		panelMain.setBackground(new Color(248, 242, 230));  //new Color(193, 210, 240)
		
		spMain	  = new JScrollPane(panelMain);
		//加入主面板
		this.add("Center", spMain);
	}
	
	/**
	 * 补按键空位
	 *	功能   ：补按键空位，如果按键数量不足 column * row 则加空JLabel补位，
	 *  不然总局会乱	注意，该方法在加完所有按键后使用
	 */
	public void remeButtons() {
		if(buttonCount < buttonTotal) {
			for (int i = 0; i < buttonTotal - buttonCount; i++) {
				JLabel lb = new JLabel("　");
				panelMain.add(lb);				//补空位
		    }
		}
	}
	
	/**		
	 *	参数   ：String roomNum 对象表示按键名字，也就是房间号
	 *	功能   ：获得面板中的指定按键
	 */
	public JButton getButton(String roomNum) {
		return (JButton)buttons.get(roomNum);
	}
	
	/**		
	 *参数   ：String buttonName 对象表示按键在哈希表中的键名
	 *String State 对象表示房间状态
	 *功能   ：设置按键图片
	 */
	public void setButtonImage(String buttonName, String state) {
//		System.out.println(buttonName);
//		System.out.println(state);
		String picName = "";

		if(state.equals("RS01"))      //空房间
			picName = "pic/room/空房.png";
		else if(state.equals("RS02"))       //已预订房间
			picName = "pic/room/已预订.png";
		else if(state.equals("RS03"))        //已入住房间
			picName = "pic/room/已住.png";
		else if(state.equals("RS04"))        //脏房间
			picName = "pic/room/1.jpg";
		else if(state.equals("RS05"))        //需维护时间
			picName = "pic/room/维修.jpg";

		((JButton)buttons.get(buttonName)).setIcon(new ImageIcon(picName));
		
	}
	
	/**
	 *参数   ：String name	表示功能按键的名字
	 *功能   ：制作功能按键，并加入相应的模板中，返回JButton方便主程序加监听
	 */
	public JButton addButton(String name) {
		JButton button = new JButton(name);
		button.setBorderPainted(false);				//设置按键无边框
		button.setContentAreaFilled(false);			//设置按键背景色透明
		button.setHorizontalTextPosition(SwingConstants.CENTER);//设置Ico与文字居中
		button.setVerticalTextPosition(SwingConstants.BOTTOM);//设置Ico相对文字的位置
		panelMain.add(button);		  				//将按键加入按键面板
		buttons.put(name, button);					//将按键存入哈希表
		buttonCount++;								//按键记数器+1
		return button;
	}
}