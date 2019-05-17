<%-- 
    Document   : busca
    Created on : 30/07/2015, 13:19:26
    Author     : Matheus Correia
--%>

<%@page import="br.com.tchunaifashion.persistence.dao.ProdutoDAO"%>
<%@page import="br.com.tchunaifashion.services.UpdateTotal"%>
<%@page import="br.com.tchunaifashion.model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="br.com.tchunaifashion.model.Produto"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

    <head>     
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <title>Tchunai Fashion</title>
        <link rel="stylesheet" href="tchunai_css/reset.css">		
        <link rel="stylesheet" href="tchunai_css/buscacss.css">
        <link rel="stylesheet" href="tchunai_css/mobile.css" media="(max-width: 939px)">
    </head>
    <%
        HttpSession sessionRecebeBusca = request.getSession();
        List<Produto> listaCarrinho = (List<Produto>) sessionRecebeBusca.getAttribute("listaCarrinho");
        List<Produto> listabusca = (List<Produto>) sessionRecebeBusca.getAttribute("busca");
        Cliente cliente = (Cliente) sessionRecebeBusca.getAttribute("cliente");
        int i = 0;
        UpdateTotal ut = new UpdateTotal();
    %>
    <body>
        <header class="container">

            <h1><a href="index.jsp"><img class="logo" src="img/logo.png" alt="Tchunai Fashion"></a></h1>

            <div class="sacola" class="container" >
                <div style="font-weight:bold; font-family: Oxygen; font-size:12px; margin-left: 50px; margin-top: -8px;">
                    <%if (cliente == null) {%>
                    <a id="login" href="login.jsp">Login</a><br>
                    <%} else {%>
                    <a id="login" href="/TchunaiFashion/DetalhaClienteServlet"><%=cliente.getNome()%></a><br><a href="/TchunaiFashion/LogoutServlet">(Sair)<br></a>
                        <%}if (listaCarrinho == null) {%>
                    <a id="qtd-sacola" href="carrinho.jsp" title="Minha Compra">0 Produtos</a>
                    <a rel="noindex nofollow" id="val-sacola" href="carrinho.jsp" title="Minha Compra"><br>R$ 0.00</a>
                        <%} else {%>
                    <a id="qtd-sacola" href="carrinho.jsp" title="Minha Compra"><%=listaCarrinho.size()%> Produtos</a>
                    <a rel="noindex nofollow" id="val-sacola" href="carrinho.jsp" title="Minha Compra"><br>R$ <%=ut.preco(listaCarrinho)%></a> 
                        <%}%>


                </div>
            </div>

            <nav class="menu-setores">
                <ul>
                    <%if (cliente == null) {%>
                    <li><a href="login.jsp">Sua Conta</a></li>
                        <%} else {%>
                    <li><a href="detalhesconta.jsp">Sua Conta</a></li><%}%>
                    <li><a href="#">Lista de Desejos</a></li>
                    <li><a href="#">Cartão Fidelidade</a></li>
                    <li><a href="sobre.html">Sobre</a></li>
                    <li><a href="#">Ajuda</a></li>
                </ul>
            </nav>

        </header><div class="container destaque">
            <section class="busca">
                <h2>Busca</h2>

                <form action="BuscaServlet" method="POST" id="form-busca">
                    <input type="search" name="busca" id="busca">
                    <input type="image" src="img/busca.png" >
                </form>

            </section><!-- fim .busca -->

            <section class="menu-departamentos">
                <h2>Departamentos</h2>
                <nav>
                    <ul>
                        <li>
                            <a class="teste" href="../TchunaiFashion/CamisaeCamisetaServlet">Camisas e Camisetas</a>
                            <ul>
                                <li><a href="../TchunaiFashion/CamisaServlet">Camisas</a></li>
                                <li><a href="../TchunaiFashion/CamisetaServlet">Camisetas</a></li>
                            </ul>
                        </li>
                        <li><a class="teste" href="../TchunaiFashion/SaiaeVestidoServlet">Saias e Vestidos</a>
                            <ul>
                                <li><a href="../TchunaiFashion/SaiaServlet">Saias</a></li>
                                <li><a href="../TchunaiFashion/VestidoServlet">Vestidos</a></li>
                            </ul>
                        </li>
                        <li><a href="../TchunaiFashion/CalcaServlet">Calças</a></li>
                        <li><a href="../TchunaiFashion/BermudaServlet">Bermudas</a></li>
                        <li><a href="../TchunaiFashion/BlazerServlet">Blazers</a></li>		  
                    </ul>
                </nav>
            </section><!-- fim .menu-departamentos -->

        </div><!-- fim .container .destaque -->

        <%

            //ProdutoDAO prodDAO = new ProdutoDAO();
            //List<Produto> listaProd = prodDAO.listarProduto();
        %>
        <div class="container paineis">
            <!-- ---------------------Painel Novidades------------------------------------------------>
            <%if (listabusca.size() != 0) {%>
            <section class="painel novidades">
                <h2>Busca</h2>
                <ol>
                    <%for (Produto prod : listabusca) {%>
                    <form action="/TchunaiFashion/ExibirProdServlet" method="GET">
                        <li>			   
                            <label for="teste<%=prod.getIdProd()%>">
                            <figure>
                                <img src="<%=prod.getImagem()%>" >
                                <figcaption><%=prod.getNomeProd()%> por R$<%=prod.getPreco()%>/</figcaption>
                            </figure>
                            <input type="hidden" name="id" value="<%=prod.getIdProd()%>"/>
                            <input type="submit" class="detail" id="teste<%=prod.getIdProd()%>" value="Detalhes" name="Detalhes" />			   
                        </label>			   
                        </li>
                    </form>
                    <%}%>
                </ol>
                <%} else {%>
                <section class="painel novidades">
                    <h2 style="text-align: center; color: #953b39">Sua busca não retornou resultados!!</h2>  
                </section>
                <%}%>

                <!-- ---------------------Painel Novidades------------------------------------------------>
                <!--section class="painel mais_vendidos">
                    <h2>Mais Vendidos</h2>
                    <ol>
                        <li>
                           <a href="produto.html">
                            <figure>
                               <img src="img/produtos/miniatura7.png">
                               <figcaption>Fuzz Cardigan por R$129,30/</figcaption>
                            </figure>
                           </a>
                        </li>
                        
                        <li>
                           <a href="produto.html">
                            <figure>
                               <img src="img/produtos/miniatura8.png">
                               <figcaption>Fuzz Cardigan por R$129,30/</figcaption>
                            </figure>
                           </a>
                        </li>
                        
                        <li>
                           <a href="produto.html">
                            <figure>
                               <img src="img/produtos/miniatura9.png">
                               <figcaption>Fuzz Cardigan por R$129,30/</figcaption>
                            </figure>
                           </a>
                        </li>

                        <li>
                           <a href="produto.html">
                            <figure>
                               <img src="img/produtos/miniatura10.png">
                               <figcaption>Fuzz Cardigan por R$129,30/</figcaption>
                            </figure>
                           </a>
                        </li>

                        <li>
                           <a href="produto.html">
                            <figure>
                               <img src="img/produtos/miniatura11.png">
                               <figcaption>Fuzz Cardigan por R$129,30/</figcaption>
                            </figure>
                           </a>
                        </li>

                        <li>
                           <a href="produto.html">
                            <figure>
                               <img src="img/produtos/miniatura12.png">
                               <figcaption>Fuzz Cardigan por R$129,30/</figcaption>
                            </figure>
                           </a>
                        </li>
                     </o>
                  </section-->	

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

