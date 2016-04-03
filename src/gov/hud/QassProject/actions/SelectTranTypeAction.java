package gov.hud.QassProject.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SelectTranTypeAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public String createNewProfile(){
		session.put("TranType", "Create");
		return SUCCESS;
	}
	
	public String updateExistingProfile(){
		session.put("TranType", "Update");
		return SUCCESS;
	}
	
	public String recallUIIProfile(){
		session.put("TranType", "RecallUII");
		return SUCCESS;
	}
	
}
