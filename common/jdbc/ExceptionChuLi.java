package common.jdbc;

import javax.swing.JOptionPane;

/**
 * �쳣�Ĵ���
 * @author �Ⱒ��
 *
 */
public class ExceptionChuLi extends RuntimeException {

	public static void DeteclChuLi() {
		String msg = "��������ģ���иü�¼�����ܽ���ɾ��";
		JOptionPane.showConfirmDialog(null, msg, "��ʾ", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);

	}
}
