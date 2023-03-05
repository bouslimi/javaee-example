package com.trigger_soft.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.trigger_soft.controllers.Login;

public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String areCredentialsOK;

	public Signin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		areCredentialsOK = null;
		request.setAttribute("areCredentialsOK", areCredentialsOK);
		this.getServletContext().getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login login = new Login();
		String areCredentialsOK = login.checkCredentials(request);
		if (areCredentialsOK.equals("OK")) {
			response.sendRedirect(response.encodeRedirectURL("./profile"));
		} else {
			request.setAttribute("areCredentialsOK", areCredentialsOK);
			this.getServletContext().getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
		}
	}

}