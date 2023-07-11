package com.fabianPalma.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabianPalma.web.models.clickerModelo;

@WebServlet("/ClickerResultServlet")
public class ClickerResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ClickerResultServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        clickerModelo model = (clickerModelo) session.getAttribute("model");
        if (model == null) {
            model = new clickerModelo();
            session.setAttribute("model", model);
        }
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/clickerResult.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
