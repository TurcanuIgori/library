package com.library.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.library.entity.User;
import com.library.service.UserService;

@Component
public class UserValidator implements Validator{
	
	@Autowired
	UserService userService;
	
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	public void validate(Object o, Errors errors) {
		
		User user = (User) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");		
		if(user.getUsername().length() < 6 || user.getUsername().length() > 20){
			errors.rejectValue("username", "Size.UserForm.Username");
		}
		
//		if(userService.findByUsername(user.getUsername()) != null){
//			errors.reject("username", "Duplicate.UserForm.Username");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");		
		if(user.getPassword().length() < 6 || user.getPassword().length() > 20){
			errors.rejectValue("password", "Size.UserForm.Password");
		}
		
		if(!user.getConfirmPassword().equals(user.getPassword())){
			errors.rejectValue("confirmPassword", "Different.UserForm.Password");
		}
	}

}
