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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Desenvolvedora;
import service.VerificaDesenvolvedora;
import persistence.dao.DesenvolvedoraDAO;
import persistence.dao.DistribuidoraDAO;

/**
 *
 * @author Matheus Correia
 */
public class DesenvolvedoraServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            boolean cadastrarPressed = request.getParameter("Cadastrar") != null;
            boolean listarPressed = request.getParameter("Listar") != null;
            boolean addPressed = request.getParameter("Add") != null;
                        
            if (addPressed) {
                RequestDispatcher rd = request.getRequestDispatcher("CadastrarDesenvolvedora.html");
                rd.forward(request, response);
            }

            if (cadastrarPressed) {
                                                                
                String nome = request.getParameter("nome");
                String sede = request.getParameter("sede");
                String dist3 = request.getParameter("dist");
                if(dist3.isEmpty())
                {
                    dist3="0";
                }
                int dist2 = Integer.parseInt(dist3);
            
                Desenvolvedora desenv = new Desenvolvedora();
                DesenvolvedoraDAO desenvDAO = new DesenvolvedoraDAO();
                VerificaDesenvolvedora verifDesenv = new VerificaDesenvolvedora();
                DistribuidoraDAO distDAO = new DistribuidoraDAO();
                
                desenv.setNome(nome);
                desenv.setSede(sede);
                desenv.setDist(distDAO.buscarPorId(dist2));
                /*
                if(dist.getCod()==0)
                    dist.setCod(-1);
*/

                int aux = verifDesenv.adicionarDesenv(desenv);
                
                if (aux == 1)
                {   
                    desenv.setNome("ermac");
                    request.setAttribute("nome2", desenv);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("DesenvolvedoraView.jsp");
                    dispatcher.forward(request, response);

                }
                else if (aux == 2)
                     {   
                        request.setAttribute("nome2", desenv.getDist().getCod());
                        RequestDispatcher dispatcher = request.getRequestDispatcher("DesenvolvedoraView.jsp");
                        dispatcher.forward(request, response);
                     }
                     else if(aux == 3)
                          {
                            desenvDAO.adicionar(desenv);
                            request.setAttribute("nome2", desenv);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("DesenvolvedoraView.jsp");
                            dispatcher.forward(request, response);
                          }
            }

            if (listarPressed) {

                DesenvolvedoraDAO desenvDAO = new DesenvolvedoraDAO();
                List<Desenvolvedora> listar_desenv = desenvDAO.getLista();
                request.setAttribute("listar_desenv", listar_desenv);
                RequestDispatcher rd = request.getRequestDispatcher("Listar_Desenv.jsp");
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
            Logger.getLogger(DesenvolvedoraServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DesenvolvedoraServlet.class.getName()).log(Level.SEVERE, null, ex);
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
