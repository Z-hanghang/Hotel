package dao.mainfrm.customer;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.jdbc.DBManager;
import vo.mainfrm.CustomerVO;




public class Customerdao {
	/*
	 * 通过编号查找顾客信息
	 */
	public Vector findCustomerById(CustomerVO vo) {
	    Vector resultVector = new Vector();

	    StringBuilder sql = new StringBuilder("select * from customer");
	    
	    String customerid=vo.getCustomerID();
	    if (customerid != null && !customerid.equals("")) {
	      sql.append(" where customer_id like '%" + customerid + "%'");
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
      
	/*
	 * 通过顾客名称查找顾客信息
	 */
	public Vector findCustomerByName(CustomerVO vo) {
	    Vector resultVector = new Vector();

	    StringBuilder sql = new StringBuilder("select * from customer ");
	    String customername = vo.getCustomerName();
	   
	    if (customername!= null && !customername.equals("")) {
	      sql.append("where customer_name like '%" + customername+ "%'");
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
	/*
	 * 通过顾客编号和名称查找
	 */
	public Vector findCustomerByNameAndId(CustomerVO vo) {
	    Vector resultVector = new Vector();

	    StringBuilder sql = new StringBuilder("select * from customer ");
	    String customername = vo.getCustomerName();
	    String customerid   = vo.getCustomerID();
	    if (customername!= null && !customername.equals("")&&customerid!= null && !customerid.equals("")) {
	      sql.append("where customer_name like '%" + customername+ "%'"
	      		+ " and customer_id like '%"+customerid+"%'");
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
      /*
       * 通过主键删除顾客信息
       */
	  public void deleteCustomerByPK(CustomerVO vo) {
	    String sql = "delete customer where customer_id = '" + vo.getCustomerID()
	        + "'";

	    Connection conn = DBManager.getConnection();
	    Statement st = null;

	    try {
	      st = conn.createStatement();
	      st.executeUpdate(sql);
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } finally {
	      DBManager.free(conn, st);
	    }
	  }
      /*
       * 查找全部顾客信息
       */
	  public Vector findAllCustomer() {
	    Vector resultVector = new Vector();
        
	    StringBuilder sql = new StringBuilder("select * from customer");

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
      /*
       * 新增顾客信息
       */
	  public void insertCustomer(CustomerVO vo) {
	    String sql = "insert into customer values " + "(?, ?, ?, ?, ?, ?)";
	    Connection conn = DBManager.getConnection();
	    PreparedStatement ps = null;
	    try {
	      ps = conn.prepareStatement(sql);
	      ps.setString(1, vo.getCustomerID());
	      ps.setString(2, vo.getCustomerName());
	      ps.setString(3, vo.getCustomerSex());
	      ps.setString(4, vo.getCustomerTel());
	      ps.setString(5, vo.getCustomerCID());
	      ps.setString(6, vo.getMemberId());

	      ps.executeUpdate();
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } finally {
	      DBManager.free(conn, ps);
	    }
	  }
      /*
       * 修改客户信息
       */
	  public void updateCustomerByPK(CustomerVO vo) {
	    String sql ="update customer set "
	      + "customer_name= ? ,"
	      + "customer_sex= ? ,"
	      + "customer_tel= ? ,"
	      + "customer_cid= ? , "
	      + "member_id= ? " 
	      + "where customer_id= ?";
	    Connection conn = DBManager.getConnection();
	    PreparedStatement ps = null;
	    try {
	      ps = conn.prepareStatement(sql);
	      ps.setString(6, vo.getCustomerID());
	      ps.setString(1, vo.getCustomerName());
	      ps.setString(2, vo.getCustomerSex());
	      ps.setString(3, vo.getCustomerTel());
	      ps.setString(4, vo.getCustomerCID());
	      ps.setString(5, vo.getMemberId());
	    
	      ps.executeUpdate();
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } finally {
	      DBManager.free(conn, ps);
	    }
	  }
}
