package com.miproyecto.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
    maxFileSize = 1024 * 1024 * 10,      // 10 MB
    maxRequestSize = 1024 * 1024 * 15    // 15 MB
)
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        
        File dir = new File(uploadPath);
        if (!dir.exists()) {
            dir.mkdir();
        }

        try {
            Part filePart = req.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String rutaCompleta = uploadPath + File.separator + fileName;

            filePart.write(rutaCompleta);
            req.getSession().setAttribute("message", "Archivo '" + fileName + "' subido exitosamente.");

        } catch (Exception e) {
            req.getSession().setAttribute("message", "Error al subir el archivo: " + e.getMessage());
        }

        res.sendRedirect(req.getContextPath() + "/perfil.jsp");
    }
}