package jsh.project.board.restapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jsh.project.board.restapi.domain.Article;

@Mapper
public interface BoardMapper {
	
	public int totalCount();
	
	public List<Article> list();
	
	public Article detail(int id);

	public void delete(int id);
	
}
