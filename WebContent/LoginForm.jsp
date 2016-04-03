<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login Form</title>
	<style type="text/css">
		.errorMessage{
			color:red;
		}
	</style>
	
</head>
<body>
<s:include value="header.html" />

	<s:if test="hasActionErrors()">
	       <s:actionerror />
	</s:if>
	<s:if test="hasActionMessages()">
	       <s:actionmessage/>
	</s:if>

	<s:form action="AuthenticateUser">
	
		<table align = "center" width = "600" border = "0" summary = "header links">
			<tr>
				<td><s:textfield label="Enter User Name " name="userName"/></td>
			</tr>
			<tr>
				<td><s:password  label="Enter Password  " name="password"/></td>
			</tr>
					
			<tr><td></<td><s:submit value="log in"></s:submit></td></tr>
		</table>
	
	</s:form>
</body>
</html>