package de.codecentric;

import de.codecentric.Boards.Boards;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.Arrays.asList;

@RestController

public class IndexController {

    @RequestMapping("/")
    public String start() { return "hello world"; }

    @RequestMapping("/boards")
    public List<Boards> getBoards() {
        return asList(new Boards("hello"), new Boards("world"));
    }
}
