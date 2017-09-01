package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.EmployeeDao;
import com.java.model.Employee;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/create")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmployee() {
		super();
		dao = new EmployeeDao();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("createEmployee.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee emp = new Employee();
		emp.setFirstname(request.getParameter("firstname"));
		emp.setLastname(request.getParameter("lastname"));
		dao.addEmployee(emp);
		response.sendRedirect("employee");
	}

}
