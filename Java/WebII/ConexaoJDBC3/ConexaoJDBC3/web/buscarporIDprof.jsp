<%-- 
    Document   : buscarporIDprof
    Created on : 15/03/2015, 12:30:06
    Author     : Maxwel
--%>

<%@page import="br.edu.ifg.jdbc.dto.Professor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista professores</title>
    </head>
     <body>  
        <%
            List<Professor> listar = (List<Professor>) request.getAttribute("buscar");
            for (Professor u : listar) {
        %>  

        <table>  
            <tr>  
               <td>ID:  <%=u.getId()%>  ------  Nome:  <%=u.getNome()%>  ------  NumSiape:  <%=u.getnumSiape()%> ------  CodigoContrato:  <%=u.getcodContrato()%></td><br>          
                 
            <td></td>  
        </tr>  
    </table>  

    <% }%>  
</body>  
</html>
