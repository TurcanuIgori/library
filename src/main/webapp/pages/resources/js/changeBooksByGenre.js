var request = null;
function createRequest(){
	try{
		request=new XMLHttpRequest();		
	}catch(trymicrosoft){
		try{
			request=new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicrosoft){
			try{
				request=new ActiveXObject("Microsoft.XMLHTTP");
			}catch(failed){
				request=null;
			}
		}
	}
}
function getBooksByGenre(id, pag){	
	createRequest();
	if(request==null){
		alert("Error creating request!");
	}		
	var url = "BookController?action=GET_BOOKS&id=" + id + "&p=" + pag;
	request.open("GET", url, true);	
	request.onreadystatechange = listBooks;
	request.send(null);
}
function listBooks(){	
	if(request.readyState == 4){
		if(request.status == 500){
			var el = document.getElementById('booksList');
			while ( el.firstChild ){ el.removeChild( el.firstChild )};
			var noBooks = document.createElement('a');
			noBooks = document.createTextNode("Not added books at this genre");
			document.getElementById('booksList').appendChild(noBooks);
		}
		if(request.status == 200){
			var jsonData=eval('(' + request.responseText + ')');
			var el = document.getElementById('booksList');
			while ( el.firstChild ){ el.removeChild( el.firstChild )};
			for(var i = 0; i < jsonData.length; i++){
				var itemDiv = document.createElement("div");  
//				itemDiv.setAttribute("class", "item");
				itemDiv.className = "item";
				var imageInfoDiv = document.createElement("div");  
//				imageInfoDiv.setAttribute("class", "image-info");
				imageInfoDiv.className = "image-info";
				var imageInfoDivA = document.createElement("a");
				imageInfoDivA.setAttribute("class", "content_link");
				imageInfoDivA.setAttribute("target", "_blank");
				var imageInfoDivAImg = document.createElement("IMG");
				imageInfoDivAImg.setAttribute("src", "BookPicture?id=" + jsonData[i].id);
				alert("genre: " + jsonData[i].genre.id);
//				imageInfoDivAImg.src("BookPicture?id=" + jsonData[i].id);
				imageInfoDivAImg.setAttribute("width", "110");
				imageInfoDivAImg.setAttribute("height", "150");
				 var ratingPanelDiv = document.createElement("div");  
				 ratingPanelDiv.id = "ratingPanel";
				imageInfoDivA.appendChild(imageInfoDivAImg);
				imageInfoDiv.appendChild(imageInfoDivA);
				imageInfoDiv.appendChild(ratingPanelDiv);
				itemDiv.appendChild(imageInfoDiv);
				var infoDiv = document.createElement('div');  
				infoDiv.setAttribute("class", "info");
				var bookNameDiv = document.createElement('div');  
				bookNameDiv.setAttribute("class", "book_name");
				var bookNameDivA = document.createElement('a');
				bookNameDivA.setAttribute("class", "title");
				bookNameDivA.setAttribute("target", "_blank");
				bookNameDivA.setAttribute("id", "bookName");
				bookNameDivA.setAttribute("href", "#");
				var bookName = document.createTextNode(jsonData[i].name);
				bookNameDivA.appendChild(bookName);
				bookNameDiv.appendChild(bookNameDivA);
				infoDiv.appendChild(bookNameDiv);
				var span1 = document.createElement('span');
				var authorName = document.createTextNode(jsonData[i].author.firstName + jsonData[i].author.lastName);
				span1.appendChild(authorName);
				infoDiv.appendChild(span1);
				var p1 = document.createElement('p');
				var p1S = document.createElement('strong');
				var pageBookE = document.createTextNode("Pages:");			
				var pageBook = document.createTextNode(jsonData[i].pages);
				p1S.appendChild(pageBookE);
				p1.appendChild(p1S);
				p1.appendChild(pageBook);
				infoDiv.appendChild(p1);			
				var p2 = document.createElement('p');
				var p2S = document.createElement('strong');
				var publisherBookE = document.createTextNode("Publisher:");			
				var publisherBook = document.createTextNode(jsonData[i].publisher);
				p2S.appendChild(publisherBookE);
				p2.appendChild(p2S);
				p2.appendChild(publisherBook);
				infoDiv.appendChild(p2);
				var p3 = document.createElement('p');
				var p3S = document.createElement('strong');
				var yearBookE = document.createTextNode("Year:");			
				var yearBook = document.createTextNode(jsonData[i].year);
				p3S.appendChild(yearBookE);
				p3.appendChild(p3S);
				p3.appendChild(yearBook);
				infoDiv.appendChild(p3);
				var p4 = document.createElement('p');
				var p4S = document.createElement('strong');
				var isbnBookE = document.createTextNode("ISBN:");			
				var isbnBook = document.createTextNode(jsonData[i].isbn);
				p4S.appendChild(isbnBookE);
				p4.appendChild(p4S);
				p4.appendChild(isbnBook);
				infoDiv.appendChild(p4);
				itemDiv.appendChild(infoDiv);
				var aRead = document.createElement('a');
				aRead.setAttribute("class", "mr");
				aRead.setAttribute("target", "_blank");
				aRead.setAttribute("href", "BookController?action=READ_BOOK&id=" + jsonData[i].id);
				var aReadP = document.createElement('p');
				aReadP.setAttribute("class", "read");
				aReadP.appendChild(document.createTextNode("Read"));
				aRead.appendChild(aReadP);
				itemDiv.appendChild(aRead);
				var aDownload = document.createElement('a');
				aDownload.setAttribute("class", "mr");
				aDownload.setAttribute("target", "_blank");
				aDownload.setAttribute("href", "DownloadPDF?id=" + jsonData[i].id);
				var aDownloadP = document.createElement('p');
				aDownloadP.setAttribute("class", "download");
				aDownloadP.appendChild(document.createTextNode("Download"));
				aDownload.appendChild(aDownloadP);
				itemDiv.appendChild(aDownload);
				var aEdit = document.createElement('a');
				aEdit.setAttribute("class", "mr");
				aEdit.setAttribute("href", "BookController?action=ADD_EDIT_BOOK&id=" + jsonData[i].id);
				var aEditP = document.createElement('p');
				aEditP.setAttribute("class", "edit");
				aEditP.appendChild(document.createTextNode("Edit"));
				aEdit.appendChild(aEditP);
				itemDiv.appendChild(aEdit);
				var aDelete = document.createElement('a');
				aDelete.setAttribute("class", "delete-button");
				aDelete.setAttribute("href", "BookController?action=ADD_EDIT_BOOK&id=" + jsonData[i].id);
				var aDeleteP = document.createElement('p');
				aDeleteP.setAttribute("class", "delete");
				aDeleteP.appendChild(document.createTextNode("Delete"));
				aDelete.appendChild(aDeleteP);
				itemDiv.appendChild(aDelete);
				document.getElementById('booksList').appendChild(itemDiv);
			}
			try{
				getNumberOfPages(jsonData[0].genre.id);
			}catch(e){
				var el = document.getElementById('booksList');
				while ( el.firstChild ){ el.removeChild( el.firstChild )};
				var noBooks = document.createElement('a');
				noBooks = document.createTextNode("Not added books at this genre");
				document.getElementById('booksList').appendChild(noBooks);
			}
		}
	}	
	
}
function getNumberOfPages(id){	
	createRequest();
	if(request==null){
		alert("Error creating request!");
	}		
	var url = "BookController?action=GET_PAGES&id=" + id;
	request.open("GET", url, true);	
	request.onreadystatechange = listPages;
	request.send(null);
}
function listPages(){	
	if(request.readyState == 4){
		if(request.status == 200){
			var jsonData=eval('(' + request.responseText + ')');
			alert(jsonData);
		}
	}
}