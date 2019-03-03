package pl.coderslab.spring01hibernatekrkw01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrkw01.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw01.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw01.entity.Book;
import pl.coderslab.spring01hibernatekrkw01.entity.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherDao publisherDao;

    @GetMapping("/insert/{name}")
    @ResponseBody
    public String insert(@PathVariable String name){
        Publisher p = new Publisher(name);
        this.publisherDao.save(p);

        return "Zapisano: " + p.toString();
    }
}
