<%-- 
    Document   : escopos
    Created on : 23/03/2015, 10:06:33
    Author     : Mcf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            String nome = request.getParameter("nome");//?nome=NOME
        %>
        <%
            String usuario = request.getParameter("usuario");
            session.setAttribute("sessionUsuario", usuario);
            application.setAttribute("applicationUsuario", usuario);
        %>
        
        <br>
        Usuário no objeto request é: <%=usuario%>
         <br>
        Usuário no objeto session é: <%=session.getAttribute("sessionUsuario")%>
        <br>
        Usuário no objeto Application é: <%=application.getAttribute("applicationUsuario")%>
        
        
    </body>
</html>
