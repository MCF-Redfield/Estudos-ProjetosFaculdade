/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifg.jdbc.servlet;

import br.edu.ifg.jdbc.dao.CursoDAO;
import br.edu.ifg.jdbc.dto.Curso;
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

/**
 *
 * @author Maxwel
 */
@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        boolean cadastrarPressed = request.getParameter("Cadastrar") != null;
        boolean excluirNomePressed = request.getParameter("ExcluirNome") != null;
        boolean listarPressed = request.getParameter("Listar") != null;
        boolean buscarPressed = request.getParameter("Buscar") != null;
        boolean alterarPressed = request.getParameter("Alterar") != null;

        if (cadastrarPressed) {

            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            Curso curso = new Curso();

            curso.setId(id);

            curso.setNome(nome);

            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.adicionar(curso);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Curso " + curso.getNome()
                        + " adicionado com sucesso");
                out.println("</body>");
                out.println("</html>");

            }

        }

        if (excluirNomePressed) {
            Curso curso = new Curso();
            CursoDAO cursoDAO = new CursoDAO();

            String nome = request.getParameter("nome");
            curso.setNome(nome);
            cursoDAO.removerPorNome(curso);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Curso " + curso.getNome()
                        + " removido com sucesso");
                out.println("</body>");
                out.println("</html>");

            }

        };

        if (listarPressed) {
            Curso curso = new Curso();
            CursoDAO cursoDAO = new CursoDAO();

            List<Curso> listar = cursoDAO.getLista();
            request.setAttribute("listar", listar);
            RequestDispatcher rd = request.getRequestDispatcher("Listar.jsp");
            rd.forward(request, response);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");

                out.println("</body>");
                out.println("</html>");

            }
        };

        if (buscarPressed) {
            /*  Curso curso = new Curso();
             CursoDAO cursoDAO = new CursoDAO();
             int id = Integer.parseInt(request.getParameter("id"));
             List<Curso> buscar = cursoDAO.getLista(id);
             request.setAttribute("buscar", buscar);
             RequestDispatcher rd = request.getRequestDispatcher("buscarPorID.jsp");
             rd.forward(request, response);

             try (PrintWriter out = response.getWriter()) {

             out.println("<html>");
             out.println("<body>");

             out.println("</body>");
             out.println("</html>");

             }
             */
            CursoDAO cursoDAO = new CursoDAO();

            int id = Integer.parseInt(request.getParameter("id"));
            Curso curso = new Curso();

            curso.setId(id);
            curso.setNome(null);
            Curso curso2 = cursoDAO.buscarPorId(curso.getId());

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Achei o danado >>> " + curso2.getId() + " " + curso2.getNome()//curso.getNome()
                );

                out.println("</body>");
                out.println("</html>");

            }
        };

        if (alterarPressed) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            Curso curso = new Curso();

            curso.setId(id);

            curso.setNome(nome);

            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.alterarPorId(curso);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Curso " + curso.getNome()
                        + " alterado com sucesso");
                out.println("</body>");
                out.println("</html>");

            }
        };

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
            Logger.getLogger(CursoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CursoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
