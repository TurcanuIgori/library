<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link type="image/png" rel="shortcut icon" href="<c:url value="/pages/resources/images/favicon.gif" />"/>			
	<link rel="stylesheet" type="text/css" href="<c:url value="/pages/resources/styles/style.css" />">
</head>
	<body>
		<form action="login" class="box login" id="loginForm" method="POST">
	        <fieldset class="boxBody">
				<a href="?lang=ru">
					<img src="<c:url value="/pages/resources/images/rus.png"/>" title="Russian" width="16" height="13"/>
				</a>
				<a href="?lang=en">
					<img src="<c:url value="/pages/resources/images/usa.png"/>" title="English" width="16" height="13"/>
				</a>
				<a href="singup" value="Register" class="btnRegister">Sing Up</a>
				<label for="username">Username</label>
				<label name="errors" for="username"/>
				<input name="username" type="text"/>
				<label for="password">Password</label>
				<label for="errors"/>
				<input name="password" type="password"/>
	          	<a class="error">${error}</a>
	          	<a>${message}</a>
			</fieldset>
			<footer>
	<!-- 				<label><input type="checkbox"  form="loginForm">Remember me</label> -->
				<input type="submit" class="btnLogin"  value="Save">
	<!-- 			  <a href="home.jsp" class="btnLogin" value="Login">Login</a> -->
			</footer>	
	    </form>
	</body>
</html>