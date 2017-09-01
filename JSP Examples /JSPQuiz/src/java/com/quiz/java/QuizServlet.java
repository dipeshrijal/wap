/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.java;

import com.quiz.model.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dipesh
 */
public class QuizServlet extends HttpServlet {

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
        doPost(request, response);
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

        HttpSession s = request.getSession();

        if (s.getAttribute("quiz") == null) {
            s.setAttribute("quiz", new Quiz());
        }

        Quiz q = (Quiz) s.getAttribute("quiz");

        request.setAttribute("age", request.getParameter("age"));

        try {
            if (!q.isValidAge(request.getParameter("age"))) {
                request.setAttribute("error", "The age is not valid.");
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
            } else {
                if (request.getParameter("answer") != null) {
                    String message = q.isCorrect(request.getParameter("answer"));
                    request.setAttribute("message", message);
                    if (q.isCompleted()) {
                        RequestDispatcher view = request.getRequestDispatcher("complete.jsp");
                        view.forward(request, response);
                    } else {
                        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                        view.forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
            request.setAttribute("errorAll", "The fields are not valid. Please fill in all values correctly.");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
    }
}
