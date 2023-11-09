/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_rastreamento_ip;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author santos
 */
@Entity
public class IpLog implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ipAddress;
    private String username;
    private Long lastLoginAttempt;
    private Boolean successfulLogin;

    public IpLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getLastLoginAttempt() {
        return lastLoginAttempt;
    }

    public void setLastLoginAttempt(Long lastLoginAttempt) {
        this.lastLoginAttempt = lastLoginAttempt;
    }

    public Boolean getSuccessfulLogin() {
        return successfulLogin;
    }

    public void setSuccessfulLogin(Boolean successfulLogin) {
        this.successfulLogin = successfulLogin;
    }
    
}
