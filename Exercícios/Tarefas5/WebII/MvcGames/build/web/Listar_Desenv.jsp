<%-- 
    Document   : Listar_Desenv
    Created on : 12/04/2015, 15:38:09
    Author     : Matheus Correia
--%>

<%@page import="java.util.List"%>
<%@page import="model.Desenvolvedora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Desenvolvedoras</title>
    </head>
    <body>  
        <h1>Lista de Desenvolvedoras</h1>
    <table border="1">
            <td WIDTH=150 ALIGN=MIDDLE>Nome</td>  
            <td WIDTH=150 ALIGN=MIDDLE>Sede</td>  
            <td WIDTH=150 ALIGN=MIDDLE>Distribuidora</td>  
        <%
            List<Desenvolvedora> listar_desenv = (List<Desenvolvedora>) request.getAttribute("listar_desenv");
            for (Desenvolvedora u : listar_desenv) {
        %>  
        <tr>  
            <td><%=u.getNome()%></td>  
            <td><%=u.getSede()%></td>            
            <td><%=u.getDist().getNome()%></td>            
        </tr>    
    <% }%>
    </table>
    
    <br>
    
    <form method="POST" action="MenuDesenvolvedora.html">
    <input type="submit" value="Retorna ao Menu Desenvolvedora"/>
    </form>
    <form method="POST" action="MainMenu.html">
    <input type="submit" value="Retorna ao Main Menu"/>
    </form>
    
</body>  
</html>
