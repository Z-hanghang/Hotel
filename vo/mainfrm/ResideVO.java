package vo.mainfrm;

import java.util.Date;
/**
 * 入住信息表
 * @author 吴阿龙
 *
 */
public class ResideVO {
	private String ResiderID;     //订单号
	private int deposit;       // 押金
	private String CheckoutState; //结账状态
	private int ResideNumber;  //入住人数
	private String CustomerID;    // 顾客编号
	private String MemberID;      //顾客类型编号
	private String RoomID;        // 房间号
	private String RoomTypeID;    // 房间类型编号
	private String EmployeeID;    //员工编号
	private Date ResideRtime;     //入住时间
	private Date ResideLtime;     // 退房时间
	public String getResiderID() {
		return ResiderID;
	}
	public void setResiderID(String residerID) {
		ResiderID = residerID;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public String getCheckoutState() {
		return CheckoutState;
	}
	public void setCheckoutState(String checkoutState) {
		CheckoutState = checkoutState;
	}
	public int getResideNumber() {
		return ResideNumber;
	}
	public void setResideNumber(int resideNumber) {
		ResideNumber = resideNumber;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getMemberID() {
		return MemberID;
	}
	public void setMemberID(String memberID) {
		MemberID = memberID;
	}
	public String getRoomID() {
		return RoomID;
	}
	public void setRoomID(String roomID) {
		RoomID = roomID;
	}
	public String getRoomTypeID() {
		return RoomTypeID;
	}
	public void setRoomTypeID(String roomTypeID) {
		RoomTypeID = roomTypeID;
	}
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}
	public Date getResideRtime() {
		return ResideRtime;
	}
	public void setResideRtime(Date resideRtime) {
		ResideRtime = resideRtime;
	}
	public Date getResideLtime() {
		return ResideLtime;
	}
	public void setResideLtime(Date resideLtime) {
		ResideLtime = resideLtime;
	}
}
