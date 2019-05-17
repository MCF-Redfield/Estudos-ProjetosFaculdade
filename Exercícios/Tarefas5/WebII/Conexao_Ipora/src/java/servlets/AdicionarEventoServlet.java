/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.AnuncianteDAO;
import dao.InterfaceEventoDAO;
import dao.fabricaDAO;
import dto.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AdicionarEventoServlet", urlPatterns = {"/AdicionarEventoServlet"})
public class AdicionarEventoServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            Evento evento = new Evento();
            AnuncianteDAO anuncDAO = new AnuncianteDAO();
            //evento.setId(Integer.parseInt(request.getParameter("id")));
            evento.setNome(request.getParameter("nome"));
            evento.setLocal(request.getParameter("local"));
            evento.setDescricao(request.getParameter("descricao"));
            evento.setCampus(request.getParameter("campus"));
            evento.setAnunciante(anuncDAO.buscarPorCPF(request.getParameter("anunciante_id")));

            String dia = request.getParameter("data").substring(0, 2);
            String mes = request.getParameter("data").substring(3, 5);
            String ano = request.getParameter("data").substring(6, 10);
            String startDate = dia + "-" + mes + "-" + ano;
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
            java.util.Date date;
            try {
                date = sdf1.parse(startDate);
                java.sql.Date dataSql = new java.sql.Date(date.getTime());
                //pst.setDate(4, dataSql);
                evento.setData(dataSql);

            } catch (ParseException ex) {
                Logger.getLogger(AdicionarAnuncianteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Não consegui armazenar na base de dados dessa forma!!!Date.valueOf(request.getParameter("data"))
            fabricaDAO fabricaMySqlDAO = fabricaDAO.getFabricaDAO();

            InterfaceEventoDAO daoEvento = fabricaMySqlDAO.getEventoDAO();

            daoEvento.adicionar(evento);
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
            Logger.getLogger(AdicionarEventoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdicionarEventoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
