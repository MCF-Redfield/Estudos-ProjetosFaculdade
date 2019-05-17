/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.Servicos;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "DistribuiServlet", urlPatterns = {"/DistribuiServlet"})
public class DistribuiServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NullPointerException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            {
                Servicos serv = new Servicos();

                HttpSession sessionQtde = request.getSession();
                boolean tamPressed = request.getParameter("comecar") != null;
                boolean simPressed = request.getParameter("sim") != null;
                boolean naoPressed = request.getParameter("nao") != null;
                int tamanho = 64;
                
                
                sessionQtde.setAttribute("sadqtd", serv.getSadqtd());
                serv.setSadqtd(1);

                if (tamPressed) {

                    out.println("»" + tamanho + "<br><br>");

                    int[][] matriz = serv.cartas(tamanho);

                    HttpSession sessionCartas = request.getSession();
                    sessionQtde.setAttribute("qtde", serv.getQtde());
                    sessionCartas.setAttribute("cartas", matriz);
                    
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("ExibeCartas_1.jsp");
                    dispatcher.forward(request, response);
                    
                } else if (simPressed) {
                    serv.setQtde(1);
                    serv.setSadresult((Integer) sessionQtde.getAttribute("resultado"));
                    if (serv.quantidadeDeCarta(tamanho) != serv.getQtde()) {
                        sessionQtde.setAttribute("qtde", serv.getQtde());
                        response.sendRedirect("ExibeCartas_1.jsp");

                    } else {
                        sessionQtde.setAttribute("sad", serv.getSadresult());
                        serv.setSadqtd(-serv.getSadqtd());
                        serv.setQtde(-serv.quantidadeDeCarta(tamanho));
                        serv.setSadresult(-serv.getSadresult());
                        response.sendRedirect("Resultado.jsp");
                    }

                } else if (naoPressed) {
                    serv.setQtde(1);
                    if (serv.quantidadeDeCarta(tamanho) != serv.getQtde()) {

                        sessionQtde.setAttribute("qtde", serv.getQtde());
                        response.sendRedirect("ExibeCartas_1.jsp");
                    } else {
                        sessionQtde.setAttribute("sad", serv.getSadresult());
                        serv.setSadqtd(-serv.getSadqtd());
                        serv.setQtde(-serv.quantidadeDeCarta(tamanho));
                        serv.setSadresult(-serv.getSadresult());
                        response.sendRedirect("Resultado.jsp");
                    }

                }

            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
