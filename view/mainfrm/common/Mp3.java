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
 * ���ֲ�����
 * @author �ź�
 * 
 * **/

public class Mp3 extends JFrame {

	private JPanel contentPane;
	File file;// �����ļ�����
	String filename;
	JFileChooser chooser = new JFileChooser();// ����һ���ļ�ѡ����
	private JTextField xiaoxi;
	boolean loop = false;
	AudioClip adc;// ������Ƶ��������
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
		this.setIconImage(new ImageIcon("pic/Music/����.png").getImage());
		setTitle("�������ֲ�����");
		this.setBackground(Color.blue);
		
		this.setSize(270, 290);
		this.setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu(" ");
		mnNewMenu.setIcon(new ImageIcon("pic/Music/�˵�.png"));
		menuBar.add(mnNewMenu);
		xiaoxi = new JTextField();
		xiaoxi.setColumns(10);
		xiaoxi.setText("��ӭʹ�ñ�������,��ѡ�����ֺ󲥷�");
		xiaoxi.setBackground(Color.cyan);
		JMenuItem dakai = new JMenuItem("\u6253\u5F00");
		dakai.setIcon(new ImageIcon("pic/Music/���ļ�.png"));
		dakai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = chooser.showOpenDialog(chooser);// �����ļ�ѡ������״̬
				if (value == chooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();// ����ѡ���ļ�
					filename = file.getName();
					String flag = filename;
					xiaoxi.setText(flag);
					try {
						if (adc != null)
							adc.stop();
						URL url = new URL("file:" + file.getPath());// ������Դ��λ
						adc = Applet.newAudioClip(url);
						// adc.play();

					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("���ܲ��ţ�");
					}
				}
			}
		});
		mnNewMenu.add(dakai);

		JMenuItem tuichu = new JMenuItem("\u9000\u51FA");
		tuichu.setIcon(new ImageIcon("pic/Music/�˳�.png"));
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
		playbtn.setIcon(new ImageIcon("pic/Music/����.png"));
		playbtn.setHorizontalAlignment(SwingConstants.LEFT);
		playbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String flag = "���ڲ��ţ�" + filename;
				if (adc == null) {
					flag = "��ѡ�񲥷ŵ�����";
					xiaoxi.setText(flag);
					return;
				}
				adc.play();
				xiaoxi.setText(flag);
			}
		});

		JButton stopbtn = new JButton();//"\u6682\u505C"
		stopbtn.setIcon(new ImageIcon("pic/Music/��ͣ.png"));
		stopbtn.setHorizontalAlignment(SwingConstants.LEFT);
		stopbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (adc == null) {
					String flag = "��ѡ�񲥷ŵ�����";
					xiaoxi.setText(flag);
					return;
				}
				adc.stop();
				String flag = "ֹͣ��������:" + filename;
				xiaoxi.setText(flag);
				
			}
		});

		JButton againbtn = new JButton();//"\u5FAA\u73AF"
		againbtn.setIcon(new ImageIcon("pic/Music/ѭ������.png"));
		againbtn.setHorizontalAlignment(SwingConstants.LEFT);
		againbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adc == null) {
					String flag = "��ѡ�񲥷ŵ�����";
					xiaoxi.setText(flag);
					return;
				}else {
					
				
				loop = !loop;
				String flag = "";
				;
				if (loop) {
					adc.play();
					adc.loop();// ѭ������
					flag = "ѭ������:" + filename;
				} else {
					adc.play();
					flag = "˳�򲥷�" + filename;
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
