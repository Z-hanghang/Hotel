package dao.mainfrm.GuKe;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.jdbc.DBManager;
import vo.mainfrm.GuKe.Customervo;
import vo.mainfrm.GuKe.Membervo;
import vo.mainfrm.GuKe.Vipvo;



public class GuKeDao {
	public String findCustomerById(String customerId) {
	    String resultVector = new String();

	    StringBuilder sql = new StringBuilder("select v.vip_id from customer c,vip v"
	    		+ " where c.customer_id=v.customer_id ");
	   
	    if (customerId != null && !customerId.equals("")) {
	      sql.append(" and c.customer_id  ='"+customerId+"'");
	    }
        
	    Connection conn = DBManager.getConnection();
	    Statement st = null;
	    ResultSet rs = null;

	    try {
	      st = conn.createStatement();
	      rs = st.executeQuery(sql.toString());
	      while (rs.next()) {
	    	  resultVector=rs.getString(1);
	        
	        //resultVector.add(v);
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
	 * 通过手机号查找顾客信息
	 */
	public Vector findCustomerByTel(Customervo vo) {
	    Vector resultVector = new Vector();

	    StringBuilder sql = new StringBuilder("select * from customer");
	    String customerTel=vo.getCustomertel();
	    
	    if (customerTel != null && !customerTel.equals("")) {
	      sql.append(" where customer_tel  ="+customerTel+"");
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
	public Vector findCustomerByName(Customervo vo) {
	    Vector resultVector = new Vector();

	    StringBuilder sql = new StringBuilder("select * from customer ");
	    String customername = vo.getCustomername();
	   
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
	 * 通过顾客手机号和名称查找
	 */
	public Vector findCustomerByNameAndTel(Customervo vo) {
	    Vector resultVector = new Vector();

	    StringBuilder sql = new StringBuilder("select * from customer ");
	    String customername = vo.getCustomername();
	    String customertel   = vo.getCustomertel();
	    if (customername!= null && !customername.equals("")&&customertel!= null && !customertel.equals("")) {
	      sql.append("where customer_name like '%" + customername+ "%'"
	      		+ " and customer_tel like '%"+customertel+"%'");
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
	  public void deleteCustomerByPK(Customervo vo) {
	    String sql = "delete customer where customer_id = '" + vo.getCustomerid()
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
        
	    StringBuilder sql = new StringBuilder("select*from customer");

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
	  public void insertCustomer(Customervo vo) {
	    String sql = "insert into customer values " + "(?, ?, ?, ?, ?, ?)";
	    Connection conn = DBManager.getConnection();
	    PreparedStatement ps = null;
	    try {
	      ps = conn.prepareStatement(sql);
	      ps.setString(1, vo.getCustomerid());
	      ps.setString(2, vo.getCustomername());
	      ps.setString(3, vo.getCustomersex());
	      ps.setString(4, vo.getCustomertel());
	      ps.setString(5, vo.getCustomercid());
	      ps.setString(6, vo.getMemberid());
	      
	      
         
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
	  public void updateCustomerByPK(Customervo vo) {
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
	      ps.setString(6, vo.getCustomerid());
	      ps.setString(1, vo.getCustomername());
	      ps.setString(2, vo.getCustomersex());
	      ps.setString(3, vo.getCustomertel());
	      ps.setString(4, vo.getCustomercid());
	      ps.setString(5, vo.getMemberid());
	    
	      ps.executeUpdate();
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } finally {
	      DBManager.free(conn, ps);
	    }
	  }
	  /*通过顾客类型编号查找*/
		public Vector findMemberById(Membervo vo) {
		    Vector resultVector = new Vector();

		    StringBuilder sql = new StringBuilder("select * from member ");
		    
		    String memberid=vo.getMemberid();
		    if (memberid!= null && !memberid.equals("")) {
		      sql.append("where member_id like '%" +memberid+ "%'");
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
		 * 通过顾客类型名称查找
		 */
		  
		public Vector findMemberByName(Membervo vo) {
		    Vector resultVector = new Vector();

		    StringBuilder sql = new StringBuilder("select * from member ");
		    
		    String membername=vo.getMembername();
		    if (membername!= null && !membername.equals("")) {
		      sql.append("where member_name like '%" +membername+ "%'");
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
		 * 查找会员名称是vip或者svip
		 */
		public Vector findVipByName(Membervo vo) {
		    Vector resultVector = new Vector();
	        String memberid=vo.getMemberid();
	        String customerid=new Customervo().getCustomerid();
		    StringBuilder sql = new StringBuilder("select vip_id,customer_id,member_id "
		    		+ "from customer,member where  "+customerid+"="+memberid+"");
		    
		    String membername=vo.getMembername();
		    if (membername!= null && !membername.equals("")) {
		      sql.append(" and member_name like '%" +membername+ "%'");
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
		/*通过顾客类型编号删除*/
		  public void deleteMemberidByPK(Membervo vo) {
		    String sql = "delete member where member_id = '" + vo.getMemberid()
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
	       /*查找全部顾客类型信息*/
		  public Vector findAllMember() {
		    Vector resultVector = new Vector();

		    String sql = "select * from member";

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
	      /*新增顾客类型*/
		  public void insertMember(Membervo vo) {
		    String sql = "insert into member values " + "(?, ?, ?)";
		    Connection conn = DBManager.getConnection();
		    PreparedStatement ps = null;
		   
		    try {
		      ps = conn.prepareStatement(sql);
		      ps.setString(1, vo.getMemberid());
		      ps.setString(2, vo.getMembername());
		      ps.setString(3, vo.getMembercount());
		      
	         
		      ps.executeUpdate();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } finally {
		      DBManager.free(conn, ps);
		    }
		  }
	      /*修改顾客类型信息*/
		  public void updateMemberByPK(Membervo vo) {
		    String sql = "update member set "
		      
		      
		      + "member_name= ?, "
		      + "member_count= ?"
		      + "where member_id = ?";
		    Connection conn = DBManager.getConnection();
		    PreparedStatement ps = null;
		    //String meNO = HotelTools.getNumber(HotelTools.MG);
			//System.out.println(meNO);
	        //HotelTools.savNumber(meNO,HotelTools.MG);
		    try {
		      ps = conn.prepareStatement(sql);
		      ps.setString(3, vo.getMemberid());
		      ps.setString(1, vo.getMembername());
		      ps.setString(2, vo.getMembercount());
		    

		      ps.executeUpdate();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } finally {
		      DBManager.free(conn, ps);
		    }
		  }
		  /*通过顾客编号查找*/
			public Vector findVipByVipId(Vipvo vo) {
			    Vector resultVector = new Vector();

			    StringBuilder sql = new StringBuilder("select* from vip ");
			    
			    String vipid=vo.getVipid();
			    if (vipid!= null && !vipid.equals("")) {
			      sql.append(" where vip_id like '%" +vipid+ "%'");
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
			
			/*通过会员编号删除*/
			  public void deleteVipIdByPK(Vipvo vo) {
			    String sql = "delete vip where vip_id = '" + vo.getVipid()
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
		       /*查找全部会员信息*/
			  public Vector findAllVip() {
			    Vector resultVector = new Vector();
			    String sql = new String("select* from vip");
			    

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
		      /*新增会员类型*/
			  public void insertVip(Vipvo vo) {
			    String sql = "insert into vip values "+" (?, ?, ?)";
			    Connection conn = DBManager.getConnection();
			    PreparedStatement ps = null;
			 
			    try {
			      ps = conn.prepareStatement(sql);
			      ps.setString(1, vo.getVipid());
			      ps.setString(2, vo.getCustomerid());
			      ps.setString(3, vo.getMemberid());
			     
			      ps.executeUpdate();
			    } catch (SQLException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    } finally {
			      DBManager.free(conn, ps);
			    }
			  }
		      /*修改会员信息*/
			  public void updateVipByPK(Vipvo vo) {
			    String sql = "update vip set "
			      
			      + "customer_id= ?, "
			      + "member_id= ?"
			      + "where vip_id = ?";
			    Connection conn = DBManager.getConnection();
			    PreparedStatement ps = null;
			    try {
			      ps = conn.prepareStatement(sql);
			    
			      ps.setString(1, vo.getCustomerid());
			      ps.setString(2, vo.getMemberid());
			      ps.setString(3, vo.getVipid());
		         
			      ps.executeUpdate();
			    } catch (SQLException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    } finally {
			      DBManager.free(conn, ps);
			    }
			  }
}

