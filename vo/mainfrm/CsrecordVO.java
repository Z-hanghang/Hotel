package vo.mainfrm;

import java.util.Date;
/**
 * »»·¿¼ÇÂ¼±í
 * @author Îâ°¢Áú
 *
 */
public class CsrecordVO {
	private String cSrecordId;
	private String customerId;
	private String roomId;
	private String beforeRoomId;
	private Date CSrecordDate;
	public String getcSrecordId() {
		return cSrecordId;
	}
	public void setcSrecordId(String cSrecordId) {
		this.cSrecordId = cSrecordId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getBeforeRoomId() {
		return beforeRoomId;
	}
	public void setBeforeRoomId(String beforeRoomId) {
		this.beforeRoomId = beforeRoomId;
	}
	public Date getCSrecordDate() {
		return CSrecordDate;
	}
	public void setCSrecordDate(Date cSrecordDate) {
		CSrecordDate = cSrecordDate;
	}
	
	
	

}
