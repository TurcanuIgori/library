<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<title>Online Library</title>
		<link type="image/png" rel="shortcut icon" href="<c:url value="/pages/resources/images/favicon.gif" />"/>			
		<link rel="stylesheet" type="text/css" href="<c:url value="/pages/resources/styles/style.css" />">
		<script src="<c:url value="/pages/resources/js/changeBooksByGenre.js "/>" type="text/javascript"></script>
	</head>
	<body>
<%-- 		Hello<a href="edit/${user.id}"> ${pageContext.request.userPrincipal.name}</a><br/> --%>
<!-- 		<a href="logout">Log Out</a><br/> -->
<%-- 		<img src="picture/<c:out value="${user.picture}"/>" width="150px"/> --%>
		<div class="header">
			<div class="header-wrap">
				<div class="language">
                    <div class="lang" style="display: inline;">        
						<a href="?lang=ru">
							<img src="<c:url value="/pages/resources/images/rus.png"/>" title="Russian" width="16" height="13"/>
						</a>
						<a href="?lang=en">
							<img src="<c:url value="/pages/resources/images/usa.png"/>" title="English" width="16" height="13"/>
						</a>
					</div>
                </div>				
				<div class="aut">
<%-- 					  background:url('Picture?id=${user.id}') no-repeat; --%>
					<p style="padding-left: 25px; float: left; margin-top: 5px; color: #fff;"><img src="picture/<c:out value="${user.picture}"/>" height="32px"/>  <a href="edit/${user.id}">${user.lastName} ${user.firstName}</a></p>
					<a href="logout">Logout</a>                    
				</div>
			</div>			
		</div>
		<div id="wrap"> 
			<div class="logo">
				<a href="home.jsp">
					<img src="<c:url value="/pages/resources/images/logo.png"/>"/>
				</a>
			</div>
			<div class="menu">
				<ul>
					<li><a href="home.jsp">home</a></li>                            
					<li><a href="about.jsp">about</a></li>
					<li><a href="SendEmail" target="_blank">contact</a></li>                            
				</ul>
			</div> 
			<div class="search">
				<form id="search_form" class="search_form">
					<input type="submit" class="button-text"/>
					<input type="text"  id="search_string" class="search-text"/>
					<input type="submit" id="btnSearch" value="Search" class="button"/>
					<div class="dropdown">                   
						<select id="search_select" class="select_search">
							<option>Title</option>
							<option>Author</option>
						</select>
					</div>				
				</form>
			</div>
			<div class="content">
				<div class="left-menu">
					<form class="genres" id="genresForm">
						<ul>
							<c:forEach items="${listGenre}" var="genre">	
								<li>
									<a href="#" value="${genre.id}" onclick="getBooksByGenre(${genre.id}, 1)" class="genre">${genre.name}</a>										
								</li>
							</c:forEach>						
						</ul>
					</form>
				</div>
				<div class="right-content">
					<div class="box-sh">
						<h1><p id="booksCount">Books size: ${fn:length(books)}</p></h1>
						<form id="add-action">
							<a href="BookController?action=ADD_EDIT_BOOK&id=${book.id}">Add Book</a>							
						</form>
						<hr style="width:96%; color: #aeaeae"/>
					</div>					
					<form id="booksForm">
						<div id="booksList" class="books_list">
							<c:if test="${empty books}">
								<a>Not added books at this genre</a>
							</c:if>
							<c:forEach var="book" items="${books}">
								<div class="item">
									<div class="image-info">
	
										<a class="content_link" target="_blank">
											<img src="BookPicture?id=${book.id}" width="110" height="150"/>										
										</a>
	
	
										<div id="ratingPanel">
											
										</div>
									</div>
	
	
									<div class="info">
										<div class="book_name">
											<a href="#" id="bookName" class="title" target="_blank">
												${book.name}											
											</a>
	
										</div>
										<span>${book.author.firstName} ${book.author.lastName}</span>	
										<p><strong>Pages:</strong> ${book.pages}</p>
	
										<p><strong>Publisher:</strong> ${book.publisher}</p>
	
										<p><strong>Year:</strong> ${book.year}</p>
	
										<p><strong>ISBN:</strong> ${book.isbn}</p>
	
									</div>
	
	
									<a class="mr" href="BookController?action=READ_BOOK&id=${book.id}" target="_blank">
										<p class="read">Read</p>
									</a>
									<a href="DownloadPDF?id=${book.id}" class="mr" value="Download" target="_blank">
										<p class="download">Download</p>
									</a>
									<a href="BookController?action=ADD_EDIT_BOOK&id=${book.id}" class="mr" title="Edit Book">
										<p class="edit">Edit</p>
									</a>
									<a href="BookController?action=DELETE_BOOK&id=${book.id}" class="delete-button" title="Delete">
										<p class="delete">Delete</p>
									</a>
								</div>
							</c:forEach>							
						</div>						
					</form>
				</div>
			</div>
			<div class="footer_blank"></div>
		</div>
		 <div id="footer">
                <div class="footer-wrap">
                    <p>© 2016 Online Library <a href="contact.jsp" class="footerLink">Contact Us  </a><a class="footerLink" href="about.jsp">About Us</a></p>
                </div>
            </div>
	</body>
</html>