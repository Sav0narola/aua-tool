package de.codecentric;

public class BoardDTO {

    public BoardDTO (String title){
        this.title = title;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
