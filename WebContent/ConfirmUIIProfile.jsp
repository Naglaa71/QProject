<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Office Profile</title>
<LINK REL="stylesheet" HREF="stylesheets/participantqassstylesheet.css"
	TYPE="text/css">

<script type="text/javascript">
	function alternate(id) {
		if (document.getElementsByTagName) {
			var table = document.getElementById(id);
			var rows = table.getElementsByTagName("td");
			for (i = 0; i < rows.length; i++) {
				//manipulate rows 
				if (i % 2 == 0) {
					rows[i].className = "even";
				} else {
					rows[i].className = "odd";
				}
			}
		}
	}
</script>

<div align="center">
	<img src="images/reac_qa_image_header.gif" width="600"
		alt="QASS Header Image">
</div>

<s:include value="qass_header_internal_links.html" />

</head>
<body onload="alternate('myTable')">


	<s:form action="VerifyProfileAction">
		<%-- 	<s:property value="#session.userName"/> - <s:property value="#session.userType"/> - <s:property value="#session.audit_firm_type"/> --%>
		

			
		<table id="myTable" align="center" width="600" border="1" summary="header links">
			<br />
			<br />
			<strong>Please verify the information below. If any information is incorrect, please click the Back button below to return to the registration screen. If the information is correct, click the Submit button to update your office profile information.</strong>

			<br />
			<br />
			
				<td>
					<s:if test="#session.TranType == 'Create'">
						<s:hidden  id="input" label="UII   " name="auditFirm.audit_firm_id" style=" width: 200px; border:none " readonly="true"/>
					</s:if>
					<s:else>
						<s:textfield  label="UII   " name="auditFirm.audit_firm_id" style=" width: 200px; border:none " readonly="true"/>
					</s:else>
							
				</td>
			
			<td>
				<s:textfield id="input" label="Enter EIN "
						name="auditFirm.audit_firm_tax_id" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Office Zip Code  "
						name="auditFirm.audit_firm_zip_code" readonly="true"
						style="width: 300px; border:none" />
			</td>

			<td>
				<s:textfield id="input" label="Enter Firm Name  " readonly="true"
						name="auditFirm.audit_firm_name" style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Address(1)  "
						name="auditFirm.audit_firm_address_line_1" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Address(2)  "
						name="auditFirm.audit_firm_address_line_2" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm City  " readonly="true"
						name="auditFirm.audit_firm_city" style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter firm State  "
						name="auditFirm.audit_firm_state" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Zip Code ext  "
						name="auditFirm.audit_firm_zip_code_ext" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Phone Number  "
						name="auditFirm.audit_firm_phone_num" readonly="true"
						style=" width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Contact First Name  "
						name="auditFirm.auditor_contact_first_name" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Contact Middle Name  "
						name="auditFirm.auditor_contact_middle_name" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Contact Last Name "
						name="auditFirm.auditor_contact_last_name" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Contact Title  "
						name="auditFirm.auditor_contact_title" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Contact Phone Number  "
						name="auditFirm.auditor_contact_phone_num" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Contact Phone Number ext  "
						name="auditFirm.auditor_contact_phone_ext_num" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Contact Fax Number  "
						name="auditFirm.auditor_contact_fax_num" readonly="true"
						style="width: 300px;border:none" />
			</td>
			<td>
				<s:textfield id="input" label="Enter Firm Contact Email  "
						name="auditFirm.auditor_contact_email" readonly="true"
						style="width: 300px; border:none" />
			</td>
			<td>
				<s:submit value="Submit"/> 
				
			</td>
		</table>
		
	</s:form>
	
	
	<br />
	<br />

	<div name="footer">
		<s:include value="qass_footer_internal_links.html" />
	</div>
</body>
</html>