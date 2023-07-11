package com.fabianpalma.web.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/guess")
public class GuessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate(); // Reiniciar sesión en cada nuevo juego
		request.getRequestDispatcher("/WEB-INF/resultado.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer numberToGuess = (Integer) session.getAttribute("numberToGuess");
		if (numberToGuess == null) {
			// Generar un nuevo número para adivinar
			Random random = new Random();
			numberToGuess = random.nextInt(100) + 1;
			session.setAttribute("numberToGuess", numberToGuess);
		}

		String guessString = request.getParameter("guess");
		int guess = 0;
		if (guessString != null && !guessString.isEmpty()) {
			guess = Integer.parseInt(guessString);
		}

		String message;
		if (guess == numberToGuess) {
			message = "¡Felicidades! Adivinaste el número.";
			session.removeAttribute("numberToGuess");
		} else if (guess < numberToGuess) {
			message = "Demasiado bajo. Intenta nuevamente.";// NUMERO: "+numberToGuess;
		} else {
			message = "Demasiado alto. Intenta nuevamente.";// NUMERO: "+numberToGuess;
		}

		session.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/resultado.jsp").forward(request, response);
	}

}
