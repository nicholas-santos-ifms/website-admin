/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.util;

import br.edu.ifms.websiteadmin.types.ResponseStatus;
import br.edu.ifms.websiteadmin.types.ResponseStatus.StatusCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

/**
 *
 * @author santos
 */
public class ResponseWriterUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ResponseWriterUtil.class);

    public static void writeResponse(HttpServletResponse response, String message) {
        try ( PrintWriter writer = response.getWriter()) {
            writer.write(message);
            writer.flush();
        } catch (IOException ie) {
            LOG.error("Problem writing output to response!", ie);
        }
    }

    public static void writeErrorResponse(HttpServletResponse response, String message) {
        ResponseStatus status = new ResponseStatus();
        status.setStatusCode(ResponseStatus.StatusCode.ERROR);
        status.setMessage(message);

        try ( PrintWriter writer = response.getWriter()) {
            String json = new ObjectMapper().writeValueAsString(status);

            writer.write(json);
            writer.flush();
        } catch (IOException ie) {
            LOG.error("Problem writing output to response!", ie);
        }
    }
    
    public static void writeResponse(HttpServletResponse response, String message, StatusCode statusCode) {
        ResponseStatus status = new ResponseStatus();
        status.setStatusCode(statusCode);
        status.setMessage(message);
                
        response.setContentType("application/json");
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        
        try (PrintWriter writer = response.getWriter()) {
            String json = new ObjectMapper().writeValueAsString(status);
                        
            writer.write(json);
            writer.flush();
        } catch (IOException ie) {
            LOG.error("Problem writing output to response!", ie);
        }
    }
}
