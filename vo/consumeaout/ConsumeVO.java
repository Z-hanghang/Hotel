package vo.consumeaout;

import java.util.Date;

public class ConsumeVO {

	private String Room_id;
	
	private String Customer_id;
	
	private String Food_id;
	
	private int Consume_number;
	
	private Date Consume_date;
	
	private String Consume_state = "0";
	
	private double Customer_count;

	public String getRoom_id() {
		return Room_id;
	}

	public void setRoom_id(String room_id) {
		Room_id = room_id;
	}

	public String getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(String customer_id) {
		Customer_id = customer_id;
	}

	public String getFood_id() {
		return Food_id;
	}

	public void setFood_id(String food_id) {
		Food_id = food_id;
	}
	
	public int getConsume_number() {
		return Consume_number;
	}

	public void setConsume_number(int consume_number) {
		Consume_number = consume_number;
	}

	public Date getConsume_date() {
		return Consume_date;
	}

	public void setConsume_date(Date consume_date) {
		Consume_date = consume_date;
	}

	public String getConsume_state() {
		return Consume_state;
	}

	public void setConsume_state(String consume_state) {
		Consume_state = consume_state;
	}

	public double getCustomer_count() {
		return Customer_count;
	}

	public void setCustomer_count(double customer_count) {
		Customer_count = customer_count;
	}
	
}
