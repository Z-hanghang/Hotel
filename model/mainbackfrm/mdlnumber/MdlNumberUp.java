package model.mainbackfrm.mdlnumber;
/*ҵ���߼��������
 * 
 * */

import dao.mainback.bianhao.NumberUp;
import vo.mainback.Employee;
import vo.mainback.Roomvo;

public class MdlNumberUp {
private NumberUp number=new NumberUp();
//Ա������ۼ�
public int EmployeeMaxNumber(){
	Employee em=number.employeeMaxId();
	String s=em.getEmployeeId().substring(2, 6);
	int num=Integer.parseInt(s)+1;
	
	return num;
}
//�������ͱ���ۼ�
public int RoomTypeMaxNumber(){
	Roomvo  room=number.RoomTypeMaxId();
	String s=room.getRoomtypeid().substring(2, 4);
	int num=Integer.parseInt(s)+1;
	
	return num;
}
//������ۼ�
public String RoomIdMaxNumber(String s){
	
	Roomvo  room=number.RoomMaxId(s);
	String l=room.getRoomid().substring(1,4);
	int num=Integer.parseInt(l)+1;
	return "R"+num;
}


}
