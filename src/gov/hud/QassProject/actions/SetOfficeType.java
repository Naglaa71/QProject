package gov.hud.QassProject.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SetOfficeType extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String audit_firm_type;
	private Map<String, Object> session;

	public String getAudit_firm_type() {
		return audit_firm_type;
	}

	public void setAudit_firm_type(String audit_tax_type) {
		this.audit_firm_type = audit_tax_type;
	}
	
	public String setOfficeTypeIPA(){
		this.setAudit_firm_type("ipa");
		session.put("audit_firm_type",this.getAudit_firm_type());
		return SUCCESS;
	}

	public String setOfficeTypeSAO(){
		this.setAudit_firm_type("sao");
		session.put("audit_firm_type",this.getAudit_firm_type());
		return SUCCESS;
	}
	
	public String setOfficeTypeRecallIPA(){
		this.setAudit_firm_type("ipa");
		session.put("audit_firm_type",this.getAudit_firm_type());
		return SUCCESS;
	}

	public String setOfficeTypeRecallSAO(){
		this.setAudit_firm_type("sao");
		session.put("audit_firm_type",this.getAudit_firm_type());
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

}
