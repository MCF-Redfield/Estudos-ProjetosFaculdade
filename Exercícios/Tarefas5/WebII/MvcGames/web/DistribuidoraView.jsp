<%-- 
    Document   : DistribuidoraAdicionar
    Created on : 12/04/2015, 12:53:18
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Distribuidora Adicionar</title>
    </head>
    <body>
        
        <%
            //Usuario usuario= (Usuario) session.getAttribute("usuario");
            String nome = (String) request.getAttribute("nome2");
            String mensagem;
            String titulo;
            if (nome==null)
            {
                mensagem = "Preencha os campos corretamente";
                titulo = "Não foi possível realizar o cadastro!!!";
            }
            else
            {
                mensagem="Cadastrado com sucesso!!";
                titulo=nome + " foi cadastrada com sucesso!!";
            }
        %>
        <h1> <%=titulo%> </h1>
        
            <%=mensagem%>

            <br>
            
            <form method="POST" action="MenuDistribuidora.html">
            <input type="submit" value="Retorna ao Menu Distribuidora"/>
            </form>
            <form method="POST" action="CadastrarDistribuidora.html">
            <input type="submit" value="Retorna ao Cadastrar"/>
            </form>
            <form method="POST" action="MainMenu.html">
            <input type="submit" value="Retorna ao Main Menu"/>
            </form>
    </body>
</html>
