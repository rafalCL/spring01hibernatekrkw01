package pl.coderslab.spring01hibernatekrkw01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {
    @GetMapping("/form")
    public String personForm(){
        return "personForm";
    }
}
