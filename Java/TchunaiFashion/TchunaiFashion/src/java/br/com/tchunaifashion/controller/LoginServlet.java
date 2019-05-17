/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tchunaifashion.controller;

import br.com.tchunaifashion.model.Cliente;
import br.com.tchunaifashion.persistence.dao.ClienteDAO;
import br.com.tchunaifashion.persistence.dao.PedidoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maxwel
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
      
     response.setContentType("text/html;charset=UTF-8");
     try (PrintWriter out = response.getWriter()) {
           
     out.println("<!DOCTYPE html>");
     out.println("<html>");
     out.println("<head>");
     out.println("<title>Servlet LoginServlet</title>");            
     out.println("</head>");
     out.println("<body>");
     out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
     out.println("</body>");
     out.println("</html>");
     }
     }
     */
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
        request.setAttribute("email", "");
        request.setAttribute("senha", "");
        request.setAttribute("validationmessage", "");
        request.getRequestDispatcher("/login.jsp").forward(request, response);

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
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        ClienteDAO clientedao = new ClienteDAO();
        Cliente cliente = new Cliente();

        cliente.setEmail(email);
        cliente.setSenha(senha);

        request.setAttribute("email", email);
        request.setAttribute("senha", senha);

        if (clientedao.autenticacao(cliente)) {
            HttpSession sessionlogin = request.getSession();
            sessionlogin.setAttribute("cliente", clientedao.buscaClienteEmail(email));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
            
            Cliente cliente1 = (Cliente) sessionlogin.getAttribute("cliente");
            PedidoDAO pedDao = new PedidoDAO();
            
            sessionlogin.setAttribute("listaPedido", pedDao.listaPedPorCli(cliente1.getCpf()));

        } else {
            request.setAttribute("validationmessage", clientedao.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);

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
