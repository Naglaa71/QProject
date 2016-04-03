package gov.hud.QassProject.actions;

import gov.hud.QassProject.model.AuditFirm;
import gov.hud.QassProject.model.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class VerifyProfileAction extends ActionSupport implements  SessionAware{
	
	private AuditFirm auditFirm;
	private static final long serialVersionUID = 1L;
	private Map<String,Object> session;
		
	public AuditFirm getAuditFirm() {
		return auditFirm;
	}

	public void setAuditFirm(AuditFirm auditFirm) {
		this.auditFirm = auditFirm;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String execute() throws SQLException, NamingException{
		String formatedPhoneNumber= null;
		int myResult = 0;
		
		if (session.get("TranType") == "Update"){
			myResult = auditFirm.updateAuditFirmObject(this.getAuditFirm(),(String)session.get("userName"),(String)session.get("audit_firm_type"));
		}else if (session.get("TranType") == "Create"){
			myResult = auditFirm.insertAuditFirmObject(this.getAuditFirm(),(String)session.get("userName"),(String)session.get("audit_firm_type"));
		}
		
		
		if ( myResult > 0 )
		{
			auditFirm.setAudit_firm_id(this.getAuditFirm().getAudit_firm_id());
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

		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
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
		return formatedPhoneNumber;
	}

}
