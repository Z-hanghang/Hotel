package vo.mainfrm;
/**
 * 房间类型信息表
 * @author 吴阿龙
 *
 */
public class RoomTypeVO {
	private String roomTypeId;      //房间类型id
	
	private String roomTypeName;      // 房间类型名
	
	private double roomTypePiece;      // 房间类型价格

	public String getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public double getRoomTypePiece() {
		return roomTypePiece;
	}

	public void setRoomTypePiece(double roomTypePiece) {
		this.roomTypePiece = roomTypePiece;
	}
	
	

}
