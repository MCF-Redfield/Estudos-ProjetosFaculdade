<%-- 
    Document   : DistribuidoraView
    Created on : 10/05/2015, 13:09:31
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="Jogos.Jogos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="jogo">
            
            Nome: <input type="text" name="nome" />
            <br>
            Gênero: <input type="text" name="genero"/>
            <br>
            Plataforma: <input type="text" name="plataforma" />
            <br>
            Distribuidora: <input type="text" name="dist"/>
            <br>
            Desenvolvedora: <input type="text" name="desenv"/>
            <br>
            Status: <input type="text" name="status"/>
            <br>
            <input type="submit" value="Cadastrar" name="Cadastrar"/>
        </form>
            <table border="1">
            <td WIDTH=150 ALIGN=MIDDLE>Jogo</td>  
            <td WIDTH=150 ALIGN=MIDDLE>Plataforma</td>  
            <td WIDTH=150 ALIGN=MIDDLE>Gênero</td>  
            <td WIDTH=115 ALIGN=MIDDLE>Desenvolvedora</td>  
            <td WIDTH=115 ALIGN=MIDDLE>Distribuidora</td>  
            <td WIDTH=100 ALIGN=MIDDLE>Status</td>
            
            <%
            @SuppressWarnings("unchecked") 
            List<Jogos> jogos = (List<Jogos>)request.getAttribute("jogo");
            
                for (Jogos jogo : jogos)
                {
            %>
        <tr>  
            <td><%=jogo.getNome()%></td>  
            <td><%=jogo.getPlataforma()%></td>  
            <td ALIGN=MIDDLE><%=jogo.getGenero()%></td>  
            <td ALIGN=MIDDLE><%=jogo.getDesenv()%></td>  
            <td ALIGN=MIDDLE><%=jogo.getDist()%></td>  
            <td ALIGN=MIDDLE><%=jogo.getStatus()%></td>  
        </tr>  
                    
            <%
                }
            %>
            </table>
        
    </body>
</html>
