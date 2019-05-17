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
        <title>Cartas</title>
        <link rel="stylesheet" href="css/exibecss.css">
    </head>
    <body>


        <%
            HttpSession sessionRecebeCartas = request.getSession();
            HttpSession sessionRecebeQtde = request.getSession();
            int cartas[][] = (int[][]) sessionRecebeCartas.getAttribute("cartas");
            int qtd = (Integer) sessionRecebeQtde.getAttribute("qtde");

            Servicos serv = new Servicos();
            int tam = (int) Math.pow(2, cartas.length);
            int qtde = serv.quantidadeDeCarta(tam);
            int y;
            int x;
            int indice = 0;
            int sadness = (Integer) sessionRecebeQtde.getAttribute("sadqtd");
            int sad;
            if (qtde % 2 == 0) {
                y = (int) Math.pow(2, qtde / 2);
                x = (int) Math.pow(2, (qtde / 2) - 1);
            } else {
                y = (int) Math.pow(2, qtde / 2);
                x = (int) Math.pow(2, (qtde / 2));
            }

        %>

        <table border="1" cellspacing="10">
            <%for (int m = 0; m < y; m++) {%>
            <tr>
                <%for (int n = 0; n < x; n++) {

                %>
                <td><%=cartas[qtd][indice]%></td><!--       tá estático-->
                <%
                        indice++;
                    }%>
            </tr>
            <%}%>

        </table>
        <%
            sessionRecebeCartas.setAttribute("resultado", cartas[sadness][0]);
        %>
        <p>O numero que você pensou está na carta?</p> <br>
        <form method="GET" action="DistribuiServlet" id="sadform">
            <input type="submit" name="sim"  value="SIM" class="myButton"/> <input type="submit" name="nao" value="NÃO" class="myButton"/>
        </form>

    </body>
</html>
