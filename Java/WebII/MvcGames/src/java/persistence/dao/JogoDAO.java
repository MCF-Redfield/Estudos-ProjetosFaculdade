/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Jogo;
import persistence.fabrica.ConnectionFactory;

/**
 *
 * @author Matheus Correia
 */
public class JogoDAO {
    
    Connection connection;

    public JogoDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adicionar(Jogo jogo) {
        String sql = "INSERT INTO jogo" + "(coddesenv,nome,plataforma,genero,status)" + "VALUES (?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                
                stmt.setInt(1, jogo.getDesenv().getCod());
                stmt.setString(2, jogo.getNome());
                stmt.setString(3, jogo.getPlataforma());
                stmt.setString(4, jogo.getGenero());
                stmt.setString(5, jogo.getStatus());
                
                stmt.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    /*
    public Jogo buscarPorId(int id) throws ClassNotFoundException {
        String sql = "SELECT * FROM desenvolvedora WHERE cod = " + id;
        Desenvolvedora desenv = new Desenvolvedora();
        DistribuidoraDAO distDAO = new DistribuidoraDAO();
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                //stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    desenv.setCod(rs.getInt("cod"));
                    desenv.setNome(rs.getString("nome"));
                    desenv.setSede(rs.getString("sede"));
                    desenv.setDist(distDAO.buscarPorId(rs.getInt("coddist")));
                }
                return desenv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DistribuidoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    */
    public List<Jogo> getLista() throws ClassNotFoundException {
        String sql = "SELECT * FROM jogo";
        DesenvolvedoraDAO desenvDAO = new DesenvolvedoraDAO();
        
        try {
            List<Jogo> listaJogo = new ArrayList<Jogo>();
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Jogo jogo = new Jogo();
                    jogo.setNome(rs.getString("nome"));
                    jogo.setPlataforma(rs.getString("plataforma"));
                    jogo.setDesenv(desenvDAO.buscarPorId(rs.getInt("coddesenv")));
                    jogo.setStatus(rs.getString("status"));
                    jogo.setGenero(rs.getString("genero"));
                    
                    listaJogo.add(jogo);
                }
            }
            return listaJogo;

        } catch (SQLException e) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return null;
    }
}
