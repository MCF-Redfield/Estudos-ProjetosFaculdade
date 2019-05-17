<%-- 
    Document   : Listar_Desenv
    Created on : 12/04/2015, 15:38:09
    Author     : Matheus Correia
--%>

<%@page import="java.util.List"%>
<%@page import="model.Jogo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Jogos</title>
    </head>
    <body>  
        <h1>Lista de Jogos</h1><br>
        <table border="1">
            <td WIDTH=150 ALIGN=MIDDLE>Jogo</td>  
            <td WIDTH=150 ALIGN=MIDDLE>Plataforma</td>  
            <td WIDTH=150 ALIGN=MIDDLE>Gênero</td>  
            <td WIDTH=115 ALIGN=MIDDLE>Desenvolvedora</td>  
            <td WIDTH=100 ALIGN=MIDDLE>Status</td>
        <%
            List<Jogo> listar_jogo = (List<Jogo>) request.getAttribute("listar_jogo");
            for (Jogo u : listar_jogo) {
        %>  

          
        <tr>  
            <td><%=u.getNome()%></td>  
            <td><%=u.getPlataforma()%></td>  
            <td ALIGN=MIDDLE><%=u.getGenero()%></td>  
            <td ALIGN=MIDDLE><%=u.getDesenv().getNome()%></td>  
            <td ALIGN=MIDDLE><%=u.getStatus()%></td>  
        </tr>     

    <% }%>  
        </table>

        <br>
        
        <form method="POST" action="MenuJogo.html">
        <input type="submit" value="Retorna ao Menu Jogo"/>
        </form>
        <form method="POST" action="MainMenu.html">
        <input type="submit" value="Retorna ao Main Menu"/>
        </form>

</body>  
</html>
