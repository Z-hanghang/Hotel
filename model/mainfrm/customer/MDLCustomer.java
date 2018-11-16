package model.mainfrm.customer;

import java.util.Vector;

import dao.mainfrm.GuKe.GuKeDao;
import vo.mainfrm.GuKe.Customervo;
import vo.mainfrm.GuKe.Membervo;
import vo.mainfrm.GuKe.Vipvo;



public class MDLCustomer {
	/**
	 * 
	 * 顾客信息管理
	 * 
	 */
	  private GuKeDao customerDAO = new GuKeDao();
	
	  //新增客户信息 
	  public void xinZengCustomer(Customervo vo) {
	    this.customerDAO.insertCustomer(vo);
	  }
	  //修改客户信息
	  public void gengXinCustomer(Customervo vo) {
	    this.customerDAO.updateCustomerByPK(vo);
	  }
	  private GuKeDao customerDao = new GuKeDao();
	  /*通过顾客手机号查找顾客信息*/
	  public Vector chaZhaoCustomerByTel(Customervo vo) {
	    return customerDao.findCustomerByTel(vo);
	    
	  }
	  /*通过顾客名称查找顾客信息*/
	  public Vector chaZhaoCustomerByName(Customervo vo){
		  return customerDao.findCustomerByName(vo);
	  }
	  /*通过手机号和名称查找顾客信息*/
	  public Vector chaZhaoCustomerByNameAndTel(Customervo vo){
		  return customerDao.findCustomerByNameAndTel(vo);
	  }
	  /*查找全部顾客信息*/
	  public Vector chaZhaoQuanCustomer() {
	    return customerDao.findAllCustomer();
	  }
	  /*删除顾客信息*/
	  public void shanChuCustomer(Customervo vo) {
		  customerDao.deleteCustomerByPK(vo);
	  }
	 /**
	  * 
	  * 顾客类型管理
	  * 
	  */
	  //新增顾客类型信息
	  public void xinZengMember(Membervo vo) {
	    this.customerDao.insertMember(vo);
	  }
	  //修改顾客类型信息
	  public void gengXinMember(Membervo vo) {
	    this.customerDao.updateMemberByPK(vo);
	  }
	 
	  /*通过顾客类型编号查找*/
	  public Vector chaZhaoMemberById(Membervo vo) {
	    return customerDao.findMemberById(vo);
	    
	  }
	  /*通过顾客类型名称查找*/
	  public Vector chaZhaoMemberByName(Membervo vo) {
		    return customerDao.findMemberByName(vo);
		    
		  }
	 /*查找全部顾客类型信息*/
	  public Vector chaZhaoQuanMember() {
	    return customerDao.findAllMember();
	  }
	  /*删除顾客类型信息*/
	  public void shanChuMember(Membervo vo) {
		  customerDao.deleteMemberidByPK(vo);
	  }
	  /**
	   * 
	   * 会员信息管理
	   * 
	   **/
	  //新增会员信息
	  public void xinZengVip(Vipvo vo) {
	    this.customerDao.insertVip(vo);
	  }
	  //修改会员信息
	  public void gengXinVip(Vipvo  vo) {
	    this.customerDao.updateVipByPK(vo);
	  }
	  
	  /*通过顾客编号查找*/
	  public Vector chaZhaoVipByVipId(Vipvo vo) {
	    return customerDao.findVipByVipId(vo);
	    
	  }
	  
	 /*查找全部会员信息*/
	  public Vector chaZhaoQuanVip() {
	    return customerDao.findAllVip();
	  }
	  /*删除顾客类型信息*/
	  public void shanChuVip(Vipvo vo) {
		  customerDao.deleteVipIdByPK(vo);
	  }
}
