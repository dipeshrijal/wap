/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dipesh
 */
public class Quiz extends HttpServlet {

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
            s.setAttribute("quiz", new QuizConstruct());
        }  
        
        QuizConstruct q = (QuizConstruct) s.getAttribute("quiz");
        q.isCorrect(request.getParameter("answer"));
        if (q.isCompleted()) {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Quiz</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div> <h1>The Number Quiz</h1>");
            out.println("Your current score is " + q.getScore() + ".");
            out.println("<p>You have completed the Number Quiz, with a score of " + q.getScore() + " out of 5.</p>");
            out.println("</body>");
            out.println("</html>");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Quiz</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div> <h1>The Number Quiz</h1>");
            out.println("Your current score is " + q.getScore() + ".");
            out.println("<p>Guess the next number in the sequence</p>");
            out.println("<p>" + q.getQuestion() + "</p>");
            out.println("<form action=\"evaluate\" method=\"POST\">");
            out.println("<div><label>Your answer: <input type=\"text\" required=\"required\" name=\"answer\"></label></div>");
            out.println("<div><input type=\"submit\" value=\"Submit\"></div>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
