package Teste;

import DAO.*;
import DTO.*;
import javax.swing.JOptionPane;

public class Teste {

    public static void main(String[] args) throws ClassNotFoundException {

        String nome, telefone, endereco, cpf, cnpj, nome1, endereco1;
        ClienteDAO cliente1 = new ClienteDAO();
        Cliente cliente = new Cliente();
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO fornecedor1 = new FornecedorDAO();
        
        nome = JOptionPane.showInputDialog(null, "Digite o nome do Cliente: ");
        telefone = JOptionPane.showInputDialog(null, "Digite o telefone do Cliente: ");
        endereco = JOptionPane.showInputDialog(null, "Digite o endereco do Cliente: ");
        cpf = JOptionPane.showInputDialog(null, "Digite o cpf do Cliente: ");
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        cliente.setCpf(cpf);

        cliente1.add(cliente);

        nome1 = JOptionPane.showInputDialog(null, "Digite o nome da Empresa: ");
        endereco1 = JOptionPane.showInputDialog(null, "Digite o endereco da Empresa: ");
        cnpj = JOptionPane.showInputDialog(null, "Digite o cnpj da Empresa: ");
        fornecedor.setNome(nome1);
        fornecedor.setEndereco(endereco1);
        fornecedor.setCnpj(cnpj);
        
        fornecedor1.add(fornecedor);
        
        
        cpf = JOptionPane.showInputDialog(null, "Digite o cpf para Remover: ");
        cliente1.remover(cpf);
    }
}
