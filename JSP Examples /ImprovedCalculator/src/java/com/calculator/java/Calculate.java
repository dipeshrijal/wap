/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calculator.java;

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
        String sumA = request.getParameter("field1");
        String sumB = request.getParameter("field2");

        String multA = request.getParameter("field3");
        String multB = request.getParameter("field4");

        int sumResult = 0, multResult = 0;

        if (!sumA.isEmpty() && !sumB.isEmpty()) {
            sumResult = Integer.parseInt(sumA) + Integer.parseInt(sumB);
        }

        if (!multA.isEmpty() && !multB.isEmpty()) {
            multResult = Integer.parseInt(multA) * Integer.parseInt(multB);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("   <h1>Simple Calculator</h1>\n"
                + "        <form method=\"Post\" action=\"Calculate\">\n"
                + "            <div>\n"
                + "                <input type=\"text\" name=\"field1\" value=\"" + sumA + "\">\n"
                + "                <span>+</span>\n"
                + "                <input type=\"text\" name=\"field2\" value=\"" + sumB + "\">\n"
                + "                <span>=</span>\n"
                + "                <input type=\"text\" readonly  name=\"sumResult\" value=\"" + sumResult + "\"/> \n"
                + "            </div>\n"
                + "            <div>\n"
                + "                <input type=\"text\" name=\"field3\" value=\"" + multA + "\">\n"
                + "                <span>*</span>\n"
                + "                <input type=\"text\" name=\"field4\" value=\"" + multB + "\">\n"
                + "                <span>=</span>\n"
                + "                <input type=\"text\" readonly name=\"multResult\" value=\"" + multResult + "\"/> \n"
                + "            </div>\n"
                + "            <br>\n"
                + "            <br>\n"
                + "            <div>\n"
                + "                <input type=\"submit\" value=\"Calculate\">\n"
                + "            </div>\n"
                + "        </form>");
    }

}
