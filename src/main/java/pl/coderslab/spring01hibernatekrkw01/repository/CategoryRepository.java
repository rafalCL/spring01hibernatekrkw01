package pl.coderslab.spring01hibernatekrkw01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrkw01.entity.Category;
import pl.coderslab.spring01hibernatekrkw01.entity.Person;

public interface CategoryRepository
        extends JpaRepository<Category, Long> {
}
