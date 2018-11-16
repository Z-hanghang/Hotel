package view.mainfrm.common;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * 音乐播放器
 * @author 张航
 * 
 * **/

public class Mp3 extends JFrame {

	private JPanel contentPane;
	File file;// 声明文件对象
	String filename;
	JFileChooser chooser = new JFileChooser();// 创建一个文件选择器
	private JTextField xiaoxi;
	boolean loop = false;
	AudioClip adc;// 声音音频剪辑对象
	SourceDataLine line;
	private FloatControl volume = null;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mp3 frame = new Mp3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public Mp3() {
		this.setIconImage(new ImageIcon("pic/Music/音乐.png").getImage());
		setTitle("迷你音乐播放器");
		this.setBackground(Color.blue);
		
		this.setSize(270, 290);
		this.setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu(" ");
		mnNewMenu.setIcon(new ImageIcon("pic/Music/菜单.png"));
		menuBar.add(mnNewMenu);
		xiaoxi = new JTextField();
		xiaoxi.setColumns(10);
		xiaoxi.setText("欢迎使用本播放器,请选择音乐后播放");
		xiaoxi.setBackground(Color.cyan);
		JMenuItem dakai = new JMenuItem("\u6253\u5F00");
		dakai.setIcon(new ImageIcon("pic/Music/打开文件.png"));
		dakai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = chooser.showOpenDialog(chooser);// 接受文件选择器的状态
				if (value == chooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();// 返回选中文件
					filename = file.getName();
					String flag = filename;
					xiaoxi.setText(flag);
					try {
						if (adc != null)
							adc.stop();
						URL url = new URL("file:" + file.getPath());// 创建资源定位
						adc = Applet.newAudioClip(url);
						// adc.play();

					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("不能播放！");
					}
				}
			}
		});
		mnNewMenu.add(dakai);

		JMenuItem tuichu = new JMenuItem("\u9000\u51FA");
		tuichu.setIcon(new ImageIcon("pic/Music/退出.png"));
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				if (adc != null)
					adc.stop();
				return;
			}
		});

		mnNewMenu.add(tuichu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton playbtn = new JButton();//"\u64AD\u653E"
		playbtn.setIcon(new ImageIcon("pic/Music/播放.png"));
		playbtn.setHorizontalAlignment(SwingConstants.LEFT);
		playbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String flag = "正在播放：" + filename;
				if (adc == null) {
					flag = "请选择播放的音乐";
					xiaoxi.setText(flag);
					return;
				}
				adc.play();
				xiaoxi.setText(flag);
			}
		});

		JButton stopbtn = new JButton();//"\u6682\u505C"
		stopbtn.setIcon(new ImageIcon("pic/Music/暂停.png"));
		stopbtn.setHorizontalAlignment(SwingConstants.LEFT);
		stopbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (adc == null) {
					String flag = "请选择播放的音乐";
					xiaoxi.setText(flag);
					return;
				}
				adc.stop();
				String flag = "停止播放音乐:" + filename;
				xiaoxi.setText(flag);
				
			}
		});

		JButton againbtn = new JButton();//"\u5FAA\u73AF"
		againbtn.setIcon(new ImageIcon("pic/Music/循环播放.png"));
		againbtn.setHorizontalAlignment(SwingConstants.LEFT);
		againbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adc == null) {
					String flag = "请选择播放的音乐";
					xiaoxi.setText(flag);
					return;
				}else {
					
				
				loop = !loop;
				String flag = "";
				;
				if (loop) {
					adc.play();
					adc.loop();// 循环播放
					flag = "循环播放:" + filename;
				} else {
					adc.play();
					flag = "顺序播放" + filename;
				}
				xiaoxi.setText(flag);
			}
			}});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING, false).addComponent(xiaoxi, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(playbtn, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(stopbtn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(againbtn, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(15, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(xiaoxi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addPreferredGap(ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(playbtn)
						.addComponent(stopbtn).addComponent(againbtn))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

}
