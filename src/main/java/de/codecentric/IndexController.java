package de.codecentric;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController

public class IndexController {
    @RequestMapping("/")
    public String start() {
        return "hello world";
    }
}


