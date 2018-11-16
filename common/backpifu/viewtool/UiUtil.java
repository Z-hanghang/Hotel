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

/**界面工具类
 * 专门做界面效果的类
 *
 * @author Administrator
 */
public class UiUtil {

   
    //修改窗体的图标
    public static void setFrameImage(JFrame jf) {
        //获取工具类对象
        //public static Toolkit getDefaultToolkit():获取默认工具包。 
        Toolkit tk = Toolkit.getDefaultToolkit();

        //根据路径获取图片
        Image i = tk.getImage("src\\cn\\itcast\\resource\\user.jpg");

        //给窗体设置图片
        jf.setIconImage(i);
    }
    
        public static void setFrameImage(JFrame jf,String imageName) {
        //获取工具类对象
        //public static Toolkit getDefaultToolkit():获取默认工具包。 
        Toolkit tk = Toolkit.getDefaultToolkit();

        //根据路径获取图片
        Image i = tk.getImage("src\\cn\\itcast\\resource\\"+imageName);

        //给窗体设置图片
        jf.setIconImage(i);
    }

    
  
    
}
