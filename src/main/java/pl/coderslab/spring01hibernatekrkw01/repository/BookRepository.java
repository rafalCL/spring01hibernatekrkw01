package pl.coderslab.spring01hibernatekrkw01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.spring01hibernatekrkw01.entity.Book;
import pl.coderslab.spring01hibernatekrkw01.entity.Category;

import java.util.List;

public interface BookRepository
                extends JpaRepository<Book, Long> {
    List<Book> findAllByTitle(String title);
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByCategoryId(Long categoryId);
    List<Book> findAllByCategoryName(String categoryName);

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> someFancyMethodReturningBooksByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.category=:category")
    List<Book> myOwnMethodReturningBooksByCategory(
                                   @Param("category") Category cat);
}
