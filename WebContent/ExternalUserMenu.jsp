<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>
<div align="center">
	<img src="images/reac_qa_image_header.gif" width="600"
		alt="QASS Header Image">
</div>
<%-- <s:include value="stylesheets/participantqassstylesheet.css" /> --%>
<s:include value="qass_header_external_links.html" />
</head>
<body>

	<%-- 	 <s:property value="#session.userName"/> - <s:property value="#session.userType"/> --%>

	

	<table align = "center" width = "600" border = "0" summary = "header links">
		<br />
		<br />
		<br />
		<br />
		<strong>Please select what action you would like to perform
			from the selections below:</strong>
			
		<br />
		<br />
		<s:url id="CreateNewProfile" action="CreateNewProfile" />
		<s:a href="%{CreateNewProfile}">Create New Profile</s:a>
		|
		<s:url id="UpdateExistingProfileEntryAction" action="UpdateExistingProfileEntryAction" />
		<s:a href="%{UpdateExistingProfileEntryAction}">Update Existing Profile</s:a>
		|
		<s:url id="RecallUII" action="RecallUII" />
		<s:a href="%{RecallUII}">Recall Unique Identifier (UII)</s:a>
	
	</table>
	<br />
	<br />
	<br />
	<br />
	<div name="footer">
		<s:include value="qass_footer_internal_links.html" />
	</div>
</body>

</html>