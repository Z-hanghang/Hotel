package model.mainbackfrm.mdlnumber;
/*业务逻辑编号增加
 * 
 * */

import dao.mainback.bianhao.NumberUp;
import vo.mainback.Employee;
import vo.mainback.Roomvo;

public class MdlNumberUp {
private NumberUp number=new NumberUp();
//员工编号累加
public int EmployeeMaxNumber(){
	Employee em=number.employeeMaxId();
	String s=em.getEmployeeId().substring(2, 6);
	int num=Integer.parseInt(s)+1;
	
	return num;
}
//房间类型编号累加
public int RoomTypeMaxNumber(){
	Roomvo  room=number.RoomTypeMaxId();
	String s=room.getRoomtypeid().substring(2, 4);
	int num=Integer.parseInt(s)+1;
	
	return num;
}
//房间号累加
public String RoomIdMaxNumber(String s){
	
	Roomvo  room=number.RoomMaxId(s);
	String l=room.getRoomid().substring(1,4);
	int num=Integer.parseInt(l)+1;
	return "R"+num;
}


}
