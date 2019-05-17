/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifg.jdbc.servlet;

import br.edu.ifg.jdbc.dao.ProfessorDAO;
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
 * @author Maxwel
 */
@WebServlet(name = "ProfessorServlet", urlPatterns = {"/ProfessorServlet"})
public class ProfessorServlet extends HttpServlet {

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

        boolean casdastrarPressed = request.getParameter("Cadastrar") != null;
        boolean excluirNomePressed = request.getParameter("ExcluirNome") != null;
        boolean listarPressed = request.getParameter("Listar") != null;
        boolean buscarPressed = request.getParameter("Buscar") != null;
        boolean alterarPressed = request.getParameter("Alterar") != null;

        if (casdastrarPressed) {
            Professor professor = new Professor();
            ProfessorDAO professorDAO = new ProfessorDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String op = request.getParameter("oper");
            int cod = Integer.parseInt(request.getParameter("codigo"));

            switch (op) {
                case "efet": {
                    professor.setId(id);
                    professor.setNome(nome);
                    professor.setnumSiape(cod);

                    professorDAO.adicionarefet(professor);

                    try (PrintWriter out = response.getWriter()) {

                        out.println("<html>");
                        out.println("<body>");
                        out.println("Professor Efetivo " + professor.getNome()
                                + " adicionado com sucesso");
                        out.println("</body>");
                        out.println("</html>");

                    }
                    break;
                }
                case "subs": {
                    professor.setId(id);
                    professor.setNome(nome);
                    professor.setcodContrato(cod);

                    professorDAO.adicionarsubs(professor);

                    try (PrintWriter out = response.getWriter()) {

                        out.println("<html>");
                        out.println("<body>");
                        out.println("Professor Substituto " + professor.getNome()
                                + " adicionado com sucesso");
                        out.println("</body>");
                        out.println("</html>");

                    }
                    break;
                }
            }

        };

        if (excluirNomePressed) {
            Professor professor = new Professor();
            ProfessorDAO professorDAO = new ProfessorDAO();

            String nome = request.getParameter("nome");
            professor.setNome(nome);
            professorDAO.removerPorNome(professor);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Professor " + professor.getNome()
                        + " removido com sucesso");
                out.println("</body>");
                out.println("</html>");

            }

        };

        if (listarPressed) {
            Professor professor = new Professor();
            ProfessorDAO professorDAO = new ProfessorDAO();

            List<Professor> listar = professorDAO.getLista();
            request.setAttribute("listar", listar);
            RequestDispatcher rd = request.getRequestDispatcher("Listarprof.jsp");
            rd.forward(request, response);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");

                out.println("</body>");
                out.println("</html>");

            }
        };

        if (buscarPressed) {

            ProfessorDAO profDAO = new ProfessorDAO();

            int id = Integer.parseInt(request.getParameter("id"));

            Professor prof = profDAO.buscarPorId(id);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Aqui o danado do Teacher>>  Nome: " + prof.getNome() + "    ID:" + prof.getId());
                out.println("</body>");
                out.println("</html>");

            }

            /*CursoDAO cursoDAO = new CursoDAO();

             int id = Integer.parseInt(request.getParameter("id"));
             Curso curso = new Curso();
            
             curso.setId(id);
             curso.setNome(null);
             Curso curso2  = cursoDAO.buscarPorId(curso.getId());

             try (PrintWriter out = response.getWriter()) {

             out.println("<html>");
             out.println("<body>");
             out.println("Curso ID" + curso2.getId() + curso2.getNome()//curso.getNome()
             );

             out.println("</body>");
             out.println("</html>");

             }*/
        };

        if (alterarPressed) {
            Professor professor = new Professor();
            ProfessorDAO professorDAO = new ProfessorDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String op = request.getParameter("oper");
            int cod = Integer.parseInt(request.getParameter("codigo"));

            switch (op) {
                case "efet": {

                    professor.setId(id);

                    professor.setNome(nome);

                    professor.setnumSiape(cod);

                    professor.setcodContrato(0);

                    professorDAO.alterarPorId(professor);

                    try (PrintWriter out = response.getWriter()) {

                        out.println("<html>");
                        out.println("<body>");
                        out.println("Professor Efetivo " + professor.getNome()
                                + " alterado com sucesso");
                        out.println("</body>");
                        out.println("</html>");
                    }
                    break;

                }

                case "subs": {

                    professor.setId(id);

                    professor.setNome(nome);

                    professor.setcodContrato(cod);
                    professor.setnumSiape(0);

                    professorDAO.alterarPorId(professor);

                    try (PrintWriter out = response.getWriter()) {

                        out.println("<html>");
                        out.println("<body>");
                        out.println("Professor Substituto " + professor.getNome()
                                + " alterado com sucesso");
                        out.println("</body>");
                        out.println("</html>");
                    }

                    break;
                }

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
            Logger.getLogger(ProfessorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProfessorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
