package gov.hud.QassProject.actions;

import java.sql.*;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

import gov.hud.QassProject.model.*;

public class LoginAction extends ActionSupport implements ServletContextAware, ServletRequestAware, ServletResponseAware , SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userType;
	private ServletContext  	servletContext;
	private ServletRequest  	servletRequest;
	private ServletResponse 	servletResponse;
	private Map<String,Object> 	session;
	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
		
	}
	
	
	public String chooseUserMenu(){
		String myResult = "";
		this.setUserType((String)session.get("userType"));
		
			
		if (this.getUserType().equals("internal")){
			myResult =  SUCCESS;
		}
		if (this.getUserType().equals("external")){
			myResult = INPUT;
		}
		
		 return myResult;
	}
}