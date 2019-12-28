package jsh.project.board.restapi.api;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import jsh.project.board.restapi.service.BoardService;

@RestController
public class RestApi{
    private static final Logger logger = (Logger)LoggerFactory.getLogger(RestApi.class);

    private BoardService boardServie;

    public RestApi(BoardService boardService){
        this.boardServie = boardService;
    }

    @GetMapping("/test")
    public ResponseEntity<Integer> test(){
        logger.info("GET /test");
        System.out.println(boardServie.totalCount());
        return new ResponseEntity<Integer>(boardServie.totalCount(),HttpStatus.OK);
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<String> detail(@PathVariable("id")int id){
        logger.info("GET /article/"+id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping("/articles")
    public ResponseEntity<String> list(){
        logger.info("GET /articles");
        return new ResponseEntity<>(HttpStatus.OK);
        
    }



    
}