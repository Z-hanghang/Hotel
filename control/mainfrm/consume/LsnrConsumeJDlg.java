package control.mainfrm.consume;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import common.component.tools.HotelTools;
import control.mainfrm.consume.zidingyi.LsnrZiDingYi;
import model.mainfrm.consume.MDLFrmConsume;
import view.mainfrm.account.FrmAccount;
import view.mainfrm.consume.FrmConsume;
import view.mainfrm.consume.zidingyi.DlgZidingyi;
import vo.consumeaout.ConsumeVO;
import vo.consumeaout.FoodVO;
import vo.consumeaout.FoodstockVO;
import vo.consumeaout.ResideVO;

public class LsnrConsumeJDlg implements ActionListener {
	private FrmConsume frmConsume;
	private MDLFrmConsume mdlConsume = new MDLFrmConsume();
//	public static int kc;

	// public static Hashtable shangping = new Hashtable();
	// public static Hashtable kucun = new Hashtable();

	public LsnrConsumeJDlg(FrmConsume frmConsume) {
		this.frmConsume = frmConsume;
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (frmConsume.getBtnShuaXin().equals(o)) { // 刷新
			ResideVO vo = new ResideVO();
			vo.setRoom_id(frmConsume.getTxtFangJianHao().getText());
			Vector v = mdlConsume.ruZhu(vo);

			if (v.size() != 0) {
				Iterator iterator = v.iterator();
				String str1 = (String) iterator.next();
				frmConsume.getTxtRuZhuShiJian().setText(str1);
				iterator.hasNext();
				String str2 = (String) iterator.next();
				frmConsume.getTxtXiaoFeiZongE().setText(str2);
				iterator.hasNext();
				String str3 = (String) iterator.next();
				frmConsume.getTxtYaJin().setText(str3);
			} else {
				frmConsume.getTxtRuZhuShiJian().setText("");
				frmConsume.getTxtXiaoFeiZongE().setText("");
				frmConsume.getTxtYaJin().setText("");
			}
			removeGouMai();
			return;
		}
		if (frmConsume.getBtnChaZhao().equals(o)) { // 查找按钮
			FoodVO vo = new FoodVO();
			vo.setFood_name(this.frmConsume.getTxtShangPinMing().getText());

			Vector resultVector = mdlConsume.chaZhaoShangPin(vo);
			// 刷新商品表
			Object[] shangPinColumnNames = this.frmConsume.getShangPinColumnNames();

			Vector columnNamesV = new Vector();
			for (int i = 0; i < shangPinColumnNames.length; i++) {
				columnNamesV.add(shangPinColumnNames[i]);
			}

			frmConsume.getTblShangPin().setModel(new DefaultTableModel(resultVector, columnNamesV));
		}
		if (frmConsume.getBtnZiDingYi().equals(o)) { // 自定义按钮
			if (frmConsume.getTxtFangJianHao().getText().equals("")) {
				JOptionPane.showMessageDialog(frmConsume, "请输入房间号！");
				return;
			}
			if (frmConsume.getTxtRuZhuShiJian().getText().equals("")) {
				JOptionPane.showMessageDialog(frmConsume, "空住房！");
				return;
			}

			JTable tblShangPin = frmConsume.getTblShangPin();

			int row = tblShangPin.getSelectedRow();

			if (row == -1) {
				new DlgZidingyi(this.frmConsume, "自定义消费", true, "消费").setVisible(true);
			} else {
				DlgZidingyi dlgZidingyi = new DlgZidingyi(this.frmConsume, "自定义消费", true, "消费");
				dlgZidingyi.getTxtShangPinMing().setText((String) tblShangPin.getValueAt(row, 1));
				dlgZidingyi.getTxtDanJia().setText(Double.toString((double) tblShangPin.getValueAt(row, 2)));
				LsnrZiDingYi.kucun=(int) tblShangPin.getValueAt(row, 3);
				dlgZidingyi.setVisible(true);
			}
		}
		if (frmConsume.getBtnShanChu().equals(o)) { // 删除按钮
			JTable tblGouMai = frmConsume.getTblGouMai();
			int gouMaiRow = tblGouMai.getSelectedRow();
			if (gouMaiRow == -1) {
				String msg = "请在已购买商品选中一行数据";
				JOptionPane.showConfirmDialog(frmConsume, msg, "提示", JOptionPane.WARNING_MESSAGE);
			} else {
				frmConsume.getModel2().removeRow(gouMaiRow);
			}
			return;
		}
		if (frmConsume.getBtnRuZhang().equals(o)) { // 入账结算
			ConsumeVO vo = new ConsumeVO();   // 消费VO
			ResideVO vo2 = new ResideVO();   // 入住VO
			FoodVO vo3 = new FoodVO();       //商品VO
			FoodstockVO vo4 = new FoodstockVO();       //  库存VO 
			JTable tblGouMai = frmConsume.getTblGouMai();

			if (tblGouMai.getRowCount() == 0) {
				String msg = "请添加购买商品";
				JOptionPane.showConfirmDialog(frmConsume, msg, "提示", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String roomID = frmConsume.getTxtFangJianHao().getText();
			vo.setRoom_id(roomID);
			vo2.setRoom_id(roomID);
			String coustomerID = mdlConsume.findCustomerM(vo2);
			vo.setCustomer_id(coustomerID);

			Vector resultVector = mdlConsume.findRoomConsumeMe(vo);

			for (int i = 0; i < tblGouMai.getRowCount(); i++) { 
				//如果没有查询到消费信息
				if (resultVector.size() == 0) {                                  
					vo3.setFood_name((String)tblGouMai.getValueAt(i, 1));
					vo.setFood_id(mdlConsume.findFoodId(vo3));

					vo.setConsume_number((int)tblGouMai.getValueAt(i, 2));

					vo.setConsume_state("0");
					vo.setCustomer_count((Double)tblGouMai.getValueAt(i, 3));
					//查找商品的库存量
					Vector reVector = mdlConsume.chaZhaoShangPin(vo3);      
					Iterator it = reVector.iterator();
					Vector v = (Vector) it.next();
					int kucun = (int) v.get(3);	
					if((int)tblGouMai.getValueAt(i, 2)>kucun) {
						JOptionPane.showMessageDialog(frmConsume, "库存不足,库存数量仅为："+kucun+"请重新输入正确数量");
						return;
					}
					vo3.setFood_id(mdlConsume.findFoodId(vo3));
					vo4.setFoodstock_amount(kucun-(int)tblGouMai.getValueAt(i, 2));
					
					mdlConsume.updateFoodStock(vo3, vo4);
					mdlConsume.insertConsume(vo);
				} else {  
					//String[] str = new String[resultVector.size()];
					Hashtable<String, Integer> h = new Hashtable<String, Integer>();
					Double[] foodpiece = new Double[resultVector.size()];
					int k = 0;
					for (Iterator it = resultVector.iterator(); it.hasNext();) {
						Vector v = (Vector) it.next();
						h.put((String)v.get(0), Integer.parseInt((String)v.get(1)));
						foodpiece[k] = Double.valueOf((String)v.get(2));
						k++;
					}
					
					if (h.containsKey(tblGouMai.getValueAt(i, 1))) {      // 查找到匹配的
						vo3.setFood_name((String)tblGouMai.getValueAt(i, 1));
						vo.setFood_id(mdlConsume.findFoodId(vo3));
						int c=(int)tblGouMai.getValueAt(i, 2);
						int zongshu=h.get(tblGouMai.getValueAt(i, 1))+c;
						vo.setConsume_number(zongshu);

						Double jine = (Double)tblGouMai.getValueAt(i, 3);
						vo.setCustomer_count(foodpiece[i]+jine);
						//查找商品的库存量
						Vector reVector = mdlConsume.chaZhaoShangPin(vo3);      
						Iterator it = reVector.iterator();
						Vector v = (Vector) it.next();
						int kucun = (int) v.get(3);	
//						kc=kucun;
						if((int)tblGouMai.getValueAt(i, 2)>kucun) {
							JOptionPane.showMessageDialog(frmConsume, "库存不足,库存数量仅为："+kucun+"请重新输入正确数量");
							return;
						}
						vo3.setFood_id(mdlConsume.findFoodId(vo3));
						vo4.setFoodstock_amount(kucun-zongshu);
						
						mdlConsume.updateFoodStock(vo3, vo4);
						mdlConsume.updateConsume(vo);
						
						frmConsume.dispose();
					} else {                                                        // 没有匹配的          
							vo3.setFood_name((String)tblGouMai.getValueAt(i, 1));
							vo.setFood_id(mdlConsume.findFoodId(vo3));
							vo.setConsume_number((int)tblGouMai.getValueAt(i, 2));
							vo.setConsume_state("0");
							vo.setCustomer_count((Double)tblGouMai.getValueAt(i, 3));
							//查找商品的库存量
							
							Vector reVector = mdlConsume.chaZhaoShangPin(vo3);      
							Iterator it = reVector.iterator();
							Vector v = (Vector) it.next();
							int kucun = (int) v.get(3);	
//							kc=kucun;
							if((int)tblGouMai.getValueAt(i, 2)>kucun) {
								JOptionPane.showMessageDialog(frmConsume, "库存不足,库存数量仅为："+kucun+"请重新输入正确数量");
								return;
							}
							vo3.setFood_id(mdlConsume.findFoodId(vo3));
							vo4.setFoodstock_amount(kucun-(int)tblGouMai.getValueAt(i, 2));
							mdlConsume.updateFoodStock(vo3, vo4);
							mdlConsume.insertConsume(vo);
					}
				}
			}
			removeGouMai();
			return;
		}
		if (frmConsume.getBtnGuanBi().equals(o)) { // 取消关闭
			frmConsume.dispose();
			removeGouMai();
			return;
		}
		if (frmConsume.getBtnJieSuan().equals(o)) { // 退房结算
			FrmAccount frmAccount = new FrmAccount(null, "退房结算", true);
			String jiesuanId = HotelTools.getNumber(HotelTools.AC);
			frmAccount.getTxtJieZhangDanHao().setText(jiesuanId);;
			frmAccount.getTxtZhuKeFangJian().setText(frmConsume.getTxtFangJianHao().getText());
			frmAccount.setVisible(true);
			removeGouMai();
			return;

		}
    }

	public void removeGouMai() {
		int count = frmConsume.getTblGouMai().getRowCount();
		if(count==0) {
			return;
		}else {
			for (int i = 0; i <= count;) {
				if(frmConsume.getTblGouMai().getRowCount()==0) {
					return;
				}
				frmConsume.getModel2().removeRow(i);	
			}
		}
		return;	
	}
}
