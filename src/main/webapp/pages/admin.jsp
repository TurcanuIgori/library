<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Administration</title>
	</head>
	<body>
		<h2>Administration Page</h2>
		<h3>Hello ${pageContext.request.userPrincipal.name}</h3><a href="logout">Logout</a>	
	 	<table border="1 black solid">
	 		<tr>
	 			<td>Photo
	 			</td>
	 			<td>ID
	 			</td>
	 			<td>FirstName
	 			</td>
	 			<td>LastName
	 			</td>
	 			<td>Username
	 			</td>
				<td>DOB
	 			</td>
	 			<td>Phone
	 			</td>
	 			<td>Gender
	 			</td>
	 			<td>ROLE
	 			</td>
	 			<td>Action
	 			</td>
	 		</tr>
	 		<c:forEach var="user" items="${users}">
		 		<tr>
		 			<td>
		 				<img src="picture/<c:out value="${user.picture}"/>" width="150px"/>
		 				
		 			</td>
		 			<td>${user.id}
		 			</td>
		 			<td>${user.firstName}
		 			</td>
		 			<td>${user.lastName}
		 			</td>
		 			<td>${user.username}
		 			</td>
					<td>${user.dob}
		 			</td>
		 			<td>${user.phone}
		 			</td>
		 			<td>${user.gender}
		 			</td>
		 			<td>${user.role}
		 			</td>
		 			<td>
				   <a href="edit/${user.id}"><img src="<c:url value="/pages/resources/images/edit.png"/>" width="35px"/></a><br>
				   <a href="delete/${user.id}"><img src="<c:url value="/pages/resources/images/delete.png"/>" width="35px"/></a>
			   	</td>
		 		</tr>
	 		</c:forEach>
	 	</table>
	</body>
</html>