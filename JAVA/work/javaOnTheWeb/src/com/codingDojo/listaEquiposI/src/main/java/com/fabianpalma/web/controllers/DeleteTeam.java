package com.fabianpalma.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabianpalma.web.models.Roster;
import com.fabianpalma.web.models.Team;

@WebServlet("/DeleteTeam")
public class DeleteTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteTeam() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int index = Integer.parseInt(request.getParameter("id"));
		System.out.println("Show team index " + index);
		
		Roster r = (Roster) session.getAttribute("roster");
		Team t = r.getTeam(index);
		System.out.println(t.getTeam_name());
		
		r.deleteTeam(t);
		response.sendRedirect("/TeamRoster/Home");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
