package view.mainfrm.common;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class JiSuanQi extends JDialog implements ActionListener {

	private JTextField txtResult;
	private JButton btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnPlus,
			btnMinus, btnTimes, btnDivided, btnEqual, btnPoint, btnC, btnCE, btnSqrt, btnPlusMinus;
	int z;
	double x, y;
	StringBuffer str;

	public JiSuanQi(JDialog ower, String title, boolean modal, String command) {
		super(ower, title, modal);
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		// this.setSize(311, 231);
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setIconImage(new ImageIcon("pic/backimages/计算器.png").getImage());
		this.setLayout(new GridLayout(1, 1));// 网格布局
		JPanel panel = new JPanel(new GridLayout(6, 1));// 面板 网格布局6行1列
		this.add(panel);

		txtResult = new JTextField("0");
		Color BackColor = new Color(255, 255, 255);
		Color ForeColor = new Color(0, 0, 0);
		txtResult.setBackground(BackColor);
		txtResult.setForeground(ForeColor);

		panel.add(txtResult);
		txtResult.setHorizontalAlignment(JTextField.RIGHT);
		txtResult.setEnabled(false);
		// text.setEnabled(true);

		JPanel panel_1 = new JPanel(new GridLayout(1, 4));
		panel.add(panel_1);

		btnSqrt = new JButton("sqrt");

		panel_1.add(btnSqrt);
		btnSqrt.addActionListener(this);
		btnPlusMinus = new JButton("+/-");
		panel_1.add(btnPlusMinus);
		btnPlusMinus.addActionListener(this);
		btnCE = new JButton("CE");
		panel_1.add(btnCE);
		btnCE.addActionListener(this);
		btnC = new JButton("C");
		panel_1.add(btnC);
		btnC.addActionListener(this);

		JPanel panel_2 = new JPanel(new GridLayout(1, 4));
		panel.add(panel_2);

		btnSeven = new JButton("7");
		panel_2.add(btnSeven);
		btnSeven.addActionListener(this);
		btnEight = new JButton("8");
		panel_2.add(btnEight);
		btnEight.addActionListener(this);
		btnNine = new JButton("9");
		panel_2.add(btnNine);
		btnNine.addActionListener(this);
		btnDivided = new JButton("/");
		panel_2.add(btnDivided);
		btnDivided.addActionListener(this);

		JPanel panel_3 = new JPanel(new GridLayout(1, 4));
		panel.add(panel_3);

		btnFour = new JButton("4");
		panel_3.add(btnFour);
		btnFour.addActionListener(this);
		btnFive = new JButton("5");
		panel_3.add(btnFive);
		btnFive.addActionListener(this);
		btnSix = new JButton("6");
		panel_3.add(btnSix);
		btnSix.addActionListener(this);
		btnTimes = new JButton("*");
		panel_3.add(btnTimes);
		btnTimes.addActionListener(this);

		JPanel panel_4 = new JPanel(new GridLayout(1, 4));
		panel.add(panel_4);

		btnOne = new JButton("1");
		panel_4.add(btnOne);
		btnOne.addActionListener(this);
		btnTwo = new JButton("2");
		panel_4.add(btnTwo);
		btnTwo.addActionListener(this);
		btnThree = new JButton("3");
		panel_4.add(btnThree);
		btnThree.addActionListener(this);
		btnMinus = new JButton("-");
		panel_4.add(btnMinus);
		btnMinus.addActionListener(this);

		JPanel panel_5 = new JPanel(new GridLayout(1, 4));
		panel.add(panel_5);

		btnZero = new JButton("0");
		panel_5.add(btnZero);
		btnZero.addActionListener(this);
		btnPoint = new JButton(".");
		panel_5.add(btnPoint);
		btnPoint.addActionListener(this);
		btnEqual = new JButton("=");
		panel_5.add(btnEqual);
		btnEqual.addActionListener(this);
		btnPlus = new JButton("+");
		panel_5.add(btnPlus);
		btnPlus.addActionListener(this);

		str = new StringBuffer();

	}

//	public void windowClosing(WindowEvent a) {
//		this.setVisible(false);
//	}

	public void actionPerformed(ActionEvent e) {

		try {
			if (e.getSource() == btnC) {
				txtResult.setText("0");
				str.setLength(0);
			} else if (e.getSource() == btnCE) {
				txtResult.setText("0.");
				str.setLength(0);
			} else if (e.getSource() == btnPlusMinus) {
				x = Double.parseDouble(txtResult.getText().trim());
				txtResult.setText("" + (-x));
			}

			else if (e.getSource() == btnPlus) {
				x = Double.parseDouble(txtResult.getText().trim());
				str.setLength(0);
				y = 0d;
				z = 1;
			} else if (e.getSource() == btnMinus) {
				x = Double.parseDouble(txtResult.getText().trim());
				str.setLength(0);
				y = 0d;
				z = 2;
			} else if (e.getSource() == btnTimes) {
				x = Double.parseDouble(txtResult.getText().trim());
				str.setLength(0);
				y = 0d;
				z = 3;
			} else if (e.getSource() == btnDivided) {
				x = Double.parseDouble(txtResult.getText().trim());
				str.setLength(0);
				y = 0d;
				z = 4;
			} else if (e.getSource() == btnEqual) {
				str.setLength(0);
				switch (z) {
				case 1:
					txtResult.setText("" + (x + y));
					break;
				case 2:
					txtResult.setText("" + (x - y));
					break;
				case 3:
					txtResult.setText("" + (x * y));
					break;
				case 4:
					txtResult.setText("" + (x / y));
					break;
				}
			}

			else if (e.getSource() == btnPoint) {
				if (txtResult.getText().trim().indexOf('.') != -1)// 判断字符串中是否已经包含了小数点
				{

				} else// 如果没数点有小
				{
					if (txtResult.getText().trim().equals("0"))// 如果初时显示为0
					{
						str.setLength(0);
						txtResult.setText((str.append("0" + e.getActionCommand())).toString());
					} else if (txtResult.getText().trim().equals(""))// 如果初时显示为空则不做任何操作
					{
					} else {
						txtResult.setText(str.append(e.getActionCommand()).toString());
					}
				}

				y = 0d;
			}

			else if (e.getSource() == btnSqrt)// 求平方根
			{
				x = Double.parseDouble(txtResult.getText().trim());
				txtResult.setText("数字格式异常");
				if (x < 0)
					txtResult.setText("负数没有平方根");
				else
					txtResult.setText("" + Math.sqrt(x));
				str.setLength(0);
				y = 0d;
			}

			else if (e.getSource() == btnZero)// 如果选择的是"0"这个数字键
			{
				if (txtResult.getText().trim().equals("0"))// 如果显示屏显示的为零不做操作
				{
				} else {
					txtResult.setText(str.append(e.getActionCommand()).toString());
					y = Double.parseDouble(txtResult.getText().trim());
				}
			}

			else// 其他的数字键
			{
				txtResult.setText(str.append(e.getActionCommand()).toString());
				y = Double.parseDouble(txtResult.getText().trim());
			}
		} catch (NumberFormatException ae) {
			txtResult.setText("数字格式异常");
		} catch (StringIndexOutOfBoundsException ae) {
			txtResult.setText("字符串索引越界");
		}

	}
//	public static void main(String arg[]) {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		new JiSuanQi();
//	}
}
