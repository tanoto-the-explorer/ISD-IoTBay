/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.model.controller;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author misel
 */

// validate input (don't think we need this, front end takes care of it.)
public class Validator implements Serializable{ 
    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
    private String namePattern = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$";       
    private String passwordPattern = "[a-z0-9A-Z]{4,}";       

    public Validator(){    }       


    public boolean validate(String pattern, String input){       
       Pattern regEx = Pattern.compile(pattern);       
       Matcher match = regEx.matcher(input);       
       return match.matches(); 
    }       

    public boolean checkEmpty(String email, String password){       
       return  email.isEmpty() || password.isEmpty();   
    }

    public boolean validateEmail(String email){                       
       return validate(emailPattern,email);   
    }

    public boolean validateName(String name){
       return validate(namePattern,name); 
    }       

    public boolean validatePassword(String password){
       return validate(passwordPattern,password); 
    }     
    
    public void clear(HttpSession session){
        // set error attributes to show to user
        // reset validation messages after every event submission
        session.setAttribute("emailErr", "Enter email");
        session.setAttribute("passErr", "Enter password");
        session.setAttribute("existErr", "");
        session.setAttribute("nameErr", "Enter name");
    }
 }
