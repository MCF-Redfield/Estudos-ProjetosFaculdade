package Jogos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class JogosDAO
{
    @PersistenceContext private EntityManager em;
    
    public void adicionar(Jogos dist)
    {
        em.persist(dist);
    }
    
    public List<Jogos> getAllJogos()
    {
        TypedQuery<Jogos> query = em.createQuery("SELECT g FROM Jogos g ORDER BY g.id", Jogos.class);
        return query.getResultList();
    }
    
    public Jogos buscarDist(int idDist)
    {
        //EntityManager entityManager = getEntityManager();
        Jogos dist = null;
        try {
          //Consulta uma pessoa pelo seu ID.
          dist = em.find(Jogos.class, idDist);
        } finally {
          em.close();
        }
        
        return dist;
    }
}
