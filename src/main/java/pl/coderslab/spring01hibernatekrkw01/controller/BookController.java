package pl.coderslab.spring01hibernatekrkw01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrkw01.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw01.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw01.entity.Author;
import pl.coderslab.spring01hibernatekrkw01.entity.Book;
import pl.coderslab.spring01hibernatekrkw01.entity.Publisher;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private PublisherDao publisherDao;

    @GetMapping("/saveHobbit")
    @ResponseBody
    public String saveHobbit(){
        Book b = new Book();
        b.setTitle("Hobbit");
//        b.setAuthor("Tolkien");
        b.getAuthors().add(new Author("JRR", "Tolkien"));
        this.bookDao.save(b);

        return "Zapisano Hobbita id=" + b.getId();
    }

    @GetMapping("/insertpwn/{title}/{author}")
    @ResponseBody
    public String savePWN(@PathVariable String title,
                          @PathVariable String author){
        Book b = new Book(title);
        b.getAuthors().add(new Author("firstName", author));
        Publisher p = this.publisherDao.findById(1L);
        b.setPublisher(p);
        this.bookDao.save(b);

        return "Zapisano: " + b.toString();
    }

    @GetMapping("/insert/{newPublisher}/{title}/{author}")
    @ResponseBody
    public String saveNewPublisher(
            @PathVariable String newPublisher,
            @PathVariable String title,
                          @PathVariable String author){
        Publisher p = new Publisher(newPublisher);
        Book b = new Book(title);
        b.getAuthors().add(new Author("firstName", author));
        b.setPublisher(p);
        this.bookDao.save(b);

        return "Zapisano: " + b.toString();
    }

    @GetMapping("/savebwa/{title}/{authorFirstName}/{authorLastName}")
    @ResponseBody
    public String saveBookWithAuthor(
            @PathVariable String title,
            @PathVariable String authorFirstName,
            @PathVariable String authorLastName
    ){
        Book b = new Book(title);
        Author a = new Author(authorFirstName,authorLastName);
        b.getAuthors().add(a);
        this.bookDao.save(b);

        return b.toString();
    }
}
