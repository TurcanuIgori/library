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
		<form class="box register" id="bookForm" method="POST" action="addBook" enctype="multipart/form-data">
			<fieldset class="boxBody">
				<a href="?lang=ru">
					<img src="<c:url value="/pages/resources/images/rus.png" />" title="Russian" width="16" height="13"/>
				</a>
				<a href="?lang=en">
					<img src="<c:url value="/pages/resources/images/usa.png" />" title="English" width="16" height="13"/>
				</a>
				<input type="hidden" form="bookForm" id="action" name="action" value="ADD_EDIT_BOOK"> 
				<input type="hidden" form="bookForm" id="idBook" name="idBook" value="${book.id}">
				<input type="hidden" form="bookForm" id="genre_id" name="genre_id" value="${book.genre.id}">
				<div id="profilePicture">
				    <c:if test="${book.id != null}">
				        <img src="BookPicture?id=${book.id}" id="image" width="150px"> 					        
				    </c:if>    
				    <c:if test="${book.id == null}">
				        <img src="<c:url value="/pages/resources/images/noImgBook.png" />" id="image" height="150px">					        
				    </c:if>
					<input type="file" accept="image/*" onchange="document.getElementById('image').setAttribute('src', window.URL.createObjectURL(this.files[0]))" name="picture" id="picture">
				</div>
				<label id="filePdfLabel">Select book file</label>
				<input type="file" accept="application/pdf"  name="filePdf" id="filePdf">
				<label class="error">${textStatus}</label>		
				<label id="nameLabel">Name</label>
				<input type="text" form="bookForm" id="name" value="${book.name}" autocomplete="off" name="name">
				<label id="nameError" class="error"></label>
				<label>Author</label>
				<input type="text" name="firstName" autocomplete="off"  value="${book.author.firstName}" id="firstName">
				<label id="firstNameAuthorError" class="error"></label>
				<input type="text" name="lastName" autocomplete="off"  value="${book.author.lastName}" id="lastName">
				<label id="lastNameAuthorError" class="error"></label>
				<label>Pages</label>
				<input type="text" name="pages" id="pages"  value="${book.pages}" autocomplete="off">
				<label id="pagesError" class="error"></label>
				<label>Publisher</label>
				<input type="text" name="publisher" id="publisher" autocomplete="off"  value="${book.publisher}">
				<label id="publisherError" class="error"></label>
				<label>Genre</label>
				<select name="genre" id="genre">
					<c:forEach items="${genres}" var="genre">
						<c:if test="${genre.id == book.genre.id}"><option value="${genre.id}" selected>${genre.name}</option></c:if>
						<c:if test="${genre.id != book.genre.id}"><option value="${genre.id}">${genre.name}</option></c:if>
<%-- 						<option value="${genre.id}">${genre.name}</option> --%>
					</c:forEach>
				</select>
				<label>Year</label>
				<input type="text" name="year" id="year" autocomplete="off"  value="${book.year}">
				<label id="yearError" class="error"></label>
				<label>ISBN</label>
				<input type="text" name="isbn" id="isbn" autocomplete="off"  value="${book.isbn}">
				<label id="isbnError" class="error"></label>
				<label>Description</label>
				<textarea id="description" name="description" rows="7" cols="30">
					${book.description}
				</textarea>
			</fieldset>
			<footer>	
				<input type="submit" form="bookForm" value="Add Book" class="btnLogin" id="btnLogin">  
<!-- 			<a href="home.jsp" onClick="createUser()" id="btnLogin" class="btnLogin">Sing Up</a> -->
			</footer>	 
		</form>
	</body>
</html>