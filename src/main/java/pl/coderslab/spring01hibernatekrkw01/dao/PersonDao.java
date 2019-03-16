package pl.coderslab.spring01hibernatekrkw01.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw01.entity.Author;
import pl.coderslab.spring01hibernatekrkw01.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Person e){
        this.em.persist(e);
    }

    public Person findById(long id){
        return this.em.find(Person.class, id);
    }
}
