package vo.mainback;
/*µÇÂ¼±í*/
public class Register implements Comparable<Register> {
 private String employeeId;
 private String employeeName;
 private String registerPassword;

 private String employeeState;
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getRegisterPassword() {
	return registerPassword;
}
public void setRegisterPassword(String registerPassword) {
	this.registerPassword = registerPassword;
}

public String getEmployeeState() {
	return employeeState;
}
public void setEmployeeState(String employeeState) {
	this.employeeState = employeeState;
}

public int compareTo(Register o) {
	int a=Integer.parseInt(this.employeeId.substring(2, 6));
	int b=Integer.parseInt(o.employeeId.substring(2, 6));
	int num=a-b;
	return num;
}

}
