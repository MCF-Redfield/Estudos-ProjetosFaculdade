<%-- 
    Document   : testeJsp
    Created on : 23/03/2015, 09:31:01
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
        <h1>Testando o danado!!</h1>

        <%
            int i = 1;
            int k = 2;
            int j ;
            out.println("Valor é: " + add(i,k));
        %>
        
        <%!
            public int add(int i, int k)
            {
                return i+k;
            }            
        %>
    </body>
</html>
