package com.fabianpalma.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabianpalma.web.models.Player;
import com.fabianpalma.web.models.Team;


@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeletePlayer() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int index = Integer.parseInt(request.getParameter("teamid"));
		int indextwo = Integer.parseInt(request.getParameter("playerid"));
		System.out.println("Show team index " + index);
		System.out.println("Show player index " + indextwo);
		
		Team t = (Team) session.getAttribute("team");
		Player p = t.getPlayer(indextwo);
		System.out.println(t.getPlayer(indextwo).getFirst_name());
		
		t.deletePlayer(p);
		response.sendRedirect("/TeamRoster/teams?id=" + index);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
