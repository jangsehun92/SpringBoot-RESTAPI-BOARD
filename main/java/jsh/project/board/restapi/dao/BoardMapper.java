package jsh.project.board.restapi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import jsh.project.board.restapi.domain.Article;

@Mapper
public interface BoardMapper {
	
	public int totalCount();
	
	public List<Article> list(Map<String, Integer> paramMap);
	
	public Article detail(int id);
	
	// public int passwordCheck(ArticlePassword articlePassword);
	
	// public int create(ArticleCreateRequest dto);
	
	// public int update(ArticleUpdateRequest dto);
	
	// public int delete(int id);
	
}
