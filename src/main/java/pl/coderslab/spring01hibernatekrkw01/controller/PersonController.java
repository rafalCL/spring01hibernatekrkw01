package pl.coderslab.spring01hibernatekrkw01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw01.dao.PersonDao;
import pl.coderslab.spring01hibernatekrkw01.entity.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;

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
}
