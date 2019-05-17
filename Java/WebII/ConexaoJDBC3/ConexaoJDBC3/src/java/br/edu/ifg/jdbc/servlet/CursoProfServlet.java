/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifg.jdbc.servlet;

import br.edu.ifg.jdbc.dao.CursoDAO;
import br.edu.ifg.jdbc.dao.CursoProfDAO;
import br.edu.ifg.jdbc.dao.DisciplinaDAO;
import br.edu.ifg.jdbc.dao.ProfessorDAO;
import br.edu.ifg.jdbc.dto.Curso;
import br.edu.ifg.jdbc.dto.CursoProf;
import br.edu.ifg.jdbc.dto.Disciplina;
import br.edu.ifg.jdbc.dto.Professor;
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
 * @author Mcf
 */
@WebServlet(name = "CursoProfServlet", urlPatterns = {"/CursoProfServlet"})
public class CursoProfServlet extends HttpServlet {

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
        
        if (cadastrarPressed) {

            CursoProf cp = new CursoProf();
            CursoProfDAO cpDAO = new CursoProfDAO();
            CursoDAO cursoDAO = new CursoDAO();
            ProfessorDAO profDAO = new ProfessorDAO();

            int idP = Integer.parseInt(request.getParameter("prof"));
            int idC = Integer.parseInt(request.getParameter("curso"));

            Curso curso = cursoDAO.buscarPorId(idC);
            Professor prof = profDAO.buscarPorId(idP);
            
            cp.setCurso(curso);
            cp.setProf(prof);
            cpDAO.adicionar(cp);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Relação Curso/Professor " 
                        + " adicionada com sucesso");
                out.println("</body>");
                out.println("</html>");

            }

        };

        if (excluirNomePressed) {
            CursoProfDAO cpDAO = new CursoProfDAO();

            int idP = Integer.parseInt(request.getParameter("prof"));
            int idC = Integer.parseInt(request.getParameter("curso"));
            cpDAO.removerPorID(idP,idC);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Curso " + idC + " e Professor " + idP
                        + " removidos com sucesso");
                out.println("</body>");
                out.println("</html>");

            }

        };

        if (listarPressed) {

            CursoProfDAO cpDAO = new CursoProfDAO();
            List<CursoProf> listacp = cpDAO.getLista();
            request.setAttribute("listacp", listacp);
            RequestDispatcher rd = request.getRequestDispatcher("ListaCP.jsp");
            rd.forward(request, response);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");

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
            Logger.getLogger(CursoProfServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CursoProfServlet.class.getName()).log(Level.SEVERE, null, ex);
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
