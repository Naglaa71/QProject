<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Audit Office Classification</title>
<div align="center">
	<img src="images/reac_qa_image_header.gif" width="600"
		alt="QASS Header Image">
</div>
<s:include value="qass_header_internal_links.html" />
</head>
<body>

	<%-- 	<s:property value="#session.userName"/> - <s:property value="#session.userType"/> --%>
	<table align="center" width="600" border="0" summary="header links">
		<br />
		<br />
		<br />
		<br />
		<strong>Please select whether you are registering for an
			independent public accounting office or for a state auditor office:</strong>
		<br />
		<br />
		<s:url id="OfficeTypeIPA" action="ClassificationRecallIPA" />
		<s:a href="%{OfficeTypeIPA}">Independent Public Accountant - IPA</s:a>
		<br />
		<br />
		<s:url id="OfficeTypeSAO" action="ClassificationRecallSAO" />
		<s:a href="%{OfficeTypeSAO}">State Accountant Office - SAO</s:a>
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