/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.logmain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import common.backpifu.pifu.MyLookAndFeel;
import control.mainback.lsnBackMainView.lsncaidan.LsnrBackCaiDan;
import java.awt.event.KeyEvent;
import model.logfrm.login.Login;
import view.backmain.BackMainView.BackMainView;
import vo.mainback.Manager;

/**
 *  主登录入口
 * @author 张航
 */
public class JuiBackLogin extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form JuiBackLogin
     */
    public JuiBackLogin() {
        initComponents();
       /* try {
			UIManager.setLookAndFeel(MyLookAndFeel.LIQUIDINF);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
        init();
    }

    private String[] geyan={"时间是一切财富中最宝贵的财富。","人生并不像火车要通过每个站似的经过每一个生活阶段。人生总是直向前行走，从不留下什么。",
			"只要我们具有能够改善事物的能力，我们的首要职责就是利用它并训练我们的全部智慧和能力，来为我们人类至高无上的事业服务。",
			"人生并不像火车要通过每个站似的经过每一个生活阶段。人生总是直向前行走，从不留下什么。","当你看到不可理解的现象，感到迷惑时，真理可能已经披着面纱悄悄地站在你的面前。"};
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
        jTextField1.setText("ME1002");
        jPasswordField1.setText("123456");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("用户名");
        jLabel1.setForeground(Color.LIGHT_GRAY);
        jLabel1.setIcon(new ImageIcon("pic/denglu/用户.png"));
        
        jLabel2.setText("密  码");
        jLabel2.setForeground(Color.LIGHT_GRAY);
        jLabel2.setIcon(new ImageIcon("pic/denglu/密码.png"));
        
        jLabel3.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel3.setText("    欢迎登录酒店后台管理系统");
        jLabel3.setForeground(Color.LIGHT_GRAY);
        jButton1.setText("登 录");
        jButton1.addActionListener(this);
        //jButton1.setIcon(new ImageIcon("pic/denglu/登录.png"));
        
        jButton2.setText("重置密码");
        jButton2.addActionListener(this);
      //  jButton2.setIcon(new ImageIcon("pic/denglu/重置.png"));
        
        jButton3.setText("返回主登录界面");
        jButton3.addActionListener(this);
       // jButton3.setIcon(new ImageIcon("pic/denglu/返回.png"));
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 94, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(31, 31, 31))))
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
            JuiBackLogin.this.jButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton2) {
            JuiBackLogin.this.jButton2ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton3) {
            JuiBackLogin.this.jButton3ActionPerformed(evt);
        }
    }                        
 public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getSource() == jButton1) {
            JuiBackLogin.this.jButton1KeyPressed(evt);
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
        //用户名规则
        String usernameRegex = "ME[1-9][0-9]{3}";
        //密码规则
        String passwordRegex = "[1-9][0-9]{5}";
        
        //校验
        if(!username.matches(usernameRegex)) {
            JOptionPane.showMessageDialog(this, "用户名不满足条件(ME开头加不以0开头的四位数字)");
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
         Manager manager=log.backLog(username, password);
        
         //计数器
       
     
          if((manager.getManagerId() != null) && (manager.getManagerPwd() != null)){
             
        	  BackMainView bw=new BackMainView();
        	  bw.getjUserName().setText("当前用户： "+manager.getManagerName());
        	  JOptionPane.showMessageDialog(this, "恭喜你登录成功");
                   this.dispose();
                   bw.setVisible(true);
                 
  
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
 //登录按钮键盘监听
   private void jButton1KeyPressed(java.awt.event.KeyEvent evt) { 
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
         
        String username = jTextField1.getText().trim();
        String password = jPasswordField1.getText().trim();
        
        
        //用正则表达式做数据校验
        //定义规则
        //用户名规则
        String usernameRegex = "ME[1-9][0-9]{3}";
        //密码规则
        String passwordRegex = "[1-9][0-9]{5}";
        
        //校验
        if(!username.matches(usernameRegex)) {
            JOptionPane.showMessageDialog(this, "用户名不满足条件(ME开头加不以0开头的四位数字)");
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
         Manager manager=log.backLog(username, password);
        
         //计数器
       
     
          if((manager.getManagerId() != null) && (manager.getManagerPwd() != null)){
        	  BackMainView bw=new BackMainView();
        	  bw.getjUserName().setText("当前用户： "+manager.getManagerName());
        	  JOptionPane.showMessageDialog(this, "恭喜你登录成功");
                   this.dispose();
                 bw.setVisible(true);
        	  int a=new Random().nextInt(5);
  		
  	         new tanchuang().show(
  					" 欢迎使用本系统",
  					"欢迎"+username
  					);
        	
              
             
  
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
   }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
               
                 jPasswordField1.setText("");
                 jPasswordField1.requestFocus();
    }                                        

    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JuiBackLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuiBackLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuiBackLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuiBackLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuiBackLogin().setVisible(true);
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
