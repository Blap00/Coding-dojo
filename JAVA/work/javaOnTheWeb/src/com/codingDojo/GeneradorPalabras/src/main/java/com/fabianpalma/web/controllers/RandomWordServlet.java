package com.fabianpalma.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabianpalma.web.models.RandomWordGenerator;

@WebServlet("/randomWord")
public class RandomWordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        // Obtener el generador de palabras aleatorias de la sesión
        RandomWordGenerator wordGenerator = (RandomWordGenerator) session.getAttribute("wordGenerator");

        // Si el generador no existe en la sesión, crear uno nuevo y guardarlo en la sesión
        if (wordGenerator == null) {
            wordGenerator = new RandomWordGenerator();
            session.setAttribute("wordGenerator", wordGenerator);
        }

        // Generar una palabra aleatoria
        wordGenerator.generateRandomWord();

        // Establecer los atributos en la solicitud (request) para mostrar en la página JSP
        request.setAttribute("randomWord", wordGenerator.getRandomWord());
        request.setAttribute("counter", wordGenerator.getCounter());
        request.setAttribute("lastGeneratedTime", wordGenerator.getLastGeneratedTime());

        // Redireccionar a la página JSP
        request.getRequestDispatcher("/WEB-INF/randomWord.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
