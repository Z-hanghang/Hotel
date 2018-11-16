/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logfrm.login;

import java.io.PrintStream;
import dao.logfrm.loginSelect.Jdbclogin;
import vo.mainback.Manager;
import vo.mainback.Register;

/**
 * 业务逻辑处理 
 *
 * @author 张航
 */
public  class Login {
	
	public Register frontLog(String id, String pwd){
		return new Jdbclogin().findUser(id, pwd);
	}
  
	public Manager backLog(String id, String pwd){
		return new Jdbclogin().findManager(id, pwd);
	}

	
   
  
}
