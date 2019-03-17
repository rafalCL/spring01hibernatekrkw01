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
import pl.coderslab.spring01hibernatekrkw01.entity.CmsArticle;
import pl.coderslab.spring01hibernatekrkw01.entity.Publisher;
import pl.coderslab.spring01hibernatekrkw01.validator.Draft;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
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

    @GetMapping(value = "/group/default",
            produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String groupValidationDefault() {
        CmsArticle cmsArticle = new CmsArticle("title", null, null);

        final Set<ConstraintViolation<CmsArticle>> valResult = validator.validate(cmsArticle);
        String html = "";
        if (valResult.isEmpty()) {
            html = "Validation passed. No errors.";
        } else {
            for (ConstraintViolation<CmsArticle> c : valResult) {
                html += "<div>" + c.getPropertyPath() + ": "
                        + c.getMessage() + "</div>";
            }
        }

        return html;
    }

    @GetMapping(value = "/group/draft",
            produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String groupValidationDraft() {
        CmsArticle cmsArticle = new CmsArticle("title", null, null);

        final Set<ConstraintViolation<CmsArticle>> valResult = validator.validate(cmsArticle, Draft.class);
        String html = "";
        if (valResult.isEmpty()) {
            html = "Validation passed. No errors.";
        } else {
            for (ConstraintViolation<CmsArticle> c : valResult) {
                html += "<div>" + c.getPropertyPath() + ": "
                        + c.getMessage() + "</div>";
            }
        }

        return html;
    }

    @GetMapping(value = "/group/emptydefault",
            produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String groupValidationDefaultEmpty() {
        CmsArticle cmsArticle = new CmsArticle(null, null, null);

        final Set<ConstraintViolation<CmsArticle>> valResult = validator.validate(cmsArticle);
        String html = "";
        if (valResult.isEmpty()) {
            html = "Validation passed. No errors.";
        } else {
            for (ConstraintViolation<CmsArticle> c : valResult) {
                html += "<div>" + c.getPropertyPath() + ": "
                        + c.getMessage() + "</div>";
            }
        }

        return html;
    }

    @GetMapping(value = "/group/emptydraft",
            produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String groupValidationDraftEmpty() {
        CmsArticle cmsArticle = new CmsArticle(null, null, null);

        final Set<ConstraintViolation<CmsArticle>> valResult = validator.validate(cmsArticle, Draft.class);
        String html = "";
        if (valResult.isEmpty()) {
            html = "Validation passed. No errors.";
        } else {
            for (ConstraintViolation<CmsArticle> c : valResult) {
                html += "<div>" + c.getPropertyPath() + ": "
                        + c.getMessage() + "</div>";
            }
        }

        return html;
    }

    @GetMapping(value = "/group/both",
            produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String groupValidationBoth() {
        CmsArticle cmsArticle = new CmsArticle(null, null, null);

        final Set<ConstraintViolation<CmsArticle>> valResult = validator.validate(cmsArticle, Default.class, Draft.class);
        String html = "";
        if (valResult.isEmpty()) {
            html = "Validation passed. No errors.";
        } else {
            for (ConstraintViolation<CmsArticle> c : valResult) {
                html += "<div>" + c.getPropertyPath() + ": "
                        + c.getMessage() + "</div>";
            }
        }

        return html;
    }
}