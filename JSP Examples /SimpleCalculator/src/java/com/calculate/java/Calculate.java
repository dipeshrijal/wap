/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calculate.java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dipesh
 */
public class Calculate extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculate</title>");
            out.println("</head>");
            out.println("<body>");
            
            if (request.getParameter("field1") != null && request.getParameter("field2") != null) {
                int input1 = Integer.valueOf(request.getParameter("field1"));
                int input2 = Integer.valueOf(request.getParameter("field2"));
                int sum = input1 + input2;
                out.println("<h1>" + input1 + "+" + input2 + "=" + sum + "</h1>");
            }

            if (request.getParameter("field3") != null && request.getParameter("field4") != null) {
                int input3 = Integer.valueOf(request.getParameter("field3"));
                int input4 = Integer.valueOf(request.getParameter("field4"));
                int multiply = input3 * input4;
                out.println("<h1>" + input3 + "*" + input4 + "=" + multiply + "</h1>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

}
