package de.codecentric;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class IndexController {
    @RequestMapping("/")
    public String start(@RequestParam(value = "name", required = false, defaultValue = "you cute User") String name, Model model) {
        model.addAttribute("name", name);
        return "start";
    }

}


