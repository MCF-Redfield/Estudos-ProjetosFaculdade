/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tchunaifashion.controller;

import br.com.tchunaifashion.model.Cliente;
import br.com.tchunaifashion.persistence.dao.ClienteDAO;
import br.com.tchunaifashion.services.ValidaCPF;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maxwel
 */
@WebServlet(name = "CadastroUsuarioServlet", urlPatterns = {"/CadastroUsuarioServlet"})
public class CadastroUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
        request.setAttribute("cpf", "");
        request.setAttribute("validationmessage", "");
        request.getRequestDispatcher("/cadastro.jsp").forward(request, response);

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
        String messagealert = "";
        Cliente cliente = new Cliente();
        ClienteDAO clientedao = new ClienteDAO();
        
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        cliente.setNome(request.getParameter("nome"));
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setTelefone(request.getParameter("tel"));
        cliente.setSenha(request.getParameter("senha"));
        cliente.setEstado(request.getParameter("estado"));
        cliente.setCidade(request.getParameter("cidade"));
        cliente.setCep(request.getParameter("cep"));
        cliente.setEndereco(request.getParameter("endereco"));
        cliente.setNumero(request.getParameter("numero"));
        cliente.setBairro(request.getParameter("bairro"));
        cliente.setComplemento(request.getParameter("complemento"));
        
        request.setAttribute("email", email);
        request.setAttribute("senha", cpf);

        if (clientedao.verificaEmail(cliente) == false && clientedao.verificaCpf(cliente) == false) {

            if (ValidaCPF.isCPF(cliente.getCpf())) {
                clientedao.adicionar(cliente);
                messagealert = "Cadastrado com sucesso!!";
                request.setAttribute("valmessage", messagealert);
                request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
            } else {
                 messagealert = "**CPF Inválido!!";
                request.setAttribute("valmessage", messagealert);
                request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("valmessage", clientedao.getMessage());
            request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
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
