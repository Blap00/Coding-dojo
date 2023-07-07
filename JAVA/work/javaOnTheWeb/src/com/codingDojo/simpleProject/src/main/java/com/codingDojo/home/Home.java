package com.codingDojo.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String languageProg = request.getParameter("languageProg");
        String hometown = request.getParameter("hometown");
        
        if (firstName == null || firstName.isEmpty()) {
			firstName = "Unknown";
		}
		if (lastName == null || lastName.isEmpty()) {
			lastName = "";
		}
		if (languageProg == null || languageProg.isEmpty()) {
			languageProg = "Unknown";
		}
		if (hometown == null || hometown.isEmpty()) {
			hometown = "Unknown";
		}
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<h1>Welcome, " + firstName +" "+ lastName + "</h1>");
        out.write("<br>");
        out.write("<h2> Your favorite language is: " + languageProg + "</h2>");
        out.write("<h2> Your hometown is: " + hometown + "</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
