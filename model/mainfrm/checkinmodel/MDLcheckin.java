package model.mainfrm.checkinmodel;

import java.util.Vector;

import dao.mainfrm.checkinDAO.checkinDao;
import vo.mainfrm.ruzhucha.checkinvo.checkinVO;




//import vo.BanJiVO;

public class MDLcheckin {
	 private checkinDao ruzhuDAO = new checkinDao();
	 public  Vector findnews( checkinVO vo) {
		    return ruzhuDAO.findnewsByfangjianhao(vo);//����һ��ͨ������Ų��ҷ�����Ϣ�ķ�����
		   
		  }
	 public Vector findallnews(checkinVO vo) {
		    return ruzhuDAO.findAllnews(vo);//����һ������������Ϣ�ķ���
		  }
	public Vector yijiezhangruzhuxinxi(checkinVO vo) {
		// TODO Auto-generated method stub
		return ruzhuDAO.findyijiezhang(vo);//����һ�����ҳ��ѽ�����Ϣ�ķ���
	}
	public Vector weijiezhangruzhuxinxi(checkinVO vo) {
		// TODO Auto-generated method stub
		return ruzhuDAO.findweijiezhang(vo);//����һ�����ҳ�δ������Ϣ�ķ���
	}
	public Vector allnews(checkinVO vo) {
		return ruzhuDAO.findAllnews(vo);//����һ����ʾ������Ϣ�ķ���
	}
	 
	
}
