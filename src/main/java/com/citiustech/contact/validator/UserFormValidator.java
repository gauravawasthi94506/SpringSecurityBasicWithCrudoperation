package com.citiustech.contact.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.citiustech.contact.model.User;
import com.citiustech.contact.service.UserService;



@Component
public class UserFormValidator implements Validator {

	/*@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	*/
	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.userForm.confirmPassword");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.userForm.sex");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.userForm.country");

		/*if(!emailValidator.valid(user.getEmail())){
			errors.rejectValue("email", "Pattern.userForm.email");
		}*/
		
		 if (user.getUsername().length()!=0 && (user.getUsername().length() < 6 || user.getUsername().length() > 32)) {
	            errors.rejectValue("username", "Size.userForm.username");
	        }
	        
	        if (userService.findByUsername(user.getUsername()) != null) {
	            errors.rejectValue("username", "Duplicate.userForm.username");
	        }

	       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	        if (user.getPassword().length()!=0 && (user.getPassword().length() < 8 || user.getPassword().length() > 32)) {
	            errors.rejectValue("password", "Size.userForm.password");
	        }

	        if (user.getPasswordConfirm().length()!=0 && (!user.getPasswordConfirm().equals(user.getPassword()))) {
	            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
	        }

	}

}