package pl.coderslab.spring01hibernatekrkw01.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw01.entity.Author;
import pl.coderslab.spring01hibernatekrkw01.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Author e){
        this.em.persist(e);
    }

    public Author findById(long id){
        return this.em.find(Author.class, id);
    }
    public List<Author> findAll() {
        final Query q = this.em.createQuery("SELECT e FROM Author e");
        return q.getResultList();
    }
}
