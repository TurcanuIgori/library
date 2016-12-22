<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
		<title>Add Book</title>
		<link type="image/png" rel="shortcut icon" href="<c:url value="/pages/resources/images/favicon.gif" />"/>			
		<link rel="stylesheet" type="text/css" href="<c:url value="/pages/resources/styles/style.css" />">
<!-- 		<script src="Resources/js/ajax.js" type="text/javascript"> </script> -->
		<script src="<c:url value="/pages/resources/js/validator.js" />" type="text/javascript"> </script>
	</head>
	<body>		
		<form:form commandName="book" class="box register"  method="POST" enctype="multipart/form-data">
			<fieldset class="boxBody">
				<a href="?lang=ru">
					<img src="<c:url value="/pages/resources/images/rus.png" />" title="Russian" width="16" height="13"/>
				</a>
				<a href="?lang=en">
					<img src="<c:url value="/pages/resources/images/usa.png" />" title="English" width="16" height="13"/>
				</a>
				<form:hidden path="id"/>
				<input type="hidden" name="category_id" value="${book.genre.id}"/>
				<div id="profilePicture">
				<img src="picture_book/<c:out value="${picturePath}"/>" id="image" width="150px"> 
<%-- 				    <c:if test="${book.id != null}"> --%>
<%-- 				        <img src="BookPicture?id=${book.id}" id="image" width="150px"> 					         --%>
<%-- 				    </c:if>     --%>
<%-- 				    <c:if test="${book.id == null}"> --%>
<%-- 				        <img src="<c:url value="/pages/resources/images/noImgBook.png" />" id="image" height="150px">					         --%>
<%-- 				    </c:if> --%>
					<input type="file" accept="image/*" onchange="document.getElementById('image').setAttribute('src', window.URL.createObjectURL(this.files[0]))" name="picture" id="picture">
				</div>
				<form:label path="bookPath">Select book file</form:label>
				<input type="file" accept="application/pdf"  name="filePdf" id="filePdf">
				<label class="error">${textStatus}</label>		
				<form:label path="name">Name</form:label>
				<form:input path="name" autocomplete="off"/>
				<form:errors path="name" class="error"></form:errors>
				<form:label path="author.firstName">Author</form:label>
				<form:input path="author.firstName" autocomplete="off"/>
				<form:errors path="author.firstName" class="error"/>
				<form:input path="author.lastName" autocomplete="off" />
				<form:errors path="author.lastName" class="error"/>
				<form:label path="pages">Pages</form:label>
				<form:input path="pages" autocomplete="off"/>
				<form:errors path="pages" class="error"/>
				<form:label path="publisher">Publisher</form:label>
				<form:input path="publisher" autocomplete="off"/>
				<form:errors path="publisher" class="error"/>
				<form:label path="genre">Genre</form:label>
				<form:select path="genre.id">
					<form:option value="0" label="(none)"/>
					<c:forEach items="${genres}" var="g">
						<form:option value="${g.id}" label="${g.name}"/>						
					</c:forEach>
				</form:select>
				<form:label path="year">Year</form:label>
				<form:input path="year" autocomplete="off"/>
				<form:errors path="year" class="error"/>
				<form:label path="isbn">ISBN</form:label>
				<form:input path="isbn" autocomplete="off"/>
				<form:errors path="isbn" class="error"/>
				<form:label path="description">Description</form:label>
				<form:textarea path="description" rows="7" cols="30"></form:textarea>
			</fieldset>
			<footer>	
				<input type="submit" value="Add Book" class="btnLogin" id="btnLogin">  
<!-- 			<a href="home.jsp" onClick="createUser()" id="btnLogin" class="btnLogin">Sing Up</a> -->
			</footer>	 
		</form:form>
	</body>
</html>