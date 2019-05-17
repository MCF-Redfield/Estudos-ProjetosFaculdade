package Servlet;

import DAO.FornecedorDAO;
import DTO.Fornecedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FornecedorServlet", urlPatterns = {"/FornecedorServlet"})
public class FornecedorServlet extends HttpServlet {

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

        boolean cadastrarPressed = request.getParameter("cadastrar") != null;
        boolean excluirPressed = request.getParameter("excluir") != null;

        if (cadastrarPressed) {
            String cnpj = request.getParameter("cnpj");
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");

            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setNome(nome);
            fornecedor.setCnpj(cnpj);
            fornecedor.setEndereco(endereco);

            fornecedorDAO.add(fornecedor);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Fornecedor " + fornecedor.getNome()
                        + " cadastrado com sucesso!");
                out.println("</body>");
                out.println("</html>");

            }
        }

        if (excluirPressed) {
            Fornecedor fornecedor = new Fornecedor();
            FornecedorDAO fornecedorDAO = new FornecedorDAO();

            String cnpj = request.getParameter("cnpj");
            fornecedor.setCnpj(cnpj);
            fornecedorDAO.remover(cnpj);

            try (PrintWriter out = response.getWriter()) {

                out.println("<html>");
                out.println("<body>");
                out.println("Fornecedor removido com sucesso");
                out.println("</body>");
                out.println("</html>");

            }
        }

        response.setContentType("text/html;charset=UTF-8");

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
            Logger.getLogger(FornecedorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FornecedorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
