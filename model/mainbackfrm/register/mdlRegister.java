package model.mainbackfrm.register;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

import dao.mainback.register.jdbcRegisterManage;
import vo.mainback.Register;

/**
 * 业务逻辑 处理登录表中数据 增删查改
 * 
 * @author 张航
 * @date 2018.10.22
 * 
 */
public class mdlRegister {
	private jdbcRegisterManage jm = new jdbcRegisterManage();

	// 查询所有员工
	public Vector findAllEmployee() {
		return jm.findAllEmployee();
	}

	// 姓名模糊查询
	public Vector selectEemployeeName(Register vo) {
		return jm.selectEemployeeName(vo);
	}

	// 编号模糊查询
	public Vector selectEmployeeId(Register vo) {
		return jm.selectEmployeeId(vo);
	}

	// 姓名和编号模糊查询
	public Vector SelectNameID(Register vo) {
		return jm.selectEmployeeNameId(vo);
	}

	// 插入登录表数据
	public void insertRegister(Register vo) {
		jm.insertRegister(vo);
	}

	// 跟新登录状态为1
	public void updateOnLine(Register vo) {
		jm.updatelogState1(vo);
	}

	// 跟新登录状态为0
	public void updateOutLine(Register vo) {
		jm.updatelogState0(vo);
	}

	// 更改密码
	public void updatelogPassWord(Register vo) {
		jm.updatelogPassWord(vo);
	}

	// 删除登录表
	public void deleteLogByFK(Register vo) {
		jm.deleteLogByFK(vo);
	}
	//查询所有密码为空的员工号
	public TreeSet selectAllLogPwdNull(){
		return jm.SelectpwdNull();
	}
	//查询所有密码不为空的员工号
	public TreeSet  selectAllLogPwdNotNull(){
		return jm.SelectpwdNotNull();
	}
}
