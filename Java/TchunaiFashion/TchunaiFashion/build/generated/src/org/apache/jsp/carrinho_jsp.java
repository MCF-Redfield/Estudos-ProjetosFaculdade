package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.tchunaifashion.model.Cliente;
import br.com.tchunaifashion.persistence.services.UpdateTotal;
import java.util.List;
import br.com.tchunaifashion.model.Produto;
import br.com.tchunaifashion.model.Produto;

public final class carrinho_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("        <title>Produto da Tchunai Fashion</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"tchunai_css/reset.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"tchunai_css/carrinhocss.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"tchunai_css/indexcss.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"tchunai_css/mobile.css\" media=\"(max-width: 939px)\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"tchunai_css/produtocss.css\">\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    ");

                    HttpSession sessionRecebeListaCarrinho = request.getSession();
                    List<Produto> listaCarrinho = (List<Produto>) sessionRecebeListaCarrinho.getAttribute("listaCarrinho");
                    int i=0;
                    UpdateTotal ut = new UpdateTotal();
                    Cliente cliente = (Cliente) sessionRecebeListaCarrinho.getAttribute("cliente");
                    
                    
    
      out.write("\n");
      out.write("                  \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <header class=\"container\">\n");
      out.write("            <h1>\n");
      out.write("                <a href=\"index.jsp\"><img class=\"logo\" src=\"img/logo.png\" alt=\"Mirror Fashion\"></a>\n");
      out.write("            </h1>\n");
      out.write("            <div class=\"sacola\">\n");
      out.write("                <div style=\"font-weight:bold; font-family: Oxygen; font-size:12px; margin-left: 50px; margin-top: 1px;\">\n");
      out.write("                   <a id=\"login\" href=\"login.jsp\">");
      out.print(cliente.getNome());
      out.write("</a><br>\n");
      out.write("                    ");
if(listaCarrinho==null){
      out.write("\n");
      out.write("                        <a id=\"qtd-sacola\" href=\"carrinho.jsp\" title=\"Minha Compra\">0 Produtos</a>\n");
      out.write("                        <a rel=\"noindex nofollow\" id=\"val-sacola\" href=\"carrinho.jsp\" title=\"Minha Compra\"><br>R$ 0.00</a>\n");
      out.write("                    ");
}else{
      out.write("\n");
      out.write("                        <a id=\"qtd-sacola\" href=\"carrinho.jsp\" title=\"Minha Compra\">");
      out.print(listaCarrinho.size());
      out.write(" Produtos</a>\n");
      out.write("                        <a rel=\"noindex nofollow\" id=\"val-sacola\" href=\"carrinho.jsp\" title=\"Minha Compra\"><br>R$ ");
      out.print(ut.preco(listaCarrinho));
      out.write("</a> \n");
      out.write("                    ");
}
      out.write("            \n");
      out.write("                        \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <nav class=\"menu-setores\">\n");
      out.write("                <ul>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"index.jsp\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Sua Conta</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Lista de Desejos</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Cartão Fidelidade</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"sobre.html\">Sobre</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Ajuda</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"produto-back\">\n");
      out.write("            <div class=\"container destaque\">\n");
      out.write("\t\t  <section class=\"busca\">\n");
      out.write("\t\t    <h2>Busca</h2>\n");
      out.write("\t\t\n");
      out.write("\t\t\t<form action=\"http://www.google.com.br/search\" id=\"form-busca\">\n");
      out.write("\t\t\t  <input type=\"search\" name=\"q\" id=\"q\">\n");
      out.write("\t\t\t  <input type=\"image\" src=\"img/busca.png\">\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t\n");
      out.write("\t\t  </section><!-- fim .busca -->\n");
      out.write("\t\t  \n");
      out.write("\t\t  <section class=\"menu-departamentos\">\n");
      out.write("\t\t    <h2>Departamentos</h2>\n");
      out.write("\t\t      <nav>\n");
      out.write("\t\t        <ul>\n");
      out.write("\t\t\t  <li>\n");
      out.write("                              <a class=\"teste\" href=\"#\">Blusas e Camisas</a>\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Manga curta</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Manga comprida</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Camisa social</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#\">Camisa casual</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t  </li>\n");
      out.write("\t\t\t  <li><a href=\"#\">Calças</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">Saias</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">Vestidos</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">Sapatos</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">Bolsas e Carteiras</a></li>\n");
      out.write("\t\t\t  <li><a href=\"#\">Acessórios</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t      </nav>\n");
      out.write("\t\t  </section><!-- fim .menu-departamentos -->\n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  <div class=\"pedidos\">\n");
      out.write("                      ");
if(listaCarrinho != null && listaCarrinho.size()!=0){
      out.write("\n");
      out.write("                      <ul>\n");
      out.write("                        ");
while(i<listaCarrinho.size()){
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <img src=\"");
      out.print(listaCarrinho.get(i).getImagem());
      out.write("\"/>\n");
      out.write("                            <p>");
      out.print(listaCarrinho.get(i).getNomeProd());
      out.write("</p>\n");
      out.write("                            <p id=\"tam\">Tamanho: ");
      out.print(listaCarrinho.get(i).getTamanho());
      out.write("</p>\n");
      out.write("                            <p id=\"preco\">Preço: R$");
      out.print(listaCarrinho.get(i).getPreco());
      out.write("</p>\n");
      out.write("                            <form action=\"/TchunaiFashion/RemoveCarrinhoServlet\" method=\"GET\">\n");
      out.write("                            <input type=\"hidden\" name=\"indiceLista\" value=\"");
      out.print(i);
      out.write("\"/>\n");
      out.write("                            <input type=\"submit\" class=\"detailRemove\" value=\"Remover\" name=\"remove\" />\n");
      out.write("                            </form>\n");
      out.write("                        </li>\n");
      out.write("                        ");
i++;
                        }
      out.write("\n");
      out.write("                      <p id=\"total\">Total R$");
      out.print(ut.preco(listaCarrinho));
      out.write("</p>\n");
      out.write("                      </ul>\n");
      out.write("                      <!--a href=\"index.jsp\"><img id=\"continuar\" src=\"img/btcontinuar.png\"></a-->\n");
      out.write("                      <form action=\"/TchunaiFashion\">\n");
      out.write("                      <input type=\"submit\" class=\"detailContinua\" value=\"Continuar\" name=\"continua\" />\n");
      out.write("                      </form>\n");
      out.write("                      \n");
      out.write("                      <form action=\"/TchunaiFashion/FinalizaCompra\" method=\"post\">\n");
      out.write("                      <input type=\"submit\" class=\"detailFinaliza\" value=\"Finalizar\" name=\"finaliza\" />\n");
      out.write("                      </form>\n");
      out.write("                      ");
}
                      if(listaCarrinho==null){
      out.write("\n");
      out.write("                      <h1>Você não possui itens no carrinho!</h1>\n");
      out.write("                      ");
}else if(listaCarrinho.isEmpty()){
      out.write("\n");
      out.write("                      <h1>Você não possui itens no carrinho!</h1>\n");
      out.write("                      ");
}
      out.write("\n");
      out.write("\t\t</div>    \n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        <footer style=\"margin-top: 130px;\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t  <img src=\"img/logo-rodape.png\" alt=\"Logo Mirror Fashion\" style=\"width:80px; height: 60px;\">\n");
      out.write("\t    <p>&copy; Copyright Tchunai Fashion</p>\n");
      out.write("\t  <ul class=\"social\">\n");
      out.write("\t    <li><a href=\"http://facebook.com/tchunaifashion\">Facebook</a></li>\n");
      out.write("\t    <li><a href=\"http://twitter.com/tchunaifashion\">Twitter</a></li>\n");
      out.write("\t    <li><a href=\"http://plus.google.com/tchunaifashion\">Google+</a></li>\n");
      out.write("            <li><a href=\"http://tchunaifashion.tumblr.com\">Tumblr</a></li>\n");
      out.write("            <li><a href=\"https://instagram.com/tchunaifashion\">Instagram</a></li>\n");
      out.write("            <li><a href=\"https://www.pinterest.com/tchunaifashion\">Pinterest</a></li>\n");
      out.write("\t  </ul>\n");
      out.write("\t</div>\n");
      out.write("     </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
