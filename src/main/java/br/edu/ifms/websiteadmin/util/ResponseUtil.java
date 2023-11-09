/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.util;

import br.edu.ifms.websiteadmin.types.ResponseStatus.StatusCode;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author santos
 */
public class ResponseUtil {
    private static final Logger LOG = LoggerFactory.getLogger(ResponseUtil.class);
    
    private static final String TOO_MANY_FAILED_LOGINS = "Muitas tentativas de login malsucedidas. Favor, tente amanhã novamente.";
    private static final String UNAUTHORIZED_ORIGIN = "Você não tem permissão para acessar este recurso dessa origem.";
    private static final String TOO_MANY_FAILED_IP_LOGINS = "Seu endereço IP falhou na autenticação muitas vezes hoje.";
    private static final String INVALID_CREDENTIALS = "Credenciais inválidas";
    
    
    public static void tooManyFailedLogins(HttpServletResponse response) {
        LOG.error("Unauthorized because of too many logins");
        
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); 
        sendResponse(response, TOO_MANY_FAILED_LOGINS);
    }
    
    
    public static void invalidCredentials(HttpServletResponse response) {
        LOG.error("Unauthorized because of invalid credentials");
        
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); 
        sendResponse(response, INVALID_CREDENTIALS);
    }
    
    
    public static void tooManyFailedIpLogins(HttpServletResponse response) {
        LOG.error("Unauthorized because of too many failed ip logins");
        
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); 
        sendResponse(response, TOO_MANY_FAILED_IP_LOGINS);
    }
    
    
    public static void badOrigin(HttpServletResponse response) {
        LOG.error("Unauthorized because of bad origin");
        
        response.setStatus(HttpServletResponse.SC_FORBIDDEN); 
        sendResponse(response, UNAUTHORIZED_ORIGIN);
    }
    
    
    private static void sendResponse(HttpServletResponse response, String message) {
        StatusCode responseStatusCode = getStatusCodeFromResponse(response);
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        
        ResponseWriterUtil.writeResponse(response, message, responseStatusCode);
    }
    
    
    private static StatusCode getStatusCodeFromResponse(HttpServletResponse response) {
        StatusCode statusCode = StatusCode.OK;
        
        if (response.getStatus() == HttpServletResponse.SC_UNAUTHORIZED || 
            response.getStatus() == HttpServletResponse.SC_FORBIDDEN) {
            statusCode = StatusCode.UNAUTHORIZED;
        } else if (response.getStatus() > 399) {
            statusCode = StatusCode.ERROR;
        }
        
        return statusCode;
    }
}
