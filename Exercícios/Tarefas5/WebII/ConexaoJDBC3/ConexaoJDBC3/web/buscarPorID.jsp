<%-- 
    Document   : buscarPorID
    Created on : 15/03/2015, 09:04:02
    Author     : Matheus
--%>

<%@page import="java.util.List"%>
<%@page import="br.edu.ifg.jdbc.dto.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
        <%
            List<Curso> listar = (List<Curso>) request.getAttribute("buscar");
            for (Curso u : listar) {
        %>  

        <table>  
            <tr>  
                <td>ID:  <%=u.getId()%>  ------  Curso:  <%=u.getNome()%></td><br>          
            <td></td>  
        </tr>  
    </table>  

    <% }%>  
</body>  
</html>
