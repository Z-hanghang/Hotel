package view.mainfrm.helpView;


import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author �ź�
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

        jButton1.setText("Ԥ  ��");
        jButton1.addActionListener(this);

        jButton2.setText("��  ס");
        jButton2.addActionListener(this);

        jButton3.setText("�˿͹���");
        jButton3.addActionListener(this);

        jButton4.setText("��������");
        jButton4.addActionListener(this);

        jButton5.setText("��  ��");
        jButton5.addActionListener(this);

        jButton6.setText("��  ��");
        jButton6.addActionListener(this);

        jButton7.setText("��������");
        jButton7.addActionListener(this);

        jButton8.setText("��������");
        jButton8.addActionListener(this);
        //jTextPane1.setBackground(Color.cyan);
        jTextPane1.setEditable(false);
         jTextPane1.setText("  \n \n \n                                                �����ť��ѯ����");
         jTextPane1.setFont(new java.awt.Font("΢���ź� Light", 0, 18)); // NOI18N
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
//��ť1 Ԥ��
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         this.jTextPane1.setText("�ͻ�Ԥ����\n" +
"      ���ˢ�¿ɲ���ȫ��Ԥ����Ϣ�����ڲ�ѯ��Ӧ�ı������������Ϣ���в��ң����޸ģ�ɾ��Ԥ����Ϣ����ͨ��ѡ��Ԥ����Ϣ����ֱ����ס�����Ӱ�ť��Ϊ����Ԥ����Ϣ��\n" +
"����Ԥ����\n" +
"       ����VIP��Ż�绰��������Ϲ˿���Ϣ���ң���Ϊ�¹˿ͣ�ֱ����д��Ӧ��Ϣ��ѡ�񷿼����ͣ���ѡ���Ӧ�ķ���š���ѡ��Ԥ�ִ�ʱ�䣬�Ӷ��Զ����ɱ���ʱ�䡣����ȷ����ȡ��������");
    }                                        
//��ť4��������
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     this.jTextPane1.setText("  \n  ��ͨ����������Ҽ����������Ӧbutton���룬�ڷ����λ����д����ţ����з������ʾ����Ҫ��д�����ˢ�£�ˢ�·���������Ϣ��\n  Ȼ��ͼƬΪ�Ŵ󾵰�ť�Ĳ��ң����ҳ�������Ʒ�����߿ɸ�����Ʒ�����в��ң�˫����Ʒ�������������Ѳ�����\n  ����ѡ����Ʒ�Զ�����Ʒ����������ӡ��ɽ������˻��빺���ѡ��رա�");
    }                                        
//��ť5 ����
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      this.jTextPane1.setText("  \n  ��ͨ����������Ҽ����������Ӧbutton���룬���ݷ���ŵ������Enter���з���������Ϣ���ң���δס�򵯴���\n  Ӧ���ܶ�Ϊ�Żݺ��ܶ�ɸ���������ռ�ë����Ӧ֧��Ϊ�Ƿ����𻵡���д����֧�����Enter����ʾ���˻�Ѻ�𣬱�ע��Ϊ�𻵵������\n  Ȼ������Ƿ���˲�����");
    }                                        
//��ť2��ס
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.jTextPane1.setText("  \n  ��ͨ����������Ҽ����������Ӧbutton��Ԥ��������룬ͨ����дVIP��Ż��ߵ绰���룬�����Ϲ˿���Ϣ��\n" +
"  ��Ϊ�¹˿�����д�����Ϣ��ѡ���Ӧ������п�����");
    }                                        
//��ť�� �˿͹���
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
          this.jTextPane1.setText("    \n  �Թ˿���Ϣ���в��ң���VIP�û����й���");
    }                                        
//��ť��  �˵�
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.jTextPane1.setText("   \n  ���������Ҽ����������������ʾ�������µ����������Table��ǩ��\n  �����µ����Ӧ�����Ҽ��˵�����ѡ���Ӧ��������Ĺ��ܡ�");
    }                                        
//��ť�� ��������
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      this.jTextPane1.setText("  \n\n  ������дR��ֱ�����뷿���������Ӧ�����֡�");
    }                                        
//��ť�� ����
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.jTextPane1.setText("   \n    ���������Գ������ֽ��м���\n" +
"    ������  ֻ�ܽ������ڣ����ڼ��Ĳ鿴\n" +
"    ���֣�ͨ����������ļ����в��ţ�ֻ�����wav���͸�ʽ�ļ�");
    }                                        
   
      private void init() {
       this.setLocationRelativeTo(null);
    	this.setTitle("����");
    	this.setIconImage(new ImageIcon("pic/backimages/�Ƶ�.jpg").getImage()); 
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
