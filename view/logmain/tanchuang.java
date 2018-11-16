package view.logmain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JDialog;

/**
 * @author Administrator
 *	�˹������÷���ʵ���������󣬵��� void show("����","����") ����.
 *	InfoUtil tool = new InfoUtil();
 *	tool.show("����","����")
 */
public class tanchuang {
	private Point oldP;										// ��һ������,�϶�����ʱ��
	private TipWindow tw = null;							// ��ʾ��
	private ImageIcon img = null;							// ͼ�����
	private JLabel imgLabel = null; 						// ����ͼƬ��ǩ
	private JPanel headPan = null;
	private JPanel feaPan = null;
	private JPanel btnPan = null;
	private JLabel title = null;							// ��Ŀ����
	private JLabel head = null;								// ��ɫ����
	private JLabel close = null;							// �رհ�ť
	private JTextArea feature = null;						// ����
	private JScrollPane jfeaPan = null;
	private JLabel releaseLabel = null;						//����ʱ��
	private JLabel sure = null;
	private String titleT = null;
	private String word = null;
	private String time = null;
	private SimpleDateFormat sdf = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void init() {
		// �½�300x220����Ϣ��ʾ��
		tw = new TipWindow(300, 220);
		img = new ImageIcon("image/ǳ��ɫ.jpg");
		imgLabel = new JLabel(img);
		// ���ø������Ĳ����Լ�����пؼ��ı߽�
		headPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		feaPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		btnPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		title = new JLabel("��ӭʹ�ñ�ϵͳ");
		head = new JLabel(titleT);
		close = new JLabel(" x");
		feature = new JTextArea(word);
		jfeaPan = new JScrollPane(feature);
		releaseLabel = new JLabel("��ǰʱ�䣺" + time);
		sure = new JLabel("ȷ��");
		sure.setHorizontalAlignment(SwingConstants.CENTER);

		// �������������Ϊ͸�������򿴲�������ͼƬ
		((JPanel) tw.getContentPane()).setOpaque(false);
		headPan.setOpaque(false);
		feaPan.setOpaque(false);
		btnPan.setOpaque(false);

		// ����JDialog����������ͼƬ
		tw.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		headPan.setPreferredSize(new Dimension(300, 60));

		// ������ʾ��ı߿�,��Ⱥ���ɫ
		tw.getRootPane().setBorder(
				BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		title.setPreferredSize(new Dimension(260, 26));
		title.setVerticalTextPosition(JLabel.CENTER);
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setFont(new Font("����", Font.PLAIN, 12));
		title.setForeground(Color.black);

		close.setFont(new Font("Arial", Font.BOLD, 15));
		close.setPreferredSize(new Dimension(20, 20));
		close.setVerticalTextPosition(JLabel.CENTER);
		close.setHorizontalTextPosition(JLabel.CENTER);
		close.setCursor(new Cursor(12));
		close.setToolTipText("�ر�");

		head.setPreferredSize(new Dimension(250, 35));
		head.setVerticalTextPosition(JLabel.CENTER);
		head.setHorizontalTextPosition(JLabel.CENTER);
		head.setFont(new Font("����", Font.PLAIN, 12));
		head.setForeground(Color.blue);

		feature.setEditable(false);
		feature.setForeground(Color.red);
		feature.setFont(new Font("����", Font.PLAIN, 13));
		feature.setBackground(new Color(184, 230, 172));
		// �����ı����Զ�����
		feature.setLineWrap(true);

		jfeaPan.setPreferredSize(new Dimension(250, 80));
		jfeaPan.setBorder(null);
		jfeaPan.setBackground(Color.DARK_GRAY);

		releaseLabel.setForeground(Color.DARK_GRAY);
		releaseLabel.setFont(new Font("����", Font.PLAIN, 12));

		// Ϊ�������ı��򣬼Ӹ��յ�JLabel������������ȥ
		JLabel jsp = new JLabel();
		jsp.setPreferredSize(new Dimension(300, 25));

		sure.setPreferredSize(new Dimension(110, 30));
		// ���ñ�ǩ�������
		sure.setCursor(new Cursor(12));

		headPan.add(title);
		headPan.add(close);
		headPan.add(head);

		feaPan.add(jsp);
		feaPan.add(jfeaPan);
		feaPan.add(releaseLabel);

		btnPan.add(sure);

		tw.add(headPan, BorderLayout.NORTH);
		tw.add(feaPan, BorderLayout.CENTER);
		tw.add(btnPan, BorderLayout.SOUTH);
	}

	public void handle() {
		// Ϊ���°�ť������Ӧ���¼�
		sure.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(tw, "лл���ټ�");
				tw.close();
			}
			public void mouseEntered(MouseEvent e) {
				sure.setBorder(BorderFactory.createLineBorder(Color.gray));
			}
			public void mouseExited(MouseEvent e) {
				sure.setBorder(null);
			}
		});
		// ��������϶��¼�
		title.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				Point newP = new Point(e.getXOnScreen(), e.getYOnScreen());
				int x = tw.getX() + (newP.x - oldP.x);
				int y = tw.getY() + (newP.y - oldP.y);
				tw.setLocation(x, y);
				oldP = newP;
			}
		});
		// ��갴��ʱ��ʼ����,���϶�ʱ������
		title.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				oldP = new Point(e.getXOnScreen(), e.getYOnScreen());
			}
		});
		// ���Ͻǹرհ�ť�¼�
		close.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tw.close();
			}
			public void mouseEntered(MouseEvent e) {
				close.setBorder(BorderFactory.createLineBorder(Color.gray));
			}
			public void mouseExited(MouseEvent e) {
				close.setBorder(null);
			}
		});
	}
	
	public void show(String titleT,String word){
		this.titleT = titleT;
		this.word = word;
		time = sdf.format(new Date());
		init();
		handle();
		tw.setAlwaysOnTop(true);
		tw.setUndecorated(true);
		tw.setResizable(false);
		tw.setVisible(true);
		tw.run();
	}





	public static void main(String args[]){
		tanchuang tool = new tanchuang();
		tool.show(
				" ��ӭʹ�ñ�ϵͳ",
				""
				);
	}
}
 
