package jsh.project.board.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jsh.project.board.restapi.dao.BoardMapper;
import jsh.project.board.restapi.domain.Article;
import jsh.project.board.restapi.dto.ArticleCreateRequest;
import jsh.project.board.restapi.dto.ArticleUpdateRequest;

@Service
public class BoardService {
    
    @Autowired
	private BoardMapper boardMapper;
	
	public int totalCount() {
		return boardMapper.totalCount();
	}
	
	public List<Article> list(){
		return boardMapper.list();
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
	
}
