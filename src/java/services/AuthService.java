/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bcrypt.BCrypt;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
/**
 *
 * @author sanjeewa_s
 */
public class AuthService {
    
    private Connection con;
    private User user =new User();
    
    //authenticate user
    public String authenticate(User user) {
        if(this.isExist(user)){
            this.user = this.getUser(user);
            String generatedSecuredPasswordHash = BCrypt.hashpw(user.getUsername(), BCrypt.gensalt(12));
            System.out.println(generatedSecuredPasswordHash);
            System.out.println(this.user.getPassword());
            System.out.println(user.getPassword());
            boolean matched = BCrypt.checkpw(user.getPassword(), generatedSecuredPasswordHash);
        System.out.println(matched);
            if(matched){
                if("student".equals(this.user.getRole())){
                    return "student";
                }
                if("teacher".equals(this.user.getRole())){
                    return "teacher";
                }
            }
            return "incorrect password";
        }
        return "user not found";
    }
    
   
    
    private User getUser(User user){
        
        try{
            this.con = DBConnection.connect();
            PreparedStatement  stm = con.prepareStatement("SELECT * FROM `users` WHERE `username`=?");
            stm.setString(1,user.getUsername());
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                this.user.setUsername(username);
                this.user.setPassword(password);
                this.user.setRole(role);
                return this.user;
            }
                return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(AuthService.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            DBConnection.closeConnection();
            System.out.println(user.getPassword()+"get user");
        }
        return null;
    }
    
    //check is user exist
    private boolean isExist(User user){
        System.out.println(user.getPassword()+"is exist");
        try{
            this.con = DBConnection.connect();
            PreparedStatement  stm = con.prepareStatement("SELECT `username` FROM `users` WHERE `username`=?");
            stm.setString(1,user.getUsername());
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(AuthService.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            DBConnection.closeConnection();
        }
        return false;
    }
}