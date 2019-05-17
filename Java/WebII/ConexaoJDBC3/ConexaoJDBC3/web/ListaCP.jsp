<%-- 
    Document   : ListaCP
    Created on : 20/03/2015, 19:28:37
    Author     : Mcf
--%>

<%@page import="java.util.List"%>
<%@page import="br.edu.ifg.jdbc.dto.CursoProf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<CursoProf> listacp = (List<CursoProf>) request.getAttribute("listacp");
            for (CursoProf u : listacp) {
        %> 

        <table>  
            <tr>  
                <td>Professor:[<%=u.getProf().getId()%>]<%=u.getProf().getNome()%> ____  Curso:[<%=u.getCurso().getId()%>]<%=u.getCurso().getNome()%></td><br>          
            <td></td>  
        </tr>  
    </table>  

    <% }%>  
</body>
</html>
