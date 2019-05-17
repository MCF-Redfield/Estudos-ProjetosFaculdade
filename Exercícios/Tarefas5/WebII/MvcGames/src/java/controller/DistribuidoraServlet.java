/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Distribuidora;
import service.VerificaDistribuidora;
import persistence.dao.DistribuidoraDAO;

/**
 *
 * @author Matheus Correia
 */
//@WebServlet(name = "DistribuidoraServlet", urlPatterns = {"/disttr"})
public class DistribuidoraServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {

            boolean cadastrarPressed = request.getParameter("Cadastrar") != null;
            boolean listarPressed = request.getParameter("Listar") != null;
            boolean addPressed = request.getParameter("Add") != null;

            if (addPressed)
            {
                RequestDispatcher rd = request.getRequestDispatcher("CadastrarDistribuidora.html");
                rd.forward(request, response);
            }

            if (cadastrarPressed)
            {
                String nome = request.getParameter("nome");
                String sede = request.getParameter("sede");

                Distribuidora dist = new Distribuidora();
                DistribuidoraDAO distDAO = new DistribuidoraDAO();
                VerificaDistribuidora verifDist = new VerificaDistribuidora();

                dist.setNome(nome);
                dist.setSede(sede);

                if (verifDist.adicionarDist(dist))
                {
                    distDAO.adicionar(dist);
                } else
                    {
                    dist.setNome(null);
                    dist.setSede(null);
                    }
                
                request.setAttribute("nome2", dist.getNome());
                RequestDispatcher dispatcher = request.getRequestDispatcher("DistribuidoraView.jsp");
                dispatcher.forward(request, response);
            }

            if (listarPressed) {

                DistribuidoraDAO discDAO = new DistribuidoraDAO();
                List<Distribuidora> listar_dist = discDAO.getLista();
                request.setAttribute("listar_dist", listar_dist);
                RequestDispatcher rd = request.getRequestDispatcher("Listar_Dist.jsp");
                rd.forward(request, response);

            };
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DistribuidoraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DistribuidoraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
