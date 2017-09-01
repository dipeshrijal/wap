package com.dict.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dict.dao.DictionaryDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class DictServlet
 */
@WebServlet("/dict")
public class DictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DictionaryDao dao;

	/**
	 * Default constructor.
	 */
	public DictServlet() {
		super();
		dao = new DictionaryDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String q = request.getParameter("q");
		Gson gson = new Gson();
		String json = gson.toJson(dao.findWord(q));
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
