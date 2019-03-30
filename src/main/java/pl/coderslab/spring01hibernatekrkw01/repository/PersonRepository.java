package pl.coderslab.spring01hibernatekrkw01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrkw01.entity.Person;

public interface PersonRepository
        extends JpaRepository<Person, Long> {
}
