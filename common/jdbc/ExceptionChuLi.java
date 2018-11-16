package common.jdbc;

import javax.swing.JOptionPane;

/**
 * 异常的处理
 * @author 吴阿龙
 *
 */
public class ExceptionChuLi extends RuntimeException {

	public static void DeteclChuLi() {
		String msg = "其他功能模块有该记录，不能进行删除";
		JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE);

	}
}
