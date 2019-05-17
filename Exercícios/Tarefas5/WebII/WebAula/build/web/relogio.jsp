<%-- 
    Document   : relogio
    Created on : 23/03/2015, 09:59:21
    Author     : Mcf
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relógio</title>
    </head>
    <body>
        <%@include file="cabecalho.jsp"%>
        Hoje é: <%= new Date()%>
        
    </body>
</html>
