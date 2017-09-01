package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet( urlPatterns = {"/"})
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("hello world");
//		HttpSession s = request.getSession();
//
//		if (s.getAttribute("quiz") == null) {
//			s.setAttribute("quiz", new Quiz());
//		}
//		
//		Quiz q = (Quiz) s.getAttribute("quiz");
//		
//		request.setAttribute("quiz", q);
//		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
//		view.forward(request, response);
	}

}


//try {
//	int age = Integer.parseInt(request.getParameter("age"));
//	if (age < 4 && age > 100) {
//		request.setAttribute("error", "The number must be within the range.");
//		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
//		view.forward(request, response);
//	}
//} catch (Exception e) {
//	request.setAttribute("error", "The number must be within the range.");
//	RequestDispatcher view = request.getRequestDispatcher("index.jsp");
//	view.forward(request, response);
//}
