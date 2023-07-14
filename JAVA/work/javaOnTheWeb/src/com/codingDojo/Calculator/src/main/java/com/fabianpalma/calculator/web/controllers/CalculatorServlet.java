package com.fabianpalma.calculator.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabianpalma.calculator.web.models.Calculator;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        // Obtener el objeto Calculator de la sesión
        Calculator currentCalculator = (Calculator) session.getAttribute("currentCalculator");
        if (currentCalculator == null) {
            currentCalculator = new Calculator();
            session.setAttribute("currentCalculator", currentCalculator);
        }

        // Obtener el número actual de la sesión
        String currentNumber = (String) session.getAttribute("currentNumber");
        if (currentNumber == null) {
            currentNumber = "";
            session.setAttribute("currentNumber", currentNumber);
        }

        // Obtener la lista de resultados de la sesión
        List<String> results = (List<String>) session.getAttribute("results");
        if (results == null) {
            results = new ArrayList<>();
            session.setAttribute("results", results);
        }

     // Obtener el valor del botón presionado o el valor ingresado en el cuadro de entrada
        String character = request.getParameter("character");
        String inputNumber = request.getParameter("inputNumber");

        if (character != null) {
            if (character.equals("=")) {
                if (inputNumber != null && !inputNumber.isEmpty()) {
                    // Usar el valor ingresado en el cuadro de entrada en lugar del número actual
                    currentNumber = inputNumber;
                }
                // Calcular el resultado y agregarlo a la lista de resultados
                String result = currentCalculator.calculate(currentNumber);
                results.add(result);
                currentNumber = result;
            } else if (character.equals("C")) {
                // Reiniciar el número actual y la lista de resultados
                currentNumber = "";
                results.clear();
            } else {
                // Actualizar el número actual según el botón presionado
                currentNumber = currentCalculator.updateNumber(character, currentNumber);
            }
            session.setAttribute("currentNumber", currentNumber);
        }

        // Configurar los atributos para mostrar en la página JSP
        request.setAttribute("currentNumber", currentNumber);
        request.setAttribute("results", results);

        // Redireccionar a la página JSP que mostrará la calculadora
        request.getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        // Obtener el objeto Calculator de la sesión
        Calculator currentCalculator = (Calculator) session.getAttribute("currentCalculator");
        if (currentCalculator == null) {
            currentCalculator = new Calculator();
            session.setAttribute("currentCalculator", currentCalculator);
        }

        // Obtener el número actual de la sesión
        String currentNumber = (String) session.getAttribute("currentNumber");
        if (currentNumber == null) {
            currentNumber = "";
            session.setAttribute("currentNumber", currentNumber);
        }

        // Obtener la lista de resultados de la sesión
        List<String> results = (List<String>) session.getAttribute("results");
        if (results == null) {
            results = new ArrayList<>();
            session.setAttribute("results", results);
        }

        // Obtener el valor del botón presionado
        String character = request.getParameter("character");

        if (character != null) {
            if (character.equals("=")) {
                // Calcular el resultado y agregarlo a la lista de resultados
                String result = currentCalculator.calculate(currentNumber);
                results.add(result);
                currentNumber = result;
            } else if (character.equals("C")) {
                // Reiniciar el número actual y la lista de resultados
                currentNumber = "";
                results.clear();
            } else {
                // Actualizar el número actual según el botón presionado
                currentNumber = currentCalculator.updateNumber(character, currentNumber);
            }
            session.setAttribute("currentNumber", currentNumber);
        }

        // Configurar los atributos para mostrar en la página JSP
        request.setAttribute("currentNumber", currentNumber);
        request.setAttribute("results", results);

        // Redireccionar a la página JSP que mostrará la calculadora
        request.getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
    }



}
