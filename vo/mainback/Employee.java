package vo.mainback;

import java.util.Date;
/**
 * Employee ��Ա���ࣩ
 *
 * @author �ź�
 * @date 2018.10.15
 * @version v1.0
 */
public class Employee {
    //Ա�����
    private String employeeId;
    //Ա�����ͱ��
    private String emtypeId;
    //Ա������
    private String employeeName;
    //Ա������
    private Date  employeeBrithday;
    //Ա���Ա�
    private String  employeeSex;
    //Ա���绰
    private String  employeeTel;
    //Ա�����֤
    private String employeeEid;
    //Ա����������
   private String emtypeName;

    public String getEmtypeName() {
		return emtypeName;
	}

	public void setEmtypeName(String emtypeName) {
		this.emtypeName = emtypeName;
	}
  
	public String getEmployeeId() {
        return employeeId;
    }

    public String getEmtypeId() {
        return emtypeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Date getEmployeeBrithday() {
        return employeeBrithday;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public String getEmployeeTel() {
        return employeeTel;
    }

    public String getEmployeeEid() {
        return employeeEid;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmtypeId(String emtypeId) {
        this.emtypeId = emtypeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeBrithday(Date employeeBrithday) {
        this.employeeBrithday = employeeBrithday;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public void setEmployeeTel(String employeeTel) {
        this.employeeTel = employeeTel;
    }

    public void setEmployeeEid(String employeeEid) {
        this.employeeEid = employeeEid;
    }

}
