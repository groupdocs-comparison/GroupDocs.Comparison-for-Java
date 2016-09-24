package com.groupdocs.ui.comparison;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@WebServlet("/upload")
@MultipartConfig
public class Upload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        // Save source file to temporary folder and keep the path remembered.
        Part source = request.getPart("source");
        if (source != null) {
            Path path = Files.createTempFile("groupdocs-comparison-source-", source.getSubmittedFileName());
            Files.copy(source.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            session.setAttribute("source", path);
        }

        // Save target file to temporary folder and keep the path remembered.
        Part target = request.getPart("target");
        if (target != null) {
            Path path = Files.createTempFile("groupdocs-comparison-target", target.getSubmittedFileName());
            Files.copy(target.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            session.setAttribute("target", path);
        }

        // Save the value of Comparison Type for later use.
        int comparisonType = 5;
        try {
            comparisonType = Integer.parseInt(request.getParameter("comparison-type"));
        } catch (Exception x) {
            // Ignore
        }
        request.getSession().setAttribute("comparison-type", comparisonType);

        // Redirect to Compare servlet
        response.sendRedirect("compare");
    }
}
