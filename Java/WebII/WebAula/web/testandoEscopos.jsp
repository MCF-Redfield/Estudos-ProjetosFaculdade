<%-- 
    Document   : testandoEscopos
    Created on : 23/03/2015, 10:29:39
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
        <br>
        Usuário no objeto session é: <%=session.getAttribute("sessionUsuario")%>
        <br>
        Usuário no objeto Application é: <%=application.getAttribute("applicationUsuario")%>
    </body>
</html>
