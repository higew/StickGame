package com.imie.stickgame.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.imie.stickgame.models.User;
import com.imie.stickgame.services.UserService;

@Component
public class ProfilValidator {
	
	@Autowired
    private UserService userService;

    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }
    
    private static final String regex_name = "(^[a-zA-Z]{2,32}$)";
    private static final String regex_password = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,32})";

    /**
    *  Validation de la modification de profil.
    *   On verifie sur chaque champs le fait qu'il ne soit pas vide, ne soit pas null et valide la regex correspondante au champ.
    */ 
     
    public void validate(Object o, Errors errors) {
        User user = (User) o;             
      
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
        if (!user.getFirstname().matches(regex_name)) {
            errors.rejectValue("firstname", "NotValid.userForm.firstname");
        } else {
        	errors.rejectValue("firstname", "NotValid.userForm.firstname");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
	    if (!user.getLastname().matches(regex_name)) {
	            errors.rejectValue("lastname", "NotValid.userForm.lastname");
        } else {
        	errors.rejectValue("lastname", "NotValid.userForm.lastname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (!user.getPassword().matches(regex_password)) {
            errors.rejectValue("password", "NotValid.userForm.password");  
        } else {
            	 errors.rejectValue("password", "NotValid.userForm.password");
         }          
    }
}
