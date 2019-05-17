package br.edu.ifg.jdbc.dao;

import br.edu.ifg.jdbc.fabrica.ConnectionFactory;
import br.edu.ifg.jdbc.dto.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CursoDAO {

    Connection connection;

    public CursoDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Curso curso) {
        String sql = "INSERT INTO curso " + "(idc,nomec) " + "VALUES (?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, curso.getId());
                stmt.setString(2, curso.getNome());

                stmt.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerPorNome(Curso nome) {
        String sql = "DELETE FROM curso WHERE nomec like ?";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, nome.getNome());
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterarPorId(Curso curso) {
        String sql = "UPDATE curso SET idc=?, nomec=? where idc=?";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, curso.getId());
                stmt.setString(2, curso.getNome());
                stmt.setInt(3, curso.getId());
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Curso> getLista() {
        String sql = "SELECT * FROM curso ";//WHERE idc = 1

        try {
            List<Curso> listaCursos = new ArrayList<Curso>();
            try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Curso curso = new Curso();
                    curso.setId(rs.getInt("idc"));
                    curso.setNome(rs.getString("nomec"));
                    listaCursos.add(curso);
                }
            }
            return listaCursos;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Curso> getLista(int id) {
        String sql = "SELECT * FROM curso WHERE idc = " + id;//

        try {
            List<Curso> listaCursos = new ArrayList<Curso>();
            try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Curso curso = new Curso();
                    curso.setId(rs.getInt("idc"));
                    curso.setNome(rs.getString("nomec"));
                    listaCursos.add(curso);
                }
            }
            return listaCursos;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Curso buscarPorId(int id) {
        String sql = "SELECT * FROM curso WHERE idc = " + id;
        Curso curso = new Curso();
        curso.setId(55);
        curso.setNome("não funfa");
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                //stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    curso.setId(rs.getInt("idc"));
                    curso.setNome(rs.getString("nomec"));
                }
                return curso;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
