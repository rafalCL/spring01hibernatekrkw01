package pl.coderslab.spring01hibernatekrkw01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw01.bean.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/form")
    public String studentForm(Model m)
    {
        m.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping(value = "/form", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String studentFormPost(@ModelAttribute Student student)
    {
        return student.toString();
    }
}
