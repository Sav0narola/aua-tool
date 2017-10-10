package de.codecentric.Boards;


import java.util.Map;

public interface Controller {

    Map<String, Board> getBoards() throws BoardRequestException;
}
