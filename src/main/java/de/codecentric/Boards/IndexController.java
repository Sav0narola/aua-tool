package de.codecentric.Boards;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController

public class IndexController {

    @Autowired FirebaseService firebaseService;
    @Autowired GraphMapper graphMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String start() { return "hello world"; }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public JSONPObject jsonResponseDemo (){

        try {
            Map<String, Board> boards = firebaseService.getBoards();
            JSONPObject JsonDemo = new JSONPObject("The JSON.fetch from the Firebase-DB", boards);

            return JsonDemo;
        } catch (BoardRequestException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/boardsPerMonth", method = RequestMethod.GET, produces = "application/json")
    public Object getBoardsPerMonth(){

        try {
            Map<String, Integer> resultMap = graphMapper.mapMonthsToBoardAmount(firebaseService.getBoards());

            return new JSONPObject("", resultMap).getValue();
        } catch (BoardRequestException e) {
            e.printStackTrace();
        }
        return null;
    }
}
