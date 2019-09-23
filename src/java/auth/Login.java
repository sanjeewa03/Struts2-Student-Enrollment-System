/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import com.opensymphony.xwork2.ActionSupport;
import models.User;
import services.AuthService;
import models.Error;

/**
 *
 * @author sanjeewa_s
 */
public class Login extends ActionSupport {
    private User user;
    private Error error = new Error();
    public Login() {
    }
    
    public String execute() throws Exception {
        AuthService auth = new AuthService();
        System.out.println(this.getUser().getUsername());
        System.out.println(this.getUser().getPassword());
        String msg = auth.authenticate(this.getUser());
        System.out.println(msg);
        if("student".equals(msg)){
            this.error.setError(msg);
            return SUCCESS+",student";
        }
        else if("teacher".equals(msg)){
            this.error.setError(msg);
            return SUCCESS+",teacher";
        }
        else if("user not found".equals(msg)){
            this.error.setError(msg);
            return INPUT;
        }
        else if("incorrect password".equals(msg)){
            this.error.setError(msg);
            return INPUT;
        }
        return INPUT;
    }
    
    /*login form validation*/
    /*@Override
    public void validate(){
        if(!"user not found".equals(this.error.getError())){
            addFieldError("username", "Check the Username");
        }
        else if(!"incorrect password".equals(this.error.getError())){
            addFieldError("username", "Wrong Password");
        }
    }*/

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @return the error
     */
    public Error getError() {
        return error;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @param error the error to set
     */
    public void setError(Error error) {
        this.error = error;
    }
}

