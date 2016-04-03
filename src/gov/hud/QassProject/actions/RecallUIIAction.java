package gov.hud.QassProject.actions;

import gov.hud.QassProject.model.AuditFirmForRecall;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class RecallUIIAction extends ActionSupport implements  SessionAware{
	private Map<String,Object> session;
	private String audit_firm_tax_id;
	private String audit_firm_zip_code;
	private AuditFirmForRecall auditFirm ;
	
	
	
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

	public AuditFirmForRecall getAuditFirm() {
		return auditFirm;
	}

	public void setAuditFirm(AuditFirmForRecall auditFirm) {
		this.auditFirm = auditFirm;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public String execute() throws Exception {
		String formatedPhoneNumber= null;
		AuditFirmForRecall myAuditFirm = (new AuditFirmForRecall()).getAuditFirmObjectNoStates(this.getAudit_firm_tax_id(), this.getAudit_firm_zip_code());
	    this.setAuditFirm(myAuditFirm);
		 
		
	      if (this.getAuditFirm().getAudit_firm_id() != null ){
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
	      if (this.getAuditFirm().getMyErrorMsg() != null ){
				addActionError(this.getAuditFirm().getMyErrorMsg());
			}
	      return INPUT;
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
