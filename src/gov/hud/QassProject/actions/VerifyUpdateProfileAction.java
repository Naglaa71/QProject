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

public class VerifyUpdateProfileAction extends ActionSupport implements  SessionAware{
	
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
		
		int myResult = 0;
		
		if (session.get("TranType") == "Update"){
			myResult = auditFirm.updateAuditFirmObject(this.getAuditFirm(),(String)session.get("userName"),(String)session.get("audit_firm_type"));
		}else if (session.get("TranType") == "Create"){
			myResult = auditFirm.insertAuditFirmObject(this.getAuditFirm(),(String)session.get("userName"),(String)session.get("audit_firm_type"));
		}
		
		
		if ( myResult > 0 )
		{
			auditFirm.setAudit_firm_id(this.getAuditFirm().getAudit_firm_id());
			String formatedPhoneNumber =  "("+ this.getAuditFirm().getAudit_firm_phone_num().substring(0, 3) + ") "+ 
					this.getAuditFirm().getAudit_firm_phone_num().substring(3, 6) + " - "+
					this.getAuditFirm().getAudit_firm_phone_num().substring(6, 10);
			auditFirm.setAudit_firm_phone_num(formatedPhoneNumber);
			if (this.getAuditFirm().getAuditor_contact_phone_num().length() == 10){
				String formatedContactNumber =  "("+ this.getAuditFirm().getAuditor_contact_phone_num().substring(0, 3) + ") "+ 
						this.getAuditFirm().getAuditor_contact_phone_num().substring(3, 6) + " - "+
						this.getAuditFirm().getAuditor_contact_phone_num().substring(6, 10);
				auditFirm.setAuditor_contact_phone_num(formatedContactNumber);
			}
			if (this.getAuditFirm().getAuditor_contact_phone_ext_num().length() == 10){
				String formatedContactExt =  "("+ this.getAuditFirm().getAuditor_contact_phone_ext_num().substring(0, 3) + ") "+ 
						this.getAuditFirm().getAuditor_contact_phone_ext_num().substring(3, 6) + " - "+
						this.getAuditFirm().getAuditor_contact_phone_ext_num().substring(6, 10);
				auditFirm.setAuditor_contact_phone_ext_num(formatedContactExt);
			}
			if (this.getAuditFirm().getAuditor_contact_fax_num().length() == 10){
				String formatedContactfax =  "("+ this.getAuditFirm().getAuditor_contact_fax_num().substring(0, 3) + ") "+ 
						this.getAuditFirm().getAuditor_contact_fax_num().substring(3, 6) + " - "+
						this.getAuditFirm().getAuditor_contact_fax_num().substring(6, 10);
				auditFirm.setAuditor_contact_fax_num(formatedContactfax);
			}
			 return SUCCESS;

		}else
		{
			System.out.println("something wrong with the data .... data not saved into database");
			return "failure";
		}
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

}
