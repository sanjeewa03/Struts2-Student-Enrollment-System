/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subjects;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author sanjeewa_s
 */
public class ViewSubjects extends ActionSupport {
    
    private String[] subjects;
    
    public ViewSubjects() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }

    /**
     * @return the subjects
     */
    public String[] getSubjects() {
        return subjects;
    }

    /**
     * @param subjects the subjects to set
     */
    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
    
}
