package pl.coderslab.spring01hibernatekrkw01.repository;

import pl.coderslab.spring01hibernatekrkw01.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class BookRepositoryImpl implements DeleteInRelation {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void deleteInRelation(Book book) {
        book.setPublisher(null);
        book.setCategory(null);
        book.setAuthors(null);
        this.em.merge(book);
        this.em.flush();
        this.em.clear();

        this.em.remove(
                this.em.contains(book) ? book
                              : this.em.merge(book));
    }
}
