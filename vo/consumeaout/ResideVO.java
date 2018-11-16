package vo.consumeaout;

import java.util.Date;

public class ResideVO {

	private String Reside_id;
	private double Deposit;
	private char  Checkout_state;
	private int Reside_number;
	private String Customer_id;
	private String Member_id;
	private String Room_id;
	private String Roomtype_id;
	private String Employee_id;
	private Date Reside_rtime;
	private Date Reside_ltime;
	
	public String getReside_id() {
		return Reside_id;
	}
	public void setReside_id(String reside_id) {
		Reside_id = reside_id;
	}
	public double getDeposit() {
		return Deposit;
	}
	public void setDeposit(double deposit) {
		Deposit = deposit;
	}
	public char getCheckout_state() {
		return Checkout_state;
	}
	public void setCheckout_state(char checkout_state) {
		Checkout_state = checkout_state;
	}
	public int getReside_number() {
		return Reside_number;
	}
	public void setReside_number(int reside_number) {
		Reside_number = reside_number;
	}
	public String getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(String customer_id) {
		Customer_id = customer_id;
	}
	public String getMember_id() {
		return Member_id;
	}
	public void setMember_id(String member_id) {
		Member_id = member_id;
	}
	public String getRoom_id() {
		return Room_id;
	}
	public void setRoom_id(String room_id) {
		Room_id = room_id;
	}
	public String getRoomtype_id() {
		return Roomtype_id;
	}
	public void setRoomtype_id(String roomtype_id) {
		Roomtype_id = roomtype_id;
	}
	public String getEmployee_id() {
		return Employee_id;
	}
	public void setEmployee_id(String employee_id) {
		Employee_id = employee_id;
	}
	public Date getReside_rtime() {
		return Reside_rtime;
	}
	public void setReside_rtime(Date reside_rtime) {
		Reside_rtime = reside_rtime;
	}
	public Date getReside_ltime() {
		return Reside_ltime;
	}
	public void setReside_ltime(Date reside_ltime) {
		Reside_ltime = reside_ltime;
	}
	
}
