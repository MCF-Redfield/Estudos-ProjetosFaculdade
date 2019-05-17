<%-- 
    Document   : Listar_Dist
    Created on : 12/04/2015, 15:38:09
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="model.Distribuidora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Distribuidoras</title>
    </head>
    <body>  
         <h1>Lista de Distribuidoras</h1>
         <table border="1">
            <td WIDTH=150 ALIGN=MIDDLE>Nome</td>  
            <td WIDTH=150 ALIGN=MIDDLE>Sede</td>  
        <%
            List<Distribuidora> listar_dist = (List<Distribuidora>) request.getAttribute("listar_dist");
            for (Distribuidora u : listar_dist) {
        %>  
        
        <tr>  
            <td><%=u.getNome()%></td>  
            <td><%=u.getSede()%></td>            
        </tr>  
    <% }%>
    </table>  
    
    <br>
    
    <form method="POST" action="MenuDistribuidora.html">
    <input type="submit" value="Retorna ao Menu Distribuidora"/>
    </form>
    <form method="POST" action="MainMenu.html">
    <input type="submit" value="Retorna ao Main Menu"/>
    </form>
    
</body>  
</html>
