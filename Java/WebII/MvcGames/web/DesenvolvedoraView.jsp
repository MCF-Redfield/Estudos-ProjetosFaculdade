<%-- 
    Document   : DistribuidoraAdicionar
    Created on : 12/04/2015, 12:53:18
    Author     : Usuario
--%>

<%@page import="model.Desenvolvedora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Distribuidora Adicionar</title>
    </head>
    <body>
        
        <%
            Desenvolvedora aux = (Desenvolvedora) request.getAttribute("nome2");
            String mensagem;
            String titulo;
            if (aux.getNome().equals("ermac"))
            {
                mensagem = "Preencha os campos corretamente";
                titulo = "Não foi possível realizar o cadastro!!!";
            }
            else if(aux.getDist().getCod()== 0)
            {
                mensagem="Não foi possível localizar Distribuidora com código informado!!";
                titulo="Distribuidora inválida ou não informada!!";
            }
            else
            {
                mensagem="Desenvolvedora cadastrada!";
                titulo=aux.getNome() + " cadastrada com sucesso!!";
            }
        %>
        <h1> <%=titulo%> </h1>
        
            <%=mensagem%>
            
            <br>  
          
            <form method="POST" action="MenuDesenvolvedora.html">
            <input type="submit" value="Retorna ao Menu Desenvolvedora"/>
            </form>
            <form method="POST" action="CadastrarDesenvolvedora.html">
            <input type="submit" value="Retorna ao Cadastrar"/>
            </form>
            <form method="POST" action="MainMenu.html">
            <input type="submit" value="Retorna ao Main Menu"/>
            </form>
    </body>
</html>
