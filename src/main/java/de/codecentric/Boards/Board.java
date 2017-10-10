package de.codecentric.Boards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {

    private String id;
    private long creationDate;
    private String title;

    public Board(){

    }

    public Board(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (creationDate != board.creationDate) return false;
        if (id != null ? !id.equals(board.id) : board.id != null) return false;
        return title != null ? title.equals(board.title) : board.title == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (int) (creationDate ^ (creationDate >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", creationDate=" + creationDate +
                ", title='" + title + '\'' +
                '}';
    }
}
