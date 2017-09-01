package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.PostDao;
import com.java.model.Post;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/post.jsp";
	private static String LIST_USER = "/listPost.jsp";
	private PostDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostController() {
		super();
		dao = new PostDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			int postId = Integer.parseInt(request.getParameter("postId"));
			dao.deletePost(postId);
			forward = LIST_USER;
			request.setAttribute("posts", dao.getAllPosts());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int postId = Integer.parseInt(request.getParameter("postId"));
			Post post = dao.getPostById(postId);
			request.setAttribute("post", post);
		} else if (action.equalsIgnoreCase("listPost")) {
			forward = LIST_USER;
			request.setAttribute("posts", dao.getAllPosts());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();

		post.setTitle(request.getParameter("title"));
		post.setDescription(request.getParameter("description"));
		String postid = request.getParameter("postid");
		if (postid == null || postid.isEmpty()) {
			dao.addPost(post);
		} else {
			post.setPostid(Integer.parseInt(postid));
			dao.updatePost(post);
		}
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("posts", dao.getAllPosts());
		view.forward(request, response);
	}

}
