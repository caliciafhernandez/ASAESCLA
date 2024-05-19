package com.asaescla.controller;

import com.github.adminfaces.template.session.AdminSession;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;

/**
 * Created by rmpestano on 04/02/17.
 */
@Named
@SessionScoped
@Specializes
public class LogonMB extends AdminSession implements Serializable {

    private String currentUser;
    private String email;
    private String password;
    private boolean remember;
    private String loginUser;

    public String doLogon() {
        String _return = "", messg = "Inicio de sesion incorrecto";
        Boolean keepMsj = true;
        String index = "/index.xhtml?faces-redirect=true";
        String login = "/login.xhtml?faces-redirect=true";
        _return = login;
        currentUser = null;        
        
        if( loginUser.equals("admin") && password.equals("123456") ){
            _return = index;
            currentUser = "admin:123456";
            messg = "Inicio de sesion correcto";
        }
        
        Faces.getFlash().setKeepMessages(keepMsj);
        Messages.addGlobalInfo(messg);
        return _return;        
    }

    @Override
    public boolean isLoggedIn() {
        return currentUser != null;
    }    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }
    
    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }    
}
