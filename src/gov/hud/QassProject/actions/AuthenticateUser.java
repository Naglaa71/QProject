package gov.hud.QassProject.actions; 

import java.sql.*; 
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport; 











import gov.hud.QassProject.model.*;

public class AuthenticateUser extends ActionSupport implements ServletRequestAware, ServletResponseAware , ServletContextAware , SessionAware{
	private String userName;
	private String password;
	private String userType;
	private ServletContext servletContext;
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;
	private Map<String, Object> session;
	
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String execute() throws SQLException, NamingException{
		Connection conn= null;
		CallableStatement pstmt=null;
		String myPassword = null;
		String myUserType = null;
		try {
				conn = (new DBConnection()).getConnection();
				pstmt = conn.prepareCall("{call get_user_password(?,?,?)}");
		
				 pstmt.setString(1, this.getUserName());
				 pstmt.registerOutParameter(2, Types.VARCHAR);
				 pstmt.registerOutParameter(3, Types.VARCHAR);
				 pstmt.executeUpdate();

				 myPassword = pstmt.getString(2);
				 myUserType = pstmt.getString(3);
				 this.setUserType(myUserType);
				 
				// System.out.print("The myUserType is  " +myUserType + " the entered user type is " + this.getUserType());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			if (pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
				 session.put("userType", this.getUserType());
				 session.put("userName", this.getUserName());
				 
		if (myPassword.equals(this.getPassword()))
		{
			return SUCCESS;

		}else
		{
			addActionError("Invalid UserName Or Password.");
			return INPUT;
		}
	}
	
	public void validate(){
		
		if(userName == null || userName.trim().equals("") ){
			addFieldError("userName", " User Name can't be blank.");
		}
		if(password == null || password.trim().equals("") ){
			addFieldError("password", " password Field can't be blank.");
		}
	}
	
	public String goToeXternalMenu(){
		return SUCCESS ;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext ;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
		
	}

}
