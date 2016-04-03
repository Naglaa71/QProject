package gov.hud.QassProject.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;



public class AuditFirmForRecall {
	private String audit_firm_tax_id;
	private String audit_firm_zip_code;
	private String audit_firm_id;
	private String audit_firm_name;
	private String audit_firm_type;
	private String audit_firm_address_line_1;
	private String audit_firm_address_line_2;
	private String audit_firm_city;
	private String audit_firm_state;
	private String audit_firm_zip_code_ext;
	private String audit_firm_phone_num;
	private String auditor_contact_first_name;			
	private String auditor_contact_middle_name;
	private String auditor_contact_last_name;
	private String auditor_contact_title;
	private String auditor_contact_phone_num;
	private String auditor_contact_phone_ext_num;
	private String auditor_contact_fax_num;
	private String auditor_contact_email ;
	private String myErrorMsg;
	
	

	public String getMyErrorMsg() {
		return myErrorMsg;
	}

	public void setMyErrorMsg(String myErrorMsg) {
		this.myErrorMsg = myErrorMsg;
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
	
	
	
	public String getAudit_firm_id() {
		return audit_firm_id;
	}

	public void setAudit_firm_id(String audit_firm_id) {
		this.audit_firm_id = audit_firm_id;
	}

	public String getAudit_firm_name() {
		return audit_firm_name;
	}

	public void setAudit_firm_name(String audit_firm_name) {
		this.audit_firm_name = audit_firm_name;
	}


	public String getAudit_firm_type() {
		return audit_firm_type;
	}

	public void setAudit_firm_type(String audit_firm_type) {
		this.audit_firm_type = audit_firm_type;
	}

	public String getAudit_firm_address_line_1() {
		return audit_firm_address_line_1;
	}

	public void setAudit_firm_address_line_1(String audit_firm_address_line_1) {
		this.audit_firm_address_line_1 = audit_firm_address_line_1;
	}

	public String getAudit_firm_address_line_2() {
		return audit_firm_address_line_2;
	}

	public void setAudit_firm_address_line_2(String audit_firm_address_line_2) {
		this.audit_firm_address_line_2 = audit_firm_address_line_2;
	}

	public String getAudit_firm_city() {
		return audit_firm_city;
	}

	public void setAudit_firm_city(String audit_firm_city) {
		this.audit_firm_city = audit_firm_city;
	}

	public String getAudit_firm_state() {
		return audit_firm_state;
	}

	public void setAudit_firm_state(String audit_firm_state) {
		this.audit_firm_state = audit_firm_state;
	}

	public String getAudit_firm_zip_code_ext() {
		return audit_firm_zip_code_ext;
	}

	public void setAudit_firm_zip_code_ext(String audit_firm_zip_code_ext) {
		this.audit_firm_zip_code_ext = audit_firm_zip_code_ext;
	}

	public String getAudit_firm_phone_num() {
		return audit_firm_phone_num;
	}

	public void setAudit_firm_phone_num(String audit_firm_phone_num) {
		this.audit_firm_phone_num = audit_firm_phone_num;
	}

	public String getAuditor_contact_first_name() {
		return auditor_contact_first_name;
	}

	public void setAuditor_contact_first_name(String auditor_contact_first_name) {
		this.auditor_contact_first_name = auditor_contact_first_name;
	}

	public String getAuditor_contact_middle_name() {
		return auditor_contact_middle_name;
	}

	public void setAuditor_contact_middle_name(String auditor_contact_middle_name) {
		this.auditor_contact_middle_name = auditor_contact_middle_name;
	}

	public String getAuditor_contact_last_name() {
		return auditor_contact_last_name;
	}

	public void setAuditor_contact_last_name(String auditor_contact_last_name) {
		this.auditor_contact_last_name = auditor_contact_last_name;
	}

	public String getAuditor_contact_title() {
		return auditor_contact_title;
	}

	public void setAuditor_contact_title(String auditor_contact_title) {
		this.auditor_contact_title = auditor_contact_title;
	}

	public String getAuditor_contact_phone_num() {
		return auditor_contact_phone_num;
	}

	public void setAuditor_contact_phone_num(String auditor_contact_phone_num) {
		this.auditor_contact_phone_num = auditor_contact_phone_num;
	}

	public String getAuditor_contact_phone_ext_num() {
		return auditor_contact_phone_ext_num;
	}

	public void setAuditor_contact_phone_ext_num(
			String auditor_contact_phone_ext_num) {
		this.auditor_contact_phone_ext_num = auditor_contact_phone_ext_num;
	}

	public String getAuditor_contact_fax_num() {
		return auditor_contact_fax_num;
	}

	public void setAuditor_contact_fax_num(String auditor_contact_fax_num) {
		this.auditor_contact_fax_num = auditor_contact_fax_num;
	}

	public String getAuditor_contact_email() {
		return auditor_contact_email;
	}

	public void setAuditor_contact_email(String auditor_contact_email) {
		this.auditor_contact_email = auditor_contact_email;
	}

	
	
public AuditFirmForRecall getAuditFirmObjectNoStates(String auditTaxId, String auditZipCode) throws Exception{
		
	Connection conn= null;
	CallableStatement pstmt=null;
	
	try {
			conn = (new DBConnection()).getConnection();
			pstmt = conn.prepareCall("{call qass_get_audit_firm_info3(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		
				 pstmt.setString(1,auditTaxId);
				 pstmt.setString(2,auditZipCode);
				 pstmt.registerOutParameter(3, Types.CHAR);
				 pstmt.registerOutParameter(4, Types.VARCHAR);
				 pstmt.registerOutParameter(5, Types.CHAR);
				 pstmt.registerOutParameter(6, Types.VARCHAR);
				 pstmt.registerOutParameter(7, Types.VARCHAR);
				 pstmt.registerOutParameter(8, Types.VARCHAR);
				 pstmt.registerOutParameter(9, Types.CHAR);
				 pstmt.registerOutParameter(10, Types.CHAR);
				 pstmt.registerOutParameter(11, Types.VARCHAR);
				 pstmt.registerOutParameter(12, Types.VARCHAR);
				 pstmt.registerOutParameter(13, Types.VARCHAR);
				 pstmt.registerOutParameter(14, Types.VARCHAR);
				 pstmt.registerOutParameter(15, Types.VARCHAR);
				 pstmt.registerOutParameter(16, Types.VARCHAR);
				 pstmt.registerOutParameter(17, Types.VARCHAR);
				 pstmt.registerOutParameter(18, Types.VARCHAR);
				 pstmt.registerOutParameter(19, Types.VARCHAR);
				 pstmt.registerOutParameter(20, Types.VARCHAR);
				  
				 				  	
				 int myResult = pstmt.executeUpdate();
		 	 
			if ( myResult > 0 )
			{
				this.setAudit_firm_tax_id(auditTaxId);
				this.setAudit_firm_zip_code(auditZipCode);
				this.setAudit_firm_id(pstmt.getString(3));
				this.setAudit_firm_name(pstmt.getString(4));
				this.setAudit_firm_type(pstmt.getString(5));
				this.setAudit_firm_address_line_1(pstmt.getString(6));
				this.setAudit_firm_address_line_2(pstmt.getString(7));
				this.setAudit_firm_city(pstmt.getString(8));
				this.setAudit_firm_state(pstmt.getString(9));
				this.setAudit_firm_zip_code_ext(pstmt.getString(10));
				this.setAudit_firm_phone_num(formatPhoneNumbers(pstmt.getString(11)));
				this.setAuditor_contact_first_name(pstmt.getString(12));
				this.setAuditor_contact_middle_name(pstmt.getString(13));
				this.setAuditor_contact_last_name(pstmt.getString(14));
				this.setAuditor_contact_title(pstmt.getString(15));
				this.setAuditor_contact_phone_num(formatPhoneNumbers(pstmt.getString(16)));
				this.setAuditor_contact_phone_ext_num(formatPhoneNumbers(pstmt.getString(17)));
				this.setAuditor_contact_fax_num(formatPhoneNumbers(pstmt.getString(18)));
				this.setAuditor_contact_email(pstmt.getString(19));
				this.setMyErrorMsg(pstmt.getString(20));
			}else{
				this.setAudit_firm_id("0");
			}
		
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
		return this;
	}
	
	
	public String formatPhoneNumbers(String phoneNumber){
		String myFormat=null;
		
		if (phoneNumber != null){
			if (phoneNumber.length() == 16){
				myFormat = phoneNumber.substring(1, 4) + 
				phoneNumber.substring(6, 9)+
				phoneNumber.substring(12, 16);
			}else{
				myFormat = phoneNumber;
			}
		}	
		return myFormat;
	}
}
