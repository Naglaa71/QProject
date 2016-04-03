package gov.hud.QassProject.actions;

import com.opensymphony.xwork2.ActionSupport;

public class SelectClassificationAction extends ActionSupport {
	private String audit_tax_type ;
	
	
	public String getAudit_tax_type() {
		return audit_tax_type;
	}

	public void setAudit_tax_type(String audit_tax_type) {
		this.audit_tax_type = audit_tax_type;
	}

	
	public String registerIPA(){
		this.setAudit_tax_type("IPA");
		return SUCCESS;
	}
	public String registerSAO(){
		this.setAudit_tax_type("SAO");
		return SUCCESS;
	}
}
