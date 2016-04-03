<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="org.apache.commons.lang3.StringUtils"%>
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
	 
     function onChangeList(changeVal) {
       document.getElementById("auditFirm.audit_firm_state").value=changeVal.value;   

     }
    
    function checkNumeric(id){
     	if (StringUtils.isNumeric(document.getElementById(id).value) == false){
    		alert ( "Please enter Numeric Value." );
    		document.getElementById(id).focus();
     	} ;
    }
    function isproperLength(input, numlength)
	{
		if (input.value.length != numlength)
			{
			alert("This value must be " + numlength + " digits.");	
			input.focus();	
			return true;
			}
		else
		{
			return false;
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



	<s:form action="ConfirmProfileAction">
		<%-- 	<s:property value="#session.userName"/> - <s:property value="#session.userType"/> - <s:property value="#session.audit_firm_type"/> --%>
		

			
		<table id="myTable" align="center" width="600" border="1" summary="header links">
			<br />
			<br />
			<strong>Please <s:property value="#session.TranType"/> your registration data below. Click
				the Go button after finish :</strong>

			<br />
			<br />
				<s:if test="#session.TranType == 'Create'">
					<td><s:hidden label="UII   " name="auditFirm.audit_firm_id" style="width: 40px;" readonly="true"/></td>
				</s:if>
				<s:else>
					<td><s:textfield label="UII   " name="auditFirm.audit_firm_id" style="width: 40px;" readonly="true"/></td>
				</s:else>
					
					
				<td><s:textfield label="*EIN " name="auditFirm.audit_firm_tax_id" style="width: 80px;" /></td>
			
			
				<td><s:textfield  label="*Audit Office Name  " name="auditFirm.audit_firm_name" style="width: 300px;" /></td>
			
			
				<td><s:textfield  label="*Audit Office Address(1)  " name="auditFirm.audit_firm_address_line_1" style="width: 300px;" /></td>
			
			
				<td><s:textfield  label="Audit Office Address(2)  " name="auditFirm.audit_firm_address_line_2" style="width: 300px;" /></td>
			
			
				<td><s:textfield  label="*Audit Office City  " name="auditFirm.audit_firm_city" style="width: 100px;" /></td>
			
			
				<td><s:hidden label="*Audit Office State  " name="auditFirm.audit_firm_state" style="width: 30px;" /></td>
			
				
				<td><s:select list='states' label="*Audit Office State  " name="states" onkeyleave="onChangeList(this)"  />
			
				
				<td><s:textfield  label="*Audit Office Zip Code  " name="auditFirm.audit_firm_zip_code" style="width: 40px;" /></td>
			
			
				<td><s:textfield  id="zipCodeExt" label="Audit Office Zip Code Extension  " name="auditFirm.audit_firm_zip_code_ext" style="width: 40px;" onkeyup="checkNumeric(zipCodeExt)"/></td>
			
			
				<td><s:textfield  label="*Audit Office Phone Number  " name="auditFirm.audit_firm_phone_num" style="width: 80px;" /></td>
			
			
				<td><s:textfield  label="*Audit Contact First Name  " name="auditFirm.auditor_contact_first_name" style="width: 100px;" /></td>
			
			
				<td><s:textfield  label="Audit Contact Middle Name  " name="auditFirm.auditor_contact_middle_name" style="width: 100px;" /></td>
			
			
				<td><s:textfield  label="*Audit Contact Last Name " name="auditFirm.auditor_contact_last_name" style="width: 100px;" /></td>
			
			
				<td><s:textfield  label="*Audit Contact Title  " name="auditFirm.auditor_contact_title" style="width: 250px;" /></td>
			
			
				<td><s:textfield  label="*Audit Contact Phone  " name="auditFirm.auditor_contact_phone_num" style="width: 80px;" /></td>
			
			
				<td><s:textfield  label="Audit Contact Phone Extension  " name="auditFirm.auditor_contact_phone_ext_num" style="width: 30px;" /></td>
			
			
				<td><s:textfield  label="Audit Contact Fax  " name="auditFirm.auditor_contact_fax_num" style="width: 80px;" /></td>
			
			
				<td><s:textfield  label="*Audit Contact Email  " name="auditFirm.auditor_contact_email" style="width: 200px;" /></td>
			
				<s:submit value="   GO   "></s:submit> <s:reset	value=" Reset"></s:reset>
				

		</table>
		<p align="center">By submitting this information, the submitter
			certifies on behalf of the user that the information in the
			registration form is correct and valid , and that the submitter is
			properly authorized to make this registration and certification on
			behalf of the user.</p>
	</s:form>


	<br />
	<br />

	<div name="footer">
		<s:include value="qass_footer_internal_links.html" />
	</div>
</body>
</html>