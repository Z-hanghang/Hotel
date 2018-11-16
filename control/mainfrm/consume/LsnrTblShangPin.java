package control.mainfrm.consume;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import view.mainfrm.consume.FrmConsume;


public class LsnrTblShangPin extends MouseAdapter {

	private FrmConsume frmConsume;
	//private static Vector resultVector = new Vector();
	public static int oldKuCun;
	
	public LsnrTblShangPin(FrmConsume frmConsume){
		
		this.frmConsume = frmConsume;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		int row = frmConsume.getTblShangPin().getSelectedRow();
		if(arg0.getClickCount() % 2 == 0){
			oldKuCun = (int) this.frmConsume.getTblShangPin().getValueAt(row, 3);
			if(frmConsume.getTxtFangJianHao().getText().equals("")){
				JOptionPane.showMessageDialog(frmConsume, "请输入房间号！");
				return;
			}
			if(frmConsume.getTxtRuZhuShiJian().getText().equals("")){
				JOptionPane.showMessageDialog(frmConsume, "空住房！");
				return;
			}
			if(oldKuCun == 0){
				JOptionPane.showMessageDialog(frmConsume, "商品'" + this.frmConsume.getTblShangPin().getValueAt(row, 1) + "'库存为0！！");
			}else{
				int newKuCun = oldKuCun - 1;
				DefaultTableModel dtmShangPin = (DefaultTableModel)this.frmConsume.getTblShangPin().getModel();
				dtmShangPin.setValueAt(newKuCun, row, 3);
				this.frmConsume.getTblShangPin().setModel(dtmShangPin);
				
				Vector v = new Vector();
				
				for(int i = 0; i <= frmConsume.getTblGouMai().getRowCount(); i++){
					if(i == frmConsume.getTblGouMai().getRowCount()){
						v.add(frmConsume.getTxtFangJianHao().getText());
						v.add(frmConsume.getTblShangPin().getValueAt(row, 1));
						v.add(1);
						v.add(frmConsume.getTblShangPin().getValueAt(row, 2));
						v.add(frmConsume.getLblTime().getText());
						frmConsume.resultVector.add(v);
						break;
					}
					if(frmConsume.getTblShangPin().getValueAt(row, 1).equals(frmConsume.getTblGouMai().getValueAt(i, 1))){
						int shuliang = (int) frmConsume.getTblGouMai().getValueAt(i, 2);
						double jinE = (double) frmConsume.getTblGouMai().getValueAt(i, 3);
						double danJia = (double) frmConsume.getTblShangPin().getValueAt(row, 2);
						frmConsume.getTblGouMai().setValueAt(shuliang + 1, i, 2);
						frmConsume.getTblGouMai().setValueAt(jinE + danJia, i, 3);
						break;
					}
				}
				
				Object[] columnNames = this.frmConsume.getGouMaiColumnNames();
				Vector columnNamesV = new Vector();
				
				for(int i = 0; i < columnNames.length; i++){
					columnNamesV.add(columnNames[i]);
				}
				frmConsume.setModel2(new DefaultTableModel(frmConsume.resultVector, columnNamesV));  //= new DefaultTableModel(frmConsume.resultVector, columnNamesV);				
				this.frmConsume.getTblGouMai().setModel(frmConsume.getModel2());
			}	
		}		
	}

}
