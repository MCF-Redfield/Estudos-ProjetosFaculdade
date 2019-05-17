package Jogos;
 
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name="JogosServlet", urlPatterns={"/jogo"})
public class JogosServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;
 
    // Injected DAO EJB:
    @EJB JogosDAO jogoDAO;
 
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
         // Display the list of guests:
        request.setAttribute("jogo", jogoDAO.getAllJogos());
        request.getRequestDispatcher("/JogosView.jsp").forward(request, response);
    }
 
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
         // Handle a new guest:
        String nome = request.getParameter("nome");
        String genero = request.getParameter("genero");
        String plataforma = request.getParameter("plataforma");
        String status = request.getParameter("status");
        String dist = request.getParameter("dist");
        String desenv = request.getParameter("desenv");
        
        Jogos jogo = new Jogos();
        jogo.setNome(nome);
        jogo.setGenero(genero);
        jogo.setDesenv(desenv);
        jogo.setPlataforma(plataforma);
        jogo.setStatus(status);
        jogo.setDist(dist);
        
        jogoDAO.adicionar(jogo);
 
        // Display the list of guests:
        doGet(request, response);
    }
}