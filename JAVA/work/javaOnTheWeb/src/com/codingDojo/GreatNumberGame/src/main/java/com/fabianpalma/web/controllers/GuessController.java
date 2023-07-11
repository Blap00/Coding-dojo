package com.fabianpalma.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fabianpalma.web.models.GuessModel;

@WebServlet("/guess")
public class GuessController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate(); // Reiniciar sesión en cada nuevo juego
        request.getRequestDispatcher("/WEB-INF/resultado.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        GuessModel model = (GuessModel) session.getAttribute("model");

        if (model == null) {
            model = new GuessModel();
            session.setAttribute("model", model);
            model.generateNumber(); // Generar un nuevo número para adivinar
        }

        String guessString = request.getParameter("guess");
        int guess = 0;
        if (guessString != null && !guessString.isEmpty()) {
            guess = Integer.parseInt(guessString);
        }

        model.setUserGuess(guess);
        model.checkGuess();

        request.getRequestDispatcher("/WEB-INF/resultado.jsp").forward(request, response);
    }

}
