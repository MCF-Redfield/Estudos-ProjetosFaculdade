/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifg.jdbc.servlet;

import br.edu.ifg.jdbc.dao.CursoDAO;
import br.edu.ifg.jdbc.dao.DisciplinaDAO;
import br.edu.ifg.jdbc.dto.Curso;
import br.edu.ifg.jdbc.dto.Disciplina;
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
@WebServlet(name = "DisciplinaServlet", urlPatterns = {"/DisciplinaServlet"})
public class DisciplinaServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        boolean cadastrarPressed = request.getParameter("Cadastrar") != null;
        boolean excluirNomePressed = request.getParameter("ExcluirNome") != null;
        boolean listarPressed = request.getParameter("Listar") != null;
        boolean buscarPressed = request.getParameter("Buscar") != null;
        boolean alterarPressed = request.getParameter("Alterar") != null;

        if (cadastrarPressed) {

            Disciplina disc = new Disciplina();
            DisciplinaDAO discDAO = new DisciplinaDAO();

            CursoDAO cursoDAO = new CursoDAO();

            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            int curso2 = Integer.parseInt(request.getParameter("curso"));

            Curso curso = cursoDAO.buscarPorId(curso2);
            disc.setId(id);
            disc.setCurso(curso);
            disc.setNome(nome);

            discDAO.adicionar(disc);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Disciplina " + disc.getNome()
                        + " adicionada com sucesso");
                out.println("</body>");
                out.println("</html>");

            }

        };

        if (excluirNomePressed) {
            Disciplina disc = new Disciplina();
            DisciplinaDAO discDAO = new DisciplinaDAO();

            String nome = request.getParameter("nome");
            disc.setNome(nome);
            discDAO.removerPorNome(disc);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Curso " + disc.getNome()
                        + " removido com sucesso");
                out.println("</body>");
                out.println("</html>");

            }

        };

        if (listarPressed) {

            DisciplinaDAO discDAO = new DisciplinaDAO();
            List<Disciplina> listar_disc = discDAO.getLista();
            request.setAttribute("listar_disc", listar_disc);
            RequestDispatcher rd = request.getRequestDispatcher("Listar_Disc.jsp");
            rd.forward(request, response);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");

                out.println("</body>");
                out.println("</html>");

            }
        };

        if (buscarPressed) {
            DisciplinaDAO discDAO = new DisciplinaDAO();

            int id = Integer.parseInt(request.getParameter("id"));
            Disciplina disc = new Disciplina();

            disc.setId(id);
            disc.setNome(null);
            disc.setCurso(null);
            Disciplina disc2 = discDAO.buscarPorId(disc.getId());

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Achei a danada >>> ID:" + disc2.getId() + "____Nome:" + disc2.getNome() + "____Curso: " + disc2.getCurso().getNome());
                out.println("</body>");
                out.println("</html>");

            }
        };

        if (alterarPressed) {
            Disciplina disc = new Disciplina();
            CursoDAO cursoDAO = new CursoDAO();
            DisciplinaDAO discDAO = new DisciplinaDAO();

            int id = Integer.parseInt(request.getParameter("id"));
            int curso2 = Integer.parseInt(request.getParameter("curso"));
            String nome = request.getParameter("nome");

            Curso curso = cursoDAO.buscarPorId(curso2);

            disc.setId(id);
            disc.setNome(nome);
            disc.setCurso(curso);

            discDAO.alterarPorId(disc);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Curso " + disc.getNome()
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
            Logger.getLogger(DisciplinaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DisciplinaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
