package common.jdbc;

/**
 *释放流方法
 * @author 张航
 * @2018.10.15
 */
import java.io.Closeable;
import java.io.IOException;
public class ReleaseIo {
 public static void free(Closeable...stream){
     for(Closeable st:stream){
         if(st != null){
             try {
                st.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         }
     }
     
 }
}
