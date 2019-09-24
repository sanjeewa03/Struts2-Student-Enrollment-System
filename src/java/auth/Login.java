/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import models.User;
import services.AuthService;
import models.Error;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author sanjeewa_s
 */
public class Login extends ActionSupport implements SessionAware {
    private User user;
    private Error error = new Error();
    private Map<String, Object> userSession;
    public Login() {
    }
    
    
    @Override
    public void setSession(Map<String, Object> session) {
        System.out.println("prepare to set");
        setUserSession(session) ;
    }
    
    public String home(){
        return SUCCESS;
    }
    
    
    
    public String execute() throws Exception {
        AuthService auth = new AuthService();
        System.out.println(this.getUser().getUsername());
        System.out.println(this.getUser().getPassword());
        String msg = auth.authenticate(this.getUser());
        System.out.println(msg);
        if(null != msg)switch (msg) {
            case "student": 
                this.error.setError(msg);
                this.getUserSession().put("name", "student");
                this.getUserSession().put("role","student");
                return SUCCESS+",student";
            case "teacher":
                this.error.setError(msg);
                userSession.put("name", "teacher");
                this.getUserSession().put("role","teacher");
                return SUCCESS+",teacher";
            case "user not found":
                this.error.setError(msg);
                return INPUT;
            case "incorrect password":
                this.error.setError(msg);
                return INPUT;
            default:
                break;
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

    /**
     * @return the userSession
     */
    public Map<String, Object> getUserSession() {
        return userSession;
    }

    /**
     * @param userSession the userSession to set
     */
    public void setUserSession(Map<String, Object> userSession) {
        System.out.println("setted");
        this.userSession = userSession;
    }

}

