package common.backpifu.viewtool;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**���湤����
 * ר��������Ч������
 *
 * @author Administrator
 */
public class UiUtil {

   
    //�޸Ĵ����ͼ��
    public static void setFrameImage(JFrame jf) {
        //��ȡ���������
        //public static Toolkit getDefaultToolkit():��ȡĬ�Ϲ��߰��� 
        Toolkit tk = Toolkit.getDefaultToolkit();

        //����·����ȡͼƬ
        Image i = tk.getImage("src\\cn\\itcast\\resource\\user.jpg");

        //����������ͼƬ
        jf.setIconImage(i);
    }
    
        public static void setFrameImage(JFrame jf,String imageName) {
        //��ȡ���������
        //public static Toolkit getDefaultToolkit():��ȡĬ�Ϲ��߰��� 
        Toolkit tk = Toolkit.getDefaultToolkit();

        //����·����ȡͼƬ
        Image i = tk.getImage("src\\cn\\itcast\\resource\\"+imageName);

        //����������ͼƬ
        jf.setIconImage(i);
    }

    
  
    
}
