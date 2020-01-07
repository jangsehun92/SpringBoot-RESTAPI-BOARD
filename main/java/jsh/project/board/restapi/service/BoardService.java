package jsh.project.board.restapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jsh.project.board.restapi.dao.BoardMapper;
import jsh.project.board.restapi.dto.Article;
import jsh.project.board.restapi.dto.ArticleCreateRequest;
import jsh.project.board.restapi.dto.ArticlePassword;
import jsh.project.board.restapi.dto.ArticleUpdateRequest;
import jsh.project.util.Pagination;

@Service
public class BoardService {
    
    @Autowired
	private BoardMapper boardMapper;
	
	public int totalCount() {
		return boardMapper.totalCount();
	}
	
	public Map<String, Object> list(int page){
		Map<String, Object> resultMap = new HashMap<>();
		Pagination pagination = new Pagination(totalCount(), page);
		resultMap.put("pagination",pagination); 
		resultMap.put("articleList",boardMapper.list(pagination.scope()));
		return resultMap;
	}
	
	public Article detail(int id) {
		return boardMapper.detail(id);
	}
	
	public void articleCreate(ArticleCreateRequest dto) {
		boardMapper.insert(dto);
	}
	
	public void articleUpdate(int id, ArticleUpdateRequest dto) {
		dto.setId(id);
		boardMapper.update(dto);
	}
	
	public void articleDelete(int id) {
		boardMapper.delete(id);
	}

	public void articlePasswordCheck(ArticlePassword dto){
		boardMapper.passwordCheck(dto);
	}
	
}
