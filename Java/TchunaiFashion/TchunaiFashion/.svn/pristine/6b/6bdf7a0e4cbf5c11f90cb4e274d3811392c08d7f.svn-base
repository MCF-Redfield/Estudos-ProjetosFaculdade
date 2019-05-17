/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tchunaifashion.controller;

import br.com.tchunaifashion.model.Cliente;
import br.com.tchunaifashion.model.PedProd;
import br.com.tchunaifashion.model.Pedido;
import br.com.tchunaifashion.model.Produto;
import br.com.tchunaifashion.persistence.dao.PedProdDAO;
import br.com.tchunaifashion.persistence.dao.PedidoDAO;
import br.com.tchunaifashion.services.ConfigurarData;
import br.com.tchunaifashion.services.UpdateTotal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matheus Correia
 */
@WebServlet(name = "FinalizarCompraServlet", urlPatterns = {"/FinalizarCompraServlet"})
public class FinalizarCompraServlet extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            HttpSession sessionRecebeListaCarrinho = request.getSession();
            List<Produto> listaCarrinho = (List<Produto>) sessionRecebeListaCarrinho.getAttribute("listaCarrinho");
            int i = 0;
            UpdateTotal ut = new UpdateTotal();
            ConfigurarData cd = new ConfigurarData();
            HttpSession sessionRecebeClienteLogado = request.getSession();
            Cliente cliente = (Cliente) sessionRecebeClienteLogado.getAttribute("cliente");
            Calendar c = new GregorianCalendar();  
            c.setTimeInMillis(System.currentTimeMillis());            
            String data = c.get(Calendar.YEAR) + "/" + cd.confuguraMes(c.get(Calendar.MONTH)) + "/" + cd.confuguraDia(c.get(Calendar.DAY_OF_MONTH));

            Pedido ped = new Pedido();
            ped.setCliente(cliente);
            ped.setTotal(ut.preco(listaCarrinho));
            ped.setData(cd.configuraData(data));
            PedidoDAO pedDAO = new PedidoDAO();
            pedDAO.addPedido(ped);
            
            for (Produto prod : listaCarrinho)
            {
                PedProd pedProd = new PedProd();
                pedProd.setPedido(pedDAO.pedMaisRecente());
                pedProd.setProduto(prod);
                pedProd.setTamanho(prod.getTamanho());
                PedProdDAO pedProdDAO = new PedProdDAO();
                pedProdDAO.addPedProd(pedProd);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FinalizarCompraServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FinalizarCompraServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>" + pedDAO.pedMaisRecente().getIdPed() + "</h1>");
            out.println("<h1>" + pedDAO.pedMaisRecente().getData() + "</h1>");
            out.println("<h1>" + pedDAO.pedMaisRecente().getTotal() + "</h1>");
            out.println("<h1>" + pedDAO.pedMaisRecente().getCliente().getEmail()  + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
                sessionRecebeListaCarrinho.invalidate();
                HttpSession sessionlogin = request.getSession();
                sessionlogin.setAttribute("cliente", cliente);
                request.getRequestDispatcher("/index.jsp").forward(request, response);    
            
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
        } catch (ParseException ex) {
            Logger.getLogger(FinalizarCompraServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(FinalizarCompraServlet.class.getName()).log(Level.SEVERE, null, ex);
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
