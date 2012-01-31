package org.convey.registration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.convey.registration.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * $LastChangedDate:  $
 * $LastChangedBy:  $
 * $LastChangedRevision:  $
 *
 *  Author: Chathuranga Tennakoon ( chathuranga.t@gmail.com  tel: 009475961039 )
 */
@Controller
@RequestMapping("/userRegistration")
public class UserAdministration {

    final static Logger logger = LoggerFactory.getLogger(UserAdministration.class);

    @Autowired
    private Validator validator;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String displayUserRegistrationForm(Map<String, Object> map){

        logger.debug(" request is for displaying the user registration form ");

        //setting up the  required value in the request scope for CommandName parameter
        map.put("user",new User());
        // InternalViewResolver will resolve the logical view name to the actual physical views name
        return "userRegisterView";
    }


    @RequestMapping(value= "/register" , method = RequestMethod.POST)
    public ModelAndView registerNewUser(@ModelAttribute("user")User user, BindingResult result){

        logger.debug(" Form data retrieved from the user registration page and Data validation starts ");

        String password=user.getPassword();
        String username=user.getUsername();
        String email=user.getEmail();

        //here we are using slf4j for logging
        logger.debug(" retrieved username is [{}] ",username);

        ModelAndView view=new ModelAndView("userRegistrationSuccessView");
        // the below parameters can be access in userRegistrationSuccessView jsp page using Expression language (EL)
        view.addObject("password",password);
        view.addObject("username",username);
        view.addObject("email",email);

        validator.validate(user, result);

        logger.debug(" has form errors "+result.hasErrors());

        if (result.hasErrors()) {

            logger.debug(" errors occurred during the validation process ");

            ModelAndView userRegisterFormView=new ModelAndView("userRegisterView");

            return userRegisterFormView;
        }
        else{
            logger.debug(" all data was properly validated with no errors ");
            return view;
        }

    }


}
