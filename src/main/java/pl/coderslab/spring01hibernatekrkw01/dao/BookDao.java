package pl.coderslab.spring01hibernatekrkw01.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw01.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Book e){
        this.em.merge(e);
    }

    public Book findById(long id){
        return this.em.find(Book.class, id);
    }

    public List<Book> findAll() {
        final Query q = this.em.createQuery("SELECT e FROM Book e");
        return q.getResultList();
    }
}
