package pl.coderslab.spring01hibernatekrkw01.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw01.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Book e){
        this.em.persist(e);
    }

    public Book findById(long id){
        return this.em.find(Book.class, id);
    }
}
