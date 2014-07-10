package controllers;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.LoginDao;

public class LoginAction extends ActionSupport implements SessionAware  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dni;
	private String password;
	private  Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String validateLogin() {

		System.out.println("salida" + dni +"-" +password);
		
		if(LoginDao.validate(dni, password)){
			return SUCCESS;
		}
		return ERROR;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Map<String, Object> getSession() {
		return session;
	}
}
