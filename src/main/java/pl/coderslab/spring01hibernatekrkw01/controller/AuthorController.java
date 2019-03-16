package pl.coderslab.spring01hibernatekrkw01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrkw01.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw01.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw01.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw01.entity.Author;
import pl.coderslab.spring01hibernatekrkw01.entity.Book;
import pl.coderslab.spring01hibernatekrkw01.entity.Publisher;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorDao authorDao;

    @GetMapping("/saveawb/{title}/{authorFirstName}/{authorLastName}")
    @ResponseBody
    public String saveBookWithAuthor(
            @PathVariable String title,
            @PathVariable String authorFirstName,
            @PathVariable String authorLastName
    ){
        Book b = new Book(title);
        Author a = new Author(authorFirstName,authorLastName);
        a.getBooks().add(b);
        this.authorDao.save(a);

        return a.toString();
    }
}
