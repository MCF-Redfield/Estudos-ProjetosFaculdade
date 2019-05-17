<%-- 
    Document   : DistribuidoraAdicionar
    Created on : 12/04/2015, 12:53:18
    Author     : Usuario
--%>

<%@page import="model.Jogo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jogo Adicionar</title>
    </head>
    <body>
        
        <%
            String[] resultado = (String[]) request.getAttribute("resultado");
            
            /*
            Jogo aux = (Jogo) request.getAttribute("nome2");
            String mensagem;
            String titulo;
            if (aux.getNome().equals("ermac"))
            {
                mensagem = "Preencha os campos corretamente";
                titulo = "Não foi possível realizar o cadastro!!!";
            }
            else if(aux.getDesenv().getCod()== 0)
            {
                mensagem="Não foi possível localizar Desenvolvedora com código informado!!";
                titulo="Desenvolvedora inválida ou não informada!!";
            }
            else
            {
                mensagem="Jogo cadastrado!";
                titulo=aux.getNome() + " cadastrado com sucesso!!";
            }
        */%>
        <h1> <%=resultado[0]%> </h1>
        
            <%=resultado[1]%>
            
            <br>
            
            <form method="POST" action="MenuJogo.html">
            <input type="submit" value="Retorna ao Menu Jogo"/>
            </form>
            <form method="POST" action="CadastrarJogo.html">
            <input type="submit" value="Retorna ao Cadastrar"/>
            </form>
            <form method="POST" action="MainMenu.html">
            <input type="submit" value="Retorna ao Main Menu"/>
            </form>
            
    </body>
</html>
