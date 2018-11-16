package model.mainbackfrm.register;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

import dao.mainback.register.jdbcRegisterManage;
import vo.mainback.Register;

/**
 * ҵ���߼� �����¼�������� ��ɾ���
 * 
 * @author �ź�
 * @date 2018.10.22
 * 
 */
public class mdlRegister {
	private jdbcRegisterManage jm = new jdbcRegisterManage();

	// ��ѯ����Ա��
	public Vector findAllEmployee() {
		return jm.findAllEmployee();
	}

	// ����ģ����ѯ
	public Vector selectEemployeeName(Register vo) {
		return jm.selectEemployeeName(vo);
	}

	// ���ģ����ѯ
	public Vector selectEmployeeId(Register vo) {
		return jm.selectEmployeeId(vo);
	}

	// �����ͱ��ģ����ѯ
	public Vector SelectNameID(Register vo) {
		return jm.selectEmployeeNameId(vo);
	}

	// �����¼������
	public void insertRegister(Register vo) {
		jm.insertRegister(vo);
	}

	// ���µ�¼״̬Ϊ1
	public void updateOnLine(Register vo) {
		jm.updatelogState1(vo);
	}

	// ���µ�¼״̬Ϊ0
	public void updateOutLine(Register vo) {
		jm.updatelogState0(vo);
	}

	// ��������
	public void updatelogPassWord(Register vo) {
		jm.updatelogPassWord(vo);
	}

	// ɾ����¼��
	public void deleteLogByFK(Register vo) {
		jm.deleteLogByFK(vo);
	}
	//��ѯ��������Ϊ�յ�Ա����
	public TreeSet selectAllLogPwdNull(){
		return jm.SelectpwdNull();
	}
	//��ѯ�������벻Ϊ�յ�Ա����
	public TreeSet  selectAllLogPwdNotNull(){
		return jm.SelectpwdNotNull();
	}
}
