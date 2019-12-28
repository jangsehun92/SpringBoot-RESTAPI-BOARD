package jsh.project.board.restapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jsh.project.board.restapi.dao.BoardMapper;
import jsh.project.board.restapi.domain.Article;

@Service
public class BoardService {
    
    @Autowired
	private BoardMapper boardMapper;
	
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	public int totalCount() {
		return boardMapper.totalCount();
	}
	
	// public Map<String, Object> articleList(int page){
	// 	Map<String, Object> resultMap = new HashMap<>();
	// 	Pagination pagination = new Pagination(totalCount(), page);
	// 	resultMap.put("pagination",pagination); 
	// 	resultMap.put("articleList",boardDao.list(pagination.scope()));
	// 	return resultMap;
	// }
	
	// public Article articleDetail(int id) {
	// 	return boardDao.detail(id);
	// }
	
	// public void articleCreate(ArticleCreateRequest ) {
	// 	boardDao.create();
	// }
	
	// public boolean articlePasswordCheck(ArticlePassword articlePassword) {
	// 	return boardDao.passwordCheck(articlePassword)!=0?true:false;
	// }
	
	// public void articleUpdate(int id, ArticleUpdateRequest ) {
	// 	.setId(id);
	// 	boardDao.update();
	// }
	
	// public void articleDelete(int id) {
	// 	boardDao.delete(id);
	// }
	
}
