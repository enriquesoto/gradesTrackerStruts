<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>El dashboard del usuario</title>
</head>
<body>
	<s:label>Bienvenido !!!</s:label>
	<s:property value="user.name" />
	<s:property value="user.lasname" />

	<form action='something.jsp' method='get'>
		<button>Something</button>
	</form>
</body>
</html>