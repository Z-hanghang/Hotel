package vo.mainfrm;
/**
 * �˿� ��Ա �˿����� VO
 * **/
public class CustomerVO {
	private String CustomerID;  //�˿ͱ��
	private String CustomerName; //�˿�����
	private String CustomerSex;  //�˿����ͱ��
	private String CustomerTel;  //�˿��ֻ�����
	private String CustomerCID;  //�˿����֤����
	private String MemberId;     //�˿����ͱ��
	private String MemberName;    //�˿���������
	private String MemberCount;   //�˿��ۿ�
	private String VipId;         //��Ա���

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
