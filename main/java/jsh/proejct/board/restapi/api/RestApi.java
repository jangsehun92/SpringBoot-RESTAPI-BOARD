package jsh.proejct.board.restapi.api;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class RestApi{
    private static final Logger logger = (Logger)LoggerFactory.getLogger(RestApi.class);


    @GetMapping("/test")
    public ResponseEntity<String> test(){
        logger.info("GET /test");
        return new ResponseEntity<String>("test",HttpStatus.OK);
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