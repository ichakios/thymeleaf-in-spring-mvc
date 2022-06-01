package com.intalio.victors;

import com.intalio.victors.domain.LoginRequest;
import com.intalio.victors.service.exercise.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


@Controller
public class HomeController {

    private final StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/index")
    @ResponseBody
    public String showIndex() {
        return "index.html";
    }

    @RequestMapping("/login")
    public String login(LoginRequest loginRequest, Model model) {

        if(!ObjectUtils.isEmpty(loginRequest.getUsername())
            && !ObjectUtils.isEmpty(loginRequest.getPassword())){

                if( "student1".equals(loginRequest.getUsername())
                && "pass1".equals(loginRequest.getPassword())) {

                    model.addAttribute("students",studentService.findAll());
                    return "Students.html";
                }
                if( "student2".equals(loginRequest.getUsername())
                        && "pass2".equals(loginRequest.getPassword())) {
                    model.addAttribute("students",studentService.findAll());
                    return "Students.html";
                }
                model.addAttribute("errorMessage","invalid username and password");
        }
        return "index.html";
    }
}
