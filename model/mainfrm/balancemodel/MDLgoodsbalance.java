package model.mainfrm.balancemodel;

import java.util.Vector;

import dao.mainfrm.balanceDAO.goodsbalancedao;
import vo.mainfrm.ruzhucha.balancevo.goodsbalanceVO;

public class MDLgoodsbalance {
	 private goodsbalancedao shangpinjiesuanDAO = new goodsbalancedao();
	 
	 public  Vector findNewsBymessage( goodsbalanceVO vo) {
		    return shangpinjiesuanDAO.findnewsbymessage(vo);//����һ��ͨ����������������Ϣ�ķ���
	 }
	 public Vector findAllNews(goodsbalanceVO vo) {
		    return shangpinjiesuanDAO.findallnews(vo);//����һ������������Ϣ�ķ���
	 }
//	 public  Vector FindNewsBystate( goodsbalanceVO vo) {
//		    return shangpinjiesuanDAO.findnewsbystate(vo);//����һ��ͨ������״̬����������Ϣ�ķ���
//	 }
	 
}
