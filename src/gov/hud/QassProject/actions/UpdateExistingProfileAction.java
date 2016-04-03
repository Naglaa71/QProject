package gov.hud.QassProject.actions;

import gov.hud.QassProject.model.AuditFirm;
import gov.hud.QassProject.model.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Map;
import oracle.jdbc.OracleTypes;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateExistingProfileAction extends ActionSupport implements  SessionAware{
	private Map<String,Object> session;
	private String audit_firm_id;
	private String audit_firm_tax_id;
	private String audit_firm_zip_code;
	private AuditFirm auditFirm ;
	private ArrayList<String> states;
	
	
	

	public String getAudit_firm_id() {
		return audit_firm_id;
	}

	public void setAudit_firm_id(String audit_firm_id) {
		this.audit_firm_id = audit_firm_id;
	}

	public ArrayList<String> getStates() {
		return states;
	}

	public void setStates(ArrayList<String> states) {
		this.states = states;
	}

	public String getAudit_firm_tax_id() {
		return audit_firm_tax_id;
	}

	public void setAudit_firm_tax_id(String audit_firm_tax_id) {
		this.audit_firm_tax_id = audit_firm_tax_id;
	}

	public String getAudit_firm_zip_code() {
		return audit_firm_zip_code;
	}

	public void setAudit_firm_zip_code(String audit_firm_zip_code) {
		this.audit_firm_zip_code = audit_firm_zip_code;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public AuditFirm getAuditFirm() {
		return auditFirm;
	}

	public void setAuditFirm(AuditFirm auditFirm) {
		this.auditFirm = auditFirm;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public String execute() throws Exception {
		
		AuditFirm myAuditFirm = (new AuditFirm()).getAuditFirmObject4(this.getAudit_firm_id(),this.getAudit_firm_tax_id(), this.getAudit_firm_zip_code());
	    this.setAuditFirm(myAuditFirm);
		 
		if (this.getAuditFirm().getMyErrorMsg() != null ){
			addActionError(this.getAuditFirm().getMyErrorMsg());
			return INPUT;
		}else
		{
			session.put("TranType", "Update");
			myAuditFirm.getStates().set(0,this.getAuditFirm().getAudit_firm_state());
			myAuditFirm.getStates().add(this.getAuditFirm().getAudit_firm_state());
			this.setStates(myAuditFirm.getStates());
			return SUCCESS;
		}
		
		
	}

	

}
