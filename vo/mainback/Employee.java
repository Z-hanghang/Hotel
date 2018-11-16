package vo.mainback;

import java.util.Date;
/**
 * Employee （员工类）
 *
 * @author 张航
 * @date 2018.10.15
 * @version v1.0
 */
public class Employee {
    //员工编号
    private String employeeId;
    //员工类型编号
    private String emtypeId;
    //员工姓名
    private String employeeName;
    //员工生日
    private Date  employeeBrithday;
    //员工性别
    private String  employeeSex;
    //员工电话
    private String  employeeTel;
    //员工身份证
    private String employeeEid;
    //员工类型名字
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
