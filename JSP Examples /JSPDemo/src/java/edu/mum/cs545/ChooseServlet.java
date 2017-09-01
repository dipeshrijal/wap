/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545;

import java.io.IOException;
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
public class ChooseServlet extends HttpServlet {

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
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
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

        if (s.getAttribute("choice") == null) {
            s.setAttribute("choice", new RadioState());
        }

        if (s.getAttribute("choice1") == null) {
            s.setAttribute("choice1", new RadioState());
        }

        if (s.getAttribute("choice2") == null) {
            s.setAttribute("choice2", new RadioState());
        }

        RadioState firstchoice = (RadioState) s.getAttribute("choice");
        RadioState secondchoice = (RadioState) s.getAttribute("choice1");
        RadioState thirdchoice = (RadioState) s.getAttribute("choice2");

        String choice = request.getParameter("radioJSPCool");
        if (choice != null) {
            System.out.println("choice= " + choice);
            if (Integer.parseInt(choice) == 1) {
                firstchoice.setYesCheck("checked");
                firstchoice.setNoCheck(null);
            } else {
                firstchoice.setNoCheck("checked");
                firstchoice.setYesCheck(null);
            }
        } else {
            System.out.println("No choice made");
        }

        String choice1 = request.getParameter("JSFwayCool");
        if (choice1 != null) {
            System.out.println("choice= " + choice1);
            if (Integer.parseInt(choice1) == 1) {
                secondchoice.setYesCheck("checked");
                secondchoice.setNoCheck(null);
            } else {
                secondchoice.setNoCheck("checked");
                secondchoice.setYesCheck(null);
            }
        } else {
            System.out.println("No choice made");
        }

        String choice2 = request.getParameter("moonCheese");
        if (choice2 != null) {
            System.out.println("choice= " + choice2);
            if (Integer.parseInt(choice2) == 1) {
                thirdchoice.setYesCheck("checked");
                thirdchoice.setNoCheck(null);
            } else {
                thirdchoice.setYesCheck(null);
                thirdchoice.setNoCheck("checked");
            }
        } else {
            System.out.println("No choice made");
        }

        request.setAttribute("firstchoice", firstchoice);
        request.setAttribute("secondchoice", secondchoice);
        request.setAttribute("thirdchoice", thirdchoice);

        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }

}
