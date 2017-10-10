package de.codecentric.Boards;

import com.fasterxml.jackson.databind.util.JSONPObject;
import de.codecentric.Boards.Board;
import de.codecentric.Boards.BoardRequestException;
import de.codecentric.Boards.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class IndexController {

    @Autowired FirebaseService firebaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String start() { return "hello world"; }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public JSONPObject jsonResponseDemo (){

        try {
            Map<String, Board> boards = firebaseService.getBoards();
            JSONPObject JsonDemo = new JSONPObject("First Statistic", boards);

            return JsonDemo;
        } catch (BoardRequestException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/boardsPerMonth", method = RequestMethod.GET, produces = "application/json")
    public String getBoardsPerMonth(){
        // TODO ->  FirebaseController (Service) get String to Boards Map
        //          MonthToBoardsMapper -> read BoardsMap and map to Months to Amount of Boards and return value

        return "";
    }
}
