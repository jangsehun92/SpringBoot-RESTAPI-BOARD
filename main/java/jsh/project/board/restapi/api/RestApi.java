package jsh.project.board.restapi.api;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import jsh.project.board.restapi.domain.Article;
import jsh.project.board.restapi.service.BoardService;

@RestController
public class RestApi{
    private static final Logger logger = (Logger)LoggerFactory.getLogger(RestApi.class);

    private BoardService boardService;

    public RestApi(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/test")
    public ResponseEntity<Integer> test(){
        logger.info("GET /test");
        System.out.println(boardService.totalCount());
        return new ResponseEntity<Integer>(boardService.totalCount(),HttpStatus.OK);
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> detail(@PathVariable("id")int id){
        logger.info("GET /article/"+id);
        return new ResponseEntity<Article>(boardService.detail(id),HttpStatus.OK);
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> list(){
        logger.info("GET /articles");
        return new ResponseEntity<List<Article>>(boardService.list(), HttpStatus.OK);
        
    }



    
}