package com.intalio.victors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

    @GetMapping("/index")
    @ResponseBody
    public String showIndex(Model model) {
        return "index";
    }

}
