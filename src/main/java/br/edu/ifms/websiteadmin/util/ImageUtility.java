/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author santos
 */
public class ImageUtility {

    public static byte[] resizeImageToByte(MultipartFile multipartFile, int targetWidth) {
        try {
            /**
             * Converte o arquivo para BufferedImage para realizar o
             * redimensionamento da imagem
             */
            BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
            BufferedImage resizeImage = Scalr.resize(bi, targetWidth);
            /**
             * Converte a imagem redimensionada para byte
             */
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String type = multipartFile.getContentType().split("/")[1];
            ImageIO.write(resizeImage, type, baos);
            return baos.toByteArray();
        } catch (Exception ex) {
            Logger.getLogger(ImageUtility.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }
}
