<%-- 
    Document   : newjsp
    Created on : 21/07/2015, 12:57:22
    Author     : Usuario
--%>

<%@page import="br.com.tchunaifashion.services.UpdateTotal"%>
<%@page import="br.com.tchunaifashion.persistence.dao.ProdutoDAO"%>
<%@page import="br.com.tchunaifashion.model.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

		<head>     
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width">
		<title>Tchunai Fashion</title>
                <link rel="stylesheet" href="../tchunai_css/reset.css">		
                <link rel="stylesheet" href="../tchunai_css/pagecss.css">
                <link rel="stylesheet" href="../tchunai_css/mobile.css" media="(max-width: 939px)">
		</head>
		<%
                    HttpSession sessionRecebeListaCarrinho = request.getSession();
                    List<Produto> listaCarrinho = (List<Produto>) sessionRecebeListaCarrinho.getAttribute("listaCarrinho");
                    int i=0;
                    UpdateTotal ut = new UpdateTotal();
                %>
		<body>
		<header class="container">
	
                    <h1><a href="../index.jsp"><img class="logo" src="../img/logo.png" alt="Tchunai Fashion"></a></h1>

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
		    <li><a href="../login.jsp">Sua Conta</a></li>
		    <li><a href="#">Lista de Desejos</a></li>
		    <li><a href="#">Cartão Fidelidade</a></li>
		    <li><a href="../sobre.html">Sobre</a></li>
		    <li><a href="#">Ajuda</a></li>
		  </ul>
		</nav>

		</header>
		<div class="container destaque">
		  <section class="busca">
		    <h2>Busca</h2>
		
			<form action="http://www.google.com.br/search" id="form-busca">
			  <input type="search" name="q" id="q">
                          <input type="image" src="../img/busca.png">
			</form>
		
		  </section><!-- fim .busca -->
		  
		  <section class="menu-departamentos">
		    <h2>Departamentos</h2>
		      <nav>
		        <ul>
                        <li>
                            <a class="teste" href="../CamisaeCamisetaServlet">Camisas e Camisetas</a>
                            <ul>
                                <li><a href="../CamisaServlet">Camisas</a></li>
                                <li><a href="../CamisetaServlet">Camisetas</a></li>
                            </ul>
                        </li>
                        <li><a class="teste" href="../SaiaeVestidoServlet">Saias e Vestidos</a>
                            <ul>
                                <li><a href="../SaiaServlet">Saias</a></li>
                                <li><a href="../VestidoServlet">Vestidos</a></li>
                            </ul>
                        </li>
                        <li><a href="../CalcaServlet">Calças</a></li>
                        <li><a href="../BermudaServlet">Bermudas</a></li>
                        <li><a href="../BlazerServlet">Blazers</a></li>
                    </ul>
		      </nav>
		  </section><!-- fim .menu-departamentos -->
		
		</div><!-- fim .container .destaque -->
		
		<%
                
                ProdutoDAO prodDAO = new ProdutoDAO();
                List<Produto> listaProd = prodDAO.listarProduto();
                
                %>
		<div class="container paineis">
<!-- ---------------------Painel Novidades------------------------------------------------>
		  <section class="painel novidades">
		    <h2>Novidades</h2>
		        <ol>
                        <%for (Produto prod : listaProd) {
                        if(prod.getTipo().equals("camisa")){%>
                        <form action="/TchunaiFashion/ExibirProdServlet" method="GET">
                        <li>			   
                            <figure>
                                <img src="../<%=prod.getImagem()%>" >
			       <figcaption><%=prod.getNomeProd()%> por R$<%=prod.getPreco()%>/</figcaption>
			    </figure>
                            <input type="hidden" name="id" value="<%=prod.getIdProd()%>"/>
                            <input type="submit" class="detail" value="Detalhes" name="Detalhes" />			   
			</li>
                        </form>
                        <%}}%>
                        </ol>
		  </section>
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
            <img src="../img/logo-rodape.png" alt="Logo Mirror Fashion" style="width:80px; height: 60px;">
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

