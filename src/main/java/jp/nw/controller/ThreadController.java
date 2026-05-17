package jp.nw.controller;

import java.io.IOException;
import java.lang.management.ThreadInfo;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.nw.dao.ThreadDao;
import jp.nw.dto.*;

/**
 * Servlet implementation class UserView
 */
@WebServlet("/ThreadController")
public class ThreadController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ThreadDao dao = new ThreadDao();

		List<ThreadDto> threadList = dao.findAll();

		request.setAttribute("threadList", threadList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/thread/ThreadList.jsp");

		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
