package vo.mainfrm;

import java.util.Date;
/**
 * ��ס��Ϣ��
 * @author �Ⱒ��
 *
 */
public class ResideVO {
	private String ResiderID;     //������
	private int deposit;       // Ѻ��
	private String CheckoutState; //����״̬
	private int ResideNumber;  //��ס����
	private String CustomerID;    // �˿ͱ��
	private String MemberID;      //�˿����ͱ��
	private String RoomID;        // �����
	private String RoomTypeID;    // �������ͱ��
	private String EmployeeID;    //Ա�����
	private Date ResideRtime;     //��סʱ��
	private Date ResideLtime;     // �˷�ʱ��
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
