package jsh.project.board.restapi.domain;

import java.util.Date;

public class Article{
    private int id;
    private String title;
    private String content;
    private Date date;

    public Article(){

    }

    public Article(int id, String title, String content, Date date){
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    //getter&setter
}