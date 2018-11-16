package control.mainfrm.consume.zidingyi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.mainfrm.consume.MDLFrmConsume;
import view.mainfrm.consume.FrmConsume;
import view.mainfrm.consume.zidingyi.DlgZidingyi;
import vo.consumeaout.FoodVO;

public class LsnrZiDingYi implements ActionListener {

	private DlgZidingyi dlgZidingyi;
	private MDLFrmConsume mdlConsume = new MDLFrmConsume();
	public static int kucun;

	FoodVO vo = new FoodVO();

	public LsnrZiDingYi(DlgZidingyi dlgZidingyi) {
		this.dlgZidingyi = dlgZidingyi;
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// 确定按钮的监听器
		if (dlgZidingyi.getBtnQueDing().equals(o)) {
			if (dlgZidingyi.getTxtShangPinMing().getText().equals("")) {
				JOptionPane.showMessageDialog(dlgZidingyi, "请输入商品名！");
				return;
			} else if (dlgZidingyi.getTxtShuLiang().getText().equals("")) {
				JOptionPane.showMessageDialog(dlgZidingyi, "请输入购买数量！");
				return;
			} else {
				// Hashtable ht1 = LsnrBtnChaZhao.kucun;
				// dlgZidingyi.getTxtDanJia().setText(Double.toString(danJia));

				double danJia = Double.valueOf(dlgZidingyi.getTxtDanJia().getText());
				int shuLiang = Integer.parseInt(dlgZidingyi.getTxtShuLiang().getText());

				FrmConsume frmConsume = (FrmConsume) this.dlgZidingyi.getOwner();

				JTable tblShangPin = frmConsume.getTblShangPin();
				JTable tblGouMai = frmConsume.getTblGouMai();

				if (shuLiang > kucun) {
					JOptionPane.showMessageDialog(dlgZidingyi, "库存不足！仅余" + kucun);
					return;
				}

				//Vector resultVector = new Vector();

				Vector v = new Vector();
				for (int i = 0; i <= tblGouMai.getRowCount(); i++) {
					if (i == frmConsume.getTblGouMai().getRowCount()) {
						v.add(frmConsume.getTxtFangJianHao().getText());
						v.add(dlgZidingyi.getTxtShangPinMing().getText());
						v.add(shuLiang);
						v.add(danJia * shuLiang);
						v.add(frmConsume.getLblTime().getText());
						frmConsume.resultVector.add(v);
						
						Object[] columnNames = frmConsume.getGouMaiColumnNames();
						Vector columnNamesV = new Vector();

						for (int k = 0; k < columnNames.length; k++) {
							columnNamesV.add(columnNames[k]);
						}
						frmConsume.setModel2(new DefaultTableModel(frmConsume.resultVector, columnNamesV));  //= new DefaultTableModel(frmConsume.resultVector, columnNamesV);				
						frmConsume.getTblGouMai().setModel(frmConsume.getModel2());
						int row = tblShangPin.getSelectedRow();
						int k = (int) tblShangPin.getValueAt(row, 3);
						int liang = (int) tblGouMai.getValueAt(i, 2);
						tblShangPin.setValueAt(k-liang, row,3);
						this.dlgZidingyi.dispose();
						break;
					}	
					if (dlgZidingyi.getTxtShangPinMing().getText().equals(tblGouMai.getValueAt(i, 1))) {
						int shu = (int) tblGouMai.getValueAt(i, 2);
						double jinE = (double) tblGouMai.getValueAt(i, 3);
						tblGouMai.setValueAt(shu + shuLiang, i, 2);
						tblGouMai.setValueAt(jinE + danJia * shuLiang, i, 3);
						int row = tblShangPin.getSelectedRow();
						int k = (int) tblShangPin.getValueAt(row, 3);
						int liang = (int) tblGouMai.getValueAt(i, 2);
						tblShangPin.setValueAt(k-liang, row,3);
						System.out.println(row);
						System.out.println(k);
						System.out.println(liang);
						this.dlgZidingyi.dispose();
						break;
					}
				}

			}
		}
		// 根据商品名查询单价的监听器
		if (dlgZidingyi.getTxtShangPinMing().equals(o)) {

			if (dlgZidingyi.getTxtShangPinMing().getText().equals("")
					&& dlgZidingyi.getTxtShangPinMing().getText().matches("[\\u4e00-\\u9fa5]*")) {
				String msg = "请输入正确商品名";
				JOptionPane.showConfirmDialog(null, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
			} else {
				vo.setFood_name(dlgZidingyi.getTxtShangPinMing().getText());
				Vector resultVector = mdlConsume.chaZhaoShangPin(vo);
				if (resultVector.size() == 0) {
					String msg = "本酒店木有该商品";
					JOptionPane.showConfirmDialog(dlgZidingyi, msg, "提示", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
				} else {
					// 根据商品名查询商品信息
					Iterator it = resultVector.iterator();
					Vector v = (Vector) it.next();
					String danjia = Double.toString((Double) v.get(2));
					kucun = (int) v.get(3);
					dlgZidingyi.getTxtDanJia().setText(danjia);
				}
			}
		}
	}
}
	
