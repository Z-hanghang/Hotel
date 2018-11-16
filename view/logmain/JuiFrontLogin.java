
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
 *  ǰ̨��¼���
 * @author �ź�
 */
public class JuiFrontLogin extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form JuiBackLogin
     */
	private String[] geyan={"ʱ����һ�вƸ������ĲƸ���","�����������Ҫͨ��ÿ��վ�Ƶľ���ÿһ������׶Ρ���������ֱ��ǰ���ߣ��Ӳ�����ʲô��",
			"ֻҪ���Ǿ����ܹ�������������������ǵ���Ҫְ�������������ѵ�����ǵ�ȫ���ǻۺ���������Ϊ���������������ϵ���ҵ����",
			"�����������Ҫͨ��ÿ��վ�Ƶľ���ÿһ������׶Ρ���������ֱ��ǰ���ߣ��Ӳ�����ʲô��","���㿴�������������󣬸е��Ի�ʱ����������Ѿ�������ɴ���ĵ�վ�������ǰ��"};
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
                ImageIcon icon = new ImageIcon("pic/denglu/�ڶ�.gif");
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

        jLabel1.setText("�û���");
        jLabel1.setForeground(Color.LIGHT_GRAY);
        jLabel1.setIcon(new ImageIcon("pic/denglu/�û�.png"));
        
        jLabel3.setFont(new java.awt.Font("����", 0, 14)); // NOI18N
        jLabel3.setText("  ��ӭ��¼�Ƶ�ǰ̨����ϵͳ");
        jLabel3.setForeground(Color.LIGHT_GRAY);
        
        jButton1.setText(" ��  ¼ ");
        jButton1.addActionListener(this);

        jButton2.setText("��������");
        jButton2.addActionListener(this);

        jButton3.setText("��������¼����");
        jButton3.addActionListener(this);

        jLabel4.setText("��    ��");
        jLabel4.setForeground(Color.LIGHT_GRAY);
        jLabel4.setIcon(new ImageIcon("pic/denglu/����.png"));
        
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
                ˼·��
        A:��ȡ�û���������
        B:������ʽУ���û���������
        C:����������ù��ܣ�����һ��booleanֵ
        D:����booleanֵ������ʾ
        */
          //��ȡ�û���������
		
       
        
        String username = jTextField1.getText().trim();
        String password = jPasswordField1.getText().trim();
        
        
        //��������ʽ������У��
        //�������
       String usernameRegex = "EM[1-9][0-9]{3}";
		// �������
       String passwordRegex = "[1-9][0-9]{5}";
        
        //У��
       if(!username.matches(usernameRegex)) {
            JOptionPane.showMessageDialog(this, "�û�������������(EM��ͷ�Ӳ���0��ͷ����λ����)");
            jTextField1.setText("");
           jTextField1.requestFocus();
            return;
        }
        
         if(!password.matches(passwordRegex)) {
            JOptionPane.showMessageDialog(this, "���벻��������(6������0��ͷ������)");
            jPasswordField1.setText("");
            jPasswordField1.requestFocus();
            return;
        }
         
         Login log=new Login();
         Register u = log.frontLog(username, password);
        
         //������
       
            mdlRegister mdlRegister = new mdlRegister();    //��¼����״̬��ҵ���߼�
		Register vo = new Register();                   // ��¼��
          if ((u.getEmployeeId() != null) && (u.getRegisterPassword() != null)) {
        	  FrmHotelMain frmHotelMain =new FrmHotelMain();
			JOptionPane.showMessageDialog(this, "��ϲ���¼�ɹ�");
			
			frmHotelMain.lbC.setText(u.getEmployeeId() + "  " + u.getEmployeeName() + "  ");
			vo.setEmployeeId(u.getEmployeeId());
			mdlRegister.updateOnLine(vo);
			this.dispose();
			frmHotelMain.setVisible(true);
			/*int a=new Random().nextInt(6);
			tanchuang tool = new tanchuang();
			tool.show(
					" ��ӭʹ�ñ�ϵͳ",
					"��ӭ"+username+"\nÿ�ո��ԣ� "+geyan[a]
					);
			*/
			

		}else {
              count++;
              JOptionPane.showMessageDialog(this, "�û���������������");
              jTextField1.setText("");
              jPasswordField1.setText("");
              jTextField1.requestFocus();
              if(count>5){
                  JOptionPane.showMessageDialog(this, "������󳬹���Σ�ϵͳ�Զ��˳�");
                  this.dispose();
                  
              }
              
         }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
               
                 jPasswordField1.setText("");
                 jPasswordField1.requestFocus();
    }               
    //��¼��ť���̼���
   private void jButton1KeyPressed(java.awt.event.KeyEvent evt) { 
   
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){   String username = jTextField1.getText().trim();
        String password = jPasswordField1.getText().trim();
        
        
        //��������ʽ������У��
        //�������
       String usernameRegex = "EM[1-9][0-9]{3}";
		// �������
       String passwordRegex = "[1-9][0-9]{5}";
        
        //У��
       if(!username.matches(usernameRegex)) {
            JOptionPane.showMessageDialog(this, "�û�������������(EM��ͷ�Ӳ���0��ͷ����λ����)");
            jTextField1.setText("");
           jTextField1.requestFocus();
            return;
        }
        
         if(!password.matches(passwordRegex)) {
            JOptionPane.showMessageDialog(this, "���벻��������(6������0��ͷ������)");
            jPasswordField1.setText("");
            jPasswordField1.requestFocus();
            return;
        }
         
         Login log=new Login();
         Register u = log.frontLog(username, password);
        
         //������
       
            mdlRegister mdlRegister = new mdlRegister();    //��¼����״̬��ҵ���߼�
		Register vo = new Register();                   // ��¼��
          if ((u.getEmployeeId() != null) && (u.getRegisterPassword() != null)) {
        	  FrmHotelMain frmHotelMain =new FrmHotelMain();
			JOptionPane.showMessageDialog(this, "��ϲ���¼�ɹ�");
			
			frmHotelMain.lbC.setText(u.getEmployeeId() + "  " + u.getEmployeeName() + "  ");
			vo.setEmployeeId(u.getEmployeeId());
			mdlRegister.updateOnLine(vo);
			this.dispose();
			frmHotelMain.setVisible(true);
			/*int a=new Random().nextInt(6);
			tanchuang tool = new tanchuang();
			tool.show(
					" ��ӭʹ�ñ�ϵͳ",
					"��ӭ"+username+"\nÿ�ո��ԣ� "+geyan[a]
					);
			*/
			

		}else {
              count++;
              JOptionPane.showMessageDialog(this, "�û���������������");
              jTextField1.setText("");
              jPasswordField1.setText("");
              jTextField1.requestFocus();
              if(count>5){
                  JOptionPane.showMessageDialog(this, "������󳬹���Σ�ϵͳ�Զ��˳�");
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
    	this.setTitle("�Ƶ����ϵͳV1.0");
    	this.setIconImage(new ImageIcon("pic/backimages/�Ƶ�.jpg").getImage()); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    }

