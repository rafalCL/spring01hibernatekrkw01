package pl.coderslab.spring01hibernatekrkw01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw01.dao.PersonDao;
import pl.coderslab.spring01hibernatekrkw01.entity.Person;
import pl.coderslab.spring01hibernatekrkw01.repository.PersonRepository;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/form")
    public String personForm(){
        return "personForm";
    }

    @PostMapping("/form")
    @ResponseBody
    public String personFormPost(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String email
            ){
        Person p = new Person(login,password,email);
        this.personDao.save(p);

        return "Saved: " + p.toString();
    }

    @GetMapping("/formbinded")
    public String personFormBinded(Model m){
        m.addAttribute("person", new Person("somelogin", null, null));
        return "personFormBinded";
    }

    @PostMapping("/formbinded")
    @ResponseBody
    public String personFormBindedPost(@ModelAttribute Person person){
        this.personDao.save(person);

        return "Zapisano: "+person.toString();
    }

    @GetMapping(value = "/testrepository", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testRepository(){
        final long count = personRepository.count();
        final List<Person> allPersons = personRepository.findAll();
        String html = "<div>Liczba osób w bazie: "+count+"</div>";
        for(Person p : allPersons){
            html += "<div>"+p.toString()+"</div>";
        }

        return html;
    }
}
