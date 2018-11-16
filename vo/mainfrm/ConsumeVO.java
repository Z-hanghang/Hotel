package vo.mainfrm;

import java.util.Date;
/**
 * 房间消费信息表
 * @author 吴阿龙
 *
 */
public class ConsumeVO {
	private String roomID;
	private String customerID;
	private String foodID;
	private int consumeNumber;
	private Date consumeDate;
	private String consumeState;
	private double consumeCount;
	
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getFoodID() {
		return foodID;
	}
	public void setFoodID(String foodID) {
		this.foodID = foodID;
	}
	public int getConsumeNumber() {
		return consumeNumber;
	}
	public void setConsumeNumber(int consumeNumber) {
		this.consumeNumber = consumeNumber;
	}
	public Date getConsumeDate() {
		return consumeDate;
	}
	public void setConsumeDate(Date consumeDate) {
		this.consumeDate = consumeDate;
	}
	public String getConsumeState() {
		return consumeState;
	}
	public void setConsumeState(String consumeState) {
		this.consumeState = consumeState;
	}
	public double getConsumeCount() {
		return consumeCount;
	}
	public void setConsumeCount(double consumeCount) {
		this.consumeCount = consumeCount;
	}
}
