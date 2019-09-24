/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

/**
 *
 * @author sanjeewa_s
 */
public class Authorization implements Interceptor {

    @Override
    public void destroy() {
        System.out.println("inside intercepter destroy method");
    }

    @Override
    public void init() {
        System.out.println("inside intercepter init method");
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
//        System.out.println("inside intercepter pre-intercept  method");
//        
//        String result = ai.invoke();
//    
//        System.out.println("inside intercepter post-intercept  method");
//        return result;

  Map<String, Object> session = ai.getInvocationContext()
    .getSession();

  String userName = (String) session.get("name");
  if (userName == null){
      System.out.println("nulllll");
  }
  if (userName == null || !userName.equals("teacher")) {
      return "input";
  } else {
      System.out.println(userName+"sessionusername");
  }
  return ai.invoke();
    }
    
}
