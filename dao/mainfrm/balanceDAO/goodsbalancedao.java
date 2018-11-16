package dao.mainfrm.balanceDAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;



import common.jdbc.DBManager;
import vo.mainfrm.ruzhucha.balancevo.goodsbalanceVO;

public class goodsbalancedao {
	
	public Vector<Vector> findnewsbymessage(goodsbalanceVO vo) {//通过输入框信息查找商品消费信息
	    Vector<Vector> resultVector = new Vector<Vector>();
	    
	    StringBuilder sql = new StringBuilder("select Room_id,Customer_name,"
	    		+ "Food_name,Consume_number,Consume_date,Consume_count,Consume_state "
	    		+ "from Consume co,Customer cu,Food f "
	    		+ "where co.Customer_id = cu.Customer_id and co.Food_id = f.Food_id ");
	    
	    String fangjianhaosp = vo.getfangjianhaosp(); 
	    String jiezhangzhuangtaisp = vo.getjiezhangzhuangtaisp();
	    
	    if (fangjianhaosp != null && !fangjianhaosp.equals("")) {//显示房间号对应的商品消费信息
	    	if(jiezhangzhuangtaisp != null && jiezhangzhuangtaisp.equals("")){
	    		sql.append("and Room_id like '%" + fangjianhaosp + "%'");	    		
	    	}
	    }
	    if (jiezhangzhuangtaisp != null && !jiezhangzhuangtaisp.equals("")) {//显示结账状态对应的商品消费信息
	    	if(fangjianhaosp != null && fangjianhaosp.equals("")){
	    		sql.append(" and Consume_state = '"+jiezhangzhuangtaisp+"'"); 	    		
	    	}
		}
	    if(fangjianhaosp != null && !fangjianhaosp.equals("")){//显示房间号以及结账状态对应的商品消费信息
		    if(jiezhangzhuangtaisp != null && !jiezhangzhuangtaisp.equals("")){
		    	sql.append("and Room_id like '%" + fangjianhaosp + "%' "
		    			+ "and Consume_state="+jiezhangzhuangtaisp+"");
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
	
//	public static Vector findnewsbystate(goodsbalanceVO vo) {//通过结账状态查找商品信息
//	    Vector resultVector = new Vector();
//	    
//	    StringBuilder sql = new StringBuilder("select Room_id,Customer_name,"
//	    		+ "Food_name,Consume_number,Consume_date,Consume_count,Consume_state "
//	    		+ "from Consume co,Customer cu,Food f "
//	    		+ "where co.Customer_id = cu.Customer_id and co.Food_id = f.Food_id ");
//	
//	 String jiezhangzhuangtaisp = vo.getjiezhangzhuangtaisp();
//	    if (jiezhangzhuangtaisp != null && !jiezhangzhuangtaisp.equals("")) {
//	      sql.append("and Account_state="+jiezhangzhuangtaisp+""); 
//	    }
//	    Connection conn = DBManager.getConnection();
//	    Statement st = null;
//	    ResultSet rs = null;
//
//	    try {
//	      st = conn.createStatement();
//	      rs = st.executeQuery(sql.toString());
//	      while (rs.next()) {
//	        Vector v = new Vector();
//	        v.add(rs.getString(1));
//	        v.add(rs.getString(2));
//	        v.add(rs.getString(3));
//	        v.add(rs.getString(4));
//	        v.add(rs.getString(5));
//	        v.add(rs.getString(6));
//	        v.add(rs.getString(7));
//	        
//	        resultVector.add(v);
//	      }
//	    } catch (SQLException e) {
//	      // TODO Auto-generated catch block
//	      e.printStackTrace();
//	    } finally {
//	      DBManager.free(conn, st, rs);
//	    }
//	    return resultVector;
//	  } 
	public Vector findallnews(goodsbalanceVO vo) {//显示所有信息
		    Vector resultVector = new Vector();

		    String sql = "select Room_id,Customer_name,"
		    		+ "Food_name,Consume_number,Consume_date,Consume_count,Consume_state "
		    		+ "from Consume co,Customer cu,Food f "
		    		+ "where co.Customer_id = cu.Customer_id and co.Food_id = f.Food_id ";

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
