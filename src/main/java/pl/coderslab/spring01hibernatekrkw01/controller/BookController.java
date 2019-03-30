package pl.coderslab.spring01hibernatekrkw01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw01.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw01.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw01.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw01.entity.*;
import pl.coderslab.spring01hibernatekrkw01.repository.BookRepository;
import pl.coderslab.spring01hibernatekrkw01.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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

    @GetMapping("/addForm")
    public String addForm(Model m){
        m.addAttribute("book", new Book());
        return "book/addForm";
    }

    @PostMapping("/addForm")
    public String addFormPost(@Valid Book book, BindingResult br){
        if(br.hasErrors()){
            return "book/addForm";
        }
        this.bookDao.save(book);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model m){
        m.addAttribute("book", bookDao.findById(id));
        return "book/addForm";
    }

    @PostMapping("/edit/{id}")
    public String editBookPost(@ModelAttribute Book book){
        this.bookDao.save(book);
        return "redirect:../list";
    }

    @GetMapping("/list")
    public String bookList(){
        return "book/list";
    }

    @GetMapping("/delbyid/{id}")
    public String delById(@PathVariable Long id)
    {
        Book b = bookRepository.findOne(id);
        bookRepository.deleteInRelation(b);
        return "book/list";
    }

    @GetMapping("/delbyid2/{id}")
    public String delById2(@PathVariable Long id)
    {
        Book b = bookRepository.findOne(id);
        b.setCategory(null);
        b.setPublisher(null);
        b.getAuthors().clear();
        bookRepository.delete(b);
        return "book/list";
    }

    @GetMapping(value = "/testrepository", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testRepository(){
        final long count = bookRepository.count();
        final List<Book> allBooks = bookRepository.findAll();
        String html = "<div>Liczba osób w bazie: "+count+"</div>";
        for(Book p : allBooks){
            html += "<div>"+p.toString()+"</div>";
        }

        html+="<div>By title</div>";
        final List<Book> booksByTitle = bookRepository.findAllByTitle("zzzeee");
        for(Book p : booksByTitle){
            html += "<div>"+p.toString()+"</div>";
        }


        html+="<div>By category</div>";
        Category cat = this.categoryRepository.findOne(1L);
        final List<Book> booksByCategory = bookRepository.findAllByCategory(cat);
        for(Book p : booksByCategory){
            html += "<div>"+p.toString()+"</div>";
        }

        html+="<div>By category id</div>";
        final List<Book> booksByCategoryId = bookRepository.findAllByCategoryId(1L);
        for(Book p : booksByCategoryId){
            html += "<div>"+p.toString()+"</div>";
        }

        return html;
    }



    @ModelAttribute("publishers")
    private List<Publisher> publishers(){
        return this.publisherDao.findAll();
    }

    @ModelAttribute("books")
    private List<Book> books(){
        return this.bookDao.findAll();
    }

    @ModelAttribute("authors")
    private List<Author> authors(){
        return this.authorDao.findAll();
    }
}
