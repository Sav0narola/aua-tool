package de.codecentric;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@RestController

public class IndexController {

    @RequestMapping("/")
    public String start() {
        return "hello world";
    }

    @RequestMapping("/boards")
    public List<BoardDTO> getBoards() {
        return asList(new BoardDTO("hello"), new BoardDTO("world"));
    }
}
