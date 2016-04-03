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
			var rows = table.getElementsByTagName("tr");
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


	<s:form>
		<%-- 	<s:property value="#session.userName"/> - <s:property value="#session.userType"/> - <s:property value="#session.audit_firm_type"/> --%>



		<table id="myTable" align="center" width="600" border="1"
			summary="header links">
			<br />
			<br />
			<s:if test="%{#session.TranType == 'Create' || #session.TranType == 'Update' }">
			<strong>Your <b> UII is <s:property
					value="auditFirm.audit_firm_id" /></b>. The registration process is
				completed and your office information has been successfully <s:property value="#session.TranType"/>d.
			</strong>
			</s:if>
			<s:else>
			<strong>Your <b> UII is <s:property
					value="auditFirm.audit_firm_id" /></b>. Please check your registration information below for any errors If any information is incorrect or if any field has the value "This is a Mandatory Field",
					your office has not completed the registration process. Please note your UII, click on the Main menu link below and select The Update
					Profile link to update your information.<br/><br/>
					If the information below is correct, the registration process is complete and your office has successfully registered.
			</strong>
			</s:else>
			<br />
			<br />

			<tr>
			<td>UII Number </td>
			<td><s:property value="auditFirm.audit_firm_id" /></td>
			</tr>
			<tr>
			<td>EIN </td>
			<td><s:property value="auditFirm.audit_firm_tax_id"/></td>
			</tr>
			<tr>
			<td>Audit Office Name </td>
			<td><s:property value="auditFirm.audit_firm_name"/></td>
			</tr>
			<tr>
			<td>Audit Office Address </td>
			<td>
				<s:property value="auditFirm.audit_firm_address_line_1"/><br/>
				<s:property value="auditFirm.audit_firm_address_line_2"/><br/>
				<s:property value="auditFirm.audit_firm_city"/>, <s:property value="auditFirm.audit_firm_state"/> <s:property value="auditFirm.audit_firm_zip_code"/>
				<s:property value="auditFirm.audit_firm_zip_code_ext"/>
			</td>
			</tr>
			<tr>
			<td>Audit Office Phone Number </td>
			<td><s:property value="auditFirm.audit_firm_phone_num"/></td>
			</tr>
			<tr>
			<td>Auditor Contact Name </td>
			<td>
				<s:property value="auditFirm.auditor_contact_first_name"/> <s:property value="auditFirm.auditor_contact_middle_name"/> <s:property value="auditFirm.auditor_contact_last_name"/>
			</td>
			</tr>
			<tr>
			<td>Auditor Contact Title </td>
			<td><s:property value="auditFirm.auditor_contact_title"/></td>
			</tr>
			<tr>
			<td>Auditor Contact Phone</td>
			<td>
				<s:property value="auditFirm.auditor_contact_phone_num"/> 
				<s:property value="auditFirm.auditor_contact_phone_ext_num"/>
			</td>
			</tr>
			<tr>
			<td>Auditor Contact Fax</td>
			<td><s:property value="auditFirm.auditor_contact_fax_num"/></td>
			</tr>
			<tr>
			<td>Auditor Contact Email</td>
			<td><s:property value="auditFirm.auditor_contact_email"/></td>
			</tr>
			<tr>
			
			<td></td>
			</tr>
			<%-- <td><s:textfield id="input" label="UII Number  "
					name="auditFirm.audit_firm_id" readonly="true"
					style=" width: 200px; border:none " /></td> 
			<td><s:textfield id="input" label="Enter EIN "
					name="auditFirm.audit_firm_tax_id" readonly="true"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input" label="Enter Office Zip Code  "
					name="auditFirm.audit_firm_zip_code" readonly="true"
					style="width: 300px; border:none" /></td>

			<td><s:textfield id="input" label="Enter Firm Name  "
					readonly="true" name="auditFirm.audit_firm_name"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input" label="Enter Firm Address(1)  "
					name="auditFirm.audit_firm_address_line_1" readonly="true"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input" label="Enter Firm Address(2)  "
					name="auditFirm.audit_firm_address_line_2" readonly="true"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input" label="Enter Firm City  "
					readonly="true" name="auditFirm.audit_firm_city"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input" label="Enter firm State  "
					name="auditFirm.audit_firm_state" readonly="true"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input" label="Enter Firm Zip Code ext  "
					name="auditFirm.audit_firm_zip_code_ext" readonly="true"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input" label="Enter Firm Phone Number  "
					name="auditFirm.audit_firm_phone_num" readonly="true"
					style=" width: 300px; border:none" /></td>
			<td><s:textfield id="input"
					label="Enter Firm Contact First Name  "
					name="auditFirm.auditor_contact_first_name" readonly="true"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input"
					label="Enter Firm Contact Middle Name  "
					name="auditFirm.auditor_contact_middle_name" readonly="true"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input"
					label="Enter Firm Contact Last Name "
					name="auditFirm.auditor_contact_last_name" readonly="true"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input" label="Enter Firm Contact Title  "
					name="auditFirm.auditor_contact_title" readonly="true"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input"
					label="Enter Firm Contact Phone Number  "
					name="auditFirm.auditor_contact_phone_num" readonly="true"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input"
					label="Enter Firm Contact Phone Number ext  "
					name="auditFirm.auditor_contact_phone_ext_num" readonly="true"
					style="width: 300px; border:none" /></td>
			<td><s:textfield id="input"
					label="Enter Firm Contact Fax Number  "
					name="auditFirm.auditor_contact_fax_num" readonly="true"
					style="width: 300px;border:none" /></td>
			<td><s:textfield id="input" label="Enter Firm Contact Email  "
					name="auditFirm.auditor_contact_email" readonly="true"
					style="width: 300px; border:none" /></td>
			<td></td>--%>
			
		</table>
			
	</s:form>
	

	<br />
	<br />

	<div name="footer">
		<s:include value="qass_footer_internal_links.html" />
	</div>
</body>
</html>