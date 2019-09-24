/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subjects;

import com.opensymphony.xwork2.ActionSupport;
import models.Subject;

/**
 *
 * @author sanjeewa_s
 */
public class ViewSubjects extends ActionSupport {
    
    private Subject[] subjects;
    
    public ViewSubjects() {
    }
    
    @Override
    public String execute() throws Exception {
        this.subjects = new Subject[5];
        for(Integer  i=0;i<5;i++){
            Subject s = new Subject();
            s.setSub_code(i.toString());
            s.setSub_name("sub_"+i.toString());
            s.setCredit(i);
            this.subjects[i]=s;
        }
        System.out.println(this.subjects.length);
        for(int j=0;j<this.subjects.length;j++){
            System.out.println(this.subjects[j].getSub_name());
        }
        return SUCCESS;
    }

    /**
     * @return the subjects
     */
    public Subject[] getSubjects() {
        return subjects;
    }

    /**
     * @param subjects the subjects to set
     */
    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }
    
}
