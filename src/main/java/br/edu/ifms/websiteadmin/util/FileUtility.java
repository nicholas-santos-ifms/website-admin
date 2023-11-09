/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author nicholas.santos
 */
public class FileUtility {

    /**
     * Captura dados de um arquivo de texto.
     * Este método tem a finalidade de abrir um arquivo de texto e retornar o
     *  seu conteúdo.
     * 
     * @param url
     * @return
     * @throws URISyntaxException
     * @throws IOException 
     */
    public static String getContentFromTextFile(URL url) throws URISyntaxException, IOException {
        File file = new File(url.toURI());
        BufferedReader obj = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String strng;
        while ((strng = obj.readLine()) != null) {
            sb.append(strng);
        }
        
        return sb.toString();
    }
}