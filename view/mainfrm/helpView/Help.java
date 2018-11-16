package view.mainfrm.helpView;


import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author 张航
 */
public class Help extends javax.swing.JFrame implements ActionListener {

   
    public Help() {
        initComponents();
        init();
    }

   
    @SuppressWarnings("unchecked")
    private void initComponents() {                          

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

      //  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("预  订");
        jButton1.addActionListener(this);

        jButton2.setText("入  住");
        jButton2.addActionListener(this);

        jButton3.setText("顾客管理");
        jButton3.addActionListener(this);

        jButton4.setText("增加消费");
        jButton4.addActionListener(this);

        jButton5.setText("结  算");
        jButton5.addActionListener(this);

        jButton6.setText("菜  单");
        jButton6.addActionListener(this);

        jButton7.setText("快速搜索");
        jButton7.addActionListener(this);

        jButton8.setText("附件功能");
        jButton8.addActionListener(this);
        //jTextPane1.setBackground(Color.cyan);
        jTextPane1.setEditable(false);
         jTextPane1.setText("  \n \n \n                                                点击按钮查询帮助");
         jTextPane1.setFont(new java.awt.Font("微软雅黑 Light", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(29, 29, 29)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jButton1) {
            Help.this.jButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton2) {
            Help.this.jButton2ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton3) {
            Help.this.jButton3ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton4) {
            Help.this.jButton4ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton5) {
            Help.this.jButton5ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton6) {
            Help.this.jButton6ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton7) {
            Help.this.jButton7ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton8) {
            Help.this.jButton8ActionPerformed(evt);
        }
    }                        
//按钮1 预订
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         this.jTextPane1.setText("客户预订：\n" +
"      点击刷新可查找全部预订信息，可在查询对应文本框根据所填信息进行查找，可修改，删除预订信息。可通过选择预订信息进行直接入住。增加按钮则为增加预订信息。\n" +
"增加预订：\n" +
"       根据VIP编号或电话号码进行老顾客信息查找，若为新顾客，直接填写对应信息。选择房间类型，再选择对应的房间号。并选择预抵达时间，从而自动生成保留时间。进行确定或取消操作。");
    }                                        
//按钮4增加消费
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     this.jTextPane1.setText("  \n  可通过点击房间右键或主界面对应button进入，在房间号位置填写房间号，若有房间号显示则不需要填写，点击刷新，刷新房间消费信息。\n  然后图片为放大镜按钮的查找，查找出所有商品，或者可根据商品名进行查找，双击商品名进行增加消费操作。\n  或者选中商品自定义商品数量进行添加。可进行入账或不想购买可选择关闭。");
    }                                        
//按钮5 结算
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      this.jTextPane1.setText("  \n  可通过点击房间右键或主界面对应button进入，根据房间号点击键盘Enter进行房间消费信息查找，若未住则弹窗。\n  应收总额为优惠后总额，可根据情况多收几毛。还应支付为是否有损坏。填写宾客支付点击Enter，显示出退还押金，备注则为损坏的情况。\n  然后进行是否结账操作。");
    }                                        
//按钮2入住
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.jTextPane1.setText("  \n  可通过点击房间右键或主界面对应button或预定界面进入，通过填写VIP编号或者电话号码，查找老顾客信息。\n" +
"  若为新顾客则填写相关信息，选择对应房间进行开单。");
    }                                        
//按钮三 顾客管理
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
          this.jTextPane1.setText("    \n  对顾客信息进行查找，对VIP用户进行管理。");
    }                                        
//按钮六  菜单
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.jTextPane1.setText("   \n  点击房间后右键，如果弹出窗体显示，请重新点击房间类型Table标签。\n  再重新点击对应房间右键菜单，可选择对应房间操作的功能。");
    }                                        
//按钮七 快速搜索
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      this.jTextPane1.setText("  \n\n  不用填写R，直接输入房间号码所对应的数字。");
    }                                        
//按钮八 附件
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.jTextPane1.setText("   \n    计算器：对常规数字进行计算\n" +
"    日历：  只能进行日期，星期几的查看\n" +
"    音乐：通过添加音乐文件进行播放，只可添加wav类型格式文件");
    }                                        
   
      private void init() {
       this.setLocationRelativeTo(null);
    	this.setTitle("帮助");
    	this.setIconImage(new ImageIcon("pic/backimages/酒店.jpg").getImage()); 
        this.setResizable(false);
    }
   
  /*  public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Help().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration                   
}
