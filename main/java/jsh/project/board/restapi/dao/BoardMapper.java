package jsh.project.board.restapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jsh.project.board.restapi.dto.Article;
import jsh.project.board.restapi.dto.ArticleCreateRequest;
import jsh.project.board.restapi.dto.ArticleUpdateRequest;

@Mapper
public interface BoardMapper {
	
	public int totalCount();
	
	public List<Article> list();
	
	public Article detail(int id);

	public int insert(ArticleCreateRequest dto);

	public int update(ArticleUpdateRequest dto);

	public void delete(int id);
	
}
