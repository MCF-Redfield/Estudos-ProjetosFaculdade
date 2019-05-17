package br.edu.ifg.jdbc.dao;

//import br.edu.ifg.jdbc.dto.Curso;
import br.edu.ifg.jdbc.dto.Curso;
import br.edu.ifg.jdbc.dto.Disciplina;
import br.edu.ifg.jdbc.fabrica.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisciplinaDAO {

    Connection connection;

    public DisciplinaDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Disciplina disc) {
        String sql = "INSERT INTO disciplina" + "(idd,nomed,cursod)" + "VALUES (?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, disc.getId());
                stmt.setString(2, disc.getNome());
                stmt.setInt(3, disc.getCurso().getId());

                stmt.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerPorNome(Disciplina disc) {
        String sql = "DELETE FROM disciplina WHERE nomed like ?";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, disc.getNome());
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterarPorId(Disciplina disc) {
        String sql = "UPDATE disciplina SET idd=?, nomed=? , cursod=? where idd=" + disc.getId();

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, disc.getId());
                stmt.setString(2, disc.getNome());
                stmt.setInt(3, disc.getCurso().getId());
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Disciplina> getLista() throws ClassNotFoundException {
        String sql = "SELECT * FROM disciplina ";//WHERE idc = 1
        CursoDAO cursoDAO = new CursoDAO();

        try {
            List<Disciplina> listaDisc = new ArrayList<Disciplina>();
            try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Disciplina disc = new Disciplina();
                    disc.setId(rs.getInt("idd"));
                    disc.setNome(rs.getString("nomed"));
                    disc.setCurso(cursoDAO.buscarPorId(rs.getInt("cursod")));
                    listaDisc.add(disc);
                }
            }
            return listaDisc;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /*
     public List<Disciplina> getLista(int id) {
     String sql = "SELECT * FROM disciplina WHERE idd = " + id;//

     try {
     List<Disciplina> listaDisc = new ArrayList<Disciplina>();
     try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

     while (rs.next()) {
     Disciplina disc = new Disciplina();
     disc.setId(rs.getInt("idd"));
     disc.setNome(rs.getString("nomed"));
     disc.setCurso(rs.getInt("cursod"));
     listaDisc.add(disc);
     }
     }
     return listaDisc;
     } catch (SQLException ex) {
     Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return null;
     }
     */

    public Disciplina buscarPorId(int id) throws ClassNotFoundException {
        String sql = "SELECT * FROM disciplina WHERE idd = " + id;
        CursoDAO cursoDAO = new CursoDAO();
        Disciplina disc = new Disciplina();
        disc.setId(55);
        disc.setNome("naoFunfa");
        disc.setCurso(null);

        try
        {
            try (PreparedStatement stmt = connection.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();
                while (rs.next())
                {
                    disc.setId(rs.getInt("idd"));
                    disc.setNome(rs.getString("nomed"));
                    disc.setCurso(cursoDAO.buscarPorId(rs.getInt("cursod")));
                }
                if(disc.getNome().equals("naoFunfa"))
                {
                    disc.setNome("DanadoNaoEncontrado");
                    disc.setId(1);
                    disc.setCurso(cursoDAO.buscarPorId(rs.getInt(1)));
                }
                return disc;
            }
        } catch (SQLException ex)
          {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        return disc;
    }

    
}
