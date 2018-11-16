package vo.mainfrm;
/**
 * 顾客 会员 顾客类型 VO
 * **/
public class CustomerVO {
	private String CustomerID;  //顾客编号
	private String CustomerName; //顾客姓名
	private String CustomerSex;  //顾客类型编号
	private String CustomerTel;  //顾客手机号码
	private String CustomerCID;  //顾客身份证号码
	private String MemberId;     //顾客类型编号
	private String MemberName;    //顾客类型名称
	private String MemberCount;   //顾客折扣
	private String VipId;         //会员编号

	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerSex() {
		return CustomerSex;
	}
	public void setCustomerSex(String customerSex) {
		CustomerSex = customerSex;
	}
	public String getCustomerTel() {
		return CustomerTel;
	}
	public void setCustomerTel(String customerTel) {
		CustomerTel = customerTel;
	}

	public String getCustomerCID() {
		return CustomerCID;
	}
	public void setCustomerCID(String customerCID) {
		CustomerCID = customerCID;
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public String getMemberCount() {
		return MemberCount;
	}
	public void setMemberCount(String memberCount) {
		MemberCount = memberCount;
	}
	public String getVipId() {
		return VipId;
	}
	public void setVipId(String vipId) {
		VipId = vipId;
	}

}
