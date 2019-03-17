package pl.coderslab.spring01hibernatekrkw01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw01.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw01.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw01.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw01.entity.Author;
import pl.coderslab.spring01hibernatekrkw01.entity.Book;
import pl.coderslab.spring01hibernatekrkw01.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/validation")
public class ValidationController {
    @Autowired
    private Validator validator;

    @GetMapping(value = "/validate/{title}/{rating}/{pages}",
            produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String validationTest(@PathVariable String title,
                                 @PathVariable BigDecimal rating,
                                 @PathVariable int pages) {
        Book b = new Book();
        b.setTitle(title);
        b.setRating(rating);
        b.setPages(pages);

        final Set<ConstraintViolation<Book>> valResult = validator.validate(b);
        String html = "";
        if (valResult.isEmpty()) {
            html = "Validation passed. No errors.";
        } else {
            for (ConstraintViolation<Book> c : valResult) {
                html += "<div>" + c.getPropertyPath() + ": "
                        + c.getMessage() + "</div>";
            }
        }

        return html;
    }

    @GetMapping(value = "/author/{firstName}/{lastName}/{yob}",
            produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String validationTest(@PathVariable String firstName,
                                 @PathVariable String lastName,
                                 @PathVariable int yob) {
        Author a = new Author();
        a.setFirstName(firstName);
        a.setLastName(lastName);
        a.setYearOfBirth(yob);

        final Set<ConstraintViolation<Author>> valResult = validator.validate(a);
        String html = "";
        if (valResult.isEmpty()) {
            html = "Validation passed. No errors.";
        } else {
            for (ConstraintViolation<Author> c : valResult) {
                html += "<div>" + c.getPropertyPath() + ": "
                        + c.getMessage() + "</div>";
            }
        }

        return html;
    }
}