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
import model.Jogo;
import service.VerificaJogo;
import persistence.dao.DesenvolvedoraDAO;
import persistence.dao.JogoDAO;

/**
 *
 * @author Matheus Correia
 */
@WebServlet(name = "JogoServlet", urlPatterns = {"/JogoServlet"})
public class JogoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InterruptedException
     */
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            boolean cadastrarPressed = request.getParameter("Cadastrar") != null;
            boolean listarPressed = request.getParameter("Listar") != null;
            boolean addPressed = request.getParameter("Add") != null;
            
            
            
            if (addPressed) {
                RequestDispatcher rd = request.getRequestDispatcher("CadastrarJogo.html");
                rd.forward(request, response);
            }

            if (cadastrarPressed) {
                out.println("<h1>Testando<h>");
                
                Jogo jogo = new Jogo();
                JogoDAO jogoDAO = new JogoDAO();
                //Desenvolvedora desenv = new Desenvolvedora();
                DesenvolvedoraDAO desenvDAO = new DesenvolvedoraDAO();
                VerificaJogo verifJogo = new VerificaJogo();
                
                String nome = request.getParameter("nome");
                String plataforma = request.getParameter("plataforma");
                String genero = request.getParameter("genero");
                String status = request.getParameter("status");
                String desenv1 = request.getParameter("desenv");
                if(desenv1.isEmpty())
                {
                   desenv1="0";
                }
                int desenv2 = Integer.parseInt(desenv1);
                
                
                jogo.setNome(nome);
                jogo.setPlataforma(plataforma);
                jogo.setGenero(genero);
                jogo.setStatus(status);
                jogo.setDesenv(/*desenv = */desenvDAO.buscarPorId(desenv2));
                
                boolean resultado = verifJogo.adicionarJogo(jogo);
                if(resultado)
                    jogoDAO.adicionar(jogo);
                
                request.setAttribute("resultado", VerificaJogo.resultado1);
                RequestDispatcher dispatcher = request.getRequestDispatcher("JogoView.jsp");
                dispatcher.forward(request, response);
                /*
                if (aux == 1)
                {
                    jogo.setNome("ermac");
                    request.setAttribute("nome2", jogo);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("JogoView.jsp");
                    dispatcher.forward(request, response);

                }
                else if (aux == 2)
                    {
                        request.setAttribute("nome2", jogo.getDesenv().getCod());
                        RequestDispatcher dispatcher = request.getRequestDispatcher("JogoView.jsp");
                        dispatcher.forward(request, response);
                    }
                    else if (aux == 3)
                        {
                            jogoDAO.adicionar(jogo);
                            request.setAttribute("nome2", jogo);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("JogoView.jsp");
                            dispatcher.forward(request, response);
                        }
                */
            }
                    

            if (listarPressed) {

                JogoDAO jogoDAO = new JogoDAO();
                List<Jogo> listar_jogo = jogoDAO.getLista();
                request.setAttribute("listar_jogo", listar_jogo);
                RequestDispatcher rd = request.getRequestDispatcher("Listar_Jogo.jsp");
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
            Logger.getLogger(JogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(JogoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(JogoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
