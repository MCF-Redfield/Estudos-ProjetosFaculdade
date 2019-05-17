
package br.edu.ifg.jdbc.teste;

import br.edu.ifg.jdbc.dao.CursoDAO;
import br.edu.ifg.jdbc.dto.Curso;

/**
 *
 * @author gabriel
 */
public class Main {
    
    public static void main(String args[]) throws ClassNotFoundException{
        Curso curso = new Curso();
        curso.setId(1);
        curso.setNome("sad");
        
        CursoDAO dao = new CursoDAO();
        
        dao.adicionar(curso);
    }
}
