<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sing Up</title>
		<link type="image/png" rel="shortcut icon" href="<c:url value="/pages/resources/images/favicon.gif" />"/>			
		<link rel="stylesheet" type="text/css" href="<c:url value="/pages/resources/styles/style.css" />">
	</head>
	<body>
		<form:form commandName="user" class="box register" id="user" method="POST" action="/book/singup" enctype="multipart/form-data">
			<fieldset class="boxBody">
				<a href="?lang=ru">
					<img src="<c:url value="/pages/resources/images/rus.png" />" title="Russian" width="16" height="13"/>
				</a>
				<a href="?lang=en">
					<img src="<c:url value="/pages/resources/images/usa.png" />" title="English" width="16" height="13"/>
				</a>
				<form:hidden path="id"/>
				<div id="profilePicture">
<%-- 					<c:if test="${user.id != 0}"> --%>
<%-- 				        <img src="Picture?id=${user.id}" id="image" width="150px"> 					         --%>
<%-- 				    </c:if>     --%>
<%-- 				    <c:if test="${user.id == 0}"> --%>
				        <img src="<c:url value="/pages/resources/images/noImg.png" />" id="image" height="150px">					        
<%-- 				    </c:if> --%>
					<input type="file" accept="image/*" onchange="document.getElementById('image').setAttribute('src', window.URL.createObjectURL(this.files[0]))" name="pict" id="pict"/>
				</div>
				<form:errors for="textStatus" class="error">${textStatus}</form:errors>		
				<form:label path="firstName">First Name</form:label>
				<form:input autocomplete="off" path="firstName"/>
				<form:errors path="firstName" class="error"></form:errors>
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" autocomplete="off"/>
				<form:errors path="lastName" class="error"/>
				<form:label path="username">Email</form:label>
				<form:input path="username" autocomplete="off"/>
				<form:errors path="username" class="error"/>
				<form:label path="phone">Phone</form:label>
				<form:input path="phone" autocomplete="off"/>
				<form:errors path="phone" class="error"/>
				<form:label path="dob">Date of Birth</form:label>
				<form:input path="dob" autocomplete="off"/>
				<form:errors path="dob" class="error"></form:errors>
				<form:label path="gender">Gender</form:label>
				<form:radiobutton path="gender" value="M" label="Male"/>
				<form:radiobutton path="gender" value="F" label="Female"/>
				<form:label path="gender" class="error"></form:label>
				<form:label path="password">Password</form:label>
				<form:password path="password"/>
				<form:label path="password" class="error"></form:label>
				<form:label path="confirmPassword">Confirm Password</form:label>
				<form:password path="confirmPassword"/>
				<form:label path="confirmPassword" class="error"/>
			</fieldset>
			<footer>	
				<input type="submit" value="Sing Up" class="btnLogin" id="btnLogin">  
<!-- 			<a href="home.jsp" onClick="createUser()" id="btnLogin" class="btnLogin">Sing Up</a> -->
			</footer>	 
		</form:form>
	</body>
</html>