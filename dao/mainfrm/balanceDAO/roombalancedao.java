package dao.mainfrm.balanceDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.jdbc.DBManager;
import vo.mainfrm.ruzhucha.balancevo.roombalanceVO;

public class roombalancedao {
	
	public Vector<Vector> findnewsbyMessage(roombalanceVO vo) {//通过输入框信息查找房间信息
	    Vector<Vector> resultVector = new Vector<Vector>();
	    
	    StringBuilder sql = new StringBuilder("select Account_id,Reside_id,"
	    		+ "Customer_name,Member_name,Room_id,Roomtype_name,Account_money,"
	    		+ "Deposit,Return_deposit,Account_state,Account_txt,Employee_name "
	    		+ "from Account a,Customer c,Member m,Employee e,Roomtype r "
	    		+ "where a.Customer_id = c.Customer_id and a.Member_id = m.Member_id "
	    		+ "and a.Roomtype_id = r.Roomtype_id and a.Employee_id = e.Employee_id ");
	    
	    String fangjianhaofj = vo.getfangjianhaofj();
	    String jiezhangzhuangtai = vo.getjiezhangzhuangtaifj();
	    
	    if (fangjianhaofj != null && !fangjianhaofj.equals("")) {//显示房间号对应的结算信息
	    	if(jiezhangzhuangtai != null && jiezhangzhuangtai.equals("")){
	    		sql.append("and Room_id like '%" + fangjianhaofj + "%'");
	    	}
	    }
	    if (jiezhangzhuangtai != null && !jiezhangzhuangtai.equals("")) {//显示结账状态对应的结算信息
	    	if(fangjianhaofj != null && fangjianhaofj.equals("")){
	    		sql.append("and Account_state = '"+jiezhangzhuangtai+"'"); 	
	    	}
	    }
	    if(fangjianhaofj != null && !fangjianhaofj.equals("") ){//显示房间号以及结账状态对应的结算信息
	    	if(jiezhangzhuangtai != null && !jiezhangzhuangtai.equals("")){
	    		sql.append("and Room_id like '%" + fangjianhaofj + "%' "
	    				+ "and Account_state = '"+jiezhangzhuangtai+"'");
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
	        v.add(rs.getString(12));
	       
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
	
	public Vector findallnews(roombalanceVO vo) {//查找所有信息
		  Vector resultVector = new Vector();

		  String sql ="select Account_id,Reside_id,"
		    		+ "Customer_name,Member_name,Room_id,Roomtype_name,Account_money,"
		    		+ "Deposit,Return_deposit,Account_state,Account_txt,Employee_name "
		    		+ "from Account a,Customer c,Member m,Employee e,Roomtype r "
		    		+ "where a.Customer_id = c.Customer_id and a.Member_id = m.Member_id "
		    		+ "and a.Roomtype_id = r.Roomtype_id and a.Employee_id = e.Employee_id ";

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
		        v.add(rs.getString(12));
		        
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
