package model.mainfrm.YuDing;

import java.util.Vector;


import dao.mainfrm.RuZhu.ResideFrmDAO;
import dao.mainfrm.YuDing.JdbcYuDing;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ReserveVO;

/**
 * Ԥ����ɾ����߼�ҵ����
 * @author �ź�
 * @date 2018.10.31
 * **/
public class MdlYuDing {
	private JdbcYuDing yd=new JdbcYuDing();
	private ResideFrmDAO rd=new ResideFrmDAO();
	//��ѯ����Ԥ����Ϣ
	public Vector selectAllYuDing(){
		return yd.selectAllYuDing();
	}
	//����Ԥ��״̬��ѯԤ����Ϣ
	public Vector selectYuDingSate(ReserveVO vo){
		return yd.selectYuDingSate(vo);
	}
	// ���ݷ���id��Ԥ����Ϣ	public Vector selectYuDingRoom(ReserveVO vo){
		return yd.selectYuDingRoom(vo);
	}
	// ���ݹ˿�������Ԥ����Ϣ
	public Vector selectYuDingCustomer(ReserveVO vo){
		return yd.selectYuDingCustomer(vo);
	}
	// ���ݹ˿͵绰��Ԥ����Ϣ
	public Vector selectYuDingCustomerTel(ReserveVO vo){
		return yd.selectYuDingTel(vo);
	}
	//ɾ��Ԥ����Ϣ
	public void deleteYuDing(ReserveVO vo){
		 yd.deleteYuDing(vo);
	}
	//���Ԥ����Ϣ
	public void addYuDing(ReserveVO vo){
		yd.insertYuDing(vo);
	}
	//����Ԥ����Ϣ
	public void updateYuDing(ReserveVO vo){
		yd.UpdateYuDing(vo);
	}
	//ͨ��vipid����ʷ�˿�
	public CustomerVO findCustomerByVIP(CustomerVO vo){
		return rd.findCustomerByVIP(vo);
	}
	//ͨ���绰����ʷ�˿�
	public Vector findCustomerByTel(CustomerVO vo){
		return rd.findCustomerByTel(vo);
	}
	//����vip
	public String  findVipId(String y) {
		return yd.findVipId(y);
	}
	
	  //�����ͻ���Ϣ 
	public void xinZengCustomer(CustomerVO vo) {
	   yd.insertCustomer(vo);
	  }
	//������ʷ�˿͵ı�ź͹˿����ͱ��
	 public CustomerVO findCustomerIDByTel(CustomerVO vo){
		 return yd.findCustomerByTel(vo);
	 }
	 ////����Ԥ����Ÿ���Ԥ��״̬
	 public void UpdateYuDingState(ReserveVO vo) {
		 yd.UpdateYuDingState(vo);
	 }
	 
}
