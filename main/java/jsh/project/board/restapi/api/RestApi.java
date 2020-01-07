package jsh.project.board.restapi.api;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import jsh.project.board.restapi.dto.Article;
import jsh.project.board.restapi.dto.ArticleCreateRequest;
import jsh.project.board.restapi.dto.ArticlePassword;
import jsh.project.board.restapi.dto.ArticleUpdateRequest;
import jsh.project.board.restapi.service.BoardService;


@RestController
public class RestApi{
    private static final Logger logger = (Logger)LoggerFactory.getLogger(RestApi.class);

    private BoardService boardService;

    public RestApi(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> detail(@PathVariable("id")int id){
        logger.info("GET /article/"+id);
        return new ResponseEntity<Article>(boardService.detail(id),HttpStatus.OK);
    }

    @GetMapping("/articles")
    public ResponseEntity<Map<String,Object>> list(@RequestParam(required = false, defaultValue="1")int page){
        logger.info("GET /articles/"+page);
        return new ResponseEntity<Map<String,Object>>(boardService.list(page), HttpStatus.OK);
    }

    @PostMapping("/articles")
    public ResponseEntity<HttpStatus> articleCreate(@RequestBody ArticleCreateRequest dto) {
        logger.info("POST /articles");
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
    
    @PostMapping(value="/article/password")
    public ResponseEntity<HttpStatus> postMethodName(@RequestBody ArticlePassword dto) {
        boardService.articlePasswordCheck(dto);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    



    
}