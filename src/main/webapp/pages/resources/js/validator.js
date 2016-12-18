var re = /^[\w ]+[^0-9]+$/;
var remail = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,4}))$/;
var rephone = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{3,8}$/im;
var redob = /^\d{2}([./-])\d{2}\1\d{4}$/;
//var repass = /^(?=.*[a-zA-Z])[a-zA-Z0-9]{4, 16}$/;
var x = 0;
function checkFirstName(){		
	//If input contains inaccessible symbols
	var str = document.getElementById("firstName").value;	
	if(!re.test(str) || str.length > 15 || str.length < 4){
		document.getElementById("firstNameError").innerHTML = "* name is null or contais invalid symbols";
		return false;
	}else{
		document.getElementById("firstNameError").innerHTML = "";	
		
	}
}
function checkLastName(){
//If input contains inaccessible symbols
	var lastName = document.getElementById("lastName").value;	
	if(!re.test(lastName) || lastName.length > 18 || lastName.length < 6){
		document.getElementById("lastNameError").innerHTML = "* last Name is null or contais invalid symbols";
		return false;
	}else{
		document.getElementById("lastNameError").innerHTML = "";
	}	
}
function checkEmail(){
	//If input contains inaccessible symbols
		var email= document.getElementById("email").value;	
		if(remail.test(email)){
			document.getElementById("emailError").innerHTML = "";
		}else{
			document.getElementById("emailError").innerHTML = "* email is not corectly";
			return false;
		}	
		
	}
function checkDob(){
	var dob= document.getElementById("dob").value;	
	if(redob.test(dob)){
		document.getElementById("dobError").innerHTML = "";
	}else{
		document.getElementById("dobError").innerHTML = "* dob is not corectly";
		return false;
	}		
}
function checkPhone(){
	//If input contains inaccessible symbols
		var phone= document.getElementById("phone").value;	
		if(rephone.test(phone)){
			document.getElementById("phoneError").innerHTML = "";
		}else{
			document.getElementById("phoneError").innerHTML = "* phone is not corectly";
			return false;
		}	
		
}
function checkGender(){
	var genders = document.getElementsByName("gender");
	if(document.getElementById("male").checked || document.getElementById("female").checked){
		document.getElementById("genderError").innerHTML = "";
	}else{
		document.getElementById("genderError").innerHTML = "* gender is must to be selected";
		return false;
	}
}
function checkPass(){
	var password = document.getElementById("password").value;
	var passwordConfirmation = document.getElementById("passwordConfirmation").value;
	if(password.length < 6 || password.length > 18){
		document.getElementById("passError").innerHTML = "* check your passwords";
		return false;
	}else{
		document.getElementById("passError").innerHTML = "";
		
	}
	if((password != passwordConfirmation)){
		document.getElementById("passConfError").innerHTML = "* passwords is not equals";
		return false;
	}else{
		document.getElementById("passConfError").innerHTML = "";
	}	
}