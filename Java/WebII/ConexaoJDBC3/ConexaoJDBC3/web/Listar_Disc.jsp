<%-- 
    Document   : Listar_Disc
    Created on : 15/03/2015, 16:26:37
    Author     : Matheus
--%>

<%@page import="java.util.List"%>
<%@page import="br.edu.ifg.jdbc.dto.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
        <%
            List<Disciplina> listar_disc = (List<Disciplina>) request.getAttribute("listar_disc");
            for (Disciplina u : listar_disc) {
        %>  

        <table>  
            <tr>  
                <td>ID Disc:<%=u.getId()%> ____ Disciplina: <%=u.getNome()%>  ____  Curso:<%=u.getCurso().getNome()%></td><br>          
            <td></td>  
        </tr>  
    </table>  

    <% }%>  
</body>  
</html>
