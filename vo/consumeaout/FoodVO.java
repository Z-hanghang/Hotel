package vo.consumeaout;

public class FoodVO {

	private String Food_id;
	
	private String Food_name;
	
	private double Food_piece;
	
	private String Foodstock_id;

	public String getFood_id() {
		return Food_id;
	}

	public void setFood_id(String food_id) {
		Food_id = food_id;
	}

	public String getFood_name() {
		return Food_name;
	}

	public void setFood_name(String food_name) {
		Food_name = food_name;
	}

	public double getFood_piece() {
		return Food_piece;
	}

	public void setFood_piece(double food_piece) {
		Food_piece = food_piece;
	}

	public String getFoodstock_id() {
		return Foodstock_id;
	}

	public void setFoodstock_id(String foodstock_id) {
		Foodstock_id = foodstock_id;
	}
	
}
