/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.properties;

/**
 *
 * @author santos
 */
public class Cors {
    private String allowHeaders;
    private String allowOrigins;

    public String getAllowHeaders() {
        return allowHeaders;
    }

    public void setAllowHeaders(String allowHeaders) {
        this.allowHeaders = allowHeaders;
    }
    
    public String getAllowOrigins() {
        return allowOrigins;
    }

    public void setAllowOrigins(String allowOrigins) {
        this.allowOrigins = allowOrigins;
    }
}
