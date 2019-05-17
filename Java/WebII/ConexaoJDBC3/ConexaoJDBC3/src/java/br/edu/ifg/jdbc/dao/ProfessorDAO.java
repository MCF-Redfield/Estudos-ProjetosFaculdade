package br.edu.ifg.jdbc.dao;

import br.edu.ifg.jdbc.dto.Professor;
import br.edu.ifg.jdbc.fabrica.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorDAO {

    Connection connection;

    public ProfessorDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionarefet(Professor professor) {
        String sql = "INSERT INTO professor" + "(idp,nomep,numsiape)" + "VALUES (?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, professor.getId());
                stmt.setString(2, professor.getNome());
                stmt.setInt(3, professor.getnumSiape());
                stmt.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void adicionarsubs(Professor professor) {
        String sql = "INSERT INTO professor" + "(idp,nomep,codcontrato)" + "VALUES (?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, professor.getId());
                stmt.setString(2, professor.getNome());
                stmt.setInt(3, professor.getcodContrato());

                stmt.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerPorNome(Professor nome) {
        String sql = "DELETE FROM professor WHERE nomep like ?";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, nome.getNome());
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterarPorId(Professor professor) {
        String sql = "UPDATE professor SET idp=?, nomep=?, numsiape=?, codcontrato=? where idp=?";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, professor.getId());
                stmt.setString(2, professor.getNome());
                stmt.setInt(3, professor.getnumSiape());
                stmt.setInt(4, professor.getcodContrato());
                stmt.setInt(5, professor.getId());
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Professor> getLista() {
        String sql = "SELECT * FROM professor ";//WHERE idc = 1

        try {
            List<Professor> listaprofessores = new ArrayList<>();
            try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Professor professor = new Professor();
                    professor.setId(rs.getInt("idp"));
                    professor.setNome(rs.getString("nomep"));
                    professor.setnumSiape(rs.getInt("numsiape"));
                    professor.setcodContrato(rs.getInt("codcontrato"));
                    listaprofessores.add(professor);
                }
            }
            return listaprofessores;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Professor> getLista(int id) {
        String sql = "SELECT * FROM professor WHERE idp = " + id;//

        try {
            List<Professor> listaProfessores = new ArrayList<Professor>();
            try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Professor professor = new Professor();
                    professor.setId(rs.getInt("idp"));
                    professor.setNome(rs.getString("nomep"));
                    professor.setnumSiape(rs.getInt("numsiape"));
                    professor.setcodContrato(rs.getInt("codcontrato"));
                    listaProfessores.add(professor);
                }
            }
            return listaProfessores;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Professor buscarPorId(int id) {
        String sql = "SELECT * FROM professor WHERE idp = " + id;
        Professor professor = new Professor();
        professor.setId(55);
        professor.setNome("não funfa");
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                //stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    professor.setId(rs.getInt("idp"));
                    professor.setNome(rs.getString("nomep"));
                    professor.setcodContrato(rs.getInt("codcontrato"));
                    professor.setnumSiape(rs.getInt("numsiape"));
                }
                return professor;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professor;
    }

}
