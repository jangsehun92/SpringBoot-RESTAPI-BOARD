package jsh.project.board.restapi.api;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import jsh.project.board.restapi.domain.Article;
import jsh.project.board.restapi.dto.ArticleCreateRequest;
import jsh.project.board.restapi.dto.ArticleUpdateRequest;
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

    @PostMapping(value="/article")
    public ResponseEntity<HttpStatus> articleCreate(@RequestBody ArticleCreateRequest dto) {
        logger.info("POST /article");
        boardService.articleCreate(dto);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @PatchMapping("/article/{id}")
    public ResponseEntity<HttpStatus> articleUpdate(@PathVariable("id")int id,@RequestBody ArticleUpdateRequest dto){
        boardService.articleUpdate(id, dto);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @DeleteMapping("/article/{id}")
    public ResponseEntity<HttpStatus> articleDelete(@PathVariable("id")int id){
        boardService.articleDelete(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    



    
}