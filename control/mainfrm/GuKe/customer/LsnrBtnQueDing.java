package control.mainfrm.GuKe.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import common.component.tools.HotelTools;
import model.mainfrm.customer.MDLCustomer;
import view.mainfrm.GuKeView.customer.DlgCustomer;
import view.mainfrm.GuKeView.guanli.FrmMain;
import vo.mainfrm.GuKe.Customervo;

/*
 * 实现顾客信息新增功能
 */
public class LsnrBtnQueDing implements ActionListener {
	private DlgCustomer dlgCustomer;
	private FrmMain frmMain;

	private MDLCustomer mdlCustomer = new MDLCustomer();

	//private MDLCustomerGuanLi mdlCustomerGuanLi = new MDLCustomerGuanLi();

	public LsnrBtnQueDing(DlgCustomer dlgCustomer) {
		this.dlgCustomer = dlgCustomer;
	}

	

	public void actionPerformed(ActionEvent e) {
		Customervo vo = new Customervo();

		vo.setCustomerid(this.dlgCustomer.getTxtcustomerid().getText());
		vo.setCustomername(this.dlgCustomer.getTxtcustomername().getText());
		//vo.setCustomersex(this.dlgCustomer.getBoxcustomersex().getToolkit().toString());
		String[] sexes=this.dlgCustomer.getSexes();
		for(String a:sexes) {                        //获取顾客类型性别
		if(dlgCustomer.getBoxcustomersex().getSelectedItem().equals(a)){
			   vo.setCustomersex(""+a);
			   }
		}
		vo.setCustomertel(this.dlgCustomer.getTxtcustomertel().getText());
		vo.setCustomercid(this.dlgCustomer.getTxtcustomercid().getText());
		String[] memberids=this.dlgCustomer.getMembers();
		for(String b:memberids) {                    //获取顾客类型编号
			if(dlgCustomer.getBoxmemberid().getSelectedItem().equals(b)){
				   vo.setMemberid(""+b);
				   }
			}

		String command = this.dlgCustomer.getCommand();
        /*对手机号进行正则匹配*/
		String regex1 = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,1,2,5-9])|(177))\\d{8}$";
		Pattern pattern = Pattern.compile(regex1);
		Matcher matcher = pattern.matcher(vo.getCustomertel());
		/*对身份证进行正则匹配*/
		String regex2 = "(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])";
		Pattern idNumPattern = Pattern.compile(regex2);
		Matcher idNumMatcher = idNumPattern.matcher(vo.getCustomercid());
        /*if(matcher==null){
        	JOptionPane.showMessageDialog(frmMain, "手机号码不能为空！");
        }*/
        if (matcher.matches() == false) {
			JOptionPane.showMessageDialog(frmMain, "请输入正确的手机号码！");
			
			}
       
        /*if( idNumMatcher==null){
        	JOptionPane.showMessageDialog(frmMain, "身份证号码不能为空！");	
        }*/
        if(idNumMatcher.matches() == false&&matcher.matches() == true){
			JOptionPane.showMessageDialog(frmMain, "请输入正确的身份证号码！");
		
		}
		
		
		if (command.equals("1") && matcher.matches() == true&&idNumMatcher.matches()==true) {
			String GD=dlgCustomer.getG();
			HotelTools.savNumber(GD, HotelTools.G);
			mdlCustomer.xinZengCustomer(vo);
			// this.dlgCustomer.dispose();

		} if (command.equals("修改") && matcher.matches() == true&&idNumMatcher.matches()==true) {
			mdlCustomer.gengXinCustomer(vo);
			// this.dlgCustomer.dispose();

		}
		
		// 刷新客户JTable
		FrmMain frmMain = ((FrmMain) this.dlgCustomer.getOwner());
		Vector resultVector = this.mdlCustomer.chaZhaoQuanCustomer();
		Object[] CustomerColumnNames = frmMain.getCustomerColumnNames();

		Vector columnNamesV = new Vector();
		for (int i = 0; i < CustomerColumnNames.length; i++) {
			columnNamesV.add(CustomerColumnNames[i]);
		}

		frmMain.getTblcustomer().setModel(new DefaultTableModel(resultVector, columnNamesV));

	}

}
