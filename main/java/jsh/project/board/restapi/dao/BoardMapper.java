package jsh.project.board.restapi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import jsh.project.board.restapi.dto.Article;
import jsh.project.board.restapi.dto.ArticleCreateRequest;
import jsh.project.board.restapi.dto.ArticlePassword;
import jsh.project.board.restapi.dto.ArticleUpdateRequest;

@Mapper
public interface BoardMapper {
	
	public int totalCount();
	
	public List<Article> list(Map<String, Integer> paramMap);
	
	public Article detail(int id);

	public int insert(ArticleCreateRequest dto);

	public int update(ArticleUpdateRequest dto);

	public void delete(int id);

	public int passwordCheck(ArticlePassword dto);
	
}
