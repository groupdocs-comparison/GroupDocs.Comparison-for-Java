package com.groupdocs.ui.comparison;

import com.groupdocs.comparison.Comparison;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet("/compare")
public class Compare extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // It is assumed that we are redirected here by Upload servlet
        // here so we already know paths of source, target and comparison-type
        Path source = (Path) request.getSession().getAttribute("source");
        Path target = (Path) request.getSession().getAttribute("target");
        int comparisonType = (int) request.getSession().getAttribute("comparison-type");
        Path result = Files.createTempFile("groupdocs-comparison-result-", ".docx");

        // Now do the comparison
        Comparison comparison = new Comparison();
        try {
            comparison.compare(source.toString(), target.toString(), result.toString(), comparisonType);
            // Save path to result file for later use
            request.getSession().setAttribute("result", result);
        } catch (Exception x) {
            throw new ServletException(x);
        }

        // Redirect to Download servlet
        response.sendRedirect("download");
    }
}
