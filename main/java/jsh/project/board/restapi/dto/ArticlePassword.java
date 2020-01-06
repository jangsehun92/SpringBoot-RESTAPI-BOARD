package jsh.project.board.restapi.dto;

public class ArticlePassword{
    private int id;
    private String password;

    public ArticlePassword(){

    }

    public ArticlePassword(int id, String password){
        this.id = id;
        this.password = password;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }


}