<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update An Existing Profile</title>
<style type="text/css">
.errorMessage {
	color: red;
}
</style>
<div align="center">
	<img src="images/reac_qa_image_header.gif" width="600"
		alt="QASS Header Image">
</div>
<%-- <s:include value="stylesheets/participantqassstylesheet.css" /> --%>

<s:include value="qass_header_internal_links.html" />
<h4 align="center">
	Create
	<s:property value="#session.audit_firm_type" />
	Office Profile
</h4>
</head>
<body>
	<s:if test="hasActionErrors()">
	       <s:actionerror />
	</s:if>
	<s:if test="hasActionMessages()">
	       <s:actionmessage/>
	</s:if>
	<s:form action="UpdateExistingProfileAction">
		<table align="center" width="600" border="0" summary="header links">
			<br />
			<br />
			<strong>Please enter your office UII Number, EIN and ZIP Code below and
				then click the Go button:</strong>

			<br />
			<br />

			<%-- <s:property value="#session.userName" /> - <s:property
				value="#session.userType" /> - <s:property
				value="#session.audit_firm_type" /> --%>
			<tr>
				<td><s:textfield label="*UII "
						name="audit_firm_id" /></td>
			</tr>
			
			<tr>
				<td><s:textfield label="*EIN "
						name="audit_firm_tax_id" /></td>
			</tr>
			<tr>
				<td><s:textfield label="*Zip Code  "
						name="audit_firm_zip_code" /></td>
			</tr>
			<tr>
			<br />
			<br />
				<s:submit value="  GO  " align="center"></s:submit>
				
			</tr>

		</table>
		<br />
		<br />
		<br />
		<br />
		<h4 align="center">Line items denoted by an asterisk (*) are
			required fields.</h4>
	</s:form>
	

	<br />
	<br />

	<div name="footer">
		<s:include value="qass_footer_internal_links.html" />
	</div>
</body>
</html>