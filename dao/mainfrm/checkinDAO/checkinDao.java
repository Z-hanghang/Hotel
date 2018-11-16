package dao.mainfrm.checkinDAO;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import common.jdbc.DBManager;
import vo.mainfrm.ruzhucha.checkinvo.checkinVO;

public class checkinDao {
	public  Vector<Vector> findnewsByfangjianhao(checkinVO vo) {//通过房间号查找房间信息
	    Vector<Vector> resultVector = new Vector<Vector>();
	    
	    StringBuilder sql = new StringBuilder("select Reside_id,Customer_name,"
	    		+ "Member_name,Room_id,Roomtype_name,Reside_number,Deposit,"
	    		+ "Reside_rtime,Reside_ltime,Checkout_state,Employee_name "
	    		+ "from reside re,Customer c,Member m,Roomtype ro,Employee e "
	    		+ "where re.Customer_id = c.Customer_id and re.Member_id = m.Member_id "
	    		+ "and re.Roomtype_id = ro.Roomtype_id and re.Employee_id = e.Employee_id ");
	    
	    String fangjianhao = vo.getfangjianhao(); 
	    String gukeming=vo.getgukeming();
	    
	    if (fangjianhao != null && !fangjianhao.equals("")) {//查找房间号对应的房间信息
	    	if(gukeming != null && gukeming.equals("")){
	    		sql.append("and Room_id like '%" + fangjianhao + "%'");//访问数据库	    		
	    	}
	    }
	    if(gukeming !=null && !gukeming.equals("")){//查找顾客名对应的房间信息
	    	if(fangjianhao != null && fangjianhao.equals("")){
	    		sql.append( "and re.Customer_id in(" +
	    				"select cus.Customer_id " +
	    				"from Customer cus " +
	    				"where cus.Customer_name like '%"+gukeming+"%')");//访问数据库 	    		
	    	}
	    }
	    if(fangjianhao != null && !fangjianhao.equals("")){//如果查找对应的房间号以及顾客名所对应的房间信息
	    	if(gukeming != null && !gukeming.equals("")){
	    		sql.append("and Room_id like '%" + fangjianhao + "%' and re.Customer_id in(" +
	    			"select cus.Customer_id " +
	    			"from Customer cus " +
	    			"where cus.Customer_name like '%"+gukeming+"%')");
	    	}
	    }
	    
	    Connection conn = DBManager.getConnection();
	    Statement st = null;
	    ResultSet rs = null;

	    try {
	      st = conn.createStatement();
	      rs = st.executeQuery(sql.toString());
	      while (rs.next()) {
	        Vector v = new Vector();
	        v.add(rs.getString(1));
	        v.add(rs.getString(2));
	        v.add(rs.getString(3));
	        v.add(rs.getString(4));
	        v.add(rs.getString(5));
	        v.add(rs.getString(6));
	        v.add(rs.getString(7));
	        v.add(rs.getString(8));
	        v.add(rs.getString(9));
	        v.add(rs.getString(10));
	        v.add(rs.getString(11));
	        resultVector.add(v);
	      }
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } finally {
	      DBManager.free(conn, st, rs);
	    }
	    return resultVector;
	  }
	 		
	   
	
	  public Vector<Vector> findAllnews(checkinVO vo) {//查找所有
	    Vector<Vector> resultVector = new Vector<Vector>();

	    String sql = "select Reside_id,Customer_name,"
	    		+ "Member_name,Room_id,Roomtype_name,Reside_number,Deposit,"
	    		+ "Reside_rtime,Reside_ltime,Checkout_state,Employee_name "
	    		+ "from reside re,Customer c,Member m,Roomtype ro,Employee e "
	    		+ "where re.Customer_id = c.Customer_id and re.Member_id = m.Member_id "
	    		+ "and re.Roomtype_id = ro.Roomtype_id and re.Employee_id = e.Employee_id ";

	    Connection conn = DBManager.getConnection();
	    Statement st = null;
	    ResultSet rs = null;

	    try {
	      st = conn.createStatement();
	      rs = st.executeQuery(sql);
	      while (rs.next()) {
	        Vector v = new Vector();
	        v.add(rs.getString(1));
	        v.add(rs.getString(2));
	        v.add(rs.getString(3));
	        v.add(rs.getString(4));
	        v.add(rs.getString(5));
	        v.add(rs.getString(6));
	        v.add(rs.getString(7));
	        v.add(rs.getString(8));
	        v.add(rs.getString(9));
	        v.add(rs.getString(10));
	        v.add(rs.getString(11));
	        resultVector.add(v);
	      }
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } finally {
	      DBManager.free(conn, st, rs);
	    }

	    return resultVector;
	  }
	  
	  public Vector<Vector> findyijiezhang(checkinVO vo) {//查找已结账房间信息
		    Vector<Vector> resultVector = new Vector<Vector>();
		    
		    StringBuilder sql = new StringBuilder("select Reside_id,Customer_name,"
		    		+ "Member_name,Room_id,Roomtype_name,Reside_number,Deposit,"
		    		+ "Reside_rtime,Reside_ltime,Checkout_state,Employee_name "
		    		+ "from reside re,Customer c,Member m,Roomtype ro,Employee e "
		    		+ "where re.Customer_id = c.Customer_id and re.Member_id = m.Member_id "
		    		+ "and re.Roomtype_id = ro.Roomtype_id and re.Employee_id = e.Employee_id ");
			String jiezhangzhuangtai = vo.getjiezhangzhuangtai();
		    sql.append("and Checkout_state='"+jiezhangzhuangtai+"'");
		    Connection conn = DBManager.getConnection();
		    Statement st = null;
		    ResultSet rs = null;
		    try {
		      st = conn.createStatement();
		      rs = st.executeQuery(sql.toString());
		      while (rs.next()) {
		        Vector v = new Vector();
		        v.add(rs.getString(1));
		        v.add(rs.getString(2));
		        v.add(rs.getString(3));
		        v.add(rs.getString(4));
		        v.add(rs.getString(5));
		        v.add(rs.getString(6));
		        v.add(rs.getString(7));
		        v.add(rs.getString(8));
		        v.add(rs.getString(9));
		        v.add(rs.getString(10));
		        v.add(rs.getString(11));
		        resultVector.add(v);
		      }
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } finally {
		      DBManager.free(conn, st, rs);
		    }

		    return resultVector;
		  }
	  
	  public Vector<Vector> findweijiezhang(checkinVO vo) {//查找未结账房间信息
		    Vector<Vector> resultVector = new Vector<Vector>();

		   StringBuilder sql = new StringBuilder("select Reside_id,Customer_name,"
		    		+ "Member_name,Room_id,Roomtype_name,Reside_number,Deposit,"
		    		+ "Reside_rtime,Reside_ltime,Checkout_state,Employee_name "
		    		+ "from reside re,Customer c,Member m,Roomtype ro,Employee e "
		    		+ "where re.Customer_id = c.Customer_id and re.Member_id = m.Member_id "
		    		+ "and re.Roomtype_id = ro.Roomtype_id and re.Employee_id = e.Employee_id ");
		    String jiezhangzhuangtai = vo.getjiezhangzhuangtai();
		    if ( jiezhangzhuangtai != null && jiezhangzhuangtai.equals("0") ) {
		      sql.append("and Checkout_state=0 ");
		    }
		    Connection conn = DBManager.getConnection();
		    Statement st = null;
		    ResultSet rs = null;
		    try {
		      st = conn.createStatement();
		      rs = st.executeQuery(sql.toString());
		      while (rs.next()) {
		        Vector v = new Vector();
		        v.add(rs.getString(1));
		        v.add(rs.getString(2));
		        v.add(rs.getString(3));
		        v.add(rs.getString(4));
		        v.add(rs.getString(5));
		        v.add(rs.getString(6));
		        v.add(rs.getString(7));
		        v.add(rs.getString(8));
		        v.add(rs.getString(9));
		        v.add(rs.getString(10));
		        v.add(rs.getString(11));
		        resultVector.add(v);
		      }
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } finally {
		      DBManager.free(conn, st, rs);
		    }
		    return resultVector;
		  }
}


