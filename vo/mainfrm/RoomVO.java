package vo.mainfrm;
/**
 * 房间信息表
 * @author 吴阿龙
 *
 */
public class RoomVO {
	private String roomId;
	private String roomTypeId;
	private int    roomNumber;
	private String floorId;
	private String roomStateId;
	public String getRoomId() {
		return roomId;
	}
	
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getFloorId() {
		return floorId;
	}
	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}
	public String getRoomStateId() {
		return roomStateId;
	}
	public void setRoomStateId(String roomStateId) {
		this.roomStateId = roomStateId;
	}
	
	
	
	

}
