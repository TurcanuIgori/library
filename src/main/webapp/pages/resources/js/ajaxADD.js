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
function createUser(){
	var radios = document.getElementsByName('gender');
	for (var i = 0, length = radios.length; i < length; i++) {
	    if (radios[i].checked) {
	        // do whatever you want with the checked radio
	        var gender = radios[i].value;
	        // only one radio can be logically checked, don't check the rest
	        break;
	    }
	}
	alert(document.getElementById("action").value);
	var text = '{"student":[{"firstName":"' + document.getElementById("firstName").value + '", ' +
		'"lastName":"' + document.getElementById("lastName").value + '", ' +
		'"email":"' + document.getElementById("email").value + '", ' +
		'"phone":"' + document.getElementById("phone").value + '", ' +
		'"dob":"' + document.getElementById("dob").value + '", ' +
		'"gender":"' + gender + '", ' +
		'"action":"' + document.getElementById("action").value + '", ' +
		'"password":"' + document.getElementById("password").value + '"}]}';
	obj = JSON.parse(text);	
	var picture = document.getElementById("picture").files[0];
	var formData = new FormData(document.getElementById("userForm"));
	formData.append('user', obj);
    formData.append('picture', picture);
	sendUser(formData);
}
function sendUser(formData){
	createRequest();
	if(request == null){
		alert("request is null");
	}
	request.open("POST", "UserController", true);
	request.send(formData);
	request.onload = function(e) {
		if (this.status == 200) {
        alert("URAAAAAAAAAAA!");
     }
     };               
}



