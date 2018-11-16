package common.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBManager {
  public static Connection getConnection() {
    FileInputStream fis = null;
    Properties pro = new Properties();
    Connection conn = null;
    
    try {
      fis = new FileInputStream("配置文件/db.properties");
      pro.load(fis);
      
      String driver = pro.getProperty("driver");
      String url = pro.getProperty("url");
      String user = pro.getProperty("user");
      String password = pro.getProperty("password");
      // 加载并注册驱动
      Class.forName(driver);
      // 获取连接对象
      conn = DriverManager.getConnection(url, user, password);
      // System.out.println(pro.getProperty("driver"));
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return conn;
  }
  
  public static void free(Connection conn, Statement st, ResultSet rs) {
    free(rs);
    free(conn, st);
  }
  
  public static void free(Connection conn, Statement st) {
    free(st);
    free(conn);
  }
  
  public static void free(Connection conn) {
    if(conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
  
  public static void free(Statement st) {
    if(st != null) {
      try {
        st.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
  
  public static void free(ResultSet rs) {
    if(rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  } 

 /* public static void main(String[] args) {
    getConnection();
  }*/
}
