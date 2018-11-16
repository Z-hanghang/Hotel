package model.mainfrm.checkinmodel;

import java.util.Vector;

import dao.mainfrm.checkinDAO.checkinDao;
import vo.mainfrm.ruzhucha.checkinvo.checkinVO;




//import vo.BanJiVO;

public class MDLcheckin {
	 private checkinDao ruzhuDAO = new checkinDao();
	 public  Vector findnews( checkinVO vo) {
		    return ruzhuDAO.findnewsByfangjianhao(vo);//定义一个通过房间号查找房间信息的方法。
		   
		  }
	 public Vector findallnews(checkinVO vo) {
		    return ruzhuDAO.findAllnews(vo);//定义一个查找所有信息的方法
		  }
	public Vector yijiezhangruzhuxinxi(checkinVO vo) {
		// TODO Auto-generated method stub
		return ruzhuDAO.findyijiezhang(vo);//定义一个查找出已结账信息的方法
	}
	public Vector weijiezhangruzhuxinxi(checkinVO vo) {
		// TODO Auto-generated method stub
		return ruzhuDAO.findweijiezhang(vo);//定义一个查找出未结账信息的方法
	}
	public Vector allnews(checkinVO vo) {
		return ruzhuDAO.findAllnews(vo);//定义一个显示所有信息的方法
	}
	 
	
}
