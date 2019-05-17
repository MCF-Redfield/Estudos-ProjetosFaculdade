package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.tchunaifashion.services.UpdateTotal;
import br.com.tchunaifashion.persistence.dao.ProdutoDAO;
import br.com.tchunaifashion.model.Produto;
import java.util.List;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>     \n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("        <title>Tchunai Fashion</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"tchunai_css/reset.css\">\t\t\n");
      out.write("        <link rel=\"stylesheet\" href=\"tchunai_css/logincss.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"tchunai_css/mobile.css\" media=\"(max-width: 939px)\">\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    ");

                    HttpSession sessionRecebeListaCarrinho = request.getSession();
                    List<Produto> listaCarrinho = (List<Produto>) sessionRecebeListaCarrinho.getAttribute("listaCarrinho");
                    int i=0;
                    UpdateTotal ut = new UpdateTotal();
    
      out.write("\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <header class=\"container\">\n");
      out.write("\n");
      out.write("            <h1><a href=\"index.jsp\"><img class=\"logo\" src=\"img/logo.png\" alt=\"Tchunai Fashion\"></a></h1>\n");
      out.write("\n");
      out.write("            <div class=\"sacola\" class=\"container\" >\n");
      out.write("                <div style=\"font-weight:bold; font-family: Oxygen; font-size:12px; margin-left: 50px; margin-top: 1px;\">\n");
      out.write("                    <a id=\"login\">Login</a><br>\n");
      out.write("                            ");
if(listaCarrinho==null){
      out.write("\n");
      out.write("                                <a id=\"qtd-sacola\" href=\"carrinho.jsp\" title=\"Minha Compra\">0 Produtos</a>\n");
      out.write("                                <a rel=\"noindex nofollow\" id=\"val-sacola\" href=\"carrinho.jsp\" title=\"Minha Compra\"><br>R$ 0.00</a>\n");
      out.write("\t\t\t\t");
}else{
      out.write("<a id=\"qtd-sacola\" href=\"carrinho.jsp\" title=\"Minha Compra\">");
      out.print(listaCarrinho.size());
      out.write(" Produtos</a>\n");
      out.write("                                          <a rel=\"noindex nofollow\" id=\"val-sacola\" href=\"carrinho.jsp\" title=\"Minha Compra\"><br>R$ ");
      out.print(ut.preco(listaCarrinho));
      out.write("</a> \n");
      out.write("                                ");
}
      out.write("            \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <nav class=\"menu-setores\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"index.jsp\">Início</a></li>\n");
      out.write("                    <li><a href=\"#\">Lista de Desejos</a></li>\n");
      out.write("                    <li><a href=\"#\">Cartão Fidelidade</a></li>\n");
      out.write("                    <li><a href=\"sobre.html\">Sobre</a></li>\n");
      out.write("                    <li><a href=\"#\">Ajuda</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("        <div class=\"container destaque\">\n");
      out.write("            <section class=\"busca\">\n");
      out.write("                <h2>Busca</h2>\n");
      out.write("\n");
      out.write("                <form action=\"http://www.google.com.br/search\" id=\"form-busca\">\n");
      out.write("                    <input type=\"search\" name=\"q\" id=\"q\">\n");
      out.write("                    <input type=\"image\" src=\"img/busca.png\">\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </section><!-- fim .busca -->\n");
      out.write("\n");
      out.write("            <section class=\"menu-departamentos\">\n");
      out.write("                <h2>Departamentos</h2>\n");
      out.write("                <nav>\n");
      out.write("                    <ul>\n");
      out.write("                        <li>\n");
      out.write("                            <a class=\"teste\" href=\"../TchunaiFashion/CamisaeCamisetaServlet\">Camisas e Camisetas</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"../TchunaiFashion/CamisaServlet\">Camisas</a></li>\n");
      out.write("                                <li><a href=\"../TchunaiFashion/CamisetaServlet\">Camisetas</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a class=\"teste\" href=\"../TchunaiFashion/SaiaeVestidoServlet\">Saias e Vestidos</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"../TchunaiFashion/SaiaServlet\">Saias</a></li>\n");
      out.write("                                <li><a href=\"../TchunaiFashion/VestidoServlet\">Vestidos</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"../TchunaiFashion/CalcaServlet\">Calças</a></li>\n");
      out.write("                        <li><a href=\"../TchunaiFashion/BermudaServlet\">Bermudas</a></li>\n");
      out.write("                        <li><a href=\"../TchunaiFashion/BlazerServlet\">Blazers</a></li>\t\t  \n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("            <div class=\"loginheader\">\n");
      out.write("                <h1> Identificação</h1>\n");
      out.write("                <br><br>\n");
      out.write("\n");
      out.write("                <form action=\"LoginServlet\" method=\"POST\">\n");
      out.write("                    <div class=\"login\">\n");
      out.write("                        <legend class=\"title\">já tenho cadastro</legend>\n");
      out.write("                        <span>e-mail:</span> <input type=\"text\" name=\"email\" autofocus><br><br>\n");
      out.write("                        <span>Senha :</span> <input type=\"text\" name=\"senha\"><br><br>\n");
      out.write("                        <input class=\"bts\" id=\"btnEntrar\" value=\"Entrar\"  type=\"submit\"><br><br>\n");
      out.write("                        ");

                            if (request.getAttribute("validationmessage") == null) {
                        
      out.write("\n");
      out.write("                        <span style=\"display: none;\" class=\"failer\">");
      out.print( request.getAttribute("validationmessage"));
      out.write("</span>\n");
      out.write("                        ");

                        } else {
                        
      out.write("\n");
      out.write("                        <span class=\"failer\">");
      out.print( request.getAttribute("validationmessage"));
      out.write("</span>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                <form action=\"cadastro.jsp\"> \n");
      out.write("                    <div class=\"cadastro\">\n");
      out.write("                        <legend class=\"title\">não tenho cadastro</legend>\n");
      out.write("                        <input class=\"bts\" id=\"btnCadastro\" value=\"Cadastrar\"  type=\"submit\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                <!--  <form>\n");
      out.write("                  <div id=\"cadastro\">\n");
      out.write("                  Email:<br> <input type=\"text\"><br>\n");
      out.write("                  Senha:<br> <input type=\"text\"><br>\n");
      out.write("                  <input id=\"btProsseguir\" value=\"Entrar\"  type=\"submit\">\n");
      out.write("                  </div>\n");
      out.write("                      </form> -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <footer>\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <img src=\"img/logo-rodape.png\" alt=\"Logo Mirror Fashion\" style=\"width:80px; height: 60px;\">\n");
      out.write("                    <p>&copy; Copyright Tchunai Fashion</p>\n");
      out.write("                    <ul class=\"social\">\n");
      out.write("                        <li><a href=\"http://facebook.com/tchunaifashion\">Facebook</a></li>\n");
      out.write("                        <li><a href=\"http://twitter.com/tchunaifashion\">Twitter</a></li>\n");
      out.write("                        <li><a href=\"http://plus.google.com/tchunaifashion\">Google+</a></li>\n");
      out.write("                        <li><a href=\"http://tchunaifashion.tumblr.com\">Tumblr</a></li>\n");
      out.write("                        <li><a href=\"https://instagram.com/tchunaifashion\">Instagram</a></li>\n");
      out.write("                        <li><a href=\"https://www.pinterest.com/tchunaifashion\">Pinterest</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
