<%-- 
    Document   : ExibeCartas
    Created on : 26/10/2015, 19:19:26
    Author     : Matheus Correia
--%>

<%@page import="service.Servicos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <%
            HttpSession sessionRecebeCartas = request.getSession();
            int cartas[][] = (int[][]) sessionRecebeCartas.getAttribute("cartas");
            Servicos serv = new Servicos();
            int tam = (int)Math.pow(2,cartas.length);
            int qtde = serv.quantidadeDeCarta(tam);
            int y;
            int x;
            int indice = 0;
            if(qtde%2==0)
            {
                y = (int)Math.pow(2,qtde/2);
                x = (int)Math.pow(2,(qtde/2)-1); 
            }
            else
            {
                y = (int)Math.pow(2,qtde/2);
                x = (int)Math.pow(2,(qtde/2)); 
            }
        %>
        
        x:<%=x%>
        y:<%=y%>
        <table border="1">
            <%for(int m=0;m<y;m++){%>
            <tr>
                <%for(int n=0;n<x;n++){%>
                <td><%=cartas[1][indice]%></td><!--       tá estático-->
                <%
                indice++;}%>
            </tr>
            <%}%>
    
        </table>
    
    </body>
</html>
