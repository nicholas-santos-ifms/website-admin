/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.properties;

import jakarta.validation.constraints.Pattern;
import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author santos
 */
@Configuration
@ConfigurationProperties(prefix = "rpas")
public class RpasProperties {

    private Jwt jwt;
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    private String from;
    private String urlFrontEnd;
    private String resetPasswordUrl;
    private Duration resetPasswordTokenExpiration;
    private Cors cors;
    private String viaCepURL;

    public Jwt getJwt() {
        return jwt;
    }

    public void setJwt(Jwt jwt) {
        this.jwt = jwt;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUrlFrontEnd() {
        return urlFrontEnd;
    }

    public void setUrlFrontEnd(String urlFrontEnd) {
        this.urlFrontEnd = urlFrontEnd;
    }

    public String getResetPasswordUrl() {
        return resetPasswordUrl;
    }

    public void setResetPasswordUrl(String resetPasswordUrl) {
        this.resetPasswordUrl = resetPasswordUrl;
    }

    public Duration getResetPasswordTokenExpiration() {
        return resetPasswordTokenExpiration;
    }

    public void setResetPasswordTokenExpiration(Duration resetTokenExpiration) {
        this.resetPasswordTokenExpiration = resetTokenExpiration;
    }

    public Cors getCors() {
        return cors;
    }

    public void setCors(Cors cors) {
        this.cors = cors;
    }

    public String getViaCepURL() {
        return viaCepURL;
    }

    public void setViaCepURL(String viaCepURL) {
        this.viaCepURL = viaCepURL;
    }
}
