package model.mainfrm.customer;

import java.util.Vector;

import dao.mainfrm.GuKe.GuKeDao;
import vo.mainfrm.GuKe.Customervo;
import vo.mainfrm.GuKe.Membervo;
import vo.mainfrm.GuKe.Vipvo;



public class MDLCustomer {
	/**
	 * 
	 * �˿���Ϣ����
	 * 
	 */
	  private GuKeDao customerDAO = new GuKeDao();
	
	  //�����ͻ���Ϣ 
	  public void xinZengCustomer(Customervo vo) {
	    this.customerDAO.insertCustomer(vo);
	  }
	  //�޸Ŀͻ���Ϣ
	  public void gengXinCustomer(Customervo vo) {
	    this.customerDAO.updateCustomerByPK(vo);
	  }
	  private GuKeDao customerDao = new GuKeDao();
	  /*ͨ���˿��ֻ��Ų��ҹ˿���Ϣ*/
	  public Vector chaZhaoCustomerByTel(Customervo vo) {
	    return customerDao.findCustomerByTel(vo);
	    
	  }
	  /*ͨ���˿����Ʋ��ҹ˿���Ϣ*/
	  public Vector chaZhaoCustomerByName(Customervo vo){
		  return customerDao.findCustomerByName(vo);
	  }
	  /*ͨ���ֻ��ź����Ʋ��ҹ˿���Ϣ*/
	  public Vector chaZhaoCustomerByNameAndTel(Customervo vo){
		  return customerDao.findCustomerByNameAndTel(vo);
	  }
	  /*����ȫ���˿���Ϣ*/
	  public Vector chaZhaoQuanCustomer() {
	    return customerDao.findAllCustomer();
	  }
	  /*ɾ���˿���Ϣ*/
	  public void shanChuCustomer(Customervo vo) {
		  customerDao.deleteCustomerByPK(vo);
	  }
	 /**
	  * 
	  * �˿����͹���
	  * 
	  */
	  //�����˿�������Ϣ
	  public void xinZengMember(Membervo vo) {
	    this.customerDao.insertMember(vo);
	  }
	  //�޸Ĺ˿�������Ϣ
	  public void gengXinMember(Membervo vo) {
	    this.customerDao.updateMemberByPK(vo);
	  }
	 
	  /*ͨ���˿����ͱ�Ų���*/
	  public Vector chaZhaoMemberById(Membervo vo) {
	    return customerDao.findMemberById(vo);
	    
	  }
	  /*ͨ���˿��������Ʋ���*/
	  public Vector chaZhaoMemberByName(Membervo vo) {
		    return customerDao.findMemberByName(vo);
		    
		  }
	 /*����ȫ���˿�������Ϣ*/
	  public Vector chaZhaoQuanMember() {
	    return customerDao.findAllMember();
	  }
	  /*ɾ���˿�������Ϣ*/
	  public void shanChuMember(Membervo vo) {
		  customerDao.deleteMemberidByPK(vo);
	  }
	  /**
	   * 
	   * ��Ա��Ϣ����
	   * 
	   **/
	  //������Ա��Ϣ
	  public void xinZengVip(Vipvo vo) {
	    this.customerDao.insertVip(vo);
	  }
	  //�޸Ļ�Ա��Ϣ
	  public void gengXinVip(Vipvo  vo) {
	    this.customerDao.updateVipByPK(vo);
	  }
	  
	  /*ͨ���˿ͱ�Ų���*/
	  public Vector chaZhaoVipByVipId(Vipvo vo) {
	    return customerDao.findVipByVipId(vo);
	    
	  }
	  
	 /*����ȫ����Ա��Ϣ*/
	  public Vector chaZhaoQuanVip() {
	    return customerDao.findAllVip();
	  }
	  /*ɾ���˿�������Ϣ*/
	  public void shanChuVip(Vipvo vo) {
		  customerDao.deleteVipIdByPK(vo);
	  }
}
