<%-- 
    Document   : Resultado
    Created on : 27/10/2015, 10:13:32
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="3 ; url='index.html'"
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>

        <link rel="stylesheet" href="css/resultadocss.css">
    </head>
    <body>
        <%
            HttpSession sessionRecebeQtde = request.getSession();
            int resultado = (Integer) sessionRecebeQtde.getAttribute("sad");
        %>
        <div id="resultado">
            <p>O número que você pensou foi:</p> 
            <span id="result"><%=resultado%></span>
            <br><br><br>Deseja Recomeçar?
            <br><br><a href="index.html">RECOMEÇAR</a>
        </div>
    </body>
</html>
