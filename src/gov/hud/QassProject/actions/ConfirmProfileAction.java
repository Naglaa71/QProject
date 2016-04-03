package gov.hud.QassProject.actions;

import gov.hud.QassProject.model.AuditFirm;
import gov.hud.QassProject.model.AuditFirmForRecall;
import gov.hud.QassProject.model.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ConfirmProfileAction extends ActionSupport implements  SessionAware{
	
	private AuditFirm auditFirm;
	private ArrayList<String> states;
	private static final long serialVersionUID = 1L;
	private Map<String,Object> session;
	
	
	
	

	public ArrayList<String> getStates() {
		return states;
	}


	public void setStates(ArrayList<String> states) {
		this.states = states;
	}


	public AuditFirm getAuditFirm() {
		return auditFirm;
	}


	public void setAuditFirm(AuditFirm auditFirm) {
		this.auditFirm = auditFirm;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	
	public Map<String, Object> getSession() {
		return session;
	}

	public String execute() throws SQLException{
		String formatedPhoneNumber= null;
		//this.getAuditFirm = the new auditFirm object created by the intercepter where the audiFirm parameter is the 
		// object in the value stack that holds the data entered by the user
		
		
		this.setAuditFirm(auditFirm);
		this.setStates(states);
		this.getAuditFirm().setAudit_firm_state(this.getStates().get(0));
		
		formatedPhoneNumber = formatePhoneNumber(this.getAuditFirm().getAudit_firm_phone_num());
		auditFirm.setAudit_firm_phone_num(formatedPhoneNumber);
		formatedPhoneNumber= null;
		
		formatedPhoneNumber = formatePhoneNumber(this.getAuditFirm().getAuditor_contact_phone_num());
		auditFirm.setAuditor_contact_phone_num(formatedPhoneNumber);
		formatedPhoneNumber= null;
		
		formatedPhoneNumber = formatePhoneNumber(this.getAuditFirm().getAuditor_contact_phone_ext_num());
		auditFirm.setAuditor_contact_phone_ext_num(formatedPhoneNumber);
		formatedPhoneNumber= null;
		
		formatedPhoneNumber = formatePhoneNumber(this.getAuditFirm().getAuditor_contact_fax_num());
		auditFirm.setAuditor_contact_fax_num(formatedPhoneNumber);
		formatedPhoneNumber= null;
		
		
		return SUCCESS;
		
	}


public String formatePhoneNumber(String phoneNumber){
	String formatedPhoneNumber = null;
	if (phoneNumber != null && phoneNumber.length() == 10){
	formatedPhoneNumber =  "("+phoneNumber.substring(0, 3) + ") "+ 
			phoneNumber.substring(3, 6) + " - "+
			phoneNumber.substring(6, 10);
	}else{
		formatedPhoneNumber = phoneNumber;
	}
	//System.out.println(phoneNumber + " =====>>" + formatedPhoneNumber);
	return formatedPhoneNumber;
}
	

}
