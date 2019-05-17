<%-- 
    Document   : carrinho
    Created on : 05/08/2015, 10:27:01
    Author     : Matheus Correia
--%>

<%@page import="br.com.tchunaifashion.persistence.dao.PedProdDAO"%>
<%@page import="br.com.tchunaifashion.model.Pedido"%>
<%@page import="br.com.tchunaifashion.model.Cliente"%>
<%@page import="br.com.tchunaifashion.services.UpdateTotal"%>
<%@page import="java.util.List"%>
<%@page import="br.com.tchunaifashion.model.Produto"%>
<%@page import="br.com.tchunaifashion.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <title>Produto da Tchunai Fashion</title>
        <link rel="stylesheet" href="tchunai_css/reset.css">
        <link rel="stylesheet" href="tchunai_css/detalheclientecss.css">
        <link rel="stylesheet" href="tchunai_css/indexcss.css">
        <link rel="stylesheet" href="tchunai_css/mobile.css" media="(max-width: 939px)">
        <link rel="stylesheet" href="tchunai_css/produtocss.css">
    </head>

    <%
        HttpSession sessionRecebeListaCarrinho = request.getSession();
        List<Produto> listaCarrinho = (List<Produto>) sessionRecebeListaCarrinho.getAttribute("listaCarrinho");
        List<Pedido> listaPedido = (List<Pedido>) sessionRecebeListaCarrinho.getAttribute("listaPedido");
        int i = 0;
        UpdateTotal ut = new UpdateTotal();
        Cliente cliente = (Cliente) sessionRecebeListaCarrinho.getAttribute("cliente");
    %>



    <body>
        <header class="container">

            <h1><a href="index.jsp"><img class="logo" src="img/logo.png" alt="Tchunai Fashion"></a></h1>

            <div class="sacola" class="container" >
                <div style="font-weight:bold; font-family: Oxygen; font-size:12px; margin-left: 50px; margin-top: -8px;">
                    <a id="login"><%=cliente.getNome()%></a><br><a href="/TchunaiFashion/LogoutServlet">(Sair)<br></a>
                        <%if (listaCarrinho == null) {%>
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

        </header>
        <div class="produto-back">
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




                <div class="pedidos">
                    <fieldset id="detailCli">
                        <legend></legend> 
                        <p>Nome: <%=cliente.getNome()%></p>
                        <p>CPF: <%=cliente.getCpf()%></p>
                        <p>Endereço: <%=cliente.getEndereco()%>, <%=cliente.getCidade()%>-<%=cliente.getEstado()%></p>
                    </fieldset>
                    
                    <%if (listaPedido != null && listaPedido.size() != 0) {%>
                    <h1 id="titulo">Seus Pedidos</h1>
                    <ul id="first">
                    <%for(Pedido ped : listaPedido) {%>
                        <li>
                            <h1>ID Pedido: <%=ped.getIdPed()%></h2>
                            <h2><%=ped.getData()+""%></h2>
                            <h2>R$<%=ped.getTotal()%></h2>
                            <%
                            PedProdDAO pedProdDAO = new PedProdDAO();
                            List<Produto> listaProdsdoPed = pedProdDAO.buscaProdsdoPed(ped.getIdPed());
                            %>
                            <ul id="second">
                                <%for(Produto prod: listaProdsdoPed){%>
                                <li>
                                    <img src="<%=prod.getImagem()%>"/>
                                    <p><%=prod.getNomeProd()%></p>
                                    <p id="tam">Tamanho: <%=prod.getTamanho()%></p>
                                    <p id="preco">Preço: R$<%=prod.getPreco()%></p>
                                </li>
                                <%}%>
                            </ul>                    
                        </li>
                    <%}%>
                    </ul>
                    <%}else{%>
                    <h1 id="titulo">Você ainda não tem pedidos. Vamos às compras!!!</h1>
                    <%}%>
                </div>    
            </div>
        </div>
        <footer style="margin-top: 130px;">
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
