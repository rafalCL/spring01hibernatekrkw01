package pl.coderslab.spring01hibernatekrkw01.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw01.entity.Book;
import pl.coderslab.spring01hibernatekrkw01.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Publisher e){
        this.em.persist(e);
    }

    public Publisher findById(long id){
        return this.em.find(Publisher.class, id);
    }

    public List<Publisher> findAll() {
        final Query q = this.em.createQuery("SELECT e FROM Publisher e");
        return q.getResultList();
    }
}
