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
import model.Desenvolvedora;
import model.Distribuidora;
import persistence.fabrica.ConnectionFactory;

/**
 *
 * @author Matheus Correia
 */
public class DesenvolvedoraDAO {
    
    Connection connection;

    public DesenvolvedoraDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adicionar(Desenvolvedora desenv) {
        String sql = "INSERT INTO desenvolvedora" + "(coddist,nome,sede)" + "VALUES (?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                
                stmt.setInt(1, desenv.getDist().getCod());
                stmt.setString(2, desenv.getNome());
                stmt.setString(3, desenv.getSede());
                
                stmt.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DesenvolvedoraDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public Desenvolvedora buscarPorId(int id) throws ClassNotFoundException {
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
                    desenv.setDist(distDAO.buscarPorId(rs.getInt("coddist")));//coddist
                }
                return desenv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DesenvolvedoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Desenvolvedora> getLista() throws ClassNotFoundException {
        String sql = "SELECT * FROM desenvolvedora";
        DistribuidoraDAO distDAO = new DistribuidoraDAO();
        
        try {
            List<Desenvolvedora> listaDesenvolvedora = new ArrayList<Desenvolvedora>();
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Desenvolvedora desenv = new Desenvolvedora();
                    desenv.setNome(rs.getString("nome"));
                    desenv.setSede(rs.getString("sede"));
                    desenv.setDist(distDAO.buscarPorId(rs.getInt("coddist")));
                    
                    listaDesenvolvedora.add(desenv);
                }
            }
            return listaDesenvolvedora;

        } catch (SQLException e) {
            Logger.getLogger(DesenvolvedoraDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return null;
    }
}
