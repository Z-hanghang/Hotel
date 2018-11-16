
package view.logmain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;





import model.logfrm.login.Login;
import model.mainbackfrm.register.mdlRegister;
import view.mainfrm.mainjiemian.FrmHotelMain;

import vo.mainback.Register;

/**
 *  前台登录入口
 * @author 张航
 */
public class JuiFrontLogin extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form JuiBackLogin
     */
	private String[] geyan={"时间是一切财富中最宝贵的财富。","人生并不像火车要通过每个站似的经过每一个生活阶段。人生总是直向前行走，从不留下什么。",
			"只要我们具有能够改善事物的能力，我们的首要职责就是利用它并训练我们的全部智慧和能力，来为我们人类至高无上的事业服务。",
			"人生并不像火车要通过每个站似的经过每一个生活阶段。人生总是直向前行走，从不留下什么。","当你看到不可理解的现象，感到迷惑时，真理可能已经披着面纱悄悄地站在你的面前。"};
    public JuiFrontLogin() {
        initComponents();
        
        init();
    }

 
    public javax.swing.JTextField getjTextField1() {
		return jTextField1;
	}


	@SuppressWarnings("unchecked")
    private void initComponents() {                          

        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g) {
                ImageIcon icon = new ImageIcon("pic/denglu/黑洞.gif");
                g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);

            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1.setText("EM1002");
        jPasswordField1.setText("123456");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("用户名");
        jLabel1.setForeground(Color.LIGHT_GRAY);
        jLabel1.setIcon(new ImageIcon("pic/denglu/用户.png"));
        
        jLabel3.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel3.setText("  欢迎登录酒店前台管理系统");
        jLabel3.setForeground(Color.LIGHT_GRAY);
        
        jButton1.setText(" 登  录 ");
        jButton1.addActionListener(this);

        jButton2.setText("重置密码");
        jButton2.addActionListener(this);

        jButton3.setText("返回主登录界面");
        jButton3.addActionListener(this);

        jLabel4.setText("密    码");
        jLabel4.setForeground(Color.LIGHT_GRAY);
        jLabel4.setIcon(new ImageIcon("pic/denglu/密码.png"));
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jPasswordField1))
                        .addGap(0, 89, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jButton1) {
            JuiFrontLogin.this.jButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton2) {
            JuiFrontLogin.this.jButton2ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton3) {
            JuiFrontLogin.this.jButton3ActionPerformed(evt);
        }
    }                        
 public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getSource() == jButton1) {
            JuiFrontLogin.this.jButton1KeyPressed(evt);
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       new MainView().setVisible(true);
       this.dispose();
    }                                        
   private int count=0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
          /*
                思路：
        A:获取用户名和密码
        B:正则表达式校验用户名和密码
        C:创建对象调用功能，返回一个boolean值
        D:根据boolean值给出提示
        */
          //获取用户名和密码
		
       
        
        String username = jTextField1.getText().trim();
        String password = jPasswordField1.getText().trim();
        
        
        //用正则表达式做数据校验
        //定义规则
       String usernameRegex = "EM[1-9][0-9]{3}";
		// 密码规则
       String passwordRegex = "[1-9][0-9]{5}";
        
        //校验
       if(!username.matches(usernameRegex)) {
            JOptionPane.showMessageDialog(this, "用户名不满足条件(EM开头加不以0开头的四位数字)");
            jTextField1.setText("");
           jTextField1.requestFocus();
            return;
        }
        
         if(!password.matches(passwordRegex)) {
            JOptionPane.showMessageDialog(this, "密码不满足条件(6个不以0开头的数字)");
            jPasswordField1.setText("");
            jPasswordField1.requestFocus();
            return;
        }
         
         Login log=new Login();
         Register u = log.frontLog(username, password);
        
         //计数器
       
            mdlRegister mdlRegister = new mdlRegister();    //登录更改状态的业务逻辑
		Register vo = new Register();                   // 登录表
          if ((u.getEmployeeId() != null) && (u.getRegisterPassword() != null)) {
        	  FrmHotelMain frmHotelMain =new FrmHotelMain();
			JOptionPane.showMessageDialog(this, "恭喜你登录成功");
			
			frmHotelMain.lbC.setText(u.getEmployeeId() + "  " + u.getEmployeeName() + "  ");
			vo.setEmployeeId(u.getEmployeeId());
			mdlRegister.updateOnLine(vo);
			this.dispose();
			frmHotelMain.setVisible(true);
			/*int a=new Random().nextInt(6);
			tanchuang tool = new tanchuang();
			tool.show(
					" 欢迎使用本系统",
					"欢迎"+username+"\n每日格言： "+geyan[a]
					);
			*/
			

		}else {
              count++;
              JOptionPane.showMessageDialog(this, "用户名或者密码有误");
              jTextField1.setText("");
              jPasswordField1.setText("");
              jTextField1.requestFocus();
              if(count>5){
                  JOptionPane.showMessageDialog(this, "输入错误超过五次，系统自动退出");
                  this.dispose();
                  
              }
              
         }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
               
                 jPasswordField1.setText("");
                 jPasswordField1.requestFocus();
    }               
    //登录按钮键盘监听
   private void jButton1KeyPressed(java.awt.event.KeyEvent evt) { 
   
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){   String username = jTextField1.getText().trim();
        String password = jPasswordField1.getText().trim();
        
        
        //用正则表达式做数据校验
        //定义规则
       String usernameRegex = "EM[1-9][0-9]{3}";
		// 密码规则
       String passwordRegex = "[1-9][0-9]{5}";
        
        //校验
       if(!username.matches(usernameRegex)) {
            JOptionPane.showMessageDialog(this, "用户名不满足条件(EM开头加不以0开头的四位数字)");
            jTextField1.setText("");
           jTextField1.requestFocus();
            return;
        }
        
         if(!password.matches(passwordRegex)) {
            JOptionPane.showMessageDialog(this, "密码不满足条件(6个不以0开头的数字)");
            jPasswordField1.setText("");
            jPasswordField1.requestFocus();
            return;
        }
         
         Login log=new Login();
         Register u = log.frontLog(username, password);
        
         //计数器
       
            mdlRegister mdlRegister = new mdlRegister();    //登录更改状态的业务逻辑
		Register vo = new Register();                   // 登录表
          if ((u.getEmployeeId() != null) && (u.getRegisterPassword() != null)) {
        	  FrmHotelMain frmHotelMain =new FrmHotelMain();
			JOptionPane.showMessageDialog(this, "恭喜你登录成功");
			
			frmHotelMain.lbC.setText(u.getEmployeeId() + "  " + u.getEmployeeName() + "  ");
			vo.setEmployeeId(u.getEmployeeId());
			mdlRegister.updateOnLine(vo);
			this.dispose();
			frmHotelMain.setVisible(true);
			/*int a=new Random().nextInt(6);
			tanchuang tool = new tanchuang();
			tool.show(
					" 欢迎使用本系统",
					"欢迎"+username+"\n每日格言： "+geyan[a]
					);
			*/
			

		}else {
              count++;
              JOptionPane.showMessageDialog(this, "用户名或者密码有误");
              jTextField1.setText("");
              jPasswordField1.setText("");
              jTextField1.requestFocus();
              if(count>5){
                  JOptionPane.showMessageDialog(this, "输入错误超过五次，系统自动退出");
                  this.dispose();
                  
              }
              
         }}
   
   }
    /*
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuiFrontLogin().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   


        
      private void init() {
    	this.setTitle("酒店管理系统V1.0");
    	this.setIconImage(new ImageIcon("pic/backimages/酒店.jpg").getImage()); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    }

