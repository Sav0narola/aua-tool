package de.codecentric;

import com.fasterxml.jackson.databind.util.JSONPObject;
import de.codecentric.Boards.BoardRequestException;
import de.codecentric.Boards.Boards;
import de.codecentric.Boards.FirebaseController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@RestController

public class IndexController extends FirebaseController{



    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String start() { return "hello world"; }

    /*@RequestMapping("/boards")
    public List<Boards> getBoards() {
        return asList(new Boards("hello"), new Boards("world"));
    }*/


    @RequestMapping(value = "/bb", method = RequestMethod.GET)
    public JSONPObject boardMap (){

        try {
            Map boards = getBoards();
            JSONPObject JO = new JSONPObject("First Statistic", boards);
            return JO;
        } catch (BoardRequestException e) {
            e.printStackTrace();
        }


        return null;
    }
}
