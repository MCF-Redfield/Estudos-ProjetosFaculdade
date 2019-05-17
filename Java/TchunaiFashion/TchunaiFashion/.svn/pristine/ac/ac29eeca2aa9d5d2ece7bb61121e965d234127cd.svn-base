<%-- 
    Document   : newjsp
    Created on : 21/07/2015, 12:57:22
    Author     : Usuario
--%>

<%@page import="br.com.tchunaifashion.persistence.services.UpdateTotal"%>
<%@page import="br.com.tchunaifashion.persistence.dao.ProdutoDAO"%>
<%@page import="br.com.tchunaifashion.model.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>     
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <title>Tchunai Fashion</title>
        <link rel="stylesheet" href="tchunai_css/reset.css">		
        <link rel="stylesheet" href="tchunai_css/logincss.css">
        <link rel="stylesheet" href="tchunai_css/mobile.css" media="(max-width: 939px)">
    </head>
    
    <%
                    HttpSession sessionRecebeListaCarrinho = request.getSession();
                    List<Produto> listaCarrinho = (List<Produto>) sessionRecebeListaCarrinho.getAttribute("listaCarrinho");
                    int i=0;
                    UpdateTotal ut = new UpdateTotal();
    %>
    
    <body>
        <header class="container">

            <h1><a href="index.jsp"><img class="logo" src="img/logo.png" alt="Tchunai Fashion"></a></h1>

            <div class="sacola" class="container" >
                <div style="font-weight:bold; font-family: Oxygen; font-size:12px; margin-left: 50px; margin-top: 1px;">
                    <%if(listaCarrinho==null){%>
                                <a id="qtd-sacola" href="carrinho.jsp" title="Minha Compra">0 Produtos</a>
                                <a rel="noindex nofollow" id="val-sacola" href="carrinho.jsp" title="Minha Compra"><br>R$ 0.00</a>
				<%}else{%><a id="qtd-sacola" href="carrinho.jsp" title="Minha Compra"><%=listaCarrinho.size()%> Produtos</a>
                                          <a rel="noindex nofollow" id="val-sacola" href="carrinho.jsp" title="Minha Compra"><br>R$ <%=ut.preco(listaCarrinho)%></a> 
                                <%}%>            
                </div>
            </div>

            <nav class="menu-setores">
                <ul>
                    <li><a href="index.jsp">Início</a></li>
                    <li><a href="#">Lista de Desejos</a></li>
                    <li><a href="#">Cartão Fidelidade</a></li>
                    <li><a href="sobre.html">Sobre</a></li>
                    <li><a href="#">Ajuda</a></li>
                </ul>
            </nav>

        </header>
        <div class="container destaque">
            <section class="busca">
                <h2>Busca</h2>

                <form action="http://www.google.com.br/search" id="form-busca">
                    <input type="search" name="q" id="q">
                    <input type="image" src="img/busca.png">
                </form>

            </section><!-- fim .busca -->

            <section class="menu-departamentos">
                <h2>Departamentos</h2>
                <nav>
                    <ul>
                        <li>
                            <a class="teste" href="#">Blusas e Camisas</a>
                            <ul>
                                <li><a href="#">Manga curta</a></li>
                                <li><a href="#">Manga comprida</a></li>
                                <li><a href="#">Camisa social</a></li>
                                <li><a href="#">Camisa casual</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Calças</a></li>
                        <li><a href="#">Saias</a></li>
                        <li><a href="#">Vestidos</a></li>
                        <li><a href="#">Sapatos</a></li>
                        <li><a href="#">Bolsas e Carteiras</a></li>
                        <li><a href="#">Acessórios</a></li>
                    </ul>
                </nav>
            </section>

            <div class="loginheader">
                <h1> Identificação</h1>
                <br><br>

                <form action="LoginServlet" method="POST">
                    <div class="login">
                        <legend class="title">já tenho cadastro</legend>
                        <span>e-mail:</span> <input type="text" name="email" autofocus><br><br>
                        <span>Senha :</span> <input type="text" name="senha"><br><br>
                        <input class="bts" id="btnEntrar" value="Entrar"  type="submit"><br><br>
                        <%
                            if (request.getAttribute("validationmessage") == null) {
                        %>
                        <span style="display: none;" class="failer"><%= request.getAttribute("validationmessage")%></span>
                        <%
                        } else {
                        %>
                        <span class="failer"><%= request.getAttribute("validationmessage")%></span>
                        <%}%>
                    </div>
                </form>
                <form action="cadastro.jsp"> 
                    <div class="cadastro">
                        <legend class="title">não tenho cadastro</legend>
                        <input class="bts" id="btnCadastro" value="Cadastrar"  type="submit">
                    </div>
                </form>
                <!--  <form>
                  <div id="cadastro">
                  Email:<br> <input type="text"><br>
                  Senha:<br> <input type="text"><br>
                  <input id="btProsseguir" value="Entrar"  type="submit">
                  </div>
                      </form> -->

            </div>

            <footer>
                <div class="container">
                    <img src="img/logo-rodape.png" alt="Logo Mirror Fashion" style="width:80px; height: 60px;">
                    <p>&copy; Copyright Tchunai Fashion</p>
                    <ul class="social">
                        <li><a href="http://facebook.com/tchunaifashion">Facebook</a></li>
                        <li><a href="http://twitter.com/tchunaifashion">Twitter</a></li>
                        <li><a href="http://plus.google.com/tchunaifashion">Google+</a></li>
                        <li><a href="http://tchunaifashion.tumblr.com">Tumblr</a></li>
                        <li><a href="https://instagram.com/tchunaifashion">Instagram</a></li>
                        <li><a href="https://www.pinterest.com/tchunaifashion">Pinterest</a></li>
                    </ul>
                </div>
            </footer>


    </body>
</html>

